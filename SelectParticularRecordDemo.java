package jdbcPart1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_Operation_Based_On_City {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		int eno=sc.nextInt();
        String sql=String.format("select * from employeee where eno='%d' ", eno);
		ResultSet rs=st.executeQuery(sql);
		System.out.println("Eno\t Ename\tEsal\tEaddr");
		System.out.println("--------------------------------------");
		while(rs.next())
		{
		   flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		if(flag==false)
		{
			System.out.println("No Record Found");
		}
		con.close();

	}

}
