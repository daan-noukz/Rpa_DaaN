package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSql {
	
	//private Connection con = (Connection) DriverManager.
	
	Connection con = null;
	
	public void connectSql() throws SQLException, ClassNotFoundException {
	String userName="usrName";
	String passaword="pwd";	
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String DB_URL ="jdbc:sqlserver://<hostname>\\<instance_name>;databaseName=sample";
	//OR by using ip
	DB_URL ="jdbc:sqlserver://192.168.0.10:3324\\<instance_name>;databaseName=sample";
	con = DriverManager.getConnection(DB_URL, userName, passaword);	
	//Connection con = DriverManager.getConnection(DB_URL, userName, passaword);	
	}
	
	public void insertQuery() throws SQLException {
		String insertQuery = "INSERT INTO EMP (EmpID,EmpAge,EmpSal) VALUES (?,?,?) ";
		PreparedStatement preparedStmt = con.prepareStatement(insertQuery);
		preparedStmt.setInt(1, 50);
		preparedStmt.setInt(2, 40);
		preparedStmt.setInt(3, 14000);
		preparedStmt.executeUpdate(insertQuery);
		preparedStmt.close();
	}
	
	public void selectQuery() throws SQLException {
		String selectQuery = "Select EmpID, EmpAge,EmpSal from EMP where EmpID=1";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		while (rs.next()) {
		        System.out.println("ID: "+rs.getInt("EmpID"));
		 System.out.println("Age: "+rs.getInt("EmpAge"));
		 System.out.println("Sal: "+rs.getInt("EmpSal"));
		}
		stmt.close();
		con.close();	 	
	}
	
	
	
	
	
}
