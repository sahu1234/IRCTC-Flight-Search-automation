package com.irctcflightsearchautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class Extentreportmanager {

	// public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/test-output/testreport.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
            //System Info
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "10.8.1");
			report.setSystemInfo("Browser", "Chrome");
			
            //Report Configuration
			htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
			htmlReporter.config().setReportName("All Headlines UI Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}

		return report;
	}
}
