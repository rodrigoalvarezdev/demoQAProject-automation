package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.AlertsFramePage;
import com.demoQa.pageObjects.FramesPage;
import com.demoQa.pageObjects.IndexPage;

public class FramesPageTest extends Base {
	@Test
	public void enterFrame1() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		FramesPage framesPage = alertsFramePage.clickOnFramesBtn();
		framesPage.switchFrame1();
		Assert.assertEquals(framesPage.returnTitleFrame(), "This is a sample page");
	}
	
	@Test
	public void enterFrame2() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		FramesPage framesPage = alertsFramePage.clickOnFramesBtn();
		framesPage.switchFrame2();
		Assert.assertEquals(framesPage.returnTitleFrame(), "This is a sample page");
	}
}
