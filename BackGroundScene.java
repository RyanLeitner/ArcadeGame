import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BackGroundScene extends Canvas implements KeyListener, Runnable
{   private ArrayList<MovingAliens> aliens;
	private MovingBox box;
	private ArrayList<MovingBullet> bullets;
	
	private boolean[] keys;
	private BufferedImage back;
	private int x,y;
    
	public BackGroundScene()
	{
		setBackground(Color.black);
		aliens = new ArrayList<MovingAliens>();
		keys = new boolean[5];
		
		box = new MovingBox( 200, 500, 50, 50, 2);
		x = box.getX() + (box.getWidth()/2);
		y=box.getY();
		bullets = new ArrayList<MovingBullet>();
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
		int aliencount = 25;
		
		int xpos = 75;
		int ypos = 25;
	for (int i = 0;i<aliencount;i++){
		if (xpos>675)
		{
		    ypos+=50;
			xpos = 75;
		}
		aliens.add(new MovingAliens(xpos,ypos,50,30,10));
		xpos+=150;
		
	}
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics backgroundImage = back.createGraphics();

		backgroundImage.setColor(Color.BLUE);
		backgroundImage.drawString("StarFighter ", 25, 50 );
		backgroundImage.setColor(Color.black);
		backgroundImage.fillRect(0,0,800,600);
		for (int n =0;n<aliens.size();n++){
			aliens.get(n).draw(backgroundImage);
		}
		
	
		if(keys[0] == true )
			{
				box.move("LEFT");
				x = box.getX() + (box.getWidth()/2);
				y=box.getY();
			}

		if(keys[1] == true  )
			{
				box.move("RIGHT");
				x = box.getX() + (box.getWidth()/2);
				y=box.getY();
			}
		if(keys[3] == true  )
			{
				box.move("UP");
				x = box.getX() + (box.getWidth()/2);
				y=box.getY();
			}
		if(keys[2] == true  )
			{
				box.move("DOWN");
				x = box.getX() + (box.getWidth()/2);
				y=box.getY();
			}
		if(keys[4] == true)
		{
				bullets.add(new MovingBullet(x, y, 5, 5, 10));
				
		}	
		
		for (int i=0;i<bullets.size();i++)
		{
			bullets.get(i).draw(backgroundImage);
			bullets.get(i).move("UP");
		}
		
		for (int j=0;j<bullets.size();j++){
			for (int a =0;a<aliens.size();a++){
				if (aliens.get(a).didHit(bullets.get(j)) == true)
				{aliens.get(a).setHeight(0);
				aliens.get(a).setWidth(0);
				bullets.get(j).setWidth(0);
				bullets.get(j).setHeight(0);
				bullets.get(j).setX(0);
				bullets.get(j).setY(0);
				
				
				}
				
				
					
					
				   

					
			}
		}
        
		box.draw( backgroundImage );
		


		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship


		twoDGraph.drawImage(back, null, 0, 0);
		twoDGraph = (Graphics2D)window;
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
	
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

