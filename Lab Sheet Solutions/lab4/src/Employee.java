/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ighosh
 */
abstract class Employee
{
String name;
int number;
String getName()
{
    return this.name;

}
int getNumber()
{
    return this.number;
}
@Override
public String toString()
{
    return(this.name+" "+Integer.toString(this.number));
}
abstract double computePay();
}
