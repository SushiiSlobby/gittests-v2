import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;

public class scene extends JPanel implements Runnable
{
	//sets, maps, stacks
	
	
	public scene()
	{
		
		
		//add code here to make a new storage container
		
		
		
		new Thread(this).start();
	}

	public void paintComponent( Graphics window )
	{
		Toolkit t = Toolkit.getDefaultToolkit();
		Image b = t.getImage("sea.jpg");
		Image i = t.getImage("boardimage.jpg");
		
		window.drawImage(b, 0, 0, this);
//		window.drawImage(i, 650, 0, this); 
//		window.drawImage(i, 650, 487, this);
		// this is for the 1440p thing
		
		
		
		
//		
//		window.setColor(Color.yellow);
//		Graphics2D a = (Graphics2D) window;
//		int xPnts[] = {42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42}; 
//        int yPnts[] = {38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38}; 
//        window.drawPolygon(xPnts, yPnts, xPnts.length);
//        window.fillPolygon(xPnts, yPnts, xPnts.length);
//		
//		window.setColor(Color.white);
//		
//		window.drawOval(-50, 375, 200, 150); // right1
//		window.fillOval(-50, 375, 200, 150);
//		
//		window.drawOval(650, 375, 200, 150); //left 1
//		window.fillOval(650, 375, 200, 150);
//		
//		window.drawOval(60, 380, 200, 150); // right 2
//		window.fillOval(60, 380, 200, 150);
//		
//		window.drawOval(540, 380, 200, 150); // left 2
//		window.fillOval(540, 380, 200, 150);
//		
//		window.drawOval(150, 390, 200, 150);
//		window.fillOval(150, 390, 200, 150);
//		
//		window.drawOval(225, 390, 200, 150);
//		window.fillOval(225, 390, 200, 150);
//		
//		window.drawOval(300, 390, 200, 150);
//		window.fillOval(300, 390, 200, 150);
//		
//		window.drawOval(375, 395, 200, 150);
//		window.fillOval(375, 395, 200, 150);
//		
//		window.drawOval(450, 390, 200, 150);
//		window.fillOval(450, 390, 200, 150);
//		
//		window.setColor(Color.white.darker());
//		
//		a.setStroke(new BasicStroke(3));
//		a.drawOval(-50, 375, 200, 150);
//		a.drawOval(650, 375, 200, 150);
//		a.drawOval(60, 380, 200, 150);
//		a.drawOval(540, 380, 200, 150);
//		a.drawOval(150, 390, 200, 150);
//		a.drawOval(225, 390, 200, 150);
//		a.drawOval(300, 390, 200, 150);
//		a.drawOval(375, 395, 200, 150);
//		a.drawOval(450, 390, 200, 150);
//		window.setColor(Color.white);
//		window.drawRect(0, 400, 800, 600);
//		window.fillRect(0, 400, 800, 600);
		
		
		
		
		
		//window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
      
		//draw your background stuff 
		
		//make all Things show and move
		
		
		
		
		
         	
		
	}
	
	public void run()
	{

		try
		{
			while( true )
			{	
			   Thread.sleep(10);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}
}