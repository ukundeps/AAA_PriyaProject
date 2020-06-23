package com.ajioweb.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioweb.keyword.Keyword;

public class SignOutPage extends Keyword{
	@FindBy(xpath = "//a[text()='Sign Out']")
	private static WebElement signOut;
	
	@FindBy(css = "span[class=\"login-form login-modal\"]")
	private static WebElement signIn_JoinAjio;

	
//Constructor
	public SignOutPage() {
		PageFactory.initElements(driver, this);}
	
	//method
	public static boolean click_On_signOut() {
		signOut.click();
		return signIn_JoinAjio.isDisplayed();
	}

}
