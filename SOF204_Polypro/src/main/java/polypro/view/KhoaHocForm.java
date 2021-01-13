package polypro.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class KhoaHocForm extends JFrame{

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
		panel.setBorder(new TitledBorder(null, "CHUY\u00CAN \u0110\u1EC0", TitledBorder.LEADING, TitledBorder.TOP, new Font("SansSerif", Font.BOLD, 15), new Color(153, 0, 51)));
		panel.setBounds(6, 6, 587, 58);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
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
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1 = new JPanel();
		tabbedPane.addTab("CẬP NHẬT", null, panel_1_1, null);
		panel_1_1.setLayout(null);
		
		JLabel lblChuyenDe = new JLabel("Chuyên đề");
		lblChuyenDe.setBounds(6, 6, 59, 16);
		panel_1_1.add(lblChuyenDe);
		
		JLabel lblTenCD = new JLabel("");
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
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(6, 267, 60, 28);
		panel_1_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(72, 267, 60, 28);
		panel_1_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xoá");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(138, 267, 60, 28);
		panel_1_1.add(btnDelete);
		
		JButton btnClear = new JButton("Mới");
		btnClear.setBounds(204, 267, 60, 28);
		panel_1_1.add(btnClear);
		
		JButton btnBegin = new JButton("|<");
		btnBegin.setBounds(387, 267, 45, 28);
		panel_1_1.add(btnBegin);
		
		JButton btnBack = new JButton("<<");
		btnBack.setBounds(435, 267, 45, 28);
		panel_1_1.add(btnBack);
		
		JButton btnNext = new JButton(">>");
		btnNext.setBounds(485, 267, 45, 28);
		panel_1_1.add(btnNext);
		
		JButton btnEnd = new JButton(">|");
		btnEnd.setBounds(535, 267, 45, 28);
		panel_1_1.add(btnEnd);
		
		JLabel lblKhaiGiang = new JLabel("Khai giảng");
		lblKhaiGiang.setBounds(314, 6, 59, 16);
		panel_1_1.add(lblKhaiGiang);
		
		txtKhaiGiang = new JTextField();
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
	}
}
