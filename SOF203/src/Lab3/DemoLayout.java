package Lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.SwingConstants;

public class DemoLayout extends JFrame implements ActionListener{
	private JPanel panel1, panel2, panel3, panel4;
	private JButton btnRed, btnGreen, btnYellow;
	private JButton btnNorth, btnCenter, btnSouth, btnEast, btnWest;
	private JTextField txtComment;
	
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
		this.setSize(321, 375);
		
		panel1 = new JPanel(new FlowLayout());
		panel1.setBackground(new Color(240, 230, 140));
		panel1.setSize(800, 200);
		getContentPane().add(panel1);
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
		
		panel2 = new JPanel(new BorderLayout());
		getContentPane().add(panel2);
		btnNorth = new JButton("North");
		btnCenter = new JButton("Center");
		btnSouth = new JButton("South");
		btnEast = new JButton("East");
		btnWest = new JButton("West");
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
		getContentPane().add(panel3);
		txtComment = new JTextField(10);
		txtComment.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(txtComment);
		
		panel4 = new JPanel(new GridLayout(2, 5));
		panel4.setBackground(new Color(255, 192, 203));
		getContentPane().add(panel4);
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel4.add(btn);
		}
		
		
		getContentPane().setLayout(new GridLayout(4, 1));
		this.pack();
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
