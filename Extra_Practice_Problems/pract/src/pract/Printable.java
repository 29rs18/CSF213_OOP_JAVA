package pract;

public class Printable{
	int data = 90;
/*private interface Showable
{
	void show();
}*/
static class ShowClass 
{
	static void show() {
		System.out.println("Within Show");}
}
public void print() {
//ShowClass s = new ShowClass();
//s.show();
System.out.println("Within Print"); 
}
 private class inwards
{
	 int prname;
	void print_data()
	{
		System.out.println(++data);
		print();
	}
	
}
inwards tt = new inwards();
tt.print_data();

} 
