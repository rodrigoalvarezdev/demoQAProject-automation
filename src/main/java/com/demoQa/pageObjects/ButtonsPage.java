package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class ButtonsPage extends Base {
	@FindBy(xpath = "//button[text()='Double Click Me']") WebElement doubleClicBtn;
	@FindBy(xpath = "//button[text()='Right Click Me']") WebElement rightClickBtn;
	@FindBy(xpath = "//button[text()='Click Me']") WebElement leftClickBtn;
	@FindBy(id = "doubleClickMessage") WebElement doubleClickMge;
	@FindBy(id = "rightClickMessage") WebElement rightClickMge;
	@FindBy(id = "dynamicClickMessage") WebElement leftClickMge;
	
	ButtonsPage(){
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnDoubleClick() {
		//Action.explicitWait(doubleClicBtn);
		Action.waitClickeable(doubleClicBtn);
		Action.doubleClick(doubleClicBtn);
	}
	
	public void clickOnRightClick() {
		Action.explicitWait(rightClickBtn);
		Action.rightClick(rightClickBtn);
	}
	
	public void clickOndynamicBtn() {
		Action.explicitWait(leftClickBtn);
		Action.click(leftClickBtn);
	}
	
	public String returnDoubleMge() {
		Action.explicitWait(doubleClickMge);
		return Action.returnText(doubleClickMge);
	}
	
	public String returnRightMge() {
		Action.explicitWait(rightClickMge);
		return Action.returnText(rightClickMge);
	}
	
	public String returnDynamicMge() {
		Action.explicitWait(leftClickMge);
		return Action.returnText(leftClickMge);
	}
}
