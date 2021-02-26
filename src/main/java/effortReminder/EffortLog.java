package effortReminder;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EffortLog {

	public static void main(String[] args) throws InterruptedException {
		
		
	  String namesInput = "Arunkumar N,karthika.n";
	  String[] namesInputList = namesInput.split(",");
	  
	  
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("https://projects.zoho.com/portal/ikomet#mytimesheet");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElementById("login_id").sendKeys("srene.ks@ikomet.com",Keys.ENTER)
	  ; driver.findElementById("password").sendKeys("Infy@8888",Keys.ENTER);
	  driver.findElementByXPath("//div[text()='Timesheets']").click();

	  HashMap<String, String> nameHour = new HashMap<String, String>();
	  
	  driver.findElementById("timesheet_filter").click(); Thread.sleep(2000);
	  driver.findElementByXPath("//label[text()='User']").click();
	  
	  List<WebElement> allNames = driver.findElementsByXPath("//div[contains(@id,'drpdwn_assignee')]//child::span[2]"); 
	  int numOfNames =  allNames.size(); 
	  System.out.println(numOfNames); 

	  
	  for (String names : namesInputList) {
		  for (int i = 1; i <= numOfNames; i++) { 
			  String userName = driver.findElementByXPath("//div[contains(@id,'drpdwn_assignee')]["+i+"]//child::span[2]").getText(); 
			  if (userName.equalsIgnoreCase(names)) {
				  System.out.println("This is srene: "+userName);
				  Thread.sleep(2000);
				  Actions act =  new Actions(driver);
				  act.moveToElement(driver.findElement(By.xpath("//div[contains(@id,'drpdwn_assignee')]["+i+"]//child::span[2]"))).click().perform();
				  //driver.findElementByXPath("//div[contains(@id,'drpdwn_assignee')]["+i+"]//child::span[2]").click(); 
			  } 
		  }
	  }
	  
	  driver.findElementById("filterFind").click();
	  
	  driver.findElementByXPath("//span[text()='Group By Date']").click();
	  driver.findElementByXPath("//div[text()='Group By User']").click();
	  
	 
	  List<WebElement> filteredNamesList = driver.findElementsByXPath("(//tbody[@class='table-group-header']//div[contains(@class,'tmsclientname ellipsis')])");
	  int FNLsize = filteredNamesList.size();
	  
	  for (int i = 1; i <= FNLsize; i++) {
		  String eachName = driver.findElementByXPath("(//tbody[@class='table-group-header']//div[contains(@class,'tmsclientname ellipsis')])["+i+"]").getText();
		  String eachHour = driver.findElementByXPath("(//tbody[@class='table-group-header']//div[contains(@class,'coltotalh')])["+i+"]").getText();
		  nameHour.put(eachName, eachHour);
	}
	  
	  System.out.println(nameHour);
	  
	  
		/*
		 * String a = "08:35"; a = a.substring(0, 2); a = a.replaceAll("[^0-9]", "");
		 * int actHour = Integer.parseInt(a); System.out.println("act hour" + actHour);
		 * if (actHour < 8) { sendReminder(); }
		 */
	}

	public static void sendReminder() {
		System.out.println("send reminder email");
	}

}
