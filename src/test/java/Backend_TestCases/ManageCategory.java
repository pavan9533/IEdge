package Backend_TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ManageCategory extends BaseClass{
 
	@Test
	public void openManageCategory() {
		application.wait(2);
		application.click("configurationOptionLeftMenu_xpath" , "Configurations Button");
		application.wait(5);
		application.click("manageCategoryButton_xpath" ," Manage Category Button");
		application.wait(5);
	}
	@Test
	public void validateManageCategoryPage() {
		application.wait(3);
		application.validateElementPresent("manageCategorySelectCompanyLabel_xpath", "Select Company Text");
		application.validateElementPresent("manageCategorySelectCompany_xpath", "Select Company dropdown");
		application.validateElementPresent("manageCategoryfilterButton_xpath", "Select Company Filter");
		application.validateElementPresent("manageCategoryAddCategoryButton_xpath", "Add Category Button");
		application.validateElementPresent("manageCategorySearch_xpath", "Search Category");
		application.validateElementPresent("manageCategoryAddCategoryTitle_xpath", "Add Category Title");
		application.validateElementPresent("manageCategoryExpandCategoryButton_xpath", "Expand Category Button");
		application.validateElementPresent("manageCategoryNameLabel_xpath", "Add Category Name Label");
		application.validateMandatoryIconForLabel("Category Name");
		application.wait(3);
		application.validateElementPresent("manageCategoryCompanyLabel_xpath", "Add Category Company label");
		application.validateMandatoryIconForLabel("Company");
		application.validateElementPresent("manageCategoryLinkLabel_xpath", "Add Category link label");
		application.validateElementPresent("manageCategorySavebutton_xpath", "Add Category Save Button");
		application.validateElementPresent("manageCategoryCancelbutton_xpath", "Add Category Cancel button");
		application.wait(2);
		application.selectCategory("manageCategoryAllSubCategories_xpath" , "Select_Category" , "ManageCategory");
		application.wait(3);
		try {
			application.validateElementPresent("manageCategoryAddSubCategoryButton_xpath", "Add Sub category Button");
			application.oneOfTwoElementsPresent("manageCategoryDisableCategoryButton_xpath" , "manageCategoryEnableCategoryButton_xpath");
			application.validateElementPresent("manageCategoryDeleteCategoryButton_xpath", "Delete category Button");
			application.wait(2);
			application.click("manageCategoryAddSubCategoryButton_xpath",  "Add Sub category Button");
			application.wait(2);
			application.scrollTo("manageCategorySavebutton_xpath");
			application.click("manageCategorySavebutton_xpath" , "Manage Category Save Button");
			application.validateElementPresent("manageCategoryNameError_xpath", "Category Name Error");
			application.validateError("manageCategoryNameError_xpath", "Category name is required");
			application.wait(2);
			application.validateElementPresent("manageCategoySubCategoryUploadImageError_xpath", "Add Sub Category Upload image Error");
			application.validateError("manageCategoryNameError_xpath", "Please upload image");	
			application.wait(2);
			application.validateElementPresent("manageCategoryNameLabel_xpath", "Add Category Name Label");
			application.validateMandatoryIconForLabel("Category Name");
			application.validateElementPresent("manageCategoryCompanyLabel_xpath", "Add Category Company label");
			application.wait(2);
			application.validateMandatoryIconForLabel("Company");
			application.validateElementPresent("manageCategoryImageUploadText_xpath", "Manage Category Image Upload text");
			application.wait(2);
			application.validateElementPresent("manageCategoryImageSizeText_xpath", "Manage Category Image Size text");
			application.validateElementPresent("manageCategoryBrowseButton_xpath", "Manage Category Browse Button");
			application.wait(2);
			
		}catch(Exception w) {
			test.log(Status.FAIL, "Sub Category not clicked."+w);
		}
		application.click("manageCategoryfilterButton_xpath" , "Manage Category Filter Button");
		application.refreshPage();
	}
	
	@Test
	public void addCategory() {
		
		application.wait(3);
		application.click("manageCategorySavebutton_xpath" , "Manage Category Save Button");
		application.validateElementPresent("manageCategoryNameError_xpath", "Category Name Error");
		application.validateError("manageCategoryNameError_xpath", "Category name is required");
		application.click("manageCategoryAddCategoryButton_xpath" , "Manage Category Add Category Button");
		application.type("manageCategoryCategoryName_xpath", readExcelData("Category_Name", "ManageCategory"));
		application.wait(2);
		application.click("manageCategoryChooseCompany_xpath" , "Manage Category Choose Company button");
		application.selectOptionUL("manageCategoryChooseCompanyDropdown_xpath", "Company_Name", "ManageCategory");
		application.type("manageCategorylink_xpath", readExcelData("Category_Link", "ManageCategory"));
		application.wait(3);
		application.click("manageCategorySavebutton_xpath"  , "Manage Category Save Button");
		application.validateCompareText("addCategorySuccessful_xpath", "Category has been added successfully.");
	}
	
	@Test
	public void addSubCategory() throws Exception, Exception {
		application.selectCategory("manageCategoryAllSubCategories_xpath" , "Select_Category" , "ManageCategory");
		application.wait(2);
		application.click("manageCategoryAddSubCategoryButton_xpath" , "Manage Category Add Sub Category Button");
		application.wait(2);
		application.type("addSubCategoryName_xpath", readExcelData("Sub_Category_Name", "ManageCategory"));
		application.wait(2);
		application.click("addSubCategoryCompanyDropdown_xpath", "Add Sub Category Select Company");
		application.selectOptionUL("addSubCategoryCompany_xpath", "Company_Name", "ManageCategory");
		application.type("addSubCategoryLinks_xpath", readExcelData("Sub_Category_Link", "ManageCategory"));
		application.scrollTo("manageCategoryBrowseButton_xpath");
		application.wait(2);
		application.click("manageCategoryBrowseButton_xpath", "Add Sub Category Browse Button");
		application.uploadImage("\\Upload\\logo.png");
		application.wait(3);
		application.click("manageCategorySavebutton_xpath", "Manage Category Save Button");
		application.wait(4);
		try {
			application.validateCompareText("addCategorySuccessful_xpath", "Category has been added successfully.");
			test.log(Status.PASS, "Sub Category Added.");
		}catch(Exception e) {
			application.validateElementPresent("addCategorySuccessful_xpath", "* Category name already exist.");
			test.log(Status.FAIL, "Category Name already Exists");
		}
		
	}
	@Test
	public void enableDisableCategory() {
		application.selectCategory("manageCategoryAllSubCategories_xpath" , "Category" , "ManageCategory");
		application.wait(5);
		application.enableDisableSubCategory("manageCategoryEnableCategoryButton_xpath","manageCategoryDisableCategoryButton_xpath",
				"Category_Status", "ManageCategory");
		application.wait(2);
	}
	
	@Test
	public void enableDisableSubCategory() {
		application.selectSubCategory("manageCategoryAllSubCategories_xpath", "Select_Category", "Sub_Category_Name" , "ManageCategory");
		application.wait(5);
		application.enableDisableSubCategory("manageCategoryEnableCategoryButton_xpath","manageCategoryDisableCategoryButton_xpath",
				"Category_Status", "ManageCategory");
		application.wait(2);
	}
	
	@Test
	public void deleteCategory() {
		application.selectCategory("manageCategoryAllSubCategories_xpath" , "Delete_Category" , "ManageCategory");
		application.wait(2);
		application.click("manageCategoryDeleteCategoryButton_xpath" , "Manage Category Delete Category Button");
		application.wait(2);
		application.click("manageCategoryEnableDisablePopUpOkButton_xpath" , "Manage Category Enable Disbale popup Ok Button");
		application.validateCompareText("addCategorySuccessful_xpath", "Category deleted sucessfully.");
	}
}
