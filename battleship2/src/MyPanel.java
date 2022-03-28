import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel {
	MyPanel(){
		this.setPreferredSize(new Dimension(1920, 1080));
	}
	public void paint(Graphics window) {
//		Graphics2D g = (Graphics2D) window;
//		g.drawLine(0, 0, 500, 500);
		
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Image b = t.getImage("sea.jpg");
		Image four = t.getImage("sea1440p.jpg");
		Image i = t.getImage("boardimage.jpg");
		
		window.drawImage(b, 0, 0, this);
		window.drawImage(i, 650, 0, this);
		window.drawImage(i, 650, 500, this);
		
		
		//this is for 1080p
		
//		window.drawImage(four, 0, 0, this);
//		window.drawImage(i, 950, 50, this); 
//		window.drawImage(i, 950, 650, this);
//		// this is for the 1440p thing
	}
}
