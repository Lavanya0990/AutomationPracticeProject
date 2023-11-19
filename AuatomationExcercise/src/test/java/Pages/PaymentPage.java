package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends MainPage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By name=By.cssSelector("input[name='name_on_card']");
	By cardNum=By.cssSelector("input[class='form-control card-number']");
	By cvv=By.cssSelector("input[class='form-control card-cvc']");
	By Expmonth=By.cssSelector("input[class='form-control card-expiry-month']");
	By ExpYear=By.cssSelector("input[class='form-control card-expiry-year']");
	By payOrderBtn=By.cssSelector("button[class='form-control btn btn-primary submit-button']");
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public void MakePayment(String nm,String cardnum,String cv,String mon,String year)
	{
		jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		driver.findElement(name).sendKeys(nm);
		driver.findElement(cardNum).sendKeys(cardnum);
		driver.findElement(cvv).sendKeys(cv);
		driver.findElement(Expmonth).sendKeys(mon);
		driver.findElement(ExpYear).sendKeys(year);
		driver.findElement(payOrderBtn).click();
		
	}
	

}
