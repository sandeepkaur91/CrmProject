package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
       //page factories/OR
	@FindBy(xpath="//td[contains(text(),' sandeep chhina ')]")
	@CacheLookup//this improves the speed of script by taking the element from cache memory instead of taking the element from webpage again again
	WebElement usernameLabel;//problem with cachelookup=if the webpage refreshed or some dom property chnaged then stale ele exception,as the element is cache is corrupted
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	//initialize these page factories through constructor
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	//actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public ContactsPage clickOnContactLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsPage() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksPage() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	public boolean verifyCorrectUserName() {
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(usernameLabel));
		return(usernameLabel.isDisplayed());
	}
	public void clickOnNewContact() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
		
	}
}

