package com.demoQa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demoQa.actions.Action;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	protected static Properties prop;
	@BeforeSuite(groups = {"sanity", "smoke", "regression"})
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("configuration\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver.set(new FirefoxDriver());
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		
		
		driver.get().manage().window().maximize();
		Action.implicitWait(driver.get(), 10);
		Action.pageLoadTimeOut(driver.get(), 20);
		driver.get().get(prop.getProperty("url"));
	}
	
	@BeforeMethod(groups = {"sanity", "smoke", "regression"}, alwaysRun = true)
	public static void setUp(ITestContext context) {
		String browserSuite = context.getCurrentXmlTest().getParameter("browser");
		String browserUp = browserSuite != null ? browserSuite : "chrome";
		launchApp(browserUp);
	}
	
	@AfterMethod(groups = {"sanity", "smoke", "regression"}, alwaysRun = true)
	public static void tearDown(ITestResult result) {
		System.out.println(result.getName());
		System.out.println(result.getThrowable());
		driver.get().quit();
	}
}
