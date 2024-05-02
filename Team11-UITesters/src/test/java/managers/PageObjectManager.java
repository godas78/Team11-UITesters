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
	private ProgramsortPage programsortpage;
	private ProgramPagiPage programpagiPage;
	//private ProgramsortPage programsortpage;
	private BatchPageValidation batchPageValidation;
	private AddandEditBatchPage addBatchPage;
	private DeleteBatchPage deleteBatchPage;
	private ProgramPage programPage;
	private DashBoardPage dashBoardPage;
	private UserPageV2 userPageV2;
	private LogoutPage logoutPage;

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

	public BatchPageValidation getBatchPageValidation()
	{
		return (batchPageValidation == null) ? batchPageValidation = new BatchPageValidation(driver) : batchPageValidation;
	}
	public AddandEditBatchPage getAddBatchPage()
	{
		return (addBatchPage == null) ? addBatchPage = new AddandEditBatchPage(driver) : addBatchPage;
	}

	public DeleteBatchPage getDeleteBatchPage()
	{
		return (deleteBatchPage == null) ? deleteBatchPage = new DeleteBatchPage(driver) : deleteBatchPage;
	}
		
	public ProgramsortPage getProgramsortPage()
	{
	
		return (programsortpage == null) ? programsortpage = new ProgramsortPage(driver) : programsortpage;
	}
	public ProgramPagiPage getProgramPagiPage()
	{
		return (programpagiPage == null) ? programpagiPage = new ProgramPagiPage(driver) : programpagiPage;
	}
	public ProgramPage getProgramPage()
	{
		return (programPage == null) ? programPage = new ProgramPage(driver) : programPage;
	}
	public DashBoardPage getDashBoardPage()
	{
		return (dashBoardPage == null) ? dashBoardPage = new DashBoardPage(driver) : dashBoardPage;
	}
	public UserPageV2 getUserPageV2()
	{
		return (userPageV2 == null) ? userPageV2 = new UserPageV2(driver) : userPageV2;
	}
	public LogoutPage getLogoutPage()
	{
		return (logoutPage == null) ? logoutPage = new LogoutPage(driver) : logoutPage;
	}
}
