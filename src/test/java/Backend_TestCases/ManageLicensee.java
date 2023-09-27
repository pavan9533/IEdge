	package Backend_TestCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ManageLicensee extends BaseClass{
	@Test
	public void openManageLicensee() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageLicenseeButton_xpath" , "Manage Licensee Button");
		application.wait(5);
	}
	
	@Test
	public void validateManageLicenseePage() {
		application.validateElementPresent("showEntriesFilter_xpath");
		application.validateElementPresent("searchlicensee_xpath");
		application.validateElementPresent("createLicenseeButton_xpath");
		application.validateLicenseeTableHeaders("licenseeTableLocator_xpath");
		application.scrollByValue("10000");
		application.validateElementPresent("licenseeTableDataInfo_xpath");
	}
	@Test
	public void changeEntriesFilter() {
		openManageLicensee();
		application.validateElementPresentText("showEntriesFilter_xpath", "Number of entries filter");
		application.wait(3);
	    List<String> NoOfLicenseeFilter = application.getTextFromExcel("LicenseePerPage", "CreateLicensee"); 
	    if (NoOfLicenseeFilter.isEmpty()) {
	        test.log(Status.FAIL, "Language is not defined in the test data sheet.");
	        application.wait(5);
	        return;
	    }else {
	    	application.selectFromDown("showEntriesFilter_xpath", "LicenseePerPage", "CreateLicensee");
	    	test.log(Status.PASS, "filter sort changed to "+NoOfLicenseeFilter);
	    	generateScreenshots("Licensee Per Page Filers");
	    }
	}
	@Test
	public void createLicensee() {
		application.click("createLicenseeButton_xpath" , "Create Licensee Button");
		application.wait(2);
		application.validateElementContains("createLicenseePopupText_xpath" , "Create Licensee");
		application.validateElementPresent("licenseeNameText_xpath", "Licensee name Text");
		application.validateElementPresent("licenseeCompanyDomainText_xpath" , "Company Domain Text");
		application.validateElementPresent("allowDomainChangeText_xpath" , "Allow Domain Text");
		application.validateElementPresent("allowIDCardText_xpath" , "Allow ID Card Text");
		application.validateElementPresent("licenseeStartDateText_xpath" , "Start Date Text");
		application.validateElementPresent("licenseeEndDateText_xpath" , "To Date Text");
		application.validateElementPresent("licenseeNoOfCardsText_xpath" , "Number of Cards text");
		application.validateElementPresent("licenseeAllowMultiLanguageText_xpath" , "Allow Multi Language Text");
		application.validateElementPresent("createLicenseeSaveButton_xpath" , "Save Button");
		application.validateElementPresent("createLicenseeCancelButton_xpath","Cancel button");
		application.click("createLicenseeSaveButton_xpath" , "Create Licensee Save Button");
		application.validateFieldRequiredErrors("createLicenseeNameFieldRequiredText_xpath" , "createLicenseeCompanyDomainFieldRequiredText_xpath",
				"createLicenseeFromDateFieldRequiredText_xpath" , "createLicenseeToDateFieldRequiredText_xpath",
				"createLicenseeNoOfCardsFieldRequiredText_xpath");
		application.type("createLicenseeName_xpath", readExcelData("LicenseeName", "CreateLicensee"));
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateErrorNotDisplayed("createLicenseeNameFieldRequiredText_xpath" , "Licensee Name");
		application.type("createLicenseeDomain_xpath", readExcelData("InvalidCompanyDomain", "CreateLicensee"));
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateError("createLicenseeInvalidDomain_xpath","Please enter valid domain name");
		application.clear("createLicenseeDomain_xpath");
		application.type("createLicenseeDomain_xpath", readExcelData("ValidCompanyDomain", "CreateLicensee"));
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateErrorNotDisplayed("createLicenseeDulplicateDomain_xpath" , "Duplicate domain error");
		application.click("createLicenseeStartDate_xpath", "Create Licensee Start Date ");
		application.wait(2);
		application.click("createLicenseeStartDate_xpath" , "Create Licensee Start Date ");
		application.wait(2);
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateErrorNotDisplayed("createLicenseeFromDateFieldRequiredText_xpath", "Start date");
		application.populateDatesFromExcel("createLicenseeToDate_xpath", "EndDate", "CreateLicensee");
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateErrorNotDisplayed("createLicenseeToDateFieldRequiredText_xpath", "To Date");
		application.type("createLicenseeNoOfCards_xpath", readExcelData("NoOfCards", "CreateLicensee"));
		application.wait(2);
		application.click("createLicenseeSaveButton_xpath", "Create Licensee Save Button");
		application.validateErrorNotDisplayed("createLicenseeNoOfCardsFieldRequiredText_xpath", "Number of cards");
	}
	@Test
	public void editLicensee() {
		application.clickLastColumnButtonForFirstColumnValue("manageLicenseeTable_xpath","manageLicenceeFirstColumn_xpath", "LicenseeName","ManageLicensee","manageLicenseeTableEdit_xpath");
		application.wait(5);
		application.validateElementPresentText("licenseeNameText_xpath", "licensee name");
		application.validateElementPresent("licenseeCompanyDomainText_xpath" , "Company Domain Text");
		application.validateElementPresent("allowDomainChangeText_xpath" , "Allow Domain Text");
		
		application.validateElementPresent("editLicenseeAllowIDCardText_xpath" , "Allow ID Card Text");
		application.validateElementPresent("licenseeStartDateText_xpath" , "Start Date Text");
		application.validateElementPresent("licenseeEndDateText_xpath" , "To Date Text");
		application.validateElementPresent("licenseeNoOfCardsText_xpath" , "Number of Cards text");
		application.validateElementPresent("licenseeAllowMultiLanguageText_xpath" , "Allow Multi Language Text");
		WebElement AllowDomain = driver.findElement(By.xpath("//input[@id='bIsDomainChangeAllowed']"));
		if (AllowDomain != null) {
		    boolean isSelected = AllowDomain.isSelected();
		    if (isSelected) {
		        test.log(Status.INFO, "Allow Domain Checkbox is Selected");
		        generateScreenshots("Allow Domain Checkbox");
		    } else {
		        test.log(Status.INFO, "Allow Domain Checkbox is not selected");
		        generateScreenshots("Allow Domain Checkbox");
		    }
		} else {
		    test.log(Status.INFO, "Allow Domain Checkbox not found.");
		}
		WebElement AllowIDCard = driver.findElement(By.xpath("//input[@id='bIsIDCardAllowed']"));
		if (AllowIDCard != null) {
		    boolean isSelected = AllowIDCard.isSelected();
		    if (isSelected) {
		        test.log(Status.INFO, "Allow ID Card Checkbox is Selected");
		        generateScreenshots("Allow ID Card Checkbox");
		    } else {
		        test.log(Status.INFO, "Allow ID Card Checkbox is not selected");
		        generateScreenshots("Allow ID Card Checkbox");
		    }
		} else {
		    test.log(Status.INFO, "Allow ID Card Checkbox not found.");
		}
		
		application.scrollByValue("300");
		application.wait(2);
		application.validateElementPresent("manageLicenseeAllowMultiLanguage_xpath", "Allow MultiLanguage Checkbox");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='bIsMultilingual']"));
		if (checkbox != null) {
		    System.out.println("Checkbox found.");
		    boolean isSelected = checkbox.isSelected();
		    System.out.println("Checkbox is selected: " + isSelected);
		    
		    if (isSelected) {
		        application.validateElementPresent("manageLicenseeLanguageText_xpath", "Language Dropdown");
		        application.getText1("editLicenseeLanguage_xpath");
		        generateScreenshots("Languages selected");
		    } else {
		        System.out.println("Checkbox is not selected, skipping validation.");
		        test.log(Status.INFO, "Checkbox is not selected, skipping validation.");
		    }
		} else {
		    System.out.println("Checkbox not found.");
		    test.log(Status.INFO, "Checkbox not found.");
		}

		application.validateElementPresent("editLicenseeUpdateButton_xpath", "Update Button");
		application.validateElementPresent("editLicenseeCancelbutton_xpath", "Cancel Button");
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		application.scrollByValue("500");
		try {
			WebElement companyDetails = driver.findElement(getLocator("editLicenseeCompanyDetailsText_xpath"));
			if(companyDetails.isDisplayed()) {
				test.log(Status.PASS, "Company Details are visible.");
			}
		}catch(Exception e) {
			test.log(Status.INFO, "Company Details are not available.");
		}
		application.clear("editlicenseeNoOfCards_xpath");
		application.type("editlicenseeNoOfCards_xpath", readExcelData("NoOfCards", "ManageLicensee"));
		application.click("editLicenseeUpdateButton_xpath" , "Edit Licensee , update Button");
//		application.wait(1);
//		application.validatePopup("Licensee details has been updated successfully.");
		application.validateElementPresent("updateLicenseePopUp_xpath", "Update Edit Licensee PopUp.");
		application.validateCompareText("updateLicenseePopUp_xpath", "Licensee details has been updated successfully.");
	}
	
}
