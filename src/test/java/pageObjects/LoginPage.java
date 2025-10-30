package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}

	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	

	

	
	//ActionMethods
	
	public void EnterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void EnterPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	public void ClickloginButton()
	{
		LoginButton.click();
	}
	
	
	
}
