package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904860120027491175L;
	private JTextField txtId;
	private JTextField txtIdShow;
	private JTextField txtEnglishMark;
	private JTextField txtInformaticMark;
	private JTextField txtPhysicEduMark;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new AdminForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminForm() {
		initializer();
	}

	private void initializer() {
		setTitle("Quản Lý Điểm Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 605);
		setVisible(true);
		setLocationRelativeTo(null);getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Quản Lý Điểm Sinh Viên");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setForeground(new Color(102, 0, 255));
		lblTitle.setBounds(100, 6, 242, 25);
		getContentPane().add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel.setBounds(41, 37, 360, 81);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Mã SV:");
		lblId.setBounds(38, 37, 39, 16);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(89, 31, 165, 28);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchButton();
			}
		});
		btnSearch.setBounds(266, 31, 67, 28);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(41, 130, 285, 190);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Họ tên SV:");
		lblName.setBounds(27, 18, 58, 16);
		panel_1.add(lblName);
		
		JLabel lblIdShow = new JLabel("Mã SV:");
		lblIdShow.setBounds(46, 52, 39, 16);
		panel_1.add(lblIdShow);
		
		txtIdShow = new JTextField();
		txtIdShow.setBounds(92, 46, 112, 28);
		panel_1.add(txtIdShow);
		txtIdShow.setColumns(10);
		
		JLabel lblNameShow = new JLabel("");
		lblNameShow.setBounds(94, 18, 110, 16);
		panel_1.add(lblNameShow);
		lblNameShow.setForeground(new Color(51, 102, 255));
		
		JLabel lblEnglishMark = new JLabel("Tiếng Anh:");
		lblEnglishMark.setBounds(27, 86, 59, 16);
		panel_1.add(lblEnglishMark);
		
		txtEnglishMark = new JTextField();
		txtEnglishMark.setBounds(92, 80, 112, 28);
		panel_1.add(txtEnglishMark);
		txtEnglishMark.setColumns(10);
		
		JLabel lblInformaticMark = new JLabel("Tin học:");
		lblInformaticMark.setBounds(42, 120, 43, 16);
		panel_1.add(lblInformaticMark);
		
		txtInformaticMark = new JTextField();
		txtInformaticMark.setBounds(92, 114, 112, 28);
		panel_1.add(txtInformaticMark);
		txtInformaticMark.setColumns(10);
		
		JLabel lblPhysicEduMark = new JLabel("Giáo dục TC:");
		lblPhysicEduMark.setBounds(14, 154, 71, 16);
		panel_1.add(lblPhysicEduMark);
		
		txtPhysicEduMark = new JTextField();
		txtPhysicEduMark.setBounds(92, 148, 112, 28);
		panel_1.add(txtPhysicEduMark);
		txtPhysicEduMark.setColumns(10);
		
		JLabel lblAverage = new JLabel("Điểm TB:");
		lblAverage.setBounds(216, 104, 55, 16);
		panel_1.add(lblAverage);
		
		JLabel lblNewLabel_4_1 = new JLabel("10.0");
		lblNewLabel_4_1.setBounds(221, 120, 42, 29);
		panel_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setForeground(new Color(51, 102, 255));
		lblNewLabel_4_1.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewButton();
			}
		});
		btnNew.setBounds(350, 130, 90, 28);
		getContentPane().add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveButton();
			}
		});
		btnSave.setBounds(350, 170, 90, 28);
		getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteButton();
			}
		});
		btnDelete.setBounds(350, 210, 90, 28);
		getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateButton();
			}
		});
		btnUpdate.setBounds(350, 250, 90, 28);
		getContentPane().add(btnUpdate);
		
		JButton btnFirst = new JButton("|<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstButton();
			}
		});
		btnFirst.setBounds(41, 328, 38, 28);
		getContentPane().add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackButton();
			}
		});
		btnBack.setBounds(92, 328, 38, 28);
		getContentPane().add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextButton();
			}
		});
		btnNext.setBounds(142, 328, 38, 28);
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LastButton();
			}
		});
		btnLast.setBounds(192, 328, 38, 28);
		getContentPane().add(btnLast);
		
		JLabel lblHighMarks = new JLabel("3 Sinh viên có điểm cao nhất");
		lblHighMarks.setForeground(new Color(51, 102, 255));
		lblHighMarks.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblHighMarks.setBounds(14, 366, 188, 20);
		getContentPane().add(lblHighMarks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 390, 444, 160);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	protected void LastButton() {
		// TODO Auto-generated method stub
		
	}

	protected void NextButton() {
		// TODO Auto-generated method stub
		
	}

	protected void BackButton() {
		// TODO Auto-generated method stub
		
	}

	protected void FirstButton() {
		// TODO Auto-generated method stub
		
	}

	protected void UpdateButton() {
		// TODO Auto-generated method stub
		
	}

	protected void DeleteButton() {
		// TODO Auto-generated method stub
		
	}

	protected void SaveButton() {
		// TODO Auto-generated method stub
		
	}

	protected void NewButton() {
		// TODO Auto-generated method stub
		
	}

	protected void SearchButton() {
		// TODO Auto-generated method stub
		
	}
}
