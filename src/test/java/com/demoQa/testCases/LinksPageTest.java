package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.LinksPage;

public class LinksPageTest extends Base {
	@Test(description = "validar cambiar foco de pestaña", enabled = true, groups = "sanity")
	public void clickOnHomeLinkTest() {
		IndexPage indexpage = new IndexPage();
		ElementsPage elementsPage = indexpage.clickElementsBtn();
		LinksPage linksPage = elementsPage.clickOnlinks();
		IndexPage indexPage = linksPage.clickOnHomeLink();
		Assert.assertTrue(indexPage.returnTitleIndex().isDisplayed());
	}
	
	@Test(description = "validar response de link", enabled = true, groups = "regression")
	public void linksResponseTest() {
		IndexPage indexpage = new IndexPage();
		ElementsPage elementsPage = indexpage.clickElementsBtn();
		LinksPage linksPage = elementsPage.clickOnlinks();
		linksPage.linksResponse();
	}
	
	@Test(description = "validar respuestas en la misma page", enabled = true, groups = "regression")
	public void linksTest() throws InterruptedException {
		IndexPage indexpage = new IndexPage();
		ElementsPage elementsPage = indexpage.clickElementsBtn();
		LinksPage linksPage = elementsPage.clickOnlinks();
		linksPage.links();
	}
}
