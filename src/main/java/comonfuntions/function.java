package comonfuntions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class function {
	
public static WebDriver driver=null;;
 public static Properties properties=null;
 
 Logger x=Logger.getLogger(function.class);
	public Properties loadpropertyfile() throws IOException {
	FileInputStream fileinputstream=new FileInputStream("config.properties");
	properties=new Properties();
	properties.load(fileinputstream);
	return properties;
	}
	@BeforeSuite
	public void browserlaunch() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		x.info("oranegs hrm test begins");
		x.info("loading the property file");
		loadpropertyfile();
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
String driverlocation=properties.getProperty("DriverLocation");
if (browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", driverlocation);
	x.info("launching home");
	driver = new ChromeDriver();
} 
else if (browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver",driverlocation);
	driver = new FirefoxDriver();
} 
driver.manage().window().maximize();
x.info("navigating to application");
driver.get(url);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterSuite
public void teardown() {
		x.info("close the broswer");	
driver.quit();
}
}
