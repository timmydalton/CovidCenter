package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.NhanKhauController;
import controller.QAController;
import model.NhanKhauModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class QAView extends JFrame {


	/**
	 * Create the frame.
	 */
	public QAView() {
		super("Question");
        this.setSize(480, 360);
        getContentPane().setLayout(null);
        
        JLabel lblQA = new JLabel("\u0110\u1EB7t c\u00E2u h\u1ECFi");
        lblQA.setHorizontalAlignment(SwingConstants.CENTER);
        lblQA.setForeground(Color.WHITE);
        lblQA.setFont(new Font("Corbel", Font.BOLD, 40));
        lblQA.setBounds(94, 10, 269, 50);
        getContentPane().add(lblQA);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 62, 446, 205);
        getContentPane().add(scrollPane);
        
        JTextPane txtpnQA = new JTextPane();
        txtpnQA.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnQA.setText("\u0110\u1EB7t c\u00E2u h\u1ECFi...");
        scrollPane.setViewportView(txtpnQA);
        
        JButton btnNewButton = new JButton("G\u1EEDi c\u00E2u h\u1ECFi");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setFocusable(false);
        btnNewButton.setBounds(10, 277, 123, 30);
        getContentPane().add(btnNewButton);
        
        JButton btnHuB = new JButton("Hu\u1EF7 b\u1ECF");
        btnHuB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnHuB.setFocusable(false);
        btnHuB.setBounds(158, 277, 123, 30);
        getContentPane().add(btnHuB);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, 0, 600, 600);
        getContentPane().add(lblBackGround);
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        //Event
        txtpnQA.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtpnQA.setText("");
        	}
        });
        
        btnHuB.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		QAView.this.dispose();
        	}
        });
        
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String question = txtpnQA.getText();
        		try {
					NhanKhauModel nhanKhau = NhanKhauController.GetThongTinByID();
					QAController.guiCauHoi(question, nhanKhau.ID);
					JOptionPane.showMessageDialog(QAView.this, "Đã gửi câu hỏi");
					QAView.this.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
	}
}
