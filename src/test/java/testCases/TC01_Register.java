package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage1;
import pageObjects.RegisterPage;
import testBase.BaseClass;



public class TC01_Register extends BaseClass{
	
	
@Test(groups= {"Regression", "Master"})
public void testRegister() throws InterruptedException {
	
	logger.info("Test starting....");
	
	try {
	
	HomePage1 hp=new HomePage1(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	logger.info("Registering.....");
	
	RegisterPage rp=new RegisterPage(driver);
	rp.setFirstName("abc");
	rp.setLastName("defqqq");
	rp.setEmail(randomString()+"@gmail.com");
	rp.setTelephone(randomNumber());
	
	String pwd =randomAlphaNumber();
	rp.setPassword(pwd);
	rp.setConfirmPassword(pwd);
	rp.clickSubscribe();
	rp.clickPrivacyPolicy();
	rp.clickContinue();
	String msg =rp.getConfirmationMsg();
	
	if(msg.equals("Your Account Has Been Created!")) {
		Assert.assertTrue(true);
	}
	
	else {
		
		logger.error("errorr.....");
		logger.debug("debugging...");
		Assert.assertTrue(false);
	}
	}
	
	catch(Exception e){
    Assert.fail();
}

}
}
