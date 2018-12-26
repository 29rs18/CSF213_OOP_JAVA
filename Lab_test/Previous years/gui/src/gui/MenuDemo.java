package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemo implements ActionListener {
@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String comString = ae.getActionCommand();
		if(comString.equals("Exit"))
			System.exit(0);
		jlab.setText(comString +" selected");
	}
JLabel jlab;
MenuDemo()
{
	JFrame jfrm = new JFrame("Menu Demo");
	jfrm.setLayout(new FlowLayout());
	jfrm.setSize(220,200);
	jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jlab = new JLabel();
	JMenuBar jmb = new JMenuBar();
	JMenu jmFile = new JMenu("File");
	jmFile.setMnemonic(KeyEvent.VK_F);
	
	JMenuItem jmiOpen = new JMenuItem("Open",KeyEvent.VK_O);
	jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
	JMenuItem jmiClose = new JMenuItem("Close",KeyEvent.VK_C);

	jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
	JMenuItem jmiSave = new JMenuItem("Save");
	JMenuItem jmiExit = new JMenuItem("Exit");
	jmFile.add(jmiOpen);
	jmFile.add(jmiClose);
	jmFile.add(jmiSave);
	jmFile.add(jmiExit);
	jmb.add(jmFile);
	jmiOpen.addActionListener(this);
	jmiClose.addActionListener(this);
	jmiSave.addActionListener(this);
	jmiExit.addActionListener(this);
	jfrm.add(jlab);
	jfrm.setJMenuBar(jmb);
	jfrm.setVisible(true);
	JPopupMenu jpu = new JPopupMenu();
	JMenuItem jmiCut = new JMenuItem("Cut");
	JMenuItem jmiCopy = new JMenuItem("Copy");
	JMenuItem jmiPaste = new JMenuItem("Paste");
	jpu.add(jmiCut);
	jpu.add(jmiCopy);
	jpu.add(jmiPaste);
	jfrm.addMouseListener(new MouseAdapter(){
		public void MousePressed(MouseEvent me)
		{
			if(me.isPopupTrigger())
				{
				jpu.setVisible(true);
				jpu.show(me.getComponent(), me.getX(),me.getY());
				}
		}
		public void MouseReleased(MouseEvent me)
		{
			if(me.isPopupTrigger())
				{ jpu.setVisible(true);
				jpu.show(me.getComponent(),me.getX(),me.getY());
				}
		}
	});
	jmiCut.addActionListener(this);
	jmiCopy.addActionListener(this);
	jmiPaste.addActionListener(this);
	
}
public static void main(String[] args)
{
	new MenuDemo();
}
}
