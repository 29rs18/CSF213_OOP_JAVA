package practi;

import java.io.*;

public class pract2 {
	public static void main(String[] args) throws IOException
	{
		int arr[] = new int[10];
		int i;
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br= new BufferedReader(isr);
		for(i=0;i<10;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
			System.out.println((i+1)+" = "+ arr[i]);
						
			
		}

	}
	
}
