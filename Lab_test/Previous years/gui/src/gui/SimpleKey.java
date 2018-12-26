package gui;
import java.awt.*;
import java.awt.event.*;
public class SimpleKey extends Frame implements KeyListener {

	String msg = " ";
	String keyState = "";
	public SimpleKey()
	{
		addWindowListener(new MyWindowAdapter());
		addKeyListener(this);//SimpleKey is a key listener
		this.setLayout(new FlowLayout());
		this.setSize(600, 500);
	}
	public class MyWindowAdapter extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		this.keyState = "Key down";
		
	}
//Display keystrokes
	public void paint(Graphics g)
	{
		g.drawString(msg, 20, 100);
		g.drawString(keyState, 20, 50);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		this.keyState = "Key Up";
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		msg+= e.getKeyChar();
		Graphics g = getGraphics();
		g.setColor(Color.blue);
		repaint();
	}
	public static void main(String[] args)
	{
		SimpleKey x = new SimpleKey();
		x.setVisible(true);
		x.setTitle("Demo");
			
	}

}
