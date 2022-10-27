package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.AlertsFramePage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.ModalPage;

public class ModalPageTest extends Base {
	@Test
	public void clickOnSmallModalTest() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		ModalPage modalPage = alertsFramePage.clickOnModalBtn();
		modalPage.clickOnSmallModal();
		Assert.assertEquals(modalPage.returnSmallTitle(), "Small Modal");
		modalPage.clickOnCloseSmallModal();
		Assert.assertEquals(modalPage.returnPrincipalTitle(), "Click on button to see modal");
	}
	
	@Test
	public void clickOnLargeModalTest() {
		IndexPage indexPage = new IndexPage();
		AlertsFramePage alertsFramePage = indexPage.clickAlertsFrame();
		ModalPage modalPage = alertsFramePage.clickOnModalBtn();
		modalPage.clickOnLargeModal();;
		Assert.assertEquals(modalPage.returnLargeTitle(), "Large Modal");
		modalPage.clickOnCloseLargeModal();
		Assert.assertEquals(modalPage.returnPrincipalTitle(), "Click on button to see modal");
	}
}
