package Lab1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Calculator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7333525485900148129L;
	private JFrame frmCalculator;
	private JTextField txtFirstNumber;
	private JTextField txtSecondNumber;
	private JTextField txtResult;
	private JButton btnSum;
	private JButton btnDif;
	private JButton btnMul;
	private JButton btnDiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
		frmCalculator.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 256, 195);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);

		JLabel lblFirstNumber = new JLabel("First number:");
		lblFirstNumber.setBounds(6, 12, 73, 16);
		frmCalculator.getContentPane().add(lblFirstNumber);

		JLabel lblSecondNumber = new JLabel("Second number:");
		lblSecondNumber.setBounds(6, 51, 91, 16);
		frmCalculator.getContentPane().add(lblSecondNumber);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(6, 93, 39, 16);
		frmCalculator.getContentPane().add(lblResult);

		txtFirstNumber = new JTextField();
		txtFirstNumber.setBounds(107, 6, 122, 28);
		frmCalculator.getContentPane().add(txtFirstNumber);
		txtFirstNumber.setColumns(10);

		txtSecondNumber = new JTextField();
		txtSecondNumber.setColumns(10);
		txtSecondNumber.setBounds(107, 45, 122, 28);
		frmCalculator.getContentPane().add(txtSecondNumber);

		txtResult = new JTextField();
		txtResult.setColumns(10);
		txtResult.setBounds(107, 87, 122, 28);
		frmCalculator.getContentPane().add(txtResult);

		btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkNull()) {
						txtResult.setText(String.valueOf(Float.parseFloat(txtFirstNumber.getText())
								+ Float.parseFloat(txtSecondNumber.getText())));
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnSum, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSum.setBounds(78, 120, 35, 28);
		frmCalculator.getContentPane().add(btnSum);

		btnDif = new JButton("-");
		btnDif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkNull()) {
						txtResult.setText(String.valueOf(Float.parseFloat(txtFirstNumber.getText())
								- Float.parseFloat(txtSecondNumber.getText())));
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnDif, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDif.setBounds(117, 120, 35, 28);
		frmCalculator.getContentPane().add(btnDif);

		btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkNull()) {
						txtResult.setText(String.valueOf(Float.parseFloat(txtFirstNumber.getText())
								* Float.parseFloat(txtSecondNumber.getText())));
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnMul, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMul.setBounds(157, 120, 35, 28);
		frmCalculator.getContentPane().add(btnMul);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkNull()) {
						txtResult.setText(String.valueOf(Float.parseFloat(txtFirstNumber.getText())
								/ Float.parseFloat(txtSecondNumber.getText())));
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btnDiv, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDiv.setBounds(194, 120, 35, 28);
		frmCalculator.getContentPane().add(btnDiv);
	}

	public boolean checkNull() {
		if (txtFirstNumber.getText().isBlank()) {
			JOptionPane.showMessageDialog(txtFirstNumber, "Chưa nhập giá trị", "First Number",
					JOptionPane.WARNING_MESSAGE);
			txtFirstNumber.requestFocus();
			return false;
		} else if (txtSecondNumber.getText().isBlank()) {
			JOptionPane.showMessageDialog(txtSecondNumber, "Chưa nhập giá trị", "Second Number",
					JOptionPane.WARNING_MESSAGE);
			txtSecondNumber.requestFocus();
			return false;
		}
		return true;
	}
}
