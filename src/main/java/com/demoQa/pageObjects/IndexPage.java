package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class IndexPage extends Base {
	@FindBy(xpath = "//h5[text()='Elements']") WebElement elementsBtn;
	@FindBy(xpath = "//h5[text()='Forms']") WebElement formsBtn;
	@FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']") WebElement alertsFrameBtn;
	@FindBy(xpath = "//h5[text()='Widgets']") WebElement widgetsBtn;
	@FindBy(xpath = "//h5[text()='Interations']") WebElement interationsBtn;
	@FindBy(xpath = "//h5[text()='Book Store Application']") WebElement bookStoreBtn;
	@FindBy(css = "img[src='/images/Toolsqa.jpg']") WebElement titleIndex;
	
	public IndexPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public ElementsPage clickElementsBtn() {
		Action.explicitWait(elementsBtn);
		Action.waitClickeable(elementsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), elementsBtn);
		Action.click(elementsBtn);
		return new ElementsPage();
	}
	
	public FormsPage clickForms() {
		Action.explicitWait(formsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), formsBtn);
		Action.click(formsBtn);
		return new FormsPage();
	}
	
	public AlertsFramePage clickAlertsFrame() {
		Action.explicitWait(alertsFrameBtn);
		Action.scrollByVisibilityOfElement(driver.get(), elementsBtn);
		Action.click(alertsFrameBtn);
		return new AlertsFramePage();
	}
	
	public void clickWidgets() {
		Action.explicitWait(widgetsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), widgetsBtn);
		Action.click(widgetsBtn);
	}
	
	public void clickInterations() {
		Action.explicitWait(interationsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), interationsBtn);
		Action.click(interationsBtn);
	}
	
	public void clickBookStore() {
		Action.explicitWait(elementsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), elementsBtn);
		Action.click(bookStoreBtn);
	}
	
	public WebElement returnTitleIndex() {
		Action.explicitWait(titleIndex);
		return titleIndex;
	}
}
