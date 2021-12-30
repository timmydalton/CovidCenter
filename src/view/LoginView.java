package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.AccountController;

public class LoginView extends JFrame {

	AccountController controller = new AccountController();
    private JTextField textPass;
    private JTextField textUser;
    
    LoginView(){
    	//
        //Khoi tao UI Log In
        //
    	
        super("Covid Center");
        this.setSize(400, 500);
        getContentPane().setLayout(null);

        //Tao button
        JButton btnLogIn = new JButton("\u0110\u0103ng nh\u1EADp");
        btnLogIn.setEnabled(false);
        btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnLogIn.setForeground(Color.DARK_GRAY);
        btnLogIn.setOpaque(true);
        btnLogIn.setBorderPainted(true);
        btnLogIn.setFocusable(false);
        getContentPane().add(btnLogIn);
        btnLogIn.setBounds(120, 380, 140, 30);

        JButton btnChange = new JButton("\u0110\u1ED5i pass", new ImageIcon(System.getProperty("user.dir")+"\\rsc\\setting.png"));
        btnChange.setFont(new Font("Tahoma Bold", Font.PLAIN, 14));
        btnChange.setBorderPainted(true);
        btnChange.setMargin(new Insets(0,0,0,0));
        btnChange.setContentAreaFilled(false);
        btnChange.setBounds(236, 327, 104, 30);
        btnChange.setFocusable(false);
        getContentPane().add(btnChange);

        //Tao textfield
        textPass = new JPasswordField();
        textPass.setBounds(40, 272, 300, 30);
        getContentPane().add(textPass);
        textPass.setColumns(10);

        textUser = new JTextField();
        textUser.setColumns(10);
        textUser.setBounds(40, 202, 300, 30);
        getContentPane().add(textUser);

        //Tao label cho textfield
        JLabel lblLogin = new JLabel("Covid Center");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        lblLogin.setBounds(53, 60, 269, 50);
        lblLogin.setForeground(Color.WHITE);
        getContentPane().add(lblLogin);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 15));
        lblPass.setBounds(40, 242, 93, 30);
        getContentPane().add(lblPass);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 15));
        lblUser.setBounds(40, 172, 93, 30);
        getContentPane().add(lblUser);
        
        JLabel lblVersion = new JLabel("Ver. 1.0.1");
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
        lblVersion.setBounds(320, 445, 65, 14);
        getContentPane().add(lblVersion);
        
        JLabel lblChange = new JLabel("B\u1EA1n mu\u1ED1n \u0111\u1ED1i m\u1EADt kh\u1EA9u?");
        lblChange.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblChange.setBounds(40, 328, 198, 30);
        getContentPane().add(lblChange);
        
        //Background
        JLabel lblThumbnail = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+ "\\rsc\\Artboard 1.png")));
        lblThumbnail.setBounds(-16, 0, 400, 475);
        getContentPane().add(lblThumbnail);
        
        //
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\rsc\\icon.jpg"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Event cho button change pass
        btnChange.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		try {
        			String User = textUser.getText();
            		String Pass = textPass.getText();
            		switch (controller.getUser(User, Pass)) {
					case 1:
					{
						new ChangePassView();
						break;
					}
					case 2:
					{
						new ChangePassView();
						break;
					}
					case 0:
						JOptionPane.showMessageDialog(LoginView.this, "Wrong username or password!!!");
						break;
					}					
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
        
        //Event cho button LogIn
        btnLogIn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String User = textUser.getText();
        		String Pass = textPass.getText();
        		try {
					switch (controller.getUser(User, Pass)) {
					case 1:
					{
						LoginView.this.dispose();
						new MainAdminView();
						break;
					}
					case 2:
					{
						LoginView.this.dispose();
						new MainCitizenView();
						break;
					}
					case 0:
						JOptionPane.showMessageDialog(LoginView.this, "Wrong username or password!!!");
						break;
					}
				} catch (Exception er) {
					JOptionPane.showMessageDialog(LoginView.this, "SQL connection fail!!!");
				}
        	}
        });
        
        //Event kiem tra account
        textUser.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	    changed();
        	  }
        	  public void removeUpdate(DocumentEvent e) {
        	    changed();
        	  }
        	  public void insertUpdate(DocumentEvent e) {
        	    changed();
        	  }

        	  public void changed() {
        	     if (textUser.getText().equals("")){
        	       btnLogIn.setEnabled(false);
        	     }
        	     else {
        	       btnLogIn.setEnabled(true);
        	    }

        	  }
        });
        
    }
	
	public static void main(String[] args) throws FileNotFoundException {
	    new LoginView();
	}
}


