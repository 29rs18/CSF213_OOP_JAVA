package midsem;
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
