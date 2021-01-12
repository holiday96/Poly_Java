package polypro.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new MainForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/fpt.png")));
		setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO");
		setVisible(true);
		setBounds(100, 100, 1030, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSystem = new JMenu("Hệ thống");
		menuBar.add(mnSystem);

		JMenuItem mntmLogin = new JMenuItem("Đăng nhập");
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnSystem.add(mntmLogin);
		mntmLogin.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Key.png")));

		JMenuItem mntmLogout = new JMenuItem("Đăng xuất");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnSystem.add(mntmLogout);
		mntmLogout.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Exit.png")));

		mnSystem.add(new JSeparator());

		JMenuItem mntmChangePassword = new JMenuItem("Đổi mật khẩu");
		mnSystem.add(mntmChangePassword);
		mntmChangePassword.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Refresh.png")));

		mnSystem.add(new JSeparator());

		JMenuItem mntmExit = new JMenuItem("Kết thúc");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnSystem.add(mntmExit);
		mntmExit.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Stop.png")));

		JMenu mnManagement = new JMenu("Quản lý");
		menuBar.add(mnManagement);

		JMenuItem mntmChuyenDe = new JMenuItem("Chuyên đề");
		mntmChuyenDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chuyenDe();
			}
		});
		mntmChuyenDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		mnManagement.add(mntmChuyenDe);
		mntmChuyenDe.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Lists.png")));

		JMenuItem mntmKhoaHoc = new JMenuItem("Khoá học");
		mntmKhoaHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaHoc();
			}
		});
		mntmKhoaHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mnManagement.add(mntmKhoaHoc);
		mntmKhoaHoc.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Certificate.png")));

		JMenuItem mntmNguoiHoc = new JMenuItem("Người học");
		mntmNguoiHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nguoiHoc();
			}
		});
		mntmNguoiHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		mnManagement.add(mntmNguoiHoc);
		mntmNguoiHoc.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Conference.png")));

		JMenuItem mntmHocVien = new JMenuItem("Học viên");
		mntmHocVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		mnManagement.add(mntmHocVien);
		mntmHocVien.setIcon(new ImageIcon(this.getClass().getResource("../../icon/User.png")));

		mnManagement.add(new JSeparator());

		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mntmNhanVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_MASK));
		mnManagement.add(mntmNhanVien);
		mntmNhanVien.setIcon(new ImageIcon(this.getClass().getResource("../../icon/User group.png")));

		JMenu mnStatistics = new JMenu("Thống kê");
		menuBar.add(mnStatistics);

		JMenuItem mntmBangDiem = new JMenuItem("Bảng điểm");
		mntmBangDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnStatistics.add(mntmBangDiem);
		mntmBangDiem.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Card file.png")));
		
		JSeparator separator = new JSeparator();
		mnStatistics.add(separator);

		JMenuItem mntmLuongNguoiHoc = new JMenuItem("Lượng người học");
		mntmLuongNguoiHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK));
		mnStatistics.add(mntmLuongNguoiHoc);
		mntmLuongNguoiHoc.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Clien list.png")));

		JMenuItem mntmDiemChuyenDe = new JMenuItem("Điểm chuyên đề");
		mntmDiemChuyenDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		mnStatistics.add(mntmDiemChuyenDe);
		mntmDiemChuyenDe.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Bar chart.png")));

		JMenuItem mntmDoanhThu = new JMenuItem("Doanh thu");
		mntmDoanhThu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_MASK));
		mnStatistics.add(mntmDoanhThu);
		mntmDoanhThu.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Dollar.png")));

		JMenu mnHelp = new JMenu("Trợ giúp");
		menuBar.add(mnHelp);

		JMenuItem mntmInstruction = new JMenuItem("Hướng dẫn sử dụng");
		mntmInstruction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmInstruction);
		mntmInstruction.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Globe.png")));

		mnHelp.add(new JSeparator());

		JMenuItem mntmAbout = new JMenuItem("Giới thiệu sản phẩm");
		mnHelp.add(mntmAbout);
		mntmAbout.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Home.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnLogout = new JButton("Đăng xuất");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		toolBar.add(btnLogout);
		btnLogout.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Exit.png")));
		btnLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLogout.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnExit = new JButton("Kết thúc");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		toolBar.add(btnExit);
		btnExit.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Stop.png")));
		btnExit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnChuyenDe = new JButton("Chuyên đề");
		btnChuyenDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chuyenDe();
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		toolBar.add(btnChuyenDe);
		btnChuyenDe.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Lists.png")));
		btnChuyenDe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnChuyenDe.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnNguoiHoc = new JButton("Người học");
		btnNguoiHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nguoiHoc();
			}
		});
		toolBar.add(btnNguoiHoc);
		btnNguoiHoc.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Conference.png")));
		btnNguoiHoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNguoiHoc.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnKhoaHoc = new JButton("Khoá học");
		btnKhoaHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaHoc();
			}
		});
		toolBar.add(btnKhoaHoc);
		btnKhoaHoc.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Certificate.png")));
		btnKhoaHoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKhoaHoc.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnHocVien = new JButton("Học viên");
		toolBar.add(btnHocVien);
		btnHocVien.setIcon(new ImageIcon(this.getClass().getResource("../../icon/User.png")));
		btnHocVien.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHocVien.setHorizontalTextPosition(SwingConstants.CENTER);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);

		JButton btnInstruction = new JButton("Hướng dẫn");
		toolBar.add(btnInstruction);
		btnInstruction.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Globe.png")));
		btnInstruction.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInstruction.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblFooter = new JLabel("Hệ quản lý đào tạo");
		panel.add(lblFooter);
		lblFooter.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Info.png")));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);

		JLabel lblTime = new JLabel("Time");
		panel.add(lblTime);
		lblTime.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Alarm.png")));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(255, 255, 255));
		getContentPane().add(lblBackground, BorderLayout.CENTER);
		lblBackground.setIcon(new ImageIcon(this.getClass().getResource("../../icon/bee.png")));
		
		Thread th = new Thread() {
			public void run() {
				while (true) {
					Date d = new Date();
				    SimpleDateFormat s = new SimpleDateFormat("H:mm:ss a");
				    lblTime.setText(s.format(d));   
				}
			}
		};
		th.start();
	}

	protected void nguoiHoc() {
		new NguoiHocForm();
	}

	protected void khoaHoc() {
		new KhoaHocForm();
	}

	protected void chuyenDe() {
		new ChuyenDeForm();
	}

	protected void exit() {
		System.exit(0);
	}

	protected void logout() {
		setVisible(false);
		new LoginForm();
	}

}
