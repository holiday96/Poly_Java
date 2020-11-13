package Lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EmployeeManagement extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -289581097040667283L;

	private JPanel panel, panel1, panel2, panel3, panel4;
	private JLabel lblHo, lblTen, lblBietDanh, lblMatMa, lblQue, lblSoThich, lblGhiChu;
	private JTextField txtHo, txtTen, txtBietDanh;
	private JTextArea txtGhiChu;
	private JPasswordField txtMatMa;
	private JRadioButton rdoNam, rdoNu, rdoKoXD;
	private JComboBox<Object> cboQue;
	private JCheckBox chkAnChoi, chkNhayMua, chkNguNghi;
	private JButton btnOK, btnReset, btnExit;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private JScrollPane scrollPane;

	public EmployeeManagement() {
		initializer();
	}

	private void initializer() {
		setTitle("Employee Management");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(630, 455);
		setVisible(true);

		panel = new JPanel();
		getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		panel.setLayout(null);

		// Panel Ho ten
		panel1 = new JPanel();
		panel1.setBounds(10, 10, 600, 98);
		panel1.setBackground(new Color(152, 251, 152));
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "H\u1ECD t\u00EAn",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.add(panel1);
		panel1.setLayout(null);
		lblHo = new JLabel("Họ:");
		lblHo.setBounds(20, 24, 19, 16);
		panel1.add(lblHo);
		lblTen = new JLabel("Tên:");
		lblTen.setBounds(307, 24, 24, 16);
		panel1.add(lblTen);
		lblBietDanh = new JLabel("Bí danh:");
		lblBietDanh.setBounds(20, 57, 45, 16);
		panel1.add(lblBietDanh);
		lblMatMa = new JLabel("Mật mã:");
		lblMatMa.setBounds(307, 57, 43, 16);
		panel1.add(lblMatMa);
		txtHo = new JTextField();
		txtHo.setBounds(70, 18, 232, 28);
		txtHo.setColumns(20);
		txtHo.setToolTipText("Please Insert Surname");
		panel1.add(txtHo);
		txtTen = new JTextField();
		txtTen.setBounds(355, 18, 232, 28);
		txtTen.setColumns(20);
		txtTen.setToolTipText("Please Insert Name");
		panel1.add(txtTen);
		txtBietDanh = new JTextField();
		txtBietDanh.setBounds(70, 51, 232, 28);
		txtBietDanh.setColumns(20);
		txtBietDanh.setToolTipText("Please Insert Nickname");
		panel1.add(txtBietDanh);
		txtMatMa = new JPasswordField();
		txtMatMa.setBounds(355, 51, 232, 28);
		txtMatMa.setColumns(20);
		txtMatMa.setToolTipText("Please Insert Password");
		panel1.add(txtMatMa);

		// Panel Gioi tinh
		panel2 = new JPanel();
		panel2.setBounds(10, 120, 600, 60);
		panel2.setBackground(new Color(238, 232, 170));
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Gi\u1EDBi t\u00EDnh",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.add(panel2);
		rdoNam = new JRadioButton("Nam");
		btnGroupGender.add(rdoNam);
		rdoNam.setBounds(116, 23, 49, 18);
		rdoNu = new JRadioButton("Nữ");
		btnGroupGender.add(rdoNu);
		rdoNu.setBounds(254, 23, 39, 18);
		rdoKoXD = new JRadioButton("Không xác định");
		btnGroupGender.add(rdoKoXD);
		rdoKoXD.setBounds(365, 23, 106, 18);
		panel2.setLayout(null);
		panel2.add(rdoNam);
		panel2.add(rdoNu);
		panel2.add(rdoKoXD);

		// Panel Thong tin khac
		panel3 = new JPanel();
		panel3.setBounds(10, 192, 600, 180);
		panel3.setBackground(new Color(255, 192, 203));
		panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Th\u00F4ng tin kh\u00E1c", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.add(panel3);
		lblQue = new JLabel("Quê quán");
		lblQue.setBounds(16, 28, 54, 16);
		cboQue = new JComboBox<>();
		cboQue.setModel(new DefaultComboBoxModel<Object>(new String[] { "Ninh Thuận", "Hà Nội" }));
		cboQue.setBounds(96, 23, 139, 26);
		panel3.setLayout(null);
		panel3.add(lblQue);
		panel3.add(cboQue);
		lblSoThich = new JLabel("Sở thích");
		lblSoThich.setBounds(16, 58, 45, 20);
		panel3.add(lblSoThich);
		chkAnChoi = new JCheckBox("Ăn chơi");
		chkAnChoi.setLocation(96, 58);
		chkAnChoi.setSize(70, 20);
		chkNhayMua = new JCheckBox("Nhảy múa");
		chkNhayMua.setLocation(195, 58);
		chkNhayMua.setSize(100, 20);
		chkNguNghi = new JCheckBox("Ngủ nghỉ");
		chkNguNghi.setLocation(305, 58);
		chkNguNghi.setSize(100, 20);
		panel3.add(chkAnChoi);
		panel3.add(chkNhayMua);
		panel3.add(chkNguNghi);
		lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setLocation(16, 90);
		lblGhiChu.setSize(42, 16);
		panel3.add(lblGhiChu);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 90, 351, 84);
		panel3.add(scrollPane);
		txtGhiChu = new JTextArea();
		scrollPane.setViewportView(txtGhiChu);

		panel4 = new JPanel();
		panel4.setSize(600, 60);
		panel4.setLocation(10, 375);
		btnOK = new JButton("OK");
		btnReset = new JButton("Reset");
		btnExit = new JButton("Exit");
		panel.add(panel4);
		panel4.add(btnOK);
		panel4.add(btnReset);
		panel4.add(btnExit);
		btnOK.setActionCommand("ok");
		btnOK.addActionListener(this);
		btnReset.setActionCommand("reset");
		btnReset.addActionListener(this);
		btnExit.setActionCommand("exit");
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ok")) {
			ok();
		}
		if (e.getActionCommand().equals("reset")) {
			reset();
		}
		if (e.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}

	private void ok() {
		StringBuilder sb = new StringBuilder();
		if (!txtHo.getText().isEmpty() || !txtTen.getText().isEmpty() || !txtBietDanh.getText().isEmpty()
				|| !String.valueOf(txtMatMa.getPassword()).isEmpty()) {
			sb.append("Họ tên: " + txtHo.getText() + " " + txtTen.getText() + "\n");
			sb.append(lblBietDanh.getText() + txtBietDanh.getText() + "\n");
			sb.append(lblMatMa.getText() + String.valueOf(txtMatMa.getPassword()) + "\n");
		} else {
			sb.append("Thông tin Họ tên trống\n");
		}
		if (btnGroupGender.isSelected(null)) {
			sb.append("Chưa nhập giới tính\n");
		} else {
			if (rdoNam.isSelected()) {
				sb.append("Giới tính: " + rdoNam.getText() + "\n");
			} else if (rdoNu.isSelected()) {
				sb.append("Giới tính: " + rdoNu.getText() + "\n");
			} else if (rdoKoXD.isSelected()) {
				sb.append("Giới tính: " + rdoKoXD.getText() + "\n");
			}
		}
		sb.append(lblQue.getText() + ": " + cboQue.getSelectedItem().toString() + "\n");
		if (chkAnChoi.isSelected()) {
			sb.append(lblSoThich.getText() + ": " + chkAnChoi.getText() + "\n");
		}
		if (chkNguNghi.isSelected()) {
			sb.append(lblSoThich.getText() + ": " + chkNguNghi.getText() + "\n");
		}
		if (chkNhayMua.isSelected()) {
			sb.append(lblSoThich.getText() + ": " + chkNhayMua.getText() + "\n");
		}
		if (sb.length() != 0) {
			JOptionPane.showMessageDialog(this, sb);
		}
		if (!txtGhiChu.getText().isEmpty()) {
			sb.append(lblGhiChu.getText() + ": " + txtGhiChu.getText());
		}
	}

	private void reset() {
		txtHo.setText(null);
		txtTen.setText(null);
		txtBietDanh.setText(null);
		txtMatMa.setText(null);
		txtGhiChu.setText(null);
		btnGroupGender.clearSelection();
		cboQue.setSelectedIndex(-1);
		chkAnChoi.setSelected(false);
		chkNguNghi.setSelected(false);
		chkNhayMua.setSelected(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new EmployeeManagement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
