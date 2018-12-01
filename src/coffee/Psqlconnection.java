package coffee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Psqlconnection {

	public static void main(String args[]) {
		
		User loginUser = new User();
		try {
			loginUser = Useroperation.login();
			if ( loginUser.getType() == 0) {
				Useroperation.employeeChoose();
			}
			if ( loginUser.getType() == 1) {
				Useroperation.managerChoose();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }

}
