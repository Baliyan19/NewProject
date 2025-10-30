package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDriven extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"Sanity"})
	public void LoginTest(String email, String pass, String exp)
	{	
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmail(email);
		lp.EnterPassword(pass);
		lp.ClickloginButton();
		
		MyAccountPage mp=new MyAccountPage(driver);
		Boolean status= mp.isMyAccountPageExist();
		
		
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
