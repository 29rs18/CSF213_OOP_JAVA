

import java.util.ArrayList;
import java.util.Random;

class TailoringShopSolution {

    public static void main(String[] args) {
        
        //Creates a new table called table to put data into
        Table table = new Table();
        
        //Creates a supplier to control all of the threads
        Supplier supplier = new Supplier(table);
		
		//Starts the supplier thread
        supplier.start();

        //Creates 3 tailor thread
        for (int i = 0; i < 3; i++) {
			
        	//Inserts the variables into the tailor class
            Tailor tailorThread = new Tailor("Tailor " + Integer.toString(i+1), i, table, supplier);
			
            //Starts all of the tailor threads
            tailorThread.start();
        }
    }
}

class Tailor extends Thread {

	private Table table; 
    private String items;
    private int itemNumber;
    private Supplier supplier;

    public Tailor(String name, int newItem, Table newTable, Supplier newSupplier) {
		//Initializing all of the variables
    	setName(name);
    	itemNumber = newItem;
        this.table = newTable;
        supplier = newSupplier;
    }

    @Override
    public void run()
    { 
		//Run the job forever
        while(true)
        {
            //Gets the item from the table and puts it into items
            items = table.getTailorStuff(itemNumber);
          
            // if the table doesn't has an stuff and the table is not empty
            if (!table.hasStuff(items) && !table.isEmpty())
            {
        		//print out the thread with the missing item
        		System.out.println("------------------------------------------------------------------------------");
        		System.out.println("Hey I am " + getName() + " and i have the " + items + " allow me to execute.\n");
  				System.out.println("------------------------------------------------------------------------------");
                
  				try {
                
  					//tell the thread to perform job
                    stitchAndIronThePant();
					
                    // the thread tells the supplier to continue
                    supplier.wakeUpSupplier();
                
  				} catch (Exception e) {}
            }
        }
    } 

    /************************* WRITE CODE FOR THIS METHOD ************************/
    /** This method prints what each thread is doing when it matches up with the */ 
    /** supplier. 																 */
    /** 							WHAT IS MISSING HERE?						 */			 			
    /*****************************************************************************/
    public synchronized void stitchAndIronThePant() throws Exception {
		
    	System.out.println(getName() + " picks up the cloth");
        Thread.sleep(100);
        
        System.out.println(getName() + " picks up the scissor and needle");
        Thread.sleep(100);
        
        System.out.println(getName() + " weave the pant");
        Thread.sleep(100);
        
        System.out.println(getName() + " iron the pant");
        Thread.sleep(100);
        
        System.out.println(getName() + " job complete");
    }

}


class Supplier extends Thread {

	private Table Table;

    public Supplier(Table newTable) { Table = newTable; }

    @Override
    public void run() 
    {
        while(true)
        {
            //Let the supplier sleep for 5 seconds - Just for simulation purpose
        	try {
                Thread.sleep(5000);
            } catch (Exception e) {}
            
        	//You have to write code for the method getTwoRandomStuffs() in the Table class
            Table.getTwoRandomStuffs();  
            
            // This tells the tailor threads to look at the table. prints the what stuff the supplier has
            System.out.println("\n Do You Want to Stich and Iron Your Pants\n At Present I Only Have " + Table.getSupplierStuff());
            
            // Makes the supplier wait while one tailor thread is running
            waitForTailor();
        }
    }

    /************************* WRITE CODE FOR THIS METHOD ************************/
    public synchronized void wakeUpSupplier() { 
    	try { 
    		notify(); 
    	} catch(Exception e){} 
    }
	
    /************************* WRITE CODE FOR THIS METHOD ************************/
    public synchronized void waitForTailor() { 
    	try { 
    		this.wait(); 
    	} catch (Exception e) {} 
    }
}

class Table {

    //Variables for storing Stuffs (Cloth, Scissor, Needle)
    private ArrayList lstAllStuffs  = new ArrayList();
    private ArrayList lstSupplierStuff = new ArrayList();

    public Table()
    {
    	//adds stuffs
        lstAllStuffs.add("Cloth");
        lstAllStuffs.add("Scissor");
        lstAllStuffs.add("Needle");
    }
    
    /************************* WRITE CODE FOR THIS METHOD ************************/
    /**       The method gets two random stuff from the list lstAllStuffs		**/
    /*****************************************************************************/
    public void getTwoRandomStuffs() {			
       
    	Random random = new Random();
		
        // clears supplier array
        lstSupplierStuff.clear();
	
        //copies what in the array list to another 
        ArrayList copyAllElements = (ArrayList) lstAllStuffs.clone();

        //picks an item and adds it to the supplier stuffs
        int supplierStuff1 = random.nextInt(lstAllStuffs.size());
        
        lstSupplierStuff.add(copyAllElements.get(supplierStuff1));

        copyAllElements.remove(supplierStuff1);
	
        //picks an item and adds it to the supplier stuffs        
        int supplierStuff2 = random.nextInt(copyAllElements.size());
        
        lstSupplierStuff.add(copyAllElements.get(supplierStuff2));
    }

    /************************* WRITE CODE FOR THIS METHOD ************************/
    /**       		Gets the stuffs and notifies the other threads				**/
    /*****************************************************************************/
    public synchronized String getSupplierStuff() {
        notifyAll();
        return lstSupplierStuff.toString();
    }
    
    /************************* WRITE CODE FOR THIS METHOD ************************/
    /**       	Gets the stuff and pairs it with the correct thread				**/
    /*****************************************************************************/
    public synchronized String getTailorStuff(int x) {
        
    	try { 
            this.wait();
        } catch (Exception e) {}
        
        return (String) lstAllStuffs.get(x);
    }
   	
    /************************* WRITE CODE FOR THIS METHOD ************************/
    /**       	Check if the tailor has the same items as the supplier			**/
    /*****************************************************************************/
    public boolean hasStuff(String itemName) { 
    	return (lstSupplierStuff.contains(itemName)); 
    }
    
    /************************* WRITE CODE FOR THIS METHOD ************************/
    /**       				Check if the table is empty							**/
    /*****************************************************************************/
    public boolean isEmpty() { 
    	return (lstSupplierStuff.size() == 0); 
    }
}
