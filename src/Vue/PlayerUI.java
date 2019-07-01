package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import TheOtherHatTrick.Player;

public class PlayerUI {
	public Player player;
	private JButton card1Button;
	private JButton card2Button;
	private JButton card3Button;
	
	public int position;
	
	public int positionCard;
	
	public static int count = -1;
	
	
	private JLabel score;
	
	
	public PlayerUI() {
	}

	public PlayerUI(Player player) {
		this.player = player;
		count++;
		position = count;
	}
	public JButton getCard1Button() {
		setCard1Button();
		return card1Button;
	}

	public void setCard1Button() {
		card1Button = new JButton(player.getMyprops().get(0).image);
		card1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionCard=0;
			}
		});
	}

	public JButton getCard2Button() {
		setCard2Button();
		return card2Button;
	}

	public void setCard2Button() {
		card2Button = new JButton(player.getMyprops().get(1).image);
		card2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionCard = 1;
			}
		});
	}

	public JButton getCard3Button() {
		setCard3Button();
		return card3Button;
	}

	public void setCard3Button() {
		card3Button = new JButton(player.getMyprops().get(2).image);
		card3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionCard = 2;
			}
		});
	}

	public JLabel getScoreLabel() {
		setScoreLabel();
		return score;
	}

	public void setScoreLabel() {
		score = new JLabel("Score:"+player.getScore());
	}
    
	
}
