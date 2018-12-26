package gui;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class xandy extends JFrame implements ActionListener{
JButton[] b = new JButton[9];
int alternate = 0;
	public xandy()
	{
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		initializebuttons();
	}
	public void initializebuttons()
	{
		for(int i =0 ;i<9;i++)
		{
			b[i] = new JButton("");
			b[i].addActionListener(this);
			add(b[i]);
		}
	}
	public void reset()
	{
		alternate = 0;
		for(int i =0 ;i<9;i++)
		{
			b[i].setText("");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b= (JButton)e.getSource();
		if(alternate % 2 == 0 && b.getText().equals(""))
		{
			b.setText("X");
					}
		else if(alternate % 2 != 0 && b.getText().equals(""))
			b.setText("O");
		else 
		{
			JOptionPane.showMessageDialog(null, "Illegal Operation");
			alternate--;
		}
			alternate++;
			if(check_win() == true)
			{
				JOptionPane.showMessageDialog(null, "You Won!");
				reset();
			}	
			if(check_full() == true)
			{
				JOptionPane.showMessageDialog(null, "Game Drawn");
				reset();
			}
	}
	public boolean check_full()
	{
		int flag = 0;
		for(int i = 0;i<9;i++)
		{
			if(b[i].getText().equals(""))
				flag = 1;
		}
		if (flag == 0)
			return true;
		else 
			return false;
	}
	public boolean check_win()
	{
		//hori
		if(check(0,1,2))
			return true;
		else if(check(3,4,5))
			return true;
		else if(check(6,7,8))
			return true;
		//verti
		else if(check(0,3,6))
			return true;
		else if(check(1,4,7))
			return true;
		else if(check(2,5,8))
			return true;
		
//diag
		else if(check(0,4,8))
			return true;
		else if(check(2,4,6))
			return true;
		else
			return false;
	}
	boolean check(int x, int y, int z)
	{
		if(b[x].getText().equals(b[y].getText()) && b[y].getText().equals(b[z].getText()) &&  !b[x].getText().equals(""))
				return true;
		else 
			return false;
	}
	public static void main(String[] args)
	{
		new xandy();
	}
}
