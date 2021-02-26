package gtm.pages;

import org.openqa.selenium.Keys;

import gtm.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	
	public PasswordPage enterUserName(String username) throws InterruptedException {
		driver.findElementById("identifierId").sendKeys(username,Keys.ENTER);
		Thread.sleep(5000);
		return new PasswordPage();
	}
	
}
