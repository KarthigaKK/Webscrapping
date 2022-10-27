package annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;
	

	@BeforeMethod
	@Parameters({"url"})
	public void launchBrowser(String url)
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VISHAKAN\\eclipse-workspace\\Numpy\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test
	@Parameters({"email","password"})
	public void yahooLogin(String email,String password)
	{		
		
		
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//img[@class='_yb_howga']")).click();
		
	
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")).click();
	   
	}
	
}
