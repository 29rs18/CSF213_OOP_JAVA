package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class minesweeper extends JFrame implements ActionListener
{
	Button b[] = new Button[25];
minesweeper() {
	this.setVisible(true);
	this.setTitle("Minesweeper");
	setSize(400,400);
	this.setLayout(new GridLayout(5,5));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	for(int i = 0;i<25;i++)
	{
		b[i] = new Button(Integer.toString(i+1));
		
		b[i].addActionListener(this);
		//tf
		add(b[i]);
	}

}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Button b =  (Button) e.getSource();
	b.setLabel("Pressed");
}

public static void main(String[] args)
{
	new minesweeper();
}
}
