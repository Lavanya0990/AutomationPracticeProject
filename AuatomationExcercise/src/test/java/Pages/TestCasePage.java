package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends MainPage{

	public TestCasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By textcaseLink=By.xpath("//a[text()=' Test Cases']");
	
	public void TestCases()
	{

		driver.findElement(textcaseLink).click();

	}

}
