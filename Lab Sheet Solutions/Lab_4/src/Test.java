import java.util.Scanner;


public class Test {
	public static Student readStudent() /*throws IOException*/
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Name");
		Name name = new Name(sc.nextLine());		
		
		System.out.println("Enter Student age");
		int age = sc.nextInt();
		Student x = new Student(name,age);
		sc.close();
		return x;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter details of 1 students");
		
		for(int i = 0 ; i < 1 ; i++)
		{
			
			StudentList.addStudent(readStudent());	
		}		
		Student[] arr1 ;
		arr1 = StudentList.getStudentsInRange(16, 20);
		Student[] arr2;
		arr2 = StudentList.getStudentsWithLastName("Sharma");
		Student[] arr3;
		arr3 = StudentList.getStudentsWithAge(20);
		
		for(int i = 0 ; i < arr2.length;i++)
			System.out.println(arr2[i].get_Name()+" ");
		for(int i = 0 ; i < arr3.length;i++)
			System.out.println(arr3[i].get_Name()+" ");
	
		for(int i = 0 ; i < arr1.length;i++)
			System.out.println(arr1[i].get_Name()+" ");}

}
