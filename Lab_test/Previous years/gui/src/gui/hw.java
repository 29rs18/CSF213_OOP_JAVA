package gui;

import java.awt.event.*;
import java.awt.*;
public class hw extends Frame implements ActionListener,KeyListener {
/**
	 * 
	 */
//	private static final long serialVersionUID = 5558422275301260062L;
TextField tf1,tf2,tf3;
Button b;
	public hw()
	{
		this.addWindowListener(new myWindowAdapter());
		//Frame f = new Frame();
		this.setLayout(new FlowLayout());
		this.setTitle("Result calc");
		this.setVisible(true);
		this.setSize(800, 800);
		Label l1 = new Label("Number 1");
		Label l2 = new Label("Number 2");
		Label l3 = new Label("Number 3");
		 tf1 = new TextField();
		 tf2 = new TextField();
		 tf3 = new TextField();
		 tf1.setBounds(l1.getX()+20, l1.getY() + 20, 1500, 150);
		 tf1.setPreferredSize(new Dimension(100,30));
		// tf1.setSize(new Dimension(100, 50));
		 tf2.setPreferredSize(new Dimension(100, 30));
		 tf3.setPreferredSize(new Dimension(100, 30));
		 /*l1.setBounds(10,20, 50, 50);
		l2.setBounds(10,120, 50, 50);
		l3.setBounds(10,220, 50, 50);
		*/
		 b = new Button("Enter");
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		add(b);
		addKeyListener(this);
		b.addActionListener(this);
		
	}
	public class myWindowAdapter extends WindowAdapter 
	{

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e)throws NumberFormatException {
		// TODO Auto-generated method stub
		
		int sum = Integer.parseInt(tf1.getText()) +Integer.parseInt(tf2.getText());
		tf3.setText(Integer.toString(sum));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			int sum = Integer.parseInt(tf1.getText()) +Integer.parseInt(tf2.getText());
			tf3.setText(Integer.toString(sum));
		}
	}
	public static void main(String[] args)
	{
		new hw();
	}
}
