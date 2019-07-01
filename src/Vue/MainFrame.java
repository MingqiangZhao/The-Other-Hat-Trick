package Vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import TheOtherHatTrick.*;
import javax.swing.JCheckBox;

/**
 * 
 * @author MingQiang
 * 
 * All the actionlisteners are in the function initialize()
 *
 */
public class MainFrame{

	private Game myGame;
	
	public JFrame frame;
	
	private static JButton btnStart;
	private static JButton btnOK_ChooseLevel;
	private static JButton btnOk_SetUpPlayer;
	private static JButton btnOK_haveChooseTrick;
	private static JButton btnOK_haveChooseSwap;
	private static JButton btnOK_haveChoosePerform;
	
	public static CardLayout cardLayout;
	private JTextField player1Name;
	private JTextField player2Name;
	private JTextField player3Name;
	private JTextField player2Age;
	private JTextField player3Age;
	protected boolean choosePlayer1Card1 = false;
	protected boolean choosePlayer1Card2 = false;
	protected boolean choosePlayer2Card1 = false;
	protected boolean choosePlayer2Card2 = false;
	protected boolean choosePlayer3Card1 = false;
	protected boolean choosePlayer3Card2 = false;
	int count = 0;

	private JButton btnPlayer3Card1;

	private JButton btnPlayer3Card2;

	private JButton btnPlayer1Card1;

	private JButton btnPlayer1Card2;

	private JButton btnPlayer2Card1;

	private JButton btnPlayer2Card2;
	private JLabel lblPlayer_1;
	private JLabel lblPlayer_2;
	private JLabel lblPlayer_3;
	private JCheckBox chckbxChooseThisTrick;
	private JCheckBox chckbxChooseNextTrick;
	private JCheckBox chckbxPerform;
	private JCheckBox chckbxNotPerform;
	private JLabel lblTrick;
	private JLabel lblThe7thCard;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Game myGame = new Game();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame(myGame);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @param game Initialize the game
	 */
	public MainFrame(Game game) {
		initialize();
		myGame = game;
	}

	/**
	 * Initialize the contents of the frame.
	 * It includes all of the actionlistener
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1177, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cardLayout = new CardLayout(0, 0);
		frame.getContentPane().setLayout(cardLayout);
		
		/**
		 * This is "Start" card layout
		 */
		JPanel Start = new JPanel();
		frame.getContentPane().add(Start, "Start");
		Start.setLayout(null);
	
		
	    btnStart = new JButton("Start");
		
		btnStart.setBounds(501, 452, 93, 28);
		Start.add(btnStart);
		Start.setBackground(Color.WHITE);
		
		JLabel lblWelcomToThe = new JLabel("Welcom to The Other Hat Trick");
		lblWelcomToThe.setBounds(441, 159, 233, 37);
		Start.add(lblWelcomToThe);
		
		JCheckBox chckbxPlayWithRealPlayer = new JCheckBox("Play With Real Player");
        chckbxPlayWithRealPlayer.setBackground(Color.WHITE);
		
		chckbxPlayWithRealPlayer.setBounds(473, 319, 154, 23);
		Start.add(chckbxPlayWithRealPlayer);
		
		JLabel lblChooseMode = new JLabel("Choose Mode:");
		lblChooseMode.setBounds(365, 298, 103, 15);
		Start.add(lblChooseMode);

		JCheckBox chckbxPlayWithRobot = new JCheckBox("Play With Robot");
		chckbxPlayWithRobot.setBounds(472, 363, 168, 23);
		Start.add(chckbxPlayWithRobot);
		chckbxPlayWithRobot.setBackground(Color.WHITE);
		
		JLabel lblBackGround = new JLabel("New label");
		lblBackGround.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround.setBounds(0, 0, 293, 205);
		Start.add(lblBackGround);
		
		JButton btnPlayInTheControler = new JButton("PLAY IN THE  CONTROLER");
		btnPlayInTheControler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      myGame.setup();
			      myGame.launchTheGame();
			}
			
		});
		
		btnPlayInTheControler.setBounds(821, 594, 196, 48);
		Start.add(btnPlayInTheControler);
		
		//choose play with real player 
		/**
		 * if you select this check box, the other check box can not be selected
		 */
		chckbxPlayWithRealPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPlayWithRealPlayer.isSelected()) {
					chckbxPlayWithRobot.setEnabled(false);
				}else {
					chckbxPlayWithRobot.setEnabled(true);
				}
				
			}
		});
		
		
		//choose player with robot
		/**
		 * if you select this check box, the other check box can not be selected
		 */
		chckbxPlayWithRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPlayWithRobot.isSelected()) {
					chckbxPlayWithRealPlayer.setEnabled(false);
					
				}else {
					chckbxPlayWithRealPlayer.setEnabled(true);
				}
				
				
			}
		});
		
		
        //choose level
		JPanel ChooseLevel = new JPanel();
		frame.getContentPane().add(ChooseLevel, "ChooseLevel");
		ChooseLevel.setLayout(null);
		ChooseLevel.setBackground(Color.WHITE);
		
		JLabel lblPleaseChooseThe = new JLabel("Please Choose the Level");
		lblPleaseChooseThe.setBounds(434, 130, 153, 15);
		ChooseLevel.add(lblPleaseChooseThe);
		
		JLabel lblChooseTheLevel = new JLabel("Choose the Level:");
		lblChooseTheLevel.setBounds(343, 190, 114, 15);
		ChooseLevel.add(lblChooseTheLevel);
		
		JCheckBox chckbxEasy = new JCheckBox("Easy");
		chckbxEasy.setBackground(Color.WHITE);
		
		chckbxEasy.setBounds(470, 221, 103, 23);
		ChooseLevel.add(chckbxEasy);
		
		JCheckBox chckbxMiddle = new JCheckBox("Middle");
		chckbxMiddle.setBackground(Color.WHITE);
		
		chckbxMiddle.setBounds(470, 270, 103, 23);
		ChooseLevel.add(chckbxMiddle);
		
		JCheckBox chckbxDifficult = new JCheckBox("Difficult");
		chckbxDifficult.setBackground(Color.WHITE);
		
		chckbxDifficult.setBounds(470, 316, 103, 23);
		ChooseLevel.add(chckbxDifficult);
		
		btnOK_ChooseLevel = new JButton("OK");
		
		btnOK_ChooseLevel.setBounds(470, 405, 93, 23);
		ChooseLevel.add(btnOK_ChooseLevel);
		
		JLabel lblBackGround4 = new JLabel("New label");
		lblBackGround4.setIcon(new ImageIcon("img\\iconBig.png"));
		
		lblBackGround4.setBounds(0, 0, 293, 205);
		ChooseLevel.add(lblBackGround4);
		
		/**
		 * The level is easy
		 * if you select this check box, the other check box can not be selected
		 */
		chckbxEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxEasy.isSelected()) {
					chckbxMiddle.setEnabled(false);
					chckbxDifficult.setEnabled(false);
				}else {
					chckbxMiddle.setEnabled(true);
					chckbxDifficult.setEnabled(true);
				}
				myGame.level = 0;
				
			}
		});
		
		/**
		 * The level is middle
		 * if you select this check box, the other check box can not be selected
		 */
		chckbxMiddle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMiddle.isSelected()) {
					chckbxEasy.setEnabled(false);
					chckbxDifficult.setEnabled(false);
				}else {
					chckbxEasy.setEnabled(true);
					chckbxDifficult.setEnabled(true);
				}
				myGame.level = 0;
			}
		});
		
		/**
		 * The level is difficult
		 * if you select this check box, the other check box can not be selected
		 */
		chckbxDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxDifficult.isSelected()) {
					chckbxEasy.setEnabled(false);
					chckbxMiddle.setEnabled(false);
				}else {
					chckbxEasy.setEnabled(true);
					chckbxMiddle.setEnabled(true);
				}
				myGame.level = 0;
			}
		});
		
		// choose level 
		/**
		 * If you click it, we will go to card layout "SetUp" to initialize the basic information of players
		 */
		btnOK_ChooseLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxEasy.isSelected()&&!chckbxMiddle.isSelected()&&!chckbxDifficult.isSelected()) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Please Choose the Level.", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					cardLayout.show(frame.getContentPane(), "SetUp");
				}
			}
		});
		
		
		/**
		 * This is "Set Up" card
		 * it sets up the basic information of players
		 */
		JPanel SetUpPlayer = new JPanel();
		frame.getContentPane().add(SetUpPlayer, "SetUp");
		SetUpPlayer.setLayout(null);
		SetUpPlayer.setBackground(Color.WHITE);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 238, 54, 15);
		SetUpPlayer.add(lblName);
		
		player1Name = new JTextField();
		player1Name.setBounds(454, 231, 100, 30);
		SetUpPlayer.add(player1Name);
		player1Name.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(590, 238, 54, 15);
		SetUpPlayer.add(lblAge);
		
		JLabel lblPleaseInputPlayers = new JLabel("Please input  players' information");
		lblPleaseInputPlayers.setBounds(464, 121, 268, 38);
		SetUpPlayer.add(lblPleaseInputPlayers);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(375, 314, 54, 15);
		SetUpPlayer.add(lblName_1);
		
		player2Name = new JTextField();
		player2Name.setBounds(454, 307, 100, 30);
		SetUpPlayer.add(player2Name);
		player2Name.setColumns(10);
		
		JLabel lblSetPlayer = new JLabel("Player1:");
		lblSetPlayer.setBounds(273, 238, 54, 15);
		SetUpPlayer.add(lblSetPlayer);
		
		JLabel lblSetPlayer_1 = new JLabel("Player2:");
		lblSetPlayer_1.setBounds(273, 314, 54, 15);
		SetUpPlayer.add(lblSetPlayer_1);
		
		JLabel lblSetPlayer_2 = new JLabel("Player3:");
		lblSetPlayer_2.setBounds(273, 390, 54, 15);
		SetUpPlayer.add(lblSetPlayer_2);
		
		JLabel lblName_2 = new JLabel("Name:");
		lblName_2.setBounds(375, 390, 54, 15);
		SetUpPlayer.add(lblName_2);
		
		player3Name = new JTextField();
		player3Name.setBounds(454, 383, 100, 30);
		SetUpPlayer.add(player3Name);
		player3Name.setColumns(10);
		
		JLabel lblAge_1 = new JLabel("Age:");
		lblAge_1.setBounds(590, 314, 54, 15);
		SetUpPlayer.add(lblAge_1);
		
		JTextField player1Age = new JTextField();
		player1Age.setBounds(661, 231, 100, 30);
		SetUpPlayer.add(player1Age);
		
		player2Age = new JTextField();
		player2Age.setBounds(661, 307, 100, 30);
		SetUpPlayer.add(player2Age);
		player2Age.setColumns(10);
		
		JLabel lblAge_2 = new JLabel("Age:");
		lblAge_2.setBounds(590, 390, 54, 15);
		SetUpPlayer.add(lblAge_2);
		
		player3Age = new JTextField();
		player3Age.setBounds(661, 383, 100, 30);
		SetUpPlayer.add(player3Age);
		player3Age.setColumns(10);
		
	    btnOk_SetUpPlayer = new JButton("OK");
	    
		btnOk_SetUpPlayer.setBounds(503, 470, 93, 23);
		SetUpPlayer.add(btnOk_SetUpPlayer);
		
		JLabel lblBackGround2 = new JLabel("New label");
		lblBackGround2.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround2.setBounds(0, 0, 293, 205);
		SetUpPlayer.add(lblBackGround2);
		
		/**
		 * This is the "Playing" card. The player can do his operation
		 * Choose the trick, swap card with other players, choose to perform or not 
		 * choose the 7th card
		 * 
		 */
		JPanel Playing = new JPanel();
		frame.getContentPane().add(Playing, "Playing");
		Playing.setLayout(null);
		//Playing.setBackground(Color.WHITE);
		
	    btnPlayer3Card1 = new JButton("Player3Card1");
		btnPlayer3Card1.setEnabled(false);
		
		btnPlayer3Card1.setBounds(20, 27, 140, 200);
		Playing.add(btnPlayer3Card1);
		
		btnPlayer3Card2 = new JButton("Player3Card2");
		btnPlayer3Card2.setEnabled(false);
		
		btnPlayer3Card2.setBounds(212, 27, 140, 200);
		Playing.add(btnPlayer3Card2);
		
		btnPlayer1Card1 = new JButton("Player1C/ard1");
		btnPlayer1Card1.setEnabled(false);
		btnPlayer1Card1.setBounds(358, 295, 140, 200);
		Playing.add(btnPlayer1Card1);
		
		btnPlayer1Card2 = new JButton("Player1Card2");
		btnPlayer1Card2.setEnabled(false);
		btnPlayer1Card2.setBounds(633, 295, 140, 200);
		Playing.add(btnPlayer1Card2);
		
		btnPlayer2Card2 = new JButton("Player2Card2");
		btnPlayer2Card2.setEnabled(false);
		btnPlayer2Card2.setBounds(980, 27, 140, 200);
		Playing.add(btnPlayer2Card2);
		
		btnPlayer2Card1 = new JButton("Player2Card1");
		btnPlayer2Card1.setEnabled(false);
		btnPlayer2Card1.setBounds(770, 27, 140, 200);
		Playing.add(btnPlayer2Card1);
		
		btnOK_haveChooseTrick = new JButton("OK");
		
		btnOK_haveChooseTrick.setBounds(190, 635, 93, 23);
		Playing.add(btnOK_haveChooseTrick);
		
		JLabel lblChooseTrick = new JLabel("Choose Trick:");
		lblChooseTrick.setBounds(100, 537, 84, 15);
		Playing.add(lblChooseTrick);
		
		chckbxChooseThisTrick = new JCheckBox("Choose this trick");
		
		chckbxChooseThisTrick.setBounds(165, 558, 139, 23);
		Playing.add(chckbxChooseThisTrick);
		
		chckbxChooseNextTrick = new JCheckBox("Choose next trick");
		
		chckbxChooseNextTrick.setBounds(165, 594, 127, 23);
		Playing.add(chckbxChooseNextTrick);
		
		
		lblPlayer_1 = new JLabel("Player1");
		lblPlayer_1.setBounds(518, 501, 255, 15);
		Playing.add(lblPlayer_1);
		
	    lblPlayer_2 = new JLabel("Player2");
		lblPlayer_2.setBounds(926, 259, 152, 15);
		Playing.add(lblPlayer_2);
		
		lblPlayer_3 = new JLabel("Player3");
		lblPlayer_3.setBounds(125, 259, 179, 15);
		Playing.add(lblPlayer_3);
		
		JLabel lblChoosePerfom = new JLabel("Choose Perfom:");
		lblChoosePerfom.setBounds(736, 537, 120, 15);
		Playing.add(lblChoosePerfom);
		
		chckbxPerform = new JCheckBox("Perform");
		
		chckbxPerform.setEnabled(false);
		chckbxPerform.setBounds(807, 558, 103, 23);
		Playing.add(chckbxPerform);
		
		chckbxNotPerform = new JCheckBox("NotPerform");
		
		chckbxNotPerform.setEnabled(false);
		chckbxNotPerform.setBounds(807, 594, 103, 23);
		Playing.add(chckbxNotPerform);
		
		btnOK_haveChoosePerform = new JButton("OK");
		
		btnOK_haveChoosePerform.setBounds(817, 635, 93, 23);
		Playing.add(btnOK_haveChoosePerform);
		
		JLabel lblChooseSwapCard = new JLabel("Choose Swap Card:");
		lblChooseSwapCard.setBounds(378, 537, 120, 15);
		Playing.add(lblChooseSwapCard);
		
		btnOK_haveChooseSwap = new JButton("OK");
		
		btnOK_haveChooseSwap.setBounds(487, 635, 93, 23);
		Playing.add(btnOK_haveChooseSwap);
		
		lblTrick = new JLabel("Trick");
		lblTrick.setBounds(459, 134, 200, 140);
		Playing.add(lblTrick);
		
		lblThe7thCard = new JLabel("The7thCard");
		lblThe7thCard.setBounds(980, 408, 140, 200);
		Playing.add(lblThe7thCard);
		
		JButton btnShowMyCard = new JButton("Show My Card");
		
		btnShowMyCard.setBounds(100, 371, 127, 42);
		Playing.add(btnShowMyCard);
		
		JLabel lblThethcard = new JLabel("The7thCard");
		lblThethcard.setBounds(1008, 383, 93, 25);
		Playing.add(lblThethcard);
		
		/**
		 * This is the action listener of player3'card1 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer3Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer3Card1.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer3Card1.isEnabled()&&!btnPlayer3Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);
					
					btnPlayer3Card1.setEnabled(true);
					btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
					btnPlayer1Card2.setEnabled(true);
					btnPlayer2Card1.setEnabled(true);
					btnPlayer2Card2.setEnabled(true);
					 
				    choosePlayer1Card1 = false;
				    choosePlayer1Card2 = false;
				    choosePlayer2Card1 = false;
				    choosePlayer2Card2 = false;
				    choosePlayer3Card1 = false;
				    choosePlayer3Card2 = false;
				    
				    count = 0;
				    
				}else {
					if(position == 2) {
						myGame.player[position].chooseSwap[2] = 0;
					}else {
						myGame.player[position].chooseSwap[0] = 2;
						myGame.player[position].chooseSwap[1] = 0;
					}
				}
			}
		});
		
		/**
		 * This is the action listener of player3'card2 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer3Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer3Card2.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer3Card1.isEnabled()&&!btnPlayer3Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);
					
					btnPlayer3Card1.setEnabled(true);
					btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
					btnPlayer1Card2.setEnabled(true);
					btnPlayer2Card1.setEnabled(true);
					btnPlayer2Card2.setEnabled(true);
					 
				    choosePlayer1Card1 = false;
				    choosePlayer1Card2 = false;
				    choosePlayer2Card1 = false;
				    choosePlayer2Card2 = false;
				    choosePlayer3Card1 = false;
				    choosePlayer3Card2 = false;
				    
				    count = 0;
				    
				}else {
					if(position == 2) {
						myGame.player[position].chooseSwap[2] = 1;
					}else {
						myGame.player[position].chooseSwap[0] = 2;
						myGame.player[position].chooseSwap[1] = 1;
					}
				}
		    }
		});
		
		/**
		 * This is the action listener of player1'card1 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer1Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer1Card1.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer1Card1.isEnabled()&&!btnPlayer1Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);
					
					btnPlayer3Card1.setEnabled(true);
					btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
					btnPlayer1Card2.setEnabled(true);
					btnPlayer2Card1.setEnabled(true);
					btnPlayer2Card2.setEnabled(true);
					 
				    choosePlayer1Card1 = false;
				    choosePlayer1Card2 = false;
				    choosePlayer2Card1 = false;
				    choosePlayer2Card2 = false;
				    choosePlayer3Card1 = false;
				    choosePlayer3Card2 = false;

				    count = 0;
				    
				}else {
					if(position == 0) {
						myGame.player[position].chooseSwap[2] = 0;
					}else {
						myGame.player[position].chooseSwap[0] = 0;
						myGame.player[position].chooseSwap[1] = 0;
					}
				}
			}
		});
		
		/**
		 * This is the action listener of player1'card2 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer1Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer1Card2.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer1Card1.isEnabled()&&!btnPlayer1Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);
					
					 btnPlayer3Card1.setEnabled(true);
					 btnPlayer3Card2.setEnabled(true);
					 btnPlayer1Card1.setEnabled(true);
					 btnPlayer1Card2.setEnabled(true);
					 btnPlayer2Card1.setEnabled(true);
					 btnPlayer2Card2.setEnabled(true);
					 
				     choosePlayer1Card1 = false;
				     choosePlayer1Card2 = false;
				     choosePlayer2Card1 = false;
				     choosePlayer2Card2 = false;
					 choosePlayer3Card1 = false;
				     choosePlayer3Card2 = false;

					 count = 0;
					    
				}else {
					if(position == 0) {
						myGame.player[position].chooseSwap[2] = 1;
					}else {
						myGame.player[position].chooseSwap[0] = 0;
						myGame.player[position].chooseSwap[1] = 1;
					}
				}
				
			}
		});
		
		/**
		 * This is the action listener of player2'card1 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer2Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer2Card1.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer2Card1.isEnabled()&&!btnPlayer2Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);

					btnPlayer3Card1.setEnabled(true);
					btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
					btnPlayer1Card2.setEnabled(true);
					btnPlayer2Card1.setEnabled(true);
					btnPlayer2Card2.setEnabled(true);
					 
				    choosePlayer1Card1 = false;
				    choosePlayer1Card2 = false;
				    choosePlayer2Card1 = false;
				    choosePlayer2Card2 = false;
				    choosePlayer3Card1 = false;
				    choosePlayer3Card2 = false;
				    
					count = 0;
					 
				}else {
					if(position == 1) {
						myGame.player[position].chooseSwap[2] = 0;
					}else {
						myGame.player[position].chooseSwap[0] = 1;
						myGame.player[position].chooseSwap[1] = 0;
					}
				}
			}
		});
		
		/**
		 * This is the action listener of player2'card2 in "Playing"
		 * It will check whether your choose is legal
		 * If you don't choose your cards, it will show you the "Warning" JOptionPanel
		 * And you will choose the cards again
		 */
		btnPlayer2Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayer2Card2.setEnabled(false);
				int position = isPlaying();
				boolean test = ((position == 0&&(!btnPlayer1Card1.isEnabled()||!btnPlayer1Card2.isEnabled()))||(
						position == 1&&(!btnPlayer2Card1.isEnabled()||!btnPlayer2Card2.isEnabled()))||(
						position == 2&&(!btnPlayer3Card1.isEnabled()||!btnPlayer3Card2.isEnabled())));
				count++;
				if(count > 2||(!btnPlayer2Card1.isEnabled()&&!btnPlayer2Card2.isEnabled())||!test) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Choose is illegal !", "Warning", JOptionPane.WARNING_MESSAGE);

					btnPlayer3Card1.setEnabled(true);
					btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
					btnPlayer1Card2.setEnabled(true);
					btnPlayer2Card1.setEnabled(true);
					btnPlayer2Card2.setEnabled(true);
					 
				    choosePlayer1Card1 = false;
				    choosePlayer1Card2 = false;
				    choosePlayer2Card1 = false;
				    choosePlayer2Card2 = false;
				    choosePlayer3Card1 = false;
				    choosePlayer3Card2 = false;
				    
				    count = 0;
				    
				}else {
					if(position == 1) {
						myGame.player[position].chooseSwap[2] = 1;
					}else {
						myGame.player[position].chooseSwap[0] = 1;
						myGame.player[position].chooseSwap[1] = 1;
					}
				}
			}
		});
		
	    /**
	     * This is Actionlistener of check box "ChooseThisTrick"  in "Playing"
	     * if it is selected, check box "ChooseNextTrick" can not be selected
	     * 
	     */
		chckbxChooseThisTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxChooseThisTrick.isSelected()) {
					chckbxChooseNextTrick.setEnabled(false);
				}else {
					chckbxChooseNextTrick.setEnabled(true);
				}
			}
		});
		
		 /**
	     * This is Actionlistener of check box "ChooseNextTrick"  in "Playing"
	     * if it is selected, check box "ChooseThisTrick" can not be selected
	     */
		chckbxChooseNextTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxChooseNextTrick.isSelected()) {
					chckbxChooseThisTrick.setEnabled(false);
				}else {
					chckbxChooseThisTrick.setEnabled(true);
				}
				
			}
		});
		
		/**
		 * when you don't choose anything, we will show you "Warning" JOptionPanel
		 * when you have chose trick, it will transfer your choose to the attribute "ChooseTrick" in class Player
		 * 
		 */
		btnOK_haveChooseTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!chckbxChooseThisTrick.isSelected()&&!chckbxChooseNextTrick.isSelected()) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Please Choose the Trick.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				if(chckbxChooseThisTrick.isSelected()||chckbxChooseNextTrick.isSelected()) {
					if(chckbxChooseThisTrick.isSelected()) {
						myGame.player[isPlaying()].chooseTrick = true;
					}
					if(chckbxChooseNextTrick.isSelected()) {
						
						myGame.player[isPlaying()].chooseTrick = false;
						myGame.getTricksPile().pop();
						lblTrick.setIcon(myGame.getTricksPile().peek().image);
					}
					
				    chckbxChooseThisTrick.setEnabled(false);
				    chckbxChooseNextTrick.setEnabled(false);
				    
				    btnPlayer3Card1.setEnabled(true);
				    btnPlayer3Card2.setEnabled(true);
				    btnPlayer1Card1.setEnabled(true);
				    btnPlayer1Card2.setEnabled(true);
				    btnPlayer2Card1.setEnabled(true);
				    btnPlayer2Card2.setEnabled(true);
				    
				    cardLayout.show(frame.getContentPane(), "ChooseSwapCard");
				}
			}
		});
		
		/**
		 * Choose the card to swap 
		 * Each card if you choose, we will store it like " choosePlayer1Card1 " £¬ the type is boolean
		 * At first all the " choosePlayerCard " are initialize as "false"
		 * If you click the button, they will change to true
		 *
		 */
		btnOK_haveChooseSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!chckbxChooseNextTrick.isSelected()) {
					chckbxPerform.setEnabled(true);
					chckbxNotPerform.setEnabled(true);
					
				}else {
					synchronized (this) {
						chckbxPerform.setEnabled(true);
						chckbxPerform.setSelected(true);
						chckbxPerform.setEnabled(false);
					}
				}
				int position = isPlaying();
				
				
				//swap card
				int choosePlayer = myGame.player[position].chooseSwap[0];
				int chooseOtherCard = myGame.player[position].chooseSwap[1];
				int chooseMyCard = myGame.player[position].chooseSwap[2];
				
				myGame.swapCard(choosePlayer, chooseOtherCard, chooseMyCard,myGame.player[position]);
				
				cardLayout.show(frame.getContentPane(),"ChoosePerform");
			}
		});
		
		//*********************
		chckbxPerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPerform.isSelected()) {
					chckbxNotPerform.setEnabled(false);
				}else {
					chckbxNotPerform.setEnabled(true);
				}
			}
		});
		
		/**
		 * If you select this check box, the other check box can not be selected
		 */
		chckbxNotPerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNotPerform.isSelected()) {
					chckbxPerform.setEnabled(false);
				}else {
					chckbxPerform.setEnabled(true);
				}
			}
		});
		
		
		//Choose Trick Hint Reminder
		JPanel ChooseTrick = new JPanel();
		frame.getContentPane().add(ChooseTrick, "ChooseTrick");
		ChooseTrick.setLayout(null);
		ChooseTrick.setBackground(Color.WHITE);
		
		JLabel lblNowYouHavetoChooseTrick = new JLabel("Now  You Have to Choose Trick");
		lblNowYouHavetoChooseTrick.setBounds(450, 217, 360, 110);
		ChooseTrick.add(lblNowYouHavetoChooseTrick);
		
		JButton btnOK_ChooseTrick = new JButton("OK");
		
		btnOK_ChooseTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				inicilizePlayingPanel();
				cardLayout.show(frame.getContentPane(), "Playing");
				if(myGame.getTricksPile().size() == 1) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "The Game is finished !", "", JOptionPane.INFORMATION_MESSAGE);
					for(int i=0; i<3; i++) {
						if(myGame.player[i].hasAttribut(Attributs.TheHat)||myGame.player[i].hasAttribut(Attributs.TheOtherRabbit)) {
							myGame.player[i].changeScore(-3);
						}
					}
				     	LinkedList<Player> winner = myGame.findWinner();
				     	while(!winner.isEmpty()) {
				     		JOptionPane.showMessageDialog(frame.getComponent(0), winner.pop().getName()+" is the WINNER! Congratuations!", "", JOptionPane.INFORMATION_MESSAGE);
				     	}
				}
			}
		});
		btnOK_ChooseTrick.setBounds(497, 424, 93, 23);
		ChooseTrick.add(btnOK_ChooseTrick);
		
		JLabel lblBackGround1 = new JLabel("New label");
		lblBackGround1.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround1.setBounds(0, 0, 293, 205);
		ChooseTrick.add(lblBackGround1);
		
		//Choose Swap Card Hint Reminder
		JPanel ChooseSwapCard = new JPanel();
		frame.getContentPane().add(ChooseSwapCard, "ChooseSwapCard");
		ChooseSwapCard.setLayout(null);
		ChooseSwapCard.setBackground(Color.WHITE);
		
		JLabel lblNowYouHave = new JLabel("Now You Have to Choose to Swap Your Card with Others ");
		lblNowYouHave.setBounds(366, 304, 353, 15);
		ChooseSwapCard.add(lblNowYouHave);
		
		JButton btnOk_ChooseSwapCard = new JButton("OK");
		
		btnOk_ChooseSwapCard.setBounds(491, 466, 93, 23);
		ChooseSwapCard.add(btnOk_ChooseSwapCard);
		
		JLabel lblBackGround5 = new JLabel("New label");
		lblBackGround5.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround5.setBounds(0, 0, 293, 205);
		ChooseSwapCard.add(lblBackGround5);
		
		//Choose Perfrom Hint Reminder
		JPanel ChoosePerform = new JPanel();
		frame.getContentPane().add(ChoosePerform, "ChoosePerform");
		ChoosePerform.setLayout(null);
		ChoosePerform.setBackground(Color.WHITE);
		
		JLabel lblNowYouHave_1 = new JLabel("Now You Have to Choose Perform");
		lblNowYouHave_1.setBounds(439, 290, 234, 15);
		ChoosePerform.add(lblNowYouHave_1);
		
		JButton btnOk_ChoosePerform = new JButton("OK");
		btnOk_ChoosePerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnPlayer1Card1.setEnabled(false);
				btnPlayer1Card2.setEnabled(false);
				btnPlayer2Card1.setEnabled(false);
				btnPlayer2Card2.setEnabled(false);
				btnPlayer3Card1.setEnabled(false);
				btnPlayer3Card2.setEnabled(false);
				
				btnOK_haveChooseSwap.setEnabled(false);
				btnOK_haveChoosePerform.setEnabled(true);
				setPosition();
				cardLayout.show(frame.getContentPane(), "Playing");
			}
		});
		btnOk_ChoosePerform.setBounds(491, 430, 93, 23);
		ChoosePerform.add(btnOk_ChoosePerform);
		
		JLabel lblBackGround3 = new JLabel("New label");
		lblBackGround3.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround3.setBounds(0, 0, 293, 205);
		ChoosePerform.add(lblBackGround3);
		//show my card
		JPanel ShowMyCard = new JPanel();
		frame.getContentPane().add(ShowMyCard, "ShowMyCard");
		ShowMyCard.setLayout(null);
		ShowMyCard.setBackground(Color.WHITE);
		
		JLabel lblCard1 = new JLabel("Card1");
		lblCard1.setBounds(293, 255, 140, 200);
		ShowMyCard.add(lblCard1);
		
		JLabel lblCard2 = new JLabel("Card2");
		lblCard2.setBounds(652, 255, 140, 200);
		ShowMyCard.add(lblCard2);
		
		JButton btnOK_getMyCard = new JButton("OK");
		btnOK_getMyCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "Playing");
			}
		});
		btnOK_getMyCard.setBounds(503, 533, 93, 23);
		ShowMyCard.add(btnOK_getMyCard);
		
		JLabel lblBackGround7 = new JLabel("New label");
		lblBackGround7.setIcon(new ImageIcon("img\\iconBig.png"));
		
		lblBackGround7.setBounds(0, 0, 293, 205);
		ShowMyCard.add(lblBackGround7);
		
		//player will play
		JPanel playerWillPlay = new JPanel();
		frame.getContentPane().add(playerWillPlay, "playerWillPlay");
		playerWillPlay.setLayout(null);
		playerWillPlay.setBackground(Color.WHITE);
		
		JLabel lblPlayerWillPlay = new JLabel("");
		lblPlayerWillPlay.setBounds(517, 276, 270, 15);
		playerWillPlay.add(lblPlayerWillPlay);
		
		JButton btnOK_playerWillPlay = new JButton("OK");
		
		btnOK_playerWillPlay.setBounds(497, 398, 93, 23);
		playerWillPlay.add(btnOK_playerWillPlay);
		
		JLabel lblBackGround6 = new JLabel("New label");
		lblBackGround6.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround6.setBounds(0, 0, 293, 205);
		playerWillPlay.add(lblBackGround6);
		
		
		
		//Choose 7th Card
		JPanel Choose7thCard = new JPanel();
		frame.getContentPane().add(Choose7thCard, "Choose7thCard");
		Choose7thCard.setLayout(null);
		Choose7thCard.setBackground(Color.WHITE);
		
		JButton btnMyCard1 = new JButton("card1");
		
		btnMyCard1.setBounds(265, 243, 140, 200);
		Choose7thCard.add(btnMyCard1);
		
		JButton btnMyCard2 = new JButton("card2");
		btnMyCard2.setBounds(477, 243, 140, 200);
		Choose7thCard.add(btnMyCard2);
		
		JButton btnMyCard3 = new JButton("card3");
		btnMyCard3.setBounds(684, 243, 140, 200);
		Choose7thCard.add(btnMyCard3);
		
		JButton btnOK_choose7thCard = new JButton("OK");
		
		btnOK_choose7thCard.setBounds(508, 504, 93, 23);
		Choose7thCard.add(btnOK_choose7thCard);
		
		JLabel lblChoose7thCard = new JLabel("Please Choose Your Card");
		lblChoose7thCard.setBounds(477, 98, 213, 15);
		Choose7thCard.add(lblChoose7thCard);
		
		JLabel lblBackGround8 = new JLabel("New label");
		lblBackGround8.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround8.setBounds(0, 0, 293, 205);
		Choose7thCard.add(lblBackGround8);
		
		JPanel TheRObotIsPlaying = new JPanel();
		frame.getContentPane().add(TheRObotIsPlaying, "TheRobotIsPlaying");
		TheRObotIsPlaying.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Robot is Playing");
		lblNewLabel.setBounds(458, 258, 272, 63);
		TheRObotIsPlaying.add(lblNewLabel);
		
		JLabel lblBackGround9 = new JLabel("New label");
		lblBackGround9.setIcon(new ImageIcon("img\\iconBig.png"));
		lblBackGround9.setBounds(0, 0, 293, 205);
		TheRObotIsPlaying.add(lblBackGround9);
		
		JButton btnOk_TheRobotIsPlaying = new JButton("OK");
		btnOk_TheRobotIsPlaying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int position = isPlaying();
				
				myGame.player[position].changemyTurn(false);
				myGame.player[(position+1)%3].changemyTurn(true);
				lblPlayerWillPlay.setText(myGame.player[(position+1)%3].getName()+" will play");
				cardLayout.show(frame.getContentPane(), "playerWillPlay");
			}
		});
		btnOk_TheRobotIsPlaying.setBounds(482, 420, 93, 23);
		TheRObotIsPlaying.add(btnOk_TheRobotIsPlaying);
		
		//********************************************
		btnMyCard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				myGame.player[position].choose7thCard = 0;
			}
		});
		//********************************************
		btnMyCard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				myGame.player[position].choose7thCard = 1;
			}
		});
		//********************************************
		btnMyCard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				myGame.player[position].choose7thCard = 2;
			}
		});

		
		//******************************************
		btnOK_choose7thCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				//myGame.player[position].change7thCard();
				
                myGame.seventhCard = myGame.player[position].getMyprops().remove(myGame.player[position].choose7thCard);
                myGame.player[position].changeScore(myGame.getTricksPile().pop().getScore());
                
                myGame.player[position].changemyTurn(false);
				myGame.player[(position+1)%3].changemyTurn(true);
				lblPlayerWillPlay.setText(myGame.player[(position+1)%3].getName()+" will play");
				cardLayout.show(frame.getContentPane(), "playerWillPlay");
			}
		});
		//***********************************************
		btnOk_ChooseSwapCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                btnOK_haveChooseTrick.setEnabled(false);
                btnOK_haveChooseSwap.setEnabled(true);
                
                setPosition();
                
                btnPlayer3Card1.setEnabled(true);
        		btnPlayer3Card2.setEnabled(true);
        	    btnPlayer1Card1.setEnabled(true);
        		btnPlayer1Card2.setEnabled(true);
        		btnPlayer2Card1.setEnabled(true);
        		btnPlayer2Card2.setEnabled(true);
        		
				cardLayout.show(frame.getContentPane(), "Playing");
			}
		});
		
		
		/**
		 * After you choose perform
		 */
		btnOK_haveChoosePerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxPerform.isSelected()&&!chckbxNotPerform.isSelected()) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Please Choose Perform Or Not.", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					int position = isPlaying();
					if(chckbxPerform.isSelected()) {
						myGame.player[position].choosePerform = true;
						boolean perform = myGame.player[position].perform(myGame.getTricksPile().pop());
						
						if(perform) {
							myGame.player[position].getMyprops().add(myGame.seventhCard);
							btnMyCard1.setIcon(myGame.player[position].getMyprops().get(0).image);
							btnMyCard2.setIcon(myGame.player[position].getMyprops().get(1).image);
							btnMyCard3.setIcon(myGame.player[position].getMyprops().get(2).image);
						    cardLayout.show(frame.getContentPane(),"Choose7thCard");
						    
						}
						else {
							myGame.player[position].foreit();
							
							myGame.player[position].changemyTurn(false);
							myGame.player[(position+1)%3].changemyTurn(true);
							lblPlayerWillPlay.setText(myGame.player[(position+1)%3].getName()+" will play");
							cardLayout.show(frame.getContentPane(), "playerWillPlay");
						}
					}
					if(chckbxNotPerform.isSelected()) {
						myGame.player[position].choosePerform = false;
						myGame.player[position].foreit();
						myGame.player[position].changemyTurn(false);
						myGame.player[(position+1)%3].changemyTurn(true);
						
			
						lblPlayerWillPlay.setText(myGame.player[(position+1)%3].getName()+" will play");
						cardLayout.show(frame.getContentPane(), "playerWillPlay");
					}
				}
			}
		});
		
		btnShowMyCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				
				lblCard1.setIcon(myGame.player[position].getMyprops().get(0).image);
				lblCard2.setIcon(myGame.player[position].getMyprops().get(1).image);
				cardLayout.show(frame.getContentPane(), "ShowMyCard");
			}
		});
		
		
		/**
		 * set players'information name and age 
		 */
		btnOk_SetUpPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player1Name.getText().isEmpty()||player1Age.getText().isEmpty()||player2Name.getText().isEmpty()||
						player2Age.getText().isEmpty()||player3Name.getText().isEmpty()||player3Age.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame.getComponent(0), "Please Input Player's Information", "Warning", JOptionPane.WARNING_MESSAGE);
				}else if(player1Name.getText().equals(player2Name.getText())||player1Name.getText().equals(player3Name.getText())||player2Name.getText().equals(player3Name.getText())) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Your Input Is Illegal !", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					
					//set up player information
					if(myGame.gameMode == 0) {
						String name1 = player1Name.getText();
						int age1 = Integer.parseInt(player1Age.getText());
						
						String name2 = player2Name.getText();
						int age2 = Integer.parseInt(player2Age.getText());
						
						String name3 = player3Name.getText();
						int age3 = Integer.parseInt(player3Age.getText());
						
						myGame.player[0] = new RealPlayer(age1, name1);
						myGame.player[1] = new RealPlayer(age2, name2);
						myGame.player[2] = new RealPlayer(age3, name3);
						
					}
					else if (myGame.gameMode == 1) {
						String name = player1Name.getText();
						int age = Integer.parseInt(player1Age.getText());
						
						myGame.player[0] = new RealPlayer(age,name);
						myGame.player[1]=new AIPlayer();
					    myGame.player[2]=new AIPlayer(); 
						
					    
						if(myGame.level == 0) {
							Easy strategy = new Easy(myGame);
				    	    AIPlayer AI1 = (AIPlayer)myGame.player[1];
				    		AIPlayer AI2 = (AIPlayer)myGame.player[2];
				    		AI1.setMyStrategy(strategy);
				    		AI2.setMyStrategy(strategy);
						}
						if(myGame.level == 1) {
							Difficult strategy = new Difficult(myGame);
				    	    AIPlayer AI1 = (AIPlayer)myGame.player[1];
				    		AIPlayer AI2 = (AIPlayer)myGame.player[2];
				    		AI1.setMyStrategy(strategy);
				    		AI2.setMyStrategy(strategy);
						}
					}
					//distribute card
					myGame.distributeCard();
					
					//setOrder
					myGame.setOrder();
					
					//set trick
					myGame.setPile();
					
					lblTrick.setIcon(myGame.getTricksPile().peek().image);
					
					//
					int position = isPlaying();
					lblPlayerWillPlay.setText(myGame.player[position].getName()+" will play");
					
					cardLayout.show(frame.getContentPane(), "playerWillPlay");
					
					
				}
			}
		});
		
		/**
		 * It will show you who will play the game and if it is robot, it will initialize the robot's strategy
		 */
		btnOK_playerWillPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = isPlaying();
				if(Player.isRobot(myGame.player[position])) {

					btnOk_TheRobotIsPlaying.setEnabled(false);
					cardLayout.show(frame.getContentPane(), "TheRobotIsPlaying");
					
					try {
						Thread.sleep(2000);
						myGame.player[position].chooseTrick();
						JOptionPane.showMessageDialog(frame.getComponent(0), "The Robot "+ myGame.player[position].getName()+
								" has chose the trick. It is "+myGame.player[position].chooseTrick, "The Robot has Choose the trick", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(2000);
						
						myGame.swap(myGame.player[position]);
						JOptionPane.showMessageDialog(frame.getComponent(0), "The Robot "+ myGame.player[position].getName()+
								" swap card with"+myGame.player[myGame.player[position].chooseSwap[0]].getName(),
								"The Robot has swaped card with other", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(2000);
						
						myGame.perform(myGame.player[position]);
						JOptionPane.showMessageDialog(frame.getComponent(0), "The Robot finish his turn", " ", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					btnOk_TheRobotIsPlaying.setEnabled(true);
					
				}else {
					cardLayout.show(frame.getContentPane(), "ChooseTrick");
				}
			}
		});
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxPlayWithRealPlayer.isSelected()&&!chckbxPlayWithRobot.isSelected()) {
					JOptionPane.showMessageDialog(frame.getComponent(0), "Please Choose Mode.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				if(chckbxPlayWithRealPlayer.isSelected()) {
					myGame.gameMode = 0;
				    cardLayout.show(frame.getContentPane() , "SetUp");
				}else if (chckbxPlayWithRobot.isSelected()) {
					myGame.gameMode = 1;
					
					myGame.player[1]=new AIPlayer();
				    myGame.player[2]=new AIPlayer(); 
					
				    player2Name.setText(myGame.player[1].getName());
				    player2Age.setText(Integer.toString(myGame.player[1].getAge()));
				    player3Name.setText(myGame.player[2].getName());
				    player3Age.setText(Integer.toString(myGame.player[2].getAge()));
				    
				    
					player2Name.setEnabled(false);
					player2Age.setEnabled(false);
					
					player3Name.setEnabled(false);
					player3Age.setEnabled(false);
					cardLayout.show(frame.getContentPane(), "ChooseLevel");
				}
			}
		});
	
	}
	
	/**
	 * 
	 * @param card This is the card player on main. if it's visibility change to visible we will turn it back
	 */
	public void turnBack(JButton card) {
		card.setIcon(ImageCard.c16);
	}
    
	/**
	 * 
	 * @return the player who is playing right now
	 */
	public int isPlaying() {
		int position = 0;
		while(position<3) {
			if(myGame.player[position].getMyTurn()) {
				break;
			}
			position++;
		}
		return position;
	}
	
	/**
	 * When each player finishes his turn, we will reconstruct the cardlayout "Playing" initialize all the buttons and labels
	 */
	void inicilizePlayingPanel(){
		chckbxChooseThisTrick.setSelected(false);
		chckbxChooseNextTrick.setSelected(false);
		chckbxChooseThisTrick.setEnabled(true);
		chckbxChooseNextTrick.setEnabled(true);
		btnOK_haveChooseTrick.setEnabled(true);
		btnOK_haveChooseSwap.setEnabled(false);
		btnOK_haveChoosePerform.setEnabled(false);
		
		chckbxPerform.setSelected(false);
		chckbxNotPerform.setSelected(false);
		chckbxPerform.setEnabled(false);
		chckbxNotPerform.setEnabled(false);
		lblTrick.setIcon(myGame.getTricksPile().peek().image);
      	lblThe7thCard.setIcon(ImageCard.c16);
		setPosition();
		lblPlayer_1.setText("Name:"+myGame.player[0].getName()+"  "+"Age:"+myGame.player[0].getAge()+" "+"Score:"+myGame.player[0].getScore());
		lblPlayer_2.setText("Name:"+myGame.player[1].getName()+"  "+"Age:"+myGame.player[1].getAge()+" "+"Score:"+myGame.player[1].getScore());
		lblPlayer_3.setText("Name:"+myGame.player[2].getName()+"  "+"Age:"+myGame.player[2].getAge()+" "+"Score:"+myGame.player[2].getScore());
	}
	
	/**
	 * When each player finishes his turn, we will set the position of each player's card on main, the tricks and the seventh card 
	 */
	public void setPosition() {
		
		if(myGame.player[0].getMyprops().get(0).getVisible()) {
		    btnPlayer1Card1.setIcon(myGame.player[0].getMyprops().get(0).image);
		}else {
			turnBack(btnPlayer1Card1);
		}
		
		if(myGame.player[0].getMyprops().get(1).getVisible()) {
			btnPlayer1Card2.setIcon(myGame.player[0].getMyprops().get(1).image);
			}else {
				turnBack(btnPlayer1Card2);
		}
		//player2
		if(myGame.player[1].getMyprops().get(0).getVisible()) {
			btnPlayer2Card1.setIcon(myGame.player[1].getMyprops().get(0).image);
		}else {
			turnBack(btnPlayer2Card1);
		}
		
		if(myGame.player[1].getMyprops().get(1).getVisible()) {
			btnPlayer2Card2.setIcon(myGame.player[1].getMyprops().get(1).image);
			}else {
				turnBack(btnPlayer2Card2);
		}
		//player3
		if(myGame.player[2].getMyprops().get(0).getVisible()) {
			
		    btnPlayer3Card1.setIcon(myGame.player[2].getMyprops().get(0).image);
		}else {
			turnBack(btnPlayer3Card1);
		}
		
		if(myGame.player[2].getMyprops().get(1).getVisible()) {
			btnPlayer3Card2.setIcon(myGame.player[2].getMyprops().get(1).image);
			}else {
				turnBack(btnPlayer3Card2);
		}
	}
}
