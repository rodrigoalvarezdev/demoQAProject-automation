package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class AlertsPage extends Base {
	@FindBy(id = "alertButton") WebElement alertBtn;
	@FindBy(id = "timerAlertButton") WebElement alertAfterBtn;
	@FindBy(id = "confirmButton") WebElement alertConfirmBtn;
	@FindBy(id = "promtButton") WebElement alertPromptBtn;
	@FindBy(id = "confirmResult") WebElement confimResult;
	@FindBy(id = "promptResult") WebElement promptResult;
	
	public AlertsPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clickOnAlertBtn1() throws InterruptedException {
		Action.explicitWait(alertBtn);
		Action.click(alertBtn);
		Thread.sleep(100);
		driver.get().switchTo().alert().accept();
	}
	
	public void clickOnAlertAfterBtn() throws InterruptedException {
		Action.explicitWait(alertAfterBtn);
		Action.click(alertAfterBtn);
		Thread.sleep(5000);
		driver.get().switchTo().alert().accept();
	}
	
	public void clickOnAlertConfirmBtn() throws InterruptedException {
		Action.explicitWait(alertConfirmBtn);
		Action.click(alertConfirmBtn);
		Thread.sleep(100);
		driver.get().switchTo().alert().dismiss();
		driver.get().switchTo().activeElement();
	}
	
	public String returnTextSuccess() {
		Action.explicitWait(confimResult);
		return Action.returnText(confimResult);
	}
	
	public void clickOnAlertPromptBtn() throws InterruptedException {
		Action.explicitWait(alertPromptBtn);
		Action.click(alertPromptBtn);
		Thread.sleep(200);
		driver.get().switchTo().alert().sendKeys("Rodri");
		driver.get().switchTo().alert().accept();
		driver.get().switchTo().activeElement();
	}
	
	public String returnPromptSuccess() {
		Action.explicitWait(promptResult);
		return Action.returnText(promptResult);
	}
}
