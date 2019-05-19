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

public class OpenAccountTest extends TestBase {
	
	
//	@Test(dataProvider="getData")
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException {
		
		if(!TestUtil.isTestRunnable("openAccountTest", excel)){
			
			throw new SkipException("Skipping the test"+"openAccountTest".toUpperCase()+"as the Run mode is NO");
		}
		
		click("openaccount_CSS");
		select("customer_CSS", data.get("customer"));
		select("currency_CSS", data.get("currency"));		
		click("process_CSS");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());			
		alert.accept();
		
		
	}

	/*	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "OpenAccountTest";
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
