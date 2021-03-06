package polypro.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import polypro.model.NhanVienModel;
import polypro.service.INhanVienService;
import polypro.service.impl.NhanVienService;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;
	private List<NhanVienModel> list;
	static NhanVienModel nhanVien;
	static int index;

	private INhanVienService nhanVienSevice = new NhanVienService();

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
		try {
			list = nhanVienSevice.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Shield.png")));
		setVisible(true);
		setBounds(100, 100, 450, 310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Đăng nhập");
		getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Secure.png")));
		lblLogin.setBounds(-41, 6, 242, 290);
		getContentPane().add(lblLogin);

		JLabel lblUsername = new JLabel("Tên đăng nhập");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblUsername.setBounds(213, 20, 85, 18);
		getContentPane().add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setText("admin");
		txtUsername.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtUsername.setBorder(null);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtUsername.setBackground(null);
				loginKeyPressed(e);
				exitKeyPressed(e);
			}
		});
		txtUsername.setBounds(213, 40, 186, 28);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPassword.setBounds(213, 70, 54, 18);
		getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setText("admin");
		txtPassword.setBorder(null);
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtPassword.setBackground(null);
				loginKeyPressed(e);
				exitKeyPressed(e);
			}
		});
		txtPassword.setColumns(10);
		txtPassword.setBounds(213, 90, 186, 28);
		getContentPane().add(txtPassword);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setBorder(null);
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
				exitKeyPressed(e);
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Key.png")));
		btnLogin.setBounds(213, 123, 89, 56);
		btnLogin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnLogin);

		btnExit = new JButton("Kết thúc");
		btnExit.setBorder(null);
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					exit();
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Exit.png")));
		btnExit.setBounds(311, 123, 88, 56);
		btnExit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnExit);
	}

	private boolean validated() {
		StringBuilder message = new StringBuilder();
		if (txtUsername.getText().isBlank()) {
			message.append("\nMã nhân viên trống");
			txtUsername.setBackground(Color.decode("#f38aff"));
			txtUsername.requestFocus();
		}
		if (String.valueOf(txtPassword.getPassword()).isBlank()) {
			message.append("\nMật khẩu trống");
			txtPassword.setBackground(Color.decode("#f38aff"));
			txtPassword.requestFocus();
		}
		if (!txtUsername.getText().isBlank() && !String.valueOf(txtPassword.getPassword()).isBlank()) {
			for (NhanVienModel nhanVienModel : list) {
				if (nhanVienModel.getMaNV().equalsIgnoreCase(txtUsername.getText())
						&& nhanVienModel.getMatKhau().equals(String.valueOf(txtPassword.getPassword()))) {
					LoginForm.nhanVien = nhanVienModel;
					return true;
				}
			}
			message.append("\nTên đăng nhập hoặc Mật khẩu không chính xác");
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message, "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	protected void login() {
		if (validated()) {
			setVisible(false);
			new MainForm();
		}
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
