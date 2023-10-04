package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pageObjects.NaukariLoginTestPage;

public class LoginTestSteps {

	TestContext testContext;
	NaukariLoginTestPage testPage;
	ScenarioContext  scenarioContext;
		
	public LoginTestSteps(TestContext context) {
		testContext = context;
		testPage = testContext.getPageObjectManager().getTestPage();
		scenarioContext=new ScenarioContext();
		}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		System.out.println("*****user is on login page*******");	 
	    testPage.user_is_On_LoginPage();	 
	    
	    	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String userName, String userPassword) throws InterruptedException {
		System.out.println("*****user enters username and password *******");
		testPage.loginTo_Naukari_Application(userName, userPassword);  
		 
	}

	@And("^click on login button$")
	public void click_on_login_button() throws InterruptedException {
		System.out.println("*****click on login button*******");
		testPage.clickOn_LoginButton();		
		}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws IOException, InterruptedException {
		System.out.println("*****user is navigated to the home page**Jai Maharastra*****");
		testPage.verify_UserLogin();
		}
	
	@And("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		testPage.UserLogout();
	}

	@Then("User should logout")
	public void user_should_logout() throws InterruptedException {
		testPage.verify_UserLoggedout(); 
	}	
	
	
}
