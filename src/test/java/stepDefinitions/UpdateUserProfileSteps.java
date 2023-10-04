package stepDefinitions;

import java.io.IOException;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.NaukariLoginTestPage;
import pageObjects.NaukariProfilePage;

public class UpdateUserProfileSteps {
	
	TestContext testContext;
	NaukariProfilePage profilePage;
	ScenarioContext  scenarioContext;
		
	public UpdateUserProfileSteps(TestContext context) {
		testContext = context;
		profilePage = testContext.getPageObjectManager().getProfilePage();
		scenarioContext=new ScenarioContext();
		}
	
	@Given("View_profile option is Displaying")
	public void view_profile_option_is_displaying() {
		profilePage.navigateTo_ProfilePage();
	}

	@When("user click on View_profile option")
	public void user_click_on_view_profile_option() {
		profilePage.open_BasicDetailsWindow();
		
	}

	@Then("user navigate to user profile page")
	public void user_navigate_to_user_profile_page() {
		profilePage.select_ExperienceInYears(" 8 Years ");
		
	}

	@When("user click edit basic details")
	public void user_click_edit_basic_details() {
	   profilePage.select_ExperienceInMonths(" 7 Months ");
	}

	@Then("edit Basic Details window displayed")
	public void edit_basic_details_window_displayed() {
		profilePage.select_ExperienceInMonths(" 8 Months ");
	}

	@When("edit Exprience years {string} and months {string} and current Salary {string} and Notice Period {string}")
	public void edit_exprience_years_and_months_and_current_salary_and_notice_period(String string, String string2, String string3, String string4) {
		profilePage.select_ExperienceInMonths(" 6 Months ");
	}

	@And("user click Save button")
	public void user_click_save_button() {
		profilePage.click_SaveBasicDetailsButton();
	}

	@Then("basic details updated and window closed.")
	public void basic_details_updated_and_window_closed() {
		profilePage.verify_UserProfileStatus();
	}
	
	@Given("User click on Update Resume button")
	public void user_click_on_update_resume_button() throws IOException, InterruptedException {
		profilePage.upload_UserResume();
	}
	
	@Then("User upload resume")
	public void user_updated() {
		profilePage.verify_UserProfileStatus();
	}


}
