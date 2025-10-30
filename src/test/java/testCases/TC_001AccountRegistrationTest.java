package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression"})
	public void TestRegistrationTest()
	{
		try {
			
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		
		hp.ClickRegiterLink();
		
		RegistrationPage rp=new RegistrationPage(driver);
		rp.EnterFirstName(StringDataGenerator());
		rp.EnterLasttName(StringDataGenerator());
		rp.EnterEmail(StringDataGenerator()+"@gmail.com");
		rp.EnterTelephone(NumberDataGenerator());
		String password= AlphaNumericRandom();
		
		rp.EnterPassword(password);
		rp.EnterConfirmPassword(password);
		rp.ClickPolicy();
		rp.Clickcontinue();
		
		Assert.assertEquals(rp.ConfirmationMessage(),"Your Account Has Been Created!");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
	}

}
