package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import polypro.model.NhanVienModel;
import polypro.service.impl.NhanVienService;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JPasswordField txtOld;
	private JPasswordField txtNew;
	private JPasswordField txtConfirm;
	private List<NhanVienModel> list;
	private int index;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ChangePasswordForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangePasswordForm() {
		initialize();
		index = LoginForm.index;
		try {
			list = new NhanVienService().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		setBounds(100, 100, 257, 191);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Refresh.png")));
		setTitle("Đổi mật khẩu");
		getContentPane().setLayout(null);

		JLabel lblOld = new JLabel("Mật khẩu cũ");
		lblOld.setBounds(20, 12, 65, 16);
		getContentPane().add(lblOld);

		txtOld = new JPasswordField();
		txtOld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtOld.setBackground(null);
			}
		});
		txtOld.setBounds(97, 6, 122, 28);
		getContentPane().add(txtOld);
		txtOld.setColumns(10);

		JLabel lblNew = new JLabel("Mật khẩu mới");
		lblNew.setBounds(20, 46, 74, 16);
		getContentPane().add(lblNew);

		txtNew = new JPasswordField();
		txtNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtNew.setBackground(null);
			}
		});
		txtNew.setColumns(10);
		txtNew.setBounds(97, 40, 122, 28);
		getContentPane().add(txtNew);

		JButton btnConfirm = new JButton("Đồng ý");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAccept();
			}
		});
		btnConfirm.setBounds(20, 105, 95, 36);
		getContentPane().add(btnConfirm);
		btnConfirm.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Tick.png")));

		JButton btnCancel = new JButton("Huỷ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel();
			}
		});
		btnCancel.setBounds(124, 105, 95, 36);
		getContentPane().add(btnCancel);
		btnCancel.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Delete.png")));

		JLabel lblNhapLai = new JLabel("Nhập lại");
		lblNhapLai.setBounds(20, 77, 55, 16);
		getContentPane().add(lblNhapLai);

		txtConfirm = new JPasswordField();
		txtConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtConfirm.setBackground(null);
			}
		});
		txtConfirm.setColumns(10);
		txtConfirm.setBounds(97, 71, 122, 28);
		getContentPane().add(txtConfirm);
	}

	protected void btnCancel() {
		this.setVisible(false);
	}

	protected void btnAccept() {
		if (validated()) {
			list.get(index).setMatKhau(String.valueOf(txtConfirm.getPassword()));
			new NhanVienService().update(list.get(index), list.get(index).getMaNV());
			setVisible(false);
		}
		list = new NhanVienService().findAll();
	}

	private boolean validated() {
		StringBuilder message = new StringBuilder();
		if (String.valueOf(txtOld.getPassword()).isBlank()) {
			message.append("\nMật khẩu cũ trống");
			txtOld.setBackground(Color.decode("#f38aff"));
			txtOld.requestFocus();
		}
		if (String.valueOf(txtNew.getPassword()).isBlank()) {
			message.append("\nMật khẩu mới trống");
			txtNew.setBackground(Color.decode("#f38aff"));
			txtNew.requestFocus();
		}
		if (String.valueOf(txtConfirm.getPassword()).isBlank()) {
			message.append("\nMật khẩu xác nhận trống");
			txtConfirm.setBackground(Color.decode("#f38aff"));
			txtConfirm.requestFocus();
		}
		if (!String.valueOf(txtOld.getPassword()).isBlank() && !String.valueOf(txtNew.getPassword()).isBlank()
				&& !String.valueOf(txtConfirm.getPassword()).isBlank()) {
			if (!String.valueOf(txtOld.getPassword()).equals(list.get(index).getMatKhau())) {
				message.append("\nMật khẩu cũ không chính xác");
				txtOld.setBackground(Color.decode("#ff96a6"));
				txtOld.requestFocus();
			} else if (String.valueOf(txtOld.getPassword()).equals(String.valueOf(txtNew.getPassword()))) {
				message.append("\nMật khẩu mới không được trùng với mật khẩu cũ");
				txtNew.setBackground(Color.decode("#ff96a6"));
				txtNew.requestFocus();
			} else if (!String.valueOf(txtNew.getPassword()).equals(String.valueOf(txtConfirm.getPassword()))) {
				message.append("\nMật khẩu nhập lại và mật khẩu mới không khớp");
				txtConfirm.setBackground(Color.decode("#ff96a6"));
				txtConfirm.requestFocus();
			}
		}
		if (!message.isEmpty()) {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
		return true;
	}
}
