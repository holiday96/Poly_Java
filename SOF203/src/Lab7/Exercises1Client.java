package Lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Exercises1Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			System.out.println("Client is Connecting....");
			Socket socket = new Socket("localhost", 8888);
			System.out.println("Client is Connected!");

			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());

			while (true) {
				System.out.print("Nhap so thu 1: ");
				outputStream.writeDouble(new Scanner(System.in).nextDouble());
				outputStream.flush();

				System.out.print("Nhap so thu 2: ");
				outputStream.writeDouble(new Scanner(System.in).nextDouble());
				outputStream.flush();

				System.out.println("Tong 2 so = " + inputStream.readDouble());
				System.out.println("Tiep tuc? (y/n): ");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n") || s.equals("N")) {
					break;
				}
				System.out.println("================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
