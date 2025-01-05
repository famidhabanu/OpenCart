package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount;
	
	//@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']']")
	//WebElement logout;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public boolean ismyAccountpageexist() {
		try {
		return (myaccount.isDisplayed());
		
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
