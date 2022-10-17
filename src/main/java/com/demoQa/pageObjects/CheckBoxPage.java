package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class CheckBoxPage extends Base {
	@FindBy(xpath = "//span[text()='Home']//ancestor::li/span/button") WebElement homeToggle;
	@FindBy(xpath = "//span[text()='Desktop']//ancestor::span/button") WebElement desktopToggle;
	@FindBy(xpath = "//span[text()='Documents']//ancestor::span/button") WebElement documentsToggle;
	@FindBy(xpath = "//span[text()='Downloads']//ancestor::span/button") WebElement downloadsToggle;
	@FindBy(xpath = "//span[text()='Notes']//parent::label") WebElement NotesCheckBox;
	@FindBy(xpath = "//span[text()='Commands']") WebElement commandsCheckBox;
	@FindBy(xpath = "//span[text()='WorkSpace']//ancestor::span/button") WebElement workspaceToggle;
	@FindBy(xpath = "//span[text()='Office']//ancestor::span/button") WebElement officeToggle;
	@FindBy(xpath = "//span[text()='Word File.doc']") WebElement wordCheckBox;
	@FindBy(xpath = "//span[text()='Excel File.doc']") WebElement excelCheckBox;
	@FindBy(css = "span.text-success") WebElement textSuccess;
	
	public CheckBoxPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void checkOnCommand() {
		Action.explicitWait(homeToggle);
		Action.click(homeToggle);
		Action.explicitWait(desktopToggle);
		Action.click(desktopToggle);
		Action.explicitWait(commandsCheckBox);
		Action.click(commandsCheckBox);
	}
	
	public String returnTextSucces() {
		Action.explicitWait(textSuccess);
		return Action.returnText(textSuccess);
	}
	
	public void checkOnExcel() {
		Action.explicitWait(homeToggle);
		Action.click(homeToggle);
		Action.explicitWait(downloadsToggle);
		Action.click(downloadsToggle);
		Action.scrollByVisibilityOfElement(driver.get(), excelCheckBox);
		Action.explicitWait(excelCheckBox);
		Action.click(excelCheckBox);
	}
	

	
}
