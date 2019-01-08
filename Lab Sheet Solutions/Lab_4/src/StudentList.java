import java.util.StringTokenizer;


public class StudentList {
public static Student[] list = new Student[1];
public static int count = 0;
public static void addStudent(Student std)
{
	if (count>=20)
		return;
	list[count]  = std;
	count++;
}
public static Student[] getStudentsWithAge(int age)
{
	int j = 0,y = 0;;
	for(int i =0 ;i<list.length;i++)
	{
		if(list[i].get_age() == age )
		{
			y++;
		}
	}
	Student[] valid = new Student[count];
	
	for(int i =0 ;i<list.length;i++)
	{
		if(list[i].get_age() == age )
		{
			valid[j] = list[i];
			j++;
		}
	}
	return valid;
}
public static Student[] getStudentsWithLastName(String lastName)
{
	int y = 0, j = 0;
	for(int i =0 ;i<list.length;i++)
	{
		StringTokenizer x = new StringTokenizer(list[i].get_Name());
		String f1 = x.nextToken();
		String m1 = x.nextToken();
		String l1 = x.nextToken();
		if(l1.equals(lastName))
		{
			y++;
		}
	}
	Student[] valid = new Student[y];
	
	for(int i =0 ;i<list.length;i++)
	{
		StringTokenizer x = new StringTokenizer(list[i].get_Name());
		String f1 = x.nextToken();
		String m1 = x.nextToken();
		String l1 = x.nextToken();
		if(l1.equals(lastName))
		{
			valid[j] = list[i];
			j++;
		}
	}
	return valid;
}
public static Student[] getStudentsInRange(int minAge,int maxAge)
{
	int j = 0;
	int y = 0;
	System.out.print(list.length);
	for(int i =0 ;i<list.length;i++)
	{
		if((list[i].get_age() >= minAge) && (list[i].get_age() <= maxAge))
		{
		y++;
		}
	}
	Student[] valid = new Student[y];
	
	for(int i =0 ;i<list.length;i++)
	{
		if(list[i].get_age() >= minAge && list[i].get_age() <= maxAge)
		{
			valid[j] = list[i];
			j++;
		}
	}
	return valid;
}
}
