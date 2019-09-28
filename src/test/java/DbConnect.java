
import java.sql.*;
public class DbConnect
{
public static void main(String args[])throws Exception
{
 	//loding jdbc
Class.forName("com.mysql.jdbc.Driver");
//connecting to data base
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
   Statement stmt=con.createStatement();
  //To Insert Records
//stmt.executeUpdate("insert into Emp values('selenium',205,20000)");
  //To update records
//stmt.executeUpdate ("UPDATE Emp SET eno=210 WHERE eno=205");
   //update cname
stmt.executeUpdate("UPDATE Emp SET ename='john' WHERE ename='selenium'");
   //To dalete record
  
}
}

