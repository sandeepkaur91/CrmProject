package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	ContactsPage contactsPage;
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	//all the testcases should be independent of each other 
	//before every test case launch the browser and login
	//after every test case close the browser =========these are best practices
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		testutils=new TestUtils();
		loginpage=new LoginPage();
		contactsPage=new ContactsPage();
		Thread.sleep(2000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    }
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title=homepage.verifyHomePageTitle();
	    Assert.assertEquals(title, "CRMPRO","Home page title not matched");
			}
	@Test(priority=2)
	public void verifyUsernameDisplayed() {
		testutils.switchToFrame();
		boolean flag = homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException {
		testutils.switchToFrame();
       contactsPage=homepage.clickOnContactLink();
      
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
