package gtm.pages;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import gtm.ProjectSpecificMethod;
import junit.framework.Assert;

public class TriggerPage extends ProjectSpecificMethod{

	public TriggerPage verifyDuplicateTriggerName(String triggerName) throws IOException {
		List<WebElement> triggernameList = driver.findElementsByXPath("//tbody//tr//td[1]");
		for (WebElement tname : triggernameList) {
			tagExistingCheck = true;
			if(tname.getText().contains(triggerName)) {
				tagExistingCheck=false;
				System.out.println("Provided trigger name("+triggerName+") is already used");
				dec.add("Trigger name("+triggerName+") is already used.");
				sts.add("fail");
				Assert.assertEquals(true, tagExistingCheck);
			}
		}
		return this;
	}
	
	public TagPage clickTagLink() {
		WebElement tagLink = driver.findElementByXPath("//a[text()='Tags ']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", tagLink);
		return new TagPage();
	}
	
}
