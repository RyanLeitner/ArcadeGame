import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class MovingBox extends Thang
{
	private int speed;
	private Image image;

	public MovingBox()
	{
		this(10, 10, 10, 10, 10);
	}

	public MovingBox(int x, int y)
	{
	   this(x, y, 10, 10, 10);
	}

	public MovingBox(int x, int y, int s)
	{
	   this( x, y, 10, 10, s);
	}

	public MovingBox(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   speed =s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		 if( direction.equals("LEFT"))
		 	   setX( getX() - getSpeed() );
		 if( direction.equals("RIGHT"))
		 	   setX( getX() + getSpeed() );
		 if( direction.equals("UP"))
		 	   setY( getY() - getSpeed() );
		 if( direction.equals("DOWN"))
		 	   setY( getY() + getSpeed() );
		 if ( direction.equals("LEFT") && getX()<0)
		 	   setX(800);
		 if (direction.equals("RIGHT") && getX()>800)
		 	   setX(0);

		 //add more code to check for all directions

	}

	public void draw( Graphics window )
	{
   		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
