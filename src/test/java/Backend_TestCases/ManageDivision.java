package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageDivision extends BaseClass{
	@Test
	public void openManageDivision() {
			application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
			application.wait(2);
			application.click("manageDivisionButton_xpath" , "Manage Division Button");
			application.wait(5);
	}
	@Test
	public void validateManageDivision() {
		application.validateElementPresent("manageDivisionCompanyLabel_xpath", "Manage Division company Label");
		application.validateElementPresent("manageDivisionFilterButton_xpath", "Division Company Filter button");
		application.validateElementPresent("manageDivisionShowFilter_xpath", "Manage Division Show Filter");
		application.wait(2);
		application.validateElementPresent("manageDivisionAddDivisionButton_xpath", "Manage Division add division Button");
		application.validateElementPresent("manageDivisonTable_xpath" , "Manage Division Table");
		application.wait(2);
		application.click("manageDivisionAddDivisionButton_xpath", "Manage Division add division Button");
		application.wait(4);
		application.validateElementPresent("addDivisonPopUpHeading_xpath", "Add Division PopUp Heading");
		application.validateElementPresent("addDivisonCompanyLabel_xpath", "Add Division Company Label");
		application.validateElementPresent("addDivisonLabel_xpath", "Add Division Label");
		application.wait(2);
		application.validateElementPresent("addDivisonAreaCodeLabel_xpath", "Add Division Area Code Label");
		application.validateElementPresent("addDivisonLandlineLabel_xpath", "Add Division Landline Label");
		application.validateElementPresent("addDivisonCompanyEnquiryFormLabel_xpath", "Add Division Enquiry Form Label");
		application.validateElementPresent("addDivisionShowEmpDpLabel_xpath", "Add Division Show Employee Profile Picture Label");
		application.validateElementPresent("addDivisionShowAboutUsonCardLabel_xpath", "Add Division Show About Us Label");
		application.validateElementPresent("addDivisonHideSearchLabel_xpath", "Add Division Hide Search engines Label");
		application.validateElementPresent("addDivisonPreventSearchText_xpath", "Add Division Prevent Search Engines text Label");
		application.wait(2);
		application.validateElementPresent("addDivisionSaveButton_xpath", "Add Division Save Button");
		application.validateElementPresent("addDivisionCancelButton_xpath", "Add Division Cancel Button");
		application.click("addDivisionCancelButton_xpath", "Add Division Cancel Button");
		
	}
	
	@Test
	public void addDivision() {
		application.wait(2);
		application.click("manageDivisionAddDivisionButton_xpath", "Manage Division add division Button");
		application.wait(2);
		application.click("addDivisionCompany_xpath", "Add Division Select Company");
		application.wait(2);
		application.selectOptionDivUlLi("addDivisionCompanyDropdown_xpath", "AddDivision_Company", "ManageDivision");
		application.wait(2);
		application.click("addDivisonCompanyLabel_xpath", "Add Division Select Company Label");
		application.type("addDivisionZone_xpath", readExcelData("AddDivision_Division", "ManageDivision"));
		application.clickCheckboxBasedOnExcelParameter("addDivisionShowContact_xpath", "AddDivision_ShowContact", "ManageDivision");
		application.wait(2);
		application.type("addDivisionAreaCode_xpath", readExcelData("AddDivision_AreaCode", "ManageDivision"));
		application.type("addDivisionLandline_xpath", readExcelData("AddDivision_Landline", "ManageDivision"));
		application.type("addDivisionEnquiryForm_xpath", readExcelData("AddDivision_EnquiryFormLink", "ManageDivision"));
		application.clickCheckboxBasedOnExcelParameter("addDivisionEmpProfilePic_xpath", "AddDivision_ShowProfilePic", "ManageDivision");
		application.clickCheckboxBasedOnExcelParameter("addDivisionShowAboutUsCheckBox_xpath", "AddDivision_ShowAboutUS", "ManageDivision");
		application.clickCheckboxBasedOnExcelParameter("addDivisionHideSearchEnginesCheckBox_xpath", "AddDivision_HideSearch", "ManageDivision");
		application.wait(2);
		application.click("addDivisionSaveButton_xpath", "Add Division Save Button");
		application.validateCompareText("addDivisionPopUp_xpath", "Division has been added successfully", " Division already exist !!");
	}
}
