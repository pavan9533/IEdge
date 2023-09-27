package Backend_TestCases;

import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.App;
import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ManageCompany extends BaseClass{
	
	@Test
	public void openManageCompany() {
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(2);
		application.click("manageCompanyButton_xpath" , "Manage Company Button");
		application.wait(5);
	}
	@Test
	public void changeEntriesFilter() {
		openManageCompany();
		application.validateElementPresentText("manageCompanyShowEntriesFilter_xpath", "Number of entries filter");
		application.wait(3);
	    List<String> NoOfCompanyFilter = application.getTextFromExcel("Company_Per_Page", "ManageCompany"); 
	    if (NoOfCompanyFilter.isEmpty()) {
	        test.log(Status.FAIL, "Company Per Page is not defined in the test data sheet.");
	        application.wait(5);
	        return;
	    }else {
	    	application.selectFromDown("manageCompanyShowEntriesFilter_xpath", "Company_Per_Page", "ManageCompany");
	    	test.log(Status.PASS, "filter sort changed to "+NoOfCompanyFilter);
	    	generateScreenshots("Licensee Per Page Filers");
	    }
	}
	@Test
	public void validateManageCompany() {
		application.validateElementPresent("manageCompanySettingShowEntriesFilter_xpath" , "No. of Companies filter.");
		application.validateElementPresent("manageCompanySettingSearch_xpath" , "Search");
		application.validateElementPresent("manageCompanyTableHeader_xpath", "Manage Company Table Header");
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "manageCompanyTableEdit_xpath");
		application.validateElementPresent("manageEditCompanyPopupTitle_xpath", "Update Company Popup");
		application.validateElementPresent("createCompanyLicenseeText_xpath", "Licensee text");
		application.validateMandatoryIconForLabel("Licensee");
		application.validateElementPresent("createCompanyDomainText_xpath");
		application.validateMandatoryIconForLabel("Company Domain");
		application.validateElementPresent("createCompanyDomainNote_xpath", "Company Domain Note");
		application.validateCompareText("createCompanyDomainNote_xpath", "Domain should start with http:// or https:// or www and space is not allowed");
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
		application.scrollTo("createCompanyEmailAddressText_xpath");
		application.validateElementPresent("createCompanyEmailAddressText_xpath");
		application.validateMandatoryIconForLabel("Email Address");
		application.validateElementPresent("createCompanySTDCodeText_xpath");
		application.validateMandatoryIconForLabel("STD Code");
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
		application.validateElementPresent("manageCompanyUpdateButton_xpath","Create Company Popup Update Button");
		application.validateElementPresent("createCompanyCancelButton_xpath", "Create Company Popup Cancel  button");
		application.click("manageCompanyUpdateButton_xpath" , "Manage Company Update Button");
		application.wait(1);
		application.validateContainsText("manageCompanyUpdatePopup_xpath", "successfully");
		application.wait(2);
		application.clear("manageCompanySearch_xpath");
	}
	@Test
	public void selectTheme() {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "manageComapnyEditThemeButton_xpath");
		application.wait(3);
		application.validateElementPresent("manageCompanyThemePageTitle_xpath", "Select Theme Title");
		application.validateElementPresent("manageCompanyTheme1_xpath", "Mobile Theme 1");
		application.validateElementPresent("manageCompanyTheme2_xpath", "Mobile Theme 2");
		application.validateElementPresent("manageCompanyTheme3_xpath", "Mobile Theme 3");
		application.validateElementPresent("manageCompanyTheme4_xpath", "Mobile Theme 4");
		application.wait(2);
		application.scrollTo("manageCompanyTheme5_xpath");
		application.validateElementPresent("manageCompanyTheme5_xpath", "Mobile Theme 5");
		application.validateElementPresent("manageCompanyTheme6_xpath", "Mobile Theme 6");
		application.wait(2);
		application.validateElementPresent("manageCompanyEditThemeCancelButton_xpath", "Cancel Button");
		application.selectTheme("Company_Theme", "ManageCompany");
		application.wait(6);
		application.scrollByValue("10000");
		application.wait(3);
		application.click("selectMobileThemeUpdateButton_xpath" , "Manage Company Select Mobile Theme Update Button");
		application.wait(1);
		application.validateCompareText("updateMobileThemePopUp_xpath", "Theme style has been updated successfully");
		application.wait(3);
		application.validateElementPresent("verifythemePopupClosed_xpath", "Manage Company Page title");
		application.clear("manageCompanySearch_xpath");
	}
	
	@Test
	public void validateCompanySettingsIcon() {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "manageCompanySettingbutton_xpath");
		application.wait(3);
		application.validateElementPresent("companySettingURLPinType_xpath", "URL Pin Type label.");
		application.validateElementPresent("companySettingURLPinTypeEmp_xpath", "Employee option in URL Pin Type");
		application.validateElementPresent("companySettingURLPinTypeMobile_xpath", "Mobile number option in URL Pin Type");
		application.validateElementPresent("companySettingURLPinTypeSystemGenerated_xpath", "System generated option in URL Pin Type");
		application.validateElementPresent("companySettingURLNote_xpath", "URL Pin Type Note");
		application.validateElementPresent("companySettingExampleURL_xpath", "Example URL");
		application.validateElementPresent("companySettingExType_xpath", "URL Pin type Example");
		application.validateElementPresent("companySettingClickToCallText_xpath", "Click to Call text Title");
		application.validateElementPresent("companySettingClickToCallMobileText_xpath", "Click to Call Mobile Option");
		application.validateElementPresent("companySettingClickToCallLandlineText_xpath", "Click to Call Landline Option");
		application.validateElementPresent("companySettingClickToCallNoteText_xpath", "Click to Call Note");
		application.validateElementPresent("companySettingAllowBusinessCardText_xpath", "Allow Business Card Label");
		application.validateElementPresent("companySettingAllowIDText_xpath", "Allow ID card label.");
		application.validateElementPresent("companySettingAllowMultiLangText_xpath", "Allow MultiLanguage label.");
		application.validateElementPresent("companySettingLanguageText_xpath", "Select Language label.");
		application.validateElementPresent("companySettingEnquiryNowText_xpath", "Enquiry Now label.");
		application.scrollTo("companySettingChangeCardSection_xpath");
		application.validateElementPresent("companySettingChangeCardSection_xpath", "Change Card Section");
		application.validateElementPresent("companySettingChangeCardSectionNameText_xpath", "Change Card Section title.");
		application.validateElementPresent("companySettingChangeProductnServiceText_xpath", "Product and Service label.");
		application.validateElementPresent("companySettingChangeVideoTitleText_xpath", "Video Title label.");
		application.validateElementPresent("companySettingChangelinkTitle_xpath", "Video Link Label");
		application.validateElementPresent("companySettingChangelinkTitle_xpath", "Video Link Label");
		application.validateElementPresent("companySettingChangeAboutUsText_xpath", "Change About Us Label");
		application.validateElementPresent("companySettingReArrangeText_xpath", "ReArrange Text");
		application.validateElementPresent("companySettingReArrangeButton_xpath", "ReArrange Button");
		application.validateElementPresent("companySettingUpdateButton_xpath", "Update Company Setting Button");
		application.validateElementPresent("companySettingCancelButton_xpath", "Cancel Company Setting Button");
		application.click("companySettingCancelButton_xpath" , "Manage Company Settings cancel Button");
		application.wait(2);
		application.clear("manageCompanySearch_xpath");
	}
	@Test
	public void updateCompanySetting() {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "manageCompanySettingbutton_xpath");
		application.selectURLPinRadioButton("companySettingEmpNameRadio_xpath" , "companySettingEmpMobileRadio_xpath" ,"companySettingSystemGenRadio_xpath"
				,"URL_Pin_Type" , "CompanySetting");
		application.wait(3);
		application.validateAlert("Are you sure you want to change the card URL structure? This change will regenerate the new card URL and send emails to every employee."
				,"URL Pin Type");
		application.acceptAlert();
		application.wait(5);
		application.validateExampleURl("companySettingExType_xpath" , "URL_Pin_Type" , "CompanySetting");
		application.selectCallNumberRadioButton("companySettingClickToCallMobile_xpath" , "companySettingClickToCallLandline_xpath"
				,"Click_To_Call" , "CompanySetting");
		application.click("companySettingClickToCallViewButton_xpath" , "Company Setting Click To Call View Button");
		application.wait(2);
		application.validateElementPresent("companySettingClickTOCallImg_xpath", "Click to View Profile view");
		generateScreenshots("Click To View.");
		application.validateElementPresent("companySettingClickToCallPreviewText_xpath", "Click To Call View Profile Title");
		application.validateElementPresent("companySettingClickToCallCloseButton_xpath", "Click To Call View Profile close Button");
		application.click("companySettingClickToCallCloseButton_xpath" , "Company Setting Click To Call Close Button");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("companySettingAllowBusinessCardCheckbox_xpath", "Allow_Business_Card", "CompanySetting");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("companySettingAllowIDCheckbox_xpath", "Allow_ID_Card", "CompanySetting");
		application.wait(2);
		application.clickCheckboxBasedOnExcelParameter("companySettingAllowMultiLangCheckbox_xpath", "Allow_MultiLanguage", "CompanySetting");
		String Multilanguage = application.getTextFromExcel("Allow_MultiLanguage", "CompanySetting").get(0);
		if(Multilanguage.equalsIgnoreCase("yes")) {
			application.validateElementPresent("companySettingMultiLangSelector_xpath", "Language Selector Dropdown");
			test.log(Status.PASS, "Language Selector Dropdown is visible if Allow MultiLanguage is enabled.");
		}else if(Multilanguage.equalsIgnoreCase("no")){
			application.validateElementNotDisplayed("companySettingMultiLangSelector_xpath", "Language Selector Dropdown");
		}
		application.scrollTo("companySettingEnquiryNow_xpath");
		application.clear("companySettingEnquiryNow_xpath");
		application.clear("companySettingProductnService_xpath");
		application.clear("companySettingVideo_xpath");
		application.clear("companySettingLinks_xpath");
		application.clear("companySettingAboutUs_xpath");
		application.scrollTo("companySettingUpdateButton_xpath");
		application.click("companySettingUpdateButton_xpath" , "Company Setting Update Button");
		application.validateElementPresent("companySettingEnquiryFormError_xpath", "Enquiry Form Required Field error");
		application.validateCompareText("companySettingEnquiryFormError_xpath", "Enquiry Now Button desired name is required");
		application.validateElementPresent("companySettingProductError_xpath", "Product and Services required Field error");
		application.validateCompareText("companySettingProductError_xpath", "Product & service desired name is required");
		application.validateElementPresent("companySettingVideoError_xpath", "Video required Field error");
		application.validateCompareText("companySettingVideoError_xpath", "Video desired name is required");
		application.validateElementPresent("companySettingLinksError_xpath", "Links required Field error");
		application.validateCompareText("companySettingLinksError_xpath", "Link desired name is required");
		application.validateElementPresent("companySettingAboutUsError_xpath", "About Us required Field error");
		application.validateCompareText("companySettingAboutUsError_xpath", "About Us desired name is required");
		application.type("companySettingEnquiryNow_xpath", readExcelData("Change_Enquiry_Now_Title", "CompanySetting"));
		application.wait(2);
		application.type("companySettingProductnService_xpath", readExcelData("Change_Product_and_Services_Title", "CompanySetting"));
		application.wait(2);
		application.type("companySettingVideo_xpath", readExcelData("Change_Video_Title", "CompanySetting"));
		application.wait(2);
		application.type("companySettingLinks_xpath", readExcelData("Change_Links_Title", "CompanySetting"));
		application.wait(2);
		application.type("companySettingAboutUs_xpath", readExcelData("Change_AboutUs_Title", "CompanySetting"));
		application.wait(2);
		application.scrollTo("companySettingUpdateButton_xpath");
		application.wait(2);
		application.click("companySettingUpdateButton_xpath", "Company Setting Update Button");
		application.validateCompareText("companySettingUpdatePopup_xpath", "Company setting has been update successfully");
		application.wait(2);
		application.clear("manageCompanySearch_xpath");
	}
	@Test
	public void employeeIDCardSettings() {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "IdCardSettingButton_xpath");
		application.validateElementPresent("IdCardSettingPopUpTitle_xpath", "ID Card Setting Title");
		application.validateCompareText("IdCardSettingPopUpTitle_xpath", "Check the fields to show on employee ID-Card");
		application.validateElementPresent("IdCardFrontFieldsText_xpath", "Id card Front Fields text");
		application.validateElementPresent("IdCardFrontCompanyLogoText_xpath", "Front Company Logo");
		application.validateElementPresent("IdCardFrontCompanyNameText_xpath", "Front Company Name");
		application.validateElementPresent("IdCardFrontCompanyEmpNameText_xpath", "Front Company Employee Name");
		application.validateElementPresent("IdCardFrontCompanyEmpPhoto_xpath", "Front Company Employee photo");
		application.validateElementPresent("IdCardFrontCompanyEmpCode_xpath", "Front Company Employee Code");
		application.validateElementPresent("IdCardFrontCompanyEmpDesignation_xpath", "Front Company Employee Designation");
		application.validateElementPresent("IdCardFrontCompanyEmpDepartment_xpath", "Front Company Employee Department");
		application.validateElementPresent("IdCardFrontCompanyEmpEmail_xpath", "Front Company Employee Email");
		application.validateElementPresent("IdCardFrontCompanyEmpContact_xpath", "Front Company Employee Contact");
		application.validateElementPresent("IdCardFrontCompanyEmpEmergency_xpath", "Front Company Employee Emergency");
		application.validateElementPresent("IdCardFrontCompanyEmpDOB_xpath", "Front Company Employee DOB");
		application.validateElementPresent("IdCardFrontCompanyEmpJoining_xpath", "Front Company Employee Joining");
		application.validateElementPresent("IdCardFrontCompanyEmpBlood_xpath", "Front Company Employee Blood Group");
		
		application.validateElementPresent("IdCardBackFieldsText_xpath", "Back Company Title");
		application.validateElementPresent("IdCardBackCompanyNameText_xpath", "Back Company Name");
		application.validateElementPresent("IdCardBackCompanyLogoText_xpath", "Back Company Logo");
		application.validateElementPresent("IdCardBackCompanyAddressText_xpath", "Back Company Address");
		application.validateElementPresent("IdCardBackCompanyContactText_xpath", "Back Company Contact");
		application.validateElementPresent("IdCardBackCompanyEmailText_xpath", "Back Company Email");
		application.validateElementPresent("IdCardBackCompanyWebsiteText_xpath", "Back Company Website");
		application.validateElementPresent("IdCardBackEmployeeResidenceText_xpath", "Back Employee residence");
		application.validateElementPresent("IdCardSaveButton_xpath", "ID card Save Button");
		application.validateElementPresent("IdCardCancelButton_xpath", "ID card Cancel Button");
		
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyLogoCheckbox_xpath", "Front_Company_Logo", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyNameCheckbox_xpath", "Front_Company_Name", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpNameCheckbox_xpath", "Employee_Name", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpPhotoCheckbox_xpath", "Employee _Photo", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpCodeCheckbox_xpath", "Employee_Code", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpDesignationCheckbox_xpath", "Employee_Designation", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpDepartmentCheckbox_xpath", "Employee_Department", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpEmailCheckbox_xpath", "Employee_Email", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpContactCheckbox_xpath", "Employee_Contact_Number", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpEmergencyCheckbox_xpath", "Employee_Emergency_Number", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpDOBCheckbox_xpath", "Employee_DOB", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpJoiningCheckbox_xpath", "Employee_Joining_Date", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardFrontCompanyEmpBloodCheckbox_xpath", "Employee_Blood_Group", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyNameCheckbox_xpath", "Back_Company_Name", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyLogoCheckbox_xpath", "Back_Company_Logo", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyAddressCheckbox_xpath", "Company_Address", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyContactCheckbox_xpath", "Company_Contact_Number", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyEmailCheckbox_xpath", "Company_Email_ID", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyWebsiteCheckbox_xpath", "Company_Website_URL", "IdCardSettings");
		application.clickCheckboxBasedOnExcelParameter("IdCardBackCompanyEmployeeResidenceCheckbox_xpath", "Employee_Residence", "IdCardSettings");
		application.wait(5);
		application.click("IdCardSaveButton_xpath" , "Company Setting Save ID Card Button");
		application.validateCompareText("companySettingUpdatePopup_xpath", "Company employee card setting fields saved successfully");
		application.wait(2);
		application.clear("manageCompanySearch_xpath");
	}
	
	@Test
	public void setVirtualBackground() throws Exception, Exception {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "virtualBGButton_xpath");
		application.wait(2);
		application.validateElementPresent("virtualBGHeaderTitle_xpath", "Virtual Background title.");
		application.validateCompareText("virtualBGHeaderTitle_xpath", "Manage Company Virtual Background Images");
		application.validateElementPresent("virtualBGUploadImageLabel_xpath", "Virtual Background upload image text.");
		application.validateElementPresent("virtualBGUploadImageButton_xpath", "Virtual Background Upload Image Button");
		application.validateElementPresent("virtualBGUploadImageSizeNote_xpath", "Virtual Background image size note");
		application.validateElementPresent("virtualBGSaveButton_xpath", "Virtual Background save button");
		application.validateElementPresent("virtualBGCancelButton_xpath", "Virtual Background cancel button");
		try {
		application.click("virtualBGRemoveImageButton_xpath" , "Virtual BG Remove Image Button");
		application.acceptAlert();
		}catch(Exception e) {
			test.log(Status.INFO, "Image is not uploaded before.");
		}
		application.uploadImage("virtualBGUploadImageButton_xpath", "\\Upload\\download.png");
		application.wait(3);
		application.click("virtualBGSaveButton_xpath" , "Virtual BG Save Button");
		application.validateCompareText("virtualBGUploadSuccessfulPopup_xpath", "Background image saved sucessfully !!");
		application.clear("manageCompanySearch_xpath");
	}
	
	@Test
	
	public void manageCompanyAddAboutUS() {
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "addAboutUsButton_xpath");
		application.validateElementPresent("addAboutUsPopUpTitle_xpath", "Add About Us PopUp title.");
		application.validateElementPresent("addAboutUsPopUpDescriptionText_xpath", "Add About US PopUp Description heading.");
		application.type("addAboutUsPopUpDescription_xpath", readExcelData("Add_About_Us_Description", "ManageCompany"));
		application.validateElementPresent("addAboutUsPopUpUpdateButton_xpath", "Add About Us Update Button");
		application.validateElementPresent("addAboutUsPopUpCancelButton_xpath", "Add About Us Cancel Button");
		application.wait(3);
		application.click("addAboutUsPopUpCancelButton_xpath" , "Add About Us PopUp Cancel Button");
		application.wait(2);
		application.clear("manageCompanySearch_xpath");
		application.type("manageCompanySearch_xpath", readExcelData("Company_Name", "ManageCompany"));
		application.wait(2);
		application.clickLastColumnButtonForFirstColumnValue("manageCompanyTable_xpath", "manageCompanyTableFirstColumn_xpath", 
				"Company_Name", "ManageCompany", "addAboutUsButton_xpath");
		application.type("addAboutUsPopUpDescription_xpath", readExcelData("Add_About_Us_Description", "ManageCompany"));
		application.wait(2);
		application.click("addAboutUsPopUpUpdateButton_xpath", "Add About Us PopUp Update Button");
		application.validateCompareText("addAboutUsPopUpSuccessfulPopup_xpath", "About US has been updated successfully");
	}
	
}
