package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.NhanKhauModel;

public class NhanKhauController {
	
	public static NhanKhauModel GetThongTinByID() throws ClassNotFoundException, SQLException, IOException {
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	BufferedReader buff = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\temp.txt"));
    	String ID = buff.readLine();
    	buff.close();
    	ResultSet rs = stmt.executeQuery("Select * from NhanKhau where ID = \'" + ID + "\'");
    	NhanKhauModel nhanKhau = new NhanKhauModel();
    	while(rs.next()) {
    		nhanKhau.ID = rs.getString(1);
        	nhanKhau.IDHoKhau = rs.getString(2);
        	nhanKhau.IDNhanKhau = rs.getString(3);
        	nhanKhau.HoTen = rs.getString(4);
        	nhanKhau.NgaySinh = rs.getString(5);
        	nhanKhau.GioiTinh = rs.getString(6);
        	nhanKhau.QuocTich = rs.getString(7);
        	nhanKhau.DiaChi = rs.getString(8);
        	nhanKhau.NgheNghiep = rs.getString(9);
        	nhanKhau.NoiLamViec = rs.getString(10);
        	nhanKhau.SoDienThoai = rs.getString(11);
    	}
    	return nhanKhau;
	}
	
	public static Vector<String> getHeader(){
		Vector<String> header = new Vector<String>();
		header.add("CMT");
		header.add("Hộ Khẩu");
		header.add("ID");
		header.add("Họ tên");
		header.add("Ngày sinh");
		header.add("Giới tính");
		header.add("Quốc tịch");
		header.add("Địa chỉ");
		header.add("Nghề nghiệp");
		header.add("Nơi làm việc");
		header.add("Phone");
		
		return header;
	}
	
	public static Vector<Vector<String>> getByKhaiBao(String kb) throws SQLException, ClassNotFoundException{
		Vector<Vector<String>> data = new Vector<>();
		Connection connection = AccountController.getMysqlConnection();
    	Statement stmt = connection.createStatement();
    	String query = ("Select * from nhankhau where KhaiBao = \'"+ kb +"\'");
    	ResultSet rs = stmt.executeQuery(query);
    	while(rs.next()) {
    		Vector<String> temp = new Vector<String>();
    		temp.add(rs.getString(1));
    		temp.add(rs.getString(2));
    		temp.add(rs.getString(3));
    		temp.add(rs.getString(4));
    		temp.add(rs.getString(5));
    		temp.add(rs.getString(6));
    		temp.add(rs.getString(7));
    		temp.add(rs.getString(8));
    		temp.add(rs.getString(9));
    		temp.add(rs.getString(10));
    		temp.add(rs.getString(11));
    		temp.add(rs.getString(12));
    		data.add(temp);
    	}
    	return data;
	}
	
	public static String showThongTin(Vector<Vector<String>> data, int index) {
		Vector<String> selectedRow = data.get(index);
		String result;
		result = "Số chứng minh nhân dân: " + selectedRow.get(0);
		result += "\nSố hộ khẩu: " + selectedRow.get(1);
		result += "\nSố nhân khẩu: " + selectedRow.get(2);
		result += "\nHọ và tên: " + selectedRow.get(3);
		result += "\nNgày sinh: " + selectedRow.get(4);
		result += "\nGiới tính: " + selectedRow.get(5);
		result += "\nQuốc tịch: " + selectedRow.get(6);
		result += "\nĐịa chỉ: " + selectedRow.get(7);
		result += "\nNghề nghiệp: " + selectedRow.get(8);
		result += "\nNơi công tác: " + selectedRow.get(9);
		result += "\nLiên lạc: " + selectedRow.get(10);
		result += "\nTình trạng khai báo: ";
		if (selectedRow.get(11).equals("1")) result += "Đã khai báo";
		else result += "Chưa khai báo";
		return result;
	}
}
