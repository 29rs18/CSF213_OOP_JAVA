import java.util.*;
class Table
{
private int held_Value;
Table(int held_Value)
{
this.held_Value = held_Value;
}
public synchronized void  putResources(int value) throws InterruptedException
{
if(value == 3)
System.out.println("Teacher Putting the resources of type B & C");
else
if(value == 5)
System.out.println("Teacher Putting the resources of type A & C");
else
if(value == 6)
System.out.println("Teacher Putting the resources of type A & B");
held_Value = value;
notifyAll();
wait();
}
public synchronized int  getResources() 
{
return held_Value;
}
public synchronized void clearResources()	throws InterruptedException
{
System.out.println("Resources Cleared from Table");
held_Value =0;
notifyAll();
wait();
}
}
class Student extends Thread
{
private int 	held_Value;
private int 	need_Value;
private Table 	table;
Student(String name, Table table,int held_Value)
{
super(name);
this.table = table;
this.held_Value = held_Value;
if(held_Value == 4 ) need_Value = 3;
else
if(held_Value == 2 ) need_Value = 5;
else need_Value = 6;
}
public void run()
{
	while(true)
	{
		try
		{
		synchronized(this)
		{
			
			if(table.getResources() == need_Value)
			{
			System.out.println("Student"+getName()+"Entered for drawing operation");
			int x = table.getResources();
			Thread.sleep(100);
			System.out.println("Student"+getName()+"Completed Drawing Operation & Cleared Resources");
			table.clearResources();
  			}
		}
		}
		catch(InterruptedException e) { }
	}
}
}
class Teacher extends Thread
{
private Table table;
Teacher(String name, Table table)
{
super(name);
this.table = table;
}
public void run()
{
	while(true)
	{
		try
		{
			while(table.getResources() !=0)
			wait();
			System.out.println("Teacher Activated");
			Random r1 = new Random();
			int x = r1.nextInt(7);
			while(x != 3 && x != 5 && x !=6 )
			x = r1.nextInt(7);
			System.out.println(x);
			table.putResources(x);
			System.out.println("Hello");
		}
		catch(InterruptedException e) { }
	}
}
}
class Test
{
public static void main(String args[])
{
Table tb = new Table(0);
Thread ST1 = new Student("S1",tb,4);
Thread ST2 = new Student("S2",tb,2);
Thread ST3 = new Student("S3",tb,1);
Thread T1  = new Teacher("T1",tb);
T1.start();
ST1.start();
ST2.start();
ST3.start();
}
}
	