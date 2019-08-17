package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testbase.TestBase;

public class ContactsPage extends TestBase{
	
	//pagefactories
	@FindBy(xpath="//td[contains(text(),' Contacts')]")
	WebElement contactsLabel;
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	@FindBy(xpath="//input[@value='Save and Create Another (same company)']")
	WebElement saveButton;
//	@FindBy(xpath="//a[contains(text(),'sarab sandhu')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
//	WebElement checkbox1;
	//initializing the page factories
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	//actions
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	public void createNewContact(String title,String firstname,String lastname,String company) {
		try{
		Select select=new Select(this.title);
		select.selectByVisibleText(title);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		this.company.sendKeys(company);
		saveButton.click();
		}
		catch(UnsupportedCommandException e) {
			e.printStackTrace();
		}
		
	}
}
