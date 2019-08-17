package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	

	//page factories or object repositories
	@FindBy(name="username")
	WebElement username1;
	
	@FindBy(name="password") 
	WebElement password1;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	//initializing page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmLogoImage() {
		boolean logo=crmLogo.isDisplayed();
		return logo;
	}
	public HomePage login(String username,String password) throws IOException {
		username1.sendKeys(username);
		password1.sendKeys(password);
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(loginButton));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginButton.click();//this method will return the object of homepage class
		return new HomePage();
	}

}
