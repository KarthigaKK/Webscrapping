package PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class JuiceShop {
	
	
	public static WebDriver driver;
	JavascriptExecutor executor;
	WebDriverWait w;
	String URL;
	String userName="";
	public static String emails=randomestring() +"@gmail.com";
	Locale local=new Locale("en_US");
	Faker faker=new Faker(local);
	
	@FindBy (xpath = "//button//span[text()='Dismiss']") WebElement dismissBtn;
	@FindBy (id = "emailControl") WebElement emailID;
	@FindBy (id = "passwordControl") WebElement passwordTxt;
	@FindBy (id = "repeatPasswordControl") WebElement confirmPassword;
	@FindBy (xpath = "//div[@id='mat-select-value-3']/span") WebElement secQnBox;
	@FindBy (xpath = "//span[text()=' Your eldest siblings middle name? ']") WebElement secQn;
	@FindBy (id = "securityAnswerControl") WebElement secQnAns;
	@FindBy	(xpath="//button[@id='navbarAccount']/span[@class='mat-button-wrapper']") WebElement account;
	@FindBy	(xpath="//button[@id='navbarLoginButton']/span") WebElement login;
	@FindBy	(xpath="//a[contains(text(),'Not yet a customer?')]") WebElement customerNew;
	//@FindBy	(xpath="//button[@id='registerButton']/span") WebElement register;
	@FindBy	(id="registerButton") WebElement register;
	@FindBy	(xpath="//input[@id='email']") WebElement email;
	@FindBy	(xpath="//input[@id='password']") WebElement password;
	@FindBy (xpath="//button[@id='loginButton']") WebElement submit;
	@FindBy (xpath="//a[contains(text(),'Me want it!')]") WebElement mewantit;
	@FindBy (xpath="//img[@alt='Fruit Press']/../../../div[2]/button//span[text()='Add to Basket']") WebElement productFruitPress;
	
	@FindBy	(id="email") WebElement loginUserName;
	@FindBy	(id="password") WebElement loginPassword;
	@FindBy	(id="loginButton") WebElement loginButton;
	@FindBy (xpath="//div[contains(text(),'Green Smoothie')]/../../..//div[2]//span[text()='Add to Basket']") WebElement greenSmoothie;
	@FindBy (xpath="//div[@class='mat-paginator-range-actions']//button[2]") WebElement nextPage;
	@FindBy (xpath="//div[contains(text(),' OWASP Juice Shop Sticker Page ')]/../../..//div[2]//span[text()='Add to Basket']") WebElement OWASPJuiceShopSticker;
	@FindBy (xpath="//div[contains(text(),' Web Applications ')]/../../..//div[3]//span[text()='Add to Basket']") WebElement OWASPLadder;
	@FindBy (xpath="//a[contains(text(),'Me want it!')]") WebElement meWantIt;
	@FindBy (xpath="//span[contains(text(),'Your Basket')]") WebElement yourBasket;
	@FindBy (xpath="//mat-cell[contains(text(),'OWASP Juice')]/../mat-cell[3]/button[2]") WebElement incQuantityOwaspJuice;
	@FindBy (xpath="//mat-cell[contains(text(),'Green Smoothie')]/../mat-cell[3]/button[2]") WebElement incQuantityGreenSmoothie;
	@FindBy (xpath="//mat-cell[contains(text(),' OWASP Snakes')]/../mat-cell[3]/button[2]") WebElement incQuanityOwaspLadder;
	@FindBy (xpath="//button[@id='checkoutButton']") WebElement checkOut;
	@FindBy (xpath="//mat-icon[contains(text(),'add')]") WebElement  addNewAddress; 
	@FindBy (id="submitButton") WebElement submitButton;
	@FindBy (xpath="//mat-table//mat-row[1]/mat-cell/mat-radio-button") WebElement selectAddress;
	@FindBy (xpath="//button[@aria-label='Proceed to payment selection']//span[contains(text(),'Continue')]") WebElement continueDelivery;
	@FindBy (xpath="//mat-table/mat-row[1]//mat-radio-button") WebElement oneDayDelivery;
	@FindBy (xpath="//button[@aria-label='Proceed to delivery method selection']//span[contains(text(),'Continue')]") WebElement continuePayment;
	@FindBy (xpath="//mat-panel-title[contains(text(),' Add new card ')]") WebElement addNewCard;
	@FindBy (xpath="//div[@id='cdk-accordion-child-1']/div/mat-form-field") WebElement couponTextBox;
	@FindBy (id="submitButton") WebElement paymentSubmit;
	@FindBy (xpath="//span/mat-panel-description[contains(text(),' Add a coupon code to receive discounts ')]") WebElement addToCoupon;
	@FindBy (xpath="//input[@id='coupon']") WebElement couponNum;
	@FindBy (id="applyCouponButton") WebElement applyCoupon;
	@FindBy (xpath="//div[@class='error ng-star-inserted']") WebElement couponErrorMsg;
	@FindBy (xpath="//mat-table/mat-row/mat-cell/mat-radio-button") WebElement selectCardRadiobtn;
	@FindBy (xpath="//button[@aria-label='Proceed to review']") WebElement reviewOrderBtn;
	@FindBy (id="checkoutButton") WebElement checkOutBtn;
	@FindBy (id="navbarAccount") WebElement accountMouseOver;
	@FindBy (xpath="//div[contains(@class,'mat-menu-content')]/button[@aria-label='Show Orders and Payment Menu']") WebElement orderAndPymnt;
	@FindBy (xpath="//div[contains(@class,'mat-menu-content')]/button[@aria-label='Go to order history page']") WebElement orderHistory;
	@FindBy (xpath="//button[@aria-label='Track Your Order']") WebElement trackOrder;
	@FindBy (xpath="//div[@class='heading']//button[@aria-label='Print order confirmation']") WebElement printOrder;
	@FindBy (id="navbarLogoutButton") WebElement logOut;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//Drivers//chromedriver.exe");
		 driver = new ChromeDriver();
		 
		URL = "https://juice-shop.herokuapp.com/#/";
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}
	

	@Test(priority=1)
	public void lanuchRegisterPage() {
		dismissBtn.click();
		
		 w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(account));
		account.click();
		 
		w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		
		
		w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(customerNew));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", customerNew);
		//customerNew.click();
	
	}
	
	
	@Test(priority=2)
	public void register() throws InterruptedException {	
		
		System.out.println(emails);
		emailID.sendKeys(emails);
		passwordTxt.sendKeys("karthi.1234");
		confirmPassword.sendKeys("karthi.1234");
		Thread.sleep(5000);
		secQnBox.click();
		secQn.click();
		secQnAns.sendKeys("karthi");
		Actions actions = new Actions(driver);
		
		Thread.sleep(5000);
		//w=new WebDriverWait(driver,Duration.ofSeconds(5));
		actions.moveToElement(register).build().perform();
		register.click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", Webelement); 
	}
	
	@Test(priority=3)
	public void login() throws InterruptedException {
		
		//System.out.println(userName);
		Thread.sleep(2000);
		loginUserName.sendKeys(emails);
		loginPassword.sendKeys("karthi.1234");
		loginButton.click();	
	}
	
	@Test(priority=4)
	public void addItemsToBasket() throws InterruptedException {
		Actions onitems = new Actions(driver);
		onitems.moveToElement(greenSmoothie).build().perform();
		Thread.sleep(3000);
		greenSmoothie.click();
		meWantIt.click();
		onitems.moveToElement(nextPage).build().perform();
		Thread.sleep(5000);
		nextPage.click();
		onitems.moveToElement(OWASPJuiceShopSticker).build().perform();
		Thread.sleep(5000);
		OWASPJuiceShopSticker.click();
		onitems.moveToElement(nextPage).build().perform();
		Thread.sleep(5000);
		nextPage.click();
		onitems.moveToElement(OWASPLadder).build().perform();
		Thread.sleep(5000);
		OWASPLadder.click();
		
	}
	
	@Test(priority=5)
	public void addToBasket() throws InterruptedException {
		Actions onitems = new Actions(driver);
		onitems.moveToElement(yourBasket).build().perform();
		Thread.sleep(5000);
		yourBasket.click(); 
		Thread.sleep(5000);
		incQuantityOwaspJuice.click();
		Thread.sleep(5000);
		incQuantityGreenSmoothie.click();
		//Thread.sleep(5000);
		//incQuanityOwaspLadder.click();	
		w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(checkOut)).click();	
	}
	
	@Test(priority=6)
	public void addNewAddress() throws InterruptedException {
		
		
		String country=faker.address().country();
		String Name=faker.name().fullName();
		//String MobileNo=faker.phoneNumber().cellPhone().replace("-", "").replace(".", "");
		String MobileNo="1234567899";
		String zipcode=faker.address().zipCodeByState("TX");
		String address=faker.address().fullAddress();
		String city=faker.address().city();
		String state=faker.address().state();
		//System.out.println("country/n"+country+"Name/n"+Name+"MobileNo/n"+MobileNo+"zipcode/n"+zipcode+"address/n"+address+"city/n"+city+"state/n"+state);
		Thread.sleep(5000);
		Actions items=new Actions(driver);
		items.moveToElement(addNewAddress).build().perform();
		
		addNewAddress.click();
		Thread.sleep(3000);
		
		
		
		List<WebElement> matForms = driver.findElements(By.xpath("//div[@id='address-form']/mat-form-field"));
		
		for(int i=0; i<matForms.size(); i++) {
			matForms.get(i).click();

			switch (i) {
	        	case 0:
	        		//matForms.get(i).sendKeys(country);
	        		matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a country.']")).sendKeys(country);
	        		break;
	        	case 1: 
        			matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a name.']")).sendKeys(Name);
        			break;
	        	case 2:
	        		matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a mobile number.']")).sendKeys(MobileNo);
	        		break;
	        	case 3:
	        		matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a ZIP code.']")).sendKeys(zipcode);
	        		break;
	        	case 4:
	        		matForms.get(i).findElement(By.xpath("//textarea[@data-placeholder='Please provide an address.']")).sendKeys(address);
	        		break;
	        	case 5:
	        		matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a city.']")).sendKeys(city);
	        		break;
	        	case 6:
        			matForms.get(i).findElement(By.xpath("//input[@data-placeholder='Please provide a state.']")).sendKeys(state);
        			break;	
			}
		}
		
		
		Thread.sleep(5000);
		submitButton.click();
		
		
	}
	
	
	@Test(priority=7)
	public void deliverySelection() throws InterruptedException {
	
		Thread.sleep(5000);
		selectAddress.click();
		Thread.sleep(3000);
		continueDelivery.click();
		Thread.sleep(8000);
		oneDayDelivery.click();
		Thread.sleep(5000);
		continuePayment.click();
	}
	
	@Test(priority=8)
	public void paymentDetails() throws InterruptedException {
		
		Thread.sleep(5000);
		addNewCard.click();
		Thread.sleep(5000);
		List<WebElement> matForms2 = driver.findElements(By.xpath("//div[contains(@class,'mat-expansion-panel-content')]/div/div/mat-form-field"));
		
		for(int i=0; i<matForms2.size(); i++) {
			matForms2.get(i).click();
			
			switch (i) {
        		case 0:
        			matForms2.get(i).findElement(By.tagName("input")).sendKeys("KKK");
        			break;
        		case 1:
        			matForms2.get(i).findElement(By.tagName("input")).sendKeys("1234567890123456");
        			break;
        		case 2:
        			Select expire=new Select(matForms2.get(i).findElement(By.tagName("select")));
        			expire.selectByValue("1");
        			break;
        		case 3:
        			Select year=new Select(matForms2.get(i).findElement(By.tagName("select")));
        	        year.selectByValue("2080");
        			break;	
			}
			Thread.sleep(3000);

		}
		
		Thread.sleep(5000);
		paymentSubmit.click();
		
	}
	
	@Test(priority=9)
	public void addCoupon() throws InterruptedException {
		Thread.sleep(3000);
		addNewCard.click();
		//executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click()", addToCoupon);
		Thread.sleep(3000);
		addToCoupon.click();
		Thread.sleep(3000);		
		couponTextBox.click();
		couponNum.sendKeys("1234567891");
		Thread.sleep(3000);
		applyCoupon.click();
		Thread.sleep(3000);
		System.out.println(couponErrorMsg.getText());
		Assert.assertTrue(couponErrorMsg.getText().trim().equals("Invalid coupon."));
		Thread.sleep(3000);
		//executor.executeScript("arguments[0].click()", selectCardRadiobtn);
		selectCardRadiobtn.click();
		Thread.sleep(3000);
		reviewOrderBtn.click();
		Thread.sleep(5000);
		//executor.executeScript("arguments[0].click()", checkOutBtn);
		checkOutBtn.click();
		Thread.sleep(5000);
	}
	
	@Test(priority=10)
	public void verifyOrderHistory() throws InterruptedException {
		accountMouseOver.click();
		Thread.sleep(5000);
		orderAndPymnt.click();
		Thread.sleep(5000);
		orderHistory.click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=11)
	public void trackOrder() throws InterruptedException {
		
		
		trackOrder.click();
		Thread.sleep(5000);
		try {
			captureScreen(driver,"Trackorder");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		Thread.sleep(5000);
		printOrder.click();
		//Wait till Window id of 2 generated
		w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.numberOfWindowsToBe(2));
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		Thread.sleep(9000);
		
		try {
			captureScreen(driver,"PrintOrder");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		w.until(ExpectedConditions.numberOfWindowsToBe(1));
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		
		accountMouseOver.click();
		Thread.sleep(5000);
		logOut.click();
		
	}

	@AfterTest
	public void quitBrowser() {
		driver.close();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);  
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
	public static String randomestring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	
	
}
