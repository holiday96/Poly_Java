package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4901337893774586484L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtFpolyJava;
	private JTextArea textArea;
	private JRadioButtonMenuItem rdbtnmntmRed, rdbtnmntmGreen, rdbtnmntmBlue;
	/**
	 * @wbp.nonvisual location=484,59
	 */
	private final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Menu window = new Menu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newSelect();
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);

		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fileChooser.setVisible(true);
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem_1);

		JMenu mnColor = new JMenu("Color");
		mnColor.setMnemonic('C');
		menuBar.add(mnColor);

		rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		rdbtnmntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redClicked();
			}
		});
		buttonGroup.add(rdbtnmntmRed);
		rdbtnmntmRed.setForeground(new Color(255, 51, 51));
		mnColor.add(rdbtnmntmRed);

		rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
		rdbtnmntmGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				greenClicked();
			}
		});
		buttonGroup.add(rdbtnmntmGreen);
		rdbtnmntmGreen.setForeground(new Color(51, 255, 0));
		mnColor.add(rdbtnmntmGreen);

		rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		rdbtnmntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blueClicked();
			}
		});
		buttonGroup.add(rdbtnmntmBlue);
		rdbtnmntmBlue.setEnabled(true);
		rdbtnmntmBlue.setBackground(new Color(255, 255, 255));
		rdbtnmntmBlue.setForeground(new Color(0, 153, 204));
		mnColor.add(rdbtnmntmBlue);

		JSeparator separator = new JSeparator();
		mnColor.add(separator);

		JRadioButtonMenuItem rdbtnmntmText = new JRadioButtonMenuItem("Text Color");
		rdbtnmntmText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textColor();
			}
		});
		buttonGroup.add(rdbtnmntmText);
		mnColor.add(rdbtnmntmText);

		JMenu mnSystem = new JMenu("System");
		mnSystem.setMnemonic('S');
		menuBar.add(mnSystem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About us");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		mnSystem.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnSystem.add(mntmNewMenuItem_3);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newSelect();
			}
		});
		btnNew.setIcon(new ImageIcon(this.getClass().getResource("/images/1.png")));
		toolBar.add(btnNew);

		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		btnInfo.setIcon(new ImageIcon(this.getClass().getResource("/images/2.png")));
		toolBar.add(btnInfo);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setIcon(new ImageIcon(this.getClass().getResource("/images/3.png")));
		toolBar.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 1 };
		gbl_panel.rowHeights = new int[] { 15, 41, 0, 3 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		txtFpolyJava = new JTextField();
		txtFpolyJava.setHorizontalAlignment(SwingConstants.CENTER);
		txtFpolyJava.setText("FPoly - Java 3");
		txtFpolyJava.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_txtFpolyJava = new GridBagConstraints();
		gbc_txtFpolyJava.insets = new Insets(0, 0, 5, 0);
		gbc_txtFpolyJava.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFpolyJava.gridx = 0;
		gbc_txtFpolyJava.gridy = 1;
		panel.add(txtFpolyJava, gbc_txtFpolyJava);
		txtFpolyJava.setColumns(10);

	}

	private void about() {
		JOptionPane.showMessageDialog(this, "Program Demo Menu\nAuthor: XuShiTa\nLast Update: 14-Nov-2020\nEducation: FPoly");
	}

	private void textColor() {
		new JColorChooser();
		Color color = JColorChooser.showDialog(this, "Select Color of Text", null);
		txtFpolyJava.setForeground(color);
	}

	private void exit() {
		System.exit(0);
	}

	private void blueClicked() {
		txtFpolyJava.setBackground(rdbtnmntmBlue.getForeground());
	}

	private void greenClicked() {
		txtFpolyJava.setBackground(rdbtnmntmGreen.getForeground());
	}

	private void redClicked() {
		txtFpolyJava.setBackground(rdbtnmntmRed.getForeground());
	}

	private void save() {
		int returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				textArea.write(output);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void open() {
		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				textArea.read(input, "read");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void newSelect() {
		textArea.setText(null);
	}
}
