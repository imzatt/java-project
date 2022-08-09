package day21;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Testing_1 {

public static void main(String[] args) {
		
		//save_with_statement();
		//save_with_preparestatement();
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter emp no : ");
			//int no = Integer.parseInt(sc.nextLine());
			String no = sc.nextLine();
			System.out.print("Enter name : ");
			String name = sc.nextLine();
			
			//find_with_statement(no, name);
			find_with_preparestatement(no, name);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void find_with_preparestatement(String no, String name) {
		
		try{
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3","root","");
			System.out.println("Get Connection");
			
			//define query
			String query = "SELECT emp_no, city, birthday FROM employees WHERE name = ? " ;
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			//setXXX(index, value)
			pstm.setString(1, name); // select city, birthday from employees where emp_no = '1006 or 1 = 1'
			//pstm.setString(2, name);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				//System.out.println("data exist");
				//getXXX();
				System.out.println("No : " + rs.getInt("emp_no"));
				System.out.println("DOB : " + rs.getDate("birthday"));
				System.out.println("City : " + rs.getString("city"));
				System.out.println("----------------------------------");
			}
//			else {
//				System.out.println("There is not data");
//			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		
	}

	private static void find_with_statement(String no, String name) {
		
		try{
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3","root","");
			System.out.println("Get Connection");
			
			//create statement
			Statement st = con.createStatement();
			
			//define query
			//String query = "SELECT city, birthday FROM employees WHERE emp_no = " + no + " AND name = '" + name + "'" ;
			// SELECT * FROM employees WHERE emp_no = 1001 AND name = 'aung'
			
			//execute query
			// 1. select => executeQuery()(return result set)
			// 2. transaction(insert
			
			String query = "SELECT city, birthday FROM employees WHERE emp_no = " + no  ;
			// SELECT * FROM employees WHERE emp_no = 1006 or 1 = 1
			// sql injection
			
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("data exist");
			}else {
				System.out.println("There is not data");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		
	}

	private static void save_with_preparestatement() {
		try{
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3","root","");
			System.out.println("Get Connection");
			
			//define query
			String query = "INSERT employees(emp_no, name, city, salary, birthday)VALUES(1003, 'Su Su', 'Mandalay', 100000, '1997-12-12')";
			
			//create statement
			PreparedStatement pstm = con.prepareStatement(query);
			
			//execute query
			// 1. select => executeQuery()(return result set)
			// 2. transaction(insert
			
			pstm.executeUpdate(query);
			System.out.println("Insert success");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void save_with_statement() {
		try{
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3","root","");
			System.out.println("Get Connection");
			
			//create statement
			Statement st = con.createStatement();
			
			//define query
			String query = "INSERT employees(emp_no, name, city, salary, birthday)VALUES(1002, 'Su Su', 'Mandalay', 100000, '1997-12-12')";
			
			//execute query
			// 1. select => executeQuery()(return result set)
			// 2. transaction(insert
			
			st.executeUpdate(query);
			System.out.println("Insert success");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
