package annotations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class overview {
	
/*[RemoteTestNG] detected TestNG version 7.4.0
BeforeSuite-setup system property for chrome
BeforeTest-login to app
BeforeClass-launch chrome browser
BeforeMethod-enter URl
Test-Google title test
AfterMethod-Logout from app
AfterClass-close the browser
AfterTest-delete all cookies
PASSED: setup
*/
	
	//pre conditions annotations starting with @before
  @BeforeSuite
  public void setup() {
	  System.out.println("BeforeSuite-setup system property for chrome");
	  
  }
  
  @BeforeTest
  public void login() {
	  System.out.println("BeforeTest-login to app");
  }
  

  @BeforeClass
  public void launchBrower() {
	  System.out.println("BeforeClass-launch chrome browser");
  }
  
 
  @BeforeMethod
  public void enterURL() {
System.out.println("BeforeMethod-enter URl");
  }
  
/*
 *
BeforeMethod-enter URl
Test-Google title test
AfterMethod-Logout from app

BeforeMethod-enter URl
Test-Search test
AfterMethod-Logout from app
 * */

  //test cases --starting with @test
  @Test
  public void googleTitleTest() {
	  System.out.println("Test-Google title test");
  }
  
  @Test
  public void searchTest() {
	  System.out.println("Test-Search test");
  }
  
 //post-conditions starting with @after
  
  @AfterMethod
  public void logout() {
	  System.out.println("AfterMethod-Logout from app");
  }

  @AfterClass
  public void closeBrowser() {
	  System.out.println("AfterClass-close the browser");
  }
  
  @AfterTest
  public void deleteCookies() {
	  System.out.println("AfterTest-delete all cookies");
  }
 

  @AfterSuite
  public void afterSuite() {
System.out.println("AfterSuite-generate test report");

}
}
