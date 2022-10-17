package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class TextBoxPage extends Base {
	@FindBy(id = "userName") WebElement userNameInput;
	@FindBy(id = "userEmail") WebElement userEmailInput;
	@FindBy(id = "currentAddress") WebElement currentAddressInput;
	@FindBy(id = "permanentAddress") WebElement permanentAddressInput;
	@FindBy(id = "submit") WebElement submitBtn;
	@FindBy(id = "name") WebElement nameResult;
	@FindBy(id = "email") WebElement emailResult;
	@FindBy(id = "currentAddress") WebElement currentResult;
	@FindBy(id = "permanentAddress") WebElement permanentResult;
	
	public TextBoxPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void completeTextBox(String user, String email, String current, String permanent) {
		Action.sendText(userNameInput, user);
		Action.sendText(userEmailInput, email);
		Action.sendText(currentAddressInput, current);
		Action.sendText(permanentAddressInput, permanent);
		Action.scrollByVisibilityOfElement(driver.get(), submitBtn);
		Action.click(submitBtn);
	}
	
	public String returnName() {
		return Action.returnTextSplit(nameResult, ":", 1);
	}
	
	public String returnValueName() {
		return Action.returnTextValue(userNameInput);
	}
	
	public String returnEmail() {
		return Action.returnTextSplit(emailResult, ":", 1);
	}
	
	public String returnValueEmail() {
		return Action.returnTextValue(userEmailInput);
	}
	
}
