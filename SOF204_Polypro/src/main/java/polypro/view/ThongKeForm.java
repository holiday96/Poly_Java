package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
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

public class ThongKeForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;

	private JTable tblBangDiem;
	private String columnBangDiem[] = { "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI" };
	private DefaultTableModel modelBangDiem;
	private JTable tblNguoiHoc;
	private String columnNguoiHoc[] = { "NĂM", "SỐ NGƯỜI HỌC", "ĐẦU TIÊN", "SAU CÙNG" };
	private DefaultTableModel modelNguoiHoc;
	private JTable tblDiemChuyenDe;
	private String columnDiemChuyenDe[] = { "CHUYÊN ĐỀ", "SL HV", "ĐIỂM THẤP NHẤT", "ĐIỂM CAO NHẤT", "ĐIỂM TB" };
	private DefaultTableModel modelDiemChuyenDe;
	private JTable tblDoanhThu;
	private String columnDoanhThu[] = { "CHUYÊN ĐỀ", "SỐ KH", "SỐ HV", "D.THU", "HP.TN", "HP.CN", "HP.TB" };
	private DefaultTableModel modelDoanhThu;
	static JTabbedPane tabbedPane;
	private JComboBox<Object> cboKhoaHoc;
	private JComboBox<Object> cboNam;
	private List<KhoaHocModel> listKhoaHoc;
	private int indexKhoaHoc;
	private List<ChuyenDeModel> listChuyenDe;
	private List<HocVienModel> listHocVien, listHocVienTemp;
	private List<NguoiHocModel> listNguoiHoc;
	private List<Integer> listYearNguoiHoc, listYearDoanhThu;
	private int count, countReal;
	private double min, max, avg, money;

	private IChuyenDeService chuyenDeService = new ChuyenDeService();
	private IKhoaHocService khoaHocService = new KhoaHocService();
	private IHocVienService hocVienService = new HocVienService();
	private INguoiHocService nguoiHocService = new NguoiHocService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new ThongKeForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThongKeForm() {
		initialize();
		try {
			listKhoaHoc = khoaHocService.findAll();
			listNguoiHoc = nguoiHocService.findAll();
			listChuyenDe = chuyenDeService.findAll();
			for (KhoaHocModel i : listKhoaHoc) {
				cboKhoaHoc.addItem(i.getMaKH());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		filterYearNguoiHoc();
		loadNguoiHocTable();
		loadChuyenDeTable();
		loadComboboxYear();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Diagram.png")));
		setVisible(true);
		setBounds(100, 100, 620, 398);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Tổng hợp & Thống kê");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("TỔNG HỢP THỐNG KÊ");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setBounds(6, 6, 168, 20);
		getContentPane().add(lblTitle);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 27, 590, 330);
		getContentPane().add(tabbedPane);

		JLayeredPane lypBangDiem = new JLayeredPane();
		tabbedPane.addTab("BẢNG ĐIỂM", null, lypBangDiem, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 31, 590, 271);
		lypBangDiem.add(scrollPane);

		modelBangDiem = new DefaultTableModel(columnBangDiem, 0);
		tblBangDiem = new JTable(modelBangDiem) {

			private static final long serialVersionUID = 5377371199505474349L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		scrollPane.setViewportView(tblBangDiem);
		tblBangDiem.getColumnModel().getColumn(0).setMaxWidth(80);
		tblBangDiem.getColumnModel().getColumn(2).setMaxWidth(80);
		tblBangDiem.getColumnModel().getColumn(3).setMaxWidth(100);

		JLabel lblKhoaHoc = new JLabel("KHOÁ HỌC");
		lblKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblKhoaHoc.setBounds(0, 6, 72, 19);
		lypBangDiem.add(lblKhoaHoc);

		cboKhoaHoc = new JComboBox<Object>();
		cboKhoaHoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboKhoaHocSelected();
			}
		});
		cboKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cboKhoaHoc.setBounds(84, 2, 500, 26);
		lypBangDiem.add(cboKhoaHoc);

		JLayeredPane lypNguoiHoc = new JLayeredPane();
		tabbedPane.addTab("LƯỢNG NGƯỜI HỌC", null, lypNguoiHoc, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 590, 302);
		lypNguoiHoc.add(scrollPane_1);

		modelNguoiHoc = new DefaultTableModel(columnNguoiHoc, 0);
		tblNguoiHoc = new JTable(modelNguoiHoc) {

			private static final long serialVersionUID = 8333042417905384815L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};

		};
		tblNguoiHoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tblNguoiHoc);
		tblNguoiHoc.getColumnModel().getColumn(0).setMaxWidth(100);

		JLayeredPane lypDiemChuyenDe = new JLayeredPane();
		tabbedPane.addTab("ĐIỂM CHUYÊN ĐỀ", null, lypDiemChuyenDe, null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 0, 590, 302);
		lypDiemChuyenDe.add(scrollPane_1_1);

		modelDiemChuyenDe = new DefaultTableModel(columnDiemChuyenDe, 0);
		tblDiemChuyenDe = new JTable(modelDiemChuyenDe) {

			private static final long serialVersionUID = 4760089132019117100L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		scrollPane_1_1.setViewportView(tblDiemChuyenDe);
		tblDiemChuyenDe.getColumnModel().getColumn(0).setMinWidth(300);

		JLayeredPane lypDoanhThu = new JLayeredPane();
		tabbedPane.addTab("DOANH THU", null, lypDoanhThu, null);
		tabbedPane.setEnabledAt(3, true);

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(0, 31, 590, 268);
		lypDoanhThu.add(scrollPane_1_1_1);

		modelDoanhThu = new DefaultTableModel(columnDoanhThu, 0);
		tblDoanhThu = new JTable(modelDoanhThu) {

			private static final long serialVersionUID = -7279130998834726863L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		scrollPane_1_1_1.setViewportView(tblDoanhThu);
		tblDoanhThu.getColumnModel().getColumn(0).setMinWidth(200);

		JLabel lblNam = new JLabel("NĂM");
		lblNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNam.setBounds(0, 6, 72, 19);
		lypDoanhThu.add(lblNam);

		cboNam = new JComboBox<Object>();
		cboNam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboYearClicked();
			}
		});
		cboNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cboNam.setBounds(44, 2, 540, 26);
		lypDoanhThu.add(cboNam);
		if (LoginForm.nhanVien.isVaiTro()) {
			tabbedPane.setEnabledAt(3, true);
		} else {
			tabbedPane.setEnabledAt(3, false);
		}
	}

	protected void cboKhoaHocSelected() {
		indexKhoaHoc = cboKhoaHoc.getSelectedIndex();
		listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());

		loadHocVienTable();
	}

	/**
	 * Table Bảng điểm
	 */
	private void loadHocVienTable() {
		modelBangDiem.setRowCount(0);
		for (HocVienModel i : listHocVien) {
			modelBangDiem.addRow(
					new Object[] { i.getMaNH(), getHoTenHocVien(i.getMaNH()), i.getDiem(), xepLoai(i.getDiem()) });
		}
	}

	private String xepLoai(double diem) {
		if (diem >= 9) {
			return "Xuất sắc";
		} else if (diem >= 8) {
			return "Giỏi";
		} else if (diem >= 7) {
			return "Khá";
		} else if (diem >= 6) {
			return "Trung bình";
		}
		return "Chưa đạt";
	}

	private String getHoTenHocVien(String maNH) {
		for (NguoiHocModel i : listNguoiHoc) {
			if (String.valueOf(maNH).equals(i.getMaNH())) {
				return i.getHoTen();
			}
		}
		return null;
	}

	// filter to list of year for NguoiHoc
	private void filterYearNguoiHoc() {
		listYearNguoiHoc = new ArrayList<Integer>();
		Calendar cal = Calendar.getInstance();
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (!listYearNguoiHoc.contains(cal.get(Calendar.YEAR))) {
				listYearNguoiHoc.add(cal.get(Calendar.YEAR));
			}
		}
		listYearNguoiHoc.sort((o1, o2) -> o1 - o2);
	}

	/**
	 * Table Lượng người học
	 */
	private void loadNguoiHocTable() {
		modelNguoiHoc.setRowCount(0);
		for (int i : listYearNguoiHoc) {
			modelNguoiHoc.addRow(
					new Object[] { i, soLuongNguoiHoc(i), new SimpleDateFormat("dd/MM/yyyy").format(dangKyDauTien(i)),
							new SimpleDateFormat("dd/MM/yyyy").format(dangKySauCung(i)) });
		}
	}

	// Caculate number of NguoiHoc in table NguoiHoc
	private int soLuongNguoiHoc(int year) {
		int amount = 0;
		Calendar cal = Calendar.getInstance();
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (cal.get(Calendar.YEAR) == year) {
				amount++;
			}
		}
		return amount;
	}

	// filter subscribers first
	private Date dangKyDauTien(int year) {
		Date firstDate = null;
		Calendar cal = Calendar.getInstance();
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (cal.get(Calendar.YEAR) == year) {
				firstDate = i.getNgayDK();
				break;
			}
		}
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (i.getNgayDK().before(firstDate) && cal.get(Calendar.YEAR) == year) {
				firstDate = i.getNgayDK();
			}
		}
		return firstDate;
	}

	// filter the last subscriber
	private Date dangKySauCung(int year) {
		Date lastDate = null;
		Calendar cal = Calendar.getInstance();
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (cal.get(Calendar.YEAR) == year) {
				lastDate = i.getNgayDK();
				break;
			}
		}
		for (NguoiHocModel i : listNguoiHoc) {
			cal.setTime(i.getNgayDK());
			if (i.getNgayDK().after(lastDate) && cal.get(Calendar.YEAR) == year) {
				lastDate = i.getNgayDK();
			}
		}
		return lastDate;
	}

	/**
	 * Table Điểm chuyên đề
	 */
	private void loadChuyenDeTable() {
		modelDiemChuyenDe.setRowCount(0);

		for (ChuyenDeModel chuyenDeModel : listChuyenDe) {
			count = 0;
			countReal = 0;
			avg = 0;
			min = 11;
			max = -1;
			for (KhoaHocModel khoaHocModel : listKhoaHoc) {
				if (khoaHocModel.getMaCD().equals(chuyenDeModel.getMaCD())) {
					listHocVienTemp = hocVienService.findByMaKH(khoaHocModel.getMaKH());
					for (HocVienModel hocVienModel : listHocVienTemp) {
						count++;
						if (hocVienModel.getDiem() >= 0 && hocVienModel.getDiem() <= 10) {
							if (hocVienModel.getDiem() < min) {
								min = hocVienModel.getDiem();
							}
							if (hocVienModel.getDiem() > max) {
								max = hocVienModel.getDiem();
							}
							countReal++;
							avg += hocVienModel.getDiem();
						}
					}
				}
			}
			if (count == 0) {
				modelDiemChuyenDe.addRow(new Object[] { chuyenDeModel.getTenCD(), count, "", "", "" });
			} else {
				avg /= countReal;
				modelDiemChuyenDe.addRow(new Object[] { chuyenDeModel.getTenCD(), count, (min == 11) ? 0 : min,
						(max == -1) ? 0 : max, (avg >= 0 && avg <= 10) ? (double) Math.round(avg * 10) / 10 : 0 });
			}
		}
	}

	/**
	 * Table Doanh thu
	 */

	protected void cboYearClicked() {
		loadDoanhThuTable();
	}

	// filter listYear for DoanhThu
	private void filterYearDoanhThu() {
		listYearDoanhThu = new ArrayList<Integer>();
		Calendar cal = Calendar.getInstance();
		for (KhoaHocModel i : listKhoaHoc) {
			cal.setTime(i.getNgayKG());
			if (!listYearDoanhThu.contains(cal.get(Calendar.YEAR))) {
				listYearDoanhThu.add(cal.get(Calendar.YEAR));
			}
		}
		listYearDoanhThu.sort((o1, o2) -> o1 - o2);
	}

	private void loadComboboxYear() {
		filterYearDoanhThu();
		if (listYearDoanhThu.size() != 0) {
			for (int i : listYearDoanhThu) {
				cboNam.addItem(i);
			}
		}
	}

	private void loadDoanhThuTable() {
		modelDoanhThu.setRowCount(0);

		int year = (int) cboNam.getSelectedItem();
		for (ChuyenDeModel chuyenDeModel : listChuyenDe) {
			count = 0;
			countReal = 0;
			min = Double.MAX_VALUE;
			max = -1;
			money = 0;
			for (KhoaHocModel khoaHocModel : listKhoaHoc) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(khoaHocModel.getNgayKG());
				if (khoaHocModel.getMaCD().equals(chuyenDeModel.getMaCD()) && cal.get(Calendar.YEAR) == year) {
					count++;
					countReal += hocVienService.findByMaKH(khoaHocModel.getMaKH()).size();
					if (khoaHocModel.getHocPhi() > 0) {
						money += khoaHocModel.getHocPhi() * countReal;
						if (money < min) {
							min = money;
						}
						if (money > max) {
							max = money;
						}
					}
				}
			}
			avg = money / count;
			if (count == 0) {
				modelDoanhThu.addRow(new Object[] { chuyenDeModel.getTenCD(), count, 0, 0, 0, 0, 0 });
			} else {
				modelDoanhThu.addRow(new Object[] { chuyenDeModel.getTenCD(), count, countReal, money, min, max, avg });
			}
		}
	}
}
