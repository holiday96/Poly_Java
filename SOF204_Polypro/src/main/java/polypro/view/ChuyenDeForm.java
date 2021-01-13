package polypro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

public class ChuyenDeForm extends JFrame {

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
	private String hinh;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../../icon/Lists.png")));
		setVisible(true);
		setBounds(100, 100, 620, 492);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("EduSys - Quản lý chuyên đề");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ CHUYÊN ĐỀ");
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTitle.setBounds(6, 6, 159, 20);
		getContentPane().add(lblTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 27, 590, 430);
		getContentPane().add(tabbedPane);

		model = new DefaultTableModel(column, 0);

		JLayeredPane lypDanhSach = new JLayeredPane();
		tabbedPane.addTab("DANH SÁCH", null, lypDanhSach, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 590, 394);
		lypDanhSach.add(scrollPane);
		tblDanhSach = new JTable(model);
		scrollPane.setViewportView(tblDanhSach);
		tblDanhSach.getColumnModel().getColumn(0).setMaxWidth(70);

		JLayeredPane lypCapNhat = new JLayeredPane();
		tabbedPane.addTab("CẬP NHẬT", null, lypCapNhat, null);

		JLabel lblTitleLogo = new JLabel("Hình Logo");
		lblTitleLogo.setBounds(6, 6, 57, 16);
		lypCapNhat.add(lblTitleLogo);

		lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoClicked();
			}
		});
		lblLogo.setBounds(6, 23, 164, 177);
		lypCapNhat.add(lblLogo);

		JLabel lblMaCD = new JLabel("Mã chuyên đề");
		lblMaCD.setBounds(185, 6, 75, 16);
		lypCapNhat.add(lblMaCD);

		txtMaCD = new JTextField();
		txtMaCD.setBounds(182, 23, 402, 28);
		lypCapNhat.add(txtMaCD);
		txtMaCD.setColumns(10);

		JLabel lblTenCD = new JLabel("Tên chuyên đề");
		lblTenCD.setBounds(185, 56, 80, 16);
		lypCapNhat.add(lblTenCD);

		txtTenCD = new JTextField();
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(182, 73, 402, 28);
		lypCapNhat.add(txtTenCD);

		txtThoiLuong = new JTextField();
		txtThoiLuong.setColumns(10);
		txtThoiLuong.setBounds(182, 124, 402, 28);
		lypCapNhat.add(txtThoiLuong);

		JLabel lblThoiLuong = new JLabel("Thời lượng (giờ)");
		lblThoiLuong.setBounds(185, 107, 90, 16);
		lypCapNhat.add(lblThoiLuong);

		txtHocPhi = new JTextField();
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

		JTextArea txtMoTa = new JTextArea();
		scrollPane_1.setViewportView(txtMoTa);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(6, 355, 60, 28);
		lypCapNhat.add(btnAdd);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setBounds(72, 355, 60, 28);
		lypCapNhat.add(btnUpdate);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.setBounds(138, 355, 60, 28);
		lypCapNhat.add(btnDelete);

		JButton btnClear = new JButton("Mới");
		btnClear.setBounds(204, 355, 60, 28);
		lypCapNhat.add(btnClear);

		JButton btnBegin = new JButton("|<");
		btnBegin.setBounds(387, 355, 45, 28);
		lypCapNhat.add(btnBegin);

		JButton btnBack = new JButton("<<");
		btnBack.setBounds(435, 355, 45, 28);
		lypCapNhat.add(btnBack);

		JButton btnNext = new JButton(">>");
		btnNext.setBounds(485, 355, 45, 28);
		lypCapNhat.add(btnNext);

		JButton btnEnd = new JButton(">|");
		btnEnd.setBounds(535, 355, 45, 28);
		lypCapNhat.add(btnEnd);
	}

	protected void logoClicked() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			lblLogo.setIcon(new ImageIcon(this.getClass().getResource(fileChooser.getSelectedFile().getAbsolutePath())));
			hinh = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(hinh);
		}
	}
}
