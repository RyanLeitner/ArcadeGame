import java.awt.Color;
import java.awt.Graphics;

public abstract class Thang implements Controllable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public Thang()
	{
		xPos = 10;
		yPos = 10;
		width = 10;
		height = 10;
	}

	public Thang(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
	}

	public Thang(int x, int y, int w, int h)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}

	public void setPos( int x, int y)
	{
		//add code here
	}

	public void setX(int x)
	{
		xPos = x;
	}

	public void setY(int y)
	{
		yPos = y;
	}

	public int getX()
	{
		return xPos;   //finish this method
	}

	public int getY()
	{
		return yPos;  //finish this method
	}

	public void setWidth(int w)
	{
		width = w;
	}

	public void setHeight(int h)
	{
		height = h;
	}

	public int getWidth()
	{
		return width;  //finish this method
	}

	public int getHeight()
	{
		return height;  //finish this method
	}
	public boolean  didHit(Thang other){
		if ((other.getX() >= this.getX() && other.getX() <= this.getX()+this.getWidth())&& (other.getY()+other.getHeight() <=getY()))
			return true;
			return false;
	}

	public abstract void move(String direction);
	public abstract void draw(Graphics window);

	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}