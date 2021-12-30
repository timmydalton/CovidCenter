package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ThongKeModel;

public class ThongKeController {
	public static ThongKeModel getThongKe() throws SQLException, ClassNotFoundException {
		ThongKeModel thongKe = new ThongKeModel();
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Select * from thongkeyte");
    	ResultSet rs = stmt.executeQuery(query);
    	rs.next();
        thongKe.F0 = rs.getString(1);
        thongKe.F1 = rs.getString(2);
        thongKe.F2 = rs.getString(3);
        thongKe.KM = rs.getString(4);
    	return thongKe;
	}
}
