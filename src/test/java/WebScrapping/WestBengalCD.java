package WebScrapping;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class WestBengalCD {
	
	public static WebDriver driver;
	public static WebDriverWait w;
	String url="https://westbengal.covidsafe.in/";
	
	@FindBys(@FindBy( xpath="//div[@class='table-responsive']/table/tbody/tr")) List<WebElement>  rows; 
	@FindBys(@FindBy( xpath="//div[@class='table-responsive']/table/tbody/tr[1]/td")) List<WebElement> cols; 
	
	
	
	@BeforeTest
	public void launchBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VISHAKAN\\eclipse-workspace\\xpath\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void getData() {
		
		PageFactory.initElements(driver, this);
		
		for (int i=1;i<=rows.size();i++)
		{
			//WebElement row=driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr["+i+"]"));
			for(int j=1;j<=cols.size();j++)
			{
				//String celldata=row.findElement(By.tagName("td")).getText();
				String celldata=driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(celldata);
			}
			System.out.println();
		}
		
		
	}
	
	
	@BeforeTest
	public void getScreenshot() {
		TakesScreenshot scrShot =(TakesScreenshot) driver;
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination



	}

}
