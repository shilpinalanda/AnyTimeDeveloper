import java.sql.*;
import java.util.Scanner;

public class Sql_Injection_attack {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="SYSTEM";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userid: ");
		String userid=sc.next();
		System.out.println("Enter Password: ");
		String upwd=sc.next();
		String sql="select count(*) from users where userid='''+userid+''' and upwd='''+upwd+'''";
		ResultSet rs=st.executeQuery(sql);
		int c=0;
		if(rs.next())
		{
			c=rs.getInt(1);
		}
		if(c==0)
		{
			System.out.println("Invalid Credentials");
		}
		else
		{
			System.out.println("Valid Credentials");
		}
		con.close();
				
	

	}

}
