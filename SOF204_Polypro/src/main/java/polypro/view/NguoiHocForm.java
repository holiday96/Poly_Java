package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

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

public class NguoiHocForm extends JFrame{

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable table;
	private String column[] = { "MÃ NH", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL", "MÃ NV", "NGÀY ĐK" };
	private DefaultTableModel model;
	private JTextField txtDienThoai;
	private JTextArea txtGhiChu;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		scrollPane.setViewportView(table);
		
		JPanel pnlFind = new JPanel();
		pnlFind.setBounds(0, 6, 587, 63);
		pnlDanhSach.add(pnlFind);
		pnlFind.setBorder(new TitledBorder(null, "T\u00CCM KI\u1EBEM", TitledBorder.LEADING, TitledBorder.TOP, new Font("SansSerif", Font.BOLD, 15), new Color(51, 0, 153)));
		pnlFind.setLayout(null);
		
		JTextField cboFind = new JTextField();
		cboFind.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboFind.setBounds(14, 18, 467, 30);
		pnlFind.add(cboFind);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.setBounds(489, 17, 79, 28);
		pnlFind.add(btnFind);
		
		JPanel pnlCapNhat = new JPanel();
		tabbedPane.addTab("CẬP NHẬT", null, pnlCapNhat, null);
		pnlCapNhat.setLayout(null);
		
		JLabel lblMaNH = new JLabel("Mã người học");
		lblMaNH.setBounds(6, 6, 75, 16);
		pnlCapNhat.add(lblMaNH);
		
		JTextField txtMaNH = new JTextField("");
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
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(6, 388, 60, 28);
		pnlCapNhat.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(72, 388, 60, 28);
		pnlCapNhat.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xoá");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(138, 388, 60, 28);
		pnlCapNhat.add(btnDelete);
		
		JButton btnClear = new JButton("Mới");
		btnClear.setBounds(204, 388, 60, 28);
		pnlCapNhat.add(btnClear);
		
		JButton btnBegin = new JButton("|<");
		btnBegin.setBounds(387, 388, 45, 28);
		pnlCapNhat.add(btnBegin);
		
		JButton btnBack = new JButton("<<");
		btnBack.setBounds(435, 388, 45, 28);
		pnlCapNhat.add(btnBack);
		
		JButton btnNext = new JButton(">>");
		btnNext.setBounds(485, 388, 45, 28);
		pnlCapNhat.add(btnNext);
		
		JButton btnEnd = new JButton(">|");
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
		
		JRadioButton rdoNam = new JRadioButton("Nam");
		buttonGroup.add(rdoNam);
		rdoNam.setBounds(6, 152, 49, 18);
		pnlCapNhat.add(rdoNam);
		
		JRadioButton rdoNu = new JRadioButton("Nữ");
		buttonGroup.add(rdoNu);
		rdoNu.setBounds(72, 152, 49, 18);
		pnlCapNhat.add(rdoNu);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ NGƯỜI HỌC");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setForeground(new Color(51, 0, 153));
		lblTitle.setBounds(6, 6, 160, 20);
		getContentPane().add(lblTitle);
	}
}
