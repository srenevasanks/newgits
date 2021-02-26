package gtm.pages;

import org.openqa.selenium.Keys;

import gtm.ProjectSpecificMethod;

public class PasswordPage extends ProjectSpecificMethod{

	
	public AllProjectsPage enterPassword(String password) throws InterruptedException {
		driver.findElementByName("password").sendKeys(password, Keys.ENTER);
		Thread.sleep(5000);
		return new AllProjectsPage();
	}
	
}
