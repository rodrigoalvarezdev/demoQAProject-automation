package com.demoQa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class LinksPage extends Base {
	@FindBy(id = "simpleLink") WebElement homeLink;
	@FindBy(id = "dynamicLink") WebElement dynamicLink;
	@FindBy(id = "created") WebElement createdLink;
	@FindBy(id = "no-content") WebElement noContentLink;
	@FindBy(id = "moved") WebElement movedLink;
	@FindBy(id = "bad-request") WebElement badRequestLink;
	@FindBy(id = "unauthorized") WebElement unauthorizedLink;
	@FindBy(id = "forbidden") WebElement forbiddenLink;
	@FindBy(id = "invalid-url") WebElement notFoundLink;
	@FindBy(xpath = "//a[contains(@href, 'javascript')]") List<WebElement> linkList;
	@FindBy(xpath = "//a[contains(@href, 'https://demoqa.com')]") List<WebElement> linksResponseList;
	@FindBy(css = "p#linkResponse b:nth-child(2)") WebElement resultResponse;
	
	
	public LinksPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public IndexPage clickOnHomeLink() {
		Action.explicitWait(homeLink);
		Action.click(homeLink);
		Action.changeFocus();
		return new IndexPage();
	}
	
	public IndexPage clickOnDynamicLink() {
		Action.explicitWait(dynamicLink);
		Action.click(dynamicLink);
		Action.changeFocus();
		return new IndexPage();
	}
	
	public void linksResponse() {
		Action.testLinks(linksResponseList, "href");
	}
	
	/*public String returnResponse() {
		return resultResponse.getText();
	}*/
	
	public void links() throws InterruptedException {
		for(WebElement i: linkList) {
			Action.scrollByVisibilityOfElement(driver.get(), i);
			Action.click(i);
			Thread.sleep(500);
			Action.explicitWait(resultResponse);
			Assert.assertTrue(resultResponse.isDisplayed());
		}
	}
}
