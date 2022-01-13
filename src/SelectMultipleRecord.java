import java.sql.*;

public class SelectMultipleRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="SYSTEM";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st=con.createStatement();
		String sql="select * from employee";
		boolean flag=false;
		ResultSet rs=st.executeQuery(sql);
		System.out.println("Eno\t Name\t Salary\t Address");
		System.out.println("****************************************");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4)+"\t");
		}
		if(flag==false)
		{
			System.out.println("No records found");
		}
		con.close();

	}

}
