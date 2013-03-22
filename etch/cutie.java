import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class cutie extends JFrame implements KeyListener{


	private JLabel[][] buttArr = new JLabel[100][100];
	private JLabel currPos;
	private int x, y;

	private ImageIcon pink = new ImageIcon("p.png");
	private ImageIcon yellow = new ImageIcon("y.png");

	public cutie(){

		super("etch a sketch ");
		x = 0;
		y = 0;
		currPos = buttArr[x][y];

		GridLayout lay = new GridLayout(100,100);

		setLayout(lay);
		fillArr(lay);
		this.addKeyListener(this);

	}//end of cutie constructor

//	private class keyHand implements KeyListener{
		public void keyPressed(KeyEvent e){
	//		if(y < 3 && x < 3 && y > -1 && x > -1){
				if(e.getKeyCode() == KeyEvent.VK_J && 
					x < 99 ){
					x++;	
					currPos = buttArr[x][y];
					currPos.setIcon(yellow);
				}//e	nd of if J 
				else if(e.getKeyCode() == KeyEvent.VK_K && 
					x > 0){
					x--;
					currPos = buttArr[x][y];
					currPos.setIcon(yellow);

				}//end of if K 
				else if(e.getKeyCode() == KeyEvent.VK_L && 
					y < 99){
					y++;
					currPos = buttArr[x][y];
					currPos.setIcon(yellow);

				}//end of if L
				else if(e.getKeyCode() == KeyEvent.VK_H &&
					y > 0){
					y--;
					currPos = buttArr[x][y];
					currPos.setIcon(yellow);

				}//end of if H
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					escape();
				}//end of if escape
				
				System.out.println("x is " + x);
				System.out.println("y is " + y);
	//		}//end of if x/y not outo f range


		}//end of keyPressed
		
		public void keyReleased(KeyEvent e){
		//	buttArr[0][0].setIcon(yellow);
		}//end of keyReleased
		
		public void keyTyped(KeyEvent e){
		//	buttArr[0][0].setIcon(yellow);

		}//end of keyTyped
//	}//end of keyHand

	private void fillArr(GridLayout gl){
		for(int i = 0; i < gl.getRows(); i ++){
			for(int j = 0; j < gl.getColumns(); j++){
				buttArr[i][j] = new JLabel(pink);
				add(buttArr[i][j]);
			}
		}//end of for 

	}//end of private fillArr method
	private void escape(){
		for(int i =0; i < 100;i++){
			for(int j= 0; j < 100; j++){
				buttArr[i][j].setIcon(pink);
			}
		}
	}//end of escape method.


}//end of cutie class
