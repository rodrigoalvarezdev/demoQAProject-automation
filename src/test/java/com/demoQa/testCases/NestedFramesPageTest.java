package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.AlertsFramePage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.NestedFramesPage;

public class NestedFramesPageTest extends Base {
	@Test
	public void verifyTitleChildTest() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		NestedFramesPage nestedframesPage = alertsFramePage.clickOnNestedFramesBtn();
		nestedframesPage.verifyTitleChildFrame();
		Assert.assertEquals(nestedframesPage.returnTitleChild(), "Child Iframe");
	}
	
	@Test
	public void verifyParentFrameAndText() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		NestedFramesPage nestedframesPage = alertsFramePage.clickOnNestedFramesBtn();
		nestedframesPage.verifyParentFrame();
		Assert.assertTrue(nestedframesPage.returnDivText().isDisplayed());
	}
}
