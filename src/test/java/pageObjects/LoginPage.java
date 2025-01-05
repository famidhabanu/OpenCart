package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//webelements
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement textPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	
	
	/*@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmail;*/
	
	//actions
	
	public void setEmail(String email) {
		textEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login.click();
	}

}
