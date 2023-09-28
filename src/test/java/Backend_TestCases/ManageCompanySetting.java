package Backend_TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ManageCompanySetting extends BaseClass{
	@Test
	public void openManageCompanySetting() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageCompanySetting_xpath" , "Manage Company Setting");
		application.wait(5);
	}
	@Test
	public void validateManageCompanySettingPage() {
		application.validateElementPresent("manageCompanySettingShowEntriesFilter_xpath");
		application.validateElementPresent("manageCompanySettingSearch_xpath");
		application.validateElementPresent("manageCompanySettingCreateCompany_xpath");
		application.validateElementPresent("manageCompanySettingTableHeader_xpath", "Manage Company Setting Header");
		application.validateContainsText("manageCompanySettingTableHeader_xpath", "Company");
		application.scrollTo("manageCompanySettingShowingResults_xpath");
		application.validateElementPresent("manageCompanySettingShowingResults_xpath");
		application.validateElementPresent("manageCompanySettingPagination_xpath", "Pagination");
		application.wait(5);
	}
	
	@Test
	public void validateCreateCompanyForm() {
		application.scrollTo("createCompanybutton_xpath");
		application.click("createCompanybutton_xpath","Create Company Button");
		application.wait(2);
		application.validateElementPresent("createCompanyLicenseeText_xpath");
		application.validateMandatoryIconForLabel("Licensee");
		application.validateElementPresent("createCompanyDomainText_xpath");
		application.validateMandatoryIconForLabel("Company Domain");
		application.validateElementPresent("createCompanyDomainNote_xpath", "Company Domain Note");
		application.validateCompareText("createCompanyDomainNote_xpath", "Domain should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyNoOfCardsLabel_xpath", "Create Company No Of Cards Label");
		application.validateMandatoryIconForLabel("No. of cards");
		application.validateElementPresent("createCompanyTypeLabel_xpath", "Create Company , Company Type Label");
		application.validateMandatoryIconForLabel("Company Type");
		application.validateElementPresent("createCompanyStartDateLabel_xpath", "Create Company Start Date Label");
		application.validateMandatoryIconForLabel("Start Date");
		application.validateElementPresent("createCompanyEndDateLabel_xpath", "Create Company end Date Label");
		application.validateMandatoryIconForLabel("End Date");
		application.validateElementPresent("createCompanyNameText_xpath");
		application.validateMandatoryIconForLabel("Company Name");
		application.validateElementPresent("createCompanyDefaultCompanyText_xpath");
		application.validateElementPresent("createCompanyDescriptionText_xpath");
		application.validateElementPresent("createCompanyWebsiteUrlText_xpath");
		application.validateMandatoryIconForLabel("Website URL");
		application.validateElementPresent("createCompanyWebsiteURLNote_xpath", "Website URL Note");
		application.validateCompareText("createCompanyWebsiteURLNote_xpath", "URL should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyAddress1Text_xpath");
		application.validateElementPresent("createCompanyAddress2Text_xpath");
		application.validateElementPresent("createCompanyCountryText_xpath");
		application.validateElementPresent("createCompanyStateText_xpath");
		application.validateElementPresent("createCompanyCityText_xpath");
		application.validateElementPresent("createCompanyPincodeText_xpath");
		application.validateElementPresent("createCompanyCountryCodeLabel_xpath", "Create Company Country Code");
		application.validateElementPresent("createCompanyAreaCodelabel_xpath", "Create Company Area Code");
		
		
		
		
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.validateElementPresent("createCompanyEmailAddressText_xpath");
		application.validateMandatoryIconForLabel("Email Address");
//		application.validateElementPresent("createCompanySTDCodeText_xpath");
//		application.validateMandatoryIconForLabel("STD Code");
		application.validateElementPresent("createCompanyLandLineText_xpath");
		application.validateMandatoryIconForLabel("Landline Number");
		application.validateElementPresent("createCompanyCorrectionText_xpath");
		application.validateMandatoryIconForLabel("Correction Request Email Id");
		application.validateElementPresent("createCompanyDefaultLanguageText_xpath");
		application.validateMandatoryIconForLabel("Default Language");
		application.validateElementPresent("createCompanyFacebookText_xpath");
		application.validateElementPresent("createCompanyYoutubeText_xpath");
		application.validateElementPresent("createCompanyTwitterText_xpath");
		application.validateElementPresent("createCompanyInstagramText_xpath");
		application.validateElementPresent("createCompanyLinkedInText_xpath");
		application.validateElementPresent("createCompanyWhatsappDescText_xpath");
		application.validateElementPresent("createCompanySMSText_xpath");
		application.validateMandatoryIconForLabel("SMS Content");
		application.scrollTo("createCompanyQRCodeText_xpath");
		application.validateElementPresent("createCompanyWhatsappMessageContentText_xpath");
		application.validateMandatoryIconForLabel("Company Whatsapp Message Content");
		application.validateElementPresent("createCompanyEmpWhatsappText_xpath");
		application.validateMandatoryIconForLabel("Employee Whatsapp Message Content");
		application.validateElementPresent("createCompanyWhatsappContentNote_xpath", "Employee Whatsapp message Content");
		application.validateContainsText("createCompanyWhatsappContentNote_xpath","Note");
		application.validateElementPresent("createCompanyEnquiryText_xpath");
		application.validateMandatoryIconForLabel("Company Enquiry Form Link");
		application.validateElementPresent("createCompanyEnquiryFormNote_xpath", "Enquiry Form Note");
		application.validateCompareText("createCompanyEnquiryFormNote_xpath", "URL should start with http:// or https:// or www and space is not allowed");
		application.validateElementPresent("createCompanyEmpProfilePicText_xpath");
		application.validateElementPresent("createCompanyWhatsappPreviewText_xpath");
		application.validateContainsText("createCompanyWhatsappPreviewRecommendedNote_xpath", "256x256 pixels (300KBs or less)");
		application.validateElementPresent("createCompanyQRCodeText_xpath");
		application.validateContainsText("createCompanyQRCodeRecommendedNote_xpath", "130x130 px (300KBs or less)");
		application.validateElementPresent("createCompanyCompanyLogoText_xpath");
		application.validateMandatoryIconForLabel("Company Logo");
		application.validateContainsText("createCompanyLogoRecommendedNote_xpath", "width 280px (300KBs or less)");
		application.validateElementPresent("createCompanySaveButton_xpath","Create Company Popup Save Button");
		application.validateElementPresent("createCompanyCancelButton_xpath", "Create Company Popup Cancel  button");
		application.click("createCompanySaveButton_xpath" , "Create Company Save button");
		
		
		//validate errors
		application.scrollTo("createCompanyLicenseeText_xpath");
		application.validateElementPresent("createCompanyLicenseeError_xpath", "Licensee Error");
		application.validateCompareText("createCompanyLicenseeError_xpath", "Licensee is required");
		application.validateElementPresent("createCompanyDomainError_xpath", "Company Domain Error");
		application.validateCompareText("createCompanyDomainError_xpath", "Company domain is required field");
		application.validateElementPresent("createCompanyNameError_xpath", "Company Name Error");
		application.validateCompareText("createCompanyNameError_xpath", "Company name is required.");
		application.validateElementPresent("createCompanyWebsiteURLError_xpath", "Website URL Error");
		application.validateCompareText("createCompanyWebsiteURLError_xpath", "Website URL is required");
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.validateElementPresent("createCompanyEmailError_xpath", "Email required Error.");
		application.validateCompareText("createCompanyEmailError_xpath", "Email is required.");
		application.validateElementPresent("createCompanySTDError_xpath", "STD Code Error.");
		application.validateCompareText("createCompanySTDError_xpath", "STD code is required");
		application.validateElementPresent("createCompanyLandlineError_xpath", "Landline number Error");
		application.validateCompareText("createCompanyLandlineError_xpath", "Landline number is required");
		application.validateElementPresent("createCompanyCorrectionReqError_xpath", "Correction request Email Error.");
		application.validateCompareText("createCompanyCorrectionReqError_xpath", "Email is required");
		application.validateElementPresent("createCompanyDefaultLangError_xpath", "Default Language Error");
		application.validateCompareText("createCompanyDefaultLangError_xpath", "Default language is required");
		application.validateElementPresent("createCompanySMSError_xpath", "SMS Content Error");
		application.validateCompareText("createCompanySMSError_xpath", "SMS Content is required");
		application.scrollTo("createCompanySMSError_xpath");
		application.validateElementPresent("createCompanyWhastappMsgContentError_xpath", "Whatsapp Message Content Error");
		application.validateCompareText("createCompanyWhastappMsgContentError_xpath", "Company Whatsapp Message Content is required");
		application.validateElementPresent("createCompanyEmpWhastappMsgContentError_xpath", "Employee Whatsapp Message Content Error");
		application.validateCompareText("createCompanyEmpWhastappMsgContentError_xpath", "Employee Whatsapp Message Content is required");
		application.validateElementPresent("createCompanyEnquiryFormError_xpath", "Company Enquiry Form Error");
		application.validateCompareText("createCompanyEnquiryFormError_xpath", "Company Enquiry Form Link is required");
		application.click("createCompanyCancelButton_xpath", "Create Company Cancel button");
		application.wait(2);
		try {
			WebElement table = driver.findElement(getLocator("manageCompanySettingTable_xpath"));
			if(table.isDisplayed()) {
				test.log(Status.PASS, "Create Company PopUp is closed");
			}
		}catch(Exception e) {
			test.log(Status.INFO, "Create Company PopUp is not Closed.");
			generateScreenshots("popup");
		}
	}
	
	@Test
	public void createCompany() throws Exception, Exception {
		application.scrollTo("createCompanybutton_xpath");
		application.click("createCompanybutton_xpath" , "Create Company Button");
		application.wait(2);
		application.type("createCompanyDomain_xpath", readExcelData("Valid_Company_Domain", "CreateCompany"));
		application.click("createCompanyLicenseeText_xpath" , "Create Company Licensee Text");
		application.validateError("createCompanyLicenseeFirstError_xpath", "Please select Licensee first");
		application.clear("createCompanyDomain_xpath");
		application.click("createCompanyLicensee_xpath", "Create Company Licensee Text" );
		application.getText("createCompanyLicenseeDropdownText_xpath");
		generateScreenshots("Licensee Options");
		application.wait(5);
		application.selectOptionUL("createCompanyLicenseeDropdownText_xpath", "Licensee" , "CreateCompany");
//		application.wait(2);
//		application.type("createCompanyNoOfCards_xpath", readExcelData("No_Of_Cards", "CreateCompany"));
//		application.wait(2);
		application.click("createCompanyType_xpath", "Create Company Type");
		application.wait(2);
		application.selectOptionUL("createCompanyTypeDropdown_xpath", "Company_Type", "CreateCompany");
		application.wait(2);
//		application.click("createCompanyStartDate_xpath", "Create Company Start Date");
//		application.selectDateFromExcel("createCompanyStartDateCalender_xpath", "createCompanyStartDateMonth_xpath", "createCompanyStartDateYear_xpath",
//				"Start_Date", "CreateCompany");
		application.type("createCompanyName_xpath", readExcelData("Company_Name", "CreateCompany"));
		application.clickCheckboxBasedOnExcelParameter("createCompanyDefaultCompany_xpath" , "Licensee_Default_Company", "CreateCompany");
		application.wait(2);
		application.type("createCompanyDescription_xpath", readExcelData("Description", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyWebsiteURL_xpath", readExcelData("Website_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyAddress1_xpath", readExcelData("Address1", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyAddress2_xpath", readExcelData("Address2", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyCountry_xpath", readExcelData("Country", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyState_xpath", readExcelData("State", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyCity_xpath", readExcelData("City", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyPincode_xpath", readExcelData("Pincode", "CreateCompany"));
		application.wait(2);
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.click("createCompanyCountryCode_xpath", "Create company Country Code");
		application.wait(2);
		application.selectOptionUL("createCompanyCountryCodeDropdown_xpath", "Country_Code", "CreateCompany");
		application.wait(2);
		application.type("createCompanyAreaCode_xpath", readExcelData("Area_Code", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyEmailId_xpath", readExcelData("Email_Address", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyLandline_xpath", readExcelData("Landline_Number", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyCorrectionEmail_xpath", readExcelData("Correction_Request_EmailID", "CreateCompany"));
		application.wait(2);
		application.click("createCompanySelectDefaultLanguage_xpath" , "Select Default language");
		application.selectOptionUL("createCompanyLanguageDropdown_xpath", "Default_Language", "CreateCompany");
		application.wait(2);
		application.scrollTo("createCompanyFacebookURL_xpath");
		application.type("createCompanyFacebookURL_xpath", readExcelData("FaceBook_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyYoutubeURL_xpath", readExcelData("Youtube_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyTwitterURL_xpath", readExcelData("Twitter_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyInstagramURL_xpath", readExcelData("Instagram_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyLinkedInURL_xpath", readExcelData("LinkedIn_URL", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyWappPreview_xpath", readExcelData("Whatsapp_Preview_Description", "CreateCompany"));
		application.wait(2);
		application.scrollTo("createCompanySMSError_xpath");
		application.type("createCompanySmsContent_xpath", readExcelData("SMS_Content", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyWappMsgContent_xpath", readExcelData("Whatsapp_Message_Content", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyEmpWappContent_xpath", readExcelData("Employee_Whatsapp_Message_Content", "CreateCompany"));
		application.wait(2);
		application.type("createCompanyEnquiryForm_xpath", readExcelData("Enquiry_Form_Link", "CreateCompany"));
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("createCompanyShowProfilepic_xpath", "Show_Employee_Profile_Picture", "CreateCompany");
		application.wait(2);
		application.scrollTo("createCompanyWhatsappPreviewText_xpath");
		application.uploadImage("createCompanyUploadWappPreviewIcon_xpath", "\\Upload\\whatsappicon.png");
		application.wait(2);
		application.uploadImage("createCompanyUploadQRIcon_xpath", "\\Upload\\QR.jpg");
		application.wait(2);
		application.uploadImage("createCompanyLogo_xpath" , "\\Upload\\logo.png");
		//application.validateCompareText("updateLicenseePopUp_xpath", "Licensee details has been updated successfully.");
		application.wait(5);
		application.click("createCompanySaveButton_xpath" ,"Create Company Save Button");
		application.wait(2);
		application.validateCompareText("updateLicenseePopUp_xpath", "Licensee details has been updated successfully.");
	}
	
	@Test
	public void copyCompanyLanguage() {
		application.type("managaCompanySearchBar_xpath", readExcelData("Company_Name", "ManageCompanySetting"));
		//application.clickButtonInLastColumnByFirstColumnValue("manageCompanyTable_xpath", "Company_Name","ManageCompanySetting", "manageCompanySettingCopyData_xpath");
		application.click("manageCompanySettingCopyData_xpath" , "Manage Company Setting Copy data");
		application.validateElementPresent("manageCompanylanguageLabel_xpath", "Language label");
		application.validateElementPresent("manageCompanyLanguagebutton_xpath", "Language Selector");
		application.validateElementPresent("manageCompanySettingFillDataButton_xpath", "Fill Data Button");
		application.validateElementPresent("manageCompanySettingCancelButton_xpath", "Cancel Button");
		application.changeLanguage("manageCompanyLanguagebutton_xpath","Language","ManageCompanySetting");
		application.wait(2);
		application.click("manageCompanySettingFillDataButton_xpath" , "Manage Company Setting Fill data button");
		application.wait(5);
		application.validateElementPresentText("fillDataLicenseeNameText_xpath", "Hindi Licensee name");
		application.click("fillDataPopUpCloseButton_xpath" , "Manage Company setting fill data popup close button");
		application.wait(5);
		application.clear("managaCompanySearchBar_xpath");
	}
	@Test
	public void changeCompanyStatus() {
		application.type("managaCompanySearchBar_xpath", readExcelData("Company_Name", "ManageCompanySetting"));
		application.wait(5);
		application.changeComapanyStatus("Company_Status" , "ManageCompanySetting");
		try {
		application.validateElementPresent("manageCompanySettingUpdateCompanyStatusPopUpVerificationText_xpath", "Company Status verification popup");
		application.validateElementPresent("manageCompanySettingCompanyStatusPopUpCloseButton_xpath", "PopUp Close button");
		application.wait(3);
		application.validateElementPresent("manageCompanySettingCompanyStatusPopUpCancelButton_xpath", "PopUp Cancel Button");
		application.validateElementPresent("manageCompanySettingCompanyStatusPopUpOkButton_xpath", "PopUp Ok Button");
		application.click("manageCompanySettingCompanyStatusPopUpOkButton_xpath" , "Manage Company Setting Company Status PopUp Ok Button");
		}catch(Exception e){
			test.log(Status.INFO, "Company Status is same as defined.");
		}
		application.wait(5);
		application.validateElementPresent("managaCompanySearchBar_xpath", "Search");
		
	}
	
	@Test
	public void cardEmailSetting() {
		application.type("managaCompanySearchBar_xpath", readExcelData("Company_Name", "ManageCompanySetting"));
		application.wait(5);
		application.click("manageCompanySettingCardEmailSettingButton_xpath", "Manage Company Setting Card Email Setting Button");
		application.wait(3);
		application.validateElementPresent("cardEmailSettingPopupTitle_xpath", "Card Email Setting Title");
		application.validateElementPresent("cardEmailSettingEditUpdateEmailLabel_xpath", "Card Email Setting Edit/Update Email label");
		application.validateElementPresent("cardEmailSettingAllowWebLoginOTPLabel_xpath", "Card Email Setting Allow Web Login label");
		application.validateElementPresent("cardEmailSettingPopupSaveButton_xpath", "Card Email Setting Save Button");
		application.validateElementPresent("cardEmailSettingPopupCancelButton_xpath", "Card Email Setting Cancel Button");
		application.validateElementPresent("cardEmailSettingEditUpdateEmail_xpath", "Card Email Setting Edit/Update Email");
		application.validateElementPresent("cardEmailSettingAllowWebLoginOTP_xpath", "Card Email Setting Allow Web Login");
		application.wait(3);
		application.clickCheckboxBasedOnExcelParameter("cardEmailSettingEditUpdateEmail_xpath", "Allow card edit/update email", "ManageCompanySetting");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("cardEmailSettingAllowWebLoginOTP_xpath", "Allow web login OTP", "ManageCompanySetting");
		application.wait(2);
		application.click("cardEmailSettingPopupSaveButton_xpath", "Card Email Setting Save Button");
		application.wait(1);
		application.validateCompareText("cardEmailSettingSucessfulPopup_xpath", "Email setting has been saved successfully");
	}
	
	@Test
	
	public void adminSetting() throws Exception {
		application.type("managaCompanySearchBar_xpath", readExcelData("Company_Name", "ManageCompanySetting"));
		application.wait(5);
		application.click("adminSettingButton_xpath", "Admin Setting Button");
		application.wait(3);
		application.validateElementPresent("adminSettingStartDateLabel_xpath", "Admin Setting Start Date label");
		application.validateElementPresent("adminSettingEndDateLabel_xpath", "Admin Setting End Date label");
		application.validateElementPresent("adminSettingNoOfCardlabel_xpath", "Admin Setting No Of Cards label");
		application.validateElementPresent("adminSettingCompanyTypeLabel_xpath", "Admin Setting Company Type label");
		application.validateElementPresent("adminSettingSaveButton_xpath", "Admin Setting Save Button");
		application.validateElementPresent("adminSettingCancelButton_xpath", "Admin Setting Cancel Button");
		application.validateElementPresent("adminSettingStartDate_xpath", "Admin Setting Start Date");
		application.validateElementPresent("adminSettingEndDate_xpath", "Admin Setting End Date");
		application.validateElementPresent("adminSettingNoOfCards_xpath", "Admin Setting No Of Cards");
		application.validateElementPresent("adminSettingCompanyType_xpath", "Admin Setting Company Type");
		application.wait(3);
		
		application.clear("adminSettingStartDate_xpath");
		application.clear("adminSettingEndDate_xpath");
		application.clear("adminSettingNoOfCards_xpath");
		application.click("adminSettingCompanyType_xpath", "Admin Setting Company Type");
		application.click("adminSettingCompanyTypeSelect_xpath", "Admin setting Company Type Select");
		application.click("adminSettingSaveButton_xpath", "Admin Setting Save Button");
		application.validateElementPresent("adminSettingStartDateError_xpath", "Admin Settings From Date field Required error");
		application.validateError("adminSettingStartDateError_xpath", "Required field");
		application.validateElementPresent("adminSettingEndDateError_xpath", "Admin Settings To Date field Required error");
		application.validateError("adminSettingEndDateError_xpath", "Required field");
		application.validateElementPresent("adminSettingNoOfCardsRequiredError_xpath", "Admin Settings No Of Cards field Required error");
		application.validateError("adminSettingNoOfCardsRequiredError_xpath", "Required field");
		application.validateElementPresent("adminSettingCompanyTypeError_xpath", "Admin Settings Company Required Error");
		application.validateError("adminSettingCompanyTypeError_xpath", "Required field");
		application.wait(2);
		application.type("adminSettingNoOfCards_xpath", "90034");
		application.click("adminSettingStartDateLabel_xpath", "Start date label");
		application.validateElementPresent("adminSettingCardsGreaterThanError_xpath", "Admin Settings No of cards greater than licensee cards error.");
		application.validateError("adminSettingCardsGreaterThanError_xpath", "No. of cards should not be greater then licensee cards");
		application.wait(5);
		application.refreshPage();
		
		
		application.click("adminSettingStartDate_xpath", "Admin Setting Start Date");
		application.selectDateFromExcel("adminSettingStartDateCalender_xpath", "adminSettingStartDateMonth_xpath", "adminSettingStartDateYear_xpath",
				"Admin_Setting_Start_Date", "ManageCompanySetting");
		application.wait(3);
		application.click("adminSettingEndDate_xpath", "Admin Setting End Date ");
		application.selectDateFromExcel("adminSettingEndDateCalender_xpath", "adminSettingEndDateMonth_xpath", "adminSettingEndDateYear_xpath",
				"Admin_Setting_To_Date", "ManageCompanySetting");
		application.clear("adminSettingNoOfCards_xpath");
		application.type("adminSettingNoOfCards_xpath", readExcelData("Admin_Setting_No_of_Cards", "ManageCompanySetting"));
		application.wait(2);
		application.click("adminSettingCompanyType_xpath", "Admin Setting Company Type");
		application.selectOptionUL("adminSettingCompanyTypeDropdown_xpath", "Admin_Setting_Company_Type", "ManageCompanySetting");
		application.wait(2);
		application.click("adminSettingSaveButton_xpath", "Admin Setting Save Button.");
		application.wait(1);
		application.validateCompareText("adminSettingSaveUpdatePopup_xpath", "Setting has been update successfully");
		
	}
	
}
