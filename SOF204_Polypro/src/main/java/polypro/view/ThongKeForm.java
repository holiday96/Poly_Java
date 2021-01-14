package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

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
	private JTabbedPane tabbedPane;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Diagram.png")));
		setVisible(true);
		setBounds(100, 100, 620, 398);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		tblBangDiem = new JTable(modelBangDiem);
		scrollPane.setViewportView(tblBangDiem);
		tblBangDiem.getColumnModel().getColumn(0).setMaxWidth(80);
		tblBangDiem.getColumnModel().getColumn(2).setMaxWidth(80);
		tblBangDiem.getColumnModel().getColumn(3).setMaxWidth(100);

		JLabel lblKhoaHoc = new JLabel("KHOÁ HỌC");
		lblKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblKhoaHoc.setBounds(0, 6, 72, 19);
		lypBangDiem.add(lblKhoaHoc);

		JComboBox<Object> cboKhoaHoc = new JComboBox<Object>();
		cboKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cboKhoaHoc.setBounds(84, 2, 500, 26);
		lypBangDiem.add(cboKhoaHoc);

		JLayeredPane lypNguoiHoc = new JLayeredPane();
		tabbedPane.addTab("LƯỢNG NGƯỜI HỌC", null, lypNguoiHoc, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 590, 302);
		lypNguoiHoc.add(scrollPane_1);

		modelNguoiHoc = new DefaultTableModel(columnNguoiHoc, 0);
		tblNguoiHoc = new JTable(modelNguoiHoc);
		scrollPane_1.setViewportView(tblNguoiHoc);
		tblNguoiHoc.getColumnModel().getColumn(0).setMaxWidth(100);

		JLayeredPane lypDiemChuyenDe = new JLayeredPane();
		tabbedPane.addTab("ĐIỂM CHUYÊN ĐỀ", null, lypDiemChuyenDe, null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 0, 590, 302);
		lypDiemChuyenDe.add(scrollPane_1_1);

		modelDiemChuyenDe = new DefaultTableModel(columnDiemChuyenDe, 0);
		tblDiemChuyenDe = new JTable(modelDiemChuyenDe);
		scrollPane_1_1.setViewportView(tblDiemChuyenDe);
		tblDiemChuyenDe.getColumnModel().getColumn(0).setMinWidth(300);

		JLayeredPane lypDoanhThu = new JLayeredPane();
		tabbedPane.addTab("DOANH THU", null, lypDoanhThu, null);

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(0, 31, 590, 268);
		lypDoanhThu.add(scrollPane_1_1_1);

		modelDoanhThu = new DefaultTableModel(columnDoanhThu, 0);
		tblDoanhThu = new JTable(modelDoanhThu);
		scrollPane_1_1_1.setViewportView(tblDoanhThu);
		tblDoanhThu.getColumnModel().getColumn(0).setMinWidth(200);

		JLabel lblNam = new JLabel("NĂM");
		lblNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNam.setBounds(0, 6, 72, 19);
		lypDoanhThu.add(lblNam);

		JComboBox<Object> cboNam = new JComboBox<Object>();
		cboNam.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cboNam.setBounds(44, 2, 540, 26);
		lypDoanhThu.add(cboNam);
	}

	public void changeTab(int numTab) {
		tabbedPane.setSelectedIndex(numTab - 1);
	}
}
