package Backend_TestCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class Login extends BaseClass{
	@Test(priority = 1)
	public void login() {
		application.validateElementsPresent("signInText_xpath");
		application.validateElementPresentText("loginEmail_xpath","Email input field");
		application.validateElementPresentText("loginPassword_xpath","Password input field");
		application.validateElementPresentText("loginSubmitButton_xpath","Login button input field");
		application.type("loginEmail_xpath", readExcelData("username", "Login"));
		application.wait(2);
		application.type("loginPassword_xpath", readExcelData("password", "Login"));
		application.wait(2);
		application.click("loginSubmitButton_xpath" , "Login Button");
		application.wait(3);
		
	}
	
	@Test(priority = 2)
	public void selectCompany() {
		application.validateElementPresent("companyText_xpath");
		application.validateElementPresent("companyConfirmButton_xpath");
		application.click("companyConfirmButton_xpath" , "Company Confirm Button");
		application.validateCompanyError("companyError_xpath");
		application.wait(2);
		application.selectFromDown("companyDropDown_xpath", "default_company", "Login");
		application.click("companyConfirmButton_xpath", "Company Confirm Button");
		application.wait(5);
	}

}
