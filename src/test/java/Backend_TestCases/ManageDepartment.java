package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageDepartment extends BaseClass{
	
	@Test
	public void openManageDepartment() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageDepartment_xpath" , "Manage Department Button");
		application.wait(5);
	}
	
	@Test
	public void validateManageDepartment() {
		application.validateElementPresent("manageDepartementTitle_xpath", "Manage Department Title");
		application.validateElementPresent("manageDepartmentLanguageSelector_xpath", "Manage Department Language Selector");
		application.validateElementPresent("manageDepartmentLoginName_xpath", "Manage Department Login Name");
		application.validateElementPresent("manageDepartmentCompanyLabel_xpath", "Manage Department Company label");
		application.validateElementPresent("manageDepartmentCompany_xpath", "Manage Department Select Company");
		application.wait(2);
		application.validateElementPresent("manageDepartmentCompanyFilterButton_xpath", "Manage Department Company Filter Button");
		application.validateElementPresent("manageDepartmentAddDepartmentButton_xpath", "Manage Department Add Department Button");
		application.validateElementPresent("manageDepartmentShowFilters_xpath", "Manage Department Show Filters");
		application.validateElementPresent("manageDepartmentSearchLabel_xpath", "Manage Department Search Label");
		application.validateElementPresent("manageDepartmentSearch_xpath", "Manage Department Search ");
		application.validateElementPresent("manageDepartmentTable_xpath", "Manage Department Table");
		application.scrollTo("manageDepartmentShowingFiltersText_xpath");
		application.validateElementPresent("manageDepartmentShowingFiltersText_xpath", "Manage Department Showing Filters Text at the botton of table");
		application.validateElementPresent("manageDepartmentPagination_xpath", "Manage Department pagination");
		
	}
	@Test
	
	public void addDepartment() {
		application.scrollTo("manageDepartmentAddDepartmentButton_xpath");
		application.wait(2);
		application.click("manageDepartmentAddDepartmentButton_xpath", "Manage Department Add Department Button");
		application.waitUntilPresenceOfElement("manageDepartmentAddDepartmentPopUp_xpath", Duration.ofSeconds(5), "Manage Department add Department Dialogue box");
		application.validateElementPresent("manageDepartmentAddDepartmentDialogueTitle_xpath", "Manage Department Add Department Dialogue Title");
		application.validateElementPresent("addDepartmentCompanyLabel_xpath", "Add Department Company label");
		application.validateElementPresent("addDepartmentCompany_xpath", "Add Department Company");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("addDepartmentLabel_xpath", "Add Department Label");
		application.validateElementPresent("addDepartmentSaveButton_xpath", "Add Department PopUp Save button");
		application.validateElementPresent("addDepartmentCancelButton_xpath", "Add Department PopUp Cancel button");
		application.validateElementPresent("addDepartmentCloseButton_xpath", "Add Department PopUp Close button");
		application.wait(2);
		application.click("addDepartmentCompany_xpath", "Add Department Select Company");
		application.wait(2);
		application.selectOptionDivUlLi("addDepartmentCompanyDropdown_xpath", "Company", "ManageDepartment");
		application.wait(2);
		application.type("addDepartment_xpath", readExcelData("Department_Name", "ManageDepartment"));
		application.wait(2);
		application.click("addDepartmentSaveButton_xpath", "Add Department save Button");
		generateScreenshots("Add Department PopUp");
		application.waitUntilPresenceOfElement("addDepartmentLastPopUp_xpath", Duration.ofSeconds(5), "Add Departmnet PopUp");
	}
	
}
