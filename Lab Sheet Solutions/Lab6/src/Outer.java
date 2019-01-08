
public class Outer {

		Inner i1 = new Inner();
		private String s = "Outer string"; //Outer instance variable
		void getS(){
		System.out.println(s);
		}
		void getInnerS(){
		System.out.println(i1.s);
		}
		static class Inner{
		//Inner instance variable, uninitialized
		private String s = "Inner string";
		//Outer o = new Outer();
//		o.getInnnerS();
		void getS()
		{
			System.out.println(s);
		}
		void getOuterS(){
		System.out.println((this.s));
		}
		}
		public static void main(String[] args){
		Outer o = new Outer();
		//can also be new Outer().new Inner();
		Outer.Inner oi = (new Inner());
		o.getS();
		oi.getS();
		o.getInnerS();
		oi.getOuterS();
		}
}
