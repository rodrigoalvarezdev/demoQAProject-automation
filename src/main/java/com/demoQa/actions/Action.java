package com.demoQa.actions;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.demoQa.base.Base;

public class Action extends Base {
	public static void click(WebElement ele) {
		if(ele.isDisplayed()) {
			ele.click();
		}
	}
	
	public static void explicitWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void sendText(WebElement ele, String text) {
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static String returnText(WebElement ele) {
		return ele.getText();
	}
	
	public static String returnTextValue(WebElement ele) {
		return ele.getAttribute("value");
	}
	
	public static String returnTextSplit(WebElement ele, String spliter, int index) {
		String complete = returnText(ele);
		String[] parts = complete.split(spliter);
		String part = parts[index];
		return part;
	}
	
	public static void clickOnRadioButton(WebElement ele) {
		if(ele.isEnabled()) {
			if(!ele.isSelected()) {
				click(ele);
			}
		}
	}
	
	public static String editFieldPosition(String pos) {
		return "edit-record-"+pos;
	}
	
	public static String deleteFieldPosition(String pos) {
		return "delete-record-"+pos;
	}
	
	@SuppressWarnings("deprecation")
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

	public static void waitClickeable(WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(100));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void doubleClick(WebElement ele) {
		Actions act = new Actions(driver.get());
		if(ele.isDisplayed()) {
			act.doubleClick(ele).build().perform();
		}
	}
	
	public static void rightClick(WebElement ele) {
		Actions act = new Actions(driver.get());
		if(ele.isDisplayed()) {
			act.contextClick(ele).build().perform();
		}
	}
	
	public static void changeFocus() {
		String actualTab = driver.get().getWindowHandle();
		System.out.println(actualTab);
		Set<String> handles = driver.get().getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while(iterator.hasNext()) {
			if(iterator.next() != actualTab) {
				driver.get().switchTo().window(iterator.next());
			}
		}
	}
	
	public static void testLinks(List<WebElement> list, String attribute) {
		for(WebElement i : list) {
			if(i.getAttribute(attribute) == null || i.getAttribute(attribute).isBlank()) {
				System.out.println(i.getText()+ "link vacio");
			}else {
				try {
					HttpURLConnection connection = (HttpURLConnection)(new URL(i.getAttribute(attribute)).openConnection());
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode = connection.getResponseCode();
					SoftAssert softAssert = new SoftAssert();
					softAssert.assertEquals(responseCode, 200, "la respuesta es diferente de 200");
					System.out.println(responseCode);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	public static void deleteFile(String path) {
		File file = new File (path);
		file.delete();
	}
	
	public static void waitVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void selectValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	public static void enterBtn(WebElement ele) {
		ele.sendKeys(Keys.ENTER);
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
}
