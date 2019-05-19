package com.j2a.testcases;

import static org.testng.Assert.fail;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.j2a.base.TestBase;
import com.j2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	
	//@Test(dataProvider="getData")
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")	
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {
		
		if (!data.get("runmode").equals("Y")) {
			
			throw new SkipException("Skipping the test as the Run mode for data set is NO ");
		}
		
		
		//driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		click("addCustBtn_CSS");
		
		//driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		type("firstname_CSS", data.get("firstname"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		type("lastname_XPATH", data.get("lastname"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		type("postcode_CSS", data.get("postcode"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		click("addbtn_CSS");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		//Thread.sleep(3000);
		alert.accept();
				
		//Assert.fail("Customer not added succcessfully");
		Thread.sleep(2000);
	}

	/*	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);


		Object[][] data = new Object[rows-1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) { //2

			for (int colNum = 0; colNum < cols; colNum++) {

				
				//data[0][0]
				data [rowNum -2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				// -2
			}


		}

		return data;
		
		
	} 
	 */

}
