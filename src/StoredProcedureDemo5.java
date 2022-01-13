import java.sql.*;

import oracle.jdbc.*;// for Oracle Types. CURSOR and it is present in ojdbc6.jar

// Write a jdbc program to call stored procedure which returns all employees info using SYS_REFCURSOR
public class StoredProcedureDemo5 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		CallableStatement cst=con.prepareCall("{call getAllEmployeeInfo2A(?,?)}");
		cst.setFloat(1,10000);
		cst.registerOutParameter(2, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs=(ResultSet)cst.getObject(2);
		boolean flag=false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-------------------------");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
			
		}
		if(flag==false)
		{
			System.out.println("No Records Available");
		}
		con.close();

	}

}
