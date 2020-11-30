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
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class UserManagement extends JFrame implements ActionListener {

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
	private JButton btnBegin;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnEnd;

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
		index = 0;
		try {
			list = new DAO().getListStudent();
			showInfo(index);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
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
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/images/add.png")));
			}
		});
		btnAdd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/images/add_hover.png")));
			}
		});
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/images/add.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAdd.setBounds(258, 12, 109, 28);
		panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setIcon(new ImageIcon(this.getClass().getResource("/images/delete.png")));
			}
		});
		btnDelete.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnDelete.setIcon(new ImageIcon(this.getClass().getResource("/images/delete_hover.png")));
			}
		});
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setIcon(new ImageIcon(this.getClass().getResource("/images/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				reset();
				list = new DAO().getListStudent();
			}
		});
		btnDelete.setBounds(258, 46, 109, 28);
		panel.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/images/write.png")));
			}
		});
		btnUpdate.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/images/write_hover.png")));
			}
		});
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/images/write.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(258, 80, 109, 28);
		panel.add(btnUpdate);

		JButton btnSave = new JButton("Save");
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
				list = new DAO().getListStudent();
			}
		});
		btnSave.setBounds(258, 114, 109, 28);
		panel.add(btnSave);

		btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				begin();
			}
		});
		btnBegin.setBounds(110, 269, 60, 28);
		panel.add(btnBegin);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnBack.setBounds(177, 269, 55, 28);
		panel.add(btnBack);

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setBounds(238, 269, 53, 28);
		panel.add(btnNext);

		btnEnd = new JButton("End");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end();
			}
		});
		btnEnd.setBounds(298, 269, 50, 28);
		panel.add(btnEnd);

		JLabel lblAdress = new JLabel("Địa chỉ:");
		lblAdress.setBounds(40, 193, 41, 16);
		panel.add(lblAdress);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnNewButton.setToolTipText("Find by id student");
		btnNewButton.setIcon(new ImageIcon(UserManagement.class.getResource("/images/2.png")));
		btnNewButton.setBounds(40, 216, 43, 43);
		panel.add(btnNewButton);
	}

	private void find() {
		String str = JOptionPane.showInputDialog("Mã Sinh viên cần tìm: ");
		Student s = new DAO().findById(str);
		if (!str.isBlank()) {
			if (s.getMaSV() == null) {
				JOptionPane.showMessageDialog(this, "Not found");
			} else {
				JOptionPane.showMessageDialog(this, s.toString());
			}
		}
	}

	private void reset() {
		txtAdress.setText(null);
		txtEmail.setText(null);
		txtID.setText(null);
		txtName.setText(null);
		txtPhone.setText(null);
	}

	private void begin() {
		index = 0;
		showInfo(index);
	}

	private void end() {
		index = list.size() - 1;
		showInfo(index);
	}

	private void back() {
		if (index > 0) {
			index--;
			showInfo(index);
		}
	}

	private void next() {
		if (index < list.size() - 1) {
			index++;
			showInfo(index);
		}
	}

	protected void update() {
		Student snew = new Student();
		Student salt = list.get(index);
		if (txtID.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Mã Sinh viên trống");
		} else {
			snew.setMaSV(txtID.getText());
			snew.setHoTen(txtName.getText());
			snew.setEmail(txtEmail.getText());
			if (rdbtnMale.isSelected()) {
				snew.setGioiTinh(true);
			} else if (rdbtnFemale.isSelected()) {
				snew.setGioiTinh(false);
			}
			snew.setSdt(txtPhone.getText());
			snew.setDiaChi(txtAdress.getText());
			if (new DAO().updateStudent(snew, salt)) {
				JOptionPane.showMessageDialog(this, "Success");
				reset();
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		}
	}

	protected void delete() {
		Student s = list.get(index);
		if (new DAO().deleteStudent(s)) {
			JOptionPane.showMessageDialog(this, "Success");
		} else {
			JOptionPane.showMessageDialog(this, "Failed");
		}
	}

	private void add() {
		Student s = new Student();
		if (txtID.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Mã Sinh viên trống");
		} else {
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
