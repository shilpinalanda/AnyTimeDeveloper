package com.atd.shilpi;
import java.sql.*;

public class UpdateRecord {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String query = null;
		ResultSet rs=null;
		int i = 0;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
			st = con.createStatement();
			query = "SELECT * FROM STUDENT";
			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next() != false) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
			}
			query = "\nUPDATE  STUDENT SET STUDENT_NAME='vishal' WHERE STUDENT_NO=102";
			System.out.println(query);
			i = st.executeUpdate(query);
			if (i != 0)
				System.out.println("Record updated Successfully");
			else
				System.out.println("Record not updated");
			
			query = "\nSELECT * FROM STUDENT";
			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next() != false) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}

