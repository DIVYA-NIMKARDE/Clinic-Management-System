import java.util.*;
import java.sql.*;
import javax.swing.*;
public class JDBC {

	public static void main(String[] args) {
		dbconnector();
	}
	public static Connection dbconnector() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		String query;
		String USER = "root";
		String PASS = "123456";
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL ="jdbc:mysql://localhost:3306/hospital_management?autoReconnect=true&useSSL=false";

		try{
		Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		//stmt = conn.createStatement();
		return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
	}
		

}
	}
