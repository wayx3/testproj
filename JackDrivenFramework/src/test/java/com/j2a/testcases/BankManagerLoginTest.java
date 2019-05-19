package com.j2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.j2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		
		//verifyEquals("abc",  "xyz");
		Thread.sleep(3000);
	//	System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.debug("Inside Login Test");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		click("bmlBtn_CSS");
		
		//Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successful");
		
		log.debug("Login successfully executed");
		
	/*	Reporter.log("Login successfully executed");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\jackz\\Pictures\\Screenshots\\error.jpg\">screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\jackz\\Pictures\\Screenshots\\error.jpg\" height=200 width=200><img src=\"C:\\Users\\jackz\\Pictures\\Screenshots\\error.jpg\"></img></a>");	*/
		
		//Assert.fail("Login not successful");
		
	}

}
