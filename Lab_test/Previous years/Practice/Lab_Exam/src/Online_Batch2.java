import java.util.*;

class Table {
	
	private int held_Value;	// Resource(s) currently on the table
	
	Table(int held_Value) {
		this.held_Value = held_Value;
	}
	
	/******************************************************************************
	 * STEP-8: WRITE CODE FOR THIS METHOD: This method is used to put resources on 
	 * the table
	 * 
	 * NOTE: You can modify the signature of the method without changing its name 
	 * visibility, and the parameters passed. 
	 ******************************************************************************/
	public synchronized void putResources(int value) {
			       if(value==3){

				System.out.println("Leader Putting the resources of type B & C");
		       }
		/* Specify condition */
		     else if(value==5){

				System.out.println("Leader Putting the resources of type A & C");
		     }
		/* Specify condition */
             else if(value==6){

				System.out.println("Leader Putting the resources of type A & B");
             }
	         held_Value=(held_Value+value)%7;
	         notifyAll();

		/* There is more to do here */
	}
	
	/******************************************************************************
	 * STEP-9: WRITE CODE FOR THIS METHOD: This method is used to get resources from  
	 * the table
	 * 
	 * NOTE: You can modify the signature of the method without changing its name 
	 * visibility, and the parameters passed. 
	 ******************************************************************************/
	public int getResources() {
		return this.held_Value;
	}
	
	/******************************************************************************
	 * STEP-10: WRITE CODE FOR THIS METHOD: This method is used to clear resources 
	 * from the table
	 * 
	 * NOTE: You can modify the signature of the method without changing its name 
	 * visibility, and the parameters passed. 
	 ******************************************************************************/
	public synchronized void clearResources() {
		System.out.println("Resources Cleared from Table");
		this.held_Value = 0;
		notifyAll();
		/* THERE IS MORE TO DO HERE */
	}
}

class Soldier extends Thread {
	private int 	held_Value;					// Resource(s) currently held by the soldier
	private int 	need_Value;					// Resource(s) needed by the soldier
	private Table 	table;						// Shared data 
	
	Soldier(String name, Table table,int held_Value) {
		super(name);							// initialize thread name
		this.table = table;						// initialize table
		this.held_Value = held_Value;			// initialize held_Value
		this.need_Value = 7 - this.held_Value;
		/* STEP-1: WRITE CODE TO INITIALIZE THE VARIABLE (need_Value) */		
	}	
	
	/* WRITE CODE FOR THIS METHOD */
	public void run() {
		while(true) {
			try {
				synchronized(this) {
					while(need_Value == table.getResources())
					/* STEP-2 (WRITE CODE): If the need is meet (SPECIFY CONDITION) */ {
						System.out.println("Soldier " + getName()+ " Entered for firing operation");
						int x = table.getResources();
												Thread.sleep(100);

						/* STEP-3 (WRITE CODE): It takes 100 milli seconds for the soldier to complete firing */
						System.out.println("Soldier " + getName() + " Completed firing Operation & Cleared Resources");
						table.clearResources();
						/* STEP-4 (WRITE CODE): THERE IS MORE TO DO HERE */ 
					
					
					}
				Thread.sleep(100);
					}
			}
			catch(InterruptedException e) { }
		}
	}
}

class Leader extends Thread {
	
	private Table table;
	
	Leader(String name, Table table) {
		super(name);
		this.table = table;
	}
	
	public void run() {
		while(true) {
			try {
				
				/* STEP-5 (WRITE CODE): wait while the resources have not been cleared by anyone */ 
				synchronized(table)
				{
					while(table.getResources()==0)
				{
				
				// After waiting 
				System.out.println("Leader Activated");
				// Random number generator
				Random r1 = new Random();
				// Generates a random number in the range 0-6
				int x = r1.nextInt(7);
				
				/* STEP-6 (WRITE CODE): Keep on generating random numbers in the range 0-6
				 * until it generates resources of the values 3, 5 , or 6
				 */
								
				while(!(x==3||x==5||x==6)){

                    x=r1.nextInt(7);
				}
				/* STEP-6 (WRITE CODE): Keep on generating random numbers in the range 0-6
				 * until it generates resources of the values 3, 5 , or 6
				 */

				System.out.println("Resource Generated " +x);
				table.putResources(x);

				}
					Thread.sleep(100);
				/* STEP-7: THERE IS MORE TO DO HERE */
					
			}
			}			catch(InterruptedException e) { }
		}
	}
}

class Online_Batch2 {
	public static void main(String args[]) {		
			Table t =new Table(0);
		Leader L1 = new Leader("L",t);
		Soldier ST1 = new Soldier("S1",t,4);
		Soldier ST2 = new Soldier("S2",t,2);
		Soldier ST3 = new Soldier("S3",t,1);
		
		ST1.start();
		ST2.start();
		ST3.start();
		L1.start();
	// STEP-11 (WRITE CODE): CREATE AN EMPTY TABLE
		// STEP-12 (WRITE CODE): CREATE L1 as Leader, and ST1, ST2, and ST3 as Soldier threads
		// STEP-13 (WRITE CODE): START ALL THE THREADS		
	}
}
	