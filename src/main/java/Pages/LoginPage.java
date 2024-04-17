package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.BaseClass;

public class LoginPage extends BaseClass{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(name = "email") private WebElement emailTextfieldElement;
	@FindBy(name = "password") private WebElement passwordTextfieldElement;
	@FindBy(xpath ="//button[text()='Login']") private WebElement submitbuttonElement;

	@FindBy(xpath ="(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]") private WebElement HomepageTextElement;
@FindBy(xpath = "//p[text()='Your email or password is incorrect!']") private WebElement aleartMessagElement;


	public WebElement LoginUserusing_ValidEmail(String Email, String Passwoard) {
		emailTextfieldElement.sendKeys(Email);
		passwordTextfieldElement.sendKeys(Passwoard);
		submitbuttonElement.click();
		return	HomepageTextElement;
	}

	public WebElement LoginUserusing_INvalidValidEmail(String email, String passwoard) {
		emailTextfieldElement.sendKeys(email);
		passwordTextfieldElement.sendKeys(passwoard);
		submitbuttonElement.click();
		return	aleartMessagElement;

	}


}
