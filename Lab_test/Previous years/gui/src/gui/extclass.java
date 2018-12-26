package gui;
import java.awt.*;
import java.awt.event.*;
public class extclass extends Frame {
	TextField tf;
	Label l;
	public extclass()
	{
		setTitle("Core Banking");
		tf = new TextField();
		tf.setBounds(100,100,170,30);
		Button b = new Button("Submit");
		b.setBounds(100,150,100,30);//positions the object along witha fixed size
		l = new Label();
		l.setBounds(100, 50, 170, 30);
		l.setBackground(Color.green);
		add(b);
		add(tf);
		add(l);
		AHandler a = new AHandler(this);
		b.addActionListener(a);
		tf.addTextListener(a);
		setBackground(Color.CYAN);
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
		
		//setLayout(new FlowLayout())	;
	addWindowListener(new MyWindowAdapter());
	}
	class MyWindowAdapter extends WindowAdapter
	{

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			//super.windowClosing(e);
			System.exit(0);
		}
		
		
	}
	class AHandler implements ActionListener,TextListener{
		extclass obj;
		AHandler(extclass t){
		this.obj = t;
		}
		public void textValueChanged(TextEvent e)
		{
			obj.l.setText("Entered text: " + obj.tf.getText());
		}
		public void actionPerformed(ActionEvent E)
		{
		obj.l.setText("Welcome to Core Banking");}
		}

	public static void main(String[] args)
	{
		new extclass();
	}

}
