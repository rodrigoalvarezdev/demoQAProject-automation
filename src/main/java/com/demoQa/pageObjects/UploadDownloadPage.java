package com.demoQa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoQa.actions.Action;
import com.demoQa.base.Base;

public class UploadDownloadPage extends Base {
	@FindBy(id = "downloadButton") WebElement downloadBtn;
	@FindBy(id = "uploadFile") WebElement uploadBtn;
	@FindBy(id = "uploadedFilePath") WebElement uploadAssert;
	
	public UploadDownloadPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void uploadFile() {
		Action.explicitWait(uploadBtn);
		Action.sendText(uploadBtn, "C:\\Users\\admin\\eclipse-workspace\\demoQaProyect\\dataset\\demoQaExcel.xlsx");
	}
	
	public WebElement returnPathFile() {
		Action.explicitWait(uploadAssert);
		return uploadAssert;
	}
	
	public void downloadFile() {
		Action.explicitWait(downloadBtn);
		Action.click(downloadBtn);
	}
	
	public boolean returnExistFile() {
		return Action.isFileDownloaded("C:\\Users\\admin\\Downloads", "sampleFile.jpeg");
	}
	
	public void deleteDownloadFile() {
		Action.deleteFile("C:\\Users\\admin\\Downloads\\sampleFile.jpeg");
	}
}
