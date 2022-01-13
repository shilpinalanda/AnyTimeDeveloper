import java.sql.*;
public class InsertMultipleRow {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Statement st=con.createStatement();
		String sql="select * from employee";
		st.executeQuery(sql);
		System.out.println("query executed");
		con.close();
	}

}
