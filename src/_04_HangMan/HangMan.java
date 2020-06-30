package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan implements KeyListener{
	Stack<String> stack = new Stack<String>();
	String st = "";
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	String z2 = "                                            ";
	String z = "";

	public static void main(String[] args) {
		HangMan man = new HangMan(); 
		man.run();
	}
				
	void run() {
		String num = JOptionPane.showInputDialog("Enter a number from 1 to 266");
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
			frame.setPreferredSize(new Dimension(400,220));
			label.setPreferredSize(new Dimension(300,200));
			frame.addKeyListener(this);
			st = stack.pop();
			
			for (int i = 0; i < st.length(); i++) {
				z += "_";
			}
			label.setText(z2+z);
			frame.pack();
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
					z = z.substring(0,a) + r + z.substring(a+1, z.length());
					label.setText(z2+z);
				}
			}
		}
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
