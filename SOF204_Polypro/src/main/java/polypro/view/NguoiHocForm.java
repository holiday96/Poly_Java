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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import polypro.model.NguoiHocModel;
import polypro.service.INguoiHocService;
import polypro.service.impl.NguoiHocService;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class NguoiHocForm extends JInternalFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable table;
	private String column[] = { "MÃ NH", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL", "MÃ NV",
			"NGÀY ĐK" };
	private DefaultTableModel model;
	private JTextField txtFind;
	private JTextField txtMaNH;
	private JTextField txtHoTen;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JDateChooser txtNgaySinh;
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
		initialize();
		try {
			index = 0;
			list = nguoiHocService.findAll();
			loadToTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrameIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Conference.png"))));
		setVisible(true);
		setBounds(100, 100, 615, 540);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setTitle("EduSys - Quản lý khoá học");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);

		JPanel pnlDanhSach = new JPanel();
		tabbedPane.addTab("DANH SÁCH", null, pnlDanhSach, null);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnlDanhSach.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultTableModel(column, 0);
		table = new JTable(model) {

			private static final long serialVersionUID = 5377371199505474349L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		scrollPane.setViewportView(table);

		JPanel pnlFind = new JPanel();
		pnlDanhSach.add(pnlFind, BorderLayout.NORTH);
		pnlFind.setBorder(new TitledBorder(null, "T\u00CCM KI\u1EBEM", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));

		txtFind = new JTextField();
		txtFind.setToolTipText("Nhập mã Người học");
		txtFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findKeyPressed();
			}
		});
		pnlFind.setLayout(new BorderLayout(0, 0));
		txtFind.setFont(new Font("SansSerif", Font.PLAIN, 15));
		pnlFind.add(txtFind);

		JPanel pnlCapNhat = new JPanel();
		tabbedPane.addTab("CẬP NHẬT", null, pnlCapNhat, null);
		pnlCapNhat.setLayout(null);

		JLabel lblMaNH = new JLabel("Mã người học");
		lblMaNH.setBounds(6, 6, 75, 16);
		pnlCapNhat.add(lblMaNH);

		txtMaNH = new JTextField("");
		txtMaNH.setToolTipText("Tối đa 7 ký tự");
		txtMaNH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtMaNH.setBackground(null);
			}
		});
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
		txtDienThoai.setToolTipText("SĐT từ 84 3/5/7/8/9\r\nhoặc 03/5/7/8/9");
		txtDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtDienThoai.setBackground(null);
			}
		});
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
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin();
			}
		});
		btnBegin.setBounds(387, 388, 45, 28);
		pnlCapNhat.add(btnBegin);

		btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBack();
			}
		});
		btnBack.setBounds(435, 388, 45, 28);
		pnlCapNhat.add(btnBack);

		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext();
			}
		});
		btnNext.setBounds(485, 388, 45, 28);
		pnlCapNhat.add(btnNext);

		btnEnd = new JButton(">|");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnd();
			}
		});
		btnEnd.setBounds(535, 388, 45, 28);
		pnlCapNhat.add(btnEnd);

		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setBounds(6, 66, 59, 16);
		pnlCapNhat.add(lblHoTen);

		txtHoTen = new JTextField();
		txtHoTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtHoTen.setBackground(null);
			}
		});
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(6, 88, 575, 28);
		pnlCapNhat.add(txtHoTen);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(314, 132, 90, 16);
		pnlCapNhat.add(lblNgaySinh);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setDateFormatString("dd/MM/yyyy");
		txtNgaySinh.setToolTipText("VD: 01/12/2020");
		txtNgaySinh.setBounds(314, 152, 267, 28);
		pnlCapNhat.add(txtNgaySinh);
		//disable editor in jdatechooser
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtNgaySinh.getDateEditor();
		editor.setEditable(false);

		JLabel lblEmail = new JLabel("Địa chỉ Email");
		lblEmail.setBounds(314, 184, 73, 16);
		pnlCapNhat.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtEmail.setBackground(null);
			}
		});
		txtEmail.setToolTipText("VD: a@a.com");
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
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ NGƯỜI HỌC");
		lblTitle.setForeground(new Color(51, 0, 153));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		panel.add(lblTitle);

		disableFunction();
	}

	private void clear() {
		txtMaNH.setText("");
		txtHoTen.setText("");
		rdoNam.setSelected(true);
		txtNgaySinh.setDate(null);
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
		if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá người học có Mã NH:  " + list.get(index).getMaNH(), "Xoá",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			nguoiHocService.delete(list.get(index));
			loadToTable();

			disableFunction();
			clear();
		}
	}

	protected void btnUpdate() {
		if (validatedIgnoreMaNHKey()) {
			try {
				NguoiHocModel nguoiHocModel = new NguoiHocModel();
				nguoiHocModel.setMaNH(txtMaNH.getText());
				nguoiHocModel.setHoTen(txtHoTen.getText());
				nguoiHocModel.setGioiTinh((rdoNam.isSelected()) ? true : false);
				nguoiHocModel.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy")
						.parse(new SimpleDateFormat("dd/MM/yyyy").format(txtNgaySinh.getDate())));
				nguoiHocModel.setDienThoai(txtDienThoai.getText());
				nguoiHocModel.setEmail(txtEmail.getText());
				nguoiHocModel.setGhiChu(txtGhiChu.getText());
				nguoiHocModel.setMaNV(LoginForm.nhanVien.getMaNV());
				nguoiHocModel.setNgayDK(new SimpleDateFormat("dd/MM/yyyy")
						.parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				nguoiHocService.update(nguoiHocModel, list.get(index).getMaNH());
			} catch (Exception e) {
				e.printStackTrace();
			}

			clear();
			disableFunction();
			loadToTable();
		}
	}

	protected void btnAdd() {
		if (validated()) {
			try {
				NguoiHocModel nguoiHocModel = new NguoiHocModel();
				nguoiHocModel.setMaNH(txtMaNH.getText());
				nguoiHocModel.setHoTen(txtHoTen.getText());
				nguoiHocModel.setGioiTinh((rdoNam.isSelected()) ? true : false);
				nguoiHocModel.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy")
						.parse(new SimpleDateFormat("dd/MM/yyyy").format(txtNgaySinh.getDate())));
				nguoiHocModel.setDienThoai(txtDienThoai.getText());
				nguoiHocModel.setEmail(txtEmail.getText());
				nguoiHocModel.setGhiChu(txtGhiChu.getText());
				nguoiHocModel.setMaNV(LoginForm.nhanVien.getMaNV());
				nguoiHocModel.setNgayDK(new SimpleDateFormat("dd/MM/yyyy")
						.parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				nguoiHocService.save(nguoiHocModel);
			} catch (Exception e) {
				e.printStackTrace();
			}

			clear();
			loadToTable();
		}
	}

	public static boolean validateLetters(String txt) {
		String regx = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txt);
		return matcher.find();
	}

	private boolean validated() {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		String regexDate = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
		String regexPhone = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
		StringBuilder message = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (txtMaNH.getText().isBlank()) {
			message.append("\nMã người học trống");
			txtMaNH.setBackground(Color.decode("#f38aff"));
			txtMaNH.requestFocus();
		} else if (txtMaNH.getText().length() > 7) {
			message.append("\nMã người học quá 7 ký tự");
			txtMaNH.setBackground(Color.decode("#f38aff"));
			txtMaNH.requestFocus();
		} else {
			for (NguoiHocModel i : list) {
				if (txtMaNH.getText().equalsIgnoreCase(i.getMaNH().trim())) {
					message.append("\nMã người học đã tồn tại");
					txtMaNH.setBackground(Color.decode("#ff96a6"));
					txtMaNH.requestFocus();
					break;
				}
			}
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
		if (txtNgaySinh.getDate() == null) {
			message.append("\nNgày sinh trống");
			txtNgaySinh.setBackground(Color.decode("#f38aff"));
			txtNgaySinh.requestFocus();
		} else if (!sdf.format(txtNgaySinh.getDate()).matches(regexDate)) {
			message.append("\nNgày sinh không hợp lệ!");
			txtNgaySinh.setBackground(Color.decode("#ff96a6"));
			txtNgaySinh.requestFocus();
		} else
			try {
				if (txtNgaySinh.getDate().after(new Date())) {
					message.append("\nNgày sinh phải trước ngày hiện tại!");
					txtNgaySinh.setBackground(Color.decode("#ff96a6"));
					txtNgaySinh.requestFocus();
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		if (txtDienThoai.getText().isBlank()) {
			message.append("\nSố điện thoại trống");
			txtDienThoai.setBackground(Color.decode("#f38aff"));
			txtDienThoai.requestFocus();
		} else if (!txtDienThoai.getText().matches(regexPhone)) {
			message.append("\nSố điện thoại không hợp lệ!");
			txtDienThoai.setBackground(Color.decode("#ff96a6"));
			txtDienThoai.requestFocus();
		}
		if (txtEmail.getText().isBlank()) {
			message.append("\nĐịa chỉ Email trống");
			txtEmail.setBackground(Color.decode("#f38aff"));
			txtEmail.requestFocus();
		} else if (!txtEmail.getText().matches(regexEmail)) {
			message.append("\nEmail không hợp lệ!");
			txtEmail.setBackground(Color.decode("#ff96a6"));
			txtEmail.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
	}

	private boolean validatedIgnoreMaNHKey() {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		String regexDate = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
		String regexPhone = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder message = new StringBuilder();
		if (txtMaNH.getText().isBlank()) {
			message.append("\nMã người học trống");
			txtMaNH.setBackground(Color.decode("#f38aff"));
			txtMaNH.requestFocus();
		} else if (txtMaNH.getText().length() > 7) {
			message.append("\nMã người học quá 7 ký tự");
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
		if (txtNgaySinh.getDate() == null) {
			message.append("\nNgày sinh trống");
			txtNgaySinh.setBackground(Color.decode("#f38aff"));
			txtNgaySinh.requestFocus();
		} else if (!sdf.format(txtNgaySinh.getDate()).matches(regexDate)) {
			message.append("\nNgày sinh không hợp lệ!");
			txtNgaySinh.setBackground(Color.decode("#ff96a6"));
			txtNgaySinh.requestFocus();
		} else
			try {
				if (txtNgaySinh.getDate().after(new Date())) {
					message.append("\nNgày sinh phải trước ngày hiện tại!");
					txtNgaySinh.setBackground(Color.decode("#ff96a6"));
					txtNgaySinh.requestFocus();
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		if (txtDienThoai.getText().isBlank()) {
			message.append("\nSố điện thoại trống");
			txtDienThoai.setBackground(Color.decode("#f38aff"));
			txtDienThoai.requestFocus();
		} else if (!txtDienThoai.getText().matches(regexPhone)) {
			message.append("\nSố điện thoại không hợp lệ!");
			txtDienThoai.setBackground(Color.decode("#ff96a6"));
			txtDienThoai.requestFocus();
		}
		if (txtEmail.getText().isBlank()) {
			message.append("\nĐịa chỉ Email trống");
			txtEmail.setBackground(Color.decode("#f38aff"));
			txtEmail.requestFocus();
		} else if (!txtEmail.getText().matches(regexEmail)) {
			message.append("\nEmail không hợp lệ!");
			txtEmail.setBackground(Color.decode("#ff96a6"));
			txtEmail.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
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

		txtMaNH.setBackground(null);
		txtHoTen.setBackground(null);
		txtNgaySinh.setBackground(null);
		txtDienThoai.setBackground(null);
		txtEmail.setBackground(null);
	}

	private void loadToTable() {
		try {
			list = nguoiHocService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		reloadTable();
	}

	private void reloadTable() {
		model.setRowCount(0);
		for (NguoiHocModel i : list) {
			model.addRow(new Object[] { i.getMaNH(), i.getHoTen(), (i.isGioiTinh()) ? "Nam" : "Nữ",
					new SimpleDateFormat("dd/MM/yyyy").format(i.getNgaySinh()), i.getDienThoai(), i.getEmail(),
					i.getMaNV(), new SimpleDateFormat("dd/MM/yyyy").format(i.getNgayDK()) });
		}
	}

	private void showDetail() {
		txtMaNH.setText(list.get(index).getMaNH());
		txtHoTen.setText(list.get(index).getHoTen());
		if (list.get(index).isGioiTinh()) {
			rdoNam.setSelected(true);
		} else {
			rdoNu.setSelected(true);
		}
		try {
			txtNgaySinh.setDate(list.get(index).getNgaySinh());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			list = nguoiHocService.findByID(txtFind.getText());
			reloadTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		clear();
		disableFunction();
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
