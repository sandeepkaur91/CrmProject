package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utils.TestUtils;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		testutils=new TestUtils();
		loginpage=new LoginPage();
		contactsPage=new ContactsPage();
		Thread.sleep(2000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutils.switchToFrame();
		contactsPage=homepage.clickOnContactLink();
	    }
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag,"contacts label is missing on the page");
	}
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactByName("samreen bhatti");
	}
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactByName("samreen bhatti");
		contactsPage.selectContactByName("sarab sandhu");
	}
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][]=TestUtils.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=4,dataProvider="getCRMTestData")//the following 4 variables should be equal to the number of coloumns in excel sheet
	public void validateCreateNewContactTest(String title,String firstname,String lastname,String company) {
		homepage.clickOnNewContact();
		//contactsPage.createNewContact("Miss", "neeru", "bajwa", "rocketscience");
		contactsPage.createNewContact(title, firstname, lastname, company);//from excel sheet
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
