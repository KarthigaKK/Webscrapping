package AutomationPractice;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderDress {

	WebDriver driver;
	WebDriverWait w;
	// JavascriptExecutor executor;

	
	private void takeScreenShot(String StepName) throws IOException{
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		
		String tcName = "TC_001";
		String dir = System.getProperty("user.dir");
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String path = dir + "/Numpy/src/test/resources/screenshots/" +tcName+"/screenshot_"+StepName+".jpeg";// + "_" + timestamp+".jpeg";
		File destFile = new File(path);
		FileUtils.copyFile(srcFile, destFile);
	}
	
	@BeforeTest
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VISHAKAN\\eclipse-workspace\\xpath\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

	}

	@Test(priority = 1)
	public void dressSearch() throws IOException {
		driver.findElement(By.id("search_query_top")).sendKeys("summer dress");
		driver.findElement(By.name("submit_search")).click();

		takeScreenShot("dressSearch1");
		  // scroll down 
		WebElement Element1 = driver.findElement( By.xpath("//li[1]//img[@class='replace-2x img-responsive' and @title='Printed Summer Dress']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("window.scrollBy(0,250)", Element1);
		 

		// mouse over printed summer dress.
		WebElement pinterdress = driver.findElement(By.xpath("//li[1]//div//div[2]//h5//a[@class='product-name']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(pinterdress).build().perform();
		
		takeScreenShot("dressSearch2");
		
		// Add to compare
		driver.findElement(By.xpath("//li[1]//div//div[3]//div[2]//a[contains(text(),'Add to Compare')]")).click();
		
		// now execute query which actually will scroll until Faded Short Sleeve T-shirts
		// appeared on page.
		WebElement Element2 = driver.findElement(
				By.xpath("//li[4]//div//div[3]//div[2]//a[contains(text(),'Add to Compare')]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("window.scrollBy(0,500)", Element2);

		takeScreenShot("dressSearch2");
		// mouse over faded summer short sleeve
		WebElement shortsleeve = driver.findElement(By.xpath("//li[4]//div//div[2]//h5//a[@class='product-name']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(shortsleeve).build().perform();
		// Add to compare
		driver.findElement(By.xpath("//li[4]//div//div[3]//div[2]//a[contains(text(),'Add to Compare')]")).click();

		takeScreenShot("dressSearch3");
		// Press Compare[2]
		driver.findElement(By.xpath("//div[@class='bottom-pagination-content clearfix']//form//button")).click();
		takeScreenShot("dressSearch4");
	}

	@Test(priority = 2)
	public void comparePrice() {
		// Compare two dress page scroll down

		WebElement Element4 = driver.findElement(
				By.xpath("//tbody//tr[1]//td[2]//div[@class='prices-container']//span[@class='price product-price']"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("window.scrollBy(0,300)", Element4);

		// Get printedDressPrice
		String printeddressprice = driver
				.findElement(By.xpath(
						"//tbody//tr[1]//td[2]//div[@class='prices-container']//span[@class='price product-price']"))
				.getText();

		System.out.println(printeddressprice);

		// Get printedDressPrice
		String shortsleevedressprice = driver
				.findElement(By.xpath(
						"//tbody//tr[1]//td[3]//div[@class='prices-container']//span[@class='price product-price']"))
				.getText();

		System.out.println(shortsleevedressprice);

		double douprinteddressprice = Double.parseDouble(printeddressprice.replace("$", " "));
		double doushortsleevedressprice = Double.parseDouble(shortsleevedressprice.replace("$", " "));
		// Find greater price dress

		if (Double.valueOf(douprinteddressprice) > Double.valueOf(doushortsleevedressprice)) {
			driver.findElement(By.xpath(
					"//tbody//tr//td[2]//div[@class='comparison_product_infos']//div//div//a//span[contains(text(),'Add to cart')]"))
			.click();

			// Scroll down
			WebElement Element5 = driver.findElement(By.xpath("//tbody//tr//td[3]//div[@class='remove']//a"));
			JavascriptExecutor executor4 = (JavascriptExecutor) driver;
			executor4.executeScript("window.scrollBy(0,200)", Element5);

			// Delete
			driver.findElement(By.xpath("//tbody//tr//td[3]//div[@class='remove']//a")).click();
		} else {
			driver.findElement(By.xpath("//tbody//tr//td[3]//div[@class='comparison_product_infos']//div//div//a//span[contains(text(),'Add to cart')]")).click();

			// Scroll up
			WebElement Element5 = driver.findElement(By.xpath("//tbody//tr//td[2]//div[@class='remove']//a"));
			JavascriptExecutor executor5 = (JavascriptExecutor) driver;
			executor5.executeScript("window.scrollBy(0,200)", Element5);

			// Delete
			driver.findElement(By.xpath("//tbody//tr//td[2]//div[@class='remove']//a")).click();
		}
	}

	@Test(priority = 3)
	public void addTocart() {

		// scroll down
		WebElement Element6 = driver.findElement(By
				.xpath("//div[@class='comparison_product_infos']//div//div//a//span[contains(text(),'Add to cart')]"));
		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
		executor6.executeScript("window.scrollBy(0,300)", Element6);
		// Click Add to cart
		driver.findElement(
				By.xpath("//div[@class='comparison_product_infos']//div//div//a//span[contains(text(),'Add to cart')]"))
		.click();
	}

	@Test(priority = 4)
	public void proceedToCheckOut() {
		driver.findElement(
				By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']//div[@class='button-container']//a"))
		.click();
		driver.findElement(
				By.xpath("//p[@class='cart_navigation clearfix']//a//span[contains(text(),'Proceed to checkout')]"))
		.click();
	}

	@Test(priority = 5)
	public void createAccount() {
		driver.findElement(By.id("email_create")).sendKeys("wisdomd"+ Math.random() +"@gmail.com", Keys.ENTER);
	}

	@Test(priority = 6)
	public void register() {
		driver.findElement(By.id("id_gender2")).click();

		driver.findElement(By.id("customer_firstname")).sendKeys("KarthigaKK", Keys.TAB);
		driver.findElement(By.id("customer_lastname")).sendKeys("K", Keys.TAB);
		driver.findElement(By.id("passwd")).sendKeys("wisdom", Keys.TAB);
		Select date = new Select(driver.findElement(By.id("days")));
		date.selectByValue("28");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("8");
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByValue("1985");

		driver.findElement(By.xpath("//div[@class='checkbox']//div[@id='uniform-newsletter']//..//label")).click();
		driver.findElement(By.id("company")).sendKeys("TechM");
		driver.findElement(By.xpath("//div[@class='account_creation']//p[4]//label[@for='address1']//..//input"))
		.sendKeys("2534 Yorktown st,Houston");
		driver.findElement(By.xpath("//div[@class='account_creation']//p[6]//label//..//input[@id='city']"))
		.sendKeys("Chennai");

		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Arkansas");
		driver.findElement(By.xpath("//div[@class='account_creation']//p[8]//label//..//input")).sendKeys("77005");

		driver.findElement(By.xpath("//div[@class='account_creation']//p[10]//textarea")).sendKeys("Nice Assignment");
		driver.findElement(By.xpath("//div[@class='account_creation']//p[13]//label//..//input"))
		.sendKeys("4856743876");
		driver.findElement(By.id("submitAccount")).click();
	}

	@Test(priority = 7)
	public void updateAddress() {

		driver.findElement(By.xpath("//ul[@id='address_delivery']//li[8]//a")).click();
		// scroll down
		WebElement Element7 = driver.findElement(By.id("address1"));
		JavascriptExecutor executor7 = (JavascriptExecutor) driver;
		executor7.executeScript("window.scrollBy(0,500)", Element7);

		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("Bering drive,Houston");
		driver.findElement(By.id("phone")).sendKeys("4357460574");
		// Click update
		driver.findElement(By.id("submitAddress")).click();
		// Proceed to checkout
		driver.findElement(By.name("processAddress")).click();

	}

	@Test(priority = 8)
	public void shipping() {
		// scroll down
		WebElement Element6 = driver.findElement(By.xpath("//span/input[@id='cgv']"));
		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
		executor6.executeScript("window.scrollBy(0,450)", Element6);
		// Pay by check checkbox
		WebElement ChkBox = driver.findElement(By.xpath("//span/input[@id='cgv']"));

		Actions act = new Actions(driver);
		act.moveToElement(ChkBox).click().build().perform();

		// proceed to checkout
		driver.findElement(
				By.xpath("//p[@class='cart_navigation clearfix']/button//span[contains(text(),'Proceed to checkout')]"))
		.click();
	}

	@Test(priority=9) 
	public void payment() { 
		// scroll down
		WebElement Element7 = driver.findElement(
				By.xpath("//a[@class='cheque']"));
		JavascriptExecutor executor7 = (JavascriptExecutor) driver;
		executor7.executeScript("window.scrollBy(0,800)", Element7);
		//pay by check option
		driver.findElement(
				By.xpath("//a[@class='cheque']")).click();

		// scroll down
		WebElement Element8 = driver.findElement(
				By.xpath("//p//button//span[contains(text(),'I confirm my order')]"));
		JavascriptExecutor executor8 = (JavascriptExecutor) driver;
		executor8.executeScript("window.scrollBy(0,600)", Element8);

		driver.findElement(
				By.xpath("//p//button//span[contains(text(),'I confirm my order')]")).click();
		 


	}
	
	@Test(priority=10) 
	public void orderrefeid() { 
		  //After order complete 
		JavascriptExecutor executor8 = (JavascriptExecutor) driver;
		executor8.executeScript("window.scrollBy(0,700)");
		
		List <WebElement> orderdetails = driver.findElements(By.xpath("//div[@class='box order-confirmation']"));
		String orderdetail = orderdetails.get(0).getText();
		//System.out.println(orderdetail);
		String referenceNo="";
		//Getting reference number by using substring
		if (orderdetail.indexOf("order reference") > 0) {
			referenceNo = orderdetail.substring(orderdetail.indexOf("order reference"), (orderdetail.indexOf("order reference") +25));
			referenceNo = referenceNo.substring(referenceNo.length() - 10).trim();
		}
		driver.findElement(By.xpath("//a[@title='Back to orders']/i")).click();
		//back to orders page
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='order-list']/tbody/tr"));
		
		for(int i=1;i<=rows.size();i++)
		{
			WebElement row=driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr["+i+"]/td[1]/a"));
			
			if(referenceNo.equals(row.getText().toString().trim()))
			{
				String totalcost=row.findElement(By.xpath("//td[@class='history_price']/span")).getText();
				String status=row.findElement(By.xpath("//td[@class='history_state']/span")).getText();
				System.out.println("ReferenceNo:"+referenceNo);
				System.out.println("totalcost:"+totalcost);
				System.out.println("status:"+status);
				
				row.findElement(By.xpath("//td[@class='history_detail footable-last-column']/a")).click();
				
			}
		
			JavascriptExecutor executor9 = (JavascriptExecutor) driver;
			executor9.executeScript("window.scrollBy(0,700)");
			String Tax=driver.findElement(By.xpath("//div[@id='order-detail-content']/table/tfoot/tr[3]/td[2]")).getText();
			System.out.println("Tax:"+Tax);
			String TotalOrderAmount=driver.findElement(By.xpath("//div[@id='order-detail-content']/table/tfoot/tr[4]/td[2]")).getText();
			System.out.println("TotalOrderAmount:"+TotalOrderAmount);
			
			
			driver.findElement(By.xpath("//div[@class='header_user_info']/a[@class='logout']")).click();
		}
	}

	
}
