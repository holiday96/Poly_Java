package polypro.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class LoginForm extends JFrame{

	private static final long serialVersionUID = -4913935832695327558L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new LoginForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Shield.png")));
		setVisible(true);
		setBounds(100, 100, 400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle("EduSys - Đăng nhập");
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("New label");
		lblLogin.setIcon(new ImageIcon(this.getClass().getResource("../../icon/security.png")));
		lblLogin.setBounds(0, 0, 173, 211);
		getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Tên đăng nhập");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblUsername.setBounds(182, 6, 85, 18);
		getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
				exitKeyPressed(e);
			}
		});
		txtUsername.setBounds(182, 26, 186, 28);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPassword.setBounds(182, 56, 54, 18);
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
				exitKeyPressed(e);
			}
		});
		txtPassword.setColumns(10);
		txtPassword.setBounds(182, 76, 186, 28);
		getContentPane().add(txtPassword);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Key.png")));
		btnLogin.setBounds(182, 109, 89, 56);
		btnLogin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnLogin);
		
		btnExit = new JButton("Kết thúc");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Exit.png")));
		btnExit.setBounds(280, 109, 88, 56);
		btnExit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnExit);
	}

	protected void login() {
		setVisible(false);
		new MainForm();
	}
	
	protected void exit() {
		System.exit(0);
	}

	protected void exitKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			exit();
		}
	}

	protected void loginKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			login();
		}
	}
}
