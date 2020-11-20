package Lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416147677938823914L;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextArea txtAdress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	private ArrayList<Student> list;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new UserManagement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserManagement() {
		initialize();
		list = new DAO().getListStudent();
		index = 0;
		try {
			showInfo(index);
		} catch (NullPointerException e) {
			
		}
		showInfo(index);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 384);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Quản lý Users");

		JLabel lblTitle = new JLabel("Quản lý Users");
		lblTitle.setForeground(new Color(65, 105, 225));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblID = new JLabel("Mã SV:");
		lblID.setBounds(40, 18, 37, 16);
		panel.add(lblID);

		txtID = new JTextField();
		txtID.setBounds(110, 12, 122, 28);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblName = new JLabel("Họ tên:");
		lblName.setBounds(40, 52, 39, 16);
		panel.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(110, 46, 122, 28);
		panel.add(txtName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 86, 32, 16);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(110, 80, 122, 28);
		panel.add(txtEmail);

		JLabel lblPhone = new JLabel("Số ĐT:");
		lblPhone.setBounds(40, 120, 37, 16);
		panel.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(110, 114, 122, 28);
		panel.add(txtPhone);

		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setBounds(40, 155, 49, 16);
		panel.add(lblGender);

		rdbtnMale = new JRadioButton("Nam");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(110, 154, 49, 18);
		panel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Nữ");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(170, 154, 39, 18);
		panel.add(rdbtnFemale);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 184, 238, 75);
		panel.add(scrollPane);

		txtAdress = new JTextArea();
		scrollPane.setViewportView(txtAdress);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setBounds(258, 12, 90, 28);
		panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(258, 46, 90, 28);
		panel.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(258, 80, 90, 28);
		panel.add(btnUpdate);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(258, 114, 90, 28);
		panel.add(btnSave);

		JButton btnBegin = new JButton("Begin");
		btnBegin.setBounds(110, 269, 60, 28);
		panel.add(btnBegin);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(177, 269, 55, 28);
		panel.add(btnBack);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(238, 269, 52, 28);
		panel.add(btnNext);

		JButton btnEnd = new JButton("End");
		btnEnd.setBounds(298, 269, 50, 28);
		panel.add(btnEnd);

		JLabel lblAdress = new JLabel("Địa chỉ:");
		lblAdress.setBounds(40, 193, 41, 16);
		panel.add(lblAdress);
	}

	private void add() {
		Student s = new Student();
		s.setMaSV(txtID.getText());
		s.setHoTen(txtName.getText());
		s.setEmail(txtEmail.getText());
		if (rdbtnMale.isSelected()) {
			s.setGioiTinh(true);
		} else if (rdbtnFemale.isSelected()) {
			s.setGioiTinh(false);
		}
		s.setSdt(txtPhone.getText());
		s.setDiaChi(txtAdress.getText());
		list.add(s);
		if (new DAO().addStudent(s)) {
			JOptionPane.showMessageDialog(this, "Success");
		} else {
			JOptionPane.showMessageDialog(this, "Failed");
		}
	}

	private void showInfo(int index) {
		txtID.setText(list.get(index).getMaSV());
		txtName.setText(list.get(index).getHoTen());
		txtEmail.setText(list.get(index).getEmail());
		if (list.get(index).isGioiTinh()) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}
		txtPhone.setText(list.get(index).getSdt());
		txtAdress.setText(list.get(index).getDiaChi());
	}
}
