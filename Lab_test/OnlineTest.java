 import java.awt.*; 
 import java.awt.event.*;
 import java.sql.Connection;
 import java.sql.*;
 import java.util.*;
 import java.util.logging.*;
 import javax.swing.*;

 class P2016B1A70938 {

 	private JFrame mainFrame;
 	private JPanel panel1, panel2;
 	private JTabbedPane tabPane;
 	private JLabel lbl_name, lbl_ID, lbl_Name, lbl_ItemName, lbl_Qty, lbl_BillAmt;
 	private JTextField txtField1_Name, txtField2_Name, txtField_Qty, txtxField_BillAmt;
 	private JComboBox<Integer> txtField_ID;
 	private JComboBox<String> txtField_Item;
 	private JButton savebtn, resetbtn, addbtn, proceedbtn ;

 	public static void main(String args[]) {
 		P2016B1A70938 pro = new OnlineTestSolution();
 		pro.displayAppGUI();
 	}

 	OnlineTestSolution() {
 /*************************************************************************************
***********
* DONOT DELETE/MODIFY THE FOLLOWING CODE
 * After you run the application for the first time comment the following lines of
code
 * This method should be called only one time when the application is executed for the first time

**********************************************************************************************
**/
try {
	createDatabase();
} catch (ClassNotFoundException | SQLException e2) {
	e2.printStackTrace();
}
/*************************************************************************************
***********
 * UNCOMMENT THE FOLLOWING CODE TO DELETE ALL THE RECORDS FROM ANYONE OR ALL THE
TABLES

**********************************************************************************************
**/
try {
	deleteAllRecordsFromTable("PURCHASE");
	deleteAllRecordsFromTable("ITEM");
	deleteAllRecordsFromTable("CUSTOMER");
} catch (ClassNotFoundException e1) {
	e1.printStackTrace();
} catch (SQLException e1) {
	e1.printStackTrace();
} /*************************************************************************************
***********
 * DONOT DELETE/MODIFY THE FOLLOWING CODE
 * After you run the application for the first time comment the following lines of
code
 * This method should be called only one time when the application is executed for the
first time

**********************************************************************************************
**/
try {
	insertItemInItemTable();
} catch (Exception e1) {
	e1.printStackTrace();
}
 /*************************************************************************************
***********
 * DONOT DELETE/MODIFY THE FOLLOWING CODE
 * Function calls to initialize all the GUI components and to populate the drop down
boxes.
 * You have to write code for these method. Unimplemented method stubs are provided
below:
 * refer Q. 1 and Q. 6

**********************************************************************************************
**/
 initializeAppGUI(); // function call
 populate_txtField_ID_And_txtField_Item(); //function call
/*****************************************************************************************
*******
 * Q.7 WRITE CODE FOR THE ACTION LISTNER OF THE resetbtn - this should reset the
txtField1
**********************************************************************************************
**/
resetbtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		txtField1_Name.setText("");
	}
});

 /*************************************************************************************
***********
* Q.8 WRITE CODE FOR THE ACTION LISTNER OF THE savebtn - this event should
automatically generates the customer id using the getCustomerID() and inserts the customer id and name into the CUSTOMER table.
**********************************************************************************************
**/
savebtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		Connection con;
		PreparedStatement st;

 int customerid; // used to store the customer id
 String value1; //used to store the customer name

 try {

 	con = getConnection();
 	customerid = getCustomerID(con);
 	value1 = txtField1_Name.getText();

 	st=con.prepareStatement("insert into CUSTOMER(CID,NAME) values(?,?)");
 	st.setInt(1, customerid);
 	st.setString(2, value1);
 	st.executeUpdate();

 	txtField_ID.addItem(customerid);

 	JOptionPane.showMessageDialog(panel1,"Data is successfully inserted into database.");

 } catch(ClassNotFoundException e){
 	JOptionPane.showMessageDialog(panel1,"Error in submitting data!");
 } catch (SQLException ex) {
 	Logger.getLogger(OnlineTestSolution.class.getName()).log(Level.SEVERE,null, ex);
 }
}
});

/*****************************************************************************************
********
* Q.9 WRITE CODE FOR THE ITEM LISTNER OF THE txtField_ID - this event is used to
retrieve the customer name from the CUSTOMER table, when the customer id is chosen from the drop down box. It
should then display name  in the txtField2_Name text box.

**********************************************************************************************
**/
txtField_ID.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent ie) {
		Connection con;
		PreparedStatement st;
		ResultSet res;
int value; //used to store the selected customer id
try {
	con = getConnection();
	value=Integer.parseInt(txtField_ID.getSelectedItem().toString());

	st=con.prepareStatement("select NAME from CUSTOMER where CID=?");
	st.setInt(1,value);
	res=st.executeQuery();
	res.next();
	txtField2_Name.setText(res.getString(1));

} catch (Exception e) {
	e.printStackTrace();
}
}
});
/*****************************************************************************************
*******
 * Q.10 WRITE CODE FOR THE ACTION LISTNER OF THE addbtn - The record from the ITEM
table is retrieved
 * for the item chosen from the drop down list. If required quantity is available in
the ITEM table,
* a record is inserted into the PURCHASE table (customer id, item id, quantity,
price) and the quantity field in the ITEM table is updated. Else, an error message is thrown. Then clear
all the fields for adding the next item.
**********************************************************************************************
**/
addbtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		Connection con;
		PreparedStatement st;
		ResultSet res;
String value1; //used to store selected item name
 Integer value2; //used to store the quantity
 int iid; //used to store the item id

 try {
 	con = getConnection();
 	value1 = (String) txtField_Item.getSelectedItem();
 	value2 = Integer.parseInt(txtField_Qty.getText());
 	st = con.prepareStatement("select * from ITEM where NAME=?");
 	st.setString(1, value1);
 	res = st.executeQuery();
 	res.next();
 	iid = res.getInt(1);

 	if(value2 <= res.getInt(3)) {
 		st = con.prepareStatement("update ITEM set QTY=? where IID=?");
 		st.setInt(1, (res.getInt(3) - value2));
 		st.setInt(2, iid);
 		st.executeUpdate();
 		st = con.prepareStatement("insert into PURCHASE(CID,IID,QTY,PRICE) values(?,?,?,?)");
 		st.setInt(1, Integer.parseInt(txtField_ID.getSelectedItem().toString()));
 		st.setInt(2, iid);
 		st.setInt(3, value2);
 		st.setFloat(4, res.getFloat(4));
 		st.executeUpdate();

 		JOptionPane.showMessageDialog(panel2,"Item is successfully added to cart!");

 	} else {
 		JOptionPane.showMessageDialog(panel2,"Required Quantity Not Available!");
 	}
 } catch (Exception e) {
 	e.printStackTrace();
 }
 txtField_Qty.setText("");
 txtField_Item.setSelectedIndex(0);
}
});

/*****************************************************************************************
*******
 * Q.11 WRITE CODE FOR THE ACTION LISTNER OF THE proceedbtn - All records pertaining
to a customer is retrieved from the PURCHASE table, the total bill amount is computed for all the
items purchased
 * by a customer.

**********************************************************************************************
**/
proceedbtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		Connection con;
		PreparedStatement st;
		ResultSet res;

 int value; //used to store customer id
float bill = 0; //used to store the bill amount
try {
	con = getConnection();
	value = Integer.parseInt(txtField_ID.getSelectedItem().toString());

	st = con.prepareStatement("select * from PURCHASE where CID=?");
	st.setInt(1, value);
	res = st.executeQuery();

	while (res.next()) {
		bill = bill + (res.getInt(3) * res.getFloat(4));
	}
	txtxField_BillAmt.setText(bill+"");
} catch (Exception e) {
	e.printStackTrace();
}
}
});

}
/*****************************************************************************************
*******
* Q.6 WRITE CODE FOR THIS METHOD TO POPULATE txtField_ID and txtField_Item from the
CUSTOMER and
 * ITEM tables.
**********************************************************************************************
**/
public void populate_txtField_ID_And_txtField_Item() {
	Connection con;
	Statement statement1, statement2;
	ResultSet rs1, rs2;
	String query1, query2;

	try {

		con = getConnection();
		statement1 = con.createStatement();
		statement2 = con.createStatement();
		query1 = "SELECT * FROM CUSTOMER";
		query2 = "SELECT * FROM ITEM";
		rs1 = statement1.executeQuery(query1);
		rs2 = statement2.executeQuery(query2);

		while (rs1.next()) { txtField_ID.addItem(rs1.getInt(1)); }
		while (rs2.next()) { txtField_Item.addItem(rs2.getString(2)); }


	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}/*****************************************************************************************
*******
296 * Q.1 WRITE CODE FOR THIS METHOD TO INITIALIZE APP GUI
297 * 0.5 M for each statement
298
**********************************************************************************************
**/
public void initializeAppGUI(){

	mainFrame = new JFrame("Online purchase");
 panel1 = new JPanel(new FlowLayout()); //Any layout can be used
 panel2 = new JPanel(new FlowLayout()); //Any layout can be used
 tabPane = new JTabbedPane();
 lbl_name = new JLabel("Customer Name:");
 txtField1_Name = new JTextField(12);
 savebtn = new JButton("Add");
 resetbtn = new JButton("Reset");
 panel1.add(lbl_name);
 panel1.add(txtField1_Name);
 panel1.add(savebtn);
 panel1.add(resetbtn);

 lbl_ID = new JLabel("Customer ID:");
 txtField_ID = new JComboBox<Integer>();
 txtField_ID.addItem(null);
 lbl_Name = new JLabel("Customer Name:");
 txtField2_Name = new JTextField(13);

 lbl_ItemName = new JLabel("Item Name:");
 txtField_Item = new JComboBox<String>();
 txtField_Item.addItem("Choose the Item");
 lbl_Qty = new JLabel("Quantity:");
 txtField_Qty = new JTextField(13);
 lbl_BillAmt = new JLabel("Bill Amount:");
 txtxField_BillAmt = new JTextField(13);
 panel2.add(lbl_ID);
 panel2.add(txtField_ID);
 panel2.add(lbl_Name);
 panel2.add(txtField2_Name);
 panel2.add(lbl_ItemName);
 panel2.add(txtField_Item);
 panel2.add(lbl_Qty);
 panel2.add(txtField_Qty);
 panel2.add(lbl_BillAmt);
 panel2.add(txtxField_BillAmt);

 addbtn = new JButton(" Add Item ");
 proceedbtn = new JButton(" Check out ");

 panel2.add(addbtn);
 panel2.add(proceedbtn);
}
/*****************************************************************************************
*******
 * Q.2 WRITE CODE FOR THIS METHOD TO DISPLAY APP GUI
 * (0/2 M)

**********************************************************************************************
**/
public void displayAppGUI() {
	mainFrame.getContentPane().add(tabPane);
	tabPane.addTab("New Customer",panel1);
	tabPane.addTab("Existing Customer",panel2);
	mainFrame.setSize(400,200);
	mainFrame.setVisible(true);
	mainFrame.setResizable(true);
}/*****************************************************************************************
*******
 * Q.3 WRITE CODE FOR THIS METHOD TO GET DATABASE CONNECTION
 * (0/1 M)

**********************************************************************************************
**/
public Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	Connection con = DriverManager.getConnection("jdbc:derby:cust;create=true;user=app;password=app");
	return con;
} /*****************************************************************************************
*******
 * Q.4 WRITE CODE FOR THIS METHOD TO CREATE CUSTOMER, ITEM, AND PURCHASE TABLES
 * TABLE : CUSTOMER, ATTRIBUTES - CID (int), NAME (var char) (Customer id and customer
name)
 * TABLE: ITEM, ATTRIBUTES - IID (int), NAME (var char), QTY (int), PRICE (float) (Item
id, item name, quantity and price)
 * TABLE: PURCHASE, ATTRIBUTES - CID (int), IID (int), QTY (int), PRICE (float) (Customer
id, item id, quantity, and price)
**********************************************************************************************
**/
public void createDatabase() throws ClassNotFoundException, SQLException {
	Connection con = getConnection();
	Statement stmt = con.createStatement();

	String createCustomer = "create table CUSTOMER(CID INTEGER PRIMARY KEY, NAME VARCHAR(20))";
	stmt.executeUpdate(createCustomer);

	String createItem = "create table ITEM(IID INTEGER PRIMARY KEY, NAME VARCHAR(20), QTY INTEGER, PRICE FLOAT)";
	stmt.executeUpdate(createItem);

	String createPurchase = "create table PURCHASE(CID INTEGER, IID INTEGER, QTY INTEGER, PRICE FLOAT)";
	stmt.executeUpdate(createPurchase);

}
 /*****************************************************************************************
*******
 * Q.5 WRITE CODE FOR THIS METHOD TO INSERT FEW ITEMS IN THE ITEM TABLE
 * (Any three items can be inserted)
 * (0/1.5 M)

**********************************************************************************************
**/
public void insertItemInItemTable() {

	String query;
	Connection con;
	Statement stmt;

	try {

		con = getConnection();
		stmt = con.createStatement();
		query = "INSERT INTO ITEM VALUES (1, 'Mobile', 10, 9999)";
		stmt.executeUpdate(query);
		query = "INSERT INTO ITEM VALUES (2, 'Chocolates', 5, 10.50)";
		stmt.executeUpdate(query);
		query = "INSERT INTO ITEM VALUES (3, 'Notebooks', 15, 33)";
		stmt.executeUpdate(query);

	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}

public int getCustomerID(Connection con) {
	int value = 0;
	ResultSet rs;
	Statement stmt;

	try {
		stmt = con.createStatement();
		rs = stmt.executeQuery("Select Max(CID) from CUSTOMER");
		rs.next();
		if(rs.getInt(1) == 0) value = 100;
		else value = rs.getInt(1) + 1;
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return value;
}

public void deleteAllRecordsFromTable(String tableName) throws ClassNotFoundException,
SQLException {
	String query;
	Connection con = getConnection();
	Statement stmt = con.createStatement();
	query = "DELETE FROM " + tableName;
	stmt.executeUpdate(query);
}
}