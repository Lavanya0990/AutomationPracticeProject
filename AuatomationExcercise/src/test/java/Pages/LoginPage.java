package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends MainPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	Actions action;
	Select select;
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	By username=By.cssSelector("input[type='text']");
	By email=By.cssSelector("input[data-qa='signup-email']");
	By signup=By.cssSelector("button[data-qa='signup-button']");
	By gender=By.cssSelector("input[id='id_gender1']");
	By password=By.cssSelector("input[id='password']");
	By days=By.cssSelector("select[id='days']");
	By months=By.cssSelector("select[id='months']");
	By years=By.cssSelector("select[id='years']");
	By newsletter=By.cssSelector("input[id='newsletter']");
	By options=By.cssSelector("input[id='optin'");
	By firstname=By.cssSelector("input[id='first_name']");
	By lastname=By.cssSelector("input[id='last_name']");
	By company=By.cssSelector("input[id='company']");
	By adddress=By.cssSelector("input[id='address1']");
	By country=By.cssSelector("select[id='country']");
	By state=By.cssSelector("input[id='state']");
	By city=By.cssSelector("input[id='city']");
	By zipcode=By.cssSelector("input[id='zipcode']");
	By mobileno=By.cssSelector("input[id='mobile_number']");
	By createAccount=By.xpath("//button[text()='Create Account']");
	By continueBtn=By.xpath("//a[text()='Continue']");
	
	By loginEmail=By.cssSelector("input[data-qa='login-email']");
	By loginPassword=By.cssSelector("input[data-qa='login-password']");
	By loginBtn=By.cssSelector("button[data-qa='login-button']");
	
	public void RegisterUser()
	{
	
		driver.findElement(username).sendKeys("Lavan09");
		driver.findElement(email).sendKeys("lavan.sham09@gmail.com");
		driver.findElement(signup).click();
		action=new Actions(driver);
		action.moveToElement(driver.findElement(gender)).click().build().perform();
		driver.findElement(password).sendKeys("lavan123");
		select=new Select(driver.findElement(days));
		select.selectByVisibleText("10");
		select=new Select(driver.findElement(months));
		select.selectByVisibleText("September");
		select=new Select(driver.findElement(years));
		select.selectByVisibleText("1990");
		action.moveToElement(driver.findElement(newsletter)).click().build().perform();
		action.moveToElement(driver.findElement(options)).click().build().perform();
		driver.findElement(firstname).sendKeys("Lavanya");
		driver.findElement(lastname).sendKeys("Sivashanmugam");
	    driver.findElement(company).sendKeys("Imarticus");
		executor.executeScript("window.scrollBy(0,250)");
		driver.findElement(adddress).sendKeys("KAS Nagar");
		select=new Select(driver.findElement(country));
		select.selectByVisibleText("India");
		driver.findElement(state).sendKeys("Tamil Nadu");
		driver.findElement(city).sendKeys("Erode");
		driver.findElement(zipcode).sendKeys("638003");
		driver.findElement(mobileno).sendKeys("9003862633");
		executor.executeScript("window.scrollBy(0,250)");
		driver.findElement(createAccount).click();
		driver.findElement(continueBtn).click();
			
	}
	
	public void LoginSuccess()
	{
		
			driver.findElement(loginEmail).sendKeys("lavan.sham09@gmail.com");
			driver.findElement(loginPassword).sendKeys("lavan123");
			driver.findElement(loginBtn).click();
			
		
	}
	
	
	public void LoginFailure()
	{

			driver.findElement(loginEmail).sendKeys("lavanya.shanmugam09@gmail.com");
			driver.findElement(loginPassword).sendKeys("!qwert");
			driver.findElement(loginBtn).click();	
	}
	
	public void Logout()
	{
	
			driver.findElement(loginEmail).sendKeys("lavanya.shanmugam09@gmail.com");
			driver.findElement(loginPassword).sendKeys("!QAZ1qaz");
			driver.findElement(loginBtn).click();	
			driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
	}
	
	
	public void RegisterUserExistingEmail()
	{
	
		driver.findElement(username).sendKeys("Lavanya");
		driver.findElement(email).sendKeys("lavanya.shanmugam09@gmail.com");
		driver.findElement(signup).click();

		
	}

}
