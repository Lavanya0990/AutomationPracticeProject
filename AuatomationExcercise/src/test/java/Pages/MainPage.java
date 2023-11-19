package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
WebDriver driver;
//JavascriptExecutor jse = (JavascriptExecutor)driver;

By loginLink=By.xpath("//a[text()=' Signup / Login']");
By deleteAccount=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void login()
	{
		driver.findElement(loginLink).click();
	}
	
	public void deleteAccount()
	{
		driver.findElement(deleteAccount).click();
	}
}
