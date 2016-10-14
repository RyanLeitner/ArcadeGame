import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class MovingBullet extends Thang
{
	private int speed;
	private Image image;

	public MovingBullet()
	{
		this(10, 10, 10, 10, 10);
	}

	public MovingBullet(int x, int y)
	{
	   this(x, y, 10, 10, 10);
	}

	public MovingBullet(int x, int y, int s)
	{
	   this( x, y, 10, 10, s);
	}

	public MovingBullet(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/bullet.jpg");
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
		 
		 if( direction.equals("UP"))
		 	   setY( getY() - getSpeed() );
		

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