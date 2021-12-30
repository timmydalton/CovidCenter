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

import controller.PhieuYTeController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class PhieuAdminView extends JFrame {
	private JTable table;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public PhieuAdminView() throws ClassNotFoundException, SQLException {
		super("Covid Center");
		this.setSize(800, 500);
        getContentPane().setLayout(null);
        
        JLabel lblTitle = new JLabel("Danh s\u00E1ch phi\u1EBFu khai b\u00E1o y t\u1EBF:");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(10, 10, 280, 40);
        getContentPane().add(lblTitle);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 48, 766, 131);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 189, 766, 221);
        getContentPane().add(scrollPane_1);
        
        JTextPane txtpnThngTinPhiu = new JTextPane();
        txtpnThngTinPhiu.setText("Th\u00F4ng tin phi\u1EBFu...");
        txtpnThngTinPhiu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        scrollPane_1.setViewportView(txtpnThngTinPhiu);
        
        JButton btnUpdate = new JButton("Refresh");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnUpdate.setFocusable(false);
        btnUpdate.setOpaque(false);
        btnUpdate.setBorderPainted(true);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setBounds(10, 420, 120, 33);
        getContentPane().add(btnUpdate);
        
        JButton btnDel = new JButton("Xo\u00E1 phi\u1EBFu");
        btnDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDel.setFocusable(false);
        btnDel.setOpaque(false);
        btnDel.setBorderPainted(true);
        btnDel.setContentAreaFilled(false);
        btnDel.setBounds(140, 420, 120, 33);
        getContentPane().add(btnDel);
        
        JButton btnBack = new JButton("Quay l\u1EA1i");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setFocusable(false);
        btnBack.setOpaque(false);
        btnBack.setBorderPainted(true);
        btnBack.setContentAreaFilled(false);
        btnBack.setBounds(270, 420, 120, 33);
        getContentPane().add(btnBack);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, -100, 800, 600);
        getContentPane().add(lblBackGround);
        
        //
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        ((DefaultTableModel)(table.getModel())).setDataVector(PhieuYTeController.layThongTinPhieu(), PhieuYTeController.getHeaderAdmin());
        
        //Event
        
        btnBack.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		PhieuAdminView.this.dispose();
        	}
        });
        
        btnUpdate.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		try {
					((DefaultTableModel)(table.getModel())).setDataVector(PhieuYTeController.layThongTinPhieu(), PhieuYTeController.getHeaderAdmin());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnDel.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table.getSelectedRow();
        		try {
					PhieuYTeController.xoaPhieu(PhieuYTeController.showIDPhieu(PhieuYTeController.layThongTinPhieu(), selectedRow));
					((DefaultTableModel)(table.getModel())).setDataVector(PhieuYTeController.layThongTinPhieu(), PhieuYTeController.getHeaderAdmin());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        			txtpnThngTinPhiu.setText("Deleted...");
        	}
        });
        
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table.getSelectedRow();
        		try {
					txtpnThngTinPhiu.setText(PhieuYTeController.showPhieu(PhieuYTeController.layThongTinPhieu(), selectedRow));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		txtpnThngTinPhiu.setCaretPosition(0);
        	}
        });
	}

}
