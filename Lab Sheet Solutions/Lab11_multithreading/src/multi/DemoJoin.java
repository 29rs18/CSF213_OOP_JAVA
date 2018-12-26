package multi;

class NewThread implements Runnable {
String name;
Thread t;
NewThread(String threadname)
{
	name = threadname;
	t = new Thread(this,name);
	System.out.println("New Thread: "+t);
}
@Override
public void run() {
	// TODO Auto-generated method stub
	try
	{
		for(int i = 5;i>0;i--)
		{
			System.out.println(name+": "+i);
			Thread.sleep(1000);
		}
	}
	catch(InterruptedException e)
	{
		System.out.println(name+" interrupted.");
	}
	System.out.println(name + " exiting. ");
	
}
}
class DemoJoin
{
	public static void main(String[] args)
	{
		NewThread t1 = new NewThread("One");
		NewThread t2 = new NewThread("Two");
		NewThread t3 = new NewThread("Three");
		t1.t.start();
		t2.t.start();
		t3.t.start();
		System.out.println("Thread one is alive :" + t1.t.isAlive());
		System.out.println("Thread one is alive :" + t2.t.isAlive());
		System.out.println("Thread one is alive :" + t3.t.isAlive());
		try
		{
			t1.t.join();
			t2.t.join();
			t3.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread is interrupted!");			
		}
		System.out.println("Thread one is alive :" + t1.t.isAlive());
		System.out.println("Thread one is alive :" + t2.t.isAlive());
		System.out.println("Thread one is alive :" + t3.t.isAlive());
		System.out.println("MAin thread exiting. ");
		
	}
}
