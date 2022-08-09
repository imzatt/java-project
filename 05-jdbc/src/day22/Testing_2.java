package day22;

import java.sql.Date;
import java.sql.DriverManager;
import java.util.Scanner;

public class Testing_2 {

	public static void main(String[] args) {
		
		//saveMultipleObject();
		//updateData();
		//deleteData();
		//retrieve_1();
		retrieve_2();
		
	}

	private static void retrieve_2() {
		try(Scanner sc = new Scanner(System.in)){
			
			var con = DriverManager.getConnection("jdbc:mariadb://localhost/batch_3","root","");
			
			var query = "SELECT * FROM employees WHERE emp_no IN(?, ?, ?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, 1001);
			pstm.setInt(2, 1003);
			pstm.setInt(3, 1005);
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				System.out.println("No : " + rs.getInt("emp_no"));
				System.out.println("Name : " + rs.getString("name"));
				System.out.println("Salary : " + rs.getDouble("salary"));
				System.out.println("----------------------------");
			}
			
			int i = pstm.executeUpdate();
			System.out.println("No of affected rows : " + i);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void retrieve_1() {
		try(Scanner sc = new Scanner(System.in)){
			
			var con = DriverManager.getConnection("jdbc:mariadb://localhost/batch_3","root","");
			
			var query = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setDouble(1, 600000);
			pstm.setDouble(2, 1000000);
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				System.out.println("No : " + rs.getInt("emp_no"));
				System.out.println("Name : " + rs.getString("name"));
				System.out.println("Salary : " + rs.getDouble("salary"));
				System.out.println("----------------------------");
			}
			
			int i = pstm.executeUpdate();
			System.out.println("No of affected rows : " + i);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void deleteData() {
		try(Scanner sc = new Scanner(System.in)){
			
			var con = DriverManager.getConnection("jdbc:mariadb://localhost/batch_3","root","");
			
			var query = "DELETE FROM employees WHERE name LIKE ?"; //%aung%
			// delete from employees where name like %aung%
			
			System.out.print("Enter name : ");
			//var city = sc.nextLine();
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, "%" + sc.nextLine() + "%");
			
			int i = pstm.executeUpdate();
			System.out.println("No of affected rows : " + i);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void updateData() {
		try(Scanner sc = new Scanner(System.in)){
			
			var con = DriverManager.getConnection("jdbc:mariadb://localhost/batch_3","root","");
			
			var query = "UPDATE employees SET salary = salary + (salary * 0.2) WHERE city = ?";
			
			System.out.print("Enter city name : ");
			//var city = sc.nextLine();
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, sc.nextLine());
			
			int i = pstm.executeUpdate();
			System.out.println("No of affected rows : " + i);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void saveMultipleObject() {
		try(Scanner sc = new Scanner(System.in)){
			
			var con = DriverManager.getConnection("jdbc:mariadb://localhost/batch_3","root","");
			var query = "INSERT INTO employees(emp_no, name, city, salary, birthday)VALUES(?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(query);
			
			for(var i=0; i<2; i++) {
				System.out.print("Enter no : ");
				pstm.setInt(1, Integer.parseInt(sc.nextLine()));
				
				System.out.print("Enter name : ");
				pstm.setString(2, sc.nextLine());
				
				System.out.print("Enter city : ");
				pstm.setString(3, sc.nextLine());
				
				System.out.print("Enter salary : ");
				pstm.setDouble(4, Double.parseDouble(sc.nextLine()));
				
				System.out.print("Enter date of birth : ");
				pstm.setDate(5, Date.valueOf(sc.nextLine()));
				
				pstm.addBatch();
				
				System.out.println("Employee " + (i + 1) + " saved");
			}
			pstm.executeBatch();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
