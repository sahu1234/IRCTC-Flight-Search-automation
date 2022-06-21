package com.irctcflightsearchautomation.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.irctcflightsearchautomation.base.baseui;
import com.irctcflightsearchautomation.utils.Extentreportmanager;

public class searchtest extends baseui {
	ExtentReports report = Extentreportmanager.getReportInstance();

	@Test
	public void testone() {
		try {
			ExtentTest logger = report.createTest("Test One");

			// Intializing the Browser
			logger.log(Status.INFO, "Intializing the Browser");
			invokeBrowser("chrome"); 
			Thread.sleep(2000);

			// Opening the website
			logger.log(Status.INFO, "Opening the website");
			openURL("https://www.air.irctc.co.in/");
			Thread.sleep(2000);

			// Search Hyd from the Station
			logger.log(Status.INFO, "search Hyd");
			enterText("stationFrom", "Hyd");
			logger.log(Status.INFO, "click Hyd");
			elementClick("//div[text()='Hyderabad (HYD)']");
			Thread.sleep(2000);

			// Search pune for the Destination
			logger.log(Status.INFO, "Search pune");
			enterText("stationTo", "Pune");
			logger.log(Status.INFO, "Click pune");
			Thread.sleep(2000);
			elementClick("//div[text()='Pune (PNQ)']");

			// Select Date for travel
			logger.log(Status.INFO, "Select date");
			Thread.sleep(2000);
			elementClick("//*[@id=\"originDate\"]");

			// Select The class
			logger.log(Status.INFO, "Select the class");
			Thread.sleep(2000);
			elementClick("//span[@class='act active-red']");

			// Select No of Passengers
			logger.log(Status.INFO, "No of passengers");
			Thread.sleep(2000);
			elementClick("//*[@id=\"noOfpaxEtc\"]");

			// Flight Search
			logger.log(Status.INFO, "Flight serach");
			Flightsearch();
			Thread.sleep(2000);

			// Screenshots
			logger.log(Status.INFO, "Screen shot");
			Thread.sleep(2000);
			Scrrenshot();

			// Close Browser
			logger.log(Status.INFO, "close browser");
			Thread.sleep(2000);
			tearDown();

			// Quit Browser
			Thread.sleep(2000);
			logger.log(Status.INFO, "Quit browser");
			quitBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	@Test
	public void testtwo() {
		try {
			ExtentTest logger = report.createTest("Test One");

			// Intializing the Browser
			logger.log(Status.INFO, "Intializing the Browser");
			invokeBrowser("Mozila");
			Thread.sleep(2000);

			// Opening the website
			logger.log(Status.INFO, "Opening the website");
			openURL("https://www.air.irctc.co.in/");
			Thread.sleep(2000);

			// Search Hyd from the Station
			logger.log(Status.INFO, "search Hyd");
			enterText("stationFrom", "Hyd");
			logger.log(Status.INFO, "click Hyd");
			elementClick("//div[text()='Hyderabad (HYD)']");
			Thread.sleep(2000);

			// Search pune for the Destination
			logger.log(Status.INFO, "Search pune");
			enterText("stationTo", "Pune");
			logger.log(Status.INFO, "Click pune");
			Thread.sleep(2000);
			elementClick("//div[text()='Pune (PNQ)']");

			// Select Date for travel
			logger.log(Status.INFO, "Select date");
			Thread.sleep(2000);
			elementClick("//*[@id=\"originDate\"]");

			// Select The class
			logger.log(Status.INFO, "Select the class");
			Thread.sleep(2000);
			elementClick("//span[@class='act active-red']");

			// Select No of Passengers
			logger.log(Status.INFO, "No of passengers");
			Thread.sleep(2000);
			elementClick("//*[@id=\"noOfpaxEtc\"]");

			// Flight Search
			logger.log(Status.INFO, "Flight serach");
			Flightsearch();
			Thread.sleep(2000);

			// Screenshots
			logger.log(Status.INFO, "Screen shot");
			Thread.sleep(2000);
			Scrrenshot();

			// Close Browser
			logger.log(Status.INFO, "close browser");
			Thread.sleep(2000);
			tearDown();

			// Quit Browser
			Thread.sleep(2000);
			logger.log(Status.INFO, "Quit browser");
			quitBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
