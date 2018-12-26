package multi;
class Q
{
	int n;
	boolean valueSet = false ;
	synchronized int get()
	{
		while(!valueSet)
		{
			try
			{
				wait();
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("InterruptedException caught");
			}
		}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;		
	}
	synchronized int put(int n)
	{
		while(valueSet)
		{
			try
			{
				wait();
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("InterruptedException caught");
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put: "+n);
		notify();
		return n;		
	}
}

class Producer implements Runnable
{
	Q q;
	Thread t;
	Producer(Q q)
	{
		
		this.q = q;
		t = new Thread(this,"Producer");
	}
	public void run()
	{
		int i = 0;
		while(true)
		{
			q.put(i++);
		}
	}
}
class Consumer implements Runnable
{
	Q q;
	Thread t;
	Consumer(Q q)
	{
		this.q = q;
		t = new Thread(this, "Consumer");
	}
	public void run()
	{
		while(true)
		{
			q.get();
		}
	}
}
public class PCFixed {
public static void main(String[] args)
{
	Q q = new Q();
	Producer p = new Producer(q);
	Consumer c = new Consumer(q);
	p.t.start();
	c.t.start();
	System.out.println("Control C to stop");
	
}

}
