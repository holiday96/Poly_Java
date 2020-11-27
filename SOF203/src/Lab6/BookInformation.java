package Lab6;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BookInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8718020519384314554L;
	private JTextField txtTitle;
	private JTable table;
	private String column[] = { "ID", "Title", "Price" };
	private DefaultTableModel model;
	private List<Book> list;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new BookInformation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookInformation() {
		initialize();
		try {
			list = new BookDAO().getListBook();
			fillToTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Book information");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Filter",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(15, 2, 275, 60);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(14, 24, 26, 16);
		panel.add(lblTitle);

		txtTitle = new JTextField();
		txtTitle.setBounds(48, 18, 213, 28);
		panel.add(txtTitle);
		txtTitle.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 69, 414, 159);
		getContentPane().add(scrollPane);

		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detail();
			}
		});
		scrollPane.setViewportView(table);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchClicked();
			}
		});
		btnSearch.setBounds(295, 18, 67, 28);
		getContentPane().add(btnSearch);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitClicked();
			}
		});
		btnExit.setBounds(374, 18, 48, 28);
		getContentPane().add(btnExit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteClicked();
			}
		});
		btnDelete.setBounds(360, 227, 67, 28);
		getContentPane().add(btnDelete);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	protected void detail() {
		index = table.getSelectedRow();
	}

	protected void deleteClicked() {
		if (JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			new BookDAO().deleteBook(list.get(index));
		}
		list = new BookDAO().getListBook();
		fillToTable();
	}

	protected void searchClicked() {
		if (txtTitle.getText().isBlank()) {
			list = new BookDAO().getListBook();
			fillToTable();
		} else {
			list = new BookDAO().searchBook(txtTitle.getText());
			fillToTable();
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(this, "The book is not availble!");
			}
		}
	}

	protected void exitClicked() {
		System.exit(0);
	}

	private void fillToTable() {
		model.setRowCount(0);
		for (Book b : list) {
			model.addRow(new Object[] { b.getId(), b.getTitle(), b.getPrice() });
		}
	}
}
