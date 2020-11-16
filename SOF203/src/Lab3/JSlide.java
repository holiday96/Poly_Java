package Lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSlide extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9003864438763243091L;
	private JTextField textField;
	private JSlider slider;
	private JLabel lblAll;

	public JSlide() {
		initializer();
	}

	private void initializer() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(449, 300);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				change();
			}
		});
		slider.setValue(45);
		slider.setMaximum(50);
		slider.setBounds(6, 5, 422, 51);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		panel.add(slider);

		JLabel lblValue = new JLabel("Giá trị hiện tại");
		lblValue.setForeground(Color.BLUE);
		lblValue.setBounds(6, 90, 75, 16);
		panel.add(lblValue);

		textField = new JTextField("");
		textField.setBounds(90, 84, 55, 28);
		panel.add(textField);
		textField.setColumns(2);

		JButton btnSet = new JButton("Set value");
		btnSet.setBounds(159, 84, 78, 28);
		panel.add(btnSet);
		btnSet.addActionListener(this);

		lblAll = new JLabel("Font size");
		lblAll.setVerticalAlignment(SwingConstants.TOP);
		lblAll.setForeground(Color.BLUE);
		lblAll.setBounds(249, 90, 179, 165);
		panel.add(lblAll);
	}

	protected void change() {
		try {
			textField.setText(String.valueOf(slider.getValue()));
			lblAll.setFont(new Font("Tahoma", 1, (int) slider.getValue()));
		} catch (NullPointerException e) {
			//
		}
	}

	private void set() {
		slider.setValue(Integer.parseInt(textField.getText()));
		lblAll.setFont(new Font("Tahoma", 1, Integer.parseInt(textField.getText())));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new JSlide();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		set();
	}
}
