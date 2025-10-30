package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
	{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccountLink;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
		
	
	//ActionMethods
	
	public void ClickMyAccount()
	{
		Actions act=new Actions(driver);
				act.moveToElement(MyAccountLink).click().perform();
	}
	
	public void ClickRegiterLink()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Register);
	}
	
	public void ClickLogin()
	{
		Login.click();
	}
	}
