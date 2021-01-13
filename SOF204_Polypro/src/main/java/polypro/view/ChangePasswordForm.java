package polypro.view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class ChangePasswordForm extends JFrame{

	private static final long serialVersionUID = -4913935832695327558L;
	private JPasswordField txtOld;
	private JPasswordField txtNew;
	private JPasswordField txtConfirm;

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
		txtOld.setBounds(97, 6, 122, 28);
		getContentPane().add(txtOld);
		txtOld.setColumns(10);
		
		JLabel lblNew = new JLabel("Mật khẩu mới");
		lblNew.setBounds(20, 46, 74, 16);
		getContentPane().add(lblNew);
		
		txtNew = new JPasswordField();
		txtNew.setColumns(10);
		txtNew.setBounds(97, 40, 122, 28);
		getContentPane().add(txtNew);
		
		JButton btnConfirm = new JButton("Đồng ý");
		btnConfirm.setBounds(20, 105, 95, 36);
		getContentPane().add(btnConfirm);
		btnConfirm.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Tick.png")));
		
		JButton btnCancel = new JButton("Huỷ");
		btnCancel.setBounds(124, 105, 95, 36);
		getContentPane().add(btnCancel);
		btnCancel.setIcon(new ImageIcon(this.getClass().getResource("../../icon/Delete.png")));
		
		JLabel lblXcNhn = new JLabel("Xác nhận");
		lblXcNhn.setBounds(20, 77, 55, 16);
		getContentPane().add(lblXcNhn);
		
		txtConfirm = new JPasswordField();
		txtConfirm.setColumns(10);
		txtConfirm.setBounds(97, 71, 122, 28);
		getContentPane().add(txtConfirm);
	}
}
