import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImageIntoDatabase {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","root");
		
        File f=new File("shilpi.jpeg");
        FileInputStream fis=new FileInputStream(f);
        
        PreparedStatement pst=con.prepareStatement("insert into person values(?,?)");
        System.out.println("Image inserting..."+f.getAbsolutePath());
        
        pst.setString(1, "shilpi");
        pst.setBinaryStream(2,fis);  
        
        int rc= pst.executeUpdate();
        if(rc==1)
        {
        	System.out.println("Record inserted successfully");
        }
        else
        {
        	System.out.println("Record not inserted");
        }
	}

}
