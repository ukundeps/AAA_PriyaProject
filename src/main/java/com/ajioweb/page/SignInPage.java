package com.ajioweb.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.ajioweb.keyword.Keyword;

public class SignInPage extends Keyword{

	
	@FindBy(css = "span[class=\"login-form login-modal\"]")
	private static WebElement signIn_JoinAjio;


	@FindBy(css = "div[class=\"modal-login-container\"]")
	private static WebElement signinModalPopUp;


	@FindBy(css = "input[name=\"username\"]")
	public  static WebElement username;

	
	@FindBy(css = "input[class=\"login-btn\"]")
	private static WebElement continueButton;

	@FindBy(css = "input[name=\"password\"]")
	public static WebElement password;

	
	@FindBy(css = "input[value=\"START SHOPPING\"]")
	private static WebElement startShopping;

	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private static WebElement signOut;

	@FindBy(css = "form[class=\"login-form num-email-form\"]")
	private static WebElement loginform_email;

	@FindBy(xpath = "//h1[text()='Welcome to AJIO']")
	private static WebElement welcomeAjioMsg;

	@FindBy(css = "div[class=\"fb-login\"]")
	private static WebElement facebookLogin;

	@FindBy(css = "button[class=\"google-login\"]")
	private static WebElement googleLogin;

	@FindBy(xpath = "//label[text()='Enter Mobile Number / Email*']")
	private static WebElement enterEmail_MobileNumber_Text;

	@FindBy(xpath = "//a[text()='Terms and Conditions']")
	private static WebElement TACLink;

	@FindBy(css = "div[class=\"ic-close-quickview\"]")
	private static WebElement closeIcon;

	@FindBy(css = "form[class=\"login-form\"]")
	private static WebElement loginform_password;

	@FindBy(xpath = "//h1[text()=\" Glad you're back! \"]")
	private static WebElement gladYouAreBackMeg;

	@FindBy(xpath = "//label[text()=' Enter your password']")
	private static WebElement enterYourPass_Text;

	@FindBy(css = "input[value=\"LOGIN WITH OTP\"]")
	private static WebElement loginWithOTP;

	@FindBy(css = "span[class=\"ic-chevron-left\"]")
	private static WebElement backIcon;

	@FindBy(xpath = "//h1[text()='Sign In with OTP']")
	private static WebElement signInWithOtpForm;
	
	@FindBy(xpath="//a[text()='My Account']")
	private static WebElement myAccount;
	
	@FindBy(css="img[src=\"https://assets.ajio.com/static/img/Ajio-Logo.svg\"]")
	private static WebElement logo;

	
	//constructor
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// methods

	public static boolean verify_loginformEmail_Visbile() {
		return loginform_email.isDisplayed();
	}

	public static boolean verify_WelcomeAjioMessage_Visbile() {
		return welcomeAjioMsg.isDisplayed();
	}

	public static boolean verify_FacebookLogin_Visbile() {
		return facebookLogin.isDisplayed();

	}

	public static boolean verify_GoogleLogin_Visbile() {
		return googleLogin.isDisplayed();

	}

	public static boolean verify_EnterEmail_MobileNumber_Message_Visbile() {
		return enterEmail_MobileNumber_Text.isDisplayed();

	}

	public static boolean verify_ContinueButton_Visbile() {
		return continueButton.isDisplayed();

	}

	public static boolean verify_termsAndCondition_Link_Visbile() {
		return TACLink.isDisplayed();

	}

	public static boolean verify_closeIcon_Visbile() {
		return closeIcon.isDisplayed();

	}

	public static boolean click_closeIcon() {
		closeIcon.click();
		return signIn_JoinAjio.isDisplayed();

	}
	
	public static boolean is_signInModalPop_Up_Visible(){
		return signinModalPopUp.isDisplayed();
		
	}

	public static String verify_termsAndCondition_Link_redirectingTo_TermsAndConditionPage() {
		TACLink.click();
		return driver.getTitle();

	}

	public static boolean verify_loginForm_Password_Visbile() {
		String email = "ukundepriya@gmail.com";
		username.sendKeys(email);
		continueButton.click();
		return loginform_password.isDisplayed();

	}

	public static boolean verify__gladYouAreBackMeg_Visible() {
		return gladYouAreBackMeg.isDisplayed();
	}

	public static boolean verify_enterYourPass_Text_Visible() {
		return enterYourPass_Text.isDisplayed();
	}

	public static boolean verify_loginWithOTP_Visible() {
		return loginWithOTP.isDisplayed();
	}

	public static boolean verify_backIcon_Visible() {
		return backIcon.isDisplayed();
	}

	public static void click_loginWithOTP() {
		loginWithOTP.click();
	}

	public static boolean verify_signInWithOtp_ModalPopUp_Visible() {
		return signInWithOtpForm.isDisplayed();
	}

	public static void click_backIcon() {
		backIcon.click();
	}

	
	public  void enterEmailOrMobileNumer() {
		String email = getParameter("email_Id");
		username.sendKeys(email);

	}
	public static void click_On_continueButton() {
		continueButton.click();
	}
	public  void enterPassword() {
		String email =getParameter("password");
		password.sendKeys(email);

	}
	public  void enterPass(String pass) {
		password.sendKeys(pass);
	}
	public  void enterEmail(String email) {
		password.sendKeys(email);
	}

	public static void click_On_startShopping() {
		startShopping.click();
	}
	
	public static boolean is_MyAccount_Visible(){
		return myAccount.isDisplayed();
	}
	
	public static void click_On_MyAccount(){
		myAccount.click();
	}
	
	public  static boolean  is_Logo_Visible() {
		return logo.isDisplayed();
	}
public  static void click_On_Logo() {
	logo.click();

}
private void login() {
	
}
	

}
