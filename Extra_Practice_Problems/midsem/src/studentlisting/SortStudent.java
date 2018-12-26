package studentlisting;

import java.util.Comparator;

public class SortStudent implements Comparator<Student>{
	public int compare(Student s1,Student s2)
	{
		if(s1.cgpa == s2.cgpa)
		{
			if((s1.Name).compareTo(s2.Name) == 0)
				return 0;
			else if((s1.Name).compareTo(s2.Name) > 0)
			{
				return 1;
			}
			else 
				return -1;
		}
		else if(s1.cgpa>s2.cgpa){
			return 1;
		}
		else
			return -1;
	}

}
