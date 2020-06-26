package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	Song demo = new Song("demo.mp3");
	Song BeethovensFifthAndAmazingSymphony = new Song("Beethovens5th.mp3");
	Song ohno = new Song("ohno.mp3");
	JFrame frame = new JFrame();
	JButton button = new JButton();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
			
		frame.add(button);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		button.setText("Suprise Me");
		button.addActionListener(this);
		frame.pack();
		ArrayList<Song> songs = new ArrayList<Song>();
			
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int ray = new Random().nextInt(3);
		if (ray == 0) {
			BeethovensFifthAndAmazingSymphony.play();
		}
		else if (ray == 1) {
			ohno.play();
		}
		else {
			demo.play();
		}
	}
}