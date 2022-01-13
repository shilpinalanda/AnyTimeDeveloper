
import java.sql.*;
import java.util.Scanner;

public class useofpreparedstatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 String driver="oracle.jdbc.OracleDriver";
	        String url="jdbc:oracle:thin:@localhost:1521:XE";
	        String user="SYSTEM";
	        String pwd="root";
	        Class.forName(driver);
	        Connection con=DriverManager.getConnection(url,user,pwd);
	        String sqlQuery="insert into employee values(?,?,?,?)";
	        PreparedStatement pst=con.prepareStatement(sqlQuery);
	        Scanner sc=new Scanner(System.in);
	        while(true)
	        {
	        	System.out.println("Employee Number: ");
	        	int eno=sc.nextInt();
	        	System.out.println("Employee Name: ");
	        	String ename=sc.next();
	        	System.out.println("Employee Salary: ");
	        	double esal=sc.nextDouble();
	        	System.out.println("Employee Address: ");
	        	String eaddr=sc.next();
	        	pst.setInt(1, eno);
	        	pst.setString(2, ename);
	        	pst.setDouble(3, esal);
	        	pst.setString(4, eaddr);
	        	pst.executeUpdate();
	        	System.out.println("Record inserted successfully");
	        	System.out.println("Do you want to insert one more record[yes/no]:");
	        	String option=sc.next();
	        	if(option.equalsIgnoreCase("no"))
	        	{
	        		break;
	        	}
	        	
	        }
	        con.close();
	}

}
