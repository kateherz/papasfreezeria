//D Oberle 6/2/20
import javax.swing.ImageIcon;
   
public class Player
{
   private String name;   
   private int x, y;             //location
   private int dir;              //direction traveling
   public static final int N=0, NNE=1, NE=2, ENE=3,      //directions you can travel (state of dir)
                           E=4, ESE=5, SE=6, SSE=7, 
                           S=8, SSW=9, SW=10, WSW=11, 
                           W=12, WNW=13, NW=14, NNW=15;
   private ImageIcon[] pictures;	                        //array of images for the player
   private int animationIndex;  	//this is the index for the col in picture array (which animation frame we are on
   private int animationDelay;	//the higher the delay, the slower the animation will be
   private int numFrames;			//the total number of frames that have passed   
   private int screenSize;       //we need to know where the boundries are for moving
   
   public Player(String n, int dx, int dy, int dr, ImageIcon [] p, int ad, int s)
   {
      name = n;
      x = dx;
      y = dy;
      dir = dr;
      pictures = p;
      animationDelay = ad;
      animationIndex = 0;
      numFrames = 0;
      screenSize = s;
   }
   
   //return the current animation frame and advance to the next frame with wrap-around  
   public ImageIcon getPicture()
   {
      if(animationIndex < 0 || animationIndex >= pictures.length)
         return null;
      ImageIcon temp = pictures[animationIndex];
      if(numFrames == Integer.MAX_VALUE)
         numFrames = 0;
      numFrames++;
      if(numFrames % animationDelay == 0)
         animationIndex = (animationIndex + 1) % pictures.length;
      return temp;
   }  
      
   public String getName()
   {
      return name;
   }
      
   public int getX()
   {
      return x;
   }
   	
   public int getY()
   {
      return y;
   }

   public void setX(int dX)
   {
      x = dX;
   }
   	
   public void setY(int dY)
   {
      y = dY;
   }

   public int getDir()
   {
      return dir;
   }

   public void setDir(int d)
   {
      if(d >= 0 && d <=15)
         dir = d;
   }
   
   //moves the enemy player in a random like fashion with screen boundry wrap-around
   public void autoMove()
   {
      int speed = 1;
   
      if(Math.random()< 0.05)
      {
         if(Math.random() < 0.5 && dir < 15)
         {
            dir++;
         }
         else if(dir > 0)
         {
            dir--;
         }
      }
   
      if(dir == N)
      {
         y -= (speed*2);
      }
      else if(dir == NNE)
      {
         y -= (speed*2);
         x += speed;
      }
      else if(dir == NE)
      {
         y -= speed;
         x += speed;
      }
      else if(dir == ENE)
      {
         y -= speed;
         x += (speed*2);
      }
      else if(dir == E)
      {
         x += (speed*2);
         if( x>= screenSize)
            dir = W;
      }
      else if(dir == S)
      {
         y += (speed*2);
      }
      else if(dir == SSE)
      {
         y += (speed*2);
         x += speed;
      }
      else if(dir == SE)
      {
         y += speed;
         x += speed;
      }
      else if(dir == ESE)
      {
         y += speed;
         x += (speed*2);
      } 
      else if(dir == NNW)
      {
         y -= (speed*2);
         x -= speed;
      }
      else if(dir == NW)
      {
         y -= speed;
         x -= speed;
      }
      else if(dir == WNW)
      {
         y -= speed;
         x -= (speed*2);
      }
      else if(dir == W)
      {
         x -= (speed*2);
         if( x < 0)
            dir = E;
      }
      else if(dir == SSW)
      {
         y += (speed*2);
         x -= speed;
      }
      else if(dir == SW)
      {
         y += speed;
         x -= speed;
      }
      else if(dir == WSW)
      {
         y += speed;
         x -= (speed*2);
      }
      if(x < 0)
         x = screenSize;
      else if(x > screenSize)
         x = 0;
      if(y < 0)
         y = screenSize;
      else if(y > screenSize)
         y = 0;
   }

}