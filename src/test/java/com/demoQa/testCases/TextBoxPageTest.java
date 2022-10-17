package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.TextBoxPage;
import com.demoQa.utils.DataProviderClass;

public class TextBoxPageTest extends Base {
	@Test(description = "validar inputs de form", enabled = true, dataProvider = "dataTextBox", dataProviderClass = DataProviderClass.class, groups = "regression")
	public void textBoxTest(String user, String email, String current, String permanent){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
		textBoxPage.completeTextBox(user, email, current, permanent);
		Assert.assertEquals(textBoxPage.returnName(), textBoxPage.returnValueName(), "El nombre no coincide");
		Assert.assertEquals(textBoxPage.returnEmail(), textBoxPage.returnValueEmail(), "El email no coincide");
	}
}
