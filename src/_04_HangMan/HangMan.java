package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan implements KeyListener {
	Stack<String> stack = new Stack<String>();
	String st = "";
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	String z2 = "                                            ";
	String z = "";
	int lives = 10;
	int numberOfTimesPlayed = 1;

	public static void main(String[] args) {
		HangMan man = new HangMan();
		man.run();
	}

	void run() {
		String num = JOptionPane.showInputDialog("How many times would you like to play hangman?");
		int numint = Integer.parseInt(num);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(label);
		while (stack.size() < numint) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!stack.contains(s)) {
				stack.push(s);
			}
		}
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(400, 220));
		label.setPreferredSize(new Dimension(300, 200));
		frame.addKeyListener(this);
		st = stack.pop();

		for (int i = 0; i < st.length(); i++) {
			z += "_";
		}
		label.setText(z2 + z);
		frame.pack();
		JOptionPane.showMessageDialog(null, "Guess the word. You have 10 lives.");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char r = e.getKeyChar();
		for (int a = 0; a < st.length(); a++) {
			if (r == st.charAt(a)) {
				z = z.substring(0, a) + r + z.substring(a + 1, z.length());
				label.setText(z2 + z);
				if (!z.contains("_")) {
					JOptionPane.showMessageDialog(null, "Yay you solved the word: " + st);
					if (stack.size() >= 1) {
						String playagain = JOptionPane.showInputDialog(null, "Would you like to play again?");
						if (playagain.equalsIgnoreCase("yes")) {
							z = "";
							label.setText("");
							st = stack.pop();

							for (int i = 0; i < st.length(); i++) {
								z += "_";
							}
							label.setText(z2 + z);
							frame.pack();
							JOptionPane.showMessageDialog(null, "Guess the word. You have 10 lives.");
						}
					}
					else {
						System.exit(0);
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
