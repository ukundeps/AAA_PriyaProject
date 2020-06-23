package com.ajioweb.runFailedTC;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.ajioweb.keyword.Keyword;

public class RunFailedTC  {
public static void main(String[] args) {
	List<String> testng_FaileXML=new ArrayList<String>();
	testng_FaileXML.add("C:\\Users\\NRK\\javapract\\PriyaRevison\\AAA_PriyaProject\\test-output\\testng-results.xml");
	TestNG runner=new TestNG();
	runner.setTestSuites(testng_FaileXML);
	runner.run();
	
}
}
