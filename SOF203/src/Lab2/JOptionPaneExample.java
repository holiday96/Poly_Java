package Lab2;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPaneExample extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton message, input, confirm, option;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					JOptionPaneExample window = new JOptionPaneExample();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JOptionPaneExample() {
		initialize();
	}

	private void initialize() {
		this.setVisible(true);
		this.setTitle("JOption Pane Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);

		message = new JButton("Message Dialog");
		this.add(message);
		message.setActionCommand("message");
		message.addActionListener(this);

		input = new JButton("Input Dialog");
		this.add(input);
		input.setActionCommand("input");
		input.addActionListener(this);

		confirm = new JButton("Confirm Dialog");
		this.add(confirm);
		confirm.setActionCommand("confirm");
		confirm.addActionListener(this);

		option = new JButton("Option Dialog");
		this.add(option);
		option.setActionCommand("option");
		option.addActionListener(this);

		this.setLayout(new GridLayout(2, 2));
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("message")) {
			JOptionPane.showMessageDialog(message, "Please input your name");
		}
		if (e.getActionCommand().equals("input")) {
			String yourName = JOptionPane.showInputDialog("Your name is: ");

			if (yourName != null) {
				JOptionPane.showMessageDialog(this, "Your name is " + yourName);
			}
		}
		if (e.getActionCommand().equals("confirm")) {
			int ret = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);

			if (ret == JOptionPane.YES_OPTION) {

			} else {

			}
		}
		if (e.getActionCommand().equals("option")) {
			int messageType = JOptionPane.QUESTION_MESSAGE;
			String[] options = { "Java", "C++", "VB", "PHP", "Perl" };
			int code = JOptionPane.showOptionDialog(this, "What language do you prefer?", "Option Dialog Box", 0,
					messageType, null, options, "PHP");
			JOptionPane.showMessageDialog(this, "Answer: " + options[code]);
		}
	}
}
