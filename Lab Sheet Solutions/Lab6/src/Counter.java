
class StaticOuter 
{
	String a= "Static outer string";
	static String b = "Static outer static string";
	void seeStaticInner()
	{
		//cannot find symbol
		//1. System.out.println(nonstatic);
		//nonstatic is not static to access like this!
		//2. System.out.println(StaticInner.nonstatic);
		System.out.println(new StaticInner().nonstatic);//OK
		System.out.println(StaticInner.s);//OK, s is static
	}
	public static void main(String[] args)
	{
		System.out.println(StaticInner.s);
		StaticOuter so = new StaticOuter();
		so.seeStaticInner();
	}
	static class StaticInner
	{
		String nonstatic = "Static Inner nonstatic string";
		static String s = "Static Inner static string";
		public static void main(String args[])
		{
		
			//System.out.println(nonstatic);
			System.out.println(s);
			System.out.println(b);
		}

	}
}
class SomeOther
{
	public static void main(String[] args)
	{
		System.out.println(StaticOuter.StaticInner.s);
	StaticOuter.StaticInner si = new StaticOuter.StaticInner();
	System.out.println(si.nonstatic);
//	System.out.println(si.s);
	}
}
