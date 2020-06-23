package com.ajioweb.pagetest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajioweb.extentReport.ScreenShot;
import com.ajioweb.page.HomepagePage;
import com.ajioweb.page.SignInPage;
import com.ajioweb.page.SignOutPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(com.ajioweb.listener.Listeners.class)
public class SignOutPageTest  extends SignOutPage{
	SignInPage signin;
	 SignOutPage signout;
	HomepagePage home;
	Logger log = Logger.getLogger(SignOutPageTest.class);

	@BeforeTest
	public void extendReportConfig() {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/ExtendedReport/SignOutPageExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "Priya Ukunde");
	}

	@BeforeMethod
	public  void setUp() {
		openBrowser();
		maxiBrowserWindow();
		signout = new SignOutPage();
		signin = new SignInPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	@Test(description = "To verify successfull SignOut after clicking on SignOut Link")
	public  void verify_Successfull_SignOut() {
		extentLog = extent.createTest("verify_Successfull_SignOut");
		home.clickSignIn_JoinAjio();
		signin.enterEmailOrMobileNumer();
		signin.click_On_continueButton();
		signin.enterPassword();
		signin.click_On_startShopping();
		Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull SignIn");

		Assert.assertTrue(signout.click_On_signOut(), "Unsuccessfull SignOut!!");
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
