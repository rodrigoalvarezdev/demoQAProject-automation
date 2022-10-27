package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class DynamicPropsPage extends Base {
	@FindBy(xpath = "//p[text()='This text has random Id']") WebElement textRamdomId;
	@FindBy(id = "enableAfter") WebElement enableFiveSecsBtn;
	@FindBy(id = "colorChange") WebElement colorChangeBtn;
	@FindBy(id = "visibleAfter") WebElement visibleFiveSecsBtn;
	
	public DynamicPropsPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public String returnTextDynamic() {
		Action.explicitWait(textRamdomId);
		return Action.returnText(textRamdomId);
	}
		
	public void clickOnEnableBtn() {
		Action.explicitWait(enableFiveSecsBtn);
		Action.waitClickeable(enableFiveSecsBtn);
		Action.click(enableFiveSecsBtn);
	}
	
	public void clickOnVisibleBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), visibleFiveSecsBtn);
		Action.explicitWait(visibleFiveSecsBtn);
		Action.waitVisibility(visibleFiveSecsBtn);
		Action.click(visibleFiveSecsBtn);
	}
}
