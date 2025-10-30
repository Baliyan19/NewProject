package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Telephone;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement ConfirmPassword;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement PolicyCheck;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ContinurButton;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmationMessage;
	
	//ActionMethods
	
	public void EnterFirstName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void EnterLasttName(String lname)
	{
		LastName.sendKeys(lname);
	}
	
	
	public void EnterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	
	public void EnterTelephone(String tele)
	{
		Telephone.sendKeys(tele);
	}
	
	
	public void EnterPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	
	public void EnterConfirmPassword(String pass)
	{
		ConfirmPassword.sendKeys(pass);
	}
	
	public void ClickPolicy()
	{
		PolicyCheck.click();
	}
	
	public void Clickcontinue()
	{
		ContinurButton.click();
	}
	
	public String ConfirmationMessage()
	{
		try
		{
		return(ConfirmationMessage.getText().toString());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
