import java.sql.*;
import java.util.Scanner;

public class Useofexecutequery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        String driver="oracle.jdbc.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:XE";
        String user="SYSTEM";
        String pwd="root";
        Class.forName(driver);
        Connection con=DriverManager.getConnection(url,user,pwd);
       
        Statement st=con.createStatement();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your query: ");
        String query=sc.nextLine();
        boolean b=st.execute(query);
        if(b==true)//select query
        {
        	ResultSet rs=st.getResultSet();
        	while(rs.next())
        	{
        		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4)+"\t");
        		
        	}
        	
        }
        else //non-select query
        {
        	int rowcount=st.getUpdateCount();
        	System.out.print("The no of rows affected is "+rowcount);
        }
        con.close();
	}

}
