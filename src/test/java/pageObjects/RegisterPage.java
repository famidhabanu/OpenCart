package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement textFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement textLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement textTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement textPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement textPasswordConfirm;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement subscribe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkedpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//actions
	
	public void setFirstName(String fname) {
		textFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		textLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		textEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		textTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		textPasswordConfirm.sendKeys(pwd);
	}
	
	public void clickSubscribe() {
		subscribe.click();
	}


   public void clickPrivacyPolicy() {
	checkedpolicy.click();
   }

   public void clickContinue() {
	btnContinue.click();
    }
   
   
   public String getConfirmationMsg() {
	   
	   try {
	   return(msgConfirmation.getText());}
   
	   catch (Exception e){
		   return (e.getMessage());} //check
	   

		}
}

