package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class NhanVienForm extends JFrame {

	private static final long serialVersionUID = -4913935832695327558L;
	private JTable tblDanhSach;
	private String column[] = { "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ" };
	private DefaultTableModel model;
	private JTextField txtMaNV;
	private JTextField txtMatKhau;
	private JTextField txtHoTen;
	private JComboBox<Object> txtVaiTro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new NhanVienForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NhanVienForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/User group.png")));
		setVisible(true);
		setBounds(100, 100, 620, 398);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Quản lý nhân viên");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setBounds(6, 6, 159, 20);
		getContentPane().add(lblTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 27, 590, 330);
		getContentPane().add(tabbedPane);

		model = new DefaultTableModel(column, 0);

		JLayeredPane lypDanhSach = new JLayeredPane();
		tabbedPane.addTab("DANH SÁCH", null, lypDanhSach, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 590, 302);
		lypDanhSach.add(scrollPane);
		tblDanhSach = new JTable(model);
		scrollPane.setViewportView(tblDanhSach);

		JLayeredPane lypCapNhat = new JLayeredPane();
		tabbedPane.addTab("CẬP NHẬT", null, lypCapNhat, null);

		JLabel lblMaNV = new JLabel("Mã chuyên đề");
		lblMaNV.setBounds(9, 6, 75, 16);
		lypCapNhat.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(6, 23, 280, 28);
		lypCapNhat.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setBounds(9, 56, 80, 16);
		lypCapNhat.add(lblMatKhau);

		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(6, 73, 280, 28);
		lypCapNhat.add(txtMatKhau);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(304, 23, 280, 28);
		lypCapNhat.add(txtHoTen);

		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setBounds(307, 6, 90, 16);
		lypCapNhat.add(lblHoTen);

		txtVaiTro = new JComboBox<Object>();
		txtVaiTro.setBounds(304, 71, 149, 28);
		lypCapNhat.add(txtVaiTro);

		JLabel lblVaiTro = new JLabel("Vai trò");
		lblVaiTro.setBounds(307, 54, 75, 16);
		lypCapNhat.add(lblVaiTro);

		JLabel lblMoTa = new JLabel("Mô tả chuyên đề");
		lblMoTa.setBounds(9, 113, 88, 16);
		lypCapNhat.add(lblMoTa);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 141, 578, 120);
		lypCapNhat.add(scrollPane_1);

		JTextArea txtMoTa = new JTextArea();
		scrollPane_1.setViewportView(txtMoTa);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(6, 266, 60, 28);
		lypCapNhat.add(btnAdd);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setBounds(72, 266, 60, 28);
		lypCapNhat.add(btnUpdate);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.setBounds(138, 266, 60, 28);
		lypCapNhat.add(btnDelete);

		JButton btnClear = new JButton("Mới");
		btnClear.setBounds(204, 266, 60, 28);
		lypCapNhat.add(btnClear);

		JButton btnBegin = new JButton("|<");
		btnBegin.setBounds(387, 266, 45, 28);
		lypCapNhat.add(btnBegin);

		JButton btnBack = new JButton("<<");
		btnBack.setBounds(435, 266, 45, 28);
		lypCapNhat.add(btnBack);

		JButton btnNext = new JButton(">>");
		btnNext.setBounds(485, 266, 45, 28);
		lypCapNhat.add(btnNext);

		JButton btnEnd = new JButton(">|");
		btnEnd.setBounds(535, 266, 45, 28);
		lypCapNhat.add(btnEnd);
	}
}
