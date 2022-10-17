package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ButtonsPage;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;

public class ButtonsPageTest extends Base {
	@Test(description = "validar hacer doble click", groups = "sanity", enabled = true)
	public void doubleClickTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		ButtonsPage buttonsPage = elementsPage.clickOnButtons();
		buttonsPage.clickOnDoubleClick();
		Assert.assertEquals(buttonsPage.returnDoubleMge(), "You have done a double click", "El texto no coincide");
	}
	
	@Test(description = "validar hacer click derecho", groups = "sanity", enabled = true)
	public void rightClickTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		ButtonsPage buttonsPage = elementsPage.clickOnButtons();
		buttonsPage.clickOnRightClick();
		Assert.assertEquals(buttonsPage.returnRightMge(), "You have done a right click", "El texto no coincide");
	}
	
	@Test(description = "validar hacer click en boton dinamico", groups = "sanity", enabled = true)
	public void dynamicClickTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		ButtonsPage buttonsPage = elementsPage.clickOnButtons();
		buttonsPage.clickOndynamicBtn();;
		Assert.assertEquals(buttonsPage.returnDynamicMge(), "You have done a dynamic click", "El texto no coincide");
	}
}
