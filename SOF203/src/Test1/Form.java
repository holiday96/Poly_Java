package Test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4744398879448866169L;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JComboBox<?> cboLoaiKhachHang;
	private JLabel lblDisplay;

	private String column[] = { "Mã Khách hàng", "Tên Khách hàng", "Số điện thoại", "Email" };
	private ArrayList<String> listCombobox;
	private ArrayList<KhachHang> list;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new Form();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		cboLoaiKhachHang = new DAO().loadCombobox();
		listCombobox = new DAO().loadListNameCombobox();
		list = new DAO().getListKhachHangByFilter(cboLoaiKhachHang.getSelectedItem().toString());
		index = 0;
		initialize();
		lblDisplay.setText(listCombobox.get(cboLoaiKhachHang.getSelectedIndex()));
		fillToTable();
		lockTextfield();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		setBounds(100, 100, 527, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblLoaiKhachHang = new JLabel("Loại khách hàng");
		lblLoaiKhachHang.setBounds(12, 11, 91, 16);
		getContentPane().add(lblLoaiKhachHang);

		cboLoaiKhachHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemChange();
			}
		});
		cboLoaiKhachHang.setBounds(115, 6, 122, 26);
		getContentPane().add(cboLoaiKhachHang);

		lblDisplay = new JLabel("Display");
		lblDisplay.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDisplay.setBounds(249, 11, 122, 16);
		getContentPane().add(lblDisplay);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 378, 157);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(column, 0);
		table.setModel(model);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newKH();
			}
		});
		btnNew.setBounds(402, 39, 90, 28);
		getContentPane().add(btnNew);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveKH();
			}
		});
		btnSave.setBounds(402, 79, 90, 28);
		getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteKH();
			}
		});
		btnDelete.setBounds(402, 119, 90, 28);
		getContentPane().add(btnDelete);

		JLabel lblMaKH = new JLabel("Mã Khách hàng");
		lblMaKH.setBounds(12, 217, 95, 16);
		getContentPane().add(lblMaKH);

		JLabel lblTenKhachHang = new JLabel("Tên Khách hàng");
		lblTenKhachHang.setBounds(12, 251, 95, 16);
		getContentPane().add(lblTenKhachHang);

		txtMaKH = new JTextField();
		txtMaKH.setBounds(115, 208, 224, 28);
		getContentPane().add(txtMaKH);
		txtMaKH.setColumns(10);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(115, 242, 224, 28);
		getContentPane().add(txtTenKH);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(115, 277, 224, 28);
		getContentPane().add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(115, 317, 224, 28);
		getContentPane().add(txtEmail);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(12, 286, 95, 16);
		getContentPane().add(lblSDT);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 326, 95, 16);
		getContentPane().add(lblEmail);
	}

	protected void tableClicked() {
		lockTextfield();
		index = table.getSelectedRow();
		showDetail();
	}

	protected void itemChange() {
		lblDisplay.setText(listCombobox.get(cboLoaiKhachHang.getSelectedIndex()));
		list = new DAO().getListKhachHangByFilter(cboLoaiKhachHang.getSelectedItem().toString());
		fillToTable();
		if (list.size() > 0) {
			index = 0;
			showDetail();
		}
		lockTextfield();
	}

	protected void deleteKH() {
		if (new DAO().removeKhachHang(list.get(index).getMaKH())) {
			list = new DAO().getListKhachHangByFilter(cboLoaiKhachHang.getSelectedItem().toString());
			fillToTable();
			if (list.size() > 0) {
				index = 0;
				showDetail();
			}
			JOptionPane.showMessageDialog(this, "Delete Success!");
		} else {
			JOptionPane.showMessageDialog(this, "Delete Failed!");
		}
	}

	protected void saveKH() {
		if (validateText()) {
			KhachHang k = new KhachHang();
			k.setMaKH(txtMaKH.getText());
			k.setTenKH(txtTenKH.getText());
			k.setEmail(txtEmail.getText());
			k.setSdt(txtSDT.getText());
			k.setLoaiKH(cboLoaiKhachHang.getSelectedItem().toString());

			if (new DAO().addKhachHang(k)) {
				list = new DAO().getListKhachHangByFilter(cboLoaiKhachHang.getSelectedItem().toString());
				fillToTable();
				if (list.size() > 0) {
					index = 0;
					showDetail();
				}
				lockTextfield();
				JOptionPane.showMessageDialog(this, "Save Success!");
			} else {
				JOptionPane.showMessageDialog(this, "Save Failed!");
			}
		}
	}

	private boolean validateText() {
		StringBuilder sb = new StringBuilder();
		if (txtMaKH.getText().isBlank()) {
			sb.append("\n Mã Khách hàng trống");
		}
		if (txtTenKH.getText().isBlank()) {
			sb.append("\nTên Khách hàng trống");
		}
		if (txtSDT.getText().isBlank()) {
			sb.append("\nSĐT trống");
		}
		if (txtEmail.getText().isBlank()) {
			sb.append("\nEmail trống");
		}
		for (KhachHang k : list) {
			if (txtMaKH.getText().equalsIgnoreCase(k.getMaKH())) {
				sb.append("\nTrùng Mã Khách hàng");
			}
			if (txtSDT.getText().equalsIgnoreCase(k.getSdt())) {
				sb.append("\nTrùng SĐT");
			}
			if (txtEmail.getText().equalsIgnoreCase(k.getEmail())) {
				sb.append("\nTrùng Email");
			}
		}
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(this, sb);
			return false;
		}
		return true;
	}

	protected void newKH() {
		index = 0;
		table.clearSelection();
		txtMaKH.setText(null);
		txtTenKH.setText(null);
		txtEmail.setText(null);
		txtSDT.setText(null);
		unlockTextfield();
	}

	private void showDetail() {
		txtMaKH.setText(list.get(index).getMaKH());
		txtTenKH.setText(list.get(index).getTenKH());
		txtSDT.setText(list.get(index).getSdt());
		txtEmail.setText(list.get(index).getEmail());
	}

	private void fillToTable() {
		model.setRowCount(0);
		for (KhachHang k : list) {
			model.addRow(new Object[] { k.getMaKH(), k.getTenKH(), k.getSdt(), k.getEmail() });
		}
	}

	private void lockTextfield() {
		txtEmail.setEnabled(false);
		txtTenKH.setEnabled(false);
		txtMaKH.setEnabled(false);
		txtSDT.setEnabled(false);
	}

	private void unlockTextfield() {
		txtEmail.setEnabled(true);
		txtTenKH.setEnabled(true);
		txtMaKH.setEnabled(true);
		txtSDT.setEnabled(true);
	}
}
