package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.NhanKhauController;
import controller.PhieuYTeController;
import controller.QAController;
import model.NhanKhauModel;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class MainCitizenView extends JFrame {
	private JTable tablePhieu;
	private JTable tableQA;


	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainCitizenView() throws ClassNotFoundException, SQLException, IOException {
		super("Covid Center");
		this.setSize(800, 600);
        getContentPane().setLayout(null);
        
        JButton btnKhaiBao = new JButton("Khai b\u00E1o", null);
        btnKhaiBao.setOpaque(false);
        btnKhaiBao.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnKhaiBao.setFocusable(false);
        btnKhaiBao.setContentAreaFilled(false);
        btnKhaiBao.setBounds(10, 5, 150, 40);
        getContentPane().add(btnKhaiBao);
        
        JButton btnQA = new JButton("G\u1EEDi c\u00E2u h\u1ECFi", null);
        btnQA.setOpaque(false);
        btnQA.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnQA.setFocusable(false);
        btnQA.setContentAreaFilled(false);
        btnQA.setBounds(170, 5, 150, 40);
        getContentPane().add(btnQA);
        
        JScrollPane scrollPanePhieu = new JScrollPane();
        scrollPanePhieu.setToolTipText("");
        scrollPanePhieu.setBounds(10, 99, 764, 130);
        getContentPane().add(scrollPanePhieu);
        
        tablePhieu = new JTable();
        scrollPanePhieu.setViewportView(tablePhieu);
        
        JScrollPane scrollPaneQA = new JScrollPane();
        scrollPaneQA.setToolTipText("");
        scrollPaneQA.setBounds(10, 276, 764, 130);
        getContentPane().add(scrollPaneQA);
        
        tableQA = new JTable();
        scrollPaneQA.setViewportView(tableQA);
        
        JLabel lblPhieu = new JLabel("Phi\u1EBFu khai b\u00E1o:");
        lblPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPhieu.setBounds(10, 60, 100, 30);
        getContentPane().add(lblPhieu);
        
        JLabel lblTheoDiCu = new JLabel("Theo d\u00F5i c\u00E2u h\u1ECFi:");
        lblTheoDiCu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTheoDiCu.setBounds(10, 236, 133, 30);
        getContentPane().add(lblTheoDiCu);
        
        JButton btnLogOut = new JButton("\u0110\u0103ng xu\u1EA5t", null);
        btnLogOut.setOpaque(false);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogOut.setFocusable(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setBounds(330, 5, 150, 40);
        getContentPane().add(btnLogOut);
        
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(10, 416, 764, 139);
        getContentPane().add(scrollPane2);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setText("Welcome to Covid Center\nChoose a button above to start...");
        textArea.setLineWrap(true);
        scrollPane2.setViewportView(textArea);
        
        JButton btnRefresh1 = new JButton("Refresh", null);
        btnRefresh1.setOpaque(false);
        btnRefresh1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRefresh1.setFocusable(false);
        btnRefresh1.setContentAreaFilled(false);
        btnRefresh1.setBounds(674, 59, 100, 30);
        getContentPane().add(btnRefresh1);
        
        JButton btnRefresh2 = new JButton("Refresh", null);
        btnRefresh2.setOpaque(false);
        btnRefresh2.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRefresh2.setFocusable(false);
        btnRefresh2.setContentAreaFilled(false);
        btnRefresh2.setBounds(674, 236, 100, 30);
        getContentPane().add(btnRefresh2);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, 0, 800, 600);
        getContentPane().add(lblBackGround);
                      
        //
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //
        NhanKhauModel nhanKhau = NhanKhauController.GetThongTinByID();
		Vector<Vector<String>> data = PhieuYTeController.layThongTinPhieuByID(nhanKhau.ID);
		((DefaultTableModel)(tablePhieu.getModel())).setDataVector(data, PhieuYTeController.getHeader());
		
		((DefaultTableModel)(tableQA.getModel())).setDataVector(QAController.getCauHoi(), QAController.getHeader());
        
        //Xu ly cac event
        
        //Event tao hieu ung cho cac button
        btnKhaiBao.addMouseListener(new MouseAdapter() {        	
        	public void mouseClicked(MouseEvent e) {
        		try {
					new KhaiBaoView();
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
        
        btnQA.addMouseListener(new MouseAdapter() {        	
        	public void mouseClicked(MouseEvent e) {
        		new QAView();
        	}
        });
        
        btnLogOut.addMouseListener(new MouseAdapter() {        	
        	public void mouseClicked(MouseEvent e) {
        		MainCitizenView.this.dispose();
        		new LoginView();
        	}
        });
        
        btnRefresh1.addMouseListener(new MouseAdapter() {        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
        			NhanKhauModel nhanKhau = NhanKhauController.GetThongTinByID();
					Vector<Vector<String>> data = PhieuYTeController.layThongTinPhieuByID(nhanKhau.ID);
					((DefaultTableModel)(tablePhieu.getModel())).setDataVector(data, PhieuYTeController.getHeader());
				} catch (Exception er) {
					er.printStackTrace();
				} 
        	}
        });
        
        btnRefresh2.addMouseListener(new MouseAdapter() {        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
        			((DefaultTableModel)(tableQA.getModel())).setDataVector(QAController.getCauHoi(), QAController.getHeader());
        		} catch (Exception er) {
        			er.printStackTrace();
        		}
        		
        	}
        });
        
        tableQA.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedQA = tableQA.getSelectedRow();
        		try {
					textArea.setText(QAController.showQA(QAController.getCauHoi(), selectedQA));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		textArea.setCaretPosition(0);
        	}
        });
        
        tablePhieu.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedPhieu = tablePhieu.getSelectedRow();
        		try {
					textArea.setText(PhieuYTeController.showPhieuCitizen(PhieuYTeController.layThongTinPhieuByID(nhanKhau.ID), selectedPhieu));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		textArea.setCaretPosition(0);
        	}
        });
	}
}
