package Lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StudentRegistration extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8110432818367970093L;

	private JPanel pnlPersonal, pnlAcamedic, pnlExtracurricular, pnlButton;
	private JTextField txtFirstName, txtLastName, txtContact, txtHigh, txtSpecification, txtEnroll, txtHobbies,
			txtSport;
	private JTextArea txtAddress;
	private JButton btnSave, btnReset, btnExit;
	private JScrollPane scrollPane;

	public StudentRegistration() {
		initializer();
	}

	private void initializer() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(SystemColor.controlHighlight);
		setSize(450, 590);

		JLabel lblTitle = new JLabel("STUDENT REGISTRATION");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(86, 6, 258, 25);
		lblTitle.setForeground(Color.MAGENTA);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblTitle);

		pnlPersonal = new JPanel();
		pnlPersonal.setBackground(SystemColor.controlHighlight);
		pnlPersonal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Personal Detail",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPersonal.setBounds(6, 32, 422, 223);
		getContentPane().add(pnlPersonal);
		pnlPersonal.setLayout(null);
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(49, 31, 61, 16);
		pnlPersonal.add(lblFirstName);
		txtFirstName = new JTextField();
		txtFirstName.setBounds(122, 25, 223, 28);
		pnlPersonal.add(txtFirstName);
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(49, 64, 61, 16);
		pnlPersonal.add(lblLastName);
		txtLastName = new JTextField();
		txtLastName.setBounds(122, 58, 223, 28);
		pnlPersonal.add(txtLastName);
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(49, 97, 42, 16);
		pnlPersonal.add(lblContact);
		txtContact = new JTextField();
		txtContact.setBounds(122, 91, 223, 28);
		pnlPersonal.add(txtContact);
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(49, 133, 46, 16);
		pnlPersonal.add(lblAddress);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 124, 223, 84);
		pnlPersonal.add(scrollPane);
		txtAddress = new JTextArea();
		txtAddress.setTabSize(0);
		scrollPane.setViewportView(txtAddress);

		pnlAcamedic = new JPanel();
		pnlAcamedic.setBackground(SystemColor.controlHighlight);
		pnlAcamedic.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Acamedic Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAcamedic.setBounds(6, 267, 422, 120);
		JLabel lblHigh = new JLabel("Highest Qualification");
		lblHigh.setBounds(48, 24, 114, 16);
		txtHigh = new JTextField();
		txtHigh.setBounds(175, 18, 223, 28);
		JLabel lblSpecification = new JLabel("Specification");
		lblSpecification.setBounds(48, 58, 70, 16);
		txtSpecification = new JTextField();
		txtSpecification.setBounds(175, 52, 223, 27);
		JLabel lblEnroll = new JLabel("Enroll For");
		lblEnroll.setBounds(48, 92, 53, 16);
		txtEnroll = new JTextField();
		txtEnroll.setBounds(175, 86, 223, 27);
		pnlAcamedic.setLayout(null);
		pnlAcamedic.add(lblHigh);
		pnlAcamedic.add(txtHigh);
		pnlAcamedic.add(lblSpecification);
		pnlAcamedic.add(txtSpecification);
		pnlAcamedic.add(lblEnroll);
		pnlAcamedic.add(txtEnroll);
		getContentPane().add(pnlAcamedic);

		pnlExtracurricular = new JPanel();
		pnlExtracurricular.setBackground(SystemColor.controlHighlight);
		pnlExtracurricular.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Extracurricular Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlExtracurricular.setBounds(6, 399, 422, 95);
		JLabel lblHobbies = new JLabel("Hobbies");
		lblHobbies.setBounds(48, 29, 47, 16);
		txtHobbies = new JTextField();
		txtHobbies.setBounds(107, 23, 223, 28);
		JLabel lblSport = new JLabel("Sport");
		lblSport.setBounds(48, 63, 29, 16);
		txtSport = new JTextField();
		txtSport.setBounds(107, 57, 223, 28);
		pnlExtracurricular.setLayout(null);
		pnlExtracurricular.add(lblHobbies);
		pnlExtracurricular.add(txtHobbies);
		pnlExtracurricular.add(lblSport);
		pnlExtracurricular.add(txtSport);
		getContentPane().add(pnlExtracurricular);

		pnlButton = new JPanel();
		pnlButton.setBackground(SystemColor.controlHighlight);
		pnlButton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pnlButton.setBounds(6, 506, 422, 38);
		getContentPane().add(pnlButton);
		btnSave = new JButton("Save");
		btnReset = new JButton("Reset");
		btnExit = new JButton("Exit");
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		pnlButton.add(btnSave);
		pnlButton.add(btnReset);
		pnlButton.add(btnExit);

		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
		btnReset.setActionCommand("reset");
		btnReset.addActionListener(this);
		btnExit.setActionCommand("exit");
		btnExit.addActionListener(this);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new StudentRegistration();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("save")) {
			save();
		}
		if (e.getActionCommand().equals("reset")) {
			reset();
		}
		if (e.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}

	private void reset() {
		txtFirstName.setText(null);
		txtLastName.setText(null);
		txtContact.setText(null);
		txtAddress.setText(null);
		txtHigh.setText(null);
		txtSpecification.setText(null);
		txtEnroll.setText(null);
		txtHobbies.setText(null);
		txtSport.setText(null);
	}

	private void save() {
		if (txtFirstName.getText().isEmpty()) {
			txtFirstName.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtFirstName.requestFocus();
		} else if (txtLastName.getText().isEmpty()) {
			txtFirstName.setBackground(Color.WHITE);
			txtLastName.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtLastName.requestFocus();
		} else if (txtContact.getText().isEmpty()) {
			txtLastName.setBackground(Color.WHITE);
			txtContact.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtContact.requestFocus();
		} else if (txtAddress.getText().isEmpty()) {
			txtContact.setBackground(Color.WHITE);
			txtAddress.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtAddress.requestFocus();
		} else if (txtHigh.getText().isEmpty()) {
			txtAddress.setBackground(Color.WHITE);
			txtHigh.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtHigh.requestFocus();
		} else if (txtSpecification.getText().isEmpty()) {
			txtHigh.setBackground(Color.WHITE);
			txtSpecification.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtSpecification.requestFocus();
		} else if (txtEnroll.getText().isEmpty()) {
			txtSpecification.setBackground(Color.WHITE);
			txtEnroll.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtEnroll.requestFocus();
		} else if (txtHobbies.getText().isEmpty()) {
			txtEnroll.setBackground(Color.WHITE);
			txtHobbies.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtHobbies.requestFocus();
		} else if (txtSport.getText().isEmpty()) {
			txtHobbies.setBackground(Color.WHITE);
			txtSport.setBackground(Color.YELLOW);
			JOptionPane.showMessageDialog(this, "Please insert text");
			txtSport.requestFocus();
		}
	}
}
