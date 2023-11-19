package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends MainPage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By cartLink=By.xpath("//a[text()=' Cart']");
	By subscriptionInputField=By.id("susbscribe_email");
	By subscribeSubmitBtm=By.cssSelector("button#subscribe");
	By registerBtn=By.xpath("//u[text()='Register / Login']");
	By proceedToCheckout=By.xpath("//a[text()='Proceed To Checkout']");
	By addToCart=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	By orderMsgTextArea=By.cssSelector("textarea[class='form-control']");
	By placeOrderBtn=By.xpath("//a[text()='Place Order']");
	By orderTable=By.xpath("//*[@id=\"cart_info_table\"]/tbody/tr");	
	By downloadInvoiceBtn=By.xpath("//a[text()='Download Invoice']");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public void Subscription()
	{
		driver.findElement(cartLink).click();
		jse.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(subscriptionInputField)));
		driver.findElement(subscriptionInputField).sendKeys("lavadncs09@gmail.com");
		driver.findElement(subscribeSubmitBtm).click();
	}
	
	public void linkToCart()
	{
		driver.findElement(cartLink).click();
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(proceedToCheckout).click();
	}
	
	public void message(String m)
	{
		driver.findElement(orderMsgTextArea).sendKeys(m);
	}
	
	public void placeOrder()
	{
		driver.findElement(placeOrderBtn).click();
	}
	
	public void register()
	{
		driver.findElement(registerBtn).click();
	}
	
	public void removeProducts()
	{
		List<WebElement> orders=driver.findElements(orderTable);
		System.out.println("orders.size()"+orders.size() );
		
			WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		orders.get(1), By.xpath(".//td[6]/a")
				    )
				);
			subNode.click();
	}
	
	public void downloadInvoice()
	{
		driver.findElement(downloadInvoiceBtn).click();
	}

}
