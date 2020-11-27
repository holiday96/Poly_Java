package Lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercises1Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("Server is connecting...");
			Socket socket = serverSocket.accept();
			System.out.println("Server is connect");
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

			while (true) {
				double num1 = inputStream.readDouble();
				double num2 = inputStream.readDouble();
				System.out.println("2 số nhận được từ Client là " + num1 + " " + num2);
				double sum = num1 + num2;
				outputStream.writeDouble(sum);
				outputStream.flush();
				System.out.println("Tổng 2 số là: " + sum);
				System.out.println("================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
