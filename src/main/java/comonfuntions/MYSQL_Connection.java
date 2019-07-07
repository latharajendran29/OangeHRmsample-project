package comonfuntions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQL_Connection {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String userName="root";
			String password="Vinoth@123";
String dbUrl="jdbc:mysql://localhost:3306/database_1";
String query="SELECT * FROM database_1.`employee tabel`;";
Connection con=DriverManager.getConnection(dbUrl, userName, password);
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next()) {
	String userid=rs.getString(1);
	String uN=rs.getString(2);
	String userPass=rs.getString(3);
	System.out.println(userid);
	System.out.println(uN);
	System.out.println(userPass);
}
con.close();
}
}

