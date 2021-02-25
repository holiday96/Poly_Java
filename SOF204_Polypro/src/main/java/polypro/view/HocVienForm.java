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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import polypro.model.ChuyenDeModel;
import polypro.model.HocVienModel;
import polypro.model.KhoaHocModel;
import polypro.model.NguoiHocModel;
import polypro.service.IChuyenDeService;
import polypro.service.IHocVienService;
import polypro.service.IKhoaHocService;
import polypro.service.INguoiHocService;
import polypro.service.impl.ChuyenDeService;
import polypro.service.impl.HocVienService;
import polypro.service.impl.KhoaHocService;
import polypro.service.impl.NguoiHocService;

public class HocVienForm extends JInternalFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable tblHocVien;
	private String columnHocVien[] = { "TT", "MÃ HV", "HỌ VÀ TÊN", "ĐIỂM" };
	private DefaultTableModel modelHocVien;
	private JTable tblNguoiHoc;
	private String columnNguoiHoc[] = { "MÃ NH", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL" };
	private DefaultTableModel modelNguoiHoc;
	private JComboBox<Object> cboChuyenDe;
	private JComboBox<Object> cboKhoaHoc;
	private int indexChuyenDe, indexKhoaHoc;
	private JTextField txtFind;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private List<ChuyenDeModel> listChuyenDe;
	private List<KhoaHocModel> listKhoaHoc;
	private List<HocVienModel> listHocVien;
	private List<NguoiHocModel> listNguoiHoc;
	private List<Integer> indexHocVien, indexNguoiHoc;

	private IChuyenDeService chuyenDeService = new ChuyenDeService();
	private IKhoaHocService khoaHocService = new KhoaHocService();
	private INguoiHocService nguoiHocService = new NguoiHocService();
	private IHocVienService hocVienService = new HocVienService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new HocVienForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HocVienForm() {
		initialize();
		try {
			listChuyenDe = chuyenDeService.findAll();
			for (ChuyenDeModel i : listChuyenDe) {
				cboChuyenDe.addItem(i.getMaCD() + " - " + i.getTenCD());
			}
			listNguoiHoc = nguoiHocService.findAll();
			loadNguoiHocTable();

			listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
			loadHocVienTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/User.png"))));
		setVisible(true);
		setBounds(100, 100, 750, 550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setTitle("EduSys - Quản lý học viên");
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 70, 718, 440);
		getContentPane().add(tabbedPane);

		modelHocVien = new DefaultTableModel(columnHocVien, 0);

		JPanel pnlHocVien = new JPanel();
		tabbedPane.addTab("HỌC VIÊN", null, pnlHocVien, null);
		pnlHocVien.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 718, 371);
		pnlHocVien.add(scrollPane);
		tblHocVien = new JTable(modelHocVien);
		tblHocVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelete.setEnabled(true);
				btnUpdate.setEnabled(true);
			}
		});
		tblHocVien.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(tblHocVien);

		btnDelete = new JButton("Xoá khỏi khoá học");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(475, 376, 128, 28);
		pnlHocVien.add(btnDelete);

		btnUpdate = new JButton("Cập nhật điểm");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(609, 376, 109, 28);
		pnlHocVien.add(btnUpdate);

		JPanel pnlNguoiHoc = new JPanel();
		tabbedPane.addTab("NGƯỜI HỌC", null, pnlNguoiHoc, null);
		pnlNguoiHoc.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 67, 718, 304);
		pnlNguoiHoc.add(scrollPane_1);

		modelNguoiHoc = new DefaultTableModel(columnNguoiHoc, 0);
		tblNguoiHoc = new JTable(modelNguoiHoc) {

			private static final long serialVersionUID = 5377371199505474349L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tblNguoiHoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblNguoiHocClicked();
			}
		});
		tblNguoiHoc.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(tblNguoiHoc);

		JPanel pnlFind = new JPanel();
		pnlFind.setLayout(null);
		pnlFind.setBorder(new TitledBorder(null, "T\u00CCM KI\u1EBEM", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlFind.setBounds(0, 4, 718, 63);
		pnlNguoiHoc.add(pnlFind);

		txtFind = new JTextField();
		txtFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findKeyPressed();
			}
		});
		txtFind.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtFind.setBounds(14, 18, 685, 30);
		pnlFind.add(txtFind);

		btnAdd = new JButton("Thêm vào khoá học");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnAdd.setEnabled(false);
		btnAdd.setBounds(583, 376, 135, 28);
		pnlNguoiHoc.add(btnAdd);

		JPanel pnlChuyenDe = new JPanel();
		pnlChuyenDe.setBounds(6, 6, 359, 63);
		getContentPane().add(pnlChuyenDe);
		pnlChuyenDe.setBorder(new TitledBorder(null, "CHUY\u00CAN \u0110\u1EC0", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlChuyenDe.setLayout(null);

		cboChuyenDe = new JComboBox<Object>();
		cboChuyenDe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboChuyenDeSelected();
			}
		});
		cboChuyenDe.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboChuyenDe.setBounds(14, 18, 328, 30);
		pnlChuyenDe.add(cboChuyenDe);

		JPanel pnlKhoaHoc = new JPanel();
		pnlKhoaHoc.setLayout(null);
		pnlKhoaHoc.setBorder(new TitledBorder(null, "KHO\u00C1 H\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlKhoaHoc.setBounds(377, 6, 347, 63);
		getContentPane().add(pnlKhoaHoc);

		cboKhoaHoc = new JComboBox<Object>();
		cboKhoaHoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboKhoaHocSelected();
			}
		});
		cboKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboKhoaHoc.setBounds(14, 18, 316, 30);
		pnlKhoaHoc.add(cboKhoaHoc);
	}

	protected void btnUpdate() {
		indexHocVien = convertArrayToList(tblHocVien.getSelectedRows());
		for (int i : indexHocVien) {
			if (Double.valueOf(modelHocVien.getValueAt(i, 3).toString()) < 0
					|| Double.valueOf(modelHocVien.getValueAt(i, 3).toString()) >= 10) {
				JOptionPane.showMessageDialog(this,
						"Điểm học viên có mã HV: " + listHocVien.get(i).getMaHV() + " không hợp lệ!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			} else {
				hocVienService.update(listHocVien.get(i).getMaHV(),
						Double.valueOf(modelHocVien.getValueAt(i, 3).toString()));
			}
		}

		try {
			listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
			loadHocVienTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void btnDelete() {
		indexHocVien = convertArrayToList(tblHocVien.getSelectedRows());
		StringBuilder listMaHV = new StringBuilder();
		for (int i : indexHocVien) {
			listMaHV.append(listHocVien.get(i).getMaHV() + ", ");
		}

		if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá học viên có Mã HV:  " + listMaHV, "Xoá",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			for (int i : indexHocVien) {
				hocVienService.delete(listHocVien.get(i));
			}

			try {
				listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
				loadHocVienTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void tblNguoiHocClicked() {
		btnAdd.setEnabled(true);
	}

	private List<Integer> convertArrayToList(int[] array) {
		List<Integer> listIndex = new ArrayList<>(array.length);
		for (int i : array) {
			listIndex.add(Integer.valueOf(i));
		}
		return listIndex;
	}

	protected void btnAdd() {
		indexNguoiHoc = convertArrayToList(tblNguoiHoc.getSelectedRows());
		for (int i : indexNguoiHoc) {
			if (checkExist(listNguoiHoc.get(i).getMaNH())) {
				JOptionPane.showMessageDialog(this,
						"Người học có mã NH: " + listNguoiHoc.get(i).getMaNH().trim() + " đã tồn tại trong khoá học",
						"Thất bại", JOptionPane.ERROR_MESSAGE);
			} else {
				HocVienModel hocVienModel = new HocVienModel();
				hocVienModel.setMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
				hocVienModel.setMaNH(listNguoiHoc.get(i).getMaNH());
				hocVienService.save(hocVienModel);
			}
		}

		try {
			listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
			loadHocVienTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tblNguoiHoc.clearSelection();
	}

	private boolean checkExist(String maNH) {
		for (HocVienModel i : listHocVien) {
			if (maNH.equalsIgnoreCase(i.getMaNH())) {
				return true;
			}
		}
		return false;
	}

	protected void cboKhoaHocSelected() {
		try {
			if (listKhoaHoc.size() > 0) {
				indexKhoaHoc = cboKhoaHoc.getSelectedIndex();
				listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());
			}
			loadHocVienTable();
		} catch (Exception e) {
			modelHocVien.setRowCount(0);
			e.printStackTrace();
		}
	}

	private void loadHocVienTable() {
		modelHocVien.setRowCount(0);
		for (int i = 0; i < listHocVien.size(); i++) {
			modelHocVien.addRow(new Object[] { i + 1, listHocVien.get(i).getMaHV(),
					hoTenHV(listHocVien.get(i).getMaNH()), listHocVien.get(i).getDiem() });
		}
	}

	private String hoTenHV(String maNH) {
		for (NguoiHocModel i : listNguoiHoc) {
			if (maNH.equalsIgnoreCase(i.getMaNH())) {
				return i.getHoTen();
			}
		}
		return null;
	}

	private void loadNguoiHocTable() {
		modelNguoiHoc.setRowCount(0);
		for (NguoiHocModel i : listNguoiHoc) {
			modelNguoiHoc.addRow(new Object[] { i.getMaNH(), i.getHoTen(), (i.isGioiTinh()) ? "Nam" : "Nữ",
					new SimpleDateFormat("dd/MM/yyyy").format(i.getNgaySinh()), i.getDienThoai(), i.getEmail() });
		}
	}

	protected void cboChuyenDeSelected() {
		indexChuyenDe = cboChuyenDe.getSelectedIndex();
		try {
			listKhoaHoc = khoaHocService.findByMaCD(listChuyenDe.get(indexChuyenDe).getMaCD());
			cboKhoaHoc.removeAllItems();
			if (listKhoaHoc.size() > 0) {
				for (KhoaHocModel i : listKhoaHoc) {
					cboKhoaHoc.addItem(i.getMaKH());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cboKhoaHocSelected();
	}

	protected void findKeyPressed() {
		try {
			listNguoiHoc = nguoiHocService.findByID(txtFind.getText());
			loadNguoiHocTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
