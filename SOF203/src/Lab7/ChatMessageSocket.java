package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextPane;

public class ChatMessageSocket {
	private Socket socket;
	private JTextPane txtMessageBoard;
	private PrintWriter out;
	private BufferedReader reader;

	public ChatMessageSocket(Socket socket, JTextPane txtMessageBoard) throws IOException {
		super();
		this.socket = socket;
		this.txtMessageBoard = txtMessageBoard;

		out = new PrintWriter(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		receive();
	}

	private void receive() {
		Thread th = new Thread() {
			public void run() {
				while (true) {
					try {
						String line = reader.readLine();
						if (line != null) {
							txtMessageBoard.setText(txtMessageBoard.getText() + "\n" + line);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
	}

	public void send(String msg) {
		txtMessageBoard.setText(txtMessageBoard.getText() + "\n" + msg);
		out.println(msg);
		out.flush();
	}
	
	public void close() {
		try {
			out.close();
			reader.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
