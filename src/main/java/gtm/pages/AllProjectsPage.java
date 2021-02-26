package gtm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import gtm.ProjectSpecificMethod;

public class AllProjectsPage extends ProjectSpecificMethod{
	
	public ProjectPage clickProjectName(String projectName) throws InterruptedException {
		
		WebElement link = driver.findElementByXPath("//a[text()=' "+projectName+" ']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", link);				
		Thread.sleep(2000);
		return new ProjectPage();
		
	}
	
}
