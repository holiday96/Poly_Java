package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import polypro.model.ChuyenDeModel;
import polypro.model.KhoaHocModel;
import polypro.service.IChuyenDeService;
import polypro.service.IKhoaHocService;
import polypro.service.impl.ChuyenDeService;
import polypro.service.impl.KhoaHocService;

public class KhoaHocForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;

	private JTable table;
	private String column[] = { "MÃ KH", "THỜI LƯỢNG", "HỌC PHÍ", "KHAI GIẢNG", "NGƯỜI TẠO", "NGÀY TẠO" };
	private DefaultTableModel model;
	private JTextField txtHocPhi;
	private JTextField txtNguoiTao;
	private JTextArea txtGhiChu;
	private JTextField txtKhaiGiang;
	private JTextField txtThoiLuong;
	private JTextField txtNgayTao;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnBegin;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnEnd;
	private JLabel lblTenCD;
	private JComboBox<Object> comboBox;
	private List<ChuyenDeModel> listChuyenDe;
	private List<KhoaHocModel> listKhoaHoc;
	private int indexChuyenDe;
	private int indexKhoaHoc;

	private IChuyenDeService chuyenDeService = new ChuyenDeService();
	private IKhoaHocService khoaHocService = new KhoaHocService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new KhoaHocForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KhoaHocForm() {
		initialize();

		try {
			listChuyenDe = chuyenDeService.findAll();
			for (ChuyenDeModel i : listChuyenDe) {
				comboBox.addItem(i.getTenCD());
			}
			indexChuyenDe = comboBox.getSelectedIndex();
			loadToTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Certificate.png")));
		setVisible(true);
		setBounds(100, 100, 615, 440);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Quản lý khoá học");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "CHUY\u00CAN \u0110\u1EC0", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(153, 0, 51)));
		panel.setBounds(6, 6, 587, 58);
		getContentPane().add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox<Object>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxSelected();
			}
		});
		comboBox.setBounds(14, 18, 554, 26);
		panel.add(comboBox);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 63, 587, 331);
		getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("DANH SÁCH", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 587, 295);
		panel_1.add(scrollPane);

		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JPanel panel_1_1 = new JPanel();
		tabbedPane.addTab("CẬP NHẬT", null, panel_1_1, null);
		panel_1_1.setLayout(null);

		JLabel lblChuyenDe = new JLabel("Chuyên đề");
		lblChuyenDe.setBounds(6, 6, 59, 16);
		panel_1_1.add(lblChuyenDe);

		lblTenCD = new JLabel("");
		lblTenCD.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTenCD.setForeground(new Color(204, 0, 51));
		lblTenCD.setBounds(10, 28, 199, 26);
		panel_1_1.add(lblTenCD);

		JLabel lblHocPhi = new JLabel("Học phí");
		lblHocPhi.setBounds(6, 68, 59, 16);
		panel_1_1.add(lblHocPhi);

		txtHocPhi = new JTextField();
		txtHocPhi.setEnabled(false);
		txtHocPhi.setBounds(6, 90, 296, 28);
		panel_1_1.add(txtHocPhi);
		txtHocPhi.setColumns(10);

		JLabel lblNguoiTao = new JLabel("Người tạo");
		lblNguoiTao.setBounds(6, 120, 59, 16);
		panel_1_1.add(lblNguoiTao);

		txtNguoiTao = new JTextField();
		txtNguoiTao.setEnabled(false);
		txtNguoiTao.setColumns(10);
		txtNguoiTao.setBounds(6, 140, 296, 28);
		panel_1_1.add(txtNguoiTao);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setBounds(6, 180, 59, 16);
		panel_1_1.add(lblGhiChu);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 200, 575, 60);
		panel_1_1.add(scrollPane_1);

		txtGhiChu = new JTextArea();
		scrollPane_1.setViewportView(txtGhiChu);
		txtGhiChu.setColumns(10);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnAdd.setEnabled(false);
		btnAdd.setBounds(6, 267, 60, 28);
		panel_1_1.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(72, 267, 60, 28);
		panel_1_1.add(btnUpdate);

		btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(138, 267, 60, 28);
		panel_1_1.add(btnDelete);

		btnClear = new JButton("Mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew();
			}
		});
		btnClear.setBounds(204, 267, 60, 28);
		panel_1_1.add(btnClear);

		btnBegin = new JButton("|<");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin();
			}
		});
		btnBegin.setEnabled(false);
		btnBegin.setBounds(387, 267, 45, 28);
		panel_1_1.add(btnBegin);

		btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBack();
			}
		});
		btnBack.setEnabled(false);
		btnBack.setBounds(435, 267, 45, 28);
		panel_1_1.add(btnBack);

		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext();
			}
		});
		btnNext.setEnabled(false);
		btnNext.setBounds(485, 267, 45, 28);
		panel_1_1.add(btnNext);

		btnEnd = new JButton(">|");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnd();
			}
		});
		btnEnd.setEnabled(false);
		btnEnd.setBounds(535, 267, 45, 28);
		panel_1_1.add(btnEnd);

		JLabel lblKhaiGiang = new JLabel("Khai giảng");
		lblKhaiGiang.setBounds(314, 6, 59, 16);
		panel_1_1.add(lblKhaiGiang);

		txtKhaiGiang = new JTextField();
		txtKhaiGiang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKhaiGiang.setText("");
			}
		});
		txtKhaiGiang.setText("Ngày / Tháng / Năm");
		txtKhaiGiang.setToolTipText("VD: 31/12/2020");
		txtKhaiGiang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtKhaiGiang.setBackground(null);
			}
		});
		txtKhaiGiang.setColumns(10);
		txtKhaiGiang.setBounds(314, 28, 267, 28);
		panel_1_1.add(txtKhaiGiang);

		JLabel lblThoiLuong = new JLabel("Thời lượng (giờ)");
		lblThoiLuong.setBounds(314, 68, 90, 16);
		panel_1_1.add(lblThoiLuong);

		txtThoiLuong = new JTextField();
		txtThoiLuong.setEnabled(false);
		txtThoiLuong.setColumns(10);
		txtThoiLuong.setBounds(314, 88, 267, 28);
		panel_1_1.add(txtThoiLuong);

		JLabel lblNgayTao = new JLabel("Ngày tạo");
		lblNgayTao.setBounds(314, 120, 59, 16);
		panel_1_1.add(lblNgayTao);

		txtNgayTao = new JTextField();
		txtNgayTao.setEnabled(false);
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(314, 140, 267, 28);
		panel_1_1.add(txtNgayTao);
		txtKhaiGiang.setEnabled(false);
	}

	protected void btnDelete() {
		if (JOptionPane.showConfirmDialog(this,
				"Xác nhận xoá khoá học có Mã KH:  " + listKhoaHoc.get(indexKhoaHoc).getMaNV(), "Xoá",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			khoaHocService.delete(listKhoaHoc.get(indexKhoaHoc));
			loadToTable();

			disableFunction();
			clear();
		}
	}

	private void disableFunction() {
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);
		txtKhaiGiang.setEnabled(false);
		txtGhiChu.setEnabled(false);
	}

	protected void btnEnd() {
		indexKhoaHoc = listKhoaHoc.size() - 1;
		table.setRowSelectionInterval(indexKhoaHoc, indexKhoaHoc);
		showDetail();
		checkPositionInTable();
	}

	protected void btnNext() {
		indexKhoaHoc++;
		table.setRowSelectionInterval(indexKhoaHoc, indexKhoaHoc);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBack() {
		indexKhoaHoc--;
		table.setRowSelectionInterval(indexKhoaHoc, indexKhoaHoc);
		showDetail();
		checkPositionInTable();
	}

	protected void btnBegin() {
		indexKhoaHoc = 0;
		table.setRowSelectionInterval(indexKhoaHoc, indexKhoaHoc);
		showDetail();
		checkPositionInTable();
	}

	protected void btnUpdate() {
		if (validated()) {
			try {
				KhoaHocModel khoaHocModel = new KhoaHocModel();
				khoaHocModel.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
				khoaHocModel.setHocPhi(Math.floor(Double.valueOf(txtHocPhi.getText())));
				khoaHocModel.setNgayKG(new SimpleDateFormat("dd/MM/yyyy").parse(txtKhaiGiang.getText()));
				khoaHocModel.setNgayTao(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayTao.getText()));
				khoaHocModel.setGhiChu(txtGhiChu.getText());
				khoaHocModel.setMaCD(listChuyenDe.get(indexChuyenDe).getMaCD());
				khoaHocModel.setMaNV(LoginForm.nhanVien.getMaNV());
				khoaHocService.update(khoaHocModel, listKhoaHoc.get(indexKhoaHoc).getMaKH());
			} catch (Exception e) {
				e.printStackTrace();
			}

			clear();
			loadToTable();
		}
	}

	protected void btnAdd() {
		if (validated()) {
			try {
				KhoaHocModel khoaHocModel = new KhoaHocModel();
				khoaHocModel.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
				khoaHocModel.setHocPhi(Math.floor(Double.valueOf(txtHocPhi.getText())));
				khoaHocModel.setNgayKG(new SimpleDateFormat("dd/MM/yyyy").parse(txtKhaiGiang.getText()));
				khoaHocModel.setNgayTao(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayTao.getText()));
				khoaHocModel.setGhiChu(txtGhiChu.getText());
				khoaHocModel.setMaCD(listChuyenDe.get(indexChuyenDe).getMaCD());
				khoaHocModel.setMaNV(LoginForm.nhanVien.getMaNV());
				khoaHocService.save(khoaHocModel);
			} catch (Exception e) {
				e.printStackTrace();
			}

			clear();
			loadToTable();
		}
	}

	private void loadToTable() {
		try {
			listKhoaHoc = khoaHocService.findByMaCD(listChuyenDe.get(indexChuyenDe).getMaCD());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setRowCount(0);
		for (KhoaHocModel i : listKhoaHoc) {
			model.addRow(new Object[] { i.getMaKH(), i.getThoiLuong() + " Giờ", i.getHocPhi() + " VNĐ",
					new SimpleDateFormat("dd/MM/yyyy").format(i.getNgayKG()), i.getMaNV(),
					new SimpleDateFormat("dd/MM/yyyy").format(i.getNgayTao()) });
		}
	}

	private void showDetail() {
		txtKhaiGiang.setText(new SimpleDateFormat("dd/MM/yyyy").format(listKhoaHoc.get(indexKhoaHoc).getNgayKG()));
		txtThoiLuong.setText(String.valueOf(listKhoaHoc.get(indexKhoaHoc).getThoiLuong()));
		txtHocPhi.setText(String.valueOf(listKhoaHoc.get(indexKhoaHoc).getHocPhi()));
		txtNguoiTao.setText(listKhoaHoc.get(indexKhoaHoc).getMaNV());
		txtNgayTao.setText(new SimpleDateFormat("dd/MM/yyyy").format(listKhoaHoc.get(indexKhoaHoc).getNgayTao()));
	}

	protected void tableClicked() {
		indexKhoaHoc = table.getSelectedRow();
		showDetail();
		checkPositionInTable();

		txtKhaiGiang.setEnabled(true);
		txtGhiChu.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	private void checkPositionInTable() {
		if (listKhoaHoc.size() > 1) {
			if (indexKhoaHoc == 0) {
				btnBegin.setEnabled(false);
				btnBack.setEnabled(false);
				btnNext.setEnabled(true);
				btnEnd.setEnabled(true);
			}
			if (indexKhoaHoc > 0 && indexKhoaHoc < listKhoaHoc.size() - 1) {
				btnBegin.setEnabled(true);
				btnBack.setEnabled(true);
				btnNext.setEnabled(true);
				btnEnd.setEnabled(true);
			}
			if (indexKhoaHoc == listKhoaHoc.size() - 1) {
				btnBegin.setEnabled(true);
				btnBack.setEnabled(true);
				btnNext.setEnabled(false);
				btnEnd.setEnabled(false);
			}
		}
	}

	private boolean validated() {
		String regexDate = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
		StringBuilder message = new StringBuilder();
		if (txtKhaiGiang.getText().isBlank()) {
			message.append("\nNgày khai giảng trống");
			txtKhaiGiang.setBackground(Color.decode("#f38aff"));
			txtKhaiGiang.requestFocus();
		} else if (!txtKhaiGiang.getText().matches(regexDate)) {
			message.append("\nNgày khai giảng không hợp lệ!");
			txtKhaiGiang.setBackground(Color.decode("#ff96a6"));
			txtKhaiGiang.requestFocus();
		} else
			try {
				if (new SimpleDateFormat("dd/MM/yyyy").parse(txtKhaiGiang.getText()).before(new Date())) {
					message.append("\nNgày khai giảng phải sau ngày hiện tại!");
					txtKhaiGiang.setBackground(Color.decode("#ff96a6"));
					txtKhaiGiang.requestFocus();
				}
			} catch (NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
	}

	private void comboBoxSelected() {
		indexChuyenDe = comboBox.getSelectedIndex();
		lblTenCD.setText(listChuyenDe.get(indexChuyenDe).getTenCD());
		txtHocPhi.setText(String.valueOf(listChuyenDe.get(indexChuyenDe).getHocPhi()));
		txtThoiLuong.setText(String.valueOf(listChuyenDe.get(indexChuyenDe).getThoiLuong()));
		loadToTable();
	}

	private void clear() {
		txtKhaiGiang.setText("Ngày / Tháng / Năm");
		txtGhiChu.setText("");
		try {
			txtNguoiTao.setText(LoginForm.nhanVien.getHoTen());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		txtNgayTao.setText(new SimpleDateFormat("dd/MM/yyy").format(new Date()));

		txtKhaiGiang.setBackground(null);
		txtGhiChu.setBackground(null);

		table.clearSelection();
	}

	protected void btnNew() {
		clear();

		txtKhaiGiang.setEnabled(true);
		txtGhiChu.setEnabled(true);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
}
