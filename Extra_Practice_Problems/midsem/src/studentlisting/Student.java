package studentlisting;

public class Student {
	String Name;
	double cgpa;
	public Student(String name, double cgpa)
	{
		this.Name = name;
		this.cgpa = cgpa;
	}
	public String toString()
	{
		return (this.Name+ " "+ Double.toString(this.cgpa));
	}

}
