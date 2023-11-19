package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends MainPage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By homePageLink=By.xpath("//a[text()=' Home']");
	By subscriptionInputField=By.id("susbscribe_email");
	By subscribeSubmitBtn=By.cssSelector("button#subscribe");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	 Actions act = new Actions(driver);
	 WebElement draggablePartOfScrollbar;
	 By scrollUpIcon=By.xpath("//*[@id=\"scrollUp\"]/i");
	 
	public void Subscription()
	{
	driver.findElement(homePageLink).click();
	jse.executeScript("window.scrollBy(0,250)");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(subscriptionInputField)));
	driver.findElement(subscriptionInputField).sendKeys("lavancs09@gmail.com");
	driver.findElement(subscribeSubmitBtn).click();
	}
	
	public void scrollDown()
	{
		driver.findElement(homePageLink).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(subscribeSubmitBtn));
	}
	
	public void scrollUp()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(subscribeSubmitBtn)));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(homePageLink));
	}
	
	public void pageDown()
	{
		try
		{
		 driver.findElement(homePageLink).click();
         act.sendKeys(Keys.END).build().perform(); 
         System.out.println("Scroll down perfomed");
         Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void pageUp()
	{
			driver.findElement(scrollUpIcon).click();      
            System.out.println("Scroll up perfomed");
     
	}
	

	
	
	
}
