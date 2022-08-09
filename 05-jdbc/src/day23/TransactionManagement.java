package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManagement {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		try{
			
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3","root","");
			
			var insert1 = "INSERT INTO students(email, name)VALUES(?, ?)";
			var insert2 = "INSERT INTO students(email, name)VALUES(?, ?)";
			var update = "UPDATE students SET email = ? WHERE id = ?";
			
			// disable auto-commit mode
			con.setAutoCommit(false);
			
			var pstm = con.prepareStatement(insert1);
			pstm.setString(1, "jeon@gmail.com");
			pstm.setString(2, "Jeon");
			pstm.executeUpdate();
			
			pstm = con.prepareStatement(insert2);
			pstm.setString(1, "cherry@gmail.com");
			pstm.setString(2, "Cherry");
			pstm.executeUpdate();
			
			var pstm_update = con.prepareStatement("INSERT INTO students(email, name)VALUES(?, ?)");
			pstm_update.setString(1, "cherry@gmail.com");
			pstm_update.setString(2, "AUNG AUNG");
			var i = pstm_update.executeUpdate();
			System.out.println("no of effected row : " + i);
			
			con.commit();
			System.out.println("Success");
			
		} catch (Exception e) {
			con.rollback(); // roll back all change again
			System.out.println("Something is wrong");
		}
		finally {
			con.close();
		}
	}
}
