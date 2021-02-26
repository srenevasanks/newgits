package gtm.testcases;

import java.io.IOException;
import java.util.HashSet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gtm.ProjectSpecificMethod;
import gtm.pages.LoginPage;

public class TC_001_GTM extends ProjectSpecificMethod{
	
	public static String tagCreationStatus;


	
	@Test(dataProvider = "fetchdata", priority = 1)
	public void createGTM(String additionalTrigger, String username, String password, String projectName, String tagName, String eventName, String categoryName, String actionName, String tagElement, String tagElement1, String triggerName, String elementName, String cssSelectorValue, String ABC) throws InterruptedException, IOException {
		
		
		if(additionalTrigger.equalsIgnoreCase("NO")) {
				newTagAndTrigger(username, password, projectName, tagName, eventName, categoryName, actionName, tagElement, tagElement1, triggerName, elementName, cssSelectorValue);
				String desc="";
				if(tagCreationStatus.equalsIgnoreCase("pass")) {
					desc = "Trigger("+triggerName+") has been added successfully to the Tag("+tagName+")";
				}else if (tagCreationStatus.equalsIgnoreCase("fail")) {
					desc = "Trigger("+triggerName+") and Tag("+tagName+") is not created.";
				}
				dec.add(desc);
				sts.add(tagCreationStatus);
		}
		else if(additionalTrigger.equalsIgnoreCase("YES")){
			additionalTrigger(username, password, projectName, tagName, eventName, categoryName, actionName, tagElement, tagElement1, triggerName, elementName, cssSelectorValue);				
			String desc="";
			System.out.println(tagCreationStatus);
			if(tagCreationStatus.equalsIgnoreCase("pass")) {
				desc = "Trigger("+triggerName+") has been added successfully to the Tag("+tagName+")";
			}else if (tagCreationStatus.equalsIgnoreCase("fail")) {
				desc = "Trigger("+triggerName+") and Tag("+tagName+") is not created.";
			}
			dec.add(desc);
			sts.add(tagCreationStatus);
		}
		else if(additionalTrigger.equalsIgnoreCase("JAVASCRIPT")){
			javaScriptFlow(username, password, projectName, tagName, eventName, categoryName, actionName, tagElement, tagElement1, triggerName, elementName, cssSelectorValue, ABC);				
			String desc="";
			System.out.println(tagCreationStatus);
			if(tagCreationStatus.equalsIgnoreCase("pass")) {
				desc = "Trigger("+triggerName+") has been added successfully to the Tag("+tagName+")";
			}else if (tagCreationStatus.equalsIgnoreCase("fail")) {
				desc = "Trigger("+triggerName+") and Tag("+tagName+") is not created.";
			}
			dec.add(desc);
			sts.add(tagCreationStatus);
		}
		

	}
	


	@Test(priority = 2)
	public void writeReport() throws IOException {
		new ProjectSpecificMethod().writeExcel(dec, sts);

	}
	
	public static void newTagAndTrigger(String username, String password, String projectName, String tagName, String eventName, String categoryName, String actionName, String tagElement, String tagElement1, String triggerName, String elementName, String cssSelectorValue) throws InterruptedException, IOException {
		new LoginPage().enterUserName(username)
		.enterPassword(password)
		.clickProjectName(projectName)
		.clickTriggerLink()
		.verifyDuplicateTriggerName(triggerName)
		.clickTagLink()
		.verifyDuplicateTagName(tagName)
		.clickTriggerLink()
		.verifyDuplicateTriggerName(triggerName)
		.clickTagLink()
		.clickNew()
		.sendTagName(tagName)
		.clickTagConfig()
		.clickGoogleAnalytics()
		.selectEvent(eventName)
		.sendCategory(categoryName)
		.sendAction(actionName)
		.clickLable()
		.clickElement(tagElement)
		.clickValue()
		.clickElement(tagElement1)
		.selectGoogleAnalySetting()
		.clickConfigTrigger()
		.clickNewTrigger()
		.sendTriggerName(triggerName)
		.clickTriggerConfig()
		.clickJustLinks()
		.clickSomeLinks()
		.selectElement(elementName)
		.selectSelector()
		.sendCSSselectorValue(cssSelectorValue)
		.clickTriggerSave()
		.clickTagSave()
		.verifyTagCreation(tagName);
		if(tagStatus=true) {
			tagCreationStatus = "pass";
		}else {
			tagCreationStatus="fail";
		}
	}
	
	
	public static void additionalTrigger(String username, String password, String projectName, String tagName, String eventName, String categoryName, String actionName, String tagElement, String tagElement1, String triggerName, String elementName, String cssSelectorValue) throws InterruptedException, IOException {
		new LoginPage().enterUserName(username)
		.enterPassword(password)
		.clickProjectName(projectName)
		.clickTriggerLink()
		.verifyDuplicateTriggerName(triggerName)
		.clickTagLink()
		.clickOnExistingTagName(tagName)
		.clickConfigTrigger()
		.clickOnAddAdditionalTrigger()	
		.clickNewTrigger()
		.sendTriggerName(triggerName)
		.clickTriggerConfig()
		.clickJustLinks()
		.clickSomeLinks()
		.selectElement(elementName)
		.selectSelector()
		.sendCSSselectorValue(cssSelectorValue)
		.clickTriggerSave()
		.clickTagSave()
		.verifyTagCreation(tagName);
		if(tagStatus=true) {
			tagCreationStatus = "pass";
		}else {
			tagCreationStatus="fail";
		}

		
	
	}
	
	
}
