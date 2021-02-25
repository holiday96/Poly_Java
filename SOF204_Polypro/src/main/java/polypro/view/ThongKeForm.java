package polypro.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

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

public class ThongKeForm extends JInternalFrame {

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
	private JScrollPane scrollPane, scrollPane_1;
	private JLayeredPane lypBangDiem, lypNguoiHoc;
	private JComboBox<Object> cboNam, cboKhoaHoc;
	private List<KhoaHocModel> listKhoaHoc;
	private int indexKhoaHoc;
	private List<ChuyenDeModel> listChuyenDe;
	private List<HocVienModel> listHocVien, listHocVienTemp;
	private List<NguoiHocModel> listNguoiHoc;
	private List<Integer> listYearNguoiHoc, listYearDoanhThu;
	private int count, countReal;
	private double min, max, avg, money;
	private JButton btnChart, btnList;
	private ChartPanel chartPanel;

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
		chartPanel = new ChartPanel(createPieChart(createPieDataset(), cboKhoaHoc.getSelectedItem().toString()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrameIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Diagram.png"))));
		setVisible(true);
		setBounds(100, 100, 620, 398);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setTitle("EduSys - Tổng hợp & Thống kê");
		getContentPane().setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);

		lypBangDiem = new JLayeredPane();
		tabbedPane.addTab("BẢNG ĐIỂM", null, lypBangDiem, null);
		lypBangDiem.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		lypBangDiem.add(scrollPane, BorderLayout.CENTER);

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

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(2);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		lypBangDiem.add(panel_2, BorderLayout.NORTH);

		JLabel lblKhoaHoc = new JLabel("KHOÁ HỌC");
		lblKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(lblKhoaHoc);

		cboKhoaHoc = new JComboBox<Object>();
		cboKhoaHoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboKhoaHocSelected();
			}
		});
		cboKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(cboKhoaHoc);

		lypNguoiHoc = new JLayeredPane();
		tabbedPane.addTab("LƯỢNG NGƯỜI HỌC", null, lypNguoiHoc, null);
		lypNguoiHoc.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
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
		lypDiemChuyenDe.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1_1 = new JScrollPane();
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
		lypDoanhThu.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
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

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(2);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		lypDoanhThu.add(panel_1, BorderLayout.NORTH);

		JLabel lblNam = new JLabel("NĂM");
		lblNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_1.add(lblNam);

		cboNam = new JComboBox<Object>();
		cboNam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboYearSelected();
			}
		});
		cboNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_1.add(cboNam);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblTitle = new JLabel("TỔNG HỢP THỐNG KÊ");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		panel.add(lblTitle);

		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);

		btnChart = new JButton("");
		btnChart.setIcon(new ImageIcon(this.getClass().getResource("../../icon/chart-icon.png")));
		panel.add(btnChart);
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChartClicked();
			}
		});

		btnList = new JButton("");
		btnList.setIcon(new ImageIcon(this.getClass().getResource("../../icon/list-icon.png")));
		panel.add(btnList);
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListClicked();
			}
		});
		btnList.setVisible(false);

		if (LoginForm.nhanVien.isVaiTro()) {
			tabbedPane.setEnabledAt(3, true);
		} else {
			tabbedPane.setEnabledAt(3, false);
		}
	}

	protected void cboYearSelected() {
		loadDoanhThuTable();
	}

	protected void cboKhoaHocSelected() {
		indexKhoaHoc = cboKhoaHoc.getSelectedIndex();
		listHocVien = hocVienService.findByMaKH(listKhoaHoc.get(indexKhoaHoc).getMaKH());

		loadHocVienTable();

		if (!scrollPane.isVisible()) {
			loadChartBangDiem();
		}
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

	/**
	 * JFreeChart - Bảng điểm PieChart
	 */
	private JFreeChart createPieChart(PieDataset dataset, String khoaHoc) {
		JFreeChart chart = ChartFactory.createPieChart("THỐNG KÊ BẢNG ĐIỂM KHOÁ HỌC " + khoaHoc, dataset, true, true,
				true);
		return chart;
	}

	private PieDataset createPieDataset() {
		int xuatSac = 0, gioi = 0, kha = 0, tb = 0, chuaDat = 0;
		for (int i = 0; i < tblBangDiem.getRowCount() - 1; i++) {
			if (tblBangDiem.getValueAt(i, 3).equals("Xuất sắc")) {
				xuatSac++;
			} else if (tblBangDiem.getValueAt(i, 3).equals("Giỏi")) {
				gioi++;
			} else if (tblBangDiem.getValueAt(i, 3).equals("Khá")) {
				kha++;
			} else if (tblBangDiem.getValueAt(i, 3).equals("Trung bình")) {
				tb++;
			} else {
				chuaDat++;
			}
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Xuất sắc: " + xuatSac, xuatSac);
		dataset.setValue("Giỏi: " + gioi, gioi);
		dataset.setValue("Khá: " + kha, kha);
		dataset.setValue("Trung bình: " + tb, tb);
		dataset.setValue("Chưa đạt: " + chuaDat, chuaDat);
		return dataset;
	}

	private void loadChartBangDiem() {
		lypBangDiem.remove(chartPanel);
		chartPanel = new ChartPanel(createPieChart(createPieDataset(), cboKhoaHoc.getSelectedItem().toString()));
		lypBangDiem.add(chartPanel, BorderLayout.CENTER);
	}

	/**
	 * JFreeChart - Lượng người học BarChart
	 */
	private JFreeChart createBarChartNguoiHoc() {
		JFreeChart barChart = ChartFactory.createBarChart("THỐNG KÊ LƯỢNG NGƯỜI HỌC", "Năm", "Số người",
				createBarDatasetNguoiHoc(), PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	private CategoryDataset createBarDatasetNguoiHoc() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < tblNguoiHoc.getRowCount() - 1; i++) {
			dataset.addValue(Double.parseDouble(tblNguoiHoc.getValueAt(i, 1).toString()), "Số người",
					tblNguoiHoc.getValueAt(i, 0).toString());
		}
		return dataset;
	}
	
	private void loadChartNguoiHoc() {
		lypNguoiHoc.remove(chartPanel);
		chartPanel = new ChartPanel(createBarChartNguoiHoc());
		lypNguoiHoc.add(chartPanel, BorderLayout.CENTER);
	}

	protected void btnChartClicked() {
		// Tab BangDiem
		if (tabbedPane.getSelectedIndex() == 0) {
			scrollPane.setVisible(false);
			loadChartBangDiem();
			chartPanel.setVisible(true);
			btnChart.setVisible(false);
			btnList.setVisible(true);
			lypBangDiem.repaint();
		} else if (tabbedPane.getSelectedIndex() == 1) {
			scrollPane_1.setVisible(false);
			loadChartNguoiHoc();
			chartPanel.setVisible(true);
			btnChart.setVisible(false);
			btnList.setVisible(true);
			lypNguoiHoc.repaint();
		}
	}

	protected void btnListClicked() {
		// Tab BangDiem
		if (tabbedPane.getSelectedIndex() == 0) {
			chartPanel.setVisible(false);
			scrollPane.setVisible(true);
			btnChart.setVisible(true);
			btnList.setVisible(false);
			lypBangDiem.repaint();
		} else if (tabbedPane.getSelectedIndex() == 1) {
			chartPanel.setVisible(false);
			scrollPane_1.setVisible(true);
			btnChart.setVisible(true);
			btnList.setVisible(false);
			lypNguoiHoc.repaint();
		}
	}
}
