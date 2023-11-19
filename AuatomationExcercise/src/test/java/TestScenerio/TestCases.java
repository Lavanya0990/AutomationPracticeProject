package TestScenerio;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.ProductPage;
import Pages.TestCasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
WebDriver driver;
LoginPage loginPage;
ContactUsPage contactusPage;
TestCasePage testCasePage;
ProductPage productPage;
HomePage homePage;
CartPage cartPage;
PaymentPage paymentPage;


@BeforeTest
public void beforeTest()
{
	System.out.println("beforeTest");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://automationexercise.com/");
    
	loginPage=new LoginPage(driver);
	contactusPage=new ContactUsPage(driver);
	testCasePage=new TestCasePage(driver);
	productPage=new ProductPage(driver);
	homePage=new HomePage(driver);
	cartPage=new CartPage(driver);
	paymentPage=new PaymentPage(driver);
	
	
}



@Test
public void Login_TC1()
{
	System.out.println("Login_TC1");
	loginPage.login();
	loginPage.RegisterUser();
	loginPage.deleteAccount();
}


@Test
public void Login_TC2()
{
	System.out.println("Login_TC2");
	loginPage.login();
	loginPage.LoginSuccess();
	loginPage.deleteAccount();
}


@Test
public void Login_TC3()
{
	System.out.println("Login_TC3");
	loginPage.login();
	loginPage.LoginFailure();
}

@Test
public void Login_TC4()
{
	System.out.println("Login_TC4");
	loginPage.login();
	loginPage.Logout();
}

@Test
public void Login_TC5()
{
	System.out.println("Login_TC5");
	loginPage.login();
	loginPage.RegisterUserExistingEmail();
}


@Test
public void ContactUs_TC6()
{
	System.out.println("ContactUs_TC6");
	contactusPage.ContactUs();
}

@Test
public void TestCase_TC7()
{
	System.out.println("TestCase_TC7");
	testCasePage.TestCases();
}


@Test
public void Product_TC8()
{
	System.out.println("Product_TC8");
	productPage.ProductDetail();
}

@Test
public void Product_TC9()
{
	System.out.println("Product_TC9");
	productPage.ProductSearch();
}

@Test
public void Home_TC10()
{
	System.out.println("Home_TC10");
	homePage.Subscription();
}


@Test
public void Cart_TC11()
{
	System.out.println("Cart_TC11");
	cartPage.Subscription();
}


@Test
public void Product_TC12()
{
	System.out.println("Product_TC12");
	productPage.AddToCart();
}

@Test
public void Product_TC13()
{
	System.out.println("Product_TC13");
	productPage.viewProductQuantity();
}

@Test
public void Product_TC14()
{
	System.out.println("Product_TC14");
	productPage.AddToCart();
	cartPage.proceedToCheckout();
	cartPage.register();
	loginPage.login();
	loginPage.RegisterUser();
	cartPage.linkToCart();
	cartPage.proceedToCheckout();
	cartPage.message("send quick");
	cartPage.placeOrder();
	paymentPage.MakePayment("lavanya", "123654789654", "122", "08", "2030");
	loginPage.deleteAccount();
}

@Test
public void Product_TC15()
{
	System.out.println("Product_TC15");
	loginPage.login();
	loginPage.RegisterUser();
	productPage.AddToCart();
	cartPage.linkToCart();
	cartPage.proceedToCheckout();
	cartPage.message("send quick");
	cartPage.placeOrder();
	paymentPage.MakePayment("lavanya", "123654789654", "122", "08", "2030");
	loginPage.deleteAccount();
}


@Test
public void Product_TC16()
{
	System.out.println("Product_TC16");
	loginPage.login();
	loginPage.LoginSuccess();
	productPage.AddToCart();
	cartPage.linkToCart();
	cartPage.proceedToCheckout();
	cartPage.message("send quick");
	cartPage.placeOrder();
	paymentPage.MakePayment("lavanya", "123654789654", "122", "08", "2030");
	loginPage.deleteAccount();
}


@Test
public void Product_TC17()
{
	System.out.println("Product_TC17");
	loginPage.login();
	productPage.AddToCart();
	cartPage.linkToCart();
	cartPage.removeProducts();
}


@Test
public void Product_TC18()
{
	System.out.println("Product_TC18");
	productPage.chooseCategory("women");
	productPage.chooseCategory("men");
}

@Test
public void Product_TC19()
{
	System.out.println("Product_TC19");
	productPage.chooseBrand();

}

@Test
public void Product_TC20()
{
	System.out.println("Product_TC20");
	productPage.ProductSearch();
	productPage.AddToCart();
	cartPage.linkToCart();
	loginPage.login();
	loginPage.LoginSuccess();
	cartPage.linkToCart();
}

@Test
public void Product_TC21()
{
	System.out.println("Product_TC21");
	productPage.ProductDetail();
	productPage.submitReview();
}

@Test
public void Product_TC22()
{
	System.out.println("Product_TC22");
	productPage.AddRecommendedProductToCart();
}

@Test
public void Product_TC23()
{
	System.out.println("Product_TC23");
	loginPage.login();
	loginPage.RegisterUser();
	productPage.AddToCart();
	cartPage.linkToCart();
	cartPage.proceedToCheckout();
	loginPage.deleteAccount();
	
}

@Test
public void Product_TC24()
{
	System.out.println("Product_TC24");
	productPage.AddToCart();
	cartPage.proceedToCheckout();
	cartPage.register();
	loginPage.login();
	loginPage.RegisterUser();
	cartPage.linkToCart();
	cartPage.proceedToCheckout();
	cartPage.message("send quick");
	cartPage.placeOrder();
	paymentPage.MakePayment("lavanya", "123654789654", "122", "08", "2030");
	cartPage.downloadInvoice();
	
}

@Test
public void Product_TC25()
{
	try
{
	System.out.println("Product_TC25");
	homePage.pageDown();
	homePage.pageUp();
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
}

@Test
public void Product_TC26()
{
	try
{
	System.out.println("Product_TC26");
	homePage.scrollDown();
	homePage.scrollUp();
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}

}




//@AfterTest
//public void afterTest()
//{
//	System.out.println("afterTest");
//	driver.close();
//}
}
