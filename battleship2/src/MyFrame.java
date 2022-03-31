import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	public String text;
	public JLabel serverText;
	JButton button;
	JTextField textField;
	JLabel serverLabel;
	MyPanel panel;
	
	
	
	MyFrame(){
		panel = new MyPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		button = new JButton("Submit");
		button.addActionListener(this);
		button.setBounds(250, 1300, 165, 40);
		//button.setBounds(250, 850, 165, 40); for 1080p
		
		
		
		textField = new JTextField();
		//textField.setBounds(250, 800, 165, 40); for 1080p
		textField.setBounds(250, 1250, 165, 40);
		textField.setFont(new Font("Consolas", Font.PLAIN, 15));
		textField.setForeground(new Color(0xFFFFFF));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.white);
		textField.setText("Type in Coordinate");
		
		serverLabel = new JLabel("Server Messages");
		serverLabel.setBounds(2000, 325, 300, 40);
		serverLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		serverLabel.setBackground(Color.BLACK);
		
		serverText = new JLabel("<html><p>Welcome to the Jungle, we got fun and games</p></html>");
		serverText.setBounds(1925, 310, 300, 500);
		serverText.setFont(new Font("Consolas", Font.PLAIN, 15));
		serverText.setBackground(Color.BLACK);
		
		
		
		this.add(textField);
		this.add(button);
		this.add(serverLabel);
		this.add(serverText);
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
//		this.toFront();
//		this.requestFocus();
//		this.repaint();
	}
	public static void main(String[] args) {
		MyFrame a = new MyFrame();
	}
	
//	public @Override void toFront() {
//		int sta = super.getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;
//		
//		super.setExtendedState(sta);
//		super.setAlwaysOnTop(true);
//		super.toFront();
//		super.requestFocus();
//		super.setAlwaysOnTop(false);
//	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			text = textField.getText();
			
		}
		
	}

}
