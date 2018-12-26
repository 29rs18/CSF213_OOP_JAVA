package midsem;

import java.util.HashSet;

public class tt {
public static <T extends Comparable<T>> T[] sorter (T[] a)
{
	int n = a.length;
	T temp ;
	for(int i = 0;i<n;i++)
	{

		for(int j= 0;j<n;j++)
		{
			if(a[i].compareTo(a[j])<0)
			{				temp = a[i];
			
			System.out.println("swapping" + a[i]+" "+a[j]);
			a[i]=a[j];
			a[j] = temp;
			}
		}
	}
	return a;
}
class x
{
	void m1()
	{
		String y = new String("Hermy");
		String z= null;
		z = y;
				System.out.println(z);

		
	}
}
class y extends x 
{
	void m1()
	{
		String x= "harry";
		System.out.println(x);

	}
	void m2()
	{
		String y = new String("Hermy");
		String z= null;
		z = y;
				System.out.println(z);

		
	}

}
public static void main(String[] args)
{
	x theta = new y();
	/*HashSet<Integer> hs = new HashSet<Integer>();
	String x = new String("Harry");
	String y = new String("Hermy");
	String z= null;
	z = y;
			System.out.println(z);
	z = x;
	System.out.println(z);
	
	Integer[] i = {22,18,43,55};
	i = sorter(i);
	for(int j:i)
	System.out.println(j);
*/}
}
