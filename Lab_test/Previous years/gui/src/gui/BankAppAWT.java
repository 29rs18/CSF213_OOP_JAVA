package gui;

import java.awt.FlowLayout;

public class BankAppAWT extends Frame{
	String msg="";
	TextField tf;
	CheckboxGroup cg;
	Choice state;
	double pchange,interest;
	Label l5,l6;
	BankAppAWT()
	{
		setSize(500,500);
		setVisible(true);
		setTitle("Banking APP");
		setLayout(new FLowLayout(FlowLayout.LEFT,100,25));
		Label l1 = new Label("Name");
		add(l1);
	}
	public static void main(String[] args)
	{
		new BankAppAWT();
	}

}
