package com.ajioweb.pagetest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajioweb.extentReport.ScreenShot;
import com.ajioweb.page.HomepagePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(com.ajioweb.listener.Listeners.class)
public class HomepagePageTest extends HomepagePage {
	HomepagePage home;
	Logger log = Logger.getLogger(HomepagePageTest.class);

	@BeforeTest
	public void extendReportConfig() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtendedReport/HomepageExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "Priya Ukunde");
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		maxiBrowserWindow();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	// Usability Testing

	@Test(description = "To verify title of homepage", groups = "Usability Testing")
	public void verify_Homepage_Title() {
		extentLog = extent.createTest("verify_Homepage_Title");
		Assert.assertEquals(getTitle(), "Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO",
				"Homepage Title not matched!!");

	}

	@Test(description = "To verify Shop women Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_ShopWomen_Link_is_visible() {
		extentLog = extent.createTest("verify_ShopWomen_Link_is_visible");
		if (home.isShopWomenLinkVisible()) {
			log.info("Shop women Link is visible");
		} else {
			log.error("Shop women Link is absent");
		}
		Assert.assertTrue(home.isShopWomenLinkVisible(), "ShopWomen Link not visible on homepage");
	}

	@Test(description = "To verify Shop men Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_ShopMen_Link_is_visible() {
		extentLog = extent.createTest("verify_ShopMen_Link_is_visible");
		if (home.isShopMenLinkVisible()) {
			log.info("Shop men Link is visible");
		} else {
			log.error("Shop men Link is absent");
		}
		Assert.assertTrue(home.isShopMenLinkVisible(), "ShopMen Link not visible on homepage");
	}

	@Test(description = "To verify Shop Kids Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_ShopKids_Link_is_visible() {
		extentLog = extent.createTest("verify_ShopKids_Link_is_visible");
		if (home.isShopKidsLinkVisible()) {
			log.info("Shop kids  Link is visible");
		} else {
			log.error("Shop kids  Link is absent");
		}
		Assert.assertTrue(home.isShopKidsLinkVisible(), "ShopKids Link not visible on homepage");
	}

	@Test(description = "To verify Shop sale Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_ShopSale_Link_is_visible() {
		extentLog = extent.createTest("verify_ShopSale_Link_is_visible");
		if (home.isShopSaleLinkVisible()) {
			log.info("Shop sale Link is visible");
		} else {
			log.error("Shop sale  Link is absent");
		}
		Assert.assertTrue(home.isShopSaleLinkVisible(), "ShopSale  Link not visible on homepage");
	}

	@Test(description = "To verify signIn_JoinAjio Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_signIn_JoinAjio_Link_is_visible() {
		extentLog = extent.createTest("verify_SignInAjio_Link_is_visible");
		if (home.isSignIn_JoinAjioLinkVisible()) {
			log.info("signIn_JoinAjio  Link is visible");
		} else {
			log.error("signIn_JoinAjio Link is absent");
		}
		Assert.assertTrue(home.isSignIn_JoinAjioLinkVisible(), "signIn_JoinAjio  Link not visible on homepage");
	}

	@Test(description = "To verify Customer care Link is visible  on homepage ", groups = "Usability Testing")
	public void verify_CustomerCare_Link_is_visible() {
		extentLog = extent.createTest("verify_Customercare_Link_is_visible");
		if (home.isCustomerCareLinkVisible()) {
			log.info("CustomerCare  Link is visible");
		} else {
			log.error("CustomerCare Link is absent");
		}
		Assert.assertTrue(home.isCustomerCareLinkVisible(), "Customer Care  Link not visible on homepage");
	}

	// Functional Testing

	@Test(description = "To verify Shop women Link is  redirecting to Women Page", groups = "Functional Testing")
	public void verify_ShopWomen_Link_is_Redirecting_to_WomenPage() {
		extentLog = extent.createTest("verify_ShopWomen_Link_is_Redirecting_to_WomenPage");
		Assert.assertEquals(home.clickShopWomen(),
				"Online Shopping for Women – Clothing, Footwear, Fashion & Accessories | AJIO",
				"ShopWomen Page title not matched!!");

	}

	@Test(description = "To verify Shop men Link is  redirecting to Men  Page", groups = "Functional Testing")
	public void verify_ShopMen_Link_is_Redirecting_to_MenPage() {
		extentLog = extent.createTest("verify_ShopMen_Link_is_Redirecting_to_MenPage");
		Assert.assertEquals(home.clickShopMen(),
				"Online Shopping for Men – Clothing, Footwear, Fashion & Accessories | AJIO",
				"ShopMen  Page title not matched!!");

	}

	@Test(description = "To verify Shop Kids Link is  redirecting to Kids  Page", groups = "Functional Testing")
	public void verify_ShopKids_Link_is_Redirecting_to_KidsPage() {
		extentLog = extent.createTest("_ShopKids_Link_is_Redirecting_to_KidsPage");
		Assert.assertEquals(home.clickShopKids(), "Online Kids fashion shopping site in India - AJIO",
				"ShopKids  Page title not matched!!");

	}

	@Test(description = "To verify Shop sale Link is redirecting to Sale Page", groups = "Functional Testing")
	public void verify_ShopSale_Link_is_Redirecting_to_SalePage() {
		extentLog = extent.createTest(" verify_ShopSale_Link_is_Redirecting_to_SalePage");
		Assert.assertEquals(home.clickShopSale(), "AJIO", "ShopSale Page title not matched!!");

	}

	@Test(description = "To verify signIn_JoinAjio Link is redirecting to  signUpModalPopUp ", groups = "Functional Testing")
	public void verify_signIn_JoinAjio_Link_is_Redirecting_to_signUpModalPopUp() {
		extentLog = extent.createTest("verify_signIn_JoinAjio_Link_is_Redirecting_to_signUpModalPopUp");
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(isSignUpModalPopUpVisible(), "signUpModalPopUp is not opened!!");

	}

	@Test(description = "To verify Customer care Link is  redirecting to Ajio Customer Care page ", groups = "Functional Testing")
	public void verify_Customercare_Link_is_Redirecting_to_customerCarePage() {
		extentLog = extent.createTest("verify_Customercare_Link_is_Redirecting_to_customerCarePage");
		Assert.assertEquals(home.clickCustomerCare(), "AJIO", "Customer care  Page title not matched!!");

	}

	@AfterMethod
	public static void tearDown(ITestResult result) throws IOException {
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
