package com.ajioweb.pagetest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajioweb.extentReport.ScreenShot;
import com.ajioweb.keyword.Keyword;
import com.ajioweb.page.HomepagePage;
import com.ajioweb.page.SignInPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


@Listeners(com.ajioweb.listener.Listeners.class)
public class LogoPageTest extends SignInPage {
		 SignInPage signin;
		HomepagePage home;
		
		Logger log = Logger.getLogger(SignOutPageTest.class);
		@BeforeTest
		public void extendReportConfig() {
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/ExtendedReport/LogoExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Tester Name", "Priya Ukunde");
		}
		

		@BeforeMethod
		public  void setUp() {
			openBrowser();
			maxiBrowserWindow();
			signin = new SignInPage();
			home = new HomepagePage();
			launchURL();
			deleteAllCookies();
			pageLoadTimeOut();
			implicitWait();

		}
		
		
		@Test(description = "Verify logo is available on  homepage", groups="Usability Testing")
		public void verify_logo_availability() {
			extentLog = extent.createTest("verify_logo_availability");
			home.clickSignIn_JoinAjio();
			if (signin.is_signInModalPop_Up_Visible()) {
				log.info("SignIn Modal Pop-up Opned!!");

				signin.enterEmailOrMobileNumer();
				signin.click_On_continueButton();
				signin.enterPassword();
				signin.click_On_startShopping();
				expllicitWait();
			} else {
				log.error("Signin Modal PopUp not Opened!!");
			}
			try {
				Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull Login!!!");
			} catch (StaleElementReferenceException e) {
				refresh();
			}
			signin.click_On_MyAccount();
			if (driver.getTitle().equals("AJIO")) {
				log.info("Redirected to My Account Page");
			} else {
				log.error("Not Redirected to My Account Page");
			}
			
			Assert.assertTrue(signin.is_Logo_Visible(),"Logo not Displayed!!");
	
		}
		

		@Test(description = "Vreify logo functionality of redirecting to homepage",groups="Functionality Testing")
		public void verify_logo_functionality() {
			extentLog = extent.createTest("verify_logo_functionality");
			home.clickSignIn_JoinAjio();
			if (signin.is_signInModalPop_Up_Visible()) {
				log.info("SignIn Modal Pop-up Opned!!");

				signin.enterEmailOrMobileNumer();
				signin.click_On_continueButton();
				signin.enterPassword();
				signin.click_On_startShopping();
				expllicitWait();
			} else {
				log.error("Signin Modal PopUp not Opened!!");
			}
			try {
				Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull Login!!!");
			} catch (StaleElementReferenceException e) {
				refresh();
			}

			signin.click_On_MyAccount();
			if (driver.getTitle().equals("AJIO")) {
				log.info("Redirected to My Account Page");
			} else {
				log.error("Not Redirected to My Account Page");
			}

			signin.click_On_Logo();
			Assert.assertTrue(
					driver.getTitle().equals("Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO"));

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
