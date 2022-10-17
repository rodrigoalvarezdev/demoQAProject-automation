package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class RadioButtonPage extends Base {
	@FindBy(css = "label[for='yesRadio']") WebElement yesRadioButton;
	@FindBy(css = "label[for='impressiveRadio']") WebElement inpressiveRadioButton;
	@FindBy(css = "label[for='noRadio']") WebElement noRadioButton;
	@FindBy(css = "span.text-success") WebElement textSuccess;
	
	RadioButtonPage(){
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnYesRadio() {
		Action.explicitWait(yesRadioButton);
		Action.clickOnRadioButton(yesRadioButton);
	}
	
	public String returnTextSuccess() {
		Action.explicitWait(textSuccess);
		return Action.returnText(textSuccess);
	}
	
	public void clickOnInpressiveRadio() {
		Action.explicitWait(inpressiveRadioButton);
		Action.clickOnRadioButton(inpressiveRadioButton);
	}
	
	public void clickOnNoRadio() {
		Action.explicitWait(noRadioButton);
		Action.clickOnRadioButton(noRadioButton);
	}
}
