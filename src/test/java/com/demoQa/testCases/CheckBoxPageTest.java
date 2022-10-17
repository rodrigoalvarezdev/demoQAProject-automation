package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.CheckBoxPage;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;

public class CheckBoxPageTest extends Base {
	@Test(description = "validar checkbox commands", enabled = true, groups = "sanity")
	public void checkCommandsTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		CheckBoxPage checkBoxPage = elementsPage.clickOncheckBox();
		checkBoxPage.checkOnCommand();
		Assert.assertEquals("commands", checkBoxPage.returnTextSucces(), "El texto no coincide");
	}
	
	@Test(description = "validar checkbox excelFile", enabled = true, groups = "sanity")
	public void checkOnDownloadTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		CheckBoxPage checkBoxPage = elementsPage.clickOncheckBox();
		checkBoxPage.checkOnExcel();
		Assert.assertEquals("excelFile", checkBoxPage.returnTextSucces(), "El texto no coincide");
	}
}
