package Lab8;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendMail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4521981636752090314L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtTo;
	private JTextField txtSubject;
	private JTextArea txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new SendMail();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SendMail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 394, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Send Mail");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTitle.setForeground(new Color(0, 102, 255));
		lblTitle.setBounds(137, 6, 94, 26);
		getContentPane().add(lblTitle);

		JPanel pnlSend = new JPanel();
		pnlSend.setBorder(new TitledBorder(null, "Send Account", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		pnlSend.setBounds(31, 35, 308, 106);
		getContentPane().add(pnlSend);
		pnlSend.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(21, 35, 66, 16);
		pnlSend.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(21, 63, 66, 16);
		pnlSend.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setText("namlun96@gmail.com");
		txtUsername.setBounds(93, 29, 197, 28);
		pnlSend.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(93, 57, 197, 28);
		pnlSend.add(txtPassword);
		txtPassword.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Receive", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		panel.setBounds(31, 153, 308, 261);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(64, 34, 23, 16);
		panel.add(lblTo);

		txtTo = new JTextField();
		txtTo.setText("ducbvph12717@fpt.edu.vn");
		txtTo.setBounds(93, 28, 197, 28);
		panel.add(txtTo);
		txtTo.setColumns(10);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(37, 63, 50, 16);
		panel.add(lblSubject);

		txtSubject = new JTextField();
		txtSubject.setText("Test Lab 8");
		txtSubject.setBounds(93, 57, 197, 28);
		panel.add(txtSubject);
		txtSubject.setColumns(10);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(28, 106, 59, 16);
		panel.add(lblMessage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 97, 197, 106);
		panel.add(scrollPane);

		txtMessage = new JTextArea();
		txtMessage.setText("gút chópppp");
		scrollPane.setViewportView(txtMessage);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendClicked();
			}
		});
		btnSend.setBounds(93, 211, 57, 28);
		panel.add(btnSend);
	}

	private void sendClicked() {
		try {
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");	//TLS
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", 587);

			Session s = Session.getInstance(p, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(txtUsername.getText(), txtPassword.getPassword().toString());
				}
			});

			Message msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(txtUsername.getText()));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtTo.getText()));
			msg.setSubject(txtSubject.getText());
			msg.setText(txtMessage.getText());

			Transport.send(msg);
			JOptionPane.showMessageDialog(null, "Mail was sent successfully.", "Message",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (MessagingException e) {
			Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
