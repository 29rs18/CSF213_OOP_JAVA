package gui;
import java.io.*;

public class calc {

	public static void main(String[] args) throws FileNotFoundException
	{
		
			PrintWriter outStream = null;
			try {
			outStream = new PrintWriter(new FileOutputStream("stuff.txt"));
			}
			catch(FileNotFoundException e)
			{
			System.err.println("Error opening the file stuff.txt.");
			System.exit(0);
			}
			outStream.println("The quick brown fox");
			outStream.println("jumped over the lazy dog.");
			outStream.close( );
	
}
}
