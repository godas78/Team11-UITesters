package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager<ProgramDelPage> {

	private static final String ProgramdelPage = null;
	private WebDriver driver;
	private HomePage homePage;
	private Userpagevalidation userpagevalidation;
	private AddNewUser adduser;

	//private LoginPage loginPage;
	private ProgramdelPage programdelpage;
	private ProgramMdelPage programMdelPage;
	private ProgramNavPage programnavPage;
	//private ProgramsortPage programsortpage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public Userpagevalidation getUserpagevalidation() {

		return (userpagevalidation == null) ? userpagevalidation = new Userpagevalidation(driver) : userpagevalidation;
	}

	public ProgramdelPage getprogramdelPage() {
		return (programdelpage == null) ? programdelpage = new ProgramdelPage(driver) : programdelpage;
	}

	public AddNewUser getAddUser() {
		return (adduser == null) ? adduser = new AddNewUser(driver) : adduser;
	}

	public ProgramMdelPage getProgramMDelPage() {
		return (programMdelPage == null) ? programMdelPage = new ProgramMdelPage(driver) : programMdelPage;
	}

	public ProgramNavPage getProgramNavPage() {
		return (programnavPage == null) ? programnavPage = new ProgramNavPage(driver) : programnavPage;
	}

/*	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public ProgramsortPage getProgramsortPage() {
		return (programsortpage == null) ? programsortpage = new ProgramsortPage(driver) : programsortpage;
	}*/

}
