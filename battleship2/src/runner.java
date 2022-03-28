import java.awt.*;
import javax.swing.*;

public class runner extends JFrame
{
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	
	public runner()
	{
		super("Animation Runner");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
				
		scene scene = new scene( );		       
		add( scene );	       	
      	
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		runner run = new runner();
	}
}
	