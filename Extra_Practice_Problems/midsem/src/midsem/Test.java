package midsem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ighosh
 */
import java.util.*;
public class Test {
public static void main(String[] args)
{
    LinkedList<Salary> x = new LinkedList<Salary>();
    //Salary theta = new Salary();
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext())
    {
        Salary rec1 = new Salary(sc.nextDouble());
        rec1.name = sc.next();
        rec1.number = sc.nextInt();
        x.add(rec1);
    }
  //  Comparator<Salary> y = 
  Collections.sort(x, new Comparator<Salary>() {
		public int compare(Salary theta, Salary s2)
	    {
	    	if(theta.getSalary()>s2.getSalary())
	    		return -1;
	    
	    	else if (theta.getSalary()== s2.getSalary())
	    		return 0;
	    	else 
	    		return 1;
	    }
  }
	   );
  sc.close();
//y.sort(x,new y);
}
}
