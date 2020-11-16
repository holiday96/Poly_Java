package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Table extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175112032512525117L;
	private JTable table;
	private JTextField txtMaSanPham;
	private JTextField txtDonGia;
	private JTextField txtTenSanPham;
	private JTextField txtNhaCungCap;
	private JComboBox<Object> cboDonViTinh;
	private DefaultTableModel tableModel;
	private String column[] = { "Mã SP", "Tên SP", "ĐVT", "Đơn giá bán", "Nhà cung cấp" };
	private String data[][] = {
			{ "SP01", "Dầu gội đầu Head & Shoulder", DonViTinh.Chai.toString(), "34000", "Unilevers" },
			{ "SP02", "Xà bông Omo", DonViTinh.Thùng.toString(), "124000", "Unilevers" },
			{ "SP03", "Dầu ăn Tường An 5L", DonViTinh.Chai.toString(), "100000", "Tường An" },
			{ "SP04", "Mì ăn liền Hảo Hảo", DonViTinh.Thùng.toString(), "75000", "AceCook" },
			{ "SP05", "Đường tinh luyện", DonViTinh.KG.toString(), "14000", "Đường Biên Hoà" },
			{ "SP06", "Sữa Ông Thọ", DonViTinh.Lon.toString(), "13000", "VinaMilk" },
			{ "SP07", "Rượu nho Hương Nhiên", DonViTinh.Chai.toString(), "12000", "Cty Hương Nhiên" } };
	private List<SanPham> list = new ArrayList<>();

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
		setTitle("Table Demo");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 600, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));

		tableModel = new DefaultTableModel(data, column);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTable();
			}
		});
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.WHITE);
		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(Color.PINK);
		pnlTable.setBorder(new TitledBorder(new LineBorder(new Color(51, 51, 204)), "Danh s\u00E1ch S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnlTable.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane sp = new JScrollPane(table);
		pnlTable.add(sp);
		getContentPane().add(pnlTable, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBackground(new Color(245, 222, 179));
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

		cboDonViTinh = new JComboBox<Object>();
		cboDonViTinh.setModel(new DefaultComboBoxModel<Object>(DonViTinh.values()));
		pnlInfo.add(cboDonViTinh);

		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(new Color(0, 128, 128));
		panel.add(pnlButton, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Thêm Sản phẩm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
				refreshTable();
			}
		});
		pnlButton.add(btnAdd);

		JButton btnRemove = new JButton("Xoá Sản phẩm");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemove();
				refreshTable();
			}
		});
		pnlButton.add(btnRemove);

		JButton btnEdit = new JButton("Chỉnh sửa thông tin");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit();
				refreshTable();
			}
		});
		pnlButton.add(btnEdit);

		for (int i = 0; i < data.length; i++) {
			list.add(new SanPham(data[i][0], data[i][1], DonViTinh.valueOf(data[i][2]), Long.parseLong(data[i][3]),
					data[i][4]));
		}
	}

	protected void selectedTable() {
		int index = table.getSelectedRow();
		txtMaSanPham.setText(list.get(index).getMaSP());
		txtTenSanPham.setText(list.get(index).getTenSP());
		cboDonViTinh.setSelectedItem(DonViTinh.valueOf(list.get(index).getDvt().toString()));
		txtDonGia.setText(String.valueOf(list.get(index).getDonGiaBan()));
		txtNhaCungCap.setText(list.get(index).getNhaCungCap());
	}

	protected void btnEdit() {
		int index = table.getSelectedRow();
		list.remove(index);
		list.add(index, new SanPham(txtMaSanPham.getText(), txtTenSanPham.getText(),
				DonViTinh.valueOf(cboDonViTinh.getSelectedItem().toString()), Long.parseLong(txtDonGia.getText()),
				txtNhaCungCap.getText()));
	}

	protected void btnRemove() {
		list.remove(table.getSelectedRow());
	}

	protected void btnAdd() {
		list.add(new SanPham(txtMaSanPham.getText(), txtTenSanPham.getText(),
				DonViTinh.valueOf(cboDonViTinh.getSelectedItem().toString()), Long.parseLong(txtDonGia.getText()),
				txtNhaCungCap.getText()));
	}
	
	private void refreshTable() {
		tableModel.setRowCount(0);
		for (SanPham sp : list) {
			tableModel.addRow(new Object[] {sp.getMaSP(), sp.getTenSP(), sp.getDvt().toString(), String.valueOf(sp.getDonGiaBan()), sp.getNhaCungCap()});
		}
	}
}
