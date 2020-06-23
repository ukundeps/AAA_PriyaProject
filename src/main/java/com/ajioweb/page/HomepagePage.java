package com.ajioweb.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioweb.keyword.Keyword;

public class HomepagePage extends Keyword{
	@FindBy(css = "a[href=\"/shop/women\"]")
	private static WebElement shopWomen;

	@FindBy(css = "a[href=\"/shop/men\"]")
	private static WebElement shopMen;

	@FindBy(css = "a[href=\"/shop/kids\"]")
	private static WebElement shopKids;

	@FindBy(css = "a[href=\"/shop/sale\"]")
	private static WebElement shopSale;

	@FindBy(css = "span[class=\"login-form login-modal\"]")
	private static WebElement signIn_JoinAjio;

	@FindBy(css = "div[class=\"modal-login-container\"]")
	private static WebElement signUpModalPopUp;

	@FindBy(css = "a[href=\"/selfcare\"]")
	private static WebElement customerCare;

	// Constructor
	public HomepagePage() {
		PageFactory.initElements(driver, this);
	}

	// methods

	public boolean isShopWomenLinkVisible() {
		return shopWomen.isDisplayed();

	}

	public static String clickShopWomen() {
		shopWomen.click();
		return driver.getTitle();
	}

	public static boolean isShopMenLinkVisible() {
		return shopMen.isDisplayed();

	}

	public static String clickShopMen() {
		shopMen.click();
		return driver.getTitle();
	}

	public static boolean isShopKidsLinkVisible() {
		return shopKids.isDisplayed();

	}

	public static String clickShopKids() {
		shopKids.click();
		return driver.getTitle();
	}

	public static boolean isShopSaleLinkVisible() {
		return shopSale.isDisplayed();

	}

	public static String clickShopSale() {
		shopSale.click();
		return driver.getTitle();
	}

	public boolean isSignIn_JoinAjioLinkVisible() {
		return signIn_JoinAjio.isDisplayed();

	}

	public static void clickSignIn_JoinAjio() {
		signIn_JoinAjio.click();
	}

	public boolean isCustomerCareLinkVisible() {
		return customerCare.isDisplayed();

	}

	public static String clickCustomerCare() {
		customerCare.click();
		return driver.getTitle();
	}

	public boolean isSignUpModalPopUpVisible() {
		return signUpModalPopUp.isDisplayed();

	}

}
