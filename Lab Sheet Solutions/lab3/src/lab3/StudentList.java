/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author ighosh
 */
public class StudentList {
    //public student[] arr;
public student[] create_list()
{
    System.out.println("Enter the number of students");
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    public student arr[]= new student[x];
    return arr;
}
}
