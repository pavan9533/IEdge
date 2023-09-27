package Backend_TestCases;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ChangeLanguage extends BaseClass{
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
	            application.click("selectEnglish_xpath" , "Select English");
	            test.log(Status.INFO, "English Language is Selected.");
	            break;
	        case "hindi":
	            application.validateElementPresent("selectHindi_xpath");
	            application.click("selectHindi_xpath", "Select Hindi");
	            test.log(Status.INFO, "Hindi Language is Selected.");
	            break;
	        case "japanese":
	            application.validateElementPresent("selectJapanese_xpath");
	            application.click("selectJapanese_xpath", "Select Japanese");
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
