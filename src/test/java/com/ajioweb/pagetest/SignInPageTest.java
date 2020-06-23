package com.ajioweb.pagetest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajioweb.extentReport.ScreenShot;
import com.ajioweb.page.HomepagePage;
import com.ajioweb.page.SignInPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(com.ajioweb.listener.Listeners.class)
public class SignInPageTest extends SignInPage {
	SignInPage signin;
	HomepagePage home;
	Logger log = Logger.getLogger(SignInPageTest.class);

	@BeforeTest
	public void extendReportConfig() {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/ExtendedReport/SigninPageExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "Priya Ukunde");
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		maxiBrowserWindow();
		signin = new SignInPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	
	
	@DataProvider(name = "TestData")
	public Object[][] readExcel() throws IOException {
		Object[][] data;
		FileInputStream fis = new FileInputStream("C:\\Users\\NRK\\Desktop\\PriyaAjioProject\\SignInData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalrows = sheet.getLastRowNum();
		int totalcolumns = sheet.getRow(0).getLastCellNum();
		
		data = new Object[totalrows][totalcolumns];
		for (int i = 1; i <= totalrows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalcolumns; j++) {
				Cell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				data[i - 1][j] = format.formatCellValue(cell);
			}

		}

		return data;

	}

	@Test(dataProvider = "TestData", description = "To verify Successfull Login after providing valid username and password", groups = "Smoke Testing")
	public void verify_Successfull_Login(String email, String Password) {
		extentLog = extent.createTest("verify_Successfull_Login");
		System.out.println(email);
		System.out.println(Password);
		extentLog = extent.createTest("verify_Successfull_Login");
		home.clickSignIn_JoinAjio();
		signin.username.sendKeys(email);
		signin.click_On_continueButton();
		signin.password.sendKeys(Password);
		signin.click_On_startShopping();
		Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull SignIn");

	}
	
	

	@Test(description = "To verify signIn_JoinAjio Link is redirecting to  loginformEmai Modal popUp ", groups = "Functional  Testing")
	public void verify_signIn_JoinAjio_Link_is_Redirecting_to_signUpModalPopUp() {
		extentLog = extent.createTest("verify_signIn_JoinAjio_Link_is_Redirecting_to_signUpModalPopUp");
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_loginformEmail_Visbile(), "loginformEmail_Visbile is not opened!!");

	}

	@Test(description = "To verify all  elements on login Form_Email  is Visible", groups = "Usability Testing")
	public void verify_loginFormEmail_Elements_Visibile() {
		extentLog = extent.createTest("verify_loginFormEmail_Elements_Visibile");
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_WelcomeAjioMessage_Visbile(), "Welcome to AJIO message not visible!!");
		Assert.assertTrue(signin.verify_FacebookLogin_Visbile(), "Facebook Login is not visible!!");
		Assert.assertTrue(signin.verify_GoogleLogin_Visbile(), "Google login is not visible!!");
		Assert.assertTrue(signin.verify_EnterEmail_MobileNumber_Message_Visbile(),
				"Enter Email/Mobile number text Is not visible");
		Assert.assertTrue(signin.verify_termsAndCondition_Link_Visbile(), "Terms And Conditions Link is not visible!!");
		Assert.assertTrue(signin.verify_ContinueButton_Visbile(), "Continue button is not visisble!!");
		Assert.assertTrue(signin.verify_closeIcon_Visbile(), "Close icon is not displayed");

	}

	@Test(description = "To verify  termsAndCondition_Link_ is redirecting to terms and  ondition page", groups = "Functional  Testing")
	public void verify_TACLink_is_redirecting_to_TACPage() {
		extentLog = extent.createTest("verify_TACLink_is_redirecting_to_TACPage");
		home.clickSignIn_JoinAjio();
		Assert.assertEquals(signin.verify_termsAndCondition_Link_redirectingTo_TermsAndConditionPage(),
				"Terms & Conditions | Terms of Use | AJIO", "TAC Page title mismatched!!");
	}

	@Test(description = "To verify  after clicking on close icon, the loginForm is closing", groups = "Functional  Testing")
	public void verify_closing_LoginForm() {
		extentLog = extent.createTest("verify_closing_LoginForm");
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.click_closeIcon(), "Login FormNot closed!!!!");
	}

	@Test(description = "To verify After entering valid username and clicking on continue shoping LoginForm_Password Modal pop_Up Is dispaying", groups = "Functional  Testing")
	public void verify_loginForm_Password_ModalPopUp_Visible() {
		extentLog = extent.createTest("verify_loginForm_Password_ModalPopUp_Visible");
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_loginForm_Password_Visbile(), "loginForm_Password_is not Visbile");

	}

	@Test(description = "To verify all  elements on login Form_Password  is Visible", groups = "Usability Testing")
	public void verify_loginFormPassword_Elements_Visibile() {
		extentLog = extent.createTest("verify_loginFormPassword_Elements_Visibile");
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		Assert.assertTrue(signin.verify__gladYouAreBackMeg_Visible(), "Gald you are back  message not visible!!");
		Assert.assertTrue(signin.verify_enterYourPass_Text_Visible(), "Enter Password test  is not visible!!");
		Assert.assertTrue(signin.verify_loginWithOTP_Visible(), "LoginWith OTP Button  is not visible!!");
		Assert.assertTrue(signin.verify_backIcon_Visible(), "Back Icon  is not visible!!");
		Assert.assertTrue(signin.verify_closeIcon_Visbile(), "Close Icon  is not visible!!");

	}

	@Test(description = "To verify after clicking on signIn With Otp button Respective modal PopUp is displaying", groups = "Functional  Testing")
	public void verify_SignInWithOtp_ModalPop_Up() {
		extentLog = extent.createTest("verify_SignInWithOtp_ModalPop_Up");
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		signin.click_loginWithOTP();
		Assert.assertTrue(signin.verify_signInWithOtp_ModalPopUp_Visible(),
				"SignInWith Otp Modal PopUp Is not visible!!");
	}

	@Test(description = "To verify after clicking back icon LoginForm_Email Modal Pop_Up is displaying!!", groups = "Functional  Testing")
	public void verify_backIcon_redirectingPage_To_LoginFormEmail() {
		extentLog = extent.createTest("verify_backIcon_redirectingPage_To_LoginFormEmail");
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		signin.click_backIcon();
		Assert.assertTrue(signin.verify_loginformEmail_Visbile(), "LoginForm_Email Modal Pop_Up is  not displayed!!");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			extentLog.log(Status.FAIL, "Failed TestCase: " + result.getName());
			String failedTCScreenshotPath = ScreenShot.screenshot(driver, result.getName());
			extentLog.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
		}	else if (result.getStatus() == ITestResult.SUCCESS) {
				extentLog.log(Status.PASS, "Passed TestCase: " + result.getName());
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentLog.log(Status.PASS, "Skipped  TestCase: " + result.getName());
			
		}
		extent.flush();
		closeBrowserWindow();
	}

	
}
