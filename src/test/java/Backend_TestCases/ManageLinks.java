package Backend_TestCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageLinks extends BaseClass{

	@Test
	public void openManageLinks() {
			application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
			application.wait(2);
			application.click("manageLinkButton_xpath" , "Manage Links Button");
			application.wait(5);
	}
	@Test
	public void validateManageLinks() {
		application.click("manageLinkTabButton_xpath", "Manage Links Tab");
		application.validateElementPresent("manageLinkTabAddLinkTab_xpath", "Add link Tab button");
		application.validateElementPresent("manageLinkTabCompanyLabel_xpath", "Manage Link tab Company label");
		application.validateElementPresent("manageLinkTabSelectCompany_xpath", "Manage Link tab Company Selector Dropdown");
		application.validateElementPresent("managelinkTabFilterButton_xpath", "Manage Links tab Company Filter  button");
		application.validateElementPresent("manageLinkTabShowFilter_xpath", "Manage Link tab Show Filters");
		application.validateElementPresent("manageLinkTabSearchTab_xpath", "Manage Link tab Search bar");
		application.validateElementPresent("managelinkTabTable_xpath", "Manage Link tab table");
		application.wait(3);
		application.click("manageLinks_xpath", "Manage Links");
		application.wait(3);
		application.validateElementPresent("manageLinksAddLinkButton_xpath", "Add link button");
		application.validateElementPresent("manageLinksCompanyLabel_xpath", "Manage Links Company label");
		application.validateElementPresent("manageLinksLinkTabLabel_xpath", "Manage Links Link tab");
		application.validateElementPresent("manageLinksSelectCompany_xpath", "Manage Links Company Selector Dropdown");
		application.validateElementPresent("manageLinksFilterButton_xpath", "Manage Links tab Company Filter  button");
		application.validateElementPresent("manageLinksShowFilter_xpath", "Manage Links Show Filters");
		application.validateElementPresent("manageLinksSearch_xpath", "Manage Links Search bar");
		application.validateElementPresent("managelinksTable_xpath", "Manage links table");
	}
	
	
	@Test
	public void addLinkTab() {
		application.click("manageLinkTabButton_xpath", "Manage Links Tab");
		application.wait(3);
		application.click("manageLinkTabAddLinkTab_xpath", "Manage Links tab add link tab Button");
		application.wait(3);
		application.validateElementPresent("addLinkTabTitle_xpath", "Add Links Tab Popup title");
		application.validateElementPresent("addLinkTabCompanyLabel_xpath", "Add Links Tab Company Label");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("addLinkTabLinkTypeLabel_xpath", "Add link Tab Link type Label");
		application.validateMandatoryIconForLabel("Link Type");
		application.validateElementPresent("addLinkTabNameLabel_xpath", "Add Link Tab Name Label");
		application.validateMandatoryIconForLabel("Tab Name");
		application.wait(2);
		application.click("addLinkTabCompany_xpath", "Add Link Tab select Company");
		application.selectOptionDivUlLi("addLinkTabCompanyDropdown_xpath", "Link_Tab_Company", "ManageLinks");
		application.wait(2);
		application.click("addLinkTabLinkType_xpath", "Add Links Link type");
		application.selectOptionDivUlLi("addLinkTabLinksTypeDropdown_xpath", "Link_Type", "ManageLinks");
		application.wait(2);
		application.type("addLinkTabName_xpath", readExcelData("Tab_Name", "ManageLinks"));
		application.validateElementPresent("addLinkTabSaveButton_xpath", "Add Link Tab Save Button");
		application.validateElementPresent("addLinkTabCancelButton_xpath", "Add Link Tab Cancel Button");
		application.click("addLinkTabSaveButton_xpath", "Add Link Tab Save Button");
		application.validateCompareText("addLinkTabPopUp_xpath", "Link saved Successfully", "Only 1 website tab is allowed for each company");
	}
	
	
	@Test
	public void editTab() {
		application.scrollTo("manageLinkTabSearchTab_xpath");
		application.type("manageLinkTabSearchTab_xpath", readExcelData("Edit_Link_Tab", "ManageLinks"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("managelinkTabTable_xpath", "manageLinksTabTable1stColumn_xpath", "Edit_Link_Tab", 
				"ManageLinks", "manageLinksTabTableEditButton_xpath");
		application.validateElementPresent("managelinksTabEditTabTitle_xpath", "Manage Links tab edit tab title");
		application.validateElementPresent("manageLinksTabEditTabCompanytext_xpath", "Manage Links tab edit Tab Company label");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("managelinksTabEditTabLinkTypeText_xpath", "Manage Links tab edit Tab Links type label");
		application.validateMandatoryIconForLabel("Link Type");
		application.validateElementPresent("managelinksTabEditTabNameText_xpath", "Manage Links tab edit Tab name label");
		application.validateMandatoryIconForLabel("Tab Name");
		application.validateElementPresent("manageLinksTabEditTabUpdateButton_xpath", "Manage Links tab edit Tab Update Button label");
		application.validateElementPresent("manageLinksTabEditTabCancelButton_xpath", "Manage Links tab edit Tab Cancel Button label");
		application.validateElementPresent("manageLinksTabEditTabCompanyDropdown_xpath", "Manage Links tab edit Tab Company Dropdown label");
		application.validateElementPresent("manageLinksTabEditTabLinkTypeDropdown_xpath", "Manage Links tab edit Tab LinkType dropdown label");
		application.gettextFromInputField("addLinkTabName_xpath");
		application.type("addLinkTabName_xpath", readExcelData("Tab_Name", "ManageLinks"));
		application.wait(2);
		application.click("manageLinksTabEditTabSaveButton_xpath", "Edit Link tab save Button");
	}
	
	@Test
	
	public void addLink() {
		application.click("manageLinks_xpath", "Manage Links");
		application.wait(3);
		application.click("manageLinksAddLinkButton_xpath", "Add Link Button");
		application.wait(2);
		application.click("addLinkSelectCompany_xpath", "Add link Select Company");
		application.wait(2);
		application.selectOptionDivUlLi("addLinkCompanydropdown_xpath", "AddLink_Company", "ManageLinks");
		application.wait(2);
		application.click("addLinkLinkTab_xpath", "Add Link , Link Tab");
		application.wait(2);
		application.selectOptionDivUlLi("addLinkLinkTabDropdown_xpath", "AddLink_Tab", "ManageLinks");
		application.wait(2);
		application.type("addLinkTitle_xpath", readExcelData("AddLink_Title", "ManageLinks"));
		application.type("addLinkURL_xpath", readExcelData("Add_Link", "ManageLinks"));
		application.click("addLinkSaveButton_xpath", "Add Links save Button");
		application.wait(1);
		application.validateCompareText("addLinkPopup_xpath", "Link has been added successfully");

	}
	
	@Test
	public void editLink() {
		application.click("manageLinks_xpath", "Manage Links");
		application.wait(2);
		application.type("manageLinksSearch_xpath", readExcelData("EditLink_Search", "ManageLinks"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("managelinksTable_xpath", "manageLinksTableFirstColumn_xpath", "EditLink_Search", 
				"ManageLinks", "manageLinksTableEditButton_xpath");
		application.wait(3);
		application.validateElementPresent("editLinkHeading_xpath", "Edit Links Heading");
		application.validateElementPresent("editLinkCompanyLabel_xpath", "Edit Links Company label");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("editLinkTabLabel_xpath", "Edit Links Tab Label");
		application.validateMandatoryIconForLabel("Link Tab");
		application.validateElementPresent("editLinkTitleLabel_xpath", "Edit Links TitleLabel");
		application.validateMandatoryIconForLabel("Title");
		application.validateElementPresent("editLinkLabel_xpath", "Edit Links Label");
		application.validateMandatoryIconForLabel("Link");
		application.click("editLinkCompany_xpath", "Edit Links Company");
		application.wait(2);
		application.selectOptionDivUlLi("editLinkCompanyDropdown_xpath", "EditLink_Company", "ManageLinks");
		application.wait(2);
		application.click("editLinkTab_xpath", "Edit Links Tab");
		application.wait(2);
		application.selectOptionDivUlLi("editLinkTabDropdown_xpath", "EditLink_LinkTab", "ManageLinks");
		application.wait(2);
		application.type("editLinkTitle_xpath", readExcelData("EditLink_Title", "ManageLinks"));
		application.wait(2);
		application.type("editLink_xpath", readExcelData("EditLink_Link", "ManageLinks"));
		application.wait(2);
		application.click("editLinkUpdateButton_xpath", "Edit Link update Button");
		
	}
	
	@Test
	
	public void enableDisableLinks() {
		application.click("manageLinks_xpath", "Manage Links");
		application.wait(2);
		application.type("manageLinksSearch_xpath", readExcelData("Enable/Disable_Search", "ManageLinks"));
		application.wait(2);
		application.getLastColumnButtonForFirstColumnValue("managelinksTable_xpath", "manageLinksTableFirstColumn_xpath", "EditLink_Search", "Status",
				"ManageLinks", "manageLinksTableStatusButton_xpath");
		application.wait(2);
		application.click("manageLinksEnableDisableOkButton_xpath", "Enable/Disable Ok Button");
	}
	
	
	@Test
	public void deleteLink() {
		application.click("manageLinks_xpath", "Manage Links");
		application.wait(2);
		application.type("manageLinksSearch_xpath", readExcelData("DeleteLink_Search", "ManageLinks"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("managelinksTable_xpath", "manageLinksTableFirstColumn_xpath", "DeleteLink_Search",
				"ManageLinks", "manageLinksDeleteButton_xpath");
		application.wait(2);
		application.click("manageLinksDeletePopupOkButton_xpath", "Links Delete popup Ok Button");
		application.wait(2);
	}
}
