import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectingtoDbusingPropertiesFile {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
     Properties p=new Properties();
     FileInputStream fis= new FileInputStream("db.properties");
     p.load(fis);
     String url=p.getProperty("url");
     String user=p.getProperty("user");
     String pwd=p.getProperty("pwd");
     Connection con=DriverManager.getConnection(url,user,pwd);
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select * from employee");
     System.out.println("ENO\tENAME\tESALARY\tEADDRESS");
     System.out.println("---------------------------------");
     while(rs.next())
     {
    	 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
     }
	}

}
