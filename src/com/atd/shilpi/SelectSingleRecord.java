package com.atd.shilpi;
import java.sql.*;
import java.util.Scanner;

public class SelectSingleRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=null;
		String query=null;
		int roll = 0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Student Roll Number : ");
				roll=sc.nextInt();
			}
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
			st=con.createStatement();
			query="SELECT * FROM STUDENT WHERE  STUDENT_NO="+roll;
			rs=st.executeQuery(query);
			while(rs.next()!=false) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getDate(4));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception se) {
				se.printStackTrace();
			}
		}
	}

}

