
public class Student {
private Name name;
private int age;
Student(Name x, int age)
{
	this.name = x;
	this.age = age;
}
String get_Name()
{
	return name.getName();
}
int get_age()
{
	return this.age;
}
}
