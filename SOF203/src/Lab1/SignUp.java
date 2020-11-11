package Lab1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frmSignUpForm;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SignUp window = new SignUp();
					window.frmSignUpForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
		frmSignUpForm.setLocationRelativeTo(null);
		frmSignUpForm.getContentPane().setLayout(null);

		JLabel lblUser = new JLabel("Username:");
		lblUser.setBounds(6, 17, 62, 16);
		frmSignUpForm.getContentPane().add(lblUser);

		JLabel lblPass = new JLabel("Password:");
		lblPass.setBounds(6, 54, 59, 16);
		frmSignUpForm.getContentPane().add(lblPass);

		JLabel lblConfirm = new JLabel("Confirm:");
		lblConfirm.setBounds(6, 97, 55, 16);
		frmSignUpForm.getContentPane().add(lblConfirm);

		txtUser = new JTextField();
		txtUser.setBounds(100, 11, 152, 28);
		frmSignUpForm.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(100, 48, 152, 28);
		frmSignUpForm.getContentPane().add(txtPass);

		txtConfirm = new JTextField();
		txtConfirm.setColumns(10);
		txtConfirm.setBounds(100, 91, 152, 28);
		frmSignUpForm.getContentPane().add(txtConfirm);

		JButton btnSignup = new JButton("Sign up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkNull()) {
					if (!txtPass.getText().equals(txtConfirm.getText())) {
						JOptionPane.showMessageDialog(btnSignup, "Confirm không khớp! Nhập lại!", "Error",
								JOptionPane.ERROR_MESSAGE);
						txtConfirm.setText("");
					}
				}
			}
		});
		btnSignup.setBounds(100, 131, 70, 28);
		frmSignUpForm.getContentPane().add(btnSignup);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(182, 131, 70, 28);
		frmSignUpForm.getContentPane().add(btnCancel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUpForm = new JFrame();
		frmSignUpForm.setTitle("Sign Up");
		frmSignUpForm.setBounds(100, 100, 273, 203);
		frmSignUpForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean checkNull() {
		if (txtUser.getText().isBlank()) {
			JOptionPane.showMessageDialog(txtUser, "Input Username please!", "Warning", JOptionPane.WARNING_MESSAGE);
			txtUser.requestFocus();
			return true;
		} else if (txtPass.getText().isBlank()) {
			JOptionPane.showMessageDialog(txtPass, "Input Password please!", "Warning", JOptionPane.WARNING_MESSAGE);
			txtPass.requestFocus();
			return true;
		} else if (txtConfirm.getText().isBlank()) {
			JOptionPane.showMessageDialog(txtPass, "Input Confirm please!", "Warning", JOptionPane.WARNING_MESSAGE);
			txtPass.requestFocus();
			return true;
		}
		return false;
	}
}
