package sep26;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class calculator {
WebDriver driver;
DesiredCapabilities cap;
String url="http://www.calculator.net";
String node="http://localhost:5550/wd/hub";
@Parameters({"browser"})
@BeforeMethod
public void launch(String brw)throws Throwable
{
	if(brw.equalsIgnoreCase("chrome"))
	{
		System.out.println("Executing on chrome");
	cap=new DesiredCapabilities();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
	driver=new RemoteWebDriver(new URL(node), cap);
	driver.get(url);
	driver.manage().window().maximize();
	}
	else if(brw.equalsIgnoreCase("firefox"))
	{
		System.out.println("Executing on Firefox");
		cap=new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL(node), cap);
		driver.get(url);	
	}
	else{
		System.out.println("Browser is not matching");
	}
}
@Test
public void calculatepercent() {
	// Click on Math Calculators
	driver.findElement(By.xpath("//a[contains(text(),'Math')]")).click();
	// Click on Percent Calculators
	driver.findElement(
	By.xpath("//a[contains(text(),'Percentage Calculator')]"))
	.click();
	// Enter value 17 in the first number of the percent Calculator
	driver.findElement(By.id("cpar1")).sendKeys("10");
	// Enter value 35 in the second number of the percent Calculator
	driver.findElement(By.id("cpar2")).sendKeys("35000");
	// Click Calculate Button
	driver.findElement(
	By.xpath("(//input[contains(@value,'Calculate')])[1]")).click();
	// Get the Result Text based on its xpath
	String result = driver.findElement(
	By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
	// Print a Log In message to the screen
	System.out.println(" The Result is " + result);
	if (result.equals("3500")) {
	System.out.println(" The Result is Pass");
	} else {
	System.out.println(" The Result is Fail");
	}
}
@AfterMethod
public void logout()
{
driver.quit();
}
}






