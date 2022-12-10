package com.appHooks;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.base.SeleniumBase;
import com.framework.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

//	@DataProvider(name = "fetchData", indices = 0)
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}
	
	@BeforeMethod
	public void preCondition() {
		startApp("chrome", false, "https://login.salesforce.com/");
		setNode();

	}
	
	public void postCondition() {
		close();

	}

	

	
	  

	
	
}
