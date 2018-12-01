package coffee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Useroperation {
	public static Date time() {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		return time;
	}

	//
	public static User login() {
		User user = new User();
		Scanner S = new Scanner(System.in);
		System.out.println("please input your username");
		String username = S.nextLine();
		System.out.println("please input your password");
		String password = S.nextLine();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    String login = null;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select userid from users where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			re = pstmt.executeQuery();
		    while ( re.next()) {
		        login = re.getString("userid");
		    }

		    if(login != null) {
		    		pstmt = c.prepareStatement("select * from users where userid = ? ");
		    		pstmt.setString(1, login);
		    		re = pstmt.executeQuery();
		    		while (re.next()) {
		    		String firstname = re.getString("firstname");
		    		String lastname = re.getString("lastname");
		    		int type = re.getInt("type");
		    		
		    		user.setFirstName(firstname);
		    		user.setLastName(lastname);
		    		user.setUserid(login);
		    		user.setUsername(username);
		    		user.setUserpassword(password);
		    		user.setType(type);
		    		}
		    		pstmt = c.prepareStatement("insert into session values(?, ?, '000000')");
				pstmt.setString(1, login);
				pstmt.setString(2, time().toString());
				pstmt.execute();
//				
		    }
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	      finally {
	    	  	return user;

	      }

	}
	public static void sale() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in the product id you want to register a sale for");
		String productid = S.nextLine();
		System.out.println("please type in the discount, eg. 70 for 70%");
		int sale = S.nextInt();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("update products set sale = ?  where productid = ?");
			pstmt.setInt(1, sale);
			pstmt.setString(2, productid);;
			pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--------------------------");
		//		e.printStackTrace();
				
			} 
	    managerChoose();
	}
	public static void e_createCustomer() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in customer first name");
		String c_firstname = S.nextLine();
		System.out.println("please type in customer last name");
		String c_lastname = S.nextLine();
		System.out.println("please type in customer address");
		String address = S.nextLine();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    int customerid = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select customerid from customers order by customerid desc limit 1");
			re = pstmt.executeQuery();
			while(re.next()) {
				customerid = re.getInt("customerid");
			}
			pstmt = c.prepareStatement("insert into customers values(?, ?, ?, 0, 0, ?)");
			pstmt.setString(1, c_firstname);
			pstmt.setString(2, c_lastname);;
			pstmt.setString(3, address);
			pstmt.setInt(4, customerid+1);
			pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    employeeChoose();
	    
	}
	public static void m_createCustomer() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in customer first name");
		String c_firstname = S.nextLine();
		System.out.println("please type in customer last name");
		String c_lastname = S.nextLine();
		System.out.println("please type in customer address");
		String address = S.nextLine();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    int customerid = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select customerid from customers order by customerid desc limit 1");
			re = pstmt.executeQuery();
			while(re.next()) {
				customerid = re.getInt("customerid");
			}
			pstmt = c.prepareStatement("insert into customers values(?, ?, ?, 0, 0, ?)");
			pstmt.setString(1, c_firstname);
			pstmt.setString(2, c_lastname);;
			pstmt.setString(3, address);
			pstmt.setInt(4, customerid+1);
			pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    managerChoose();
	}
	public static void createEmployee() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in employee first name");
		String firstname = S.nextLine();
		System.out.println("please type in employee last name");
		String lastname = S.nextLine();
		System.out.println("please type in employee username");
		String username = S.nextLine();
		System.out.println("please type in employee password");
		String password = S.nextLine();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    int userid = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select userid from users order by userid desc limit 1");
			re = pstmt.executeQuery();
			while(re.next()) {
				userid = re.getInt("userid");
			}
			pstmt = c.prepareStatement("insert into users values(?, ?, ?, ?, ?, 0)");
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);;
			pstmt.setInt(3, userid+1);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    managerChoose();
	}
	public static void e_recordTransaction() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in product id");
		String productid = S.nextLine();
		System.out.println("please type in numbers to buy");
		int quantity = S.nextInt();
		System.out.println("please type in customer id");
		int customerid = S.nextInt();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    double tot_points = 0;
	    double ava_points = 0;
	    double price = 0;
	    int stock = 0;
	    int transactionid = 0;
	    int sale = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    		
	    		pstmt = c.prepareStatement("select transactionid from transaction order by transactionid desc limit 1");
			re = pstmt.executeQuery();
			while(re.next()) {
				transactionid = re.getInt("transactionid");
			}
	    		pstmt = c.prepareStatement("insert into transaction values(?, ?, ?, ?,?)");
	    		pstmt.setInt(1, transactionid + 1);
	    		pstmt.setInt(2, customerid);
	    		pstmt.setString(3, productid);
	    		pstmt.setInt(4, quantity);
			pstmt.setString(5, time().toString());
			pstmt.execute();
			pstmt = c.prepareStatement("select tot_points from customers where customerid = ?");
			pstmt.setInt(1, customerid);
			re = pstmt.executeQuery();
			while(re.next()) {
				tot_points = re.getDouble("tot_points");
			}
			pstmt = c.prepareStatement("select ava_points from customers where customerid = ?");
			pstmt.setInt(1, customerid);
			re = pstmt.executeQuery();
			while(re.next()) {
				ava_points = re.getDouble("ava_points");
			}
			pstmt = c.prepareStatement("select price from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				price = re.getDouble("price");
			}
			pstmt = c.prepareStatement("select stock from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				stock = re.getInt("stock");
			}
			pstmt = c.prepareStatement("select sale from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				sale = re.getInt("sale");
			}
			pstmt = c.prepareStatement("update customers set tot_points = ?, ava_points = ? where customerid = ?");
			pstmt.setDouble(1,  tot_points + quantity*price*sale*0.01);
			pstmt.setDouble(2,  ava_points + quantity*price*sale*0.01);
			pstmt.setInt(3, customerid);
			pstmt.execute();
			pstmt = c.prepareStatement("update products set stock = ? where productid = ?");
			pstmt.setInt(1, stock - quantity);
			pstmt.setString(2, productid);
			pstmt.execute();
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    checkReward(customerid);
	    employeeChoose();
	}
	public static void m_recordTransaction() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in product id");
		String productid = S.nextLine();
		System.out.println("please type in numbers to buy");
		int quantity = S.nextInt();
		System.out.println("please type in customer id");
		int customerid = S.nextInt();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    double tot_points = 0;
	    double ava_points = 0;
	    double price = 0;
	    int stock = 0;
	    int transactionid = 0;
	    int sale = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    		
	    		pstmt = c.prepareStatement("select transactionid from transaction order by transactionid desc limit 1");
			re = pstmt.executeQuery();
			while(re.next()) {
				transactionid = re.getInt("transactionid");
			}
	    		pstmt = c.prepareStatement("insert into transaction values(?, ?, ?, ?,?)");
	    		pstmt.setInt(1, transactionid + 1);
	    		pstmt.setInt(2, customerid);
	    		pstmt.setString(3, productid);
	    		pstmt.setInt(4, quantity);
			pstmt.setString(5, time().toString());
			pstmt.execute();
			pstmt = c.prepareStatement("select tot_points from customers where customerid = ?");
			pstmt.setInt(1, customerid);
			re = pstmt.executeQuery();
			while(re.next()) {
				tot_points = re.getDouble("tot_points");
			}
			pstmt = c.prepareStatement("select ava_points from customers where customerid = ?");
			pstmt.setInt(1, customerid);
			re = pstmt.executeQuery();
			while(re.next()) {
				ava_points = re.getDouble("ava_points");
			}
			pstmt = c.prepareStatement("select price from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				price = re.getDouble("price");
			}
			pstmt = c.prepareStatement("select stock from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				stock = re.getInt("stock");
			}
			pstmt = c.prepareStatement("select sale from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				sale = re.getInt("sale");
			}
			pstmt = c.prepareStatement("update customers set tot_points = ?, ava_points = ? where customerid = ?");
			pstmt.setDouble(1,  tot_points + quantity*price*sale*0.01);
			pstmt.setDouble(2,  ava_points + quantity*price*sale*0.01);
			pstmt.setInt(3, customerid);
			pstmt.execute();
			pstmt = c.prepareStatement("update products set stock = ? where productid = ?");
			pstmt.setInt(1, stock - quantity);
			pstmt.setString(2, productid);
			pstmt.execute();
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    checkReward(customerid);
	    managerChoose();
	}
	public static void createReward() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in the product id you want to register a reward");
		String productid = S.nextLine();
		System.out.println("please type in the points trade for reward");
		double reward_points = S.nextDouble();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("update products set reward = ? where productid = ?");
			pstmt.setDouble(1, reward_points);
			pstmt.setString(2, productid);
			pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	public static void checkReward(int customerid) {
		Scanner S = new Scanner(System.in);
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    double apoints = 0;
	    boolean boo = false;
	    String available = null;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select ava_points from customers where customerid = ?");
			pstmt.setInt(1, customerid);
			re = pstmt.executeQuery();
			while(re.next()) {
				apoints = re.getDouble("ava_points");
			}
			if (apoints >= 25) {
				System.out.println("want a free coffee for 25 points? 'y' for yes, 'n' for no");
				String choice = S.nextLine();
				if (choice.equals("y")) {
					pstmt = c.prepareStatement("update customers set ava_points = ? where customerid = ?");
					pstmt.setDouble(1, apoints - 25);
					pstmt.setInt(2, customerid);
					pstmt.execute();
				}
			}
			
			
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
	public static void inventory() {
		Scanner S = new Scanner(System.in);
		System.out.println("please type in product id");
		String productid = S.nextLine();
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    int inventory = 0;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pstmt = c.prepareStatement("select stock from products where productid = ?");
			pstmt.setString(1, productid);
			re = pstmt.executeQuery();
			while(re.next()) {
				inventory = re.getInt("stock");
			}
			System.out.println("inventory: " + inventory);
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    managerChoose();
	}
	public static void logout() {
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    String userid = null;
	    try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    try {
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/coffee",
				 "sanchuanjiang", "Jsc2211050");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			c.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {


		    pstmt = c.prepareStatement("update session set logouttime = ? where logouttime = '000000'");
		    pstmt.setString(1, time().toString());

		    pstmt.execute();
		   
		    c.commit();
		    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	   
	     
	}
	public static void showSales() {
		Connection c = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    ResultSet re = null;
	    String date = null;
	    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
	    SimpleDateFormat formatter2=new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		Scanner S = new Scanner(System.in);
		System.out.println("please input the start date as 'dd/mm/yyyy'");
		String s_date = S.nextLine();
		Date startDate = null;
		try {
			startDate = formatter1.parse(s_date);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("please input the end date as 'dd/mm/yyyy'");
		String e_date = S.nextLine();
		Date endDate = null;
		try {
			endDate = formatter1.parse(e_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		    try {
				c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/coffee",
					 "sanchuanjiang", "Jsc2211050");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				c.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				pstmt = c.prepareStatement("select * from transaction");
				// pstmt = c.prepareStatement("select sum(quantity) as tot_quantity from transaction group by productid")
				re = pstmt.executeQuery();
				while(re.next()) {
					date = re.getString("data");
					int transactionid = re.getInt("transactionid");
					int customerid = re.getInt("customerid");
					String productid = re.getString("productid");
					int quantity = re.getInt("quantity");
					
					try {
						Date realDate = formatter2.parse(date);
						if (realDate.before(endDate) && realDate.after(startDate)) {
							System.out.println("transaction id: " + transactionid + 
									", customer id: " + customerid + ", product id: " + productid +
									", quantity: " + quantity + ", date: " + date);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			   
			    c.commit();
			    c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		    managerChoose();
	}
	public static void employeeChoose() {
		Scanner S = new Scanner(System.in);
		System.out.println("1. register a sale");
		System.out.println("2. create a customer");
		System.out.println("3. logout");
		int c1 = S.nextInt();
		if (c1 == 1) {
			e_recordTransaction();
		}
		if (c1 == 2) {
			e_createCustomer();
		}
		if (c1 == 3) {
			
			logout();
		}
	}
	public static void managerChoose() {
		Scanner S = new Scanner(System.in);
		System.out.println("1. register a sale");
		System.out.println("2. create a customer");
		System.out.println("3. show inventory");
		System.out.println("4. show transactions");
		System.out.println("5. create a employee");
		System.out.println("6. add discount for item");
		System.out.println("7. logout");
		int c2 = S.nextInt();
		if (c2 == 1) {
			m_recordTransaction();
		}
		if (c2 == 2) {
			m_createCustomer();
		}
		if (c2 == 3) {
			inventory();
		}
		if (c2 == 4) {
			showSales();
		}
		if (c2 == 5) {
			createEmployee();
		}
		if (c2 == 6) {
			sale();
		}
		if (c2 == 7) {
			logout();
		}
		
	}

}
