package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.PhieuYTeModel;

public class PhieuYTeController {
	public static void guiPhieu(PhieuYTeModel phieu) throws ClassNotFoundException, SQLException{
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("INSERT INTO tokhaiyte(ID, Sot, Ho, KhoTho, ViemPhoi, DauHong, MetMoi,"
    			+ " TrangThaiCachLy, KetQuaXetNghiem, Phone, RegisterDate) "
    			+ "VALUES (\'"+ phieu.ID +"\',\'"+ phieu.Sot +"\',\'"+ phieu.Ho +"\',\'"+ phieu.KhoTho +"\',\'"+ phieu.ViemPhoi +"\',\'"+ phieu.DauHong +"\'"
    					+ ",\'"+ phieu.MetMoi +"\',\'"+ phieu.CachLy +"\',\'"+ phieu.XetNghiem +"\',\'"+ phieu.SoDienThoai +"\',CURRENT_DATE())");
    	stmt.executeUpdate(query);
    	stmt.executeUpdate("Update nhankhau set KhaiBao = \'1\' WHERE ID = \'"+ phieu.ID +"\'");
	}
	
	public static Vector<String> getHeader(){
		Vector<String> header = new Vector<String>();
		header.add("ID Phieu");
		header.add("Sot");
		header.add("Ho");
		header.add("KT");
		header.add("VP");
		header.add("DH");
		header.add("MM");
		header.add("Cach ly");
		header.add("Xet Nghiem");
		header.add("Phone");
		header.add("Date");
		return header;
	}
	
	public static Vector<String> getHeaderAdmin(){
		Vector<String> header = new Vector<String>();
		header.add("ID Phieu");
		header.add("User");
		header.add("Sot");
		header.add("Ho");
		header.add("KT");
		header.add("VP");
		header.add("DH");
		header.add("MM");
		header.add("Cach ly");
		header.add("Xet Nghiem");
		header.add("Phone");
		header.add("Date");
		return header;
	}
	
	public static Vector<Vector<String>> layThongTinPhieuByID(String ID) throws ClassNotFoundException, SQLException {
		Vector<Vector<String>> data = new Vector<>();
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Select * from tokhaiyte where ID = \'"+ ID +"\'");
    	ResultSet rs = stmt.executeQuery(query);
    	while(rs.next()) {
    		String IDPhieu = String.valueOf(rs.getInt(1));
    		String Sot = rs.getString(3);
    		String Ho = rs.getString(4);
    		String KhoTho = rs.getString(5);
    		String ViemPhoi = rs.getString(6);
    		String DauHong = rs.getString(7);
    		String MetMoi = rs.getString(8);
    		String TrangThai = rs.getString(9);
    		String Kq = rs.getString(10);
    		String Phone = rs.getString(11);
    		String Date = rs.getString(12);
    		
    		Vector<String> temp = new Vector<>();
    		
    		temp.add(IDPhieu);
    		temp.add(Sot);
    		temp.add(Ho);
    		temp.add(KhoTho);
    		temp.add(ViemPhoi);
    		temp.add(DauHong);
    		temp.add(MetMoi);
    		temp.add(TrangThai);
    		temp.add(Kq);
    		temp.add(Phone);
    		temp.add(Date);
    		
    		data.add(temp);
    	}
    	return data;
	}
	
	public static Vector<Vector<String>> layThongTinPhieu() throws ClassNotFoundException, SQLException {
		Vector<Vector<String>> data = new Vector<>();
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Select * from tokhaiyte");
    	ResultSet rs = stmt.executeQuery(query);
    	while(rs.next()) {
    		String IDPhieu = String.valueOf(rs.getInt(1));
    		String User = rs.getString(2);
    		String Sot = rs.getString(3);
    		String Ho = rs.getString(4);
    		String KhoTho = rs.getString(5);
    		String ViemPhoi = rs.getString(6);
    		String DauHong = rs.getString(7);
    		String MetMoi = rs.getString(8);
    		String TrangThai = rs.getString(9);
    		String Kq = rs.getString(10);
    		String Phone = rs.getString(11);
    		String Date = rs.getString(12);
    		
    		Vector<String> temp = new Vector<>();
    		
    		temp.add(IDPhieu);
    		temp.add(User);
    		temp.add(Sot);
    		temp.add(Ho);
    		temp.add(KhoTho);
    		temp.add(ViemPhoi);
    		temp.add(DauHong);
    		temp.add(MetMoi);
    		temp.add(TrangThai);
    		temp.add(Kq);
    		temp.add(Phone);
    		temp.add(Date);
    		
    		data.add(temp);
    	}
    	return data;
	}
	
	public static String showIDPhieu(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "" + selectedRow.get(0);
		return result;
	}
	
	public static String showPhieu(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "ID Tờ khai: " + selectedRow.get(0);
		result += "\nSố cmt: " + selectedRow.get(1);
		result += "\nTriệu chứng:";
		if (selectedRow.get(2).equals("1")) result += "\n>Sốt";
		if (selectedRow.get(3).equals("1")) result += "\n>Ho";
		if (selectedRow.get(4).equals("1")) result += "\n>Khó thở";
		if (selectedRow.get(5).equals("1")) result += "\n>Viêm phổi";
		if (selectedRow.get(6).equals("1")) result += "\n>Đau họng";
		if (selectedRow.get(7).equals("1")) result += "\n>Mệt mỏi";
		result += "\nTrạng thái cách ly: " + selectedRow.get(8);
		result += "\nKết quả xét nghiệm: " + selectedRow.get(9);
		result += "\nThông tin liên lạc: " + selectedRow.get(10);
		result += "\nNgày khai báo: " + selectedRow.get(11);
		return result;
	}
	
	public static String showPhieuCitizen(Vector<Vector<String>> data, int index) {
		Vector selectedRow = data.get(index);
		String result;
		result = "ID Tờ khai: " + selectedRow.get(0);
		result += "\nTriệu chứng:";
		if (selectedRow.get(1).equals("1")) result += "\n>Sốt";
		if (selectedRow.get(2).equals("1")) result += "\n>Ho";
		if (selectedRow.get(3).equals("1")) result += "\n>Khó thở";
		if (selectedRow.get(4).equals("1")) result += "\n>Viêm phổi";
		if (selectedRow.get(5).equals("1")) result += "\n>Đau họng";
		if (selectedRow.get(6).equals("1")) result += "\n>Mệt mỏi";
		result += "\nTrạng thái cách ly: " + selectedRow.get(7);
		result += "\nKết quả xét nghiệm: " + selectedRow.get(8);
		result += "\nThông tin liên lạc: " + selectedRow.get(9);
		result += "\nNgày khai báo: " + selectedRow.get(10);
		return result;
	}
	
	public static void xoaPhieu(String ID) throws ClassNotFoundException, SQLException {
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	stmt.executeUpdate("DELETE FROM tokhaiyte where IDToKhai = \'"+ ID +"\'");
	}
}
