package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appHooks.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_VerifyLogin extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyLogin";
		testDescription ="Verify Login functionality with positive data";
		authors="Rago";
		category ="Smoke";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String username, String password) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin();
//		.verifyHomePage();// local repo change in line 25
		/*
<<<<<<< HEAD
//		.verifyHomePage();// local repo change in line 25
=======
//		.verifyHomePage(); // remote edit
>>>>>>> 9f1dc99ed0e9167e209857cdbee7bc91d5a65182
*/
	}

}
