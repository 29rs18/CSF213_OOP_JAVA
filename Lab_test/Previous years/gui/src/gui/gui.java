package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class gui {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("My First GUI");
		frame.setLayout(new FlowLayout());;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setSize(300, 300);
		JButton b1 = new JButton("Press 1");
		JButton b2 = new JButton("Press 2");
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
	}
	
}
