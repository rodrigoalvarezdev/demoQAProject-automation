package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.AlertsFramePage;
import com.demoQa.pageObjects.BrowserWinPage;
import com.demoQa.pageObjects.IndexPage;

public class BrowserWinPageTest extends Base {
	@Test
	public void clickOnNewTabTest(){
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		BrowserWinPage browserWinPage = alertsFramePage.clickOnBrowserWinBtn();
		browserWinPage.clickOnNewTabBtn();
		String title = browserWinPage.returnTitle();
		Assert.assertEquals(title, "This is a sample page");
	}
	
	@Test
	public void clickOnNewWinTest(){
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		BrowserWinPage browserWinPage = alertsFramePage.clickOnBrowserWinBtn();
		browserWinPage.clickOnNewTabBtn();
		String title = browserWinPage.returnTitle();
		Assert.assertEquals(title, "This is a sample page");
	}
}
