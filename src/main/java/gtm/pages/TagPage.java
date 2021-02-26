package gtm.pages;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gtm.ProjectSpecificMethod;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TagPage extends ProjectSpecificMethod{
	
	@SuppressWarnings("deprecation")
	public TagPage verifyDuplicateTagName(String tagName) throws InterruptedException, IOException {
		List<WebElement> tagnameList = driver.findElementsByXPath("(//tr[@class='wd-tag-row'])//td[1]");
		HashSet<String> tagList = new HashSet<String>();
		for (WebElement tname : tagnameList) {
			tagExistingCheck = true;
			if(tname.getText().contains(tagName)) {
				tagExistingCheck=false;
				System.out.println("Provided tag name("+tagName+") is already used");
				dec.add("Tag name("+tagName+") is already used.");
				sts.add("fail");
				Assert.assertEquals(true, tagExistingCheck);
			}
		}
		return this;
	}
	
	public TagPage clickOnExistingTagName(String tagName) throws InterruptedException {
		List<WebElement> tagnameList = driver.findElementsByXPath("(//tr[@class='wd-tag-row'])//td[1]");
		HashSet<String> tagList = new HashSet<String>();
		for (WebElement tname : tagnameList) {
			if(tname.getText().contains(tagName)) {
				tname.click();
				Thread.sleep(3000);
			}
		}
		return this;
	}
	
	
	public TriggerPage clickTriggerLink() {
		
		return new TriggerPage();
	}
	
	
	public TagPage clickNew() {
		driver.findElementByXPath("//button[text()=' New ']").click();
		return this;
	}
	
	public TagPage sendTagName(String tagName) throws InterruptedException {
		WebElement TagName = driver.findElementByXPath("//div[@name='tag.data.name']");
		TagName.clear();
		TagName.sendKeys("GA-"+tagName);
		Thread.sleep(3000);
		return this;
	}
	
	public TagPage clickTagConfig() {
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[1]").click();
		return this;
	}
	
	public TagPage clickGoogleAnalytics() {
		driver.findElementByXPath("//div[text()='Google Analytics: Universal Analytics']").click();
		return this;
	}
	
	public TagPage selectEvent(String eventName) {
		Select trackType = new Select(driver.findElementByXPath("//select[@name='tag.data.vendorTemplate.param.trackType']"));
		trackType.selectByVisibleText(eventName);
		return this;
	}

	public TagPage sendCategory(String categoryName) {
		driver.findElementByXPath("(//label[text()=' Category ']/following::input)[1]").sendKeys(categoryName);
		return this;
	}
	
	public TagPage sendAction(String actionName) {
		driver.findElementByXPath("(//label[text()=' Action ']/following::input)[1]").sendKeys(actionName);
		return this;
	}
	
	public TagPage clickLable() throws InterruptedException {
		driver.findElementByXPath("(//label[text()=' Label ']/following::button)[1]").click();
		Thread.sleep(3000);
		return this;
	}
	
	public TagPage clickElement(String tagElement) throws InterruptedException {
		driver.findElementByXPath("//div[text()='"+tagElement+"']").click();
		Thread.sleep(3000);
		return this;
	}
	
	public TagPage clickValue() throws InterruptedException {
		driver.findElementByXPath("(//label[text()=' Value ']/following::button)[1]").click();
		Thread.sleep(3000);
		return this;
	}
	
	public TagPage selectGoogleAnalySetting() throws InterruptedException {
		Select agSetting = new Select(driver.findElementByXPath("//select[@name='tag.data.vendorTemplate.param.gaSettings']"));
		agSetting.selectByVisibleText("{{gaProperty}}");
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage clickConfigTrigger() throws InterruptedException {
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[2]").click();
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage clickOnAddAdditionalTrigger() throws InterruptedException {
		driver.findElementByXPath("//i[contains(@class,'gtm-add-icon')]").click();
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage clickNewTrigger() throws InterruptedException {
		driver.findElementByXPath("//i[@title='New trigger']").click();
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage sendTriggerName(String triggerName) throws InterruptedException {
		WebElement triggerTitle = driver.findElementByXPath("//div[@name='trigger.data.name']");
		triggerTitle.clear();
		triggerTitle.sendKeys(triggerName+"-Trigger");
		return this;
	}
	
	public TagPage clickTriggerConfig() throws InterruptedException {
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[4]").click();
		return this;
	}
	
	public TagPage clickJustLinks() throws InterruptedException {
		driver.findElementByXPath("//div[text()=' Choose trigger type ']/following::div[text()='Just Links']").click();
		Thread.sleep(3000);
		return this;
	}
	
	public TagPage clickSomeLinks() throws InterruptedException {
		driver.findElementByXPath("//md-radio-button[@id='radio_8']").click();
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage selectElement(String elementName) throws InterruptedException {
		Select selectVariable = new Select(driver.findElementByXPath("//select[@data-ng-model='ctrl.selectedVariable']"));
		selectVariable.selectByVisibleText(elementName);Thread.sleep(2000);
		return this;
	}
	
	public TagPage selectSelector() throws InterruptedException {
		Select selectOperator = new Select(driver.findElementByXPath("//select[@data-ng-model='predicate.operator']"));
		selectOperator.selectByVisibleText("matches CSS selector");
		return this;
	}
	
	public TagPage sendCSSselectorValue(String cssSelectorValue) throws InterruptedException {
		driver.findElementByXPath("//select[@data-ng-model='predicate.operator']/following::input").sendKeys(cssSelectorValue);
		Thread.sleep(2000);
		return this;
	}
	
	public TagPage clickTriggerSave() throws InterruptedException {
		driver.findElementByXPath("(//button[text()=' Save '])[2]").click();
		Thread.sleep(5000);
		return this;
	}
	
	public TagPage clickTagSave() throws InterruptedException {
		driver.findElementByXPath("(//button[text()=' Save '])[1]").click();
		Thread.sleep(2000);
		return this;
	}

	public boolean verifyTagCreation(String tagName) throws InterruptedException {
		tagStatus = false;
		List<WebElement> tagnameList = driver.findElementsByXPath("(//tr[@class='wd-tag-row'])//td[1]");
		HashSet<String> tagList = new HashSet<String>();
		for (WebElement tname : tagnameList) {
			tagList.add(tname.getText());
		}
		for (String a : tagList) {
			if(a.contains(tagName)) {
				System.out.println("Tag has been created successfully. Tag name is: "+tagName);
				tagStatus=true;
				Thread.sleep(3000);
			}
		}
		return tagStatus;
	}
	
	
	
}
