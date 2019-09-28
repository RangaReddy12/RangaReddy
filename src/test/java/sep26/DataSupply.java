package sep26;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class DataSupply {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

@BeforeTest
 public void beforeTest() {
report=new ExtentReports("./Reports/Login.html");	  
System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");

	  }
  @Test(dataProvider = "orange")
  public void verifylogin(String user, String pass)throws Throwable {
	test=report.startTest("Accessing data from DataProvider");
	driver.get("http://orangehrm.qedgetech.com");
	driver.manage().window().maximize();
	driver.findElement(By.name("txtUsername")).sendKeys(user);
	driver.findElement(By.name("txtPassword")).sendKeys(pass);
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(3000);
	if(driver.getCurrentUrl().contains("dash"))
	{
	Reporter.log("Login Success",true);
	test.log(LogStatus.PASS, "Login Success");
	}
	else{
	String message=driver.findElement(By.id("spanMessage")).getText();
	Reporter.log(message,true);
	test.log(LogStatus.FAIL, message);	
	}
	report.endTest(test);
	report.flush();
  }
  @DataProvider
  public Object[][] orange() {
  Object login[][]=new Object[5][2];
  login[0][0]="Admin";
  login[0][1]="Qedge123!@#";
  login[1][0]="Test";
  login[1][1]="admin";
  login[2][0]="Admin";
  login[2][1]="Qedge123!@#";
  login[3][0]="Test";
  login[3][1]="Admin";
  login[4][0]="Test234";
  login[4][1]="Admin";
  return login;
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
