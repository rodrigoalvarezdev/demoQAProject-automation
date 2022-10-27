package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class BrowserWinPage extends Base {
	@FindBy(id = "tabButton") WebElement newTabBtn;
	@FindBy(id = "windowButton") WebElement newWindowBtn;
	@FindBy(id = "messageWindowButton") WebElement newWinMsgeBtn;
	@FindBy(id = "sampleHeading") WebElement resultTitle;
	@FindBy(xpath = "//body[text()='Knowledge increases by sharing "
			+ "but not by saving. Please share this website with your "
			+ "friends and in your organization.']") WebElement textResult;
	
	public BrowserWinPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnNewTabBtn() {
		Action.explicitWait(newTabBtn);
		Action.click(newTabBtn);
		Action.changeFocus();
		Action.explicitWait(resultTitle);
	}
	
	public String returnTitle() {
		return resultTitle.getText();
	}
	
	public void clickOnNewWindowBtn() {
		Action.explicitWait(newWindowBtn);
		Action.click(newWindowBtn);
		Action.changeFocus();
		Action.explicitWait(resultTitle);
	}
	
	public void clickOnNewWindowMsgeBtn() {
		Action.explicitWait(newWinMsgeBtn);
		Action.click(newWinMsgeBtn);
		Action.changeFocus();
		Action.explicitWait(textResult);
	}
}
