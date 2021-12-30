package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.NhanKhauController;
import controller.QAController;
import model.NhanKhauModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class QAAdminView extends JFrame {
	private JTable table;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public QAAdminView() throws ClassNotFoundException, SQLException {
		super("Answer question");
		this.setSize(800, 500);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Question list:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 10, 131, 30);
        getContentPane().add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 38, 766, 169);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 217, 766, 85);
        getContentPane().add(scrollPane_1);
        
        JTextPane textPaneQ = new JTextPane();
        textPaneQ.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textPaneQ.setText("C\u00E2u h\u1ECFi...");
        scrollPane_1.setViewportView(textPaneQ);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 312, 766, 85);
        getContentPane().add(scrollPane_2);
        
        JTextPane textPaneA = new JTextPane();
        textPaneA.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textPaneA.setText("Tr\u1EA3 l\u1EDDi...");
        scrollPane_2.setViewportView(textPaneA);
        
        JButton btnConfirm = new JButton("G\u1EEDi tr\u1EA3 l\u1EDDi");
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnConfirm.setOpaque(false);
        btnConfirm.setBorderPainted(true);
        btnConfirm.setContentAreaFilled(false);
        btnConfirm.setFocusable(false);
        btnConfirm.setBounds(10, 407, 123, 46);
        getContentPane().add(btnConfirm);
        
        JButton btnQuayLi = new JButton("Quay l\u1EA1i");
        btnQuayLi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnQuayLi.setOpaque(false);
        btnQuayLi.setBorderPainted(true);
        btnQuayLi.setFocusable(false);
        btnQuayLi.setContentAreaFilled(false);
        btnQuayLi.setBounds(143, 407, 123, 46);
        getContentPane().add(btnQuayLi);
        
        //Background
        JLabel lblBackGround = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\bg8.png")));
        lblBackGround.setBounds(0, 0, 800, 600);
        getContentPane().add(lblBackGround);
        
        //
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //
        ((DefaultTableModel)(table.getModel())).setDataVector(QAController.getCauHoi(), QAController.getHeader());;
        
        //Event
        
        btnQuayLi.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		QAAdminView.this.dispose();
        	}
        });
        
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table.getSelectedRow();
        		try {
					textPaneQ.setText(QAController.showQ(QAController.getCauHoi(), selectedRow));
					textPaneA.setText(QAController.showA(QAController.getCauHoi(), selectedRow));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		textPaneQ.setCaretPosition(0);
        	}
        });
        
        btnConfirm.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table.getSelectedRow();
        		String answer = textPaneA.getText();
        		try {
					NhanKhauModel nK = NhanKhauController.GetThongTinByID();
					QAController.guiTraLoi(answer, nK.ID, QAController.getSelectedQID(QAController.getCauHoi(), selectedRow));
					((DefaultTableModel)(table.getModel())).setDataVector(QAController.getCauHoi(), QAController.getHeader());;
					JOptionPane.showMessageDialog(QAAdminView.this, "Đã gửi trả lời!");
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
