package Utility;

//import static org.testng.Assert.assertTrue;

//import static org.testng.Assert.assertTrue;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import com.aventstack.extentreports.Status;


public class ValidationKeyword extends GenericKeywords{
	
	public void validateTitle(String locatorkey) {
		WebElement e = driver.findElement(getLocator(locatorkey));
		if(e.isDisplayed()) {
			test.log(Status.PASS, "Title is Present");
			generateScreenshots(e.getText());
		}else {
			test.log(Status.FAIL, "Title is not present");
			//reportFailure("Title not displayed", true);
		}
	}
	
	public void validateNotLoginText(String locatorkey) {
		if(locatorkey.toLowerCase().contains("An error has occurred. Please check the input and try again.".toLowerCase())) {
			test.log(Status.FAIL, "Text is correct");
			generateScreenshots("Login Text");
		}else {
			test.log(Status.FAIL, "Text is not correct");
			//reportFailure("Text not displayed", true);
		}
	}

	public void validateSignInPopup() {
	    try {
	        Alert alert = driver.switchTo().alert();
	        String popupText = alert.getText();
	        
	        String expectedText = "Signed in Successfully";
	        
	        if (popupText.equals(expectedText)) {
	            test.log(Status.PASS, "Popup text is as expected: " + popupText);
	        } else {
	            test.log(Status.FAIL, "Popup text is not as expected. Expected: " + expectedText + ", Actual: " + popupText);
	        }
	        
	        alert.accept();
	    } catch (Exception e) {
	        System.out.println("No popup found.");
	    }
	}
	
	public void validatePopup(String expectedText) {
	    try {
	        Alert alert = driver.switchTo().alert();
	        String popupText = alert.getText();
	        if (popupText.equals(expectedText)) {
	            test.log(Status.PASS, "Popup text is as expected: " + popupText);
	        } else {
	            test.log(Status.FAIL, "Popup text is not as expected. Expected: " + expectedText + ", Actual: " + popupText);
	        }
	        
	        alert.accept();
	    } catch (Exception e) {
	        test.log(Status.FAIL, "No popup found.");
	    }
	}
	
	
	public void validateLogin(String valid, String invalid) {
	    try {
	        WebElement element = driver.findElement(getLocator(valid));
	        if (element.isDisplayed()) {
	            test.log(Status.PASS, "Logged in successfully");
	            generateScreenshots("Login");
	        } else {
	            validateNotLoginText(invalid);
	            test.log(Status.FAIL, "Login unsuccessful");
	            //reportFailure("User unable to login", true);
	        }
	    } catch (NoSuchElementException e) {
	        test.log(Status.FAIL, "Element not found: " + valid);
	        //reportFailure("Element not found: " + valid, true);
	    }
	}
	
	public void validateLogin(String locatorKey) {
		WebElement e = driver.findElement(getLocator(locatorKey));
		String text=e.getText();
		String expectedText = "Hi";
		
		if(text.toLowerCase().contains(expectedText.toLowerCase())) {
			test.log(Status.PASS, "User loggedIn Successfully");
			generateScreenshots("User loggedIn Successfully");
		}else {
			test.log(Status.FAIL, "User Not loggedIn");
			////reportFailure("element not Present", true);
			generateScreenshots("User Not loggedIn");
		}
	}
	
	
	public void validateLogout(String locatorKey) {
		WebElement e = driver.findElement(getLocator(locatorKey));
		String text=e.getText();
		if(text.equals("Sign In")) {
			test.log(Status.PASS, "User Logged out Successfully");
			generateScreenshots("User Logged out Successfully");
		}else {
			test.log(Status.FAIL, "User not logged out");
			generateScreenshots("User not logged out");
		}
	}
	
	
	
//	public void validateElementPresent(String locatorkey) {
//		try{
//		WebElement e = driver.findElement(getLocator(locatorkey));
//		
//		String text = e.getText();
//		if(e.isDisplayed()) {
//			test.log(Status.PASS,text+ " Element is present");
//			
//			generateScreenshots();
//		}else {
//			test.log(Status.FAIL,text+ " Element not present");
//			//reportFailure("element not Present", false);
//		}
//		}catch (Exception e) {
//	    test.log(Status.FAIL, "Element not present: " + e.getMessage());
//	    generateScreenshots();
//		}
//	}
	public void validateElementPresent(String locatorkey) {
	    try {
	        WebElement e = driver.findElement(getLocator(locatorkey));
	        String text = e.getText();
	        assertTrue(e.isDisplayed()+ text + " Element is present", true);
	        test.log(Status.PASS, text + " Element is present");
	        
	    } catch (AssertionError ae) {
	        test.log(Status.FAIL, ae.getMessage());
	        generateScreenshots(ae.getMessage());
	    }
	}
	
	public void validateElementPresent(String locatorKey, String elementName) {
	    try {
	        WebElement element = driver.findElement(getLocator(locatorKey));

	        assertTrue(element.isDisplayed()+ elementName + " Element is present",true);
	        test.log(Status.PASS, elementName + " Element is present");

	    } catch (AssertionError ae) {
	        String errorMessage = elementName + " element is not present: " + ae.getMessage();
	        test.log(Status.FAIL, errorMessage);

	    } catch (Exception e) {
	        String errorMessage = "Element not present: " + e.getMessage();
	        test.log(Status.FAIL, errorMessage);
	        generateScreenshots(errorMessage);
	    }
	}
	




	public void validateElementPresentText(String locatorkey, String message) {
		try {
		WebElement e = driver.findElement(getLocator(locatorkey));
		
		String text = e.getText();
		if(e.isDisplayed()) {
			test.log(Status.PASS,text+ " "+message+" Element is present");
			
		}else {
			test.log(Status.FAIL,text+" "+message+ " Element not present");
			//reportFailure("element not Present", false);
		}
		}catch(Exception e) {
			test.log(Status.FAIL, "Element not present: " + e.getMessage());
		    generateScreenshots(e.getMessage());
		}
	}
	
	public void validateElementsPresent(String locatorKey) {
	    List<WebElement> elements = driver.findElements(getLocator(locatorKey));
	    int elementsCount = elements.size();

	    if (elementsCount > 0) {
	        for (WebElement e : elements) {
	            String text = e.getText();
	            if (e.isDisplayed()) {
	                test.log(Status.PASS, text + " Element is present");
	                generateScreenshots(text);
	            } else {
	                test.log(Status.FAIL, text + " Element not present");
	                //reportFailure("Element not Present", false);
	            }
	        }
	    } else {
	        test.log(Status.FAIL, "No elements found with locator: " + locatorKey);
	        //reportFailure("No elements found", false);
	    }
	}

	
	
	
	public void validateCriticalElements(String locatorkey) {
		
		WebElement e = driver.findElement(getLocator(locatorkey));
		if(e.isDisplayed()) {
			test.log(Status.PASS, "Element is present");
			generateScreenshots(e.getText());
		}else {
			test.log(Status.FAIL, "Element not present");
			//reportFailure("element not Present", true);
	
		}
	}
	public void validateCompareText(String locatorkey ,String expectedText) {
		try {
			WebElement e = driver.findElement(getLocator(locatorkey));
			String text=e.getText();
			
			if(text.toLowerCase().equals(expectedText.toLowerCase())) {
				test.log(Status.PASS, text+" "+"Text is Displayed");
			}else {
				test.log(Status.FAIL, expectedText+"Text is not Displayed");
				generateScreenshots(text);
			}
		}catch(Exception e) {
			test.log(Status.FAIL, expectedText+ " is not visible ");
		}
	}
	
	public void validateCompareText(String locatorkey ,String expectedText , String expectedText2) {
		try {
			WebElement e = driver.findElement(getLocator(locatorkey));
			String text=e.getText();
			
			if(text.toLowerCase().equals(expectedText.toLowerCase())) {
				test.log(Status.PASS, text+" "+"Text is Displayed");
			}else if(text.equalsIgnoreCase(expectedText2)) {
				test.log(Status.INFO,text+ " Text is displayed");
			}
			
			else {
				test.log(Status.FAIL, expectedText +" or "+expectedText2+" Text are not Displayed");
				generateScreenshots(text);
			}
		}catch(Exception e) {
			test.log(Status.FAIL, expectedText+" or "+expectedText2+ " are not visible ");
		}
	}
	
	public void validateContainsText(String locatorkey ,String expectedText) {
		try {
			WebElement e = driver.findElement(getLocator(locatorkey));
			String text=e.getText();
			log(text);
			if(text.toLowerCase().contains(expectedText.toLowerCase())) {
				test.log(Status.PASS, text+" "+"Text is Displayed");
			}else {
				test.log(Status.FAIL, "Text is not Displayed");
				////reportFailure("element not Present", true);
				generateScreenshots(text);
			}
		}catch(Exception e) {
			test.log(Status.FAIL, expectedText+ " is not visible");
		}
	}
	
	public void validateDomainPresent(String locatorkey) {
	    try {
	        WebElement e = driver.findElement(getLocator(locatorkey));
	        String text = e.getText();
	        
	        assertTrue(e.isDisplayed()+ text + " Element is present",true);
	        test.log(Status.PASS, text + " Element is present");
	        generateScreenshots(text);
	        
	    } catch (AssertionError ae) {
	        test.log(Status.FAIL, ae.getMessage());
	        //reportFailure("element not Present", false);
	        
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Element not present: " + e.getMessage());
	        generateScreenshots(e.getMessage());
	    }
	}
	
	public void validateFieldRequired(String locatorKey) {
		WebElement e = driver.findElement(getLocator(locatorKey));
		String text=e.getText();
		if(text.equals("This is a required field.")) {
			test.log(Status.PASS, text+ " "+ "text is displayed");
			generateScreenshots(text);
		}else {
			test.log(Status.FAIL, text+ " "+ "text is displayed");
			generateScreenshots(text);
		}
	}
	
	
	
	public void validatePasswordVisibility(String textBoxLocator) {
		WebElement inputbox = driver.findElement(getLocator(textBoxLocator));
		String inputValue = inputbox.getAttribute("type");
		if(inputValue.equals("password")) {
			test.log(Status.INFO, "Password is not visible");
		}else if(inputValue.equals("text")) {
			test.log(Status.INFO, "Password is visible.");
		}
	}
	
	public void validateCompanyError(String locator) {
		WebElement companyError = driver.findElement(getLocator(locator));
		String error = "please select a company";
		if(companyError.isDisplayed()){
			if(companyError.getText().toLowerCase().equals(error)){
				test.log(Status.PASS, companyError.getText()+ "error is displayed if confirm button is clicked without selecting the company");
				assertTrue(companyError.getText()+" is displayed",true);
				generateScreenshots(companyError.getText());
			}
		}else if(!companyError.isDisplayed()) {
			test.log(Status.FAIL, "Error not displayed for submitting without selecting the company");
			assertTrue(error+" is not displayed", false);
			generateScreenshots(error);
		}
	}
	public String[] getTableHeaders(String tableLocator) {
        WebElement table = driver.findElement(getLocator(tableLocator));
        WebElement headerRow = table.findElements(By.tagName("tr")).get(0);
        java.util.List<WebElement> headerCells = headerRow.findElements(By.tagName("th"));

        String[] headers = new String[headerCells.size()];
        for (int i = 0; i < headerCells.size(); i++) {
            headers[i] = headerCells.get(i).getText();
        }
        return headers;
    }
	
	public void validateLicenseeTableHeaders(String tableLocator) {
        String[] actualHeaders = getTableHeaders(tableLocator);
        String[] expectedHeaders = {"Licensee Name", "Licensee ID", "Default Company" , "License Start Date" , "License End Date",
        		 "No. Of Card" ,"Total Consumed Card" , "ID-Card Allowed" , "Language" , "Created On" , "Action"}; 
        assertTrue("Table headers do not match expected.", Arrays.equals(actualHeaders, expectedHeaders));
    }
	public void validateManageCompanyTableHeaders(String tableLocator) {
        String[] actualHeaders = getTableHeaders(tableLocator);
        String[] expectedHeaders = {"Company", "Email", "Contact" , "Image" , "Created On","Action"}; 
        assertEquals( "Table headers do not match expected.",Arrays.equals(actualHeaders, expectedHeaders));
    }
	
	public void validateDashboardTableHeaders(String tableLocator) {
		 String[] actualHeaders = getTableHeaders(tableLocator);
		 String[] expectedHeaders = {"Employee Name", "Total Impressions", "Unique Impression" , "Redirect From"}; 
		 assertEquals( "Table headers do not match expected.",Arrays.equals(actualHeaders, expectedHeaders));
	}
	
	public void validateEmployeeNoData() {
		try {
		WebElement noData = driver.findElement(getLocator("noDataAvailableText_xpath"));
		test.log(Status.INFO, noData.getText()+" for the employee download.");
		}catch(Exception e ) {
			test.log(Status.INFO, "Data is Visible");
		}
	}
	
	public void selectPageInPaginationFromExcel(String columnName, String nameOfSheet) {
	    List<WebElement> pageElements = driver.findElements(By.xpath("//ul[@class='pagination']/li/a")); 
	    
	    // Read the page number from Excel
	    List<String> excelData = readExcelData(columnName, nameOfSheet);
	    if (excelData == null || excelData.isEmpty()) {
	        test.log(Status.FAIL, "Page number not found in Excel.");
	        return;
	    }
	    int pageNumber = Integer.parseInt(excelData.get(0));

	    if (pageNumber >= 1 && pageNumber <= pageElements.size() - 2) {
	        pageElements.get(pageNumber).click();
	        test.log(Status.PASS, "Page selected is " + pageNumber);
	    } else {
	        test.log(Status.FAIL, "Invalid page number");
	    }
	}

	
	public void validateElementContains(String Locator , String text) {
		WebElement locator = null;
		try {
		locator = driver.findElement(getLocator(Locator));
		}catch(Exception e ) {
			test.log(Status.FAIL, text+" Element not visivle.");
			generateScreenshots(text);
		}
		String locatorText = locator.getText();
		if(locatorText.contains(text)) {
			test.log(Status.PASS, text+" Popup is visible.");
		}else {
			test.log(Status.FAIL, text+" is not as expected.");
			generateScreenshots(text);
		}
		
	}
	public void validateError(String locator , String Error) {
		try {
		WebElement errorLocator = driver.findElement(getLocator(locator));
		String errorText = errorLocator.getText();
		if(errorText.toLowerCase().equals(Error.toLowerCase())) {
			test.log(Status.PASS, errorText+" is displayed.");
		}
		}catch(Exception e) {
			test.log(Status.FAIL, Error+"Error is not displayed");
		}
	}
	
	public void validateFieldRequiredErrors(String NameErrorLocator, String DomainErrorLocator, String StartDateErrorLocator, 
			String ToDateErrorLocator ,String NoOFCardsErrorLocator) {
		WebElement NameError = null;
		WebElement DomainError = null;
		WebElement StartDateError = null;
		WebElement ToDateError = null;
		WebElement NoOfCardsError = null;
		try {
			NameError = driver.findElement(getLocator(NameErrorLocator));
		}catch(Exception e) {
			test.log(Status.FAIL, "Error is not displayed for blank input in Licensee name.");
		}try {
			DomainError = driver.findElement(getLocator(DomainErrorLocator));
		}catch(Exception e) {
			test.log(Status.FAIL, "Error is not displayed for blank input in Company Domain.");
		}try {
			StartDateError = driver.findElement(getLocator(StartDateErrorLocator));
		}catch(Exception e) {
			test.log(Status.FAIL, "Error is not displayed for blank input in Start date.");
		}try {
			ToDateError = driver.findElement(getLocator(ToDateErrorLocator));
		}catch(Exception e) {
			test.log(Status.FAIL, "Error is not displayed for blank input in To date.");
		}try {
			NoOfCardsError = driver.findElement(getLocator(NoOFCardsErrorLocator));
		}catch(Exception e) {
			test.log(Status.FAIL, "Error is not displayed for blank input in Number of cards.");
		}

		String error = "Required field";
		String DuplicateDomainError = "domain already exist, please enter another domain.";
		
		if(NameError.getText().equalsIgnoreCase(error)) {
			test.log(Status.PASS, NameError.getText()+" is displayed for blank input in Licensee Name.");
		}else {
			test.log(Status.FAIL, NameError.getText()+" is diplayed for blank input in Licensee Name.");
			generateScreenshots(error);
		}
//		if(DomainError.getText().toLowerCase().contains(DuplicateDomainError)){
//			test.log(Status.PASS, DomainError.getText()+" is displayed for duplicate Domain Entered.");
//		}else {
//			test.log(Status.FAIL, DomainError.getText()+" is displayed for duplicate Domain Entered.");
//			generateScreenshots("DomainError");
//		}
		if(DomainError.getText().equalsIgnoreCase(error)){
			test.log(Status.PASS, DomainError.getText()+" is displayed for duplicate Domain Entered.");
		}else {
			test.log(Status.FAIL, DomainError.getText()+" is displayed for duplicate Domain Entered.");
			generateScreenshots("DomainError");
		}

		if(StartDateError.getText().equalsIgnoreCase(error)) {
			test.log(Status.PASS, StartDateError.getText()+" is displayed for blank input in Licensee Start Date.");
		}else {
			test.log(Status.FAIL, StartDateError.getText()+" is diplayed for blank input in Licensee Start Date.");
			generateScreenshots("Start Date Error");
		}
		if(ToDateError.getText().equalsIgnoreCase(error)) {
			test.log(Status.PASS, ToDateError.getText()+" is displayed for blank input in Licensee To Date.");
		}else {
			test.log(Status.FAIL, ToDateError.getText()+" is diplayed for blank input in Licensee To Date .");
			generateScreenshots("Start Date Error");
		}
		
		if(NoOfCardsError.getText().equalsIgnoreCase(error)) {
			test.log(Status.PASS, NoOfCardsError.getText()+" is displayed for No.Of Cards Blank input.");
		}else {
			test.log(Status.FAIL, NoOfCardsError.getText()+" is displayed for No.Of Cards Blank input.");
			generateScreenshots("Start Date Error");
		}
		generateScreenshots("Field Required Validation");
	}
	
	public void validateErrorNotDisplayed(String Locator , String message) {
		try {
			WebElement locator = driver.findElement(getLocator(Locator));
			if(locator.isDisplayed()) {
				test.log(Status.FAIL, locator.getText()+" error is displayed.");
				generateScreenshots(locator.getText());
			}else {
	            test.log(Status.PASS, "No error is displayed for " + message);
	        }
		}catch(Exception e) {
			test.log(Status.PASS, "Error is not displayed for "+message);
		}
	}
	
	public void validateElementNotDisplayed(String Locator , String message) {
		try {
			WebElement locator = driver.findElement(getLocator(Locator));
			if(locator.isDisplayed()) {
				test.log(Status.FAIL, locator.getText()+" element is displayed.");
				generateScreenshots(locator.getText());
			}else {
	            test.log(Status.PASS, "element not displayed " + message);
	        }
		}catch(Exception e) {
			test.log(Status.PASS, "element not displayed  "+message);
		}
	}
	
	
	public void validateDuplicateDomainErrorDisplayed(String Locator) {
		try {
			String DuplicateError = "'https://test.com' domain already exist, Please enter another domain.";
			WebElement locator = driver.findElement(getLocator(Locator));
			if(locator.isDisplayed()) {	
				if(locator.getText().equals(DuplicateError)) {
					test.log(Status.INFO, locator.getText());
				}else if(!locator.getText().equals(DuplicateError)) {
					test.log(Status.INFO, locator.getText()+" is displayed.");
				}
			}
		}catch(Exception e) {
			test.log(Status.INFO, "Error is not displayed for duplicate domain");
		}
	}
	

	public boolean validateSpecialCharacters(String inputText) {
	    String specialCharsPattern = "[!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~]";
	    return inputText.matches(".*" + specialCharsPattern + ".*");
	}

	public void validateEmailIputField(String textBoxLocator, String errorLocator) {
        WebElement inputBox = driver.findElement(getLocator(textBoxLocator));
        WebElement error = driver.findElement(getLocator(errorLocator));

        String inputText = inputBox.getAttribute("value");
        String errorText = error.getText();
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String emailFormatError = "Email should not contain special characters other than . and @.";
        String fieldRequiredText = "This is a required field.";

        log(inputText);
        log(errorText);

        if (!inputText.isBlank()) {
            if (!errorText.isEmpty()) {
                if (!inputText.contains(emailPattern)) {
                    if (errorText.equals(emailFormatError)) {
                        test.log(Status.PASS, errorText + " Text is displayed for entering an invalid email format in the input");
                        generateScreenshots(errorText);
                    } else if (errorText.equals(fieldRequiredText)) {
                        test.log(Status.FAIL, errorText + " Text is displayed for entering an invalid email format in the input");
                        generateScreenshots(errorText);
                    } else {
                        test.log(Status.FAIL, errorText + " Error is displayed");
                        generateScreenshots(errorText);
                    }
                } else if (inputText.matches(emailPattern)) {
                    test.log(Status.FAIL, "Error message is displayed even with a valid email format in the input");
                    generateScreenshots(inputText);
                }
            } else if (errorText.isEmpty()) {
                if (inputText.matches(emailPattern)) {
                    test.log(Status.PASS, "Input entered is in a valid email format");
                    generateScreenshots(inputText);
                } else if (!inputText.matches(emailPattern)) {
                    test.log(Status.FAIL, "Error message is not displayed even after entering an invalid email format");
                    generateScreenshots(inputText);
                }
            }
        } else if (inputText.isBlank()) {
            if (errorText.isEmpty()) {
                test.log(Status.FAIL, "Error is not popped up even if the input field is empty");
                generateScreenshots(inputText);
            } else if (!errorText.isEmpty()) {
                if (errorText.equals(fieldRequiredText)) {
                    test.log(Status.PASS, errorText + " Error is displayed");
                    generateScreenshots(inputText);
                }
            }
        }
    }
	 public void validatePassword(String textBoxLocator, String errorLocator) {
	        WebElement inputBox = driver.findElement(getLocator(textBoxLocator));
	        WebElement error = driver.findElement(getLocator(errorLocator));

	        String inputText = inputBox.getAttribute("value");
	        String errorText = error.getText();
	        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).{8,}$";
	        String passwordFormatError = "Must contain at least 8 character(s).";
	        String passwordFormatError2 = "A password must contain at least 3 of the following: lowercase, uppercase, digits, special characters.";
	        String fieldRequiredText = "This is a required field.";

	        log(inputText);
	        log(errorText);

	        if (!inputText.isBlank()) {
	            if (!errorText.isEmpty()) {
	                if (!inputText.matches(passwordPattern)) {
	                    if (errorText.equals(passwordFormatError)) {
	                        test.log(Status.PASS, errorText + " Text is displayed for entering less than 8 charcters");
	                        generateScreenshots(errorText);
	                    } else if (errorText.equals(fieldRequiredText)) {
	                        test.log(Status.FAIL, errorText + " Text is displayed for entering an invalid password format in the input");
	                        generateScreenshots(errorText);
	                    }else if(errorText.equals(passwordFormatError2)) {
	                    	test.log(Status.PASS, errorText + " Text is displayed for not meeting the password requirements");
	                        generateScreenshots(errorText);
	                    } else {
	                        test.log(Status.FAIL, errorText + " Error is displayed");
	                        generateScreenshots(errorText);
	                    }
	                } else if (inputText.matches(passwordPattern)) {
	                    test.log(Status.PASS, "Input entered is in a valid password format");
	                    generateScreenshots(inputText);
	                }
	            } else if (errorText.isEmpty()) {
	                if (!inputText.matches(passwordPattern)) {
	                    test.log(Status.PASS, "Input entered does not match the required password format");
	                    generateScreenshots(inputText);
	                } else if (inputText.matches(passwordPattern)) {
	                    test.log(Status.FAIL, "Error message is not displayed even after entering a valid password format");
	                    generateScreenshots(inputText);
	                }
	            }
	        } else if (inputText.isBlank()) {
	            if (errorText.isEmpty()) {
	                test.log(Status.FAIL, "Error is not displayed even if the input field is empty");
	                generateScreenshots(inputText);
	            } else if (!errorText.isEmpty()) {
	                if (errorText.equals(fieldRequiredText)) {
	                    test.log(Status.PASS, errorText + " Error is displayed");
	                    generateScreenshots(inputText);
	                }
	            }
	        }
	    }
	
	 public void validateAccountDuplicate(String locatorKey) {
		 try{
			WebElement e = driver.findElement(getLocator(locatorKey));
			
			String text = e.getText();
			if(e.isDisplayed()) {
				test.log(Status.PASS , text+" text is Displayed if an account is already created with the same mail ID.");
				generateScreenshots(text);
			}else {
				test.log(Status.FAIL,text+ " text is displayed");
				generateScreenshots(text);
			}
		}catch (Exception e) {
		    test.log(Status.INFO, "Account Duplicate error not displayed." );
		    generateScreenshots("Account Duplicate");
			}
	 }
	
	
	public void validateOrderID(String locatorKey, String columnName, String nameOfSheet) {
	    List<String> expectedOrderIDs = readExcelData(columnName, nameOfSheet);
	    if (expectedOrderIDs == null) {
	        // Failed to read Excel data
	        test.log(Status.FAIL, "Failed to read Excel data for validation");
	        return;
	    }

	    WebElement element = driver.findElement(getLocator(locatorKey));
	    String actualOrderID = element.getText();

	    boolean isOrderIDDisplayed = false;
	    for (String expectedOrderID : expectedOrderIDs) {
	        if (actualOrderID.equals(expectedOrderID)) {
	            isOrderIDDisplayed = true;
	            test.log(Status.PASS, "Order ID is Displayed: " + expectedOrderID);
	            break;
	        }
	    }

	    if (!isOrderIDDisplayed) {
	        test.log(Status.FAIL, "Order ID is not Displayed");
	    }
	}

	
	
	public void validatePincodePopup(String locatorKey) {
		 WebElement pincodePopUp = driver.findElement(getLocator(locatorKey));
		 if(pincodePopUp.isDisplayed()) {
			 test.log(Status.PASS, "Pincode Pop up is Displayed");
			 generateScreenshots("Pincode Pop up");
		 }else if(!pincodePopUp.isDisplayed()) {
			 test.log(Status.FAIL, "pincode Pop Up is not Displayed");
			 generateScreenshots("Pincode Pop up");
		 }
	}
	public void validatePincodePopupAfterCancel(String locatorKey) {
		 WebElement pincodePopUp = driver.findElement(getLocator(locatorKey));
		 if(pincodePopUp.isDisplayed()) {
			 test.log(Status.FAIL, "Pincode Pop up is Displayed");
			 generateScreenshots("Pincode Pop up is Displayed");
		 }else if(!pincodePopUp.isDisplayed()) {
			 test.log(Status.PASS, "pincode Pop Up is not Displayed");
			 generateScreenshots("pincode Pop Up is not Displayed");
		 }
	}
	
	
//	
	
	
	
	public void validateHiText(String locatorKey) {
		 WebElement HiTextLocator= driver.findElement(getLocator(locatorKey));
		 
		 String Text = HiTextLocator.getText();
		 if(Text.contains("Hi")) {
			 test.log(Status.PASS, "Name is Displayed in the place of sign In button");
			 generateScreenshots(Text);
		 }else if(!Text.contains("Hi")) {
			 test.log(Status.FAIL, "Name is Not Displayed in the place of sign In button");
			 generateScreenshots(Text);
		 }
	}
	
	
	
	public void blankInputLoginValidation(String userLocator, String passLocator, String userErrorLocator,
          String passErrorLocator) {
		WebElement username = driver.findElement(getLocator(userLocator));
		WebElement password = driver.findElement(getLocator(passLocator));
		String userErrorText = "This is a required field.";
		String passErrorText = "This is a required field.";
		//String mandatoryCharcters = "@"+".";
		WebElement userError = null;
		WebElement passError = null;
		
		if (username.getText().isBlank() && password.getText().isBlank()) {
			try {
					userError = driver.findElement(getLocator(userErrorLocator));
				} catch(Exception e) {
					test.log(Status.FAIL, "Username Error not visible");
					generateScreenshots("Username Error not visible");
				}
			try {
				passError = driver.findElement(getLocator(passErrorLocator));
			}catch(Exception e) {
				test.log(Status.FAIL, "Password error is not visible.");
				generateScreenshots("Password error is not visible.");
			}
			if(userError.isDisplayed() && passError.isDisplayed()) {
				if(userError.getText().equals(userErrorText) && passError.getText().equals(passErrorText)) {
					test.log(Status.PASS,userErrorText+ " Text is displayed for empty username and password input");
					generateScreenshots(userErrorText);
				}else if(!userError.getText().equals(userErrorText) && !passError.getText().equals(passErrorText)) {
					test.log(Status.FAIL,userErrorText+ " "+passErrorText+" Texts are displayed for empty username and password input.");
					generateScreenshots(userErrorText);
				}else if(!userError.getText().equals(userErrorText) && passError.getText().equals(passErrorText)) {
					test.log(Status.FAIL,passErrorText+" Error is displayed for blank input password . But"+userErrorText+" Text is displayed for the blank input in username.");
					generateScreenshots(passErrorText);
				}else if (userError.getText().equals(userErrorText) && passError.getText().equals(passErrorText)) {
					test.log(Status.FAIL,userErrorText+" Error is displayed for blank input username . But"+passErrorText+" Text is displayed for the blank input in password.");
					generateScreenshots(userErrorText);
				}
				
			}
			}
		
		
	}
	
	
	public void validateAddAddressPopup2(List<String>firstName , List<String>middleName , List<String>lasttName , List<String>phoneNumber,
			List<String>streetAddress , List<String>streetAddress2 , List<String>postalCode, List<String>city , String state , String country) {
		
		
	}
	
	public void validateAddAddressPopup(String firstName, String middleName , String lasttName, String phoneNumber,
			String streetAddress, String streetAddress2, String postalCode, String city, String state, String country) {
		
	}
	
	//Listing page validation
	
	public int getElementsCount(String locatorKey) {
	    List<WebElement> elements = driver.findElements(getLocator(locatorKey));
	    int elementsCount = elements.size();
	    log("Number of elements present are"+ elementsCount);
	    return elementsCount;
	}

	
	public void selectDateFromInput(String locatorkey, String columnName, String nameOfSheet) {
	    List<String> numericDateValues = readExcelData(columnName, nameOfSheet);
	    if (numericDateValues == null || numericDateValues.isEmpty()) {
	        System.out.println("No dates found in the Excel sheet.");
	        test.log(Status.FAIL, "No dates found in the Excel sheet.");
	        return;
	    }

	    for (String numericDate : numericDateValues) {
	        try {
	            int numericDateValue = Integer.parseInt(numericDate);
	            long milliseconds = (numericDateValue - 1L) * 24 * 60 * 60 * 1000; // Convert days to milliseconds
	            Date javaDate = new Date(milliseconds);

	            int day = Integer.parseInt(new SimpleDateFormat("dd").format(javaDate));
	            log("Selected day: " + day);
	            String monthAbbreviation = new SimpleDateFormat("MMM").format(javaDate); // Abbreviated month like "Aug"
	            log(monthAbbreviation);
	            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(javaDate));

	            // Modify the locator to work with input tags
	            By inputLocator = getLocator(locatorkey);

	            // Find the input element
	            WebElement inputElement = driver.findElement(inputLocator);
	            inputElement.click(); // This step might be necessary to open the date picker

	            // Select the desired month and year from the dropdowns
	            Select monthSelect = new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
	            Select yearSelect = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
//	            monthSelect.selectByVisibleText(monthAbbreviation); // Use visible text (e.g., "Aug")
//	            wait(3);
//	            yearSelect.selectByValue(String.valueOf(year));
//	            wait(3);
	            WebElement calendarTable = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
	            
	            // Locate the specific day cell in the calendar table
	            By dayCellLocator = By.xpath("//a[text()='" + day + "']");
	            WebElement dayCell = calendarTable.findElement(dayCellLocator);
	           
	            wait(3);
	            dayCell.click();

	            // After selecting the date, close the date picker if needed
	            // You might also need to blur the input field to trigger any validation or updates

	            // After selecting the date, continue with the loop

	        } catch (Exception e) {
	            test.log(Status.FAIL, e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}
	
	
	public void selectDateFromExcel(String calendarLocator, String monthLocator, String yearLocator, String columnName, String sheetName) throws Exception {
	    // Get the target date from the Excel sheet using the readExcelData method
	    List<String> data = readExcelData(columnName, sheetName);
	    if (data.isEmpty()) {
	        // Log an error or handle the case when data is not found in Excel
	        return;
	    }
	    
	    String targetDate = data.get(0); // Assuming the target date is in the first row
	    
	    WebElement calendarDiv = driver.findElement(getLocator(calendarLocator));
	    WebElement monthDropdown = calendarDiv.findElement(getLocator(monthLocator));
	    Select monthSelect = new Select(monthDropdown);

	    // Parse the targetDate in "dd-MMM-yyyy" format
	    SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	    Date date = inputDateFormat.parse(targetDate);

	    // Get the target month in MMM format
	    String targetMonth = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date);

	    // Select the target month from the dropdown
	    monthSelect.selectByVisibleText(targetMonth);

	    // Select the target year from the year dropdown
	    WebElement yearDropdown = calendarDiv.findElement(getLocator(yearLocator));
	    Select yearSelect = new Select(yearDropdown);
	    yearSelect.selectByVisibleText(String.valueOf(date.getYear() + 1900));

	    // Locate and interact with the date table
	    WebElement dateTable = calendarDiv.findElement(By.tagName("table"));

	    // Find and click the desired day
	    WebElement targetDayElement = dateTable.findElement(By.linkText(String.valueOf(date.getDate())));
	    targetDayElement.click();
	}


	
	public void selectFromDown(String locator, String columnName, String sheetName) {
	    List<String> options = readExcelData(columnName, sheetName);
	    if (options != null && !options.isEmpty()) {
	        WebElement element = getElement(locator);
	        Select select = new Select(element);

	        boolean optionSelected = false; // Flag to track if any option is selected

	        for (final String option : options) {
	            List<Object> matchingOptions = select.getOptions().stream()
	                    .filter(new Predicate<WebElement>() {
							@Override
							public boolean test(WebElement opt) {
								return opt.getText().equalsIgnoreCase(option);
							}
						})
	                    .collect(Collectors.toList());

	            if (!matchingOptions.isEmpty()) {
	                select.selectByVisibleText(option);
	                optionSelected = true;
	                break;
	            }
	        }

	        if (!optionSelected) {
	            test.log(Status.INFO, "No matching option found in the dropdown");
	        }
	    } else {
	        test.log(Status.INFO, "No option data found in the Excel sheet");
	    }
	}
	
	public void clickLastColumnButtonForFirstColumnValue(String tableLocator, String firstColumnLocator,String columnName,String nameOfSheet, String buttonLocator) {
	    WebElement table = driver.findElement(getLocator(tableLocator));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    List<String> targetValues = readExcelData(columnName, nameOfSheet);
	    
	    if (targetValues == null) {
	        log("Unable to read Excel data");
	        return;
	    }
	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));

	        if (columns.size() >= 1) { 
	            WebElement firstColumn = columns.get(0); 
	            String firstColumnText = firstColumn.getText();
	            for(String targetValue : targetValues) {	
		            if (firstColumnText.toLowerCase().equals(targetValue.toLowerCase())) {
		                WebElement lastColumnButton = columns.get(columns.size() - 1).findElement(getLocator(buttonLocator));
		                highlightElement(lastColumnButton);
		                lastColumnButton.click();
		                wait(3);
		                log(targetValue+"Button in the last column is clicked");
		                return;
		            }
	            }
	        }
	    }
	    log("Matching row not found");
	}
	
	public void getLastColumnButtonForFirstColumnValue(String tableLocator, String firstColumnLocator,String columnName, String column2 ,String nameOfSheet, String buttonLocator) {
	    WebElement table = driver.findElement(getLocator(tableLocator));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    List<String> targetValues = readExcelData(columnName, nameOfSheet);
	    String sheetStatus = readExcelData(column2, nameOfSheet).get(0);
	    
	    if (targetValues == null) {
	        log("Unable to read Excel data");
	        return;
	    }
	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));

	        if (columns.size() >= 1) { 
	            WebElement firstColumn = columns.get(0); 
	            String firstColumnText = firstColumn.getText();
	            for(String targetValue : targetValues) {	
		            if (firstColumnText.toLowerCase().equals(targetValue.toLowerCase())) {
		                WebElement lastColumnButton = columns.get(columns.size() - 1).findElement(getLocator(buttonLocator));
		                
		                String status =  lastColumnButton.getAttribute("title");
		                wait(3);
		                if(status.equalsIgnoreCase("enable")) {
		                	if(sheetStatus.equalsIgnoreCase("enable")) {
		                		highlightElement(lastColumnButton);
		                		lastColumnButton.click();
		                	}else if(sheetStatus.equalsIgnoreCase("disable")) {
		                		test.log(Status.PASS, "Status is already Enabled");
		                	}
		                }else if (status.equalsIgnoreCase("disable")) {
		                	if(sheetStatus.equalsIgnoreCase("enable")) {
		                		test.log(Status.PASS, "Status is already Disabled");
		                	}else if (sheetStatus.equalsIgnoreCase("disable")) {
		                		highlightElement(lastColumnButton);
		                		lastColumnButton.click();
		                		
		                	}
		                }
		                log(targetValue+"Button in the last column is clicked");
		                return;
		            }
	            }
	        }
	    }
	    log("Matching row not found");
	}
//	public void clickLastColumnButtonForFirstColumnValue(String tableLocator, String firstColumnLocator, String columnName, String sheetName, String buttonLocator) {
//	    List<WebElement> firstColumnElements = driver.findElements(getLocator(firstColumnLocator));
//	    
//	    String targetValue = readExcelData(columnName, sheetName).get(0);
//	    // Iterate through all the elements with the firstColumnLocator
//	    for (WebElement firstColumnElement : firstColumnElements) {
//	        String firstColumnText = firstColumnElement.getText();
//	        
//	        if (firstColumnText.toLowerCase().equals(targetValue.toLowerCase())) {
//	            WebElement row = firstColumnElement.findElement(By.xpath("./ancestor::tr"));
//	            List<WebElement> columns = row.findElements(By.tagName("td"));
//	            
//	            // Click the button in the last column using the provided button locator
//	            WebElement lastColumnButton = columns.get(columns.size() - 1).findElement(getLocator(buttonLocator));
//	            lastColumnButton.click();
//	            
//	            log(targetValue + " Button in the last column is clicked");
//	        }
//	    }
//	}



	 public void getSelectedOptionsFromDropdown(String dropdownLocator) {
	        // Locate the dropdown element
	        WebElement dropdown = driver.findElement(getLocator(dropdownLocator)); // Replace with actual locator

	        // Initialize the Select class
	        Select select = new Select(dropdown);

	        // Select options by index or value
//	        select.selectByIndex(0);
//	        select.selectByIndex(1);;

	        // Get all selected options
	        List<String> selectedOptionTexts = getSelectedOptionTexts(select);

	        // Print the selected options
	        for (String optionText : selectedOptionTexts) {
	            test.log(Status.INFO,"Selected option: " + optionText);
	        }
	    }
	 private List<String> getSelectedOptionTexts(Select select) {
	        List<WebElement> selectedOptions = select.getAllSelectedOptions();
	        List<String> selectedOptionTexts = new ArrayList<>();

	        for (WebElement option : selectedOptions) {
	            selectedOptionTexts.add(option.getText());
	        }

	        return selectedOptionTexts;
	    }
	 public void validateMandatoryIconForLabel(String labelName) {
		    String labelXpath = "//label[contains(text(), '" + labelName + "')]";
		    String mandatoryIconXpath = labelXpath + "/following-sibling::label[text()='*']";

		    try {
		    	WebElement label = driver.findElement(By.xpath(labelXpath));
		        WebElement mandatoryIcon = driver.findElement(By.xpath(mandatoryIconXpath));
		        log("Mandatory indicator is present for label: " + labelName);
		        test.log(Status.PASS, "Mandatory indicator is present for label: " + labelName);
		    } catch (NoSuchElementException e) {
		        test.log(Status.FAIL,"Mandatory indicator is not present for label: " + labelName);
		    }
		}
	 public void validateExampleURl(String exampleLocator ,String columnName, String sheetName) {
		 String example = readExcelData(columnName, sheetName).get(0);
		 if(example.equalsIgnoreCase("Employee Name")) {
			 validateElementPresentText(exampleLocator, "Emp-Name");
			 test.log(Status.PASS, "https://digitalcardmluat.azurewebsites.net/Emp-Name is displayed.");
		 }else if(example.equalsIgnoreCase("Employee Mobile No")) {
			 validateElementPresent(exampleLocator, "9xxxxxxxxxx");
			 test.log(Status.PASS, "https://digitalcardmluat.azurewebsites.net/9xxxxxxxxxx is displayed.");
		 }else if(example.equalsIgnoreCase("System Generated")) {
			 validateElementPresent(exampleLocator, "WRqAqDNUROModIaQ7Tuai8V7-I0A");
			 test.log(Status.PASS, "https://digitalcardmluat.azurewebsites.net/WRqAqDNUROModIaQ7Tuai8V7-I0A is displayed.");
		 }else {
			 test.log(Status.FAIL, "Option provided in Excel is not visible");
		 }
	 }
	 
	 public void oneOfTwoElementsPresent(String element1, String element2) {
		    try {
		        WebElement ele1 = driver.findElement(getLocator(element1));
		        test.log(Status.PASS, ele1.getText() + " is displayed");
		    } catch (Exception e1) {
		        try {
		            WebElement ele2 = driver.findElement(getLocator(element2));
		            test.log(Status.PASS, ele2.getText() + " is displayed");
		        } catch (Exception e2) {
		            test.log(Status.FAIL, "Neither " + element1 + " nor " + element2 + " is displayed");
		        }
		    }
		}

}
