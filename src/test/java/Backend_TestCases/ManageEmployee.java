package Backend_TestCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageEmployee extends BaseClass{
	@Test
	public void openManageEmployee() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageDivisionButton_xpath" , "Manage Division Button");
		application.wait(5);
	}
	
	@Test
	public void validateMangeEmployee() {
		application.validateElementPresent("", date);
	}
}
