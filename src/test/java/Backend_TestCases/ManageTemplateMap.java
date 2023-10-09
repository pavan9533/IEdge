package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageTemplateMap extends BaseClass{
	@Test
	public void openManageTemplate() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageTemplateMapButton_xpath" , "Manage Template Map Button");
		application.wait(5);
	}
	@Test
	public void validateManageTemplateMap() {
		application.validateElementPresent("manageTemplateCompanyLabel_xpath", "Manage Template map Company label");
		application.validateElementPresent("manageTemplateSelectCompany_xpath", "Manage Template Select Company");
		application.validateElementPresent("manageTemplateFilterButton_xpath", "Manage Template Company Filter Button");
		application.validateElementPresent("manageTemplateAddTemplateButton_xpath", "Manage Template Add template Button");
		application.wait(2);
		application.validateElementPresent("manageTemplateSearch_xpath", "Manage Template Search");
		application.validateElementPresent("manageTemplateTable_xpath", "Manage Template Table");
		application.wait(2);
		application.validateElementPresent("manageTemplateTableHeader_xpath", "Manage Template Table Header.");
	}
	
	@Test
	public void addtemplate() {
		application.wait(3);
		application.click("manageTemplateAddTemplateButton_xpath", "Manage template Add Template Button");
		application.waitUntilPresenceOfElement("addTemplateHeading_xpath", Duration.ofSeconds(5), "Manage template Add Template");
		application.validateElementPresent("addTemplateCompanyLabel_xpath", "Add template Company label");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("addTemplateSelectCompany_xpath", "Add Temaplte Select Company");
		application.validateElementPresent("addTemplateDivisionLabel_xpath", "Add Template Division Label");
		application.validateMandatoryIconForLabel("Division");
		application.wait(2);
		application.validateElementPresent("addTemplateSelectDivision_xpath", "Add template Select Division");
		application.validateElementPresent("addTemplateTemplateLabel_xpath", "Add Template , Template Label");
		application.validateMandatoryIconForLabel("Template");
		application.validateElementPresent("addTemplateTemplate_xpath", "Add Template  Template");
		application.validateElementPresent("addtemplateDescriptionLabel_xpath", "Add Template Description Label");
		application.validateElementPresent("addtemplateDescription_xpath", "Add template Description");
		application.validateElementPresent("addtemplateAllowBusinessCardLabel_xpath", "Add Template Allow business Card Label");
		application.validateElementPresent("addtemplateAllowBusinessCard_xpath", "Allow BusinessCard Checkbox");
		application.validateElementPresent("addtemplateAllowIDCardLabel_xpath", "Add Template Allow ID Card Label");
		application.validateElementPresent("addtemplateAllowIDCard_xpath", "Allow ID Card Checkbox");
		application.validateElementPresent("addtemplateSaveButton_xpath", "Add Temaplte Save Button");
		application.validateElementPresent("addtemplateCancelButton_xpath", "Add Template Cancel Button");
		application.wait(2);
		application.click("addtemplateSaveButton_xpath", "Add Temaplte Save Button");
		application.validateElementPresent("addTemplateRequiredError_xpath", "Template Mandatory Field error");
		application.wait(2);
		application.click("addTemplateSelectCompany_xpath", "Add template Select company");
		application.wait(2);
		application.selectOptionDivUlLi("addTemplateCompanyDropdown_xpath", "AddTemplate_Company", "ManageTemplate");
		application.wait(2);
		application.click("addTemplateSelectDivision_xpath", "Add Template Select Division");
		application.selectOptionDivUlLi("addTemplateDivisionDropdown_xpath", "AddTemplate_Division", "ManageTemplate");
		application.wait(2);
		application.type("addTemplateTemplate_xpath", readExcelData("AddTemplate_Template", "ManageTemplate"));
		application.wait(2);
		application.type("addtemplateDescription_xpath", readExcelData("AddTemplate_Description", "ManageTemplate"));
		application.clickCheckboxBasedOnExcelParameter("addtemplateAllowBusinessCard_xpath", "AddTemplate_AllowBusinessCard", "ManageTemplate");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("addtemplateAllowIDCard_xpath", "AddTemplate_AllowIDCard", "ManageTemplate");
		
		application.click("addtemplateSaveButton_xpath", "Add Temaplte Save Button");
		application.waitUntilPresenceOfElement("addTemplatePopUp_xpath", Duration.ofSeconds(5), "Add template End Popup");
		application.validateCompareText("addTemplatePopUp_xpath", "Template has been added successfully");
	}
	
	@Test
	public void editTemplate() {
		
		application.type("manageTemplateSearch_xpath", readExcelData("Edit_Template", "ManageTemplate"));
		application.wait(2);
		
	}
	
	
}
