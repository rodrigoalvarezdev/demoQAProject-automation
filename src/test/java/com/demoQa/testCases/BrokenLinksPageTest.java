package com.demoQa.testCases;

import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.BrokenLinksPage;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;

public class BrokenLinksPageTest extends Base {
	@Test(description = "validar src de imagenes", enabled = true)
	public void imgLinksTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		BrokenLinksPage brokenLinksPage = elementsPage.clickOnBrokensLinks();
		brokenLinksPage.checkImg();
	}
	
	@Test(description = "validar response de links", enabled = true)
	public void LinksTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		BrokenLinksPage brokenLinksPage = elementsPage.clickOnBrokensLinks();
		brokenLinksPage.checkLink();
	}
}
