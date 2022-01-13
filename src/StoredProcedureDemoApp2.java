import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedureDemoApp2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
        CallableStatement cst=con.prepareCall("{call getEmpInfo(?,?,?)}");
        cst.setInt(1, 101);
        cst.registerOutParameter(2, Types.VARCHAR);
        cst.registerOutParameter(3, Types.FLOAT);
        cst.execute();
        System.out.println("Employee Name is: "+cst.getString(2));
        System.out.println("Employee Salary: "+cst.getFloat(3));
        con.close();
	}

}
