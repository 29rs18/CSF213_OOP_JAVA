package studentlisting;
import java.util.*;
public class Test {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> s = new ArrayList<Student>();
		for(int i = 0;i<3 && i<2;i++)
		{
		Student x = new Student(sc.next(), sc.nextDouble());		
		s.add(x);
		}
		Collections.sort(s,new SortStudent());
	//	Iterator<Student> i = s.iterator();
		/*while(i.hasNext())
		{
			System.out.println(i.next());
			
		}*/
		for(int r = 0;r<3;r++)
		{
			System.out.println(s.get(r).toString());
		}
		sc.close();
		ArrayList c = new ArrayList();
		
		//System.out.println("Chekcer");
	}
}
