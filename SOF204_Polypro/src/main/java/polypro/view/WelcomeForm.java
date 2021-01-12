package polypro.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;

public class WelcomeForm extends JFrame {

	private static final long serialVersionUID = -7253530192216100758L;
	private JProgressBar progressBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					JWindow window = new JWindow();
					window.getContentPane().add(new WelcomeForm());
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
		setTitle("Welcome");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		setBounds(100, 100, 526, 376);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(
				new ImageIcon(this.getClass().getResource("../../icon/logo.png")));
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
				} catch (Exception e) {

				}
			}
		};
		th.start();
	}

}
