package jdbcPart1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Single_Row {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		Statement st=con.createStatement();
		String sql="update employeee set ename='Monika' where eno=1";
		st.executeUpdate(sql);
		System.out.println("Record Updated successfully");
		con.close();

	}

}
