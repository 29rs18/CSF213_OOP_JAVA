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
public class Name {
private String fname; // First Name
private String mname; // Middle Name
private String lname; // Last Name
// provide accessor methods as per the given specification
// provide implementation for getName() method as per the given
// specification
Name(String name) {
    int x = name.indexOf(';');
    this.fname = name.substring(0, (x));
    this.mname = name.substring(name.indexOf(';')+1,name.indexOf(';', name.indexOf(';')+1));
    this.lname = name.substring(name.indexOf(';', name.indexOf(';')+1)+1);
    System.out.println(this.fname);
    System.out.println(this.mname);
    System.out.println(this.lname);   
/* Complete the constructor by extracting the values of three name
fields. Note that name value may be either comma separated or
semicolon separated */
// Write Your Code Here
//<editor-fold defaultstate="collapsed" desc="comment">
}
//</editor-fold>
public static void main(String[] args)
{
    Name x = new Name("Harry;James;Potter");
 
}
} // End of class Name.