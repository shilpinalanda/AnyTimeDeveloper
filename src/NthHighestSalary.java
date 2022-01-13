
import java.sql.*;
import java.util.Scanner;

public class NthHighestSalary {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="SYSTEM";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n=sc.nextInt();
		String sql="select * from(select eno,ename,esal,eaddr,rank() over(order by esal DESC) ranking from employee) where ranking="+n;
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())

		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();
	}

}
