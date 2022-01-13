import java.sql.*;

public class functionCallFromJdbcprogram {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
        CallableStatement cst=con.prepareCall("{?=call getAvg(?,?)}");
        cst.setInt(2, 101);
        cst.setInt(3, 102);
        cst.registerOutParameter(1, Types.FLOAT);
        cst.execute();
        System.out.println("Salary..."+cst.getFloat(1));
        con.close();
	}

}
