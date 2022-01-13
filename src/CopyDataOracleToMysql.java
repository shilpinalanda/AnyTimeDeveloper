import java.sql.*;

public class CopyDataOracleToMysql {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
		Statement st1=con1.createStatement();
		Statement st2=con2.createStatement();
		String sql="select * from employee";
		int count=0;
		ResultSet rs=st1.executeQuery(sql);
		System.out.println("Eno\t Name\t Salary\t Address");
		System.out.println("****************************************");
		while(rs.next())
		{
			count++;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4)+"\t");
			st2.executeUpdate(sql);
		}
		System.out.println("The no of row updated in mysql database from oracle database: "+count);
		con1.close();
		con2.close();
		
	}

}
