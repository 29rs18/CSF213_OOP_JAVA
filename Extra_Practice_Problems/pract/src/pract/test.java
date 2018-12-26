package pract;

import pract.Printable.ShowClass;
import pract.Printable.inwards;

public class test {
public static void main(String[] args)
{
	Printable pt = new Printable();
	pt.print();
	//ShowClass st = pt.new ShowClass();
	System.out.println("Next");
	ShowClass.show();
	inwards ins  =pt.new inwards();
	ins.print_data();
	char[] arr = {'a','b','c','d','e','x','y','z'};
	String x= new String(arr);
	System.out.println(x);
	
	for(int i = 0 ;i<arr.length-2;i++)
		{
		String y  = new String(arr,i,arr.length - i);
		System.out.println(y);
			
		}
}

}
