package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ManageLocation extends BaseClass{
	@Test
	public void openManageLocation() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageLocationButton_xpath" , "Manage Location Button");
		application.wait(5);
	}
	@Test
	public void changeDefaultDepartmentCompany() {
		application.click("manageLocationCompany_xpath", "Manage Department Default company");
		application.wait(2);
		application.selectOptionDivUlLi("manageLocationCompanyDropdown_xpath", "Default_Company", "ManageLocation");
		application.wait(2);
		application.click("manageLocationCompanyFilterButton_xpath", "Manage Department company Filter Button");
		String companySelected = application.getStringText("manageLocationSelectedDefaultCompany_xpath");
		String companyExcel = application.readExcelData("Default_Company", "ManageLocation").get(0);
		if(companySelected.equalsIgnoreCase(companyExcel)) {
			test.log(Status.PASS, "Default Company Changed to "+companySelected);
			generateScreenshots("Default Company");
		}else {
			test.log(Status.FAIL, companySelected+" is displayed.");
			generateScreenshots("Default Company");
		}
	}
	
	@Test
	public void validateManageLocation() {
		application.validateElementPresent("manageLocationTitle_xpath", "Manage Location Title");
		application.validateElementPresent("manageLocationCompanyLabel_xpath", "Manage Location Company Label");
		application.validateElementPresent("manageLocationCompany_xpath", "Manage Location Select Company");
		application.validateElementPresent("manageLocationCompanyFilterButton_xpath", "Manage Location Company Filter Button");
		application.validateElementPresent("manageLocationAddLoctionButton_xpath", "Manage Location Add Location Button");
		application.validateElementPresent("manageLocationShowFilters_xpath", "Manage Location Shoe Filters Button");
		application.validateElementPresent("manageLocationSearchLabel_xpath", "Manage Location Search Label");
		application.validateElementPresent("manageLocationSearch_xpath", "Manage Location Search");
		application.validateElementPresent("manageLocationTable_xpath", "Manage Location Table");
		application.scrollTo("manageLocationShowingEntries_xpath");
		application.validateElementPresent("manageLocationShowingEntries_xpath", "Manage Location Show Entries");
		application.validateElementPresent("manageLocationPagination_xpath", "Manage Location Pagination");
	}
	
	
	@Test
	public void addLocation() {
		application.scrollTo("manageLocationAddLoctionButton_xpath");
		application.click("manageLocationAddLoctionButton_xpath", "Manage Location Add Location Button");
		application.waitUntilPresenceOfElement("addLocationCompanyLabel_xpath", Duration.ofSeconds(10), "Add Location Company Label");
		application.validateElementPresent("addLocationPopupTitle_xpath", "Add Location Popup Title");
		application.validateElementPresent("addLocationSelectCompany_xpath", "Add Location Popup Select Company");
		application.validateElementPresent("addLocationNameLabel_xpath", "Add Location Popup Location Name Label");
		application.validateElementPresent("addLocationURLLabel_xpath", "Add Location Popup URL Label");
		application.validateElementPresent("addLocationAddress1Label_xpath", "Add Location Popup Address 1 Label");
		application.validateElementPresent("addLocationAddress2Label_xpath", "Add Location Popup Address 2 Label");
		application.validateElementPresent("addLocationName_xpath", "Add Location Popup Location Name");
		application.validateElementPresent("addLocationURL_xpath", "Add Location Popup Location URL");
		application.validateElementPresent("addLocationAddress1_xpath", "Add Location Popup Location Address 1");
		application.validateElementPresent("addLocationAddress2_xpath", "Add Location Popup Location Address 2");
		application.validateElementPresent("addLocationSaveButton_xpath", "Add Location Popup Save button");
		application.validateElementPresent("addLocationCancelButton_xpath", "Add Location Popup Cancel Button");
		application.validateElementPresent("addLocationCloseButton_xpath", "Add Location Popup Close Button");
		application.click("addLocationSaveButton_xpath", "Add Location Save Button");
		application.validateElementPresent("addLocationNameReqFieldError_xpath", "Add Location , Location Name Required Field error");
		application.validateCompareText("addLocationNameReqFieldError_xpath", "Location name is a required field");
		application.wait(2);
		application.validateElementPresent("addLocationURLReqFieldError_xpath", "Add Location , Location URL Required Field error");
		application.validateCompareText("addLocationNameReqFieldError_xpath", "Location URL is a required field");
		application.validateElementPresent("addLocationAddress1ReqFieldError_xpath", "Add Location Address 1 Required Field error");
		
		application.type("addLocationURL_xpath", readExcelData("InvalidLocation_URL", "ManageLocation"));
		application.validateElementPresent("addLocationValidURLError_xpath", "Add Location InValid URL Error ");
		application.validateCompareText("addLocationValidURLError_xpath", "Please enter valid URL");
		application.wait(2);
		
		String company = application.readExcelData("Company", "ManageLocation").get(0);
		if(company.isEmpty()) {
			test.log(Status.FAIL, "Add Location Field in Excel is empty");
		}else {
			application.click("addLocationSelectCompany_xpath", "Add Location Select Company");
			application.waitUntilPresenceOfElement("addLocationCompanyDropDown_xpath", Duration.ofSeconds(10), "Add Location Company DropDown");
			application.selectOptionDivUlLi("addLocationCompanyDropDown_xpath", "Company", "ManageLocation");
			application.wait(3);
			application.type("addLocationName_xpath", readExcelData("Location_Name", "ManageLocation"));
			application.wait(3);
			application.type("addLocationURL_xpath", readExcelData("Location_URL", "ManageLocation"));
			application.wait(3);
			application.type("addLocationAddress1_xpath", readExcelData("Address1", "ManageLocation"));
			application.wait(3);
			application.type("addLocationAddress2_xpath", readExcelData("Address2", "ManageLocation"));
			application.wait(3);
			application.click("addLocationSaveButton_xpath", "Add Location Save Button");
		}
		
	}
}
