package practi;
import java.util.*;
public class item {
	private String itemName;
	private String itemidNo;
	private int itemQuantity;
	private double itemPrice;
	/*public void  item_mutator(String name, String id, int quant, double price)//accessor methods
	{
		this.itemName = name;
		this.itemidNo = id;
		this.itemQuantity = quant;
		this.itemPrice = price;
	}*/
	public void item_mut()
	{
		System.out.println("give input");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String id = sc.next();
		int quant = sc.nextInt();
		double price = sc.nextDouble();
		

		this.itemName = name;
		this.itemidNo = id;
		this.itemQuantity = quant;
		this.itemPrice = price;
		sc.close();
		//price = 500
	}
	/*public void item_mutator(String name, String id)//price=6500 quant=1
	{
		this.itemName = name;
		this.itemidNo = id;
		this.itemQuantity = 1;
		this.itemPrice = 500;
	}*/
	public String get_name()
	{
		return itemName;		
	}
	public String get_id()
	{
		return itemidNo;		
	}
	public int get_quant()
	{
		return itemQuantity;		
	}
	public double get_price()
	{
		return itemPrice;		
	}
public static  void main(String[] args)
{
	/*Scanner sc = new Scanner(System.in);
	String name = sc.next();
	String id = sc.next();
	int quant = sc.nextInt();
	double price = sc.nextDouble();*/
	 item x = new item();
	 x.item_mut();
	 System.out.println("name :"+ x.get_name() + "\n id: "+x.get_id());
	 System.out.println("Quantity:"+ x.get_quant() + "\t Price: "+x.get_price());
	//sc.close();
	
	
}
}
