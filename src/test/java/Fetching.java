
import java.sql.*;
public class Fetching {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
		("jdbc:mysql://localhost:3306/banking","root","");
		   Statement stmt=con.createStatement();
//ResultSet rs=stmt.executeQuery("Select * from Emp where esal=(select max(esal) from Emp)");
ResultSet rs=stmt.executeQuery("Select * from Emp where esal=(select max(esal) from Emp where esal <(select max(esal) from Emp))");
		   while(rs.next())
		   {
			  //System.out.println("max sal is:::"+rs.getInt("esal"));
			  System.out.println("second sal is:::"+rs.getInt("esal"));
		   		   }
	}

}
