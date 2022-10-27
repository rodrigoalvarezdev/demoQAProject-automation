package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class FormsPage extends Base{
	@FindBy(xpath = "//span[text()='Practice Form']//ancestor::ul") WebElement pracFormBtn;
	@FindBy(id = "firstName") WebElement nameInput;
	@FindBy(id = "lastName") WebElement lastNameInput;
	@FindBy(id = "userEmail") WebElement emailInput;
	@FindBy(css = "label[for='gender-radio-1']") WebElement maleRadioBtn;
	@FindBy(css = "*.custom-control.custom-radio.custom-control-inline input[value='Female']") WebElement femaleRadioBtn;
	@FindBy(css = "*.custom-control.custom-radio.custom-control-inline input[value='Other']") WebElement otherRadioBtn;
	@FindBy(id = "userNumber") WebElement mobileInput;
	@FindBy(id = "dateOfBirthInput") WebElement birthDayInput;
	@FindBy(css = "select.react-datepicker__month-select") WebElement monthSelect;
	@FindBy(css = "select.react-datepicker__year-select") WebElement yearSelect;
	@FindBy(css = "*.react-datepicker__day.react-datepicker__day--024") WebElement dayData;
	@FindBy(id = "subjectsInput") WebElement subjectsInput;
	@FindBy(css = "label[for='hobbies-checkbox-1']") WebElement sportCheckBox;
	@FindBy(css = "*.custom-control.custom-checkbox.custom-control-inline input[value='2']") WebElement readingCheckBox;
	@FindBy(css = "*.custom-control.custom-checkbox.custom-control-inline input[value='3']") WebElement musicCheckBox;
	@FindBy(id = "uploadPicture") WebElement uploadFileBtn;
	@FindBy(id = "currentAddress") WebElement currentAddressInput;
	@FindBy(xpath = "//*[text()='Thanks for submitting the form']") WebElement modalResult;
	
	public FormsPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnPractice() {
		Action.explicitWait(pracFormBtn);
		Action.click(pracFormBtn);
	}
	
	public void completeForms(String name, String lastname, String email, String mobile, String address, String monthNumber, String year
							  ,String subject) {
		Action.explicitWait(nameInput);
		Action.sendText(nameInput, name);
		Action.sendText(lastNameInput, lastname);
		Action.sendText(emailInput, email);
		//Action.click(femaleRadioBtn);
		maleRadioBtn.click();
		Action.sendText(mobileInput, mobile);
		Action.scrollByVisibilityOfElement(driver.get(), birthDayInput);
		Action.click(birthDayInput);
		Action.explicitWait(yearSelect);
		Action.selectValue(yearSelect, year);
		//Action.explicitWait(monthSelect);
		Action.selectValue(monthSelect, monthNumber);
		Action.explicitWait(dayData);
		Action.click(dayData);
		Action.click(subjectsInput);
		Action.sendText(subjectsInput, subject);
		Action.enterBtn(subjectsInput);
		//Action.click(sportCheckBox);
		sportCheckBox.click();
		uploadFileBtn.sendKeys("C:\\Users\\admin\\eclipse-workspace\\demoQaProyect\\dataset\\demoQaExcel.xlsx");
		Action.sendText(currentAddressInput, address);
		Action.click(subjectsInput);
		Action.enterBtn(subjectsInput);
	}
	
	public WebElement modal() {
		Action.explicitWait(modalResult);
		return modalResult;
	}
}
