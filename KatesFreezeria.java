//D Oberle 5/5/20
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KatesFreezeria					   
{
   public static Freezeria screen;					//Our Custom JPanel

   public static void main(String[]args)
   {
      screen = new Freezeria();
      JFrame frame = new JFrame("Kate's Freezeria");	//window title
      frame.setSize(1450, 800);			            //Size of game window
      frame.setLocation(1, 1);				         //location of game window on the screen
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ex-out when closed
      frame.setContentPane(screen);		
      frame.setVisible(true);
      	      //  MouseListeners would go in the JPanel (screen)
   }
  
 
}
