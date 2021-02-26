package gtm;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GTMmain {

	public static void main(String[] args) throws InterruptedException {
		String TagName="testLegal1";
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://tagmanager.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("identifierId").sendKeys("projects.vw@gmail.com",Keys.ENTER);
		driver.findElementByName("password").sendKeys("Nhy65tgB@", Keys.ENTER);
		Thread.sleep(8000);	
	
		//project selection
		WebElement link = driver.findElementByXPath("//a[text()=' 2018 Recruiting Landing ']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", link);		
		
		Thread.sleep(2000); 
		WebElement tagLink = driver.findElementByXPath("//a[text()='Tags ']");
		executor.executeScript("arguments[0].click();", tagLink);
		Thread.sleep(5000);
		
		//find tag name already exists or not
		List<WebElement> tagnameList = driver.findElementsByXPath("(//tr[@class='wd-tag-row'])//td[1]");
		HashSet<String> tagList = new HashSet<String>();
		for (WebElement tname : tagnameList) {
			tagList.add(tname.getText());
		}
		for (String a : tagList) {
			if(a.contains(TagName)) {
				System.out.println("Already there is an existing tag with this name: "+TagName);
				Thread.sleep(3000);
				break;
			}
		}
		
		//new tag
		driver.findElementByXPath("//button[text()=' New ']").click();
		WebElement tagName = driver.findElementByXPath("//div[@name='tag.data.name']");
		tagName.clear();
		tagName.sendKeys("testLegal1");
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[1]").click();
		driver.findElementByXPath("//div[text()='Google Analytics: Universal Analytics']").click();
		
		//tag configuration
		Select trackType = new Select(driver.findElementByXPath("//select[@name='tag.data.vendorTemplate.param.trackType']"));
		trackType.selectByVisibleText("Event");
		driver.findElementByXPath("(//label[text()=' Category ']/following::input)[1]").sendKeys("CategoryTEST");
		driver.findElementByXPath("(//label[text()=' Action ']/following::input)[1]").sendKeys("ActionTEST");
		driver.findElementByXPath("(//label[text()=' Label ']/following::button)[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Click URL']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[text()=' Value ']/following::button)[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Click URL']").click();
		Select agSetting = new Select(driver.findElementByXPath("//select[@name='tag.data.vendorTemplate.param.gaSettings']"));
		agSetting.selectByVisibleText("{{gaProperty}}");
		Thread.sleep(2000);
		
		//triggering panel
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//i[@title='New trigger']").click();
		WebElement triggerTitle = driver.findElementByXPath("//div[@name='trigger.data.name']");
		triggerTitle.clear();
		triggerTitle.sendKeys("testLEGAL");
		driver.findElementByXPath("(//div[@class='gtm-veditor-section-overlay'])[4]").click();
		driver.findElementByXPath("//div[text()=' Choose trigger type ']/following::div[text()='Just Links']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//md-radio-button[@id='radio_8']").click();
		Thread.sleep(2000);
		Select selectVariable = new Select(driver.findElementByXPath("//select[@data-ng-model='ctrl.selectedVariable']"));
		selectVariable.selectByVisibleText("Click Element");
		
		Select selectOperator = new Select(driver.findElementByXPath("//select[@data-ng-model='predicate.operator']"));
		selectOperator.selectByVisibleText("matches CSS selector");
		
		driver.findElementByXPath("//select[@data-ng-model='predicate.operator']/following::input").sendKeys("body > div.siteWrap > div > footer > div > div > div.fCol > ul.fNav > li:nth-child(3) > a");
		
		driver.findElementByXPath("(//button[text()=' Save '])[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//button[text()=' Save '])[1]").click();
		Thread.sleep(5000);
		 		//driver.close();
	}

}
