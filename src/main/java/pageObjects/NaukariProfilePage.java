package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NaukariProfilePage {
        WebDriver driver;
	
	public NaukariProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/mnjuser/profile']") 
	private WebElement link_ViewProfile;
	
	@FindBy(how = How.XPATH, using = "//span[@class='fullname']//following-sibling::em[1]") 
	private WebElement editBasicDetails_pencilIcon;
	
	@FindBy(how = How.XPATH, using = "//input[@id='exp-years-droopeFor']") 
	private WebElement search_exp_year_input;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ul_exp-years-droope']/child::ul[1]/child::li") 
	private List<WebElement> exp_Years;
	
	@FindBy(how = How.XPATH, using = "//input[@id='exp-months-droopeFor']") 
	private WebElement search_exp_months_input;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ul_exp-months-droope']/ul/child::li") 
	private List<WebElement> exp_Months;
	
	@FindBy(how = How.XPATH, using = "//button[@id='saveBasicDetailsBtn']") 
	private  WebElement  btn_Save;
	
	@FindBy(how = How.XPATH, using = "//div[@Class='action']") 
	private  WebElement  input_AttachResume;
	
	@FindBy(how = How.XPATH, using = "//span[@class='typ-14Medium mod-date-val']") 
	private  WebElement  status_ProfileUpdate;
	
	@FindBy(how = How.XPATH, using = "//p[@class='msg']") 
	private  WebElement  status_ResumeUpdate;
	
	
		
	String actualProfileUpdateStatus="";
	public void select_ExperienceInYears(String expr) {
		search_exp_year_input.click();
		System.out.println("===========Search experience clicked===============");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		List<WebElement> exps=exp_Years;
		for(WebElement ele :exps)
		{
			if(ele.getText().trim().equalsIgnoreCase(expr))
			{
				//ele.click();			
				
			     executor.executeScript("arguments[0].click();", ele);
			}
		}
		
	}
	
	public void select_ExperienceInMonths(String months) {
		search_exp_months_input.click();
		System.out.println("===========Search experience clicked===============");
		List<WebElement> exps=exp_Months;
		for(WebElement ele :exps)
		{
			if(ele.getText().trim().equalsIgnoreCase(months.trim()))
			{	System.out.println("Click options month: "+ele.getText());
			    ele.click();
			     break;
			}
		}
		
	}
	
	public void navigateTo_ProfilePage() {
		link_ViewProfile.click();
	}
	
	public void open_BasicDetailsWindow() {
		editBasicDetails_pencilIcon.click();
	}
	
	public void click_SaveBasicDetailsButton() {
		btn_Save.click();
	}
	
	public void upload_UserResume() throws IOException, InterruptedException {
	Thread.sleep(8000);	
	input_AttachResume.click();
	Thread.sleep(2000);	
	String currentUsersHomeDir = System.getProperty("user.home");
	System.out.println(currentUsersHomeDir);
	Runtime.getRuntime().exec("C:\\Users\\Kalia Muduli\\eclipse-workspace\\NaukriProfileAutoTask\\configs\\Kmuduli.exe");
	Thread.sleep(5000);	
	}
	
	public void verify_UserProfileStatus() {
		actualProfileUpdateStatus=status_ProfileUpdate.getText().trim();
		String Expected="Today";
		if(actualProfileUpdateStatus.equals(Expected))
		{
			System.out.println("++++++++++Profile status verified successfully+++++++++++");
		}
		else {
			throw new RuntimeException("Profile update Failed");
		}
		
	}
	
	
	public void verify_UserResumeStatus() {
		actualProfileUpdateStatus=status_ResumeUpdate.getText().trim();
		String Expected="Resume has been successfully uploaded.";
		if(actualProfileUpdateStatus.equals(Expected))
		{
			System.out.println("++++++++++Resume updated Successfully+++++++++++");
		}
		else {
			throw new RuntimeException("Resume update Failed");
		}
		
	}
	
}
