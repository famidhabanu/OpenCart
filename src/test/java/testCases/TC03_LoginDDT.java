package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage1;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC03_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)// getting dataprovider from a diff class
	public void testDDTLogin(String email, String password, String expectedresult) {
		
		
		try {
		
		logger.info("...TC03DDT_Login Test starting...");
		HomePage1 hp=new HomePage1(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccount ma=new MyAccount(driver);
		Boolean targetpage =ma.ismyAccountpageexist();
		
		/*Data is valid  - login success - test pass  - logout
		                 -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		                  -- login failed - test pass
		*/
		
		if(expectedresult.equalsIgnoreCase("Valid")) { //Data is valid
			if(targetpage==true) { //login success
				ma.clickLogout();
				Assert.assertTrue(true); //test pass
			}
			else {
				Assert.assertTrue(false); //test fail
			}
		}
		
		if(expectedresult.equalsIgnoreCase("Invalid")) { //Data is invalid
			if(targetpage==true) { //login success
				ma.clickLogout();
				Assert.assertTrue(false); //test fail
			}
			else {
				Assert.assertTrue(true); //test pass
			}
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("...TC03DDT_Login Test completed...");
	}
	
}
