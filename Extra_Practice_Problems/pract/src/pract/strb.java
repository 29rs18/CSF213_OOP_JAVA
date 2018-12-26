package pract;
import java.util.*;
public class strb {
public static void main(String args[])
{
	StringBuffer sb =  new StringBuffer(20);
	sb.append("wfeohlehgl");
	System.out.println(sb.capacity()+" "+sb.length());
	sb.delete(0,sb.length()-1);
	sb.append("Led Zep ");

	System.out.println(sb);
	sb.append("reversed");
	sb.reverse();
	System.out.println(sb);
	sb.setCharAt(sb.length()-1, '1');
	StringTokenizer st = new StringTokenizer("http://nalanda.bits-pilani.ac.in/pluginfile.php/48491/mod_resource/content/0/"
			+ "Lecture%2013%20-%20String%20Buffer%2CString%20Tokenizer%2CWrapper%20Classes.pdf","://%",false);
	
	String strl = "http://nalanda.bits-pilani.ac.in/pluginfile.php/48491/mod_resource/content/0/"
			+ "Lecture%2013%20-%20String%20Buffer%2CString%20Tokenizer%2CWrapper%20Classes.pdf";
	String[] strlist = strl.split("://%");
			System.out.println(strlist.length);
	strlist = strl.split("://|%|/|//");
	/*for(int i = 0;i<strlist.length;i++)
		System.out.println("#"+i+""+strlist[i]);
	*/System.out.println(strlist.length);
	System.out.println(st.countTokens()+"   "+st.getClass());		
	while(st.hasMoreTokens())
	{
		System.out.print(" " +st.nextToken());
	}
	
}
}
