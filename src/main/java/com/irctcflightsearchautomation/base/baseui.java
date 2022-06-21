package com.irctcflightsearchautomation.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

//import com.datadriven.framework.utils.DateUtils;

public class baseui {

	public WebDriver driver;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\922462\\OneDrive - Cognizant\\Desktop\\QEA Selenium Learning\\JavaTraining-master\\FirstSeleniumProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Mozila")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\922462\\eclipse-workspace\\Irctc Flight Search automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	/****************** Open URL ***********************/
	public void openURL(String websiteURL) {
		driver.get(websiteURL);

	}

	/****************** Close Browser ***********************/
	public void tearDown() {
		driver.close();

	}

	/****************** Quit Browser ***********************/
	public void quitBrowser() {
		driver.quit();
	}

	/****************** Enter Text ***********************/
	public void enterText(String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
	}

	/****************** Click Element ***********************/
	public void elementClick(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	/****************** Flight Search Function ***********************/
	public void Flightsearch() {

		WebElement d = driver.findElement(By.id("travelClass"));
		Select st = new Select(d);
		st.selectByIndex(1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/app-root/app-index/div[2]/div[4]/div/div/div/div[2]/form/button"))
				.click();
		String msg = driver
				.findElement(
						By.xpath("/html/body/app-root/app-oneway/div[1]/div/div/div/div/div/div/div/div/div[1]/label"))
				.getText();
		System.out.println("Validating the city");
		System.out.println(msg);
		String msg1 = driver
				.findElement(
						By.xpath("/html/body/app-root/app-oneway/div[1]/div/div/div/div/div/div/div/div/div[2]/label"))
				.getText();
		System.out.println("Validating the Date");
		System.out.println(msg1);
		// Displaying name and number of flights
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='right_Airline_no']"));
		System.out.println("Total flights available for today is " + list.size());
		for (WebElement webElement : list) {
			System.out.println("Name and Number of the available flight is" + webElement.getText());

		}

	}

	/****************** Capture Screen Shot ***********************/

	public void Scrrenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				"C:\\Users\\922462\\eclipse-workspace\\irctcflightsearchautomation\\Screenshots\\SearchResult.png");
		try {
			FileHandler.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
