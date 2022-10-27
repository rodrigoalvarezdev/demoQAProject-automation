package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class ElementsPage extends Base {
	@FindBy(xpath = "//span[text()='Text Box']") WebElement textBoxBtn;
	@FindBy(xpath = "//span[text()='Check Box']") WebElement checkBoxBtn;
	@FindBy(xpath = "//span[text()='Radio Button']") WebElement radioBtn;
	@FindBy(xpath = "//span[text()='Web Tables']") WebElement tablesBtn;
	@FindBy(xpath = "//span[text()='Buttons']") WebElement buttonsBtn;
	@FindBy(xpath = "//span[text()='Links']") WebElement linksBtn;
	@FindBy(xpath = "//span[text()='Broken Links - Images']") WebElement brokenLinksBtn;
	@FindBy(xpath = "//span[text()='Upload and Download']") WebElement uploadDownBtn;
	@FindBy(xpath = "//span[text()='Dynamic Properties']") WebElement dinamicPropBtn;
	
	public ElementsPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public TextBoxPage clickOnTextBox() {
		Action.explicitWait(textBoxBtn);
		Action.waitClickeable(tablesBtn);
		Action.click(textBoxBtn);
		return new TextBoxPage();
	}
	
	public CheckBoxPage clickOncheckBox() {
		Action.explicitWait(checkBoxBtn);
		Action.click(checkBoxBtn);
		return new CheckBoxPage();
	}
	
	public RadioButtonPage clickOnRadioBtn() {
		Action.explicitWait(radioBtn);
		Action.click(radioBtn);
		return new RadioButtonPage();
	}
	
	public WebTablesPage clickOnWebTables() {
		Action.explicitWait(tablesBtn);
		Action.scrollByVisibilityOfElement(driver.get(), tablesBtn);
		//Actions.waitClickeable(tablesBtn);
		Action.click(tablesBtn);
		return new WebTablesPage();
	}
	
	public ButtonsPage clickOnButtons() {
		Action.explicitWait(buttonsBtn);
		Action.scrollByVisibilityOfElement(driver.get(), buttonsBtn);
		Action.click(buttonsBtn);
		return new ButtonsPage();
	}
	
	public LinksPage clickOnlinks() {
		Action.scrollByVisibilityOfElement(driver.get(), linksBtn);
		Action.explicitWait(linksBtn);
		Action.click(linksBtn);
		return new LinksPage();
	}
	
	public BrokenLinksPage clickOnBrokensLinks() {
		Action.scrollByVisibilityOfElement(driver.get(), brokenLinksBtn);
		Action.explicitWait(brokenLinksBtn);
		Action.click(brokenLinksBtn);
		return new BrokenLinksPage();
	}
	
	public UploadDownloadPage clickOnUploadDown() {
		Action.scrollByVisibilityOfElement(driver.get(), uploadDownBtn);
		Action.explicitWait(uploadDownBtn);
		Action.click(uploadDownBtn);
		return new UploadDownloadPage();
	}
	
	public DynamicPropsPage clickOnDinamicProps() {
		Action.scrollByVisibilityOfElement(driver.get(), tablesBtn);
		Action.explicitWait(dinamicPropBtn);
		Action.click(dinamicPropBtn);
		return new DynamicPropsPage();
	}
	
	
}
