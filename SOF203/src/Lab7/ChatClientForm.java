package Lab7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class ChatClientForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1282390903066102112L;
	private JPanel contentPane;
	private JTextField txtPort;
	private JTextField txtMessage;
	private JTextField txtServerHost;
	private JTextPane txtMessageBoard;
	private JButton btnConnect;
	private JButton btnSend;

	ChatMessageSocket mSocket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ChatClientForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClientForm() {
		setTitle("Client v1.0");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Chat Client");
		lblTitle.setFont(new Font("Dodger", Font.BOLD, 18));
		lblTitle.setBounds(19, 6, 201, 18);
		contentPane.add(lblTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(16, 30, 397, 10);
		contentPane.add(separator);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(252, 42, 25, 16);
		contentPane.add(lblPort);

		txtPort = new JTextField();
		txtPort.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtPortKeyPressed(e);
			}
		});
		txtPort.setBounds(289, 36, 43, 28);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		txtPort.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
			textListenValueChange(txtPort, btnConnect);
		});

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectClicked();
			}
		});
		btnConnect.setBounds(336, 36, 74, 28);
		btnConnect.setEnabled(false);
		contentPane.add(btnConnect);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 70, 391, 151);
		contentPane.add(scrollPane);

		txtMessageBoard = new JTextPane();
		txtMessageBoard.setEditable(false);
		txtMessageBoard.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtMessageBoard.setForeground(new Color(0, 204, 102));
		scrollPane.setViewportView(txtMessageBoard);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(19, 233, 54, 16);
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

		JLabel lblServerHost = new JLabel("Server Host:");
		lblServerHost.setBounds(19, 42, 67, 16);
		contentPane.add(lblServerHost);

		txtServerHost = new JTextField();
		txtServerHost.setText("127.0.0.1");
		txtServerHost.setBounds(98, 36, 122, 28);
		contentPane.add(txtServerHost);
		txtServerHost.setColumns(10);
	}

	protected void txtMessageKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendClicked();
		}
	}

	protected void txtPortKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			connectClicked();
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
		mSocket.send("Client " + txtPort.getText() + ": " + txtMessage.getText());
		txtMessage.setText(null);
	}

	protected void connectClicked() {
		try {
			int port = Integer.parseInt(txtPort.getText());
			Socket socket = new Socket(txtServerHost.getText(), port);

			mSocket = new ChatMessageSocket(socket, txtMessageBoard);

			txtMessageBoard.setText(txtMessageBoard.getText() + "\nPort " + txtPort.getText() + " Connected!");

			txtMessage.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
				textListenValueChange(txtMessage, btnSend);
			});

			ChatServerForm.txtMessage.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
				textListenValueChange(ChatServerForm.txtMessage, ChatServerForm.btnSend);
			});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
