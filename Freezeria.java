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
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
   
public class Freezeria extends JPanel implements MouseListener, MouseMotionListener, ImageObserver
{
   private static final int SIZEx = 1450; 
   private static final int SIZEy = 800;    //size of square screen to be drawn
   private static final int textSize = 25;   //font size
   private static final int DELAY = 0;	      //#miliseconds delay between each time the screen refreshes for the timer
   private static Timer t;	//used to control what happens each frame (game code)
   private static int frame; 
  
    //***BUTTON CODE***define array of buttons
   private Button [] buttons = new Button[4]; 
   private Button [] continueButton = new Button[1];               //buttons to activate features
   private Button [] flavorButtons = new Button[3];
   //*****************/
   
   protected static int mouseX;			      //locations for the mouse pointer
   protected static int mouseY;
   boolean firstClick=false;
   
   private static int playerX, playerY;                        //position of the player  
   private ImageIcon player = new ImageIcon("Xandra.png");     //image for the client player
   private Player[] customers= new Player[1];
   private ImageIcon[] utah = {new ImageIcon("Utah.png")};
   
   private int properOrderFlavor; //integer for the proper flavor customer wants
   private String OrderTicketFlavor;//the actual name of the flavor customer wants
   private int playerOrderFlavor;//the integer for the flavor that gameplayer clicked
   private String[] flavorWords= { "Peanut Butter Cup", "Strawberry","Blueberry"};//all possible flavors
   
   private static final int STARTSCREEN=0, ORDER_STATION=1, BUILD=2, MIX = 3, TOPPING=4, EVALUATION=5; //different game modes
   private static int gameMode;                                       
   public Freezeria()
   {
      gameMode = STARTSCREEN;               
      customers[0]= new Player("utah", SIZEx-200, SIZEy-370, 0, utah, 10, SIZEy);
      
      properOrderFlavor=(int)(Math.random()*(2))+1;
      OrderTicketFlavor= flavorWords[properOrderFlavor];
     
      frame=0;
      
      addMouseListener( this );
      addMouseMotionListener( this );
      mouseX = SIZEx/2;                       
      mouseY = SIZEy/2;
      
      
      Shape r2 = new Ellipse2D.Float(450, SIZEy-100,100, 50);
      Shape r3 = new Ellipse2D.Float(600, SIZEy-100,100, 50);
      Shape r4 = new Ellipse2D.Float(750, SIZEy-100,100, 50);
      Shape r5 = new Ellipse2D.Float(900, SIZEy-100,100, 50);
      Shape r6 = new Rectangle(205, 163,140, 115);//int x, int y, width height
      Shape r7 = new Rectangle(51, 163,140, 115);//int x, int y, width height
      Shape r8 = new Rectangle(897, 163,140, 115);//int x, int y, width height
      
      
      buttons[0] = new Button(r2, "Order",  new Color(100,222,80), Color.YELLOW, Color.BLACK);
      buttons[1] = new Button(r3, "Build", new Color(125,73,213), Color.YELLOW, Color.BLACK);
      buttons[2] = new Button(r4, "Mix", new Color(232,157,45), Color.YELLOW, Color.BLACK);
      buttons[3] = new Button(r5, "Toppings", new Color(54,76,220), Color.YELLOW, Color.BLACK);
      continueButton[0] = new Button(r2, "CONTINUE", new Color(233,54,90), Color.YELLOW, Color.BLACK);
      //buttons[2] = new Button(r3, "sound", buttonImage1, buttonImage2);
   
      ImageIcon flavorButtonImage1 = new ImageIcon("PeanutButterCup.png");
      ImageIcon flavorButtonImage2 = new ImageIcon("Strawberry.png");
      ImageIcon flavorButtonImage3 = new ImageIcon("Blueberry.png");
      flavorButtons[0] = new Button(r6, "", flavorButtonImage1, flavorButtonImage2);
      flavorButtons[1] = new Button(r7, "", flavorButtonImage2, flavorButtonImage1);
      flavorButtons[2] = new Button(r8, "", flavorButtonImage3, flavorButtonImage1);
      
   
   
   }


   public void showBoard(Graphics g)	
   {
   
      
         
      if(gameMode == ORDER_STATION)
      {
         ImageIcon orderImage = new ImageIcon("order.png");
         g.drawImage(orderImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);
         g.drawImage(customers[0].getPicture().getImage(), customers[0].getX(), customers[0].getY(), 200, 300, null);
      }
      
      
      else if(gameMode == BUILD)
      {
         ImageIcon buildImage = new ImageIcon("build.png");
         g.drawImage(buildImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(buttons, g);
         drawButtons(flavorButtons, g);
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
         ImageIcon logoImage = new ImageIcon("BeginLogo.jpg");
         g.drawImage(logoImage.getImage(), 0,0,SIZEx,SIZEy, null);
         drawButtons(continueButton, g);		                              
      
      }
      
      t= new Timer(0, new Listener());
      t.start();
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
               if(b.getTitle().equals("Order"))
               {
                  gameMode=1;
               }
               else if(b.getTitle().equals("Build"))
                  gameMode=2;  
               else if(b.getTitle().equals("Mix"))
                  gameMode=3;
               else if(b.getTitle().equals("Toppings"))
                  gameMode=4;
            }
         } 
         for(Button b: flavorButtons) 
         {
            if(b.getShape().contains(mouseX, mouseY))
            {
               if(b.getImageIcon().equals("PeanutButterCup.png"))
                  playerOrderFlavor = 1;
               else if(b.getImageIcon().equals("Strawberry.png"))
                  playerOrderFlavor = 2;
               else if(b.getImageIcon().equals("Blueberry.png"))
                  playerOrderFlavor = 3;
            }
         
         } 
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
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         frame++;
         if (frame==Integer.MAX_VALUE)
            frame=0;
      //if orrderstation and utah is not at the counter yet
         //move utah to the left
         if(gameMode == ORDER_STATION)
         {
            if(customers[0].getX()>200 && frame%100==0)
            {
               customers[0].setX(customers[0].getX()-1);
            }
            if(customers[0].getX()==200)
            {
               Shape order = new Ellipse2D.Float(450, SIZEy-500,100, 50);//how do I get a shape to just pop up
            //order.drawShape(g);
            }
            
            
         }
         
         repaint();
         
      }
   }
}
