package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton bt1= new JButton();
	JButton bt2 = new JButton();
	JButton bt3 = new JButton();
	JButton bt4 = new JButton();

	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.run();
	}
	
	
	
	
	void run() {
		frame.add(panel);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(bt4);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt1.setText("Add Entry");
		bt2.setText("Search by ID");
		bt3.setText("View List");
		bt4.setText("Remove Entry");
		bt4.addActionListener(this);
		frame.pack();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bt1) {
			String ID1 = JOptionPane.showInputDialog("Enter an ID number");
			int ID = Integer.parseInt(ID1);
			String name = JOptionPane.showInputDialog("Enter a name");
			hashmap.put(ID, name);
		}
		if(e.getSource() == bt2) {
			String enterID = JOptionPane.showInputDialog("Enter an ID number");
			int eID = Integer.parseInt(enterID);
			if (hashmap.containsKey(eID)) {
				JOptionPane.showMessageDialog(null, "The user's name is " + hashmap.get(eID));
			}
			else {
				JOptionPane.showMessageDialog(null, "The user entry, " + eID + ", does not exist");
			}
		}
		if (e.getSource()==bt3) {
			String s = "";
			for(Integer i : hashmap.keySet()){
				s+= "ID: " + i + "  Name:  " + hashmap.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if (e.getSource() == bt4) {
			String remove = JOptionPane.showInputDialog("Enter an ID number");
			int removeInt = Integer.parseInt(remove);
			if (hashmap.containsKey(removeInt)) {
				hashmap.remove(removeInt);
			}
			else {
				JOptionPane.showMessageDialog(null, "The ID, " + removeInt + ", does not exist");
			}
		}
	}
}









