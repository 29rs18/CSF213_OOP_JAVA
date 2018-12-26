package gui;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
public class GUITest implements ActionListener 
{ 
	JFrame frame; 
	JPanel commentPanel; 
	JButton button1; 
	JTextArea text1; 
	JLabel label; 
	GUITest() 
	{ 
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// exists when you close the window 
		//set the default size of the frame 
		frame.setSize(700,700); //Display the frame on the screen 
		frame.setVisible(true); //creating panel that contains label, text area and //button 
		commentPanel= new JPanel(); 
		commentPanel.setLayout(null); 
		label=new JLabel("Your feedback :"); 
		label.setLocation(50, 25); 
		label.setSize(100, 30); 
		commentPanel.add(label); 
		text1=new JTextArea(); 
		text1.setLocation(50, 50); 
		text1.setSize(500, 100); 
		commentPanel.add(text1); 
		button1 =new JButton("Submit"); 
		button1.setLocation(50,175); 
		button1.setSize(100, 30); 
		button1.addActionListener(this); 
		commentPanel.add(button1); 
		frame.add(commentPanel); 
		frame.validate(); 
		} 
	public static void main(String args[])
	{ 
		new GUITest(); 
	} 
	public void actionPerformed(ActionEvent e){ 
		
		JButton b =(JButton) e.getSource();
		b.setVisible(false);
		text1.setEnabled(false);
		//see (1)in exercise 2.1 } }
	}
}