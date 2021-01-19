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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import polypro.model.NguoiHocModel;
import polypro.model.NhanVienModel;
import polypro.service.INguoiHocService;
import polypro.service.impl.NguoiHocService;

public class NguoiHocForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable table;
	private String column[] = { "MÃ NH", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL", "MÃ NV",
			"NGÀY ĐK" };
	private DefaultTableModel model;
	private JTextField txtMaNH;
	private JTextField txtHoTen;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JTextField txtNgaySinh;
	private JTextField txtDienThoai;
	private JTextField txtEmail;
	private JTextArea txtGhiChu;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnBegin;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnEnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int index;
	private List<NguoiHocModel> list;
	private NhanVienModel nhanVien;

	private INguoiHocService nguoiHocService = new NguoiHocService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new NguoiHocForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NguoiHocForm() {
		nhanVien = LoginForm.nhanVien;

		initialize();
		try {
			index = 0;
			list = nguoiHocService.findAll();
			loadToTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadToTable() {
		model.setRowCount(0);
		for (NguoiHocModel i : list) {
			model.addRow(new Object[] { i.getMaNH(), i.getHoTen(), (i.isGioiTinh()) ? "Nam" : "Nữ",
					new SimpleDateFormat("dd/MM/yyyy").format(i.getNgaySinh()), i.getDienThoai(), i.getEmail(),
					i.getMaNV(), new SimpleDateFormat("dd/MM/yyyy").format(i.getNgayDK()) });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Conference.png")));
		setVisible(true);
		setBounds(100, 100, 615, 540);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Quản lý khoá học");
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 31, 587, 452);
		getContentPane().add(tabbedPane);

		JPanel pnlDanhSach = new JPanel();
		tabbedPane.addTab("DANH SÁCH", null, pnlDanhSach, null);
		pnlDanhSach.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 67, 587, 355);
		pnlDanhSach.add(scrollPane);

		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		scrollPane.setViewportView(table);

		JPanel pnlFind = new JPanel();
		pnlFind.setBounds(0, 6, 587, 63);
		pnlDanhSach.add(pnlFind);
		pnlFind.setBorder(new TitledBorder(null, "T\u00CCM KI\u1EBEM", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlFind.setLayout(null);

		JTextField txtFind = new JTextField();
		txtFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				findKeyPressed();
			}
		});
		txtFind.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtFind.setBounds(14, 18, 561, 30);
		pnlFind.add(txtFind);

		JPanel pnlCapNhat = new JPanel();
		tabbedPane.addTab("CẬP NHẬT", null, pnlCapNhat, null);
		pnlCapNhat.setLayout(null);

		JLabel lblMaNH = new JLabel("Mã người học");
		lblMaNH.setBounds(6, 6, 75, 16);
		pnlCapNhat.add(lblMaNH);

		txtMaNH = new JTextField("");
		txtMaNH.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtMaNH.setForeground(new Color(0, 0, 0));
		txtMaNH.setBounds(6, 28, 575, 26);
		pnlCapNhat.add(txtMaNH);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(6, 132, 59, 16);
		pnlCapNhat.add(lblGioiTinh);

		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setBounds(6, 184, 59, 16);
		pnlCapNhat.add(lblDienThoai);

		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(6, 204, 296, 28);
		pnlCapNhat.add(txtDienThoai);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setBounds(6, 244, 59, 16);
		pnlCapNhat.add(lblGhiChu);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 264, 575, 112);
		pnlCapNhat.add(scrollPane_1);

		txtGhiChu = new JTextArea();
		scrollPane_1.setViewportView(txtGhiChu);
		txtGhiChu.setColumns(10);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnAdd.setBounds(6, 388, 60, 28);
		pnlCapNhat.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(72, 388, 60, 28);
		pnlCapNhat.add(btnUpdate);

		btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(138, 388, 60, 28);
		pnlCapNhat.add(btnDelete);

		btnClear = new JButton("Mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew();
			}
		});
		btnClear.setBounds(204, 388, 60, 28);
		pnlCapNhat.add(btnClear);

		btnBegin = new JButton("|<");
		btnBegin.setBounds(387, 388, 45, 28);
		pnlCapNhat.add(btnBegin);

		btnBack = new JButton("<<");
		btnBack.setBounds(435, 388, 45, 28);
		pnlCapNhat.add(btnBack);

		btnNext = new JButton(">>");
		btnNext.setBounds(485, 388, 45, 28);
		pnlCapNhat.add(btnNext);

		btnEnd = new JButton(">|");
		btnEnd.setBounds(535, 388, 45, 28);
		pnlCapNhat.add(btnEnd);

		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setBounds(6, 66, 59, 16);
		pnlCapNhat.add(lblHoTen);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(6, 88, 575, 28);
		pnlCapNhat.add(txtHoTen);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(314, 132, 90, 16);
		pnlCapNhat.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(314, 152, 267, 28);
		pnlCapNhat.add(txtNgaySinh);

		JLabel lblEmail = new JLabel("Địa chỉ Email");
		lblEmail.setBounds(314, 184, 73, 16);
		pnlCapNhat.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(314, 204, 267, 28);
		pnlCapNhat.add(txtEmail);

		rdoNam = new JRadioButton("Nam");
		buttonGroup.add(rdoNam);
		rdoNam.setBounds(6, 152, 49, 18);
		pnlCapNhat.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		buttonGroup.add(rdoNu);
		rdoNu.setBounds(72, 152, 49, 18);
		pnlCapNhat.add(rdoNu);

		JLabel lblTitle = new JLabel("QUẢN LÝ NGƯỜI HỌC");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setForeground(new Color(51, 0, 153));
		lblTitle.setBounds(6, 6, 160, 20);
		getContentPane().add(lblTitle);

		disableFunction();
	}

	private void clear() {
		txtMaNH.setText("");
		txtHoTen.setText("");
		rdoNam.setSelected(true);
		txtNgaySinh.setText("");
		txtDienThoai.setText("");
		txtEmail.setText("");
		txtGhiChu.setText("");

		txtMaNH.setBackground(null);
		txtHoTen.setBackground(null);
		txtNgaySinh.setBackground(null);
		txtDienThoai.setBackground(null);
		txtEmail.setBackground(null);
	}

	protected void btnNew() {
		clear();

		txtMaNH.setEnabled(true);
		txtHoTen.setEnabled(true);
		rdoNam.setEnabled(true);
		rdoNu.setEnabled(true);
		txtNgaySinh.setEnabled(true);
		txtDienThoai.setEnabled(true);
		txtEmail.setEnabled(true);
		txtGhiChu.setEnabled(true);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	protected void btnDelete() {
		// TODO Auto-generated method stub

	}

	protected void btnUpdate() {
		// TODO Auto-generated method stub

	}

	protected void btnAdd() {
		if (validated()) {
			try {
				NguoiHocModel nguoiHocModel = new NguoiHocModel();
				nguoiHocModel.setMaNH(txtMaNH.getText());
				nguoiHocModel.setHoTen(txtHoTen.getText());
				nguoiHocModel.setGioiTinh((rdoNam.isSelected()) ? true : false);
				nguoiHocModel.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgaySinh.getText()));
				nguoiHocModel.setDienThoai(txtDienThoai.getText());
				nguoiHocModel.setEmail(txtEmail.getText());
				nguoiHocModel.setGhiChu(txtGhiChu.getText());
				nguoiHocModel.setMaNV(nhanVien.getMaNV());
				nguoiHocModel.setNgayDK(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				nguoiHocService.save(nguoiHocModel);
			} catch (Exception e) {
				e.printStackTrace();
			}

			clear();
			loadToTable();
		}
	}

	private boolean validated() {
		// TODO Auto-generated method stub
		return true;
	}

	protected void tableClicked() {
		index = table.getSelectedRow();
		showDetail();
		checkPositionInTable();

		txtMaNH.setEnabled(true);
		txtHoTen.setEnabled(true);
		rdoNam.setEnabled(true);
		rdoNu.setEnabled(true);
		txtNgaySinh.setEnabled(true);
		txtDienThoai.setEnabled(true);
		txtEmail.setEnabled(true);
		txtGhiChu.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	private void showDetail() {
		txtMaNH.setText(list.get(index).getMaNH());
		txtHoTen.setText(list.get(index).getHoTen());
		if (list.get(index).isGioiTinh()) {
			rdoNam.setSelected(true);
		} else {
			rdoNu.setSelected(true);
		}
		txtNgaySinh.setText(new SimpleDateFormat("dd/MM/yyyy").format(list.get(index).getNgaySinh()));
		txtDienThoai.setText(list.get(index).getDienThoai());
		txtEmail.setText(list.get(index).getEmail());
		txtGhiChu.setText(list.get(index).getGhiChu());
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

	protected void findKeyPressed() {

	}

	private void disableFunction() {
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);

		txtMaNH.setEnabled(false);
		txtHoTen.setEnabled(false);
		rdoNam.setEnabled(false);
		rdoNu.setEnabled(false);
		txtNgaySinh.setEnabled(false);
		txtDienThoai.setEnabled(false);
		txtEmail.setEnabled(false);
		txtGhiChu.setEnabled(false);
	}

	protected void btnEnd() {
		index = list.size() - 1;
		table.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnNext() {
		index++;
		table.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBack() {
		index--;
		table.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBegin() {
		index = 0;
		table.setRowSelectionInterval(index, index);
		showDetail();
		checkPositionInTable();
	}
}
