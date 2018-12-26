package gui;
import java.awt.event.*;
import java.awt.*;
public class ButtonExample extends Frame implements ActionListener {

	TextField tf;
	Button b1,b2,b3;
	ButtonExample()
	{
		tf = new TextField();
		b1 = new Button("Yes");
		b2 = new Button("No");
		b3 = new Button("Maybe");
		b1.setBounds(50, 50, 200, 50);
		b2.setBounds(50, 200, 200, 50);
		b3.setBounds(50, 300, 200, 50);
		tf.setBounds(50, 500, 200, 50);
		add(b1);
		add(b2);
		add(b3);
		add(tf);
		setLayout(null);
		setSize(1000,1000);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setVisible(true);
		addWindowListener(new MyWindowAdapter());
		
	}
	class MyWindowAdapter extends WindowAdapter
	{

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
		System.exit(0);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button x = (Button) e.getSource();
		tf.setText("Button Pressed: "+ x.getLabel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new ButtonExample();
	}

}
