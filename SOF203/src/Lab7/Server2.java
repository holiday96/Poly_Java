package Lab7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Server2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4057052925023622738L;
	private JTextField txtPort;
	private JTextField txtSend;
	private static JTextArea textArea;
	private JButton btnStart;

	private ServerSocket ss;
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
					new Server2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Server");
		setVisible(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblPort = new JLabel("Port No.");
		lblPort.setBounds(20, 6, 44, 16);
		getContentPane().add(lblPort);

		txtPort = new JTextField();
		txtPort.setBounds(83, 0, 122, 28);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnStart.setBounds(217, 0, 53, 28);
		getContentPane().add(btnStart);

		JLabel lblClient = new JLabel("Client say:");
		lblClient.setBounds(20, 41, 57, 16);
		getContentPane().add(lblClient);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 61, 392, 142);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textArea.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(textArea);

		txtSend = new JTextField();
		txtSend.setBounds(20, 210, 315, 28);
		getContentPane().add(txtSend);
		txtSend.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		btnSend.setBounds(357, 210, 57, 28);
		getContentPane().add(btnSend);
	}

	protected void send() {
		try {
			convertStringToOut(os, txtSend.getText());

			txtSend.setText(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void start() {
		try {
			ss = new ServerSocket(Integer.parseInt(txtPort.getText()));
			System.out.println("Port: " + ss.getLocalPort() + "\nServer is connecting....");
			socket = ss.accept();
			System.out.println("Server is connect to Port " + ss.getLocalPort());
			btnStart.setEnabled(false);
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());

			while (true) {
				System.out.println(convertInToString(is));
				if (!convertInToString(is).isBlank()) {
//					Client2.setTextArea(textArea.getText() + "\n" + convertInToString(is));
					textArea.append("\n" + convertInToString(is));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String convertInToString(DataInputStream in) {
		int length;
		String str = "";
		try {
			length = in.readInt();
			byte[] data = new byte[length];
			in.readFully(data);
			str = new String(data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private void convertStringToOut(DataOutputStream out, String str) {
		byte[] data;
		try {
			data = str.getBytes("UTF-8");
			out.writeInt(data.length);
			out.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTextArea() {
		return textArea.getText();
	}

	public static void setTextArea(String str) {
		textArea.setText(str);
	}
}
