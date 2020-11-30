package Lab6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookInformationV2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1059403393966735639L;
	private JTable table;
	private JTextField txtName;
	private JTextField txtParentName;
	private JTextField txtContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new BookInformationV2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookInformationV2() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 607, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Book Information Ver 2.0");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 256, 299);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(350, 35, 231, 67);
		getContentPane().add(txtAddress);
		
		txtParentName = new JTextField();
		txtParentName.setBounds(350, 102, 231, 28);
		getContentPane().add(txtParentName);
		txtParentName.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(350, 131, 77, 28);
		getContentPane().add(txtContact);
		
		JComboBox cboStandard = new JComboBox();
		cboStandard.setBounds(350, 164, 157, 26);
		getContentPane().add(cboStandard);
		
		JComboBox cboFees = new JComboBox();
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
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newClicked();
			}
		});
		btnNew.setBounds(274, 224, 76, 28);
		getContentPane().add(btnNew);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertClicked();
			}
		});
		btnInsert.setBounds(351, 224, 76, 28);
		getContentPane().add(btnInsert);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextClicked();
			}
		});
		btnNext.setBounds(274, 258, 76, 28);
		getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousClicked();
			}
		});
		btnPrevious.setBounds(351, 258, 76, 28);
		getContentPane().add(btnPrevious);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editClicked();
			}
		});
		btnEdit.setBounds(428, 224, 76, 28);
		getContentPane().add(btnEdit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateClicked();
			}
		});
		btnUpdate.setBounds(505, 224, 76, 28);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
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
	
	protected void exitClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void updateClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void editClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void previousClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void nextClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void insertClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void newClicked() {
		// TODO Auto-generated method stub
		
	}
}
