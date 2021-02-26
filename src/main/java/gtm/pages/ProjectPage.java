package gtm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import gtm.ProjectSpecificMethod;

public class ProjectPage extends ProjectSpecificMethod {

	public TriggerPage clickTriggerLink() throws InterruptedException {
		WebElement tagLink = driver.findElementByXPath("//a[text()='Triggers ']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", tagLink);
		Thread.sleep(5000);
		return new TriggerPage();
		
	}
	
	
}
