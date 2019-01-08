package practi;
import java.io.*;
import java.util.*;
public class read 
{
	public static void main(String[] args)throws IOException{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("enter our first name :");
		String name= br.readLine();
		System.out.println("your name is "+name);
		
				
	}
}
