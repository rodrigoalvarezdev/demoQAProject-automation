package com.demoQa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.base.Base;
import com.demoQa.pageObjects.ElementsPage;
import com.demoQa.pageObjects.IndexPage;
import com.demoQa.pageObjects.UploadDownloadPage;

public class UploadDownloadPageTest extends Base {
	@Test
	public void uploadFileTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		UploadDownloadPage uploadDownloadPage = elementsPage.clickOnUploadDown();
		uploadDownloadPage.uploadFile();
		Assert.assertTrue(uploadDownloadPage.returnPathFile().isDisplayed());
	}
	
	@Test
	public void downloadFileTest() {
		IndexPage indexPage = new IndexPage();
		ElementsPage elementsPage = indexPage.clickElementsBtn();
		UploadDownloadPage uploadDownloadPage = elementsPage.clickOnUploadDown();
		uploadDownloadPage.downloadFile();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(uploadDownloadPage.returnExistFile());
		uploadDownloadPage.deleteDownloadFile();
	}
}
