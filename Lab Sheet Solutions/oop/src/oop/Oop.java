/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author ighosh
 */
public class Oop {



 public int is_prime(int x)
 {
     for(int i =2;i<=sqrt(x);i++)//Note the style in which for loop works
		{
                   
                              System.out.println("i value=" +(i));
                              System.out.println("xval = " +x);
                        if (x%i == 0)
                        {  
                            if(x==2 )
                            { 
                                System.out.println(" 2%2 = " +(x%10));
                            }
			
                            return 0;
                        }
		}
     return 1;
 }
public void generate(int n)
{
	int prime = 0;
	int x=2;
	
	while(prime < n)
	{
		if(is_prime(x) == 1)
                {
                    prime++;
                    System.out.println(x)
                 }
		x++;
	}
	x-=1;
	System.out.println(x);
}
public static void main(String[] args)
{
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the n value : ");
	int x = scan.nextInt();
	Oop y = new Oop();
	y.generate(x);
}
}

}
