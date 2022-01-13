import java.util.Scanner;
import java.sql.*;

public class DynamicInput {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Number: ");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String ename=sc.next();
		System.out.println("Enter Employee Salary: ");
		double esal=sc.nextDouble();
		System.out.println("Enter Employee Address: ");
		String eaddr=sc.next();
		String sqlQuery=String.format("insert into employee values(%d,'%s',%f,'%s')",eno,ename,esal,eaddr);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Statement st=con.createStatement();
		st.executeUpdate(sqlQuery);
		System.out.println("sql Query inserted into table");
		con.close();
		

	}
	;
}
