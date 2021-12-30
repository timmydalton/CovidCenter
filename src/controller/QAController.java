package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class QAController {
	public static void guiCauHoi(String question, String UserHoi) throws ClassNotFoundException, SQLException {
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Insert into QA (CauHoi, UserHoi) VALUES (\'" + question + "\', \'"+ UserHoi +"\')");
    	stmt.executeUpdate(query);
	}
	
	public static void guiTraLoi(String answer, String UserTL, String IDCauHoi) throws ClassNotFoundException, SQLException {
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Update QA SET TraLoi = \'"+ answer +"\', UserTL = \'"+ UserTL +"\' where IDCauHoi = \'"+ IDCauHoi +"\'");
    	stmt.executeUpdate(query);
	}
	
	public static Vector<String> getHeader(){
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("Cau Hoi");
		header.add("Tra Loi");
		header.add("User Hoi");
		header.add("User Tra Loi");
		
		return header;
	}
	
	public static Vector<Vector<String>> getCauHoi() throws ClassNotFoundException, SQLException{
		Vector<Vector<String>> data = new Vector<>();
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Select * from QA");
    	ResultSet rs = stmt.executeQuery(query);
    	while(rs.next()) {
    		Vector<String> temp = new Vector<String>();
    		temp.add(String.valueOf(rs.getInt(1)));
    		temp.add(rs.getString(2));
    		temp.add(rs.getString(3));
    		temp.add(rs.getString(4));
    		temp.add(rs.getString(5));
    		data.add(temp);
    	}
    	return data;
	}
	
	public static String showQA(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "Mã câu hỏi: " + selectedRow.get(0)
				+ "\nNgười hỏi: " + selectedRow.get(3)
				+ "\nCâu hỏi:\n" + selectedRow.get(1)
				+ "\nNgười trả lời: " + selectedRow.get(4)
				+ "\nCâu trả lời: \n" + selectedRow.get(2);
		return result;
	}
	
	public static String showQ(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "Câu hỏi:\n" + selectedRow.get(1);
		return result;
	}
	public static String showA(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "" + selectedRow.get(2);
		return result;
	}
	
	public static String getSelectedQID(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "" + selectedRow.get(0);
		return result;
	}
}
