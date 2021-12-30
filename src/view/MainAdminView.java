package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThongKeController;
import model.ThongKeModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class MainAdminView extends JFrame {

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainAdminView() throws ClassNotFoundException, SQLException {
		super("Covid Center");
		this.setSize(800, 500);
        getContentPane().setLayout(null);
        
        JLabel lblFF = new JLabel("");
        lblFF.setBackground(Color.GREEN);
        lblFF.setOpaque(true);
        lblFF.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        lblFF.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblFF.setBounds(58, 163, 301, 108);
        getContentPane().add(lblFF);
        
        JLabel lblF = new JLabel("");
        lblF.setOpaque(true);
        lblF.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        lblF.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblF.setBackground(Color.PINK);
        lblF.setBounds(427, 163, 301, 108);
        getContentPane().add(lblF);
        
        JLabel lblF_2 = new JLabel("");
        lblF_2.setOpaque(true);
        lblF_2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        lblF_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblF_2.setBackground(Color.ORANGE);
        lblF_2.setBounds(58, 310, 301, 108);
        getContentPane().add(lblF_2);
        
        JLabel lblF_3 = new JLabel("");
        lblF_3.setOpaque(true);
        lblF_3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        lblF_3.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblF_3.setBackground(Color.LIGHT_GRAY);
        lblF_3.setBounds(427, 310, 301, 108);
        getContentPane().add(lblF_3);
        
        JButton btnTTin = new JButton("Th\u00F4ng tin phi\u1EBFu", null);
        btnTTin.setOpaque(false);
        btnTTin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTTin.setFocusable(false);
        btnTTin.setContentAreaFilled(false);
        btnTTin.setBorderPainted(true);
        btnTTin.setBounds(58, 33, 167, 40);
        getContentPane().add(btnTTin);
        
        JButton btnDsach = new JButton("Danh s\u00E1ch", null);
        btnDsach.setOpaque(false);
        btnDsach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDsach.setFocusable(false);
        btnDsach.setContentAreaFilled(false);
        btnDsach.setBorderPainted(true);
        btnDsach.setBounds(58, 83, 167, 40);
        getContentPane().add(btnDsach);
        
        JButton btnLogOut = new JButton("\u0110\u0103ng xu\u1EA5t", null);
        btnLogOut.setOpaque(false);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogOut.setFocusable(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setBorderPainted(true);
        btnLogOut.setBounds(561, 83, 167, 40);
        getContentPane().add(btnLogOut);
        
        JButton btnQA = new JButton("Tr\u1EA3 l\u1EDDi c\u00E2u h\u1ECFi", null);
        btnQA.setOpaque(false);
        btnQA.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnQA.setFocusable(false);
        btnQA.setContentAreaFilled(false);
        btnQA.setBorderPainted(true);
        btnQA.setBounds(561, 33, 167, 40);
        getContentPane().add(btnQA);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, -100, 800, 600);
        getContentPane().add(lblBackGround);
        
        ThongKeModel thongKe = ThongKeController.getThongKe();
        lblFF.setText("     Kho\u1EBB m\u1EA1nh: " + thongKe.KM);
        lblF.setText("     F0: " + thongKe.F0);
        lblF_2.setText("     F1: " + thongKe.F1);
        lblF_3.setText("     F2: " + thongKe.F2);
        
        //
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);              
        
        //Event
        btnLogOut.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		MainAdminView.this.dispose();
        		new LoginView();
        	}
        });
        
        btnQA.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		try {
					new QAAdminView();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnTTin.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		try {
					new PhieuAdminView();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnDsach.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		try {
					new DanhSachView();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
	}

}
