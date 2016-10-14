import javax.swing.JFrame;
import java.awt.Component;

public class ArcadeGame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public ArcadeGame()
	{
		super("SPACE INVADERS");
		setSize(WIDTH,HEIGHT);

		BackGroundScene view = new BackGroundScene();
		((Component) view ).setFocusable(true);

		getContentPane().add( view );

		setVisible(true);
	}

	public static void main( String args[] )
	{
		ArcadeGame run = new ArcadeGame();
	}
}