package Lab7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Client2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5734856716696550436L;
	private JTextField txtPort;
	private JTextField txtSend;
	private JTextArea textArea;

	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new Client2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	/**
	 * Create the application.
	 */
	public Client2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client");
		getContentPane().setLayout(null);

		JLabel lblPort = new JLabel("Port No.");
		lblPort.setBounds(20, 15, 44, 16);
		getContentPane().add(lblPort);

		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(74, 6, 122, 28);
		getContentPane().add(txtPort);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		btnConnect.setBounds(208, 9, 74, 28);
		getContentPane().add(btnConnect);

		JLabel lblServer = new JLabel("Server say:");
		lblServer.setBounds(20, 86, 60, 16);
		getContentPane().add(lblServer);

		txtSend = new JTextField();
		txtSend.setBounds(20, 46, 325, 28);
		getContentPane().add(txtSend);
		txtSend.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		btnSend.setBounds(357, 46, 57, 28);
		getContentPane().add(btnSend);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 114, 394, 141);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textArea.setForeground(new Color(255, 0, 51));
		scrollPane.setViewportView(textArea);
	}

	protected void send() {
		try {
			os = new DataOutputStream(socket.getOutputStream());
			is = new DataInputStream(socket.getInputStream());
			os.writeChars(txtSend.getText());

			String mess = String.valueOf(is.readLine());
			textArea.setText(textArea.getText() + "\n" + mess);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void connect() {
		try {
			socket = new Socket("localhost", Integer.parseInt(txtPort.getText()));
			System.out.println("Port: " + socket.getLocalPort() + "\nClient is connecting...");
			System.out.println("Client is connect to Port " + socket.getLocalPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
