package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends MainPage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By loginLink=By.xpath("//a[text()=' Signup / Login']");
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	By contactUslink=By.xpath("//a[text()=' Contact us']");
	By nameInputField=By.cssSelector("input[data-qa='name']");
	By emailField=By.cssSelector("input[data-qa='email']");
	By subjectField=By.cssSelector("input[data-qa='subject']");
	By msgTextarea=By.cssSelector("textarea[data-qa='message']");
	By uploadFile=By.cssSelector("input[name='upload_file']");
	By submitBtn=By.cssSelector("input.btn");
	By homeLink=By.xpath("//a[text()=' Home']");
	
	public void ContactUs()
	{
	
		driver.findElement(contactUslink).click();
		driver.findElement(nameInputField).sendKeys("Lavanya");
		driver.findElement(emailField).sendKeys("lavanya.shanmugam09@gmail.com");
		driver.findElement(subjectField).sendKeys("test");
		driver.findElement(msgTextarea).sendKeys("test");
		driver.findElement(uploadFile).sendKeys("C:\\Users\\chand\\OneDrive\\Desktop\\img.jpg");
		driver.findElement(submitBtn).click();
		Alert a = driver.switchTo().alert(); 
		a.accept(); 	
		jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");		
		driver.findElement(homeLink).click();

		
	}
}


