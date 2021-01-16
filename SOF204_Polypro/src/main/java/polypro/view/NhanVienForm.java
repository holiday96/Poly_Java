package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import polypro.model.NhanVienModel;
import polypro.service.INhanVienService;
import polypro.service.impl.NhanVienService;

public class NhanVienForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable tblDanhSach;
	private String column[] = { "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ" };
	private DefaultTableModel model;
	private JTextField txtMaNV;
	private JPasswordField txtMatKhau;
	private JTextField txtHoTen;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnBegin;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnEnd;
	private JRadioButton rdoNhanVien;
	private JRadioButton rdoTruongPhong;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private List<NhanVienModel> list;
	private int index;

	private INhanVienService nhanVienSevice = new NhanVienService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new NhanVienForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NhanVienForm() {
		initialize();
		index = 0;
		loadToTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/User group.png")));
		setVisible(true);
		setBounds(100, 100, 620, 398);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Quản lý nhân viên");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setBounds(6, 6, 159, 20);
		getContentPane().add(lblTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 27, 590, 330);
		getContentPane().add(tabbedPane);

		model = new DefaultTableModel(column, 0);

		JLayeredPane lypDanhSach = new JLayeredPane();
		tabbedPane.addTab("DANH SÁCH", null, lypDanhSach, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 590, 302);
		lypDanhSach.add(scrollPane);
		tblDanhSach = new JTable(model);
		tblDanhSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDanhSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		scrollPane.setViewportView(tblDanhSach);

		JLayeredPane lypCapNhat = new JLayeredPane();
		tabbedPane.addTab("CẬP NHẬT", null, lypCapNhat, null);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setBounds(9, 6, 75, 16);
		lypCapNhat.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtMaNV.setBackground(null);
			}
		});
		txtMaNV.setBounds(6, 23, 280, 28);
		lypCapNhat.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setBounds(303, 6, 80, 16);
		lypCapNhat.add(lblMatKhau);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(300, 23, 280, 28);
		lypCapNhat.add(txtMatKhau);

		txtHoTen = new JTextField();
		txtHoTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtHoTen.setBackground(null);
			}
		});
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(6, 73, 280, 28);
		lypCapNhat.add(txtHoTen);

		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setBounds(9, 54, 90, 16);
		lypCapNhat.add(lblHoTen);

		JLabel lblVaiTro = new JLabel("Vai trò");
		lblVaiTro.setBounds(303, 54, 75, 16);
		lypCapNhat.add(lblVaiTro);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnAdd.setBounds(6, 266, 60, 28);
		lypCapNhat.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});
		btnUpdate.setBounds(72, 266, 60, 28);
		lypCapNhat.add(btnUpdate);

		btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		btnDelete.setBounds(138, 266, 60, 28);
		lypCapNhat.add(btnDelete);

		btnClear = new JButton("Mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew();
			}
		});
		btnClear.setBounds(204, 266, 60, 28);
		lypCapNhat.add(btnClear);

		btnBegin = new JButton("|<");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin();
			}
		});
		btnBegin.setBounds(387, 266, 45, 28);
		lypCapNhat.add(btnBegin);

		btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBack();
			}
		});
		btnBack.setBounds(435, 266, 45, 28);
		lypCapNhat.add(btnBack);

		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext();
			}
		});
		btnNext.setBounds(485, 266, 45, 28);
		lypCapNhat.add(btnNext);

		btnEnd = new JButton(">|");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnd();
			}
		});
		btnEnd.setBounds(535, 266, 45, 28);
		lypCapNhat.add(btnEnd);

		rdoNhanVien = new JRadioButton("Nhân viên");
		buttonGroup.add(rdoNhanVien);
		rdoNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNhanVien.setBounds(300, 76, 81, 25);
		lypCapNhat.add(rdoNhanVien);

		rdoTruongPhong = new JRadioButton("Trưởng phòng");
		buttonGroup.add(rdoTruongPhong);
		rdoTruongPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoTruongPhong.setBounds(387, 75, 109, 23);
		lypCapNhat.add(rdoTruongPhong);

		disableFunction();
	}

	protected void btnUpdate() {
		if (validatedIgnoreMaNVKey()) {
			NhanVienModel nhanVienModel = new NhanVienModel();
			nhanVienModel.setMaNV(txtMaNV.getText());
			nhanVienModel.setMatKhau(String.valueOf(txtMatKhau.getPassword()));
			nhanVienModel.setHoTen(txtHoTen.getText());
			nhanVienModel.setVaiTro((rdoTruongPhong.isSelected()) ? true : false);
			nhanVienSevice.update(nhanVienModel, list.get(index).getMaNV());

			clear();
			loadToTable();
		}
	}

	protected void btnDelete() {
		if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá nhân viên có Mã NV:  " + list.get(index).getMaNV(), "Xoá",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			nhanVienSevice.delete(list.get(index));
			loadToTable();

			disableFunction();
			clear();
		}
	}

	protected void btnEnd() {
		index = list.size() - 1;
		tblDanhSach.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnNext() {
		index++;
		tblDanhSach.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBack() {
		index--;
		tblDanhSach.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBegin() {
		index = 0;
		tblDanhSach.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void tableClicked() {
		index = tblDanhSach.getSelectedRow();
		showDetail();
		checkPositionInTable();

		btnAdd.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		txtMaNV.setEnabled(true);
		txtMatKhau.setEnabled(true);
		txtHoTen.setEnabled(true);
		rdoTruongPhong.setEnabled(true);
		rdoNhanVien.setEnabled(true);
	}

	private void showDetail() {
		txtMaNV.setText(list.get(index).getMaNV());
		txtMatKhau.setText(list.get(index).getMatKhau());
		txtHoTen.setText(list.get(index).getHoTen());
		if (list.get(index).isVaiTro()) {
			rdoTruongPhong.setSelected(true);
		} else {
			rdoNhanVien.setSelected(true);
		}
	}

	private void loadToTable() {
		try {
			list = nhanVienSevice.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setRowCount(0);
		for (NhanVienModel i : list) {
			model.addRow(new Object[] { i.getMaNV(), convertToTextPass(i.getMatKhau()), i.getHoTen(),
					(i.isVaiTro()) ? "Trưởng phòng" : "Nhân viên" });
		}
	}

	private StringBuilder convertToTextPass(String text) {
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			pass.append("*");
		}
		return pass;
	}

	private void checkPositionInTable() {
		if (list.size() > 1) {
			if (index == 0) {
				btnBegin.setEnabled(false);
				btnBack.setEnabled(false);
				btnNext.setEnabled(true);
				btnEnd.setEnabled(true);
			}
			if (index > 0 && index < list.size() - 1) {
				btnBegin.setEnabled(true);
				btnBack.setEnabled(true);
				btnNext.setEnabled(true);
				btnEnd.setEnabled(true);
			}
			if (index == list.size() - 1) {
				btnBegin.setEnabled(true);
				btnBack.setEnabled(true);
				btnNext.setEnabled(false);
				btnEnd.setEnabled(false);
			}
		}
	}

	protected void btnNew() {
		// Enable text & button
		btnAdd.setEnabled(true);
		txtMaNV.setEnabled(true);
		txtMatKhau.setEnabled(true);
		txtHoTen.setEnabled(true);
		rdoNhanVien.setEnabled(true);
		rdoTruongPhong.setEnabled(true);

		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);
		tblDanhSach.clearSelection();

		clear();
	}

	private void clear() {
		txtMaNV.setText("");
		txtMatKhau.setText("");
		txtHoTen.setText("");
		rdoNhanVien.setSelected(true);
		rdoTruongPhong.setSelected(false);
		txtMaNV.setBackground(null);
		txtMatKhau.setBackground(null);
		txtHoTen.setBackground(null);
	}

	private void disableFunction() {
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);
		txtMaNV.setEnabled(false);
		txtMatKhau.setEnabled(false);
		txtHoTen.setEnabled(false);
		rdoNhanVien.setEnabled(false);
		rdoTruongPhong.setEnabled(false);
		txtMaNV.setBackground(null);
		txtMatKhau.setBackground(null);
		txtHoTen.setBackground(null);

	}

	public static boolean validateLetters(String txt) {
		String regx = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txt);
		return matcher.find();
	}

	private boolean validated() {
		StringBuilder message = new StringBuilder();
		if (txtMaNV.getText().isBlank()) {
			message.append("\nMã nhân viên trống");
			txtMaNV.setBackground(Color.decode("#f38aff"));
			txtMaNV.requestFocus();
		} else {
			for (NhanVienModel i : list) {
				if (txtMaNV.getText().equalsIgnoreCase(i.getMaNV())) {
					message.append("\nMã nhân viên đã tồn tại");
					txtMaNV.setBackground(Color.decode("#ff96a6"));
					txtMaNV.requestFocus();
					break;
				}
			}
		}
		if (String.valueOf(txtMatKhau.getPassword()).isBlank()) {
			message.append("\nMật khẩu trống");
			txtMatKhau.setBackground(Color.decode("#f38aff"));
			txtMatKhau.requestFocus();
		}
		if (txtHoTen.getText().isBlank()) {
			message.append("\nHọ và tên trống");
			txtHoTen.setBackground(Color.decode("#f38aff"));
			txtHoTen.requestFocus();
		} else if (!validateLetters(txtHoTen.getText())) {
			message.append("\nHọ tên không hợp lệ");
			txtHoTen.setBackground(Color.decode("#ff96a6"));
			txtHoTen.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(btnAdd, message);
			return false;
		}
	}
	
	private boolean validatedIgnoreMaNVKey() {
		StringBuilder message = new StringBuilder();
		if (txtMaNV.getText().isBlank()) {
			message.append("\nMã nhân viên trống");
			txtMaNV.setBackground(Color.decode("#f38aff"));
			txtMaNV.requestFocus();
		}
		if (String.valueOf(txtMatKhau.getPassword()).isBlank()) {
			message.append("\nMật khẩu trống");
			txtMatKhau.setBackground(Color.decode("#f38aff"));
			txtMatKhau.requestFocus();
		}
		if (txtHoTen.getText().isBlank()) {
			message.append("\nHọ và tên trống");
			txtHoTen.setBackground(Color.decode("#f38aff"));
			txtHoTen.requestFocus();
		} else if (!validateLetters(txtHoTen.getText())) {
			message.append("\nHọ tên không hợp lệ");
			txtHoTen.setBackground(Color.decode("#ff96a6"));
			txtHoTen.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(btnAdd, message);
			return false;
		}
	}

	protected void btnAdd() {
		if (validated()) {
			NhanVienModel nhanVienModel = new NhanVienModel();
			nhanVienModel.setMaNV(txtMaNV.getText());
			nhanVienModel.setMatKhau(String.valueOf(txtMatKhau.getPassword()));
			nhanVienModel.setHoTen(txtHoTen.getText());
			nhanVienModel.setVaiTro((rdoTruongPhong.isSelected()) ? true : false);
			nhanVienSevice.save(nhanVienModel);

			clear();
			loadToTable();
		}
	}
}
