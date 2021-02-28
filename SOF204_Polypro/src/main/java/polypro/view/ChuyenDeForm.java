package polypro.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import polypro.model.ChuyenDeModel;
import polypro.service.IChuyenDeService;
import polypro.service.impl.ChuyenDeService;

public class ChuyenDeForm extends JInternalFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable tblDanhSach;
	private String column[] = { "MÃ CD", "TÊN CD", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH", "MÔ TẢ" };
	private DefaultTableModel model;
	private JFileChooser fileChooser;
	private JTextField txtMaCD;
	private JTextField txtTenCD;
	private JTextField txtThoiLuong;
	private JTextField txtHocPhi;
	private JLabel lblLogo;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnBegin;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnEnd;
	private JTextArea txtMoTa;
	private boolean unlockLogo;
	private List<ChuyenDeModel> list;
	private int index, sumDB, numPage, indexPage;
	private JPanel panel;
	private JLabel lblTitle;
	private JPanel panel_1;
	private JButton btnDau, btnTruoc, btnTiep, btnCuoi;
	private JLabel lblNumPage;

	@Inject
	private IChuyenDeService chuyenDeService = new ChuyenDeService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ChuyenDeForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChuyenDeForm() {
		fileChooser = new JFileChooser();
		initialize();
		try {
			index = 0;
			indexPage = 1;
			loadToTable(1);
			checkPositionListPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrameIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Lists.png"))));
		setVisible(true);
		setBounds(100, 100, 620, 492);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);

		setTitle("EduSys - Quản lý chuyên đề");
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblTitle = new JLabel("QUẢN LÝ CHUYÊN ĐỀ");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		panel.add(lblTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);

		model = new DefaultTableModel(column, 0);

		JLayeredPane lypDanhSach = new JLayeredPane();
		tabbedPane.addTab("DANH SÁCH", null, lypDanhSach, null);
		lypDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		lypDanhSach.add(scrollPane);
		tblDanhSach = new JTable(model) {

			private static final long serialVersionUID = 5377371199505474349L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tblDanhSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDanhSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		scrollPane.setViewportView(tblDanhSach);

		panel_1 = new JPanel();
		lypDanhSach.add(panel_1, BorderLayout.SOUTH);

		btnDau = new JButton("|<");
		btnDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDau();
			}
		});
		panel_1.add(btnDau);

		btnTruoc = new JButton("<<");
		btnTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTruoc();
			}
		});
		panel_1.add(btnTruoc);

		lblNumPage = new JLabel("numPage");
		panel_1.add(lblNumPage);

		btnTiep = new JButton(">>");
		btnTiep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTiep();
			}
		});
		panel_1.add(btnTiep);

		btnCuoi = new JButton(">|");
		btnCuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCuoi();
			}
		});
		panel_1.add(btnCuoi);
		tblDanhSach.getColumnModel().getColumn(0).setMaxWidth(70);

		JLayeredPane lypCapNhat = new JLayeredPane();
		tabbedPane.addTab("CẬP NHẬT", null, lypCapNhat, null);

		JLabel lblTitleLogo = new JLabel("Hình Logo");
		lblTitleLogo.setBounds(6, 6, 57, 16);
		lypCapNhat.add(lblTitleLogo);

		lblLogo = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("../../icon/none.png"));
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (unlockLogo) {
					logoClicked();
				}
			}
		});
		lblLogo.setBounds(6, 23, 164, 177);
		lypCapNhat.add(lblLogo);

		JLabel lblMaCD = new JLabel("Mã chuyên đề");
		lblMaCD.setBounds(185, 6, 75, 16);
		lypCapNhat.add(lblMaCD);

		txtMaCD = new JTextField();
		txtMaCD.setToolTipText("Bắt buộc gồm 5 ký tự");
		txtMaCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtMaCD.setBackground(null);
			}
		});
		txtMaCD.setBounds(182, 23, 402, 28);
		lypCapNhat.add(txtMaCD);
		txtMaCD.setColumns(10);

		JLabel lblTenCD = new JLabel("Tên chuyên đề");
		lblTenCD.setBounds(185, 56, 80, 16);
		lypCapNhat.add(lblTenCD);

		txtTenCD = new JTextField();
		txtTenCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtTenCD.setBackground(null);
			}
		});
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(182, 73, 402, 28);
		lypCapNhat.add(txtTenCD);

		txtThoiLuong = new JTextField();
		txtThoiLuong.setToolTipText("Điền thời lượng giờ chẵn");
		txtThoiLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtThoiLuong.setBackground(null);
			}
		});
		txtThoiLuong.setColumns(10);
		txtThoiLuong.setBounds(182, 124, 402, 28);
		lypCapNhat.add(txtThoiLuong);

		JLabel lblThoiLuong = new JLabel("Thời lượng (giờ)");
		lblThoiLuong.setBounds(185, 107, 90, 16);
		lypCapNhat.add(lblThoiLuong);

		txtHocPhi = new JTextField();
		txtHocPhi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtHocPhi.setBackground(null);
			}
		});
		txtHocPhi.setToolTipText("Theo đơn vị VNĐ");
		txtHocPhi.setColumns(10);
		txtHocPhi.setBounds(182, 172, 402, 28);
		lypCapNhat.add(txtHocPhi);

		JLabel lblHocPhi = new JLabel("Học phí");
		lblHocPhi.setBounds(185, 155, 75, 16);
		lypCapNhat.add(lblHocPhi);

		JLabel lblMoTa = new JLabel("Mô tả chuyên đề");
		lblMoTa.setBounds(6, 212, 88, 16);
		lypCapNhat.add(lblMoTa);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 230, 578, 120);
		lypCapNhat.add(scrollPane_1);

		txtMoTa = new JTextArea();
		txtMoTa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtMoTa.setBackground(null);
			}
		});
		scrollPane_1.setViewportView(txtMoTa);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnAdd.setBounds(6, 355, 60, 28);
		lypCapNhat.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});
		btnUpdate.setBounds(72, 355, 60, 28);
		lypCapNhat.add(btnUpdate);

		btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		btnDelete.setBounds(138, 355, 60, 28);
		lypCapNhat.add(btnDelete);

		btnClear = new JButton("Mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew();
			}
		});
		btnClear.setBounds(204, 355, 60, 28);
		lypCapNhat.add(btnClear);

		btnBegin = new JButton("|<");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin();
			}
		});
		btnBegin.setBounds(387, 355, 45, 28);
		lypCapNhat.add(btnBegin);

		btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBack();
			}
		});
		btnBack.setBounds(435, 355, 45, 28);
		lypCapNhat.add(btnBack);

		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext();
			}
		});
		btnNext.setBounds(485, 355, 45, 28);
		lypCapNhat.add(btnNext);

		btnEnd = new JButton(">|");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnd();
			}
		});
		btnEnd.setBounds(535, 355, 45, 28);
		lypCapNhat.add(btnEnd);

		disableFunction();
	}

	protected void btnDau() {
		indexPage = 1;
		loadToTable(indexPage);
		checkPositionListPage();
	}

	protected void btnTruoc() {
		indexPage--;
		loadToTable(indexPage);
		checkPositionListPage();
	}

	protected void btnTiep() {
		indexPage++;
		loadToTable(indexPage);
		checkPositionListPage();
	}

	protected void btnCuoi() {
		indexPage = numPage;
		loadToTable(indexPage);
		checkPositionListPage();
	}

	private void checkPositionListPage() {
		if (numPage > 1) {
			if (indexPage == 1) {
				btnDau.setEnabled(false);
				btnTruoc.setEnabled(false);
				btnTiep.setEnabled(true);
				btnCuoi.setEnabled(true);
			}
			if (indexPage > 1 && indexPage < numPage) {
				btnDau.setEnabled(true);
				btnTruoc.setEnabled(true);
				btnTiep.setEnabled(true);
				btnCuoi.setEnabled(true);
			}
			if (indexPage == numPage) {
				btnDau.setEnabled(true);
				btnTruoc.setEnabled(true);
				btnTiep.setEnabled(false);
				btnCuoi.setEnabled(false);
			}
		}
		lblNumPage.setText(indexPage + "/" + numPage);
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

	protected void btnUpdate() {
		if (validatedIgnoreMaCDKey()) {
			ChuyenDeModel chuyenDeModel = new ChuyenDeModel();
			chuyenDeModel.setMaCD(txtMaCD.getText());
			chuyenDeModel.setTenCD(txtTenCD.getText());
			chuyenDeModel.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
			chuyenDeModel.setHocPhi(Math.floor(Double.valueOf(txtHocPhi.getText())));
			chuyenDeModel.setMoTa(txtMoTa.getText());

			if (fileChooser.getSelectedFile() != null) {
				chuyenDeModel.setHinh(fileChooser.getSelectedFile().getAbsolutePath());
			} else {
				chuyenDeModel.setHinh(list.get(index).getHinh());
			}
			chuyenDeService.update(chuyenDeModel, list.get(index).getMaCD());

			clear();
			disableFunction();
			loadToTable(1);
		}
	}

	private boolean validatedIgnoreMaCDKey() {
		String regexInteger = "\\d+";
		String regexDouble = "\\d+(\\.\\d+)?";
		StringBuilder message = new StringBuilder();
		if (txtMaCD.getText().isBlank()) {
			message.append("\nMã chuyên đề trống");
			txtMaCD.setBackground(Color.decode("#f38aff"));
			txtMaCD.requestFocus();
		}
		if (txtTenCD.getText().isBlank()) {
			message.append("\nTên chuyên đề trống");
			txtTenCD.setBackground(Color.decode("#f38aff"));
			txtTenCD.requestFocus();
		}
		if (txtThoiLuong.getText().isBlank()) {
			message.append("\nThời lượng trống");
			txtThoiLuong.setBackground(Color.decode("#f38aff"));
			txtThoiLuong.requestFocus();
		} else if (!txtThoiLuong.getText().matches(regexInteger) || Integer.valueOf(txtThoiLuong.getText()) == 0) {
			message.append("\nThời lượng không hợp lệ");
			txtThoiLuong.setBackground(Color.decode("#ff96a6"));
			txtThoiLuong.requestFocus();
		}
		if (txtHocPhi.getText().isBlank()) {
			message.append("\nHọc phí trống");
			txtHocPhi.setBackground(Color.decode("#f38aff"));
			txtHocPhi.requestFocus();
		} else if (!txtHocPhi.getText().matches(regexDouble) || Double.valueOf(txtHocPhi.getText()) == 0) {
			message.append("\nHọc phí không hợp lệ");
			txtHocPhi.setBackground(Color.decode("#ff96a6"));
			txtHocPhi.requestFocus();
		}
		if (txtMoTa.getText().isBlank()) {
			message.append("\nMô tả trống");
			txtMoTa.setBackground(Color.decode("#f38aff"));
			txtMoTa.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
	}

	protected void btnDelete() {
		if (!LoginForm.nhanVien.isVaiTro()) {
			JOptionPane.showMessageDialog(this, "Bạn không có quyền thực hiện chức năng này!", "Chức năng giới hạn",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá chuyên đề có Mã CD:  " + list.get(index).getMaCD(),
					"Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
				chuyenDeService.delete(list.get(index));
				loadToTable(1);

				disableFunction();
				clear();
			}
		}
	}

	protected void tableClicked() {
		index = tblDanhSach.getSelectedRow();
		showDetail();
		checkPositionInTable();

		btnAdd.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);

		txtMaCD.setEnabled(true);
		txtTenCD.setEnabled(true);
		txtHocPhi.setEnabled(true);
		txtThoiLuong.setEnabled(true);
		txtMoTa.setEnabled(true);
		unlockLogo = true;

		txtHocPhi.setBackground(null);
		txtMaCD.setBackground(null);
		txtTenCD.setBackground(null);
		txtThoiLuong.setBackground(null);
		txtMoTa.setBackground(null);
	}

	private void showDetail() {
		txtMaCD.setText(list.get(index).getMaCD());
		txtTenCD.setText(list.get(index).getTenCD());
		txtThoiLuong.setText(String.valueOf(list.get(index).getThoiLuong()));
		txtHocPhi.setText(String.valueOf(list.get(index).getHocPhi()));
		txtMoTa.setText(list.get(index).getMoTa());

		ImageIcon imageIcon = new ImageIcon(list.get(index).getHinh());
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));
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

	private boolean validated() {
		String regexInteger = "\\d+";
		String regexDouble = "\\d+(\\.\\d+)?";
		StringBuilder message = new StringBuilder();
		if (txtMaCD.getText().isBlank()) {
			message.append("\nMã chuyên đề trống");
			txtMaCD.setBackground(Color.decode("#f38aff"));
			txtMaCD.requestFocus();
		} else {
			for (ChuyenDeModel i : list) {
				if (txtMaCD.getText().equalsIgnoreCase(i.getMaCD().trim())) {
					message.append("\nMã chuyên đề đã tồn tại");
					txtMaCD.setBackground(Color.decode("#ff96a6"));
					txtMaCD.requestFocus();
					break;
				}
			}
		}
		if (txtTenCD.getText().isBlank()) {
			message.append("\nTên chuyên đề trống");
			txtTenCD.setBackground(Color.decode("#f38aff"));
			txtTenCD.requestFocus();
		}
		if (txtThoiLuong.getText().isBlank()) {
			message.append("\nThời lượng trống");
			txtThoiLuong.setBackground(Color.decode("#f38aff"));
			txtThoiLuong.requestFocus();
		} else if (!txtThoiLuong.getText().matches(regexInteger) || Integer.valueOf(txtThoiLuong.getText()) == 0) {
			message.append("\nThời lượng không hợp lệ");
			txtThoiLuong.setBackground(Color.decode("#ff96a6"));
			txtThoiLuong.requestFocus();
		}
		if (txtHocPhi.getText().isBlank()) {
			message.append("\nHọc phí trống");
			txtHocPhi.setBackground(Color.decode("#f38aff"));
			txtHocPhi.requestFocus();
		} else if (!txtHocPhi.getText().matches(regexDouble) || Double.valueOf(txtHocPhi.getText()) == 0) {
			message.append("\nHọc phí không hợp lệ");
			txtHocPhi.setBackground(Color.decode("#ff96a6"));
			txtHocPhi.requestFocus();
		}
		if (txtMoTa.getText().isBlank()) {
			message.append("\nMô tả trống");
			txtMoTa.setBackground(Color.decode("#f38aff"));
			txtMoTa.requestFocus();
		}
		if (message.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
	}

	protected void btnAdd() {
		if (validated()) {
			ChuyenDeModel chuyenDeModel = new ChuyenDeModel();
			chuyenDeModel.setMaCD(txtMaCD.getText());
			chuyenDeModel.setTenCD(txtTenCD.getText());
			chuyenDeModel.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
			chuyenDeModel.setHocPhi(Math.floor(Double.valueOf(txtHocPhi.getText())));
			chuyenDeModel.setMoTa(txtMoTa.getText());

			if (fileChooser.getSelectedFile() != null) {
				chuyenDeModel.setHinh(fileChooser.getSelectedFile().getAbsolutePath());
			} else {
				chuyenDeModel.setHinh(this.getClass().getResource("../../icon/question.png").getPath());
			}
			chuyenDeService.save(chuyenDeModel);

			ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("../../icon/question.png"));
			Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
			lblLogo.setIcon(new ImageIcon(image));

			clear();
			loadToTable(1);
		}
	}

	private void loadToTable(int indexPage) {
		try {
			sumDB = chuyenDeService.countDB();
			numPage = numPage(sumDB);
			list = chuyenDeService.top5(indexPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setRowCount(0);
		for (ChuyenDeModel i : list) {
			model.addRow(new Object[] { i.getMaCD(), i.getTenCD(), (int) i.getHocPhi() + " VNĐ",
					i.getThoiLuong() + " Giờ", i.getHinh(), i.getMoTa() });
		}
	}

	private int numPage(int sumDB) {
		if (sumDB % 5 == 0) {
			return sumDB / 5;
		} else {
			return sumDB / 5 + 1;
		}
	}

	private void clear() {
		txtHocPhi.setText("");
		txtMaCD.setText("");
		txtTenCD.setText("");
		txtThoiLuong.setText("");
		txtMoTa.setText("");
		txtHocPhi.setBackground(null);
		txtMaCD.setBackground(null);
		txtTenCD.setBackground(null);
		txtThoiLuong.setBackground(null);
		txtMoTa.setBackground(null);

		tblDanhSach.clearSelection();
	}

	protected void btnNew() {
		unlockLogo = true;

		lblLogo.setIcon(null);
		txtHocPhi.setEnabled(true);
		txtMaCD.setEnabled(true);
		txtTenCD.setEnabled(true);
		txtThoiLuong.setEnabled(true);
		txtMoTa.setEnabled(true);

		btnAdd.setEnabled(true);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("../../icon/question.png"));
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));

		clear();
	}

	protected void logoClicked() {
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
			Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
			lblLogo.setIcon(new ImageIcon(image));
		}
	}

	private void disableFunction() {
		// btn Trang Danh sach
		btnDau.setEnabled(false);
		btnTruoc.setEnabled(false);
		btnTiep.setEnabled(false);
		btnCuoi.setEnabled(false);
		// btn Trang Chi tiet
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnBegin.setEnabled(false);
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnEnd.setEnabled(false);
		txtHocPhi.setEnabled(false);
		txtMaCD.setEnabled(false);
		txtTenCD.setEnabled(false);
		txtThoiLuong.setEnabled(false);
		txtMoTa.setEnabled(false);
		unlockLogo = false;
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("../../icon/none.png"));
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));
	}
}
