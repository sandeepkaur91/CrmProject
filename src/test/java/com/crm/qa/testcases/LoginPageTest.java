package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() throws IOException {
		super();//to initialize the prop object which is used in initialization method
	}
	@BeforeMethod
	  public void setUp() throws IOException {
		initialization();
		loginpage=new LoginPage();
	  }
	@Test(priority=1)
	  public void loginPageTitleTest() {
	     String title=loginpage.validateLoginPageTitle();
	     Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	  }
	@Test(priority=2)
	 public void crmLogoTest() {
		boolean Flag=loginpage.validateCrmLogoImage();
		Assert.assertTrue(Flag);
	}
	@Test(priority=3)
	 public void loginTest() throws IOException {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			
		
	}
  

	@AfterMethod
	  public void tearDown() {
		driver.quit();
	  }

}
