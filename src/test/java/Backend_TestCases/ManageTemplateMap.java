package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
		application.clickLastColumnButtonForFirstColumnValue("manageTemplateTable_xpath", "editTemplateFirstColumn_xpath", "Edit_Template",
				"ManageTemplate", "editTemplateEditButton_xpath");
		application.waitUntilPresenceOfElement("editTemplateCompanyLabel_Xpath", Duration.ofSeconds(5), "Edit Template Company Label");
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
		application.click("addTemplateSelectCompany_xpath", "Edit Template Select Company");
		application.waitUntilPresenceOfElement("addTemplateCompanyDropdown_xpath", Duration.ofSeconds(3), "Edit Template Company DropDown");
		application.selectOptionDivUlLi("addTemplateCompanyDropdown_xpath", "EditTemplate_Company", "ManageTemplate");
		application.wait(2);
		application.click("addTemplateSelectDivision_xpath", "Edit Template Select Division");
		application.wait(2);
		application.selectOptionDivUlLi("addTemplateDivisionDropdown_xpath", "EditTemplate_Division", "ManageTemplate");
		application.wait(2);
		String templateName = application.readExcelData("EditTemplate_Division", "ManageTemplate").get(0);
		if(templateName.isEmpty()) {
			test.log(Status.INFO, "Data Not Provided , Template Name in edit template");
		}else {
			application.clear("addTemplateTemplate_xpath");
			application.type("addTemplateTemplate_xpath", readExcelData("NewTemplate_Name", "ManageTemplate"));
			application.wait(2);
		}
		String description = application.readExcelData("EditTemplate_Division", "ManageTemplate").get(0);
		if(description.isEmpty()) {
			test.log(Status.INFO, "Data Not Provided , Template Description in edit template");
		}else {
			application.clear("addtemplateDescription_xpath");
			application.type("addtemplateDescription_xpath", readExcelData("Edit_TemplateDescription", "ManageTemplate"));
			application.wait(2);
		}
		application.clickCheckboxBasedOnExcelParameter("addtemplateAllowBusinessCard_xpath", "EditTemplate_AllowBusinessCard", "ManageTemplate");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("addtemplateAllowIDCard_xpath", "EditTemplate_AllowIDCard", "ManageTemplate");
		application.wait(2);
		application.click("addtemplateSaveButton_xpath", "Add Temaplte Save Button");
		application.waitUntilPresenceOfElement("addTemplatePopUp_xpath", Duration.ofSeconds(5), "Add template End Popup");
		application.validateCompareText("addTemplatePopUp_xpath", "Template has been added successfully");
	}
	
	@Test
	public void validateTemplateMapDivision() {
		application.type("manageTemplateSearch_xpath", readExcelData("Template_SearchMapCategory", "ManageTemplate"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageTemplateTable_xpath", "editTemplateFirstColumn_xpath", "Template_SearchMapCategory",
				"ManageTemplate", "templateMapCategoryButton_xpath");
		application.waitUntilPresenceOfElement("templateMapCategoryFields_xpath", Duration.ofSeconds(5), "Manage Template map Category button page load element");
		application.validateElementPresent("templateMapCategorytitle_xpath", "Template Map Category Title ");
		application.validateElementPresent("templateMapCategoryHeading_xpath", "Template Map Category Heading");
		application.validateElementPresent("templateMapCategoryBackToListButton_xpath", "Template Map Category Back to List button");
		application.validateElementPresent("templateMapCategoryUnmappedSearchCategoryLabel_xpath", "Template Map Category Unmapped category Search label");
		application.validateElementPresent("templateMapCategoryMappedSearchCategoryLabel_xpath", "Template Map Category Mapped category Search label");
		application.validateElementPresent("templateMapCategoryUnmappedSearchCategory_xpath", "Template Map Category Unmapped category Search");
		application.validateElementPresent("templateMapCategoryMappedSearchCategory_xpath", "Template Map Category Mapped category Search");
		application.scrollTo("templateMapCategorySavebutton_xpath");
		application.validateElementPresent("templateMapCategorySavebutton_xpath", "Template Map Category Save Button");
		application.scrollTo("templateMapCategoryHeading_xpath");
		
		try {
			String categories = application.validateLinksPresent("templateMapCategoryUnmappedCategory_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.mapLinks("templateMapCategoryUnmappedCategory_xpath", "Template_MapCategory", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Categories are empty");
		}
		application.wait(4);
		try {
			String Links = application.validateCategoriesPresent("templateMapCategoryMappedCategory_xpath");
			if(Links.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.unMapLinks("templateMapCategoryMappedCategory_xpath", "Template_UnMapCategory", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Categories are empty");
		}
		application.scrollTo("templateMapCategoryBackToListButton_xpath");
		application.click("templateMapCategoryBackToListButton_xpath", "Template category Back to list button");
	}
	@Test
	public void templateMapDivision() {
		application.type("manageTemplateSearch_xpath", readExcelData("TemplateMapCategory_Search", "ManageTemplate"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageTemplateTable_xpath", "editTemplateFirstColumn_xpath", "TemplateMapCategory_Search",
				"ManageTemplate", "templateMapCategoryButton_xpath");
		try {
			String categories = application.validateLinksPresent("templateMapCategoryUnmappedCategory_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.mapLinks("templateMapCategoryUnmappedCategory_xpath", "Template_MapCategory", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Categories are empty");
		}
		application.scrollTo("templateMapCategorySavebutton_xpath");
		application.click("templateMapCategorySavebutton_xpath", "Template map Category save Button");
		application.waitUntilPresenceOfElement("addTemplatePopUp_xpath", Duration.ofSeconds(5), "Template Map Category save PopUp");
	}
	
}
