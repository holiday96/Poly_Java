package Lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class DemoLayout extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8833661739380585019L;
	private JPanel panel1, panel2, panel3, panel4;
	private JButton btnRed, btnGreen, btnYellow;
	private JButton btnNorth, btnCenter, btnSouth, btnEast, btnWest;
	private JTextField txtComment;
	private BoxLayout boxLayout;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					new DemoLayout();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DemoLayout() {
		initializer();
	}
	
	private void initializer() {
		this.setVisible(true);
		this.setTitle("Demo Layout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(600, 430);
		JPanel panel = new JPanel();
        boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        getContentPane().add(panel);
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		panel1.setBackground(new Color(240, 230, 140));
		btnRed = new JButton("Red");
		btnGreen = new JButton("Green");
		btnYellow = new JButton("Yellow");
		panel1.add(btnRed);
		panel1.add(btnGreen);
		panel1.add(btnYellow);
		btnRed.setActionCommand("red");
		btnRed.addActionListener(this);
		btnGreen.setActionCommand("green");
		btnGreen.addActionListener(this);
		btnYellow.setActionCommand("yellow");
		btnYellow.addActionListener(this);
		panel.add(panel1);
		
		panel2 = new JPanel(new BorderLayout());
		btnNorth = new JButton("North");
		btnCenter = new JButton("Center");
		btnSouth = new JButton("South");
		btnEast = new JButton("East");
		btnWest = new JButton("West");
		panel.add(panel2);
		
		panel2.add(btnNorth, BorderLayout.NORTH);
		panel2.add(btnCenter, BorderLayout.CENTER);
		panel2.add(btnSouth, BorderLayout.SOUTH);
		panel2.add(btnEast, BorderLayout.EAST);
		panel2.add(btnWest, BorderLayout.WEST);
		btnNorth.setActionCommand("north");
		btnNorth.addActionListener(this);
		btnCenter.setActionCommand("center");
		btnCenter.addActionListener(this);
		btnSouth.setActionCommand("south");
		btnSouth.addActionListener(this);
		btnEast.setActionCommand("east");
		btnEast.addActionListener(this);
		btnWest.setActionCommand("west");
		btnWest.addActionListener(this);
		
		panel3 = new JPanel();
		panel3.setBorder(new EmptyBorder(new Insets(5, 0, 5, 0)));
		txtComment = new JTextField(40);
		txtComment.setForeground(new Color(34, 139, 34));
		txtComment.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtComment.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(txtComment);
		panel.add(panel3);
		
		panel4 = new JPanel(new GridLayout(2, 5));
		panel4.setBackground(new Color(255, 192, 203));
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			btn.setFont(new Font("SansSerif", Font.PLAIN, 30));
			panel4.add(btn);
		}
		panel.add(panel4);
		
		panel.setBorder(new EmptyBorder(new Insets(10, 10, 50, 10)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//panel 1
		if(e.getActionCommand().equals("red")) {
			panel1.setBackground(Color.RED);
		}
		if(e.getActionCommand().equals("green")) {
			panel1.setBackground(Color.GREEN);
		}
		if(e.getActionCommand().equals("yellow")) {
			panel1.setBackground(Color.YELLOW);
		}
		//panel 2+3
		if(e.getActionCommand().equals("north")) {
			txtComment.setText("North");
		}if(e.getActionCommand().equals("south")) {
			txtComment.setText("South");
		}if(e.getActionCommand().equals("east")) {
			txtComment.setText("East");
		}if(e.getActionCommand().equals("west")) {
			txtComment.setText("West");
		}if(e.getActionCommand().equals("center")) {
			txtComment.setText("Center");
		}
	}
}
