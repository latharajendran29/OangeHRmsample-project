package comonfuntions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.xdevapi.Statement;

import okhttp3.Connection;

public class JDBCconnections {
	public static void main(String[] args) throws Throwable, SQLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\eclipse-workspace\\Selenium\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Map<String,String> datafromDB=getDataFromDB();
		String CD=datafromDB.get("3");
		System.out.println(CD);
		String[] split=CD.split("=");
		driver.findElement(By.id("email")).sendKeys(split[0]);
		driver.findElement(By.id("pass")).sendKeys(split[1]);
	}
public static Map<String, String> getDataFromDB() throws ClassNotFoundException, SQLException {
	try {
		Map<String,String> mp=new HashMap<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String userName="root";
				String password="Vinoth@123";
	String dbUrl="jdbc:mysql://localhost:3306/studentdatabase";
String query="SELECT*FROM studentdatabase.new_table;";
Connection con=DriverManager.getConnection(dbUrl, userName, password);
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next()) {
	String userid=rs.getString(1);
	String uN=rs.getString(2);
	String userPass=rs.getString("password");
	mp.put(userid,uN+"="+userPass);
}
//con.close();
return mp;
}
	catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
}
	}
}


