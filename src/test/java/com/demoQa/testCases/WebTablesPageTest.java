package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.WebTablesPage;
import com.demoQa.utils.DataProviderClass;

public class WebTablesPageTest extends Base{
	@Test(description = "validar nuevo usuario", enabled = true, dataProvider = "webTableData", dataProviderClass = DataProviderClass.class, groups = "regression")
	public void addNewUsertest(String nombre, String apellido, String mail, String edad, String salario, String area){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		WebTablesPage webTablesPage = elementsPage.clickOnWebTables();
		webTablesPage.clickOnAdd();
		webTablesPage.formUser(nombre, apellido, mail, edad, salario, area);
		Assert.assertEquals("rodri@gmail.com", webTablesPage.returnMailAssert(), "El texto no coincide");
	}
	
	@Test(description = "validar edicion de usuario", enabled = true, dataProvider = "webTableData", dataProviderClass = DataProviderClass.class, groups = "regression")
	public void editUserTest(String nombre, String apellido, String mail, String edad, String salario, String area){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		WebTablesPage webTablesPage = elementsPage.clickOnWebTables();
		webTablesPage.clickOnEdit("3");
		webTablesPage.formUser(nombre, apellido, mail, edad, salario, area);
		//Assert.assertEquals(webTablesPage.returnMailAssert(), webTablesPage.returnMailAssert(), "El texto no coincide");
	}
	
	@Test(description = "validar borrar usuario", enabled = true, groups = "regression")
	public void deleteUserTest(){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		WebTablesPage webTablesPage = elementsPage.clickOnWebTables();
		webTablesPage.clickOnDelete("2");
		Assert.assertEquals("Legal", webTablesPage.returnMailAssert(), "El texto no coincide");
	}
	
	@Test(description = "validar buscar usuario", enabled = true, groups = "regression")
	public void searchUsetTest(){
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		WebTablesPage webTablesPage = elementsPage.clickOnWebTables();
		webTablesPage.searchUser("Cierra");
		Assert.assertEquals("Cierra", webTablesPage.searchaAsserts());
	}
}
