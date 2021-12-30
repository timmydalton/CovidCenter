package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.NhanKhauController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DanhSachView extends JFrame {
	private JTable table1;
	private JTable table2;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DanhSachView() throws ClassNotFoundException, SQLException {
		super("Covid Center");
		this.setSize(800, 700);
        getContentPane().setLayout(null);
        
        JLabel lblTitle1 = new JLabel("\u0110\u00E3 khai b\u00E1o y t\u1EBF:");
        lblTitle1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle1.setBounds(10, 10, 194, 30);
        getContentPane().add(lblTitle1);
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(10, 50, 766, 124);
        getContentPane().add(scrollPane1);
        
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        
        JLabel lblTitle2 = new JLabel("\u0110\u00E3 khai b\u00E1o y t\u1EBF:");
        lblTitle2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle2.setBounds(10, 184, 194, 30);
        getContentPane().add(lblTitle2);
        
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(10, 224, 766, 124);
        getContentPane().add(scrollPane2);
        
        table2 = new JTable();
        scrollPane2.setViewportView(table2);
        
        JLabel lblTitle3 = new JLabel("Chi ti\u1EBFt:");
        lblTitle3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle3.setBounds(10, 358, 194, 30);
        getContentPane().add(lblTitle3);
        
        JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setBounds(10, 398, 766, 213);
        getContentPane().add(scrollPane3);
        
        JTextPane txtpnTTin = new JTextPane();
        txtpnTTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnTTin.setEnabled(true);
        txtpnTTin.setEditable(false);
        txtpnTTin.setText("Th\u00F4ng tin chi ti\u1EBFt...");
        scrollPane3.setViewportView(txtpnTTin);
        
        JButton btnBack = new JButton("Quay l\u1EA1i");
        btnBack.setOpaque(false);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setFocusable(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(true);
        btnBack.setBounds(656, 621, 120, 33);
        getContentPane().add(btnBack);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\Art2.png")));
        lblBackGround.setBounds(0, -100, 800, 800);
        getContentPane().add(lblBackGround);
        
        //
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        ((DefaultTableModel)(table1.getModel())).setDataVector(NhanKhauController.getByKhaiBao("1"), NhanKhauController.getHeader());
        ((DefaultTableModel)(table2.getModel())).setDataVector(NhanKhauController.getByKhaiBao("0"), NhanKhauController.getHeader());
        
        //Event
        btnBack.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		DanhSachView.this.dispose();
        	}
        });
        
        table1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table1.getSelectedRow();
        		try {
					txtpnTTin.setText(NhanKhauController.showThongTin(NhanKhauController.getByKhaiBao("1"), selectedRow));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		txtpnTTin.setCaretPosition(0);
        	}
        });
        
        table2.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table2.getSelectedRow();
        		try {
					txtpnTTin.setText(NhanKhauController.showThongTin(NhanKhauController.getByKhaiBao("0"), selectedRow));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		txtpnTTin.setCaretPosition(0);
        	}
        });
	}

}
