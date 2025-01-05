package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage1;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC02_Login extends BaseClass {
  
	
	@Test(groups= {"Sanity", "Master"})
	public void testLogin() {
		
		try {
		
		logger.info("...TC02_Login Test starting...");
		HomePage1 hp=new HomePage1(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(prop.getProperty("Email"));
		lp.setPassword(prop.getProperty("pwd"));
		lp.clickLogin();
		
		MyAccount ma=new MyAccount(driver);
		Boolean targetpage =ma.ismyAccountpageexist();
		//Assert.assertEquals(true, targetpage,"login failed");
		Assert.assertTrue(targetpage);
		
		}
		catch (Exception e)
		{Assert.fail();
		logger.info("...TC02_Login Test completed...");	
	}
}
}