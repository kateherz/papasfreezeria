//D Oberle 5/5/20
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
public class KatesFreezeria					   
{
   public static Freezeria screen;					//Our Custom JPanel

   public static void main(String[]args) throws InterruptedException
   {
      screen = new Freezeria();
      JFrame frame = new JFrame("Kate's Freezeria");	//window title
      frame.setSize(1450, 800);			            //Size of game window
      frame.setLocation(1, 1);				         //location of game window on the screen
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ex-out when closed
      frame.setContentPane(screen);		
      frame.setVisible(true);
      	      //  MouseListeners would go in the JPanel (screen)
      boolean x=true; //https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java/14323134
            long displayMinutes=0;
            long starttime=System.currentTimeMillis();
            System.out.println("Timer:");
            while(x)
            {
               TimeUnit.SECONDS.sleep(1);
               long timepassed=System.currentTimeMillis()-starttime;
               long secondspassed=timepassed/1000;
               if(secondspassed==60)
               {
                  secondspassed=0;
                  starttime=System.currentTimeMillis();
               }
               if((secondspassed%60)==0)
                  displayMinutes++;
            
               System.out.println(displayMinutes+"::"+secondspassed);
            }
         }
      
  
 
}
