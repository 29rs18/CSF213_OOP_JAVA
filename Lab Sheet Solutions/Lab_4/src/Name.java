import java.util.StringTokenizer;


public class Name {
private String fname,mname,lname;
Name(String name)
{
	StringTokenizer x = new StringTokenizer(name,",;");
	this.fname = x.nextToken();
	this.mname =x.nextToken();
	this.lname = x.nextToken();
}
String getName()
{
	return this.fname+" "+this.mname+" "+ this.lname;
}
String getfName()
{
	return this.fname;
}
String getmName()
{
	return this.mname;
}
String getlName()
{
	return this.lname;
}
}
