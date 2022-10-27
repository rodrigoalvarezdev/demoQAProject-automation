package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class NestedFramesPage extends Base {
	@FindBy(id = "frame1") WebElement parentFrame;
	@FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']") WebElement childFrame;
	@FindBy(xpath = "//*[@id='framesWrapper']/div[1]") WebElement divText;
	@FindBy(xpath = "//p[text()='Child Iframe']") WebElement titleChildFrame;
	
	public NestedFramesPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void verifyTitleChildFrame() {
		Action.explicitWait(parentFrame);
		driver.get().switchTo().frame(parentFrame);
		driver.get().switchTo().frame(childFrame);
		Action.explicitWait(titleChildFrame);
	}
	
	public String returnTitleChild() {
		return Action.returnText(titleChildFrame);
	}
	
	public void verifyParentFrame() {
		Action.explicitWait(parentFrame);
		driver.get().switchTo().frame(parentFrame);
		driver.get().switchTo().parentFrame();
		Action.explicitWait(divText);
	}
	
	public WebElement returnDivText() {
		return divText;
	}
}
