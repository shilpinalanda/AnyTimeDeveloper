//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//public class DateTimeInsertDemo1 {
//
//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
//		PreparedStatement pst=con.prepareStatement("insert into user values(?,?)");
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Name: ");
//		String name=sc.next();
//		System.out.println("Enter Dop(dd-mm-yyyy");
//		String dop=sc.next();
//		pst.setString(1, name);
//		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
//		java.util.Date udate=sdf.parse(dop);
//		long l=udate.getTime();
//		java.sql.Date sdate=new java.sql.Date(l);
//		pst.setDate(2, java.sql.Date);
//		pst.executeUpdate();
//		System.out.println("Record inserted");
//	}
//
//}
