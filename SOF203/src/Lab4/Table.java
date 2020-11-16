package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Table extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175112032512525117L;
	private JTable table;
	private JTextField txtMaSanPham;
	private JTextField txtDonGia;
	private JTextField txtTenSanPham;
	private JTextField txtNhaCungCap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new Table();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 580, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(new Color(51, 153, 204));
		table.setBorder(new TitledBorder(new LineBorder(new Color(102, 153, 255)), "Danh s\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 0, 20), new Color(255, 51, 51)));
		getContentPane().add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlInfo = new JPanel();
		panel.add(pnlInfo, BorderLayout.CENTER);
		pnlInfo.setLayout(new GridLayout(3, 4, 0, 0));
		
		JLabel lblMaSanPham = new JLabel("Mã Sản phẩm");
		pnlInfo.add(lblMaSanPham);
		
		txtMaSanPham = new JTextField();
		pnlInfo.add(txtMaSanPham);
		txtMaSanPham.setColumns(10);
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		pnlInfo.add(lblDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		pnlInfo.add(txtDonGia);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản phẩm");
		pnlInfo.add(lblTenSanPham);
		
		txtTenSanPham = new JTextField();
		txtTenSanPham.setColumns(10);
		pnlInfo.add(txtTenSanPham);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp");
		pnlInfo.add(lblNhaCungCap);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setColumns(10);
		pnlInfo.add(txtNhaCungCap);
		
		JLabel lblDonViTinh = new JLabel("Đơn vị tính");
		pnlInfo.add(lblDonViTinh);
		
		JComboBox<Object> cboDonViTinh = new JComboBox<Object>();
		cboDonViTinh.setModel(new DefaultComboBoxModel<Object>(new String[] {"Chai", "KG", "Hộp"}));
		pnlInfo.add(cboDonViTinh);
		
		JPanel pnlButton = new JPanel();
		panel.add(pnlButton, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Thêm Sản phẩm");
		pnlButton.add(btnAdd);
		
		JButton btnRemove = new JButton("Xoá Sản phẩm");
		pnlButton.add(btnRemove);
		
		JButton btnEdit = new JButton("Chỉnh sửa thông tin");
		pnlButton.add(btnEdit);
	}

}
