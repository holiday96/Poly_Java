package polypro.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class WelcomeForm extends JFrame {

	private static final long serialVersionUID = -7253530192216100758L;
	private JProgressBar progressBar;
	private LoginForm loginForm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new WelcomeForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeForm() {
		setUndecorated(true);
		loginForm = new LoginForm();
		loginForm.setVisible(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/fpt.png")));
		setTitle("Welcome");
		setVisible(true);
		setBounds(100, 100, 577, 263);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(this.getClass().getResource("../../icon/logo.png")));
		getContentPane().add(lblIcon, BorderLayout.CENTER);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		getContentPane().add(progressBar, BorderLayout.SOUTH);
		fill();
	}

	public void fill() {
		Thread th = new Thread() {
			public void run() {
				try {
					for (int i = progressBar.getMinimum(); i <= progressBar.getMaximum(); i++) {
						progressBar.setValue(i);
						sleep(10);
					}
					if (progressBar.getValue() == 100) {
						setVisible(false);
						loginForm.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		th.start();
	}

}
