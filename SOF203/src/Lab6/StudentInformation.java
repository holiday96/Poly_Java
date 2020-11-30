package Lab6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class StudentInformation extends JFrame {
	private static final long serialVersionUID = -1059403393966735639L;
	private JTable table;
	private JTextField txtName;
	private JTextField txtParentName;
	private JTextField txtContact;
	private JTextArea txtAddress;
	private DefaultTableModel model;
	private JComboBox<String> cboStandard;
	private JComboBox<Integer> cboFees;
	private String column[] = { "Name", "Standard" };
	private JButton btnNew;
	private JButton btnInsert;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnEdit;
	private JButton btnUpdate;
	private JButton btnDelete;

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
					new StudentInformation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInformation() {
		initialize();

		index = 0;
		btnPrevious.setEnabled(false);
		try {
			list = new StudentDAO().getListStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new StudentDAO().loadComboBoxStandard(cboStandard, cboFees);
		fillToTable();
		
		table.setRowSelectionInterval(index, index);
		disableInput();
		showDetail();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 607, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Student Information Ver 2.0");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 256, 299);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableInput();
				index = table.getSelectedRow();
				showDetail();
				setEnabledPrevNext();
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(column, 0);
		table.setModel(model);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(305, 12, 40, 16);
		getContentPane().add(lblName);

		txtName = new JTextField();
		txtName.setBounds(350, 6, 231, 28);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(293, 41, 52, 16);
		getContentPane().add(lblAddress);

		txtAddress = new JTextArea();
		txtAddress.setBounds(350, 35, 231, 67);
		getContentPane().add(txtAddress);

		txtParentName = new JTextField();
		txtParentName.setBounds(350, 102, 231, 28);
		getContentPane().add(txtParentName);
		txtParentName.setColumns(10);

		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(350, 131, 112, 28);
		getContentPane().add(txtContact);

		cboStandard = new JComboBox<String>();
		cboStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				standardSelected();
			}
		});
		cboStandard.setBounds(350, 164, 157, 26);
		getContentPane().add(cboStandard);

		cboFees = new JComboBox<Integer>();
		cboFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feesSelected();
			}
		});
		cboFees.setBounds(350, 195, 157, 26);
		getContentPane().add(cboFees);

		JLabel lblParentName = new JLabel("Parent Name");
		lblParentName.setBounds(266, 108, 79, 16);
		getContentPane().add(lblParentName);

		JLabel lblContact = new JLabel("Contact No.");
		lblContact.setBounds(274, 137, 71, 16);
		getContentPane().add(lblContact);

		JLabel lblStandard = new JLabel("Standard");
		lblStandard.setBounds(288, 169, 57, 16);
		getContentPane().add(lblStandard);

		JLabel lblFees = new JLabel("Fees");
		lblFees.setBounds(311, 200, 34, 16);
		getContentPane().add(lblFees);

		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newClicked();
			}
		});
		btnNew.setBounds(274, 224, 76, 28);
		getContentPane().add(btnNew);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertClicked();
			}
		});
		btnInsert.setBounds(351, 224, 76, 28);
		getContentPane().add(btnInsert);

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextClicked();
			}
		});
		btnNext.setBounds(351, 258, 76, 28);
		getContentPane().add(btnNext);

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousClicked();
			}
		});
		btnPrevious.setBounds(274, 258, 76, 28);
		getContentPane().add(btnPrevious);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editClicked();
			}
		});
		btnEdit.setBounds(428, 224, 76, 28);
		getContentPane().add(btnEdit);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateClicked();
			}
		});
		btnUpdate.setBounds(505, 224, 76, 28);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteClicked();
			}
		});
		btnDelete.setBounds(428, 258, 76, 28);
		getContentPane().add(btnDelete);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitClicked();
			}
		});
		btnExit.setBounds(505, 258, 76, 28);
		getContentPane().add(btnExit);
	}

	private void feesSelected() {
		if (cboFees.getSelectedIndex() != 0) {
			cboStandard.setSelectedIndex(cboFees.getSelectedIndex());
		}
	}

	private void standardSelected() {
		if (cboStandard.getSelectedIndex() != 0) {
			cboFees.setSelectedIndex(cboStandard.getSelectedIndex());
		}
	}

	private void exitClicked() {
		System.exit(0);
	}

	private void deleteClicked() {
		if (new StudentDAO().deleteStudent(list.get(index).getId())) {
			JOptionPane.showMessageDialog(this, "Xoá thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Xoá thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
		}
		fillToTable();
	}

	private void updateClicked() {
		if (validated()) {
			Student s = new Student();
			s.setName(txtName.getText());
			s.setAddress(txtAddress.getText());
			s.setParentName(txtParentName.getText());
			s.setPhone(txtContact.getText());
			s.setStan((String) cboStandard.getSelectedItem());

			if (new StudentDAO().updateStudent(list.get(index).getId(), s)) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại", "Failed!", JOptionPane.ERROR_MESSAGE);
			}
		}
		fillToTable();
		disableInput();
	}

	private void editClicked() {
		enableInput();
		btnInsert.setEnabled(false);
	}

	private void setEnabledPrevNext() {
		if (index == 0) {
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(true);
		} else if (index == list.size() - 1) {
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(false);
		} else {
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
	}

	private void previousClicked() {
		disableInput();
		if (index != 0) {
			index--;
			table.setRowSelectionInterval(index, index);
			showDetail();
		}
		setEnabledPrevNext();
	}

	private void nextClicked() {
		disableInput();
		if (index != list.size() - 1) {
			index++;
			table.setRowSelectionInterval(index, index);
			showDetail();
		}
		setEnabledPrevNext();
	}

	private void insertClicked() {
		if (validated()) {
			Student s = new Student();
			s.setName(txtName.getText());
			s.setAddress(txtAddress.getText());
			s.setParentName(txtParentName.getText());
			s.setPhone(txtContact.getText());
			s.setStan((String) cboStandard.getSelectedItem());

			if (new StudentDAO().addStudent(s)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại", "Failed!", JOptionPane.ERROR_MESSAGE);
			}
		}
		fillToTable();
		disableInput();
	}

	private boolean validated() {
		StringBuilder sb = new StringBuilder();
		if (txtName.getText().isBlank()) {
			sb.append("\nTên trống");
			txtName.requestFocus();
		}
		if (txtAddress.getText().isBlank()) {
			sb.append("\nĐịa chỉ trống");
		}
		if (txtParentName.getText().isBlank()) {
			sb.append("\nHọ tên cha/mẹ trống");
		}
		if (txtContact.getText().isBlank()) {
			sb.append("\nSố liên lạc trống");
		}
		if (sb.length() != 0) {
			JOptionPane.showMessageDialog(this, sb);
			return false;
		}
		return true;
	}

	private void newClicked() {
		enableInput();
		txtName.setText(null);
		txtContact.setText(null);
		txtParentName.setText(null);
		txtAddress.setText(null);
		cboFees.setSelectedIndex(0);
		cboStandard.setSelectedIndex(0);
		btnNext.setEnabled(true);
		btnPrevious.setEnabled(true);
		btnUpdate.setEnabled(false);
		table.clearSelection();
	}

	private void fillToTable() {
		model.setRowCount(0);
		list = new StudentDAO().getListStudent();
		for (Student s : list) {
			model.addRow(new Object[] { s.getName(), s.getStan() });
		}
	}

	private void showDetail() {
		txtName.setText(list.get(index).getName());
		txtAddress.setText(list.get(index).getAddress());
		txtContact.setText(list.get(index).getPhone());
		txtParentName.setText(list.get(index).getParentName());
		cboStandard.setSelectedItem(list.get(index).getStan());
	}

	private void disableInput() {
		txtName.setEnabled(false);
		txtContact.setEnabled(false);
		txtParentName.setEnabled(false);
		txtAddress.setEnabled(false);
		cboFees.setEnabled(false);
		cboStandard.setEnabled(false);
		btnInsert.setEnabled(false);
		btnUpdate.setEnabled(false);
	}

	private void enableInput() {
		txtName.setEnabled(true);
		txtContact.setEnabled(true);
		txtParentName.setEnabled(true);
		txtAddress.setEnabled(true);
		cboFees.setEnabled(true);
		cboStandard.setEnabled(true);
		btnInsert.setEnabled(true);
		btnUpdate.setEnabled(true);
	}
}
