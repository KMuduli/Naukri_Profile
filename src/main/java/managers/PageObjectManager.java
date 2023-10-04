package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.NaukariProfilePage; 
import pageObjects.NaukariLoginTestPage;

public class PageObjectManager {
	private WebDriver driver;
	private NaukariProfilePage profilePage;
	private NaukariLoginTestPage testPage;

	public PageObjectManager(WebDriver driver) {
    	this.driver = driver;
    	}
//
	public NaukariProfilePage getProfilePage(){
		return (profilePage == null) ? profilePage = new NaukariProfilePage(driver) : profilePage;
	}
		
	public NaukariLoginTestPage getTestPage() {
		return (testPage == null) ? testPage = new NaukariLoginTestPage(driver) : testPage;
	}
}
