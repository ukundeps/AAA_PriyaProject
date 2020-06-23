package com.ajioweb.extentReport;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//This method will return path of Screenshot so that from this path captured screenshot can be attached to Extent Report Automatically
public class ScreenShot {
public static 	Logger log=Logger.getLogger(ScreenShot.class);
	public static String screenshot(WebDriver driver, String tcName) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);

		String screenshotPath = "C:\\Users\\NRK\\javapract\\PriyaRevison\\AAA_PriyaProject\\ExtendedReport\\" + tcName + " dated "
				+ datetime + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");

		return screenshotPath;

	}

}
