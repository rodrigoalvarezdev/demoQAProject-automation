package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.RadioButtonPage;

public class RadioButtonPageTest extends Base {
	@Test(description = "verificar radio button 'yes'", enabled = true, groups = "smoke")
	public void clickOnYesRadioButtonTest(){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		RadioButtonPage radioButtonPage = elementsPage.clickOnRadioBtn();
		radioButtonPage.clickOnYesRadio();
		Assert.assertEquals("Yes", radioButtonPage.returnTextSuccess(), "El texto no coincide");
	}
	
	@Test(description = "verificar radio button 'yes'", enabled = true, groups = "smoke")
	public void clickOnImpressiveButtonTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		RadioButtonPage radioButtonPage = elementsPage.clickOnRadioBtn();
		radioButtonPage.clickOnInpressiveRadio();
		Assert.assertEquals("Impressive", radioButtonPage.returnTextSuccess(), "El texto no coincide");
	}
	
	@Test(description = "verificar radio button 'yes'", enabled = true, groups = "smoke")
	public void clickOnNoRadioButtonTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		RadioButtonPage radioButtonPage = elementsPage.clickOnRadioBtn();
		radioButtonPage.clickOnNoRadio();
		
	}
}
