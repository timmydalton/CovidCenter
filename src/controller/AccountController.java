package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class AccountController {
	
	public String tempID;
	
	public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "CovidCenter";
        String userName = "root";
        String password = "";
        return getMysqlConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password) 
        throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String connectionUrl = "jdbc:mysql://localhost:3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
        return conn;
    }
    
  //Ham kiem tra tai khoan
    public static int getUser(String Username, String Pass) throws ClassNotFoundException, SQLException, IOException{
    	Connection connection = getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	ResultSet rs = stmt.executeQuery("Select * from Users where Username like \'" + Username + "\'");
    	while(rs.next()) {
    		String tmp = rs.getString(3);
    		if (tmp.equals(Pass)) {
    			BufferedWriter buff = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+ "\\temp.txt"));
    			buff.write(rs.getString(1));
    	        buff.flush();
    	        buff.close();
    			int role = rs.getInt(4);
    			return role;
    		}
    	}
    	return 0;
    }
    
    //Ham doi pass
    public static void changePass(String ID, String Pass) throws ClassNotFoundException, SQLException {
    	Connection connection = getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	stmt.executeUpdate("Update users set Password = \'"+ Pass +"\' WHERE ID = \'"+ ID +"\'");
    }
}
