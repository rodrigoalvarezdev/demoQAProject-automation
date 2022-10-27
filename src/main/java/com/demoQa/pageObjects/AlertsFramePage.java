package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class AlertsFramePage extends Base {
	@FindBy(xpath = "//span[text()='Browser Windows']") WebElement browserWinBtn;
	@FindBy(xpath = "//span[text()='Alerts']") WebElement alertsBtn;
	@FindBy(xpath = "//span[text()='Frames']") WebElement framesBtn;
	@FindBy(xpath = "//span[text()='Nested Frames']") WebElement nestedFrameBtn;
	@FindBy(xpath = "//span[text()='Modal Dialogs']") WebElement modalDialBtn;
	
	public AlertsFramePage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public BrowserWinPage clickOnBrowserWinBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), browserWinBtn);
		Action.explicitWait(browserWinBtn);
		Action.click(browserWinBtn);
		return new BrowserWinPage();
	}
	
	public AlertsPage clickOnAlertsBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), alertsBtn);
		Action.explicitWait(alertsBtn);
		Action.click(alertsBtn);
		return new AlertsPage();
	}
	
	public FramesPage clickOnFramesBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), framesBtn);
		Action.explicitWait(framesBtn);
		Action.click(framesBtn);
		return new FramesPage();
	}
	
	public NestedFramesPage clickOnNestedFramesBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), nestedFrameBtn);
		Action.explicitWait(nestedFrameBtn);
		Action.click(nestedFrameBtn);
		return new NestedFramesPage();
	}
	
	public ModalPage clickOnModalBtn() {
		Action.scrollByVisibilityOfElement(driver.get(), modalDialBtn);
		Action.explicitWait(modalDialBtn);
		Action.click(modalDialBtn);
		return new ModalPage();
	}
}
