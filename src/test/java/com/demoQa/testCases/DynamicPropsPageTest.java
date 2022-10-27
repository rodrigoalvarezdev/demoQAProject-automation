package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.DynamicPropsPage;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;

public class DynamicPropsPageTest extends Base {
	@Test
	public void assertDynamicText() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		DynamicPropsPage dynamicPropsPage = elementsPage.clickOnDinamicProps();
		Assert.assertEquals(dynamicPropsPage.returnTextDynamic(), "This text has random Id", "el texto no coincide");
	}
	
	@Test
	public void clickOnEnableTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		DynamicPropsPage dynamicPropsPage = elementsPage.clickOnDinamicProps();
		dynamicPropsPage.clickOnEnableBtn();
	}
	
	@Test
	public void clickOnVisibilityTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		DynamicPropsPage dynamicPropsPage = elementsPage.clickOnDinamicProps();
		dynamicPropsPage.clickOnVisibleBtn();
	}
}
