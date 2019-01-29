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
import java.io.*;
public class Test {
public static void main(String[] args)
{
    LinkedList<Salary> x = new LinkedList<Salary> implements Comparable<Salary>()
   {
  
    /**
     *
     * @param s1
     * @return
     */
    public int compareTo(Salary s1)
                  {
                            if(getSalary() > s1.salary)
                            {
                                return -1;
                            }
                            else if(getSalary() == s1.salary)
                            {
                                return 0;
                            }
                            else
                                return 1;
                        }
   
   };
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext())
    {
        Salary rec1;
        rec1 = new Salary(sc.nextDouble());
        rec1.name = sc.next();
        rec1.number = sc.nextInt();
        x.add(rec1);
    }
  
Collections.sort(x);
}
}
//             public int compareTo(Salary s1)
//                        {
//                            if(getSalary() > s1.salary)
//                            {
//                                return -1;
//                            }
//                            else if(getSalary() == s1.salary)
//                            {
//                                return 0;
//                            }
//                            else
//                                return 1;
//                        }
//   