import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client{

	public static void main(String[] args){
		
		String player1 = JOptionPane.showInputDialog("Enter player 1's name");
		String player2 = JOptionPane.showInputDialog("Enter player 2's name");


		Game pan = new Game(player1, player2);
		pan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setSize(150,200);
		pan.setVisible(true);

	}//end of main method

}//end of Client class
