package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class ModalPage extends Base {
	@FindBy(xpath = "//*[text()='Click on button to see modal']") WebElement principalTitle;
	@FindBy(id = "showSmallModal") WebElement openSmallModalBtn;
	@FindBy(id = "example-modal-sizes-title-sm") WebElement smallModalTitle;
	@FindBy(id = "closeSmallModal") WebElement closeSmallModalBtn;
	@FindBy(id = "showLargeModal") WebElement openLargeModalBtn;
	@FindBy(id = "example-modal-sizes-title-lg") WebElement largeModalTitle;
	@FindBy(id = "closeLargeModal") WebElement closeLargeModalBtn;
	
	public ModalPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnSmallModal() {
		Action.waitClickeable(openSmallModalBtn);
		Action.click(openSmallModalBtn);
		Action.explicitWait(smallModalTitle);
	}
	
	public void clickOnCloseSmallModal() {
		Action.click(closeSmallModalBtn);
		Action.explicitWait(principalTitle);
	}
	
	public String returnSmallTitle() {
		return Action.returnText(smallModalTitle);
	}
	
	public String returnPrincipalTitle() {
		return Action.returnText(principalTitle);
	}
	
	public void clickOnLargeModal() {
		Action.waitClickeable(openLargeModalBtn);
		Action.click(openLargeModalBtn);
		Action.explicitWait(largeModalTitle);
	}
	
	public void clickOnCloseLargeModal() {
		Action.click(closeLargeModalBtn);
		Action.explicitWait(principalTitle);
	}
	
	public String returnLargeTitle() {
		return Action.returnText(largeModalTitle);
	}
}
