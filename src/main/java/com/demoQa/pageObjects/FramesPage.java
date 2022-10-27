package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class FramesPage extends Base {
	@FindBy(id = "frame1") WebElement frame1;
	@FindBy(id = "sampleHeading") WebElement titleFrame1;
	@FindBy(id = "frame2") WebElement frame2;
	
	public FramesPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void switchFrame1() {
		Action.explicitWait(frame1);
		driver.get().switchTo().frame(frame1);
	}
	
	public String returnTitleFrame() {
		Action.explicitWait(titleFrame1);
		return Action.returnText(titleFrame1);
	}
	
	public void switchFrame2() {
		Action.scrollByVisibilityOfElement(driver.get(), frame2);
		Action.explicitWait(frame2);
		driver.get().switchTo().frame(frame2);
	}
}
