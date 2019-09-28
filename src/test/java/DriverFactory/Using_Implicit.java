package DriverFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Using_Implicit {
public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
driver.get("https://gmail.com");
//wait for elements when not found
driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.findElement(By.name("identifier")).sendKeys("pranga2010");
driver.findElement(By.className("CwaK9")).click();
driver.findElement(By.name("password")).sendKeys("test123456");
	}

}
