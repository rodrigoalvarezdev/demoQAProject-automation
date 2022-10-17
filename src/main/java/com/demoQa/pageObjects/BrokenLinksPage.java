package com.demoQa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class BrokenLinksPage extends Base{
	@FindBy(css = "*.col-12.mt-4.col-md-6 img") List<WebElement> imgList;
	@FindBy(css = "*.col-12.mt-4.col-md-6 a") List<WebElement> linkList;
	
	public BrokenLinksPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void checkImg() {
		Action.testLinks(imgList, "src");
	}
	
	public void checkLink() {
		Action.testLinks(linkList, "href");
	}
}
