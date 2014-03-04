import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.HashMap;
import javax.swing.JTextArea;

public class Game extends JFrame{

	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four, five, six;
	private JButton seven,eight,nine;
	
	private JTextArea meh;
	private JTextArea intro;

	int counter = 0;
	boolean[] oscores = new boolean[9];
	boolean[] xscores = new boolean[9];
	String h1 = "";
	String h2 = "";
	String h3 = "";
	String v1 = "";
	String v2 = "";
	String v3 = "";
	String d1 = "";
	String d2 = "";

	HashMap<JButton, Integer> dict = new HashMap<JButton, Integer>();

	int scorex = 0; 
	int scoreo = 0;
	int gamesplayed = 0;

	int master = 0;

	String player1;
	String player2;

	private void pophash(){
		//populates your hashmap
		dict.put(one, new Integer(1));
		dict.put(two, new Integer(2));
		dict.put(three, new Integer(3));
		dict.put(four, new Integer(4));
		dict.put(five, new Integer(5));
		dict.put(six, new Integer(6));
		dict.put(seven, new Integer(7));
		dict.put(eight, new Integer(8));
		dict.put(nine, new Integer(9));
	}//endo f pophash

	public Game(String player1, String player2){
		super("Title here");

		this.player1 = player1;
		this.player2 = player2;
		
		setLayout(new FlowLayout());

		intro = new JTextArea("BTW: " + player2 + " (O) goes first!");
		add(intro);

		one = new JButton("1");
		add(one);
		two = new JButton("2");
		add(two);
		three = new JButton("3");
		add(three);
		four = new JButton("4");
		add(four);
		five = new JButton("5");
		add(five);
		six = new JButton("6");
		add(six);
		seven = new JButton("7");
		add(seven);
		eight = new JButton("8");
		add(eight);
		nine = new JButton("9");
		add(nine);
		pophash();
		handler bars = new handler();

		one.addActionListener(bars);
		two.addActionListener(bars);
		three.addActionListener(bars);
		four.addActionListener(bars);
		five.addActionListener(bars);
		six.addActionListener(bars);
		seven.addActionListener(bars);
		eight.addActionListener(bars);
		nine.addActionListener(bars);

		meh = new JTextArea(player1 + "(X): " + scorex + "\n" + 
								player2 + "(O): " + scoreo + "\n" +
								"games played: " + gamesplayed);
		meh.setEditable(false);
		add(meh);
	}//end of Game constructor default
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			counter++;

			JButton butt = (JButton) e.getSource();
			Integer target = dict.get(butt);	
			int temp = target.intValue() - 1;
			
			if(counter%2==0){
				butt.setText("x");	
				butt.setEnabled(false);	
				fillin(temp,"x");	
			}//end of if even
			else if(counter %2 !=0){
				butt.setText("o");
				butt.setEnabled(false);
				fillin(temp, "o");
			}//end of else odd 
			winDet(player1, player2);

		}//end of actionPerformed overwrite method

	}//end of handler class inside Game class
	private void winDet(String player1, String player2){		
		if(h1.equals("xxx") || h2.equals("xxx") || h3.equals("xxx") ||
			d1.equals("xxx") || d2.equals("xxx") ||
			v1.equals("xxx") || v2.equals("xxx") || v3.equals("xxx"))
		{
			JOptionPane.showMessageDialog(null,player1 + "(X) wins");
			scorex++;
			gamesplayed++;
			master = 0;// you want o to start next round
			intro.setText("BTW: " + player2 + " (O) starts first!");
			refresh();
		}//end of if x wins

		else if(h1.equals("ooo") || h2.equals("ooo") || h3.equals("ooo") ||
			d1.equals("ooo") || d2.equals("ooo") || 
			v1.equals("ooo") || v2.equals("ooo") || v3.equals("ooo"))
		{
			JOptionPane.showMessageDialog(null, player2 + "(O) wins");
			scoreo++;
			gamesplayed++;
			master = 1; // you want x to start next round
			intro.setText("BTW: " + player1 + " (X) starts first!");
			refresh();
		}//end of if o wins

		else if(allDone()){
			JOptionPane.showMessageDialog(null,"no one wins");
			gamesplayed++;
			refresh();
		}//end of all done

	//	meh.setText("X: " + scorex + "\n" + "O: " + scoreo + "\n" + "games played: " + gamesplayed);
		meh.setText(player1 + "(X): " + scorex + "\n" +
					player2 + "(O): " + scoreo + "\n" + 
					"games played: " + gamesplayed);
	}//end of winDet method
	private void refresh(){
		h1 = "";
		h2 = "";
		h3 = "";
		v1 = "";
		v2 = "";
		v3 = "";
		d1 = "";
		d2 = "";
		// refreshing all the storages

		one.setEnabled(true);
		two.setEnabled(true);
		three.setEnabled(true);
		four.setEnabled(true);
		five.setEnabled(true);
		six.setEnabled(true);
		seven.setEnabled(true);
		eight.setEnabled(true);
		nine.setEnabled(true);
		//refreshing all the buttons' button enabling...
		
		one.setText("1");
		two.setText("2");
		three.setText("3");
		four.setText("4");
		five.setText("5");
		six.setText("6");
		seven.setText("7");
		eight.setText("8");
		nine.setText("9");
		//refreshing all the buttons' texts....

		counter = master;

	}//end of refresh method

	private boolean allDone(){
		if(h1.length() == 3 && h2.length() == 3 && h3.length() == 3 &&
			v1.length() == 3 && v2.length() == 3 && v3.length() == 3 &&
			d1.length() == 3 && d2.length() == 3)
			return true;
		else
			return false;
	}//end of allDone
	private void fillin(int pos, String str){
		if(pos ==0){
			h1 = h1 + str;
			v1 = v1 + str;
			d1 = d1 + str;
		}
		if(pos ==1){
			h1 = h1 + str;
			v2 = v2 + str;
		}
		if(pos ==2){
			d2 = d2 + str;
			h1 = h1 + str;
			v3 = v3 + str;
		}
		if(pos ==3){
			h2 = h2 + str;
			v1 = v1 + str;
		}
		if(pos == 4){
			d1 = d1 + str;
			h2 = h2 + str;
			v2 = v2 + str;
			d2 = d2 + str;
		}
		if(pos == 5){
			h2 = h2 + str;
			v3 = v3 + str;
		}
		if(pos == 6){
			d2 = d2 + str;
			v1 = v1 + str;
			h3 = h3 + str;
		}
		if(pos ==7){
			v2 = v2 + str;
			h3 = h3 + str;
		}
		if(pos == 8){
			d1 = d1 + str;
			v3 = v3 + str;
			h3 = h3 + str;
		}
	}//end of fillin method
}//end of class Game 
