import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	public String text;
	JButton button;
	JTextField textField;
	MyPanel panel;
	
	
	
	MyFrame(){
		panel = new MyPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		button = new JButton("Submit");
		button.addActionListener(this);
		button.setBounds(250, 850, 165, 40);
		
		
		
		textField = new JTextField();
		textField.setBounds(250, 800, 165, 40);
		textField.setFont(new Font("Consolas", Font.PLAIN, 15));
		textField.setForeground(new Color(0xFFFFFF));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.white);
		textField.setText("Type in Coordinate");
		
		
		this.add(textField);
		this.add(button);
		
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
