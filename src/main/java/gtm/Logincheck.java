package gtm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Logincheck {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://news.google.com/topstories?tab=wn&hl=en-IN&gl=IN&ceid=IN:en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByLinkText("Sign in").click();
		
		driver.findElementById("identifierId").sendKeys("srenevasanks@gmail.com", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElementByName("password").sendKeys("Nhy65tgB@", Keys.ENTER);
		Thread.sleep(8000);	

	}

}
