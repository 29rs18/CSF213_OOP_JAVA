/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ighosh
 */
public interface Outer {
  int data = 30;
void show();  
}
class test
{
    public static void main(String args[]) {
Outer o = new Outer() {
public void show() {
System.out.println("Data=:"+data);
//data =25; // Error
}
};
o.show();
}
}