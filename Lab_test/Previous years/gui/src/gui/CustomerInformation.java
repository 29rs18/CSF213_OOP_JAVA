package gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;

public class CustomerInformation {
JFrame f;
JPanel p1,p2,p3;
JTabbedPane tp;
JLabel idlabel1, namelabel1,emaillabel1,countrylabel1,genderlabel1,
deletelabel1,idlabel2,namelabel2,emaillabel2,countrylabel2,genderlabel2;
JTextField name1,email1,gender1,delete_id,name2,email2,gender2,id2;
JButton savebtn,resetbtn,editbtn1,editbtn2,deletebtn;
JComboBox country1,country2;

CustomerInformation()
{
	f = new JFrame("Customer Form");
	p1 = new JPanel(new GridLayout(5,2));
	p2 = new JPanel(new GridLayout(6,2));
	p3 = new JPanel(new GridLayout(2,2));
	tp = new JTabbedPane();
	namelabel1 = new JLabel("Customer Name: ");
	emaillabel1 = new JLabel("Customer E-mail: ");
	countrylabel1 = new JLabel("Customer Country: ");
	genderlabel1 = new JLabel("Customer Gender: ");
	deletelabel1 = new JLabel("Enter Customer ID to delete record ");
	
	idlabel2 = new JLabel("Customer ID: ");
	namelabel2 = new JLabel("Customer Name: ");
	emaillabel2 = new JLabel("Customer E-mail: ");
	countrylabel2 = new JLabel("Customer Country: ");
	genderlabel2 = new JLabel("Customer Gender: ");
	name1 = new JTextField(12);
	email1 = new JTextField(12);
	gender1 = new JTextField(12);
	delete_id= new JTextField(12);
	name2 = new JTextField(12);
	email2 = new JTextField(12);
	gender2 = new JTextField(12);
	id2 = new JTextField(12);
	
	country1 = new JComboBox();
	country1.addItem("INDIA");
	country1.addItem("AMERICA");
	country1.addItem("AUSTRALIA");
	country1.addItem("PHILLIPINES");
	country1.addItem("SPAIN");
	
	country2 = new JComboBox();
	country2.addItem("INDIA");
	country2.addItem("AMERICA");
	country2.addItem("AUSTRALIA");
	country2.addItem("PHILLIPINES");
	country2.addItem("SPAIN");
	
	savebtn = new JButton(" Add ");
	resetbtn = new JButton(" Reset ");
	editbtn1 = new JButton("Edit");
	editbtn2 = new JButton("Save");
	deletebtn = new JButton("Delete");
	
	p1.add(namelabel1);
	p1.add(name1);
	p1.add(emaillabel1);
	p1.add(email1);	
	p1.add(countrylabel1);
	p1.add(country1);
	p1.add(genderlabel1);
	p1.add(gender1);
	p1.add(savebtn);
	p1.add(resetbtn);
	
	p2.add(idlabel2);
	p2.add(id2);
	p2.add(namelabel2);
	p2.add(name2);
	p2.add(emaillabel2);
	p2.add(email2);	
	p2.add(countrylabel2);
	p2.add(country2);
	p2.add(genderlabel2);
	p2.add(gender2);
	p2.add(editbtn1);
	p2.add(editbtn2);
	p3.add(deletelabel1);
	p3.add(delete_id);
	p3.add(deletebtn);
	
	f.getContentPane().add(tp);
	tp.add("Add Record",p1);
	tp.add("Edit Record",p2);
	tp.add("Delete Record",p3);
	f.setSize(400, 200);
	f.setVisible(true);
	f.setResizable(true);
	//tp.addTab(arg0, arg1);
//	try{
//		createDatabase();		
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//	}
	resetbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		name1.setText("");
		email1.setText("");
		country1.setSelectedIndex(0);
		gender1.setText("");
		}
	});
	savebtn.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String value1= name1.getText();
					String value2 = email1.getText();
					String value3 = (String) country1.getSelectedItem();
					String value4 = gender1.getText();
					try
					{
						Connection con = getConnection();
						int customerid = getCustomerID(con);
						PreparedStatement st = con.prepareStatement("insert into CUSTOMER_INFO(CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_EMAIL,CUSTOMER_COUNTRY,CUSTOMER_GENDER) "
								+ "values(?,?,?,?,?)");
						st.setInt(1, customerid);
						st.setString(2, value1);
						st.setString(3, value2);
						st.setString(4, value3);
						st.setString(5, value4);
						st.executeUpdate();
						JOptionPane.showMessageDialog(p1, "Data is inserted successfully into dbs");
						BufferedReader br = new BufferedReader(new FileInputStream());
						//br.read
						
										
				}
					catch(ClassNotFoundException e1)
					{
						JOptionPane.showMessageDialog(p1, "error in submitting data");
					}
					catch(SQLException e1)
					{
						Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null,e1);
					}
						
					}
		
			});
	editbtn2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		int x = JOptionPane.showConfirmDialog(p2, "Confirm edit data will be replaced")	;
		if(x==0)
		{
			try
			{
				int value1 = Integer.parseInt(id2.getText());
				String value2 = name2.getText();
				String value3  =email2.getText();
				String value4 = (String) country2.getSelectedItem();
				String value5 = gender2.getText();
				Connection con = getConnection();
				Statement st = con.createStatement();
				st.executeUpdate("update CUSTOMER_INFO set CUSTOMER_NAME='"+value2+
				"',CUSTOMER_EMAIL='"+value3+",CUSTOMER_COUNTRY='"+value4+"CUSTOMER_GENDER='"+value5+"'" + "where CUSTOMER_ID="+ value1+"");
				JOptionPane.showMessageDialog(p2,"updated successfully" );
				con.close();
			}
			catch(SQLException ex)
			{
				Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(p2, "error in updating data");
			}
		}
		}		
	});	
	deletebtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	try
	{
		Connection con = getConnection();
		int x = Integer.parseInt(delete_id.getText());
		//String query = ;
		Statement st  = con.createStatement();
		st.executeUpdate("delete from CUSTOMER_INFO where CUSTOMER_ID = "+x+"");
		JOptionPane.showMessageDialog(p3, "Success");
	}
	catch(SQLException ex)
	{
		Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);				
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(p3, "error in deleting data");
	}

		}
		
	});
}
public void createDatabase() throws ClassNotFoundException,SQLException
{
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	Connection con = DriverManager.getConnection("jdbc:derby:cust;create=true;user=app;password=app");
	String createString = "create table CUSTOMER_INFO(CUSTOMER_ID INTEGER PRIMARY KEY,\r\n"+
	"CUSTOMER_NAME VARCHAR(20), \r\n"+"CUSTOMER_EMAIL VARCHAR(50),\r\n"+"CUSTOMER_COUNTRY VARCHAR(20),\r\n"+"CUSTOMER_GENDER VARCHAR(20))";
	Statement st = con.createStatement();
	st.executeUpdate(createString);
}
public Connection getConnection() throws ClassNotFoundException, SQLException
{
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	Connection con = DriverManager.getConnection("jdbc:derby:cust;create=true;user=app;password=app");

	return con;
	
}
private int getCustomerID(Connection con) throws SQLException
{
int value = 0 ;
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("Select max(CUSTOMER_ID) from CUSTOMER_INFO");
if(rs.next())
	value = rs.getInt(1);
return value+1;
}
public void closeConnection(Connection con) throws SQLException
{
	con.close();
}
public static void main(String[] args)
{
	new CustomerInformation();
}
}
