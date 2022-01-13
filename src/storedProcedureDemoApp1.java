import java.sql.*;

public class storedProcedureDemoApp1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
     CallableStatement cst=con.prepareCall("{call addproc(?,?,?)}");
     cst.setInt(1, 100);
     cst.setInt(2,200);
     cst.registerOutParameter(3, Types.INTEGER);
     cst.execute();
     int result=cst.getInt(3);
     System.out.println("Result is: "+result);
     con.close();
	}

}
