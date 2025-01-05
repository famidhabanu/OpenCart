package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*contructor
 * locators
 * actions
 */

public class HomePage1 extends BasePage  {
	
//calling driver from Basepage constructor
public HomePage1(WebDriver driver) {
	super(driver);
}

//locators
@FindBy(xpath="//i[@class='fa fa-user']")
WebElement myaccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement register;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement login;


//actions
public void clickMyAccount() {
	myaccount.click();
}

public void clickRegister() {
	register.click();
}

public void clickLogin() {
	login.click();
}
}
