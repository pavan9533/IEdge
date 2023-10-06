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
		application.validateElementPresent("dashboardSelectCompany_xpath", "Select Company");
		application.validateElementPresent("dashboardCustomDateLabel_xpath", "Custom Range Label");
	}
	
	@Test
	public void validateDashboard() throws Exception {
		application.click("dashboardSelectCompany_xpath" , "Select Company");
		application.selectOptioncompany("dashboardCompanyDropdown_xpath", "Company" , "Dashboard");
		application.wait(2);
		String range = application.readExcelData("CustomRange", "Dashboard").get(0);
		application.click("dashboardSelectDateType_xpath", "Select Date Type");
		application.selectOptionDivUlLi("dashboardCustomDateDropdown_xpath", "CustomRange", "Dashboard", range);
		application.wait(2);
		if(range.equalsIgnoreCase("custom date")) {
			application.click("dashboardFromDate_xpath" , "Dashboard From date");
			application.selectDateFromExcel("dashboardFromDateCalender_xpath","dashboardFromDateMonth_xpath", "dashboardFromDateYear_xpath",
					"Invalid_From_Date", "Dashboard");
			application.validateError("dashboardFromDateError_xpath", "Date should not be greater the today's date");
			application.wait(2);
			application.click("dashboardFromDate_xpath" , "Dashboard From date");
			application.selectDateFromExcel("dashboardFromDateCalender_xpath", "dashboardFromDateMonth_xpath", "dashboardFromDateYear_xpath",
					"FromDate", "Dashboard");
			application.wait(2);
			application.click("dashboardToDate_xpath" , "Dashboard To date");
			application.selectDateFromExcel("dashboardToDateCalender_xpath","dashboardToDateMonth_xpath", "dashboardToDateYear_xpath",
					"Invalid_To_Date" , "Dashboard");
			application.wait(2);
			application.validateError("daashboardInvalidDateError_xpath", "To date should not be less then from date");
			application.wait(2);
			application.click("dashboardToDate_xpath" , "Dashboard To date");
			application.selectDateFromExcel("dashboardToDateCalender_xpath","dashboardToDateMonth_xpath", "dashboardToDateYear_xpath",
					"ToDate" , "Dashboard");
			application.click("dashboardFilterbutton_xpath" , "Dashboard Filter Button");
		}
		application.wait(5);
		application.scrollByValue("10000");
		generateScreenshots("Dashboard Chart");
	}
	@Test
	public void changeLanguage() {
		application.wait(3);
		application.scrollTo("languageSelector_xpath");
		application.wait(2);
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
