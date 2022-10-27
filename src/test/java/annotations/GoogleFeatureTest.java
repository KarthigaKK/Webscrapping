package annotations;

import 	org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleFeatureTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VISHAKAN\\eclipse-workspace\\Numpy\\src\\test\\resources\\Drivers\\chromedriver.exe");
		//launch ChromeDriver
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		
	}
	
	@Test(priority=1)
	public void googleTitleTest()
	{
		String title=driver.getTitle();
		System.out.println("Goigle title"+title);
	}
	
	@Test(priority=2)
	public void googleImageTest() {
		boolean b= driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
		Assert.assertEquals(b, true);
	}
	
	@Test(priority=3)
	public void mailLinkTest() {
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertEquals(b, true);

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
