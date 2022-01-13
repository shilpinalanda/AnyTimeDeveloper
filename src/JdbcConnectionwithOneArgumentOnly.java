import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionwithOneArgumentOnly {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/root@localhost:1521:XE");
		Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from employee");
	     System.out.println("ENO\tENAME\tESALARY\tEADDRESS");
	     System.out.println("---------------------------------");
	     while(rs.next())
	     {
	    	 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
	     }
	     con.close();
		}
	}
	


