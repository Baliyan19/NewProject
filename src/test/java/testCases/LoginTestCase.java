package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTestCase extends BaseClass{
	
	@Test(groups= {"Sanity"})
	public void LoginTest()
	{	
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmail(p.getProperty("email"));
		lp.EnterPassword(p.getProperty("password"));
		lp.ClickloginButton();
		
		MyAccountPage mp=new MyAccountPage(driver);
		Boolean status= mp.isMyAccountPageExist();
		String exp="My Account";
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (status==true)
			{
				
				mp.ClickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if (status==true)
				{
				mp.ClickLogout();
				Assert.assertTrue(false);
				}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}

}
