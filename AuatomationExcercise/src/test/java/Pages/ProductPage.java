package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends MainPage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By productLink=By.xpath("//a[text()=' Products']");
	By products=By.cssSelector("div.col-sm-4");
	By divA=By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div");
	By continueBtn=By.xpath("//button[text()='Continue Shopping']");
	By vieCartBtn=By.xpath("//u[text()='View Cart']");
	By quantity=By.id("quantity");
	By category=By.xpath("//*[@id=\"accordian\"]/div");
	By brand=By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[2]/div/ul/li");
	By reviewerName=By.cssSelector("input[id='name']");
	By reviewerEmail=By.cssSelector("input[id='email']");
	By reviewMsg=By.cssSelector("textarea[id='review']");
	By reviewSubmitBtn=By.cssSelector("button[id='button-review']");
	By recommendedItems=By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div");
	
	CartPage cartPage=new CartPage(driver);
	LoginPage loginPage=new LoginPage(driver);
	Actions a = new Actions(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebElement searchBox;
	Actions action;
	
	
	public void ProductDetail()
	{
		
			try
			{	
			driver.findElement(productLink).click();
			jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
			driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
	
	public void ProductSearch()
	{
		try
		{
			driver.findElement(productLink).click();
			jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
			driver.findElement(By.xpath("//*[@id=\"search_product\"]")).click();			
			action = new Actions(driver);
			searchBox = driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
			keyboardActions(searchBox,"Blue");
		    driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
		    
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void AddToCart()
	{
		driver.findElement(productLink).click();
		jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		List<WebElement> Items=driver.findElements(divA);
		System.out.println("Items.size()"+Items.size() );
		jse.executeScript("window.scrollBy(0,25)");
		for(int i=1;i<=2;i++)
		{
			WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		Items.get(i), By.xpath(".//div[1]/div[1]/div[1]/a")
				    )
				);		
				subNode.click();
				if(i==1)
				driver.findElement(continueBtn).click();
				else
				driver.findElement(vieCartBtn).click();	
		}
		
		
	}
	
	public void viewProductQuantity()
	{
		driver.findElement(productLink).click();
		jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		List<WebElement> Items=driver.findElements(divA);
		System.out.println("Items.size()"+Items.size() );
		jse.executeScript("window.scrollBy(0,25)");
		
			WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		Items.get(1), By.xpath(".//div[1]/div[2]/ul/li/a")
				    )
				);
			subNode.click();
			driver.findElement(quantity).click();
			driver.findElement(quantity).clear();
			driver.findElement(quantity).sendKeys("4");
			driver.findElement(cartPage.addToCart).click();
			driver.findElement(vieCartBtn).click();
			
				
	}
	
	public void chooseCategory(String cory)
	{
		List<WebElement> Items=driver.findElements(category);
		System.out.println("Items.size()"+Items.size() );
		jse.executeScript("window.scrollBy(0,25)");
		
		if(cory=="women")
		{
			WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		Items.get(0), By.xpath(".//div/h4/a/span")
				    )
				);
			subNode.click();
			System.out.println("hj   "+Items.get(1));
			WebElement subcat = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		Items.get(0), By.xpath(".//div[2]/div/ul/li[1]/a")
				    )
				);
			subcat.click();
			
			
			
		}
		else
			if(cory=="men")
			{
				WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
					    ExpectedConditions.presenceOfNestedElementLocatedBy(
					    		Items.get(1), By.xpath(".//div/h4/a/span")
					    )
					);
				subNode.click();
				System.out.println("hj   "+Items.get(1));
				WebElement subcat = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
					    ExpectedConditions.presenceOfNestedElementLocatedBy(
					    		Items.get(1), By.xpath(".//div[2]/div/ul/li[1]/a")
					    )
					);
				subcat.click();
			}
	}
	
	public void chooseBrand()
	{
		List<WebElement> Items=driver.findElements(brand);
		System.out.println("Items.size()"+Items.size() );
		jse.executeScript("window.scrollBy(0,25)");

		WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
			    ExpectedConditions.presenceOfNestedElementLocatedBy(
			    		Items.get(1), By.xpath(".//a")
			    )
			);
		subNode.click();		
		
	}
	
	
	public void submitReview()
	{
		driver.findElement(reviewerName).sendKeys("Lavan");
		driver.findElement(reviewerEmail).sendKeys("lavan.sahn@gmail.com");
		driver.findElement(reviewMsg).sendKeys("Good");
		driver.findElement(reviewSubmitBtn).click();
	}
	
	public void AddRecommendedProductToCart()
	{
		driver.findElement(productLink).click();
		jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> Items=driver.findElements(recommendedItems);
		System.out.println("Items.size()"+Items.size() );

			WebElement subNode = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
				    ExpectedConditions.presenceOfNestedElementLocatedBy(
				    		Items.get(0), By.xpath(".//div/div/div/div/a")
				    )
				);		
				subNode.click();
				driver.findElement(vieCartBtn).click();	
	
	}

	

	public void keyboardActions(WebElement searchBox,String s)
	{
		try {
			action.moveToElement(searchBox).perform();
			action.click().perform();
			action.pause(3000);
			action.sendKeys(s).perform(); 
			Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

	
	
	

	

}
