package Backend_TestCases;

import java.time.Duration;
import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
	public void changeDefaultDepartmentCompany() {
		application.click("manageDepartmentCompany_xpath", "Manage Department Default company");
		application.wait(2);
		application.selectOptionDivUlLi("manageDepartmentCompanyDropdown_xpath", "Default_Company", "ManageDepartment");
		application.wait(2);
		application.click("manageDepartmentCompanyFilterButton_xpath", "Manage Department company Filter Button");
		String companySelected = application.getStringText("manageDepartmentSelectedDefaultCompany_xpath");
		String companyExcel = application.readExcelData("Default_Company", "ManageDepartment").get(0);
		if(companySelected.equalsIgnoreCase(companyExcel)) {
			test.log(Status.PASS, "Default Company Changed to "+companySelected);
			generateScreenshots("Default Company");
		}else {
			test.log(Status.FAIL, companySelected+" is displayed.");
			generateScreenshots("Default Company");
		}
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
		application.validateMandatoryIconForLabel("Department");
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
	
	@Test
	public void editDepartment() {
		application.scrollTo("manageDepartmentAddDepartmentButton_xpath");
		application.wait(2);
		application.type("manageDepartmentSearch_xpath", readExcelData("EditDepartment_Search", "ManageDepartment"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDepartmentTable_xpath", "manageDepartmentTableFirstColumn_xpath", 
				"EditDepartment_Search", "ManageDepartment", "manageDepartmentTableEditDepartmentButton_xpath");
		application.waitUntilPresenceOfElement("manageDepartmentEditDepartmentPopUp_xpath", Duration.ofSeconds(10), "Manage Department Edit Department Popup");
		application.validateElementPresent("editDepartmentTitle_xath", "Edit Department popup Title");
		application.validateElementPresent("addDepartmentCompanyLabel_xpath", "Edit Department Company label");
		application.validateElementPresent("addDepartmentCompany_xpath", "Edit Department Company");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("addDepartmentLabel_xpath", "Edit Department Label");
		application.validateMandatoryIconForLabel("Department");
		application.validateElementPresent("editDepartmentUpdateButton_xpath", "Edit Department PopUp Update button");
		application.validateElementPresent("addDepartmentCancelButton_xpath", "Edit Department PopUp Cancel button");
		application.validateElementPresent("addDepartmentCloseButton_xpath", "Edit Department PopUp Close button");
		application.wait(2);
		application.clear("addDepartment_xpath");
		application.type("addDepartment_xpath", readExcelData("New_DepartmentName", "ManageDepartment"));
		application.wait(2);
		application.click("editDepartmentUpdateButton_xpath", "Edit Department PopUp Update button");
		application.waitUntilPresenceOfElement("addDepartmentLastPopUp_xpath", Duration.ofSeconds(5), "Edit Department PopUp");
	}
	
	@Test
	public void deleteDepartment() {
		application.type("manageDepartmentSearch_xpath", readExcelData("DeleteDepartment_Search", "ManageDepartment"));
		application.wait(4);
		application.clickLastColumnButtonForFirstColumnValue("manageDepartmentTable_xpath", "manageDepartmentTableFirstColumn_xpath",
				"DeleteDepartment_Search", "ManageDepartment", "manageDepartmentDeleteDepartment_xpath");
		application.validateElementPresent("manageDepartmentDeleteDepartment_xpath", "Delete Department Dialogue Box");
		application.validateElementPresent("manageDepartmentDeletePopUpText_xpath", "Delete Department popUp Text");
		application.validateElementPresent("manageDepartmentDeleteCancelButton_xpath", "Delete Department popUp Cancel Button");
		application.validateElementPresent("manageDepartmentDeleteOkButton_xpath", "Delete Department popUp Ok Button");
		application.wait(2);
		application.click("manageDepartmentDeleteOkButton_xpath", "Delete Department popUp Ok Button");
		application.waitUntilPresenceOfElement("addDepartmentLastPopUp_xpath", Duration.ofSeconds(5), "Edit Department PopUp");
		
	}
	
}
