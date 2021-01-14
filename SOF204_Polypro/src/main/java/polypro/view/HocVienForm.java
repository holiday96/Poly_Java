package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class HocVienForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable tblHocVien;
	private String columnHocVien[] = { "TT", "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM" };
	private DefaultTableModel modelHocVien;
	private JTable tblNguoiHoc;
	private String columnNguoiHoc[] = { "MÃ HV", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL" };
	private DefaultTableModel modelNguoiHoc;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/User.png")));
		setVisible(true);
		setBounds(100, 100, 750, 550);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
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
		tblHocVien.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(tblHocVien);

		JButton btnDelete = new JButton("Xoá khỏi khoá học");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(475, 376, 128, 28);
		pnlHocVien.add(btnDelete);

		JButton btnUpdate = new JButton("Cập nhật điểm");
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
		tblNguoiHoc = new JTable(modelNguoiHoc);
		tblNguoiHoc.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(tblNguoiHoc);

		JPanel pnlFind = new JPanel();
		pnlFind.setLayout(null);
		pnlFind.setBorder(new TitledBorder(null, "T\u00CCM KI\u1EBEM", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlFind.setBounds(0, 4, 718, 63);
		pnlNguoiHoc.add(pnlFind);

		JTextField txtFind = new JTextField();
		txtFind.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtFind.setBounds(14, 18, 595, 30);
		pnlFind.add(txtFind);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.setBounds(621, 18, 79, 30);
		pnlFind.add(btnFind);

		JButton btnAdd = new JButton("Thêm vào khoá học");
		btnAdd.setEnabled(false);
		btnAdd.setBounds(583, 376, 135, 28);
		pnlNguoiHoc.add(btnAdd);

		JPanel pnlChuyenDe = new JPanel();
		pnlChuyenDe.setBounds(6, 6, 359, 63);
		getContentPane().add(pnlChuyenDe);
		pnlChuyenDe.setBorder(new TitledBorder(null, "CHUY\u00CAN \u0110\u1EC0", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlChuyenDe.setLayout(null);

		JComboBox<Object> cboChuyenDe = new JComboBox<Object>();
		cboChuyenDe.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboChuyenDe.setBounds(14, 18, 328, 30);
		pnlChuyenDe.add(cboChuyenDe);

		JPanel pnlKhoaHoc = new JPanel();
		pnlKhoaHoc.setLayout(null);
		pnlKhoaHoc.setBorder(new TitledBorder(null, "KHO\u00C1 H\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlKhoaHoc.setBounds(377, 6, 347, 63);
		getContentPane().add(pnlKhoaHoc);

		JComboBox<Object> cboKhoaHoc = new JComboBox<Object>();
		cboKhoaHoc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboKhoaHoc.setBounds(14, 18, 316, 30);
		pnlKhoaHoc.add(cboKhoaHoc);
	}
}
