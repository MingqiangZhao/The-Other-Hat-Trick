package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import TheOtherHatTrick.Player;

public class ControleurSetUpPlayer {
	Player []players;
	JTextField player1Name;
	JTextField player1Age;
	JTextField player2Name;
	JTextField player2Age;
	JTextField player3Name; 
	JTextField player3Age;
	JButton btn_Ok;
	public ControleurSetUpPlayer(JTextField player1Name,JTextField player1Age,
			JTextField player2Name, JTextField player2Age, 
			JTextField player3Name, JTextField player3Age, JButton btn_Ok, Player []players) {
		this.player1Name = player1Name;
		this.player1Age = player1Age;
		this.player1Name = player2Name;
		this.player1Age = player2Age;
		this.player1Name = player3Name;
		this.player1Age = player3Age;
		this.btn_Ok = btn_Ok;
		
		this.btn_Ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		// TODO Auto-generated constructor stub
	}

}
