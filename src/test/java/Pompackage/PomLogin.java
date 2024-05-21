package Pompackage;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseHRMClass;

public class PomLogin extends BaseHRMClass{
	// Object repository
	@FindBy(name="username") WebElement Username;
	@FindBy(name="password") WebElement Password;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button") WebElement Login;

	
	//initiate page element
	
	public PomLogin() {
		

		PageFactory.initElements(driver, this);
		}
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Login.click();
	}
public String verify() {
	return driver.getTitle();
}



}
