package Backend_TestCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class ManageLinks extends BaseClass{

	@Test
	public void openManageLinks() {
			application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
			application.wait(2);
			application.click("manageLinksButton_xpath" , "Manage Links Button");
			application.wait(5);
	}
	@Test
	public void addLink() {
		application.click("manageLinksAddLinkButton_xpath" , "Manage Links Add Links Button");
		application.validateElementPresent("manageLinksTabAddLinkButton_xpath", "Add link Tab button");
		application.validateElementPresent("manageLinksTabCompanytext_xpath", "Company label");
		application.validateElementPresent("manageLinksTabSelectCompany_xpath", "Company Selector Dropdown");
		application.validateElementPresent("managelinkTabFilterButton_xpath", "Manage Links tab Company Filter  button");
		application.validateElementPresent("manageLinksTabShowFilter_xpath", "Show Filters");
		application.validateElementPresent("manageLinksTabSearchTab_xpath", "Search bar");
		application.validateElementPresent("managelinksTabTable_xpath", "Manage links table");
	}
	
	@Test
	public void editTab() {
		application.scrollTo("manageLinksTabSearchTab_xpath");
		application.type("manageLinksTabSearchTab_xpath", readExcelData("Edit_Link_Tab", "ManageLinks"));
		application.clickLastColumnButtonForFirstColumnValue("managelinksTabTable_xpath", "manageLinksTabTable1stColumn_xpath", "Edit_Link_Tab", 
				"ManageLinks", "manageLinksTableTableEditButton_xpath");
		application.validateElementPresent("managelinksTabEditTabTitle_xpath", "Manage Links tab edit tab title");
		application.validateElementPresent("manageLinksTabEditTabCompanytext_xpath", "Manage Links tab edit Tab Company label");
		application.validateElementPresent("managelinksTabEditTabLinkTypeText_xpath", "Manage Links tab edit Tab Links type label");
		application.validateElementPresent("managelinksTabEditTabNameTypeText_xpath", "Manage Links tab edit Tab name label");
		application.validateElementPresent("manageLinksTabEditTabUpdateButton_xpath", "Manage Links tab edit Tab Update Button label");
		application.validateElementPresent("manageLinksTabEditTabCancelButton_xpath", "Manage Links tab edit Tab Cancel Button label");
		application.validateElementPresent("manageLinksTabEditTabCompanyDropdown_xpath", "Manage Links tab edit Tab Company Dropdown label");
		application.validateElementPresent("manageLinksTabEditTabLinkTypeDropdown_xpath", "Manage Links tab edit Tab LinkType dropdown label");
//		application.getTextFromInput("manageLinksTabEditTabName_xpath");
		application.wait(2);
		
		
	}
	
}
