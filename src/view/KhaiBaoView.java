package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.NhanKhauController;
import model.NhanKhauModel;

public class KhaiBaoView extends JFrame {
	private JTextField textFieldPhone;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public KhaiBaoView() throws ClassNotFoundException, SQLException, IOException {
        super("Covid Center");
        this.setSize(540, 680);
        getContentPane().setLayout(null);
		
        //Tao label cho textfield
        JLabel lblKhaiBao = new JLabel("Khai b\u00E1o y t\u1EBF");
        lblKhaiBao.setHorizontalAlignment(SwingConstants.CENTER);
        lblKhaiBao.setFont(new Font("Corbel", Font.BOLD, 40));
        lblKhaiBao.setBounds(129, 45, 269, 50);
        lblKhaiBao.setForeground(Color.WHITE);
        getContentPane().add(lblKhaiBao);
        
        JLabel lblID = new JLabel("CMND:");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblID.setBounds(30, 149, 49, 30);
        getContentPane().add(lblID);
        
        JLabel lblName = new JLabel("H\u1ECD t\u00EAn:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(30, 197, 58, 30);
        getContentPane().add(lblName);
        
        JLabel lblGender = new JLabel("Gi\u1EDBi t\u00EDnh:");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender.setBounds(30, 241, 75, 30);
        getContentPane().add(lblGender);
        
        JLabel lblDate = new JLabel("Ng\u00E0y sinh:");
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDate.setBounds(229, 241, 75, 30);
        getContentPane().add(lblDate);
        
        JLabel lblName1 = new JLabel("N/a");
        lblName1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName1.setBounds(98, 197, 373, 30);
        getContentPane().add(lblName1);
        
        JLabel lblGender1 = new JLabel("N/a");
        lblGender1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender1.setBounds(98, 241, 121, 30);
        getContentPane().add(lblGender1);
        
        JLabel lblDate1 = new JLabel("N/a");
        lblDate1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDate1.setBounds(314, 241, 121, 30);
        getContentPane().add(lblDate1);
        
        JLabel lblSymtomp = new JLabel("Tri\u00EAu ch\u1EE9ng xu\u1EA5t hi\u1EC7n trong 14 ng\u00E0y qua:");
        lblSymtomp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSymtomp.setBounds(30, 281, 313, 30);
        getContentPane().add(lblSymtomp);
        
        JCheckBox chckbxSot = new JCheckBox("S\u1ED1t");
        chckbxSot.setOpaque(false);
        chckbxSot.setFocusable(false);
        chckbxSot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxSot.setBounds(30, 317, 100, 30);
        getContentPane().add(chckbxSot);
        
        JCheckBox chckbxHo = new JCheckBox("Ho");
        chckbxHo.setOpaque(false);
        chckbxHo.setFocusable(false);
        chckbxHo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxHo.setBounds(132, 317, 100, 30);
        getContentPane().add(chckbxHo);
        
        JCheckBox chckbxKhoTho = new JCheckBox("Kh\u00F3 th\u1EDF");
        chckbxKhoTho.setOpaque(false);
        chckbxKhoTho.setFocusable(false);
        chckbxKhoTho.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxKhoTho.setBounds(234, 317, 100, 30);
        getContentPane().add(chckbxKhoTho);
        
        JCheckBox chckbxViemPhoi = new JCheckBox("Vi\u00EAm ph\u1ED5i");
        chckbxViemPhoi.setOpaque(false);
        chckbxViemPhoi.setFocusable(false);
        chckbxViemPhoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxViemPhoi.setBounds(336, 317, 100, 30);
        getContentPane().add(chckbxViemPhoi);
        
        JCheckBox chckbxDauHong = new JCheckBox("\u0110au h\u1ECDng");
        chckbxDauHong.setOpaque(false);
        chckbxDauHong.setFocusable(false);
        chckbxDauHong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxDauHong.setBounds(30, 349, 100, 30);
        getContentPane().add(chckbxDauHong);
        
        JCheckBox chckbxMetMoi = new JCheckBox("M\u1EC7t m\u1ECFi");
        chckbxMetMoi.setOpaque(false);
        chckbxMetMoi.setFocusable(false);
        chckbxMetMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chckbxMetMoi.setBounds(132, 349, 100, 30);
        getContentPane().add(chckbxMetMoi);
        
        JLabel lblStatus = new JLabel("Tr\u1EA1ng th\u00E1i c\u00E1ch ly:");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblStatus.setBounds(30, 385, 174, 30);
        getContentPane().add(lblStatus);
        
        String combo[] = {"Không", "F0", "F1", "F2"};
        JComboBox comboBoxStatus = new JComboBox(combo);
        comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxStatus.setBounds(30, 425, 131, 30);
        getContentPane().add(comboBoxStatus);
        comboBoxStatus.setFocusable(false);
        
        JLabel lblKtQuXt = new JLabel("K\u1EBFt qu\u1EA3 x\u00E9t nghi\u1EC7m:");
        lblKtQuXt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblKtQuXt.setBounds(229, 385, 174, 30);
        getContentPane().add(lblKtQuXt);
        
        String test[] = {"Âm tính", "Dương tính"};
        JComboBox comboBoxTest = new JComboBox(test);
        comboBoxTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxTest.setFocusable(false);
        comboBoxTest.setBounds(229, 425, 131, 30);
        getContentPane().add(comboBoxTest);
        
        JButton btnConfirm = new JButton("X\u00E1c nh\u1EADn");
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnConfirm.setFocusable(false);
        btnConfirm.setBounds(215, 570, 100, 30);
        getContentPane().add(btnConfirm);
        
        JLabel lblPhone = new JLabel("Số điện thoại:");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPhone.setBounds(30, 489, 113, 30);
        getContentPane().add(lblPhone);
        
        textFieldPhone = new JTextField();
        textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFieldPhone.setColumns(10);
        textFieldPhone.setBounds(142, 489, 329, 30);
        getContentPane().add(textFieldPhone);
        
        JLabel lblIDNum = new JLabel("N/a");
        lblIDNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIDNum.setBounds(98, 149, 337, 30);
        getContentPane().add(lblIDNum);
        
        //Background
        JLabel lblThumbnail = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\Khaibao.png")));
        lblThumbnail.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblThumbnail.setText("");
        lblThumbnail.setBounds(-16, 0, 542, 643);
        getContentPane().add(lblThumbnail);
                                   
		//
        this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Event
        NhanKhauModel nhanKhau = NhanKhauController.GetThongTinByID();
        lblIDNum.setText(nhanKhau.ID);
        lblName1.setText(nhanKhau.HoTen);
        lblGender1.setText(nhanKhau.GioiTinh);
        lblDate1.setText(nhanKhau.NgaySinh);
        textFieldPhone.setText(nhanKhau.SoDienThoai);
        
        btnConfirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {        	
        		model.PhieuYTeModel phieu = new model.PhieuYTeModel();
        		phieu.ID = lblIDNum.getText();
        		phieu.HoTen = lblName1.getText();
        		phieu.GioiTinh = lblGender1.getText();
        		if (chckbxSot.isSelected()) phieu.Sot = "1"; 
        		else phieu.Sot = "0";
        		if (chckbxHo.isSelected()) phieu.Ho = "1"; 
        		else phieu.Ho = "0";
        		if (chckbxKhoTho.isSelected()) phieu.KhoTho = "1"; 
        		else phieu.KhoTho = "0";
        		if (chckbxViemPhoi.isSelected()) phieu.ViemPhoi = "1"; 
        		else phieu.ViemPhoi = "0";
        		if (chckbxDauHong.isSelected()) phieu.DauHong = "1"; 
        		else phieu.DauHong = "0";
        		if (chckbxMetMoi.isSelected()) phieu.MetMoi = "1"; 
        		else phieu.MetMoi = "0";
        		phieu.CachLy = (String) comboBoxStatus.getSelectedItem();
        		phieu.XetNghiem = (String) comboBoxTest.getSelectedItem();
        		phieu.SoDienThoai = textFieldPhone.getText();
        		try {
					controller.PhieuYTeController.guiPhieu(phieu);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		JOptionPane.showMessageDialog(KhaiBaoView.this, "Done!!!");
        		KhaiBaoView.this.dispose();
        	}
        });
	}
}
