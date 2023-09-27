package Backend_TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import TestBase.BaseClass;

public class OpenBackend extends BaseClass{
	@Test
	public void openBackend() {
		application.launchBrowser(readExcelData("browser", "Open_Browser"));
		application.navigate("Backend", "URL");
		application.wait(3);
		application.validateTitle("signInText_xpath");
		application.waitForPageToLoad(driver, Duration.ofSeconds(200));
	}

}
