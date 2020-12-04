//D Oberle 6/2/20
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image ;
import java.awt.image.ImageObserver;
import javax.swing.Timer;                    //there is a swing timer and an awt timer, so we have to be specific and not use .*
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
   
public class Freezeria extends JPanel implements MouseListener, MouseMotionListener, ImageObserver
{
   private static final int SIZEx = 1450; 
   private static final int SIZEy = 800;    //size of square screen to be drawn
   private static final int textSize = 25;   //font size
   private static final int DELAY = 0;	      //#miliseconds delay between each time the screen refreshes for the timer
   private static Timer t;							//used to control what happens each frame (game code)
   
    //***BUTTON CODE***define array of buttons
   private Button [] buttons = new Button[4]; 
   private Button [] continueButton = new Button[1];               //buttons to activate features
   //*****************/
   
   protected static int mouseX;			      //locations for the mouse pointer
   protected static int mouseY;
   boolean firstClick=false;
   
   private static final int STARTSCREEN=0, ORDER_STATION=1, BUILD=2, MIX = 3, TOPPING=4, EVALUATION=5; //different game modes
   private static int gameMode;                                       
   public Freezeria()
   {
      gameMode = STARTSCREEN;
                      
     
      //Sound.initialize();
      //t = new Timer(DELAY, new Listener());	//the higher the value of DELAY, the slower the refresh rate is
      //t.start();
      //ImageObserver observer;
      addMouseListener( this );
      addMouseMotionListener( this );
      mouseX = SIZEx/2;                       
      mouseY = SIZEy/2;
      
      
      Shape r2 = new Ellipse2D.Float(450, SIZEy-100,100, 50);
      
      Shape r3 = new Ellipse2D.Float(600, SIZEy-100,100, 50);
      Shape r4 = new Ellipse2D.Float(750, SIZEy-100,100, 50);
      Shape r5 = new Ellipse2D.Float(900, SIZEy-100,100, 50);
      //ImageIcon buttonImage1 = new ImageIcon("graphics/button1.jpg");
      //ImageIcon buttonImage2 = new ImageIcon("graphics/button2.jpg");
      buttons[0] = new Button(r2, "Order Station", Color.CYAN, Color.YELLOW, Color.BLACK);
      buttons[1] = new Button(r3, "Build", Color.CYAN, Color.YELLOW, Color.BLACK);
      buttons[2] = new Button(r4, "Mix", Color.CYAN, Color.YELLOW, Color.BLACK);
      buttons[3] = new Button(r5, "Toppings", Color.CYAN, Color.YELLOW, Color.BLACK);
      continueButton[0] = new Button(r2, "CONTINUE", Color.CYAN, Color.YELLOW, Color.BLACK);
      //buttons[2] = new Button(r3, "sound", buttonImage1, buttonImage2);
   
   }


   public void showBoard(Graphics g)	
   {
   
      
         
      if(gameMode == ORDER_STATION)
      {
         
         ImageIcon orderImage = new ImageIcon("order.png");
         g.drawImage(orderImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);
      }
      else if(gameMode == BUILD)
      {
         ImageIcon buildImage = new ImageIcon("build.png");
         g.drawImage(buildImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);
      }
      else if(gameMode == MIX)
      {
         ImageIcon mixImage = new ImageIcon("mix.png");
         g.drawImage(mixImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);	
      }
      else if(gameMode == TOPPING)
      {
         ImageIcon toppingImage = new ImageIcon("topping.png");
         g.drawImage(toppingImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);
      }
      
      else //if(gameMode == STARTSCREEN)       
      {
         ImageIcon logoImage = new ImageIcon("Logo.png");
         g.drawImage(logoImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(continueButton, g);		                              
      
      }
   }
   
  

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      showBoard(g);					      
   }
   public void drawButtons(Button[] buttons, Graphics g)
   {
      for(Button b:buttons)
      {
         b.drawButton(g);
      }					      
   }
         
   public void mouseClicked( MouseEvent e )
   {
      int button = e.getButton();
      if(button == MouseEvent.BUTTON1)
      {
         //***BUTTON CODE***actions if clicked on button
         for(Button b:buttons)
         {
            if(b.getShape().contains(mouseX, mouseY))
            {
               if(b.getTitle().equals("Order Station"))
               {
                  if (firstClick==false)
                  {
                     //t = new Timer(/*DELAY, new Listener()*/);	//the higher the value of DELAY, the slower the refresh rate is
                     t.start();
                     firstClick=true;
                     gameMode=1;
                  }
                  else
                     gameMode=1;
                  
               }
               else if(b.getTitle().equals("Build"))
                  gameMode=2;  
               else if(b.getTitle().equals("Mix"))
                  gameMode=3;
               else if(b.getTitle().equals("Toppings"))
                  gameMode=4;
               //else if(b.getTitle().equals("sound"))
                  //gameMode=5;
            }
         }   
      //*****************/
      } 
      else if(button == MouseEvent.BUTTON3)//right click
      {
         
      }
      repaint();
   }

   public void mousePressed( MouseEvent e )
   {}

   public void mouseReleased( MouseEvent e )
   {}

   public void mouseEntered( MouseEvent e )
   {}

   public void mouseMoved( MouseEvent e)
   {
      mouseX = e.getX();
      mouseY = e.getY(); 
      //***BUTTON CODE***highlight button if mouse is on it
      for(Button b:buttons)
      {
         if(b.getShape().contains(mouseX, mouseY))
            b.highlight();
         else
            b.unHighlight();
      }   
      //*****************/
      repaint();			//refresh the screen
   }

   public void mouseDragged( MouseEvent e)
   {}

   public void mouseExited( MouseEvent e )
   {}
   
   //this forces the mouse to the position sent in as the Point p: thanks Stackoverflow!
   //https://stackoverflow.com/questions/2941324/how-do-i-set-the-position-of-the-mouse-in-java
   public void moveMouse(Point p) {
      GraphicsEnvironment ge = 
         GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice[] gs = ge.getScreenDevices();
    // Search the devices for the one that draws the specified point.
      for (GraphicsDevice device: gs) { 
         GraphicsConfiguration[] configurations =
            device.getConfigurations();
         for (GraphicsConfiguration config: configurations) {
            Rectangle bounds = config.getBounds();
            if(bounds.contains(p)) {
                // Set point to screen coordinates.
               Point b = bounds.getLocation(); 
               Point s = new Point(p.x - b.x, p.y - b.y);
            
               try {
                  Robot r = new Robot(device);
                  r.mouseMove(s.x, s.y);
               } catch (AWTException e) {
                  e.printStackTrace();
               }
            
               return;
            }
         }
      }
    // Couldn't move to the point, it may be off screen.
      return;
   }

   public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
   {
      return false;
   }
}
