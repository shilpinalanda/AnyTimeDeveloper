import java.sql.*;
import java.util.Scanner;

public class InsertMultipleRow1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="SYSTEM";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st=con.createStatement();
        Scanner sc=new Scanner(System.in);
        
        while(true)
        {
        	System.out.println("Enter Employee NO: ");
        	int eno=sc.nextInt();
        	System.out.println("Enter Employee Name: ");
        	String ename=sc.next();
        	System.out.println("Enter Employee Salary: ");
        	double esal=sc.nextDouble();
        	System.out.println("Enter Employee Address: ");
        	String eaddr=sc.next();
        	String sql=String.format("insert into employee values(%d,'%s',%f,'%s')",eno,ename,esal,eaddr);
        	st.executeUpdate(sql);
        	System.out.println("Record inserted successfully");
        	System.out.println("Do You want to insert more Employee Information:[yes/no]");
        	String userchoise=sc.next();
        	if(userchoise.equalsIgnoreCase("no"))
        	{
        		break;
        	}
        }
        con.close();
	}

	

}
