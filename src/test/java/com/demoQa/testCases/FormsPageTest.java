package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.FormsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.utils.DataProviderClass;

public class FormsPageTest extends Base {
	@Test(dataProvider = "formData", dataProviderClass = DataProviderClass.class)
	public void completeFormsTest(String nombre, String apellido, String email, String celu, String direccion, String mesNum, String anio, String materia) {
		IndexPage indexPage = new IndexPage();
		FormsPage formsPage = indexPage.clickForms();
		formsPage.clickOnPractice();
		formsPage.completeForms(nombre, apellido, email, celu, direccion, mesNum, anio, materia);
		Assert.assertTrue(formsPage.modal().isDisplayed());
	}
}
