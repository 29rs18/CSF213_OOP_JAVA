package multi;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

class Data {
	
	private int result;
	private boolean pChance;
	private boolean mChance;
	private Object lock;
	private int nop;
	
	public Data(){ // 8 Marks
		Scanner scan;
		try{
			 scan= new Scanner(new FileInputStream("input.txt"));
				result = Integer.parseInt(scan.nextLine());
				pChance = Boolean.parseBoolean(scan.nextLine());
				mChance = Boolean.parseBoolean(scan.nextLine());
				nop = Integer.parseInt(scan.nextLine());
				lock = new Object();
			scan.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public int getResult() {
		return result;
	}

	public void setResult(int value) {
		this.result = value;
	}

	public boolean isPChance() {
		return pChance;
	}

	public void setPChance(boolean pChance) {
		this.pChance = pChance;
	}

	public boolean isMChance() {
		return mChance;
	}

	public void setMChance(boolean mChance) {
		this.mChance = mChance;
	}

	public Object getLock() {
		return lock;
	}

	public int getNoP() {
		return nop;
	}	
}

class Monitor implements Runnable {

	private Data d;
	private int tails = 0;
	private int heads = 0;
	
	public Monitor(Data d){
		this.d = d;
	}
	
	public void run() {
		int i;
	//	PrintWriter outStream;
		Object obj = d.getLock();
		//System.out.println(d.getNoP());
		
		for( i = 0;i<d.getNoP();i++)		
		{ System.out.println(i);
		try {
		synchronized(obj)
		{		
		while(!d.isMChance())
		{
			System.out.println("monitor waiting.");
			obj.wait();		
			System.out.println("monitor_notified.");
		}
			System.out.println("monitor is going to read value ..." + d.getResult());
			if(d.getResult() == 0)
				{
				tails++; 
				}
			else 
				{
				heads++;	
				}
		
		d.setMChance(false);
		d.setPChance(true);
		obj.notifyAll();
		}
		}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}


class Player implements Runnable{
	private Data d;
	Random rand = new Random();
	
	public Player(Data d) {
		this.d = d;
	}
	
	public void run() {
		
		Object obj = d.getLock();
		try{
		synchronized(obj)
		{
				while(!d.isPChance())
			{	
					System.out.println("Player waiting.");
				obj.wait();
				System.out.println("player notified");
			}
				d.setResult(rand.nextInt(2));
				System.out.println("player is going to write value :" + d.getResult());
				d.setMChance(true);
				d.setPChance(false);
				obj.notifyAll();
		}
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	
} //end of run method		
}

class Lab10 {
	
	public static void main(String[] args){
		
		Data data = new Data();
		Thread[] players;
		Thread monitor;
		Monitor r1 = new Monitor(data);
		Player r2 = new Player(data);
		monitor = new Thread(r1);
		players = new Thread[data.getNoP()];
		for(int i = 0;i<data.getNoP();i++)
		{
			players[i] = new Thread(r2);
			players[i].start();
		}
		monitor.start();
		try
		{
			monitor.join();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Q.4(a) - 7 Marks
		
		//Q.4(b) - 3 Marks
	}
}
