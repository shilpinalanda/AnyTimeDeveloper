import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.*;

public class RetriveDateValueFromDb {
	public static void main(String[] args) throws SQLException {
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
    PreparedStatement pst=con.prepareStatement("Select * from users");
    ResultSet rs=pst.executeQuery();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    while(rs.next())
    {
    	String name=rs.getString(1);
    	java.util.Date sdate=rs.getDate(2);
    	String s=sdf.format(sdate);
    	System.out.println(name+"..."+s);
    }
    con.close();
	}

}
