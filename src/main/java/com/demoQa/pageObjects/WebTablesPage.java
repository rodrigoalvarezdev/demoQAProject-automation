package com.demoQa.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class WebTablesPage extends Base {
	@FindBy(id = "addNewRecordButton") WebElement addBtn;
	@FindBy(id ="searchBox") WebElement searchBox;
	@FindBy(id = "basic-addon2") WebElement searchBtn;
	@FindBy(id = "delete-record-1") WebElement deleteFirst;
	@FindBy(id = "submit") WebElement submitBtn;
	@FindBy(id = "firstName") WebElement firstNameInput;
	@FindBy(id = "lastName") WebElement lastNameInput;
	@FindBy(id = "userEmail") WebElement emailInput;
	@FindBy(id = "age") WebElement ageInput;
	@FindBy(id = "salary") WebElement salaryInput;
	@FindBy(id = "department") WebElement departmentInput;
	@FindBy(xpath = "//*[text()='Cierra']") WebElement searchAssert;
	@FindBy(css = "*.rt-td") List<WebElement> itemTable;
	
	
	public WebTablesPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnAdd() {
		Action.click(addBtn);
	}
	
	public void formUser(String name, String lastname, String email, String age, String salary, String department) {
		Action.explicitWait(firstNameInput);
		Action.sendText(firstNameInput, name);
		Action.sendText(lastNameInput, lastname);
		Action.sendText(emailInput, email);
		Action.sendText(ageInput, age);
		Action.sendText(salaryInput, salary);
		Action.sendText(departmentInput, department);
		Action.click(submitBtn);
	}
	
	public String returnMailAssert() {
		int index = 0;
		for(WebElement i: itemTable) {
			if(!i.getText().isBlank()) {
				index = index +1;
			}
		}
		WebElement a = itemTable.get(index);
		return a.getText();
	}
	
	public void clickOnEdit(String pos) {
		Action.explicitWait(driver.get().findElement(By.id(Action.editFieldPosition(pos))));
		//Actions.waitClickeable(driver.get().findElement(By.id(Actions.editFieldPosition(pos))));
		Action.scrollByVisibilityOfElement(driver.get(), driver.get().findElement(By.id(Action.editFieldPosition(pos))));
		Action.click(driver.get().findElement(By.id(Action.editFieldPosition(pos))));
	}
	
	public void clickOnDelete(String pos) {
		Action.explicitWait(driver.get().findElement(By.id(Action.deleteFieldPosition(pos))));
		Action.waitClickeable(driver.get().findElement(By.id(Action.deleteFieldPosition(pos))));
		Action.click(driver.get().findElement(By.id(Action.deleteFieldPosition(pos))));
	}
	
	public void searchUser(String user) {
		Action.explicitWait(searchBox);
		Action.sendText(searchBox, user);
		Action.click(searchBtn);
	}
	
	public String searchaAsserts() {
		return searchAssert.getText();
	}
}
