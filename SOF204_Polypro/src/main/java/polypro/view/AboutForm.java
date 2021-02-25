package polypro.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class AboutForm extends JInternalFrame{

	private static final long serialVersionUID = -4913935832695327558L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new AboutForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Giới thiệu sản phẩm");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo, BorderLayout.CENTER);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("../../icon/logo.png")));
		
		JTextPane txpInfo = new JTextPane();
		txpInfo.setEditable(false);
		txpInfo.setText("Polypro là dự án mẫu. Mục tiêu chính là huấn luyện sinh viên quy trình thực hiện dự án.\r\n\r\nMục tiêu của dự án này là để rèn luyện kỹ năng IO (CDIO) tức không yêu cầu sinh viên phải thu thập phân tích mà chỉ thực hiện và vận hành một phần mềm chuẩn bị cho các dự án sau này. Các kỹ năng CD (trong CDIO) sẽ được huấn luyện ở dự án 1 và dự án 2.\r\n\r\nYêu cầu về môi trường:\r\n1. Hệ điều hành bất kỳ\r\n2. JDK 15\r\n3. SQL Server 2019");
		getContentPane().add(txpInfo, BorderLayout.CENTER);
		
		setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Home.png"))));
		setVisible(true);
		setBounds(100, 100, 581, 429);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}

}
