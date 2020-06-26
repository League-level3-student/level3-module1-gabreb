package _01_IntroToArrayLists;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	_02_GuestBook() {
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		b1.setText("Add Name");
		b2.setText("View Names");
		b1.addActionListener(this);
		b2.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
	}
	public static void main(String[] args) {
		_02_GuestBook gbook = new _02_GuestBook();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String add = JOptionPane.showInputDialog("Enter a name!");
			names.add(add);
		}
		if (e.getSource()==b2) {
			String s = "";
			for (int i = 0; i < names.size(); i++) {
				s+="Guest #" + (i+1) + " : " + names.get(i) +"\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
	}

}
