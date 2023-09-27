package Backend_TestCases;

import java.util.List;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import TestBase.BaseClass;

public class Dashboard extends BaseClass{
	@Test
	public void dashboard() {
		application.validateElementPresent("dashboardLogoLeft_xpath");
		application.validateElementPresent("dashboardTitle_xpath");
		application.validateElementPresent("languageSelector_xpath");
		application.validateElementPresent("profileIcon_xpath");
		application.validateElementPresent("loginUserTitle_xpath");
		application.validateElementPresent("dashboardLogoRight_xpath");
		application.validateElementPresent("dashboardLeftMenu_xpath");
		application.validateElementPresent("dashboardOptionLeftMenu_xpath");
		application.validateElementPresent("configurationOptionLeftMenu_xpath");
		application.validateElementPresent("securityOptionLeftMenu_xpath");
		application.validateElementPresent("reportsOptionLeftMenu_xpath");
		application.validateElementPresent("nonPersonaOptionLeftMenu_xpath");
	
	}
	
	@Test
	public void bulkEmployeeDownload() throws Exception {
		application.click("dashboardSelectCompany_xpath" , "Select Company");
		application.selectOptioncompany("dashboardCompanyDropdown_xpath", "Company" , "Dashboard");
		application.wait(2);
		application.click("dashboardFromDate_xpath" , "Dashboard From date");
		application.selectDateFromExcel("dashboardFromDateCalender_xpath","dashboardFromDateMonth_xpath", "dashboardFromDateYear_xpath",
				"Invalid_From_Date", "Dashboard");
		application.validateError("dashboardFromDateError_xpath", "Date should not be greater the today's date");
		application.wait(2);
		application.click("dashboardFilterbutton_xpath" , "Dashboard Filter Button");
		application.wait(2);
		application.validateError("dashboardromDateReqError_xpath", "Date is required");
		application.wait(5);
		application.click("dashboardFromDate_xpath" , "Dashboard From date");
		application.selectDateFromExcel("dashboardFromDateCalender_xpath", "dashboardFromDateMonth_xpath", "dashboardFromDateYear_xpath", 
				"FromDate", "Dashboard");
		application.wait(2);
		application.validateErrorNotDisplayed("dashboardFromDateError_xpath", "Valid From Date");
		application.click("dashboardToDate_xpath" , "Dashboard To date");
		application.selectDateFromExcel("dashboardToDateCalender_xpath","dashboardToDateMonth_xpath", "dashboardToDateYear_xpath",
				"Invalid_To_Date" , "Dashboard");
		application.wait(1);
		application.validateError("dashboardToDateError_xpath", "Date should not be greater the today's date");
		application.click("dashboardFilterbutton_xpath", "Dashboard Filter Button");
		application.validateError("dashboardToDateReqError_xpath", "Date is required");
		application.click("dashboardToDate_xpath", "Dashboard To date");
		application.selectDateFromExcel("dashboardToDateCalender_xpath","dashboardToDateMonth_xpath", "dashboardToDateYear_xpath",
				"ToDate" , "Dashboard");
		application.wait(2);
		application.validateErrorNotDisplayed("dashboardToDateReqError_xpath", "Valid To Date");
		application.selectOptionUL("dashboardIpAddressType_xpath", "IPType" , "Dashboard");
		application.wait(5);
		
		application.validateElementPresent("dashboardFilterbutton_xpath");
		application.click("dashboardFilterbutton_xpath", "Dashboard Filter Button");
		try {
			try {
			application.type("dashboardEmployeeSearch_xpath", readExcelData("Invalid_Search_Employee", "Dashboard"));
			}catch(Exception e ) {
				test.log(Status.INFO, "Invalid Search Employee is not defined in Test data sheet.");
			}
			application.validateEmployeeNoData();
			application.wait(5);
			application.clear("dashboardEmployeeSearch_xpath");
			application.wait(5);
			try {
			application.type("dashboardEmployeeSearch_xpath", readExcelData("Valid_Search_Employee", "Dashboard"));
			application.wait(5);
			}catch(Exception e) {
				test.log(Status.INFO, "Valid Search Employee is not defined in Test data sheet.");
			}
			application.click("employeeBulkDownloadButton_xpath" , "Employee Download Button");
			application.wait(5);
		}catch(Exception e) {
			test.log(Status.INFO, "Employee name not defined in the test data sheet.");
		}
		application.wait(3);
	   
		    
	}
	@Test
	public void changeLanguage() {
		application.wait(3);
	    List<String> languages = application.getTextFromExcel("Change_Language", "Dashboard");
	    if (languages.isEmpty()) {
	        test.log(Status.FAIL, "Language is not defined in the test data sheet.");
	        application.wait(5);
	        return; 
	    }
	    
	    String language = languages.get(0).toLowerCase(); 
	    
	    application.click("languageSelector_xpath" , "Language Selector");
	    switch (language) {
	        case "english":
	            application.validateElementPresent("selectEnglish_xpath");
	            application.click("selectEnglish_xpath" ,  "Select English");
	            test.log(Status.INFO, "English Language is Selected.");
	            break;
	        case "hindi":
	            application.validateElementPresent("selectHindi_xpath");
	            application.click("selectHindi_xpath",  "Select Hindi");
	            test.log(Status.INFO, "Hindi Language is Selected.");
	            break;
	        case "japanese":
	            application.validateElementPresent("selectJapanese_xpath");
	            application.click("selectJapanese_xpath",  "Select Japanese");
	            test.log(Status.INFO, "Japanese Language is Selected.");
	            break;
	        default:
	            test.log(Status.INFO, "Unsupported language: " + language);
	            break;
	    }
	    generateScreenshots("Dashboard");
	    application.wait(5);
	}
}
