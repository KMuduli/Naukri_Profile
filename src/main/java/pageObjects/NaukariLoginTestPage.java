package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Verify;

import dev.failsafe.internal.util.Assert;
import selenium.Wait;

public class NaukariLoginTestPage {
	  WebDriver driver;
	public NaukariLoginTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='login_Layer']") 
	private WebElement opt_Login;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your active Email ID / Username']") 
	private WebElement txt_UserName;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your password']") 
	private WebElement txt_UserPassword;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Login']") 
	private WebElement btn_Login;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/mnjuser/profile']") 
	private WebElement link_ViewProfile;

	@FindBy(how = How.XPATH, using = "//div[@class='nI-gNb-drawer__icon']") 
	private WebElement bar_Logout;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Logout']") 
	private WebElement link_Logout;
	
	
	public void user_is_On_LoginPage() throws InterruptedException {
		Thread.sleep(3000);
		Assert.isTrue(opt_Login.isDisplayed(),"User failed to login Naukari Application", "Test");
	}
	public void loginTo_Naukari_Application(String username,String password) throws InterruptedException {
		Thread.sleep(3000);
		opt_Login.click();
		Thread.sleep(3000);
		txt_UserName.sendKeys(username);
		Thread.sleep(3000);
		txt_UserPassword.sendKeys(password);	
		Thread.sleep(3000);
	}
	
	public void clickOn_LoginButton() throws InterruptedException {
		btn_Login.click();	
		}
	
	public void verify_UserLogin() throws InterruptedException {
		Thread.sleep(3000);
		Assert.isTrue(link_ViewProfile.isDisplayed(), "User failed to login OrangeHRM Application", "Test");
	}
   
	public void UserLogout() throws InterruptedException {
		Thread.sleep(3000);
		bar_Logout.click();
		link_Logout.click();
		
	}
	public void verify_UserLoggedout() throws InterruptedException {
		Thread.sleep(3000);
		Assert.isTrue(opt_Login.isDisplayed(), "User logged out Application", "Test");
	}
}
