package Lab7;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class ChatMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ChatServerForm();
					new ChatClientForm();
					new ChatClientForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
