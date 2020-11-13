package Lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;

public class EmployeeManagement extends JFrame implements ActionListener{
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
	private JComboBox<Que> cboQue;
	private JCheckBox chkAnChoi, chkNhayMua, chkNguNghi;
	private JButton btnOK, btnReset, btnExit;

	public EmployeeManagement() {
		initializer();
	}
	
	private void initializer() {
		setTitle("Employee Management");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Panel Ho ten
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "H\u1ECD t\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.add(panel1);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{19, 24, 45, 43, 0};
		gbl_panel1.rowHeights = new int[]{28, 0, 0};
		gbl_panel1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_panel1);
		lblHo = new JLabel("Họ:");
		GridBagConstraints gbc_lblHo = new GridBagConstraints();
		gbc_lblHo.anchor = GridBagConstraints.WEST;
		gbc_lblHo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHo.gridx = 0;
		gbc_lblHo.gridy = 0;
		panel1.add(lblHo, gbc_lblHo);
		lblTen = new JLabel("Tên:");
		GridBagConstraints gbc_lblTen = new GridBagConstraints();
		gbc_lblTen.anchor = GridBagConstraints.WEST;
		gbc_lblTen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTen.gridx = 2;
		gbc_lblTen.gridy = 0;
		panel1.add(lblTen, gbc_lblTen);
		lblBietDanh = new JLabel("Bí danh:");
		GridBagConstraints gbc_lblBietDanh = new GridBagConstraints();
		gbc_lblBietDanh.anchor = GridBagConstraints.WEST;
		gbc_lblBietDanh.insets = new Insets(0, 0, 0, 5);
		gbc_lblBietDanh.gridx = 0;
		gbc_lblBietDanh.gridy = 1;
		panel1.add(lblBietDanh, gbc_lblBietDanh);
		lblMatMa = new JLabel("Mật mã:");
		GridBagConstraints gbc_lblMatMa = new GridBagConstraints();
		gbc_lblMatMa.anchor = GridBagConstraints.WEST;
		gbc_lblMatMa.insets = new Insets(0, 0, 0, 5);
		gbc_lblMatMa.gridx = 2;
		gbc_lblMatMa.gridy = 1;
		panel1.add(lblMatMa, gbc_lblMatMa);
		txtHo = new JTextField();
		txtHo.setColumns(20);
		txtHo.setToolTipText("Please Insert Surname");
		GridBagConstraints gbc_txtHo = new GridBagConstraints();
		gbc_txtHo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtHo.insets = new Insets(0, 0, 5, 5);
		gbc_txtHo.gridx = 1;
		gbc_txtHo.gridy = 0;
		panel1.add(txtHo, gbc_txtHo);
		txtTen = new JTextField();
		txtTen.setColumns(20);
		txtTen.setToolTipText("Please Insert Name");
		GridBagConstraints gbc_txtTen = new GridBagConstraints();
		gbc_txtTen.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtTen.insets = new Insets(0, 0, 5, 0);
		gbc_txtTen.gridx = 3;
		gbc_txtTen.gridy = 0;
		panel1.add(txtTen, gbc_txtTen);
		txtBietDanh = new JTextField();
		txtBietDanh.setColumns(20);
		txtBietDanh.setToolTipText("Please Insert Nickname");
		GridBagConstraints gbc_txtBietDanh = new GridBagConstraints();
		gbc_txtBietDanh.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtBietDanh.insets = new Insets(0, 0, 0, 5);
		gbc_txtBietDanh.gridx = 1;
		gbc_txtBietDanh.gridy = 1;
		panel1.add(txtBietDanh, gbc_txtBietDanh);
		txtMatMa = new JPasswordField();
		txtMatMa.setColumns(20);
		txtMatMa.setToolTipText("Please Insert Password");
		GridBagConstraints gbc_txtMatMa = new GridBagConstraints();
		gbc_txtMatMa.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtMatMa.gridx = 3;
		gbc_txtMatMa.gridy = 1;
		panel1.add(txtMatMa, gbc_txtMatMa);
		
		panel2 = new JPanel();
		panel.add(panel2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
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
