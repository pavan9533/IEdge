package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeyword extends ValidationKeyword{
	
	
		
	
	public ApplicationKeyword() {
		String path = System.getProperty("user.dir")+"\\Properties\\env.properties";
		envprop = new Properties();
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			envprop.load(file);
			String environment = envprop.getProperty("env")+".properties";
			path =  System.getProperty("user.dir")+"\\Properties\\"+environment;
			file = new FileInputStream(path);
			prop.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public ApplicationKeyword() {
//	    String path = System.getProperty("user.dir") + "\\Properties\\User.properties";
//	    prop = new Properties();
//	    try {
//	        FileInputStream file = new FileInputStream(path);
//	        prop.load(file);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    //softAssert = new SoftAssert();
//	}
	
	
	
	public void setReport(ExtentTest test) {
		this.test = test;
	}
	

//	    public void uploadImage(String uploadLocator, String directory) throws InterruptedException, Exception  {
//	    	
//	        String filePath = System.getProperty("user.dir")+ directory ;
//	        log(filePath);
//	        // Click on the upload button to trigger the native file upload dialog
//	        WebElement uploadButton = driver.findElement(getLocator(uploadLocator));
//	        uploadButton.click();
//
//	        // Wait for the file upload dialog to appear
//	        Thread.sleep(2000); // Adjust the wait time as needed
//
//	        // Set the file path to the clipboard
//	        StringSelection stringSelection = new StringSelection(filePath);
//	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//	        // Simulate keyboard actions to paste the file path and press Enter
//	        Robot robot = new Robot();
//	        robot.keyPress(KeyEvent.VK_CONTROL);
//	        robot.keyPress(KeyEvent.VK_V);
//	        robot.keyRelease(KeyEvent.VK_V);
//	        robot.keyRelease(KeyEvent.VK_CONTROL);
//	        robot.keyPress(KeyEvent.VK_ENTER);
//	        robot.keyRelease(KeyEvent.VK_ENTER);
//
//	    }
	
	public void uploadImage(String uploadLocator, String directory) throws Exception {
	    try {
	        // Get the absolute file path
	        String filePath = System.getProperty("user.dir") + directory;
	        log("File path: " + filePath);

	        // Click on the upload button to trigger the native file upload dialog
	        WebElement uploadButton = driver.findElement(getLocator(uploadLocator));
	        uploadButton.click();

	        // Wait for the file upload dialog to appear (you can use WebDriverWait for better waiting)
	        wait(5); // Adjust the wait time as needed

	        // Set the file path to the clipboard
	        StringSelection stringSelection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	        // Simulate keyboard actions to paste the file path and press Enter
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        wait(5);
	        test.log(Status.PASS, "Image Uploaded");
	    } catch (Exception  e) {
	        test.log(Status.FAIL, "Unable to upload image"+e);
	    }
	}
	
	public void uploadImage( String directory) throws Exception {
	    try {
	        // Get the absolute file path
	        String filePath = System.getProperty("user.dir") + directory;
	        log("File path: " + filePath);
	        wait(5); 
	        StringSelection stringSelection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        wait(5);
	        test.log(Status.PASS, "Image Uploaded");
	    } catch (Exception  e) {
	        test.log(Status.FAIL, "Unable to upload image"+e);
	    }
	}
	    
	    public void selectOptionUL(String locator, String columnName, String sheetName) {
	        List<WebElement> ulElements = driver.findElements(getLocator(locator));
	        if (!ulElements.isEmpty()) {
	            WebElement ulElement = ulElements.get(0);
	            try {
	                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
	                
	                // Retrieve the options from the specified Excel column and sheet
	                List<String> optionsFromExcel = readExcelData(columnName, sheetName);

	                for (WebElement liElement : liElements) {
	                    WebElement spanElement = liElement.findElement(By.tagName("span"));
	                    String spanText = spanElement.getText();
	                    
	                    // Check if the spanText is present in the optionsFromExcel list
	                    if (optionsFromExcel.contains(spanText)) {
	                        spanElement.click();
	                        generateScreenshots("Option Clicked.");
	                        test.log(Status.PASS, spanText + " option is clicked.");
	                        break;
	                    }
	                }
	            } catch (NoSuchElementException e) {
	                test.log(Status.FAIL, "One or more options were not found in the dropdown.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                test.log(Status.FAIL, e);
	            }
	        } else {
	            test.log(Status.FAIL, "Not enough ul elements with the specified class.");
	        }
	    }
	    
	    public void selectOptionDivUlLi(String locator, String columnName, String sheetName) {
	    	WebElement div = driver.findElement(getLocator(locator));
	        List<WebElement> ulElements = div.findElements(By.tagName("ul"));
	        if (!ulElements.isEmpty()) {
	            WebElement ulElement = ulElements.get(0);
	            try {
	                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
	                
	                // Retrieve the options from the specified Excel column and sheet
	                List<String> optionsFromExcel = readExcelData(columnName, sheetName);

	                for (WebElement liElement : liElements) {
	                    WebElement aElement = liElement.findElement(By.tagName("a"));
	                    WebElement spanElement = aElement.findElement(By.tagName("span"));
	                    String spanText = spanElement.getText();
	                    
	                    // Check if the spanText is present in the optionsFromExcel list
	                    if (optionsFromExcel.contains(spanText)) {
	                    	spanElement.click();
	                    	wait(2);
	                        generateScreenshots("Option Clicked.");
	                        test.log(Status.PASS, spanText + " option is clicked.");
	                        break;
	                    }
	                }
	            } catch (NoSuchElementException e) {
	                test.log(Status.FAIL, "One or more options were not found in the dropdown.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                test.log(Status.FAIL, e);
	            }
	        } else {
	            test.log(Status.FAIL, "Not enough ul elements with the specified class.");
	        }
	    }
	    
	    public void selectOptionDivUlLi(String locator, String columnName, String sheetName, String range) {
	        WebElement div = driver.findElement(getLocator(locator));
	        List<WebElement> ulElements = div.findElements(By.tagName("ul"));
	        if (!ulElements.isEmpty()) {
	            WebElement ulElement = ulElements.get(0);
	            String Ui = ulElement.getText();
	            log(Ui);
	            try {
	                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
	                
	                for (WebElement liElement : liElements) {
	                    WebElement aElement = liElement.findElement(By.tagName("a"));
	                    WebElement spanElement = aElement.findElement(By.tagName("span"));
	                    String spanText = spanElement.getText();
	                    
	                    switch (range.toLowerCase()) {
	                        case "last 7 days":
	                            if (spanText.equalsIgnoreCase("Last 7 days")) {
	                            	highlightElement(spanElement);
	                                spanElement.click();
	                                wait(2);
	                                generateScreenshots("Option Clicked.");
	                                test.log(Status.PASS, spanText + " option is clicked.");
	                                return;
	                            }
	                            break;
	                        case "last 30 days":
	                            if (spanText.equalsIgnoreCase("Last 30 days")) {
	                            	highlightElement(spanElement);
	                                spanElement.click();
	                                wait(2);
	                                generateScreenshots("Option Clicked.");
	                                test.log(Status.PASS, spanText + " option is clicked.");
	                                return;
	                            }
	                            break;
	                        case "last 3 months":
	                            if (spanText.equalsIgnoreCase("Last 3 months")) {
	                            	highlightElement(spanElement);
	                                spanElement.click();
	                                wait(2);
	                                generateScreenshots("Option Clicked.");
	                                test.log(Status.PASS, spanText + " option is clicked.");
	                                return;
	                            }
	                            break;
	                        case "custom date":
	                            if (spanText.equalsIgnoreCase("Custom Date")) {
	                            	highlightElement(spanElement);
	                                spanElement.click();
	                                wait(2);
	                                generateScreenshots("Option Clicked.");
	                                test.log(Status.PASS, spanText + " option is clicked.");
	                                return;
	                            }
	                            break;
	                    }
	                }
	                test.log(Status.FAIL, "Range option not found: " + range);
	            } catch (NoSuchElementException e) {
	                test.log(Status.FAIL, "One or more options were not found in the dropdown.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                test.log(Status.FAIL, e);
	            }
	        } else {
	            test.log(Status.FAIL, "Not enough ul elements with the specified class.");
	        }
	    }
	    
//	    public void selectOptioncompany(String locator, String optionText) {
//	        try {
//	            WebElement ulElement = driver.findElement(getLocator(locator));
//	            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
//
//	            for (WebElement liElement : liElements) {
//	            	WebElement aElement = liElement.findElement(By.tagName("a"));
//	                String aText = aElement.getText();
//
//	                if (aText.equals(optionText)) {
//	                    
//	                    WebElement spanElement = liElement.findElement(By.tagName("span"));
//	                    spanElement.click();
//	                    generateScreenshots("Option Clicked.");
//	                    test.log(Status.PASS, optionText + " option is clicked.");
//	                    return; // Exit the loop once option is clicked
//	                }
//	            }
//
//	            // If optionText is not found, log an error
//	            test.log(Status.FAIL, optionText + " option not found in the dropdown.");
//	        } catch (NoSuchElementException e) {
//	            test.log(Status.FAIL, "Dropdown menu elements not found.");
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            test.log(Status.FAIL, e);
//	        }
//	    }
	    
	    public void selectOptioncompany(String locator, String columnName, String sheetName) {
	        try {
	            WebElement ulElement = driver.findElement(getLocator(locator));
	            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

	            // Retrieve the options from Excel
	            List<String> excelOptions = readExcelData(columnName, sheetName);

	            for (WebElement liElement : liElements) {
	                WebElement aElement = liElement.findElement(By.tagName("a"));
	                String aText = aElement.getText();

	                // Check if the option from the webpage is present in the Excel data
	                if (excelOptions.contains(aText)) {
	                    WebElement spanElement = liElement.findElement(By.tagName("span"));
	                    spanElement.click();
	                    generateScreenshots("Option Clicked.");
	                    test.log(Status.PASS, aText + " option is clicked.");
	                    return; // Exit the loop once option is clicked
	                }
	            }

	            // If optionText is not found, log an error
	            test.log(Status.FAIL, "No matching option found in the dropdown.");
	        } catch (NoSuchElementException e) {
	            test.log(Status.FAIL, "Dropdown menu elements not found.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            test.log(Status.FAIL, e);
	        }
	    }
	    
	    public void changeLanguage(String Locator , String ColumnName , String SheetName) {
			wait(3);
		    List<String> languages = getTextFromExcel(ColumnName, SheetName);
		    if (languages.isEmpty()) {
		        test.log(Status.FAIL, "Language is not defined in the test data sheet.");
		        wait(5);
		        return; 
		    }
		    
		    String language = languages.get(0).toLowerCase(); 
		    
		    click(Locator , "Language");
		    switch (language) {
		        case "english":
		            validateElementPresent("manageCompanySettingSelectEnglish_xpath");
		            click("manageCompanySettingSelectEnglish_xpath" , "English Language option");
		            test.log(Status.INFO, "English Language is Selected.");
		            break;
		        case "hindi":
		            validateElementPresent("manageCompanySettingSelectHindi_xpath");
		            click("manageCompanySettingSelectHindi_xpath" , "Hindi Language option");
		            test.log(Status.INFO, "Hindi Language is Selected.");
		            break;
		        case "japanese":
		            validateElementPresent("manageCompanySettingSelectJapanese_xpath");
		            click("manageCompanySettingSelectJapanese_xpath", "Japanese Language option");
		            test.log(Status.INFO, "Japanese Language is Selected.");
		            break;
		        default:
		            test.log(Status.INFO, "Unsupported language: " + language);
		            break;
		    }
		    generateScreenshots("Dashboard");
		    wait(5);
		}
	    
	   
	    public void changeComapanyStatus(String columnName, String nameOfSheet) {
	        List<String> statuses = readExcelData(columnName, nameOfSheet);

	        if (statuses == null || statuses.isEmpty()) {
	            test.log(Status.FAIL, "No status data found in the Excel sheet.");
	            return;
	        }
	        
	        for (String status : statuses) {
	        	log(status);
	            if (status.equalsIgnoreCase("Enable")) {
	                try {
	                    WebElement enable = driver.findElement(By.xpath("//a[@title='"+ status +"']"));
	                    if (enable.isDisplayed()) {
	                        click("manageCompanySettingEnable_xpath" , "Company Status");
	                        test.log(Status.PASS, "Company is Enabled.");
	                    }else {
	                    	test.log(Status.INFO, "Company already Enabled.");
	                    }
	                } catch (Exception e) {
	                    test.log(Status.INFO, "Company is already Enabled.");
	                }
	            } else if (status.equalsIgnoreCase("Disable")) {
	                try {
	                    WebElement disable = driver.findElement(By.xpath("//a[@title='"+ status +"']"));
	                    if (disable.isDisplayed()) {
	                        click("manageCompanySettingDisable_xpath" , "Company Status");
	                        test.log(Status.PASS, "Company is Disabled.");
	                    }else {
	                    	test.log(Status.INFO, "Company is Already Disabled");
	                    }
	                } catch (Exception e) {
	                	
	                    test.log(Status.INFO, "Company is already Disabled.");
	                }
	            } 
	        }
	    }
	   public void selectTheme(String columnName , String sheetName) {
	    	try {
	    		String theme = readExcelData(columnName, sheetName).get(0);
	    		if(theme.equalsIgnoreCase("Theme1")) {
	    			scrollTo("manageCompanyTheme1_xpath");
	    			highlightElement("manageCompanyTheme1_xpath");
	    			click("manageCompanyTheme1_xpath" , "Theme 1");
	    		}else if(theme.equalsIgnoreCase("Theme2")) {
	    			scrollTo("manageCompanyTheme2_xpath");
	    			highlightElement("manageCompanyTheme2_xpath");
	    			click("manageCompanyTheme2_xpath" , "Theme 2");
	    		}
	    		else if(theme.equalsIgnoreCase("Theme3")) {
	    			scrollTo("manageCompanyTheme3_xpath");
	    			highlightElement("manageCompanyTheme3_xpath");
	    			click("manageCompanyTheme3_xpath" , "Theme 3");
	    		}
	    		else if(theme.equalsIgnoreCase("Theme4")) {
	    			scrollTo("manageCompanyTheme4_xpath");
	    			highlightElement("manageCompanyTheme4_xpath");
	    			click("manageCompanyTheme4_xpath", "Theme 4");
	    		}
	    		else if(theme.equalsIgnoreCase("Theme5")) {
	    			scrollTo("manageCompanyTheme5_xpath");
	    			highlightElement("manageCompanyTheme5_xpath");
	    			click("manageCompanyTheme5_xpath", "Theme 5");
	    		}
	    		else if(theme.equalsIgnoreCase("Theme6")) {
	    			scrollTo("manageCompanyTheme6_xpath");
	    			click("manageCompanyTheme6_xpath", "Theme 6");
	    		}else if(theme.equalsIgnoreCase("Theme7")) {
	    			scrollTo("manageCompanyTheme7_xpath");
	    			highlightElement("manageCompanyTheme1_xpath");
	    			click("manageCompanyTheme7_xpath", "Theme 6");
	    		}
	    		
	    	}catch(Exception e) {
	    		test.log(Status.FAIL, "Theme not available.");
	    		generateScreenshots("Theme");
	    	}
	    }

	   public void selectURLPinRadioButton(String EmpNameLocator ,String EmpMobileLocator , String systemGenerated, String columnName , String sheetName) {
		  String option = readExcelData(columnName, sheetName).get(0);
		  log(option);
		  if(option.equalsIgnoreCase("Employee name")) {
			  click(EmpNameLocator , "Employee Name");
			  test.log(Status.PASS, "Employee Name radio button is selected.");
		  }else if(option.equalsIgnoreCase("Employee Mobile No")) {
			  click(EmpMobileLocator , "Employee Mobile Number");
			  test.log(Status.PASS, "Employee Mobile No radio button is selected.");
		  }else if (option.equalsIgnoreCase("System Generated")) {
			  click(systemGenerated , "System Generated");
			  test.log(Status.PASS, "System Generated radio button is selected.");
		  }else {
			  test.log(Status.FAIL, "Option not available for URL Pin type.");
		  }
	   }
	   public void selectCallNumberRadioButton(String mobileLocator ,String landlineLocator , String columnName , String sheetName) {
			  String option = readExcelData(columnName, sheetName).get(0);
			  log(option);
			  if(option.equalsIgnoreCase("Mobile No")) {
				  click(mobileLocator , "Mobile Number");
				  test.log(Status.PASS, "Mobile No radio button is selected.");
			  }else if(option.equalsIgnoreCase("Landline No")) {
				  click(landlineLocator , "LandLine");
				  test.log(Status.PASS, "Landline radio button is selected.");
			  }else {
				  test.log(Status.FAIL, "Option not available for Click to call.");
			  }
		   }

	   public void selectSubCategory(String locator, String categoryColumnName , String subCategoryColumnName, String sheetName ) {
		   WebElement div = driver.findElement(getLocator(locator));
	        List<WebElement> ulElements = div.findElements(By.tagName("ul"));
	        if (!ulElements.isEmpty()) {
	            WebElement ulElement = ulElements.get(0);
	            try {
	                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
	                
	                // Retrieve the options from the specified Excel column and sheet
	                String categoryFromExcel = readExcelData(categoryColumnName, sheetName).get(0);

	                for (WebElement liElement : liElements) {
	                    WebElement labelElement = liElement.findElement(By.tagName("label"));
	                    String labelText = labelElement.getText();
	                    
	                    // Check if the spanText is present in the optionsFromExcel list
	                    if (categoryFromExcel.contains(labelText)) {
	                    	WebElement parallelDiv = liElement.findElement(By.tagName("div"));
	                    	parallelDiv.click();
	                    	wait(3);
	                        generateScreenshots("Option Clicked.");
	                        test.log(Status.PASS, labelText + " option is clicked.");
	                        List<WebElement> subUlElements = liElement.findElements(By.tagName("ul"));
	                        if (!subUlElements.isEmpty()) {
	                            WebElement subUlElement = subUlElements.get(0);
	                            List<WebElement> subLiElements = subUlElement.findElements(By.tagName("li"));

	                            // Retrieve the sub-category from the specified Excel column and sheet
	                            String subCategoryFromExcel = readExcelData(subCategoryColumnName, sheetName).get(0);

	                            for (WebElement subLiElement : subLiElements) {
	                                WebElement subLabelElement = subLiElement.findElement(By.tagName("label"));
	                                String subLabelText = subLabelElement.getText();

	                                // Check if the subLabelText matches the subCategoryFromExcel
	                                if (subCategoryFromExcel.equals(subLabelText)) {
	                                    subLabelElement.click();
	                                    wait(3);
	                                    generateScreenshots("Sub-Category Option Clicked.");
	                                    test.log(Status.PASS, subLabelText + " sub-category option is clicked.");
	                                    break;
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	             catch (NoSuchElementException e) {
	                test.log(Status.FAIL, "One or more options were not found in the dropdown.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                test.log(Status.FAIL, e);
	            }
	        } else {
	            test.log(Status.FAIL, "Not enough ul elements with the specified class.");
	        }
	    
	   }
	   
	   public void selectCategory(String locator, String columnName, String sheetName) {
		   WebElement div = driver.findElement(getLocator(locator));
	        List<WebElement> ulElements = div.findElements(By.tagName("ul"));
	        if (!ulElements.isEmpty()) {
	            WebElement ulElement = ulElements.get(0);
	            try {
	                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
	                
	                // Retrieve the options from the specified Excel column and sheet
	                List<String> optionsFromExcel = readExcelData(columnName, sheetName);

	                for (WebElement liElement : liElements) {
	                    WebElement labelElement = liElement.findElement(By.tagName("label"));
	                    String labelText = labelElement.getText();
	                    
	                    // Check if the spanText is present in the optionsFromExcel list
	                    if (optionsFromExcel.contains(labelText)) {
	                    	labelElement.click();
	                        generateScreenshots("Option Clicked.");
	                        test.log(Status.PASS, labelText + " option is clicked.");
	                        break;
	                    }else {
	                    	test.log(Status.FAIL, labelText+" is not displayed in the list");
	                    }
	                }
	            } catch (NoSuchElementException e) {
	                test.log(Status.FAIL, "One or more options were not found in the dropdown.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                test.log(Status.FAIL, e);
	            }
	        } else {
	            test.log(Status.FAIL, "Not enough ul elements with the specified class.");
	        }
	    }
	   
	   public void enableDisableSubCategory(String enableLocator, String disableLocator, String columnName , String sheetName) {
		   WebElement enableButton =null;
		   WebElement disableButton = null;
		   String option = readExcelData(columnName, sheetName).get(0);
		   try {
			    enableButton = driver.findElement(getLocator(enableLocator));
			    if(enableButton.isDisplayed()) {
			    	if(option.equalsIgnoreCase("enable")) {
			    		enableButton.click();
			    		wait(2);
			    		click("manageCategoryEnableDisablePopUpOkButton_xpath" , "Manage Category Enable Disbale popup Ok Button");
			    		wait(2);
			    		validateContainsText("addCategorySuccessful_xpath","successfully");
			    		test.log(Status.PASS, "Sub Category Enabled");
			    	}else if(option.equalsIgnoreCase("disable")) {
			    		test.log(Status.INFO, "Sub Category is already Disabled");
			    	}
			    }
		   }catch(Exception e) {
			   test.log(Status.INFO, "Enable button is not visible ");
		   }
		   try {
			    disableButton = driver.findElement(getLocator(disableLocator));
			    if(disableButton.isDisplayed()) {
			    	if(option.equalsIgnoreCase("enable")) {
			    		test.log(Status.INFO, "Sub Category is already Enabled");
			    	}else if(option.equalsIgnoreCase("disable")) {
			    		disableButton.click();
			    		wait(2);
			    		click("manageCategoryEnableDisablePopUpOkButton_xpath" , "Manage Category Enable Disbale popup Ok Button");
			    		wait(2);
			    		validateContainsText("addCategorySuccessful_xpath","successfully");
			    		test.log(Status.PASS, "Sub Category Disabled");
			    	}
			    }
		   }catch(Exception e) {
			   test.log(Status.INFO, "Disable button is not visible ");
		   }
		   
		   
	   }
	   
	   public void clickButtonInLastColumnByFirstColumnValue(String tableLocator, String columnName , String sheetName, String buttonLocator) {
		    List<WebElement> rows = driver.findElements(getLocator(tableLocator));
		    String firstColumnValue = readExcelData(columnName, sheetName).get(0);

		    for (WebElement row : rows) {
		        WebElement firstColumn = row.findElement(By.xpath(".//td[1]")); // Assuming first column is at index 1
		        WebElement lastColumnButton = row.findElement(getLocator(buttonLocator));

		        if (firstColumn.getText().trim().equals(firstColumnValue)) {
		            lastColumnButton.click();
		            break; // Exit the loop once the button is clicked
		        }
		    }
		}
	   
	   public void mapCategories(String locator , String column, String sheet) {
		   try {
			   WebElement unMappedTable = driver.findElement(getLocator(locator));
			   String unMap = unMappedTable.getAttribute("class");
			   log(unMap);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   if(unMap.contains("left")) {
				   List<WebElement> categories = null;
				   try {
					   categories = unMappedTable.findElements(By.tagName("div"));
				   }catch(Exception e) {
					   test.log(Status.FAIL, "Categories are not visible "+e);
					   generateScreenshots("Categories");
				   }
				   int excelDataSize = readExcelData(column, sheet).size();
					   if(categories != null) {
						   for (int index = 0; index <excelDataSize && index <= 50; index++) {
							   for(WebElement category : categories) {
								   String categoryName = category.getText();
								   WebElement categoryToClick = driver.findElement(By.xpath("//div[text()='"+categoryName+"']"));
								   String excelCategory = readExcelData(column, sheet).get(index);
								   if(categoryName.equalsIgnoreCase(excelCategory)) {
									   js.executeScript("arguments[0].scrollIntoView();", categoryToClick);
									   wait(3);
									   categoryToClick.click();
									   test.log(Status.PASS, categoryToClick.getText()+" is mapped.");
								   }
							   }
						   }
					   }
			   }else {
				   test.log(Status.INFO , "Unable to map");
			   }
		   }catch(Exception e) {
			   test.log(Status.FAIL, "Map Category left block is not visible. "+ e);
			   generateScreenshots("Map Category");
		   }
	   }
	   
	   public void unMapCategories(String locator , String column, String sheet) {
		   try {
			   WebElement unMappedTable = driver.findElement(getLocator(locator));
			   String unMap = unMappedTable.getAttribute("class");
			   log(unMap);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   if(unMap.contains("right")) {
				   List<WebElement> categories = null;
				   try {
					   categories = unMappedTable.findElements(By.tagName("div"));
				   }catch(Exception e) {
					   test.log(Status.FAIL, "Categories are not visible "+e);
					   generateScreenshots("Categories");
				   }
				   int excelDataSize = readExcelData(column, sheet).size();
					   if(categories != null) {
						   for (int index = 0; index <excelDataSize && index <= 50; index++) {
							   for(WebElement category : categories) {
								   String categoryName = category.getText();
								   WebElement categoryToClick = driver.findElement(By.xpath("//div[text()='"+categoryName+"']"));
								   String excelCategory = readExcelData(column, sheet).get(index);
								   if(categoryName.equalsIgnoreCase(excelCategory)) {
									   js.executeScript("arguments[0].scrollIntoView();", categoryToClick);
									   wait(3);
									   categoryToClick.click();
									   test.log(Status.PASS, categoryToClick.getText()+" is UnMapped.");
								   }
							   }
						   }
					   }
			   }else {
				   test.log(Status.INFO , "Unable to UnMap");
			   }
		   }catch(Exception e) {
			   test.log(Status.FAIL, "Map Category right block is not visible. "+ e);
			   generateScreenshots("Map Category");
		   }
	   }
	   
	   public String validateCategoriesPresent(String divLocator) {
		   String divText = null;
		   try {
			   WebElement categories = driver.findElement(getLocator(divLocator));
			   List<WebElement> nestedDiv = categories.findElements(By.tagName("div"));
			   List<String> divTexts = new ArrayList<>();
			   if(nestedDiv.isEmpty()) {
				   test.log(Status.INFO, "Categories are empty");
			   }else {
				   for (WebElement div : nestedDiv) {
					   	divText = div.getText();
		                divTexts.add(divText);
			            test.log(Status.INFO, "Text: " + divText);
			        } 
			   }
		   }catch(Exception e) {
			   test.log(Status.INFO, "Categories are not Present "+e);
		   }
		   return divText;
	   }
	   
	   public String validateLinksPresent(String divLocator) {
		   String divText = null;
		   try {
			   WebElement categories = driver.findElement(getLocator(divLocator));
			   List<WebElement> nestedDiv = categories.findElements(By.tagName("div"));
			   List<String> divTexts = new ArrayList<>();
			   if(nestedDiv.isEmpty()) {
				   test.log(Status.INFO, "Links are empty");
			   }else {
				   for (WebElement div : nestedDiv) {
					   	divText = div.getText();
		                divTexts.add(divText);
			            test.log(Status.INFO, "Text: " + divText);
			        } 
			   }
		   }catch(Exception e) {
			   test.log(Status.INFO, "Links are not Present "+e);
		   }
		   return divText;
	   }
	   
//	   public void mapLinks(String locator , String column, String sheet) {
//		   try {
//			   WebElement unMappedTable = driver.findElement(getLocator(locator));
//			   String unMap = unMappedTable.getAttribute("class");
//			   log(unMap);
//			   if(unMap.contains("left")) {
//				   List<WebElement> links = null;
//				   try {
//					   links = unMappedTable.findElements(By.tagName("div"));
//				   }catch(Exception e) {
//					   test.log(Status.FAIL, "Links are not visible "+e);
//					   generateScreenshots("Links");
//				   }
//				   int excelDataSize = readExcelData(column, sheet).size();
//					   if(links != null) {
//						   for (int index = 0; index <excelDataSize && index <= 50; index++) {
//							   for(WebElement link : links) {
//								   String linkName = link.getText();
//								   WebElement linkToClick = driver.findElement(By.xpath("//div[text()='"+linkName+"']"));
//								   String excelCategory = readExcelData(column, sheet).get(index);
//								   if(linkName.equalsIgnoreCase(excelCategory)) {
//									   linkToClick.click();
//									   test.log(Status.PASS, linkToClick.getText()+" is mapped.");
//								   }
//							   }
//						   }
//					   }
//			   }else {
//				   test.log(Status.INFO , "Unable to map");
//			   }
//		   }catch(Exception e) {
//			   test.log(Status.FAIL, "Map left block is not visible. "+ e);
//			   generateScreenshots("Mapping");
//		   }
//	   }

	   public void mapLinks(String locator , String column, String sheet) {
		   try {
			   WebElement unMappedTable = driver.findElement(getLocator(locator));
			   String unMap = unMappedTable.getAttribute("class");
			   log(unMap);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   if(unMap.contains("left")) {
				   List<WebElement> links = null;
				   try {
					   links = unMappedTable.findElements(By.tagName("div"));
				   }catch(Exception e) {
					   test.log(Status.FAIL, "Links are not visible "+e);
					   generateScreenshots("Links");
				   }
				   int excelDataSize = readExcelData(column, sheet).size();
					   if(links != null) {
						   for (int index = 0; index <excelDataSize && index <= 50; index++) {
							   for(WebElement link : links) {
								   String linkName = link.getText();
								   WebElement linkToClick = driver.findElement(By.xpath("//div[text()='"+linkName+"']"));
								   String excelLink = readExcelData(column, sheet).get(index);
								   if(linkName.equalsIgnoreCase(excelLink)) {
									   js.executeScript("arguments[0].scrollIntoView();", linkToClick);
									   wait(3);
									   linkToClick.click();
									   test.log(Status.PASS, linkToClick.getText()+" is mapped.");
								   }
							   }
						   }
					   }
			   }else {
				   test.log(Status.INFO , "Unable to map");
			   }
		   }catch(Exception e) {
			   test.log(Status.FAIL, "Map links left block is not visible. "+ e);
			   generateScreenshots("Map Link");
		   }
	   }
	   public void unMapLinks(String locator , String column, String sheet) {
		   try {
			   WebElement unMappedTable = driver.findElement(getLocator(locator));
			   String unMap = unMappedTable.getAttribute("class");
			   log(unMap);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   if(unMap.contains("right")) {
				   List<WebElement> links = null;
				   try {
					   links = unMappedTable.findElements(By.tagName("div"));
				   }catch(Exception e) {
					   test.log(Status.FAIL, "Links are not visible "+e);
					   generateScreenshots("Links");
				   }
				   int excelDataSize = readExcelData(column, sheet).size();
					   if(links != null) {
						   for (int index = 0; index <excelDataSize && index <= 50; index++) {
							   for(WebElement link : links) {
								   String linkName = link.getText();
								   WebElement linkToClick = driver.findElement(By.xpath("//div[text()='"+linkName+"']"));
								   String excelLink = readExcelData(column, sheet).get(index);
								   if(linkName.equalsIgnoreCase(excelLink)) {
									   js.executeScript("arguments[0].scrollIntoView();", linkToClick);
									   wait(3);
									   linkToClick.click();
									   test.log(Status.PASS, linkToClick.getText()+" is UnMapped.");
								   }
							   }
						   }
					   }
			   }else {
				   test.log(Status.INFO , "Unable to UnMap");
			   }
		   }catch(Exception e) {
			   test.log(Status.FAIL, "Map right block is not visible. "+ e);
			   generateScreenshots("Mapping");
		   }
	   }

	   public List<String> getColumnText(String locator) {
		   WebElement row = driver.findElement(getLocator(locator));
		   List <WebElement> columnText = row.findElements(By.tagName("td"));
		   List<String> columnTextList = new ArrayList<>();

		    for (WebElement column : columnText) {
		        columnTextList.add(column.getText());
		    }
		    return columnTextList;
	   }
	   
}

