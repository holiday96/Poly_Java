package Lab7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatServerForm extends JFrame {
	private ChatMessageSocket mSocket;

	/**
	 * 
	 */
	private static final long serialVersionUID = 509171831309434000L;
	private JPanel contentPane;
	private JTextField txtPort;
	static JTextField txtMessage;
	private JTextPane txtMessageBoard;
	private JButton btnStart;
	static JButton btnSend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ChatServerForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatServerForm() {
		setTitle("Server v1.0");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Chat Server");
		lblTitle.setFont(new Font("Dodger", Font.BOLD, 18));
		lblTitle.setBounds(19, 6, 218, 18);
		contentPane.add(lblTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(16, 30, 397, 10);
		contentPane.add(separator);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(19, 42, 25, 16);
		contentPane.add(lblPort);

		txtPort = new JTextField();
		txtPort.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtPortKeyPressed(e);
			}
		});
		txtPort.setBounds(56, 36, 43, 28);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		txtPort.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
			textListenValueChange(txtPort, btnStart);
		});

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startClicked();
			}
		});
		btnStart.setBounds(360, 36, 53, 28);
		btnStart.setEnabled(false);
		contentPane.add(btnStart);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 70, 391, 151);
		contentPane.add(scrollPane);

		txtMessageBoard = new JTextPane();
		txtMessageBoard.setEditable(false);
		txtMessageBoard.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtMessageBoard.setForeground(new Color(204, 0, 102));
		scrollPane.setViewportView(txtMessageBoard);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(19, 233, 55, 16);
		contentPane.add(lblMessage);

		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtMessageKeyPressed(e);
			}
		});
		txtMessage.setBounds(86, 227, 258, 28);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);

		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendClicked();
			}
		});
		btnSend.setBounds(356, 227, 57, 28);
		btnSend.setEnabled(false);
		contentPane.add(btnSend);
	}

	protected void txtMessageKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendClicked();
		}
	}

	protected void txtPortKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			startClicked();
		}
	}

	protected void textListenValueChange(JTextField textfield, JButton button) {
		if (textfield.getText().isBlank()) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}

	protected void sendClicked() {
		if (txtMessage.getText().isBlank()) {
			return;
		}
		mSocket.send("SERVER: " + txtMessage.getText());
		txtMessage.setText(null);
	}

	protected void startClicked() {
		try {
			int port = Integer.parseInt(txtPort.getText());
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);

			Thread th = new Thread() {
				public void run() {
					try {
						txtMessageBoard
								.setText(txtMessageBoard.getText() + "\nPort " + txtPort.getText() + " - Starting...");
						Socket socket = serverSocket.accept();

						mSocket = new ChatMessageSocket(socket, txtMessageBoard);

					} catch (Exception e) {
						txtMessageBoard.setText("\nError: " + e.getMessage());
						e.printStackTrace();
					}
				}
			};
			th.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
