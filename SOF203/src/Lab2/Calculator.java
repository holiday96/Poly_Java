package Lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Calculator {

	private JFrame frmCalculator;
	private String result = "0";
	private String num = "";
	private JLabel lblResult;
	private double kq;
	private String operator = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
		///dfdfdffefee
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 277, 244);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.setLocationRelativeTo(null);
		frmCalculator.getContentPane().setLayout(null);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBounds(10, 4, 243, 25);
		frmCalculator.getContentPane().add(pnlTitle);
		pnlTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTitle = new JLabel("CASIO");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		pnlTitle.add(lblTitle);

		JPanel pnlResult = new JPanel();
		pnlResult.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlResult.setBounds(10, 32, 243, 36);
		frmCalculator.getContentPane().add(pnlResult);
		pnlResult.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		lblResult = new JLabel("0");
		lblResult.setForeground(Color.BLUE);
		lblResult.setFont(new Font("SansSerif", Font.PLAIN, 22));
		pnlResult.add(lblResult);

		JPanel pnlFunction = new JPanel();
		pnlFunction.setBounds(6, 80, 250, 120);
		frmCalculator.getContentPane().add(pnlFunction);
		pnlFunction.setLayout(null);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn1.getText();
				} else if (result.length() < 19) {
					result += btn1.getText();
				} else {
					JOptionPane.showMessageDialog(btn1, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn1.setBounds(0, 0, 50, 30);
		pnlFunction.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn2.getText();
				} else if (result.length() < 19) {
					result += btn2.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn2, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn2.setBounds(50, 0, 50, 30);
		pnlFunction.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn3.getText();
				} else if (result.length() < 19) {
					result += btn3.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn3, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn3.setBounds(100, 0, 50, 30);
		pnlFunction.add(btn3);

		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.isEmpty()) {
					operator = "/";
				}
				result();
				show();
				operator = "/";
			}
		});
		btnDiv.setBounds(150, 0, 50, 30);
		pnlFunction.add(btnDiv);

		JButton btnSqrt = new JButton("sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqrt();
			}
		});
		btnSqrt.setBounds(200, 0, 50, 30);
		pnlFunction.add(btnSqrt);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn4.getText();
				} else if (result.length() < 19) {
					result += btn4.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn4, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn4.setBounds(0, 30, 50, 30);
		pnlFunction.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn5.getText();
				} else if (result.length() < 19) {
					result += btn5.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn5, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn5.setBounds(50, 30, 50, 30);
		pnlFunction.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn6.getText();
				} else if (result.length() < 19) {
					result += btn6.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn6, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn6.setBounds(100, 30, 50, 30);
		pnlFunction.add(btn6);

		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.isEmpty()) {
					operator = "*";
				}
				result();
				show();
				operator = "*";
			}
		});
		btnMul.setBounds(150, 30, 50, 30);
		pnlFunction.add(btnMul);

		JButton btnMod = new JButton("%");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.isEmpty()) {
					operator = "%";
				}
				result();
				show();
				operator = "%";
			}
		});
		btnMod.setBounds(200, 30, 50, 30);
		pnlFunction.add(btnMod);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn7.getText();
				} else if (result.length() < 19) {
					result += btn7.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn7, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn7.setBounds(0, 60, 50, 30);
		pnlFunction.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn8.getText();
				} else if (result.length() < 19) {
					result += btn8.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn8, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn8.setBounds(50, 60, 50, 30);
		pnlFunction.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn9.getText();
				} else if (result.length() < 19) {
					result += btn9.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn9, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn9.setBounds(100, 60, 50, 30);
		pnlFunction.add(btn9);

		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.isEmpty()) {
					operator = "-";
				}
				result();
				show();
				operator = "-";
			}
		});
		btnSub.setBounds(150, 60, 50, 30);
		pnlFunction.add(btnSub);

		JButton btnReverse = new JButton("1/x");
		btnReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reverse();
			}
		});
		btnReverse.setBounds(200, 60, 50, 30);
		pnlFunction.add(btnReverse);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result.equals("0")) {
					result = btn0.getText();
				} else if (result.length() < 19) {
					result += btn0.getText();
					lblResult.setText(result);
				} else {
					JOptionPane.showMessageDialog(btn0, "Syntax Errror");
				}
				lblResult.setText(result);
			}
		});
		btn0.setBounds(0, 90, 50, 30);
		pnlFunction.add(btn0);

		JButton btnPlusMinus = new JButton("+/-");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!result.equals("0")) {
					if (result.contains("-")) {
						result = result.substring(1);
					} else {
						result = "-" + result;
					}
					lblResult.setText(result);
				}
			}
		});
		btnPlusMinus.setBounds(50, 90, 50, 30);
		pnlFunction.add(btnPlusMinus);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = "0";
				num = "";
				lblResult.setText(result);
			}
		});
		btnC.setBounds(100, 90, 50, 30);
		pnlFunction.add(btnC);

		JButton btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.isEmpty()) {
					operator = "+";
				}
				result();
				show();
				operator = "+";
			}
		});
		btnSum.setBounds(150, 90, 50, 30);
		pnlFunction.add(btnSum);

		JButton btnResult = new JButton("=");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!num.isEmpty()) {
					result();
					show();
					num = ""; // reset result after = clicked
				}
			}
		});
		btnResult.setBounds(200, 90, 50, 30);
		pnlFunction.add(btnResult);
	}

	private void show() {
		if (isNumInteger(kq)) {
			result = String.valueOf((int) kq);
		} else {
			result = String.valueOf(kq);
		}

		if (result == "NaN") {
			lblResult.setText("Error");
		} else if (result == "Infinity") {
			lblResult.setText("Error");
		} else if(result.contains("E")) {
			num = result;
			result = "0";
			lblResult.setText(num.replace("E", "x10^"));
		}else {
			num = result;
			result = "0";
			lblResult.setText(num);
		}
	}

	private boolean isNumInteger(double a) {
		if ((a - (int) a) == 0) {
			return true;
		}
		return false;
	}

	private void sum() {
		if (num.isEmpty()) {
			kq = Double.parseDouble(result);
		} else {
			kq = Double.parseDouble(num) + Double.parseDouble(result);
		}
	}

	private void sub() {
		if (num.isEmpty()) {
			kq = Double.parseDouble(result);
		} else {
			kq = Double.parseDouble(num) - Double.parseDouble(result);
		}
	}

	private void mul() {
		if (num.isEmpty()) {
			kq = Double.parseDouble(result);
		} else {
			kq = Double.parseDouble(num) * Double.parseDouble(result);
		}
	}

	private void div() {
		if (num.isEmpty()) {
			kq = Double.parseDouble(result);
		} else {
			kq = Double.parseDouble(num) / Double.parseDouble(result);
		}
	}

	private void sqrt() {
		if (!operator.isEmpty()) {
			result();
			kq = Math.sqrt(kq);
		} else {
			kq = Math.sqrt(Double.parseDouble(result));
		}
		show();
	}

	private void mod() {
		if (num.isEmpty()) {
			kq = Double.parseDouble(result);
		} else {
			kq = Double.parseDouble(num) % Double.parseDouble(result);
		}
	}

	private void reverse() {
		if (!operator.isEmpty()) {
			result();
		}
		kq = 1 / Double.parseDouble(result);
		show();
	}

	private void result() {
		switch (operator) {
		case "+":
			sum();
			break;
		case "-":
			sub();
			break;
		case "*":
			mul();
			break;
		case "/":
			div();
			break;
		case "%":
			mod();
			break;
		}
	}
}
