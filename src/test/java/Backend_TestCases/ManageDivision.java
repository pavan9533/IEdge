package Backend_TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
		application.waitUntilPresenceOfElement("addDivisionPopUp_xpath", Duration.ofSeconds(5), "Add Division PopUp");
		try {
			WebElement closeButton = driver.findElement(getLocator("addDivisionClosePopUpButton_xpath"));
			if(closeButton.isDisplayed()) {
				application.click("addDivisionClosePopUpButton_xpath", "Add Division Popup Close button");
			}else {
				test.log(Status.INFO, "PopUp Is Closed");
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "PopUp Is Closed");
		}
	}
	
	@Test
	public void editDivision() {
		application.type("manageDivisionSearch_xpath", readExcelData("Edit_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Edit_Division", "ManageDivision", "manageDivisionLastColumnEditButton_xpath");
		application.waitUntilPresenceOfElement("editDivisionPopup_xpath", Duration.ofSeconds(5), "Edit Division Popup");
		
		application.validateElementPresent("editDivisonPopUpHeading_xpath", "Edit Division PopUp Heading");
		application.validateElementPresent("addDivisonCompanyLabel_xpath", "Edit Division Company Label");
		application.validateElementPresent("editDivisonLabel_xpath", "Edit Division Label");
		application.wait(2);
		application.validateElementPresent("editDivisonAreaCodeLabel_xpath", "Edit Division Area Code Label");
		application.validateElementPresent("editDivisonLandlineLabel_xpath", "Edit Division Landline Label");
		application.validateElementPresent("editDivisonCompanyEnquiryFormLabel_xpath", "Edit Division Enquiry Form Label");
		application.validateElementPresent("editDivisionShowEmpDpLabel_xpath", "Edit Division Show Employee Profile Picture Label");
		application.validateElementPresent("editDivisionShowAboutUsonCardLabel_xpath", "Edit Division Show About Us Label");
		application.validateElementPresent("editDivisonHideSearchLabel_xpath", "Edit Division Hide Search engines Label");
		application.validateElementPresent("editDivisonPreventSearchText_xpath", "Edit Division Prevent Search Engines text Label");
		application.wait(2);
		application.validateElementPresent("editDivisionSaveButton_xpath", "Edit Division Save Button");
		application.validateElementPresent("editDivisionCancelButton_xpath", "Edit Division Cancel Button");
		String editCompany = readExcelData("AddDivision_Company", "ManageDivision").get(0);
		if(editCompany.isEmpty()) {
			test.log(Status.INFO, "Edit Company in the data sheet is empty");
		}else {
			application.click("editDivisionCompany_xpath", "Edit Division Select Company");
			application.wait(2);
			application.selectOptionDivUlLi("editDivisionCompanyDropdown_xpath", "EditDivision_Company", "ManageDivision");
			application.wait(2);
		}
		String divisionName = readExcelData("EditDivision_Division", "ManageDivision").get(0);
		if(divisionName.isEmpty()) {
			test.log(Status.INFO, "Edit Division ,  Division name in the data sheet is empty");
		}else {
			application.clear("editDivisionZone_xpath");
			application.type("editDivisionZone_xpath", readExcelData("EditDivision_Division", "ManageDivision"));
			application.wait(2);
		}
		String showContactCheckBox = readExcelData("EditDivision_ShowContact", "ManageDivision").get(0);
		if(showContactCheckBox.isEmpty()) {
			test.log(Status.INFO, "Edit Division Show Contact Checkbox in the data sheet is empty");
			application.wait(2);
		}else {
			application.clickCheckboxBasedOnExcelParameter("editDivisionShowContact_xpath", "editDivision_ShowContact", "ManageDivision");
		}
		String areaCode = readExcelData("EditDivision_AreaCode", "ManageDivision").get(0);
		if(areaCode.isEmpty()) {
			test.log(Status.INFO, "Edit Division Areacode in the data sheet is empty");
			application.wait(2);
		}else {
			application.clear("editDivisionAreaCode_xpath");
			application.type("editDivisionAreaCode_xpath", readExcelData("EditDivision_AreaCode", "ManageDivision"));
			application.wait(2);
		}
		String landLine = readExcelData("EditDivision_Landline", "ManageDivision").get(0);
		if(landLine.isEmpty()) {
			test.log(Status.INFO, "Edit Division Landline in the data sheet is empty");
			application.wait(2);
		}else {
			application.clear("editDivisionLandline_xpath");
			application.type("editDivisionLandline_xpath", readExcelData("EditDivision_Landline", "ManageDivision"));
			application.wait(2);
		}
		String enquiryForm = readExcelData("EditDivision_EnquiryFormLink", "ManageDivision").get(0);
		if(enquiryForm.isEmpty()) {
			test.log(Status.INFO, "Edit Division Enquiry Form in the data sheet is empty");
			application.wait(2);
		}else {
			application.clear("editDivisionEnquiryForm_xpath");
			application.type("editDivisionEnquiryForm_xpath", readExcelData("EditDivision_EnquiryFormLink", "ManageDivision"));
			application.wait(2);
		}
		String empProfilePic = readExcelData("EditDivision_ShowProfilePic", "ManageDivision").get(0);
		if(empProfilePic.isEmpty()) {
			test.log(Status.INFO, "Edit Division Employee Show profile picture checkbox in the data sheet is empty");
			application.wait(2);
		}else {
			application.clickCheckboxBasedOnExcelParameter("editDivisionEmpProfilePic_xpath", "EditDivision_ShowProfilePic", "ManageDivision");
		}
		String showAboutUs = readExcelData("EditDivision_ShowAboutUS", "ManageDivision").get(0);
		if(showAboutUs.isEmpty()) {
			test.log(Status.INFO, "Edit Division Show About us Checkbox in the data sheet is empty");
			application.wait(2);
		}else {
			application.clickCheckboxBasedOnExcelParameter("editDivisionShowAboutUsCheckBox_xpath", "EditDivision_ShowAboutUS", "ManageDivision");
		}
		String hideSearchEngines= readExcelData("EditDivision_HideSearch", "ManageDivision").get(0);
		if(hideSearchEngines.isEmpty()) {
			test.log(Status.INFO, "Edit Division Hide Search Engines Checkbox in the data sheet is empty");
			application.wait(2);
		}else {
			application.clickCheckboxBasedOnExcelParameter("editDivisionHideSearchEnginesCheckBox_xpath", "EditDivision_HideSearch", "ManageDivision");
		}
		application.wait(2);
		application.scrollTo("editDivisionSaveButton_xpath");
		application.click("editDivisionSaveButton_xpath", "Edit division Save button");
		application.waitUntilPresenceOfElement("editDivisionPopUp_xpath", Duration.ofSeconds(5), "Update Division PopUp");
		application.validateCompareText("editDivisionPopUp_xpath", "Division has been updated successfully", " Division already exist !!");
	}
	
	@Test
	
	public void validateMapCategory() {
		application.type("manageDivisionSearch_xpath", readExcelData("Map_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapCategoryButton_xpath");
		application.waitUntilPresenceOfElement("mapCategoryTitle_xpath", Duration.ofSeconds(10), "Map Category Title");
		application.validateElementPresent("mapCategoryHeading_xpath", "Manage Categoy Heading.");
		application.wait(5);
		application.validateElementPresent("mapCategoryBackToListButton_xpath", "Map Category Back to list Button");
		application.validateContainsText("mapCategoryHeading_xpath", "Map Category");
		try {
			String categories = application.validateCategoriesPresent("mapCategoryUnmappedList_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Unmapped Categories are empty");
			}else {
				application.mapCategories("mapCategoryUnmappedList_xpath", "Map_Categories", "ManageDivision");
				application.wait(2);
			}
		}catch(Exception e) {
			test.log(Status.INFO, "UnMapped Categories are empty");
		}
		try {
			String categories = application.validateCategoriesPresent("mapCategoryMappedList_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.unMapCategories("mapCategoryMappedList_xpath", "UnMap_Categories", "ManageDivision");
				application.wait(2);
			}
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Categories are empty");
		}
		application.type("mapCategorySearchUnmapped_xpath", readExcelData("Search_UnMapCategories_Division", "ManageDivision"));
		application.wait(2);
		application.type("mapCategorySearchMapped_xpath", readExcelData("Search_MapCategories_Division", "ManageDivision"));
		application.wait(2);
		application.scrollTo("mapCategorySaveButton_xpath");
		application.wait(2);
		application.scrollTo("mapCategoryBackToListButton_xpath");
		application.click("mapCategoryBackToListButton_xpath", "Back To List Button");
		application.wait(3);
	}
	
	@Test
	
	public void mapCategory() {
		application.type("manageDivisionSearch_xpath", readExcelData("Search_MapCategories_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapCategoryButton_xpath");
		application.waitUntilPresenceOfElement("mapCategoryTitle_xpath", Duration.ofSeconds(10), "Map Category Title");
		application.validateElementPresent("mapCategoryHeading_xpath", "Manage Categoy Heading.");
		application.wait(5);
		application.validateElementPresent("mapCategoryBackToListButton_xpath", "Map Category Back to list Button");
		application.validateContainsText("mapCategoryHeading_xpath", "Map Category");
		try {
			String categories = application.validateCategoriesPresent("mapCategoryUnmappedList_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Unmapped Categories are empty");
			}else {
				application.mapCategories("mapCategoryUnmappedList_xpath", "Map_Categories", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "UnMapped Categories are empty");
		}
		application.type("mapCategorySearchUnmapped_xpath", readExcelData("Search_UnMapCategories", "ManageDivision"));
		application.wait(2);
		application.type("mapCategorySearchMapped_xpath", readExcelData("Search_MapCategories", "ManageDivision"));
		application.wait(2);
		application.scrollTo("mapCategorySaveButton_xpath");
		application.click("mapCategorySaveButton_xpath", "Map Category Save Button");
		
	}
	@Test
	
	public void unMapCategory() {
		application.type("manageDivisionSearch_xpath", readExcelData("Search_UnMapCategories_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapCategoryButton_xpath");
		application.waitUntilPresenceOfElement("mapCategoryTitle_xpath", Duration.ofSeconds(10), "Map Category Title");
		application.validateElementPresent("mapCategoryHeading_xpath", "Manage Categoy Heading.");
		application.wait(5);
		application.validateElementPresent("mapCategoryBackToListButton_xpath", "Map Category Back to list Button");
		application.validateContainsText("mapCategoryHeading_xpath", "Map Category");
		try {
			String categories = application.validateCategoriesPresent("mapCategoryMappedList_xpath");
			if(categories.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.unMapCategories("mapCategoryMappedList_xpath", "UnMap_Categories", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Categories are empty");
		}
		application.type("mapCategorySearchUnmapped_xpath", readExcelData("Search_UnMapCategories", "ManageDivision"));
		application.wait(2);
		application.type("mapCategorySearchMapped_xpath", readExcelData("Search_MapCategories", "ManageDivision"));
		application.wait(2);
		application.scrollTo("mapCategorySaveButton_xpath");
		application.click("mapCategorySaveButton_xpath", "Map Category Save Button");
		
	}
	
	@Test
	public void validateMapLinks() {
		application.type("manageDivisionSearch_xpath", readExcelData("Search_MapLink_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapLinkButton_xpath");
		application.waitUntilPresenceOfElement("mapLinkTitle_xpath", Duration.ofSeconds(10), "Map Link Title");
		application.validateElementPresent("mapLinkHeading_xpath", "Map Link Heading.");
		application.wait(5);
		application.validateElementPresent("mapLinkBackToListButton_xpath", "Map link Back to list Button");
		application.type("mapLinkUnMappedSearch_xpath", readExcelData("Search_MapLink", "ManageDivision"));
		application.wait(2);
		application.clear("mapLinkUnMappedSearch_xpath");
		application.wait(2);
		try {
			String Links = application.validateLinksPresent("mapLinksUnMappedList_xpath");
			if(Links.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.mapLinks("mapLinksUnMappedList_xpath", "Map_Link", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Links are empty");
		}
		application.wait(5);
		try {
			String Links = application.validateCategoriesPresent("mapLinkMappedSearch_xpath");
			if(Links.isBlank()) {
				test.log(Status.INFO, "Mapped Links are empty");
			}else {
				application.unMapLinks("mapLinkMappedSearch_xpath", "UnMap_Link", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Links are empty");
		}
		application.wait(2);
		application.scrollTo("mapLinkSaveButton_xpath");
	}
	
	@Test
	public void mapLinks() {
		application.type("manageDivisionSearch_xpath", readExcelData("Search_MapLink_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapLinkButton_xpath");
		application.waitUntilPresenceOfElement("mapLinkTitle_xpath", Duration.ofSeconds(10), "Map Link Title");
		application.validateElementPresent("mapLinkHeading_xpath", "Map Link Heading.");
		application.wait(5);
		application.validateElementPresent("mapLinkBackToListButton_xpath", "Map link Back to list Button");
		application.type("mapLinkUnMappedSearch_xpath", readExcelData("Search_MapLink", "ManageDivision"));
		application.wait(2);
		application.clear("mapLinkUnMappedSearch_xpath");
		application.wait(2);
		try {
			String Links = application.validateLinksPresent("mapLinksUnMappedList_xpath");
			if(Links.isBlank()) {
				test.log(Status.INFO, "Mapped Categories are empty");
			}else {
				application.mapLinks("mapLinksUnMappedList_xpath", "Map_Link", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Links are empty");
		}
		application.wait(2);
		application.scrollTo("mapLinkSaveButton_xpath");
		application.click("mapLinkSaveButton_xpath", "Manage Links Save Button");
		application.wait(1);
		application.validateCompareText("mapLinksSavePopUp_xpath", "Link mapped with Division successfully.");
	}
	@Test
	public void UnMapLinks() {
		application.type("manageDivisionSearch_xpath", readExcelData("Search_UnMapLink_Division", "ManageDivision"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageDivisonTable_xpath", "manageDivisionFirstColumn_xpath", 
				"Map_Division", "ManageDivision", "manageDivisionLastColumnMapLinkButton_xpath");
		application.waitUntilPresenceOfElement("mapLinkTitle_xpath", Duration.ofSeconds(10), "Map Link Title");
		application.validateElementPresent("mapLinkHeading_xpath", "Map Link Heading.");
		application.wait(5);
		application.validateElementPresent("mapLinkBackToListButton_xpath", "Map link Back to list Button");
		application.type("mapLinkMappedSearch_xpath", readExcelData("Search_UnMapLink", "ManageDivision"));
		application.wait(2);
		application.clear("mapLinkMappedSearch_xpath");
		application.wait(2);
		try {
			String Links = application.validateLinksPresent("mapLinkMappedList_xpath");
			if(Links.isBlank()) {
				test.log(Status.INFO, "Mapped Links are empty");
			}else {
				application.unMapLinks("mapLinkMappedList_xpath", "UnMap_Link", "ManageDivision");
				application.wait(2);
			}
			
		}catch(Exception e) {
			test.log(Status.INFO, "Mapped Links are empty");
		}
		application.wait(2);
		application.scrollTo("mapLinkSaveButton_xpath");
		application.click("mapLinkSaveButton_xpath", "Manage Links Save Button");
		application.wait(1);
		application.validateCompareText("mapLinksSavePopUp_xpath", "Link mapped with Division successfully.");
	}
}
