import java.sql.*;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "SYSTEM";
		String pwd = "root";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int cut_off=sc.nextInt();

//		String sql = "delete from employee where esal<10000";
		String sql=String.format("delete from employee where esal<%f",cut_off );
		int n = st.executeUpdate(sql);
		System.out.println(n + " row deleted");

		con.close();

	}

}
