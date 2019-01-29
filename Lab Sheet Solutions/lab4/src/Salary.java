/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ighosh
 */
public class Salary extends Employee {
   private double salary;

    /**
     *
     * @param sal
     */
    public Salary(double sal)
   {
       this.salary = sal;
   }

    Salary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
   double computePay()
    {
        return this.salary/52;//weekly fees given yearly
    }
    void setSalary(double salary)
    {
        this.salary = salary;
    }
    double getSalary()
    {
        return this.salary;
    }
    
}
