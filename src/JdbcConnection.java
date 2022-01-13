import java.sql.*;

public class JdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Statement st=con.createStatement();
		st.executeUpdate("create table employee1(eno number,ename varchar2(10) ,esal number(10,2),eaddr varchar2(20))");
		System.out.println("Table created successfully");
		con.close();
		
		

	}

}
