package Backend_TestCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ValidInvalidLogin extends BaseClass{
	@Test
	
	public void validateLogin() {
		application.type("loginEmail_xpath", readExcelData("username", "Login"));
		application.wait(2);
		application.type("loginPassword_xpath", readExcelData("Invalid_Password", "Login"));
		application.wait(2);
		application.click("loginSubmitButton_xpath" , "Login Submit Button");
		application.validateError("invalidLoginError_xpath", "Invalid Login error");
		application.validateCompareText("invalidLoginError_xpath", "Invalid credential");
		application.wait(2);
		application.clear("loginEmail_xpath");
		application.clear("loginPassword_xpath");
		application.type("loginEmail_xpath", readExcelData("username", "Login"));
		application.wait(2);
		application.type("loginPassword_xpath", readExcelData("password", "Login"));
		application.wait(2);
		application.click("loginSubmitButton_xpath", "Login Submit Button");
		application.wait(3);
	}

}
