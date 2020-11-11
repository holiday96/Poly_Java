package Lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class StudentDetail {

	private JFrame frmStudentDetail;
	private JTextField txtName;
	private JPanel pnlSex;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextArea txtAddress;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQualification;
	private JPanel pnlHobby;
	private JCheckBox chckbxReading;
	private JCheckBox chckbxSinging;
	private JCheckBox chckbxDancing;
	private JButton btnValidate;
	private JButton btnReset;
	JLabel lblName;
	JLabel lblAddress;
	JLabel lblSex;
	JLabel lblQualification;
	JLabel lblHobby;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					StudentDetail window = new StudentDetail();
					window.frmStudentDetail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentDetail() {
		initialize();
		frmStudentDetail.setLocationRelativeTo(null);
		frmStudentDetail.getContentPane().setLayout(null);

		lblName = new JLabel("Name:");
		lblName.setBounds(6, 19, 37, 16);
		frmStudentDetail.getContentPane().add(lblName);

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 74, 49, 16);
		frmStudentDetail.getContentPane().add(lblAddress);

		lblSex = new JLabel("Sex:");
		lblSex.setBounds(6, 142, 23, 16);
		frmStudentDetail.getContentPane().add(lblSex);

		lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(240, 19, 71, 16);
		frmStudentDetail.getContentPane().add(lblQualification);

		lblHobby = new JLabel("Hobby:");
		lblHobby.setBounds(240, 74, 38, 16);
		frmStudentDetail.getContentPane().add(lblHobby);

		pnlSex = new JPanel();
		pnlSex.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlSex.setBounds(78, 127, 117, 90);
		frmStudentDetail.getContentPane().add(pnlSex);
		pnlSex.setLayout(null);

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(6, 17, 48, 18);
		pnlSex.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(6, 47, 64, 18);
		pnlSex.add(rdbtnFemale);

		txtAddress = new JTextArea();
		txtAddress.setBounds(75, 68, 153, 47);
		frmStudentDetail.getContentPane().add(txtAddress);

		txtName = new JTextField();
		txtName.setBounds(78, 13, 117, 28);
		frmStudentDetail.getContentPane().add(txtName);
		txtName.setColumns(10);

		cboQualification = new JComboBox();
		cboQualification.setModel(new DefaultComboBoxModel(new String[] { "Graduate" }));
		cboQualification.setBounds(316, 14, 112, 26);
		frmStudentDetail.getContentPane().add(cboQualification);

		pnlHobby = new JPanel();
		pnlHobby.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlHobby.setBounds(301, 68, 90, 86);
		frmStudentDetail.getContentPane().add(pnlHobby);

		chckbxReading = new JCheckBox("Reading");
		chckbxReading.setBounds(6, 6, 69, 18);

		chckbxSinging = new JCheckBox("Singing");
		chckbxSinging.setBounds(6, 29, 64, 18);

		chckbxDancing = new JCheckBox("Dancing");
		chckbxDancing.setBounds(6, 52, 68, 18);
		pnlHobby.setLayout(null);
		pnlHobby.add(chckbxReading);
		pnlHobby.add(chckbxSinging);
		pnlHobby.add(chckbxDancing);

		btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validate();
			}
		});
		btnValidate.setBounds(122, 227, 72, 28);
		frmStudentDetail.getContentPane().add(btnValidate);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(206, 227, 61, 28);
		frmStudentDetail.getContentPane().add(btnReset);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentDetail = new JFrame();
		frmStudentDetail.setTitle("Student Detail");
		frmStudentDetail.setBounds(100, 100, 450, 300);
		frmStudentDetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void validate() {
		StringBuilder sb = new StringBuilder();
		String str = "";
		// Name
		if (txtName.getText().isBlank()) {
			sb.append("Name empty\n");
			txtName.setBackground(Color.YELLOW);
		} else {
			str += "\n" + lblName.getText() + " " + txtName.getText();
			txtName.setBackground(null);
		}

		// Address
		if (txtAddress.getText().isBlank()) {
			sb.append("Adress empty\n");
			txtAddress.setBackground(Color.YELLOW);
		} else {
			str += lblAddress.getText() + " " + txtAddress.getText();
			txtAddress.setBackground(null);
		}

		// Sex
		if (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) {
			sb.append("Sex is not selected\n");
			pnlSex.setBackground(Color.YELLOW);
		} else {
			str += "\n" + lblSex.getText() + " ";
			if (rdbtnMale.isSelected()) {
				str += rdbtnMale.getText();
			} else {
				str += rdbtnFemale.getText();
			}
			pnlSex.setBackground(null);
		}
		// Qualification
		str += "\n" + lblQualification.getText() + " " + cboQualification.getSelectedItem().toString();

		// Hobby
		if (!chckbxReading.isSelected() && !chckbxSinging.isSelected() && !chckbxDancing.isSelected()) {
			sb.append("Hobby is not selected\n");
			pnlHobby.setBackground(Color.YELLOW);
		} else {
			str += "\n" + lblHobby.getText() + " ";
			if (chckbxReading.isSelected()) {
				str += chckbxReading.getText() + "\n";
			}
			if (chckbxSinging.isSelected()) {
				str += chckbxSinging.getText() + "\n";
			}
			if (chckbxDancing.isSelected()) {
				str += chckbxDancing.getText() + "\n";
			}
			pnlHobby.setBackground(null);
		}

		// showMessage
		if (!String.valueOf(sb).isBlank()) {
			JOptionPane.showMessageDialog(btnValidate, sb);
		} else {
			JOptionPane.showMessageDialog(btnValidate, str);
		}
	}

	private void reset() {
		txtName.setText(null);
		txtAddress.setText(null);
		chckbxDancing.setSelected(false);
		chckbxReading.setSelected(false);
		chckbxSinging.setSelected(false);
		buttonGroup.clearSelection();
	}
}
