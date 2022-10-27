package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.AlertsFramePage;
import com.demoQa.pageObjects.AlertsPage;
import com.demoQa.pageObjects.IndexPage;

public class AlertPageTest extends Base{
	@Test
	public void clickOnAlertTest() throws InterruptedException {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		AlertsPage alertsPage = alertsFramePage.clickOnAlertsBtn();
		alertsPage.clickOnAlertBtn1();
	}
	
	@Test
	public void clickOnAlertAfterTest() throws InterruptedException {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		AlertsPage alertsPage = alertsFramePage.clickOnAlertsBtn();
		alertsPage.clickOnAlertAfterBtn();
	}
	
	@Test
	public void clickOnAlertConfirmTest() throws InterruptedException {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		AlertsPage alertsPage = alertsFramePage.clickOnAlertsBtn();
		alertsPage.clickOnAlertConfirmBtn();
		Assert.assertEquals(alertsPage.returnTextSuccess(), "You selected Cancel");
	}
	
	@Test
	public void clickOnAlertPromtTest() throws InterruptedException {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		AlertsPage alertsPage = alertsFramePage.clickOnAlertsBtn();
		alertsPage.clickOnAlertPromptBtn();
		Assert.assertEquals(alertsPage.returnPromptSuccess(), "You entered Rodri");
	}
}
