package view;

import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.NhanKhauController;
import model.NhanKhauModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePassView extends JFrame {
	private JTextField textField;
	public ChangePassView() throws ClassNotFoundException, SQLException, IOException {
		super("Covid Center");
        this.setSize(313, 234);
        getContentPane().setLayout(null);
        
        JLabel lblNameL = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u cho:");
        lblNameL.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNameL.setBounds(10, 10, 140, 30);
        getContentPane().add(lblNameL);
        
        JLabel lblName = new JLabel("____");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(10, 40, 140, 30);
        getContentPane().add(lblName);
        NhanKhauModel nhanKhau = NhanKhauController.GetThongTinByID();
        lblName.setText(nhanKhau.HoTen);
        
        JLabel lblPass = new JLabel("Nh\u1EADp m\u1EADt kh\u1EA9u m\u1EDBi:");
        lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPass.setBounds(10, 69, 163, 30);
        getContentPane().add(lblPass);
        
        textField = new JTextField();
        textField.setBounds(10, 109, 279, 33);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnConfirm = new JButton("X\u00E1c nh\u1EADn");
        btnConfirm.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					controller.AccountController.changePass(nhanKhau.ID, textField.getText());
					JOptionPane.showMessageDialog(ChangePassView.this, "Changed password to: " + textField.getText());
					ChangePassView.this.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnConfirm.setFocusable(false);
        btnConfirm.setContentAreaFilled(false);
        btnConfirm.setBounds(10, 152, 106, 33);
        getContentPane().add(btnConfirm);
        
        JButton btnCancel = new JButton("Hu\u1EF7 b\u1ECF");
        btnCancel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ChangePassView.this.dispose();
        	}
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCancel.setFocusable(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setBounds(183, 152, 106, 33);
        getContentPane().add(btnCancel);
        
        //
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, -100, 800, 600);
        getContentPane().add(lblBackGround);
        
        //
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
	}
}
