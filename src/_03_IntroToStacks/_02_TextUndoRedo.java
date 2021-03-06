package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> stack = new Stack<Character>();
	String s = "";

	
	_02_TextUndoRedo() {
		frame.add(panel);
		panel.add(label);
		frame.setSize(700,400);
		label.setSize(350, 300);
		label.setText("");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	/**
	 *
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

			stack.push((s.charAt(s.length()-1)));
			s = s.substring(0,s.length()-1);
		}
		else if (e.getKeyCode()==KeyEvent.VK_B) {
			if (!stack.isEmpty()) {
				s+=stack.pop();
			}
		}
		else {
		s+=e.getKeyChar();
		}
		label.setText(s);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}
