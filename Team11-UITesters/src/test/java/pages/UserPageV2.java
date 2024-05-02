	package pages;
	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import managers.FileReaderManager;
	import utilities.Log;
	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	public class UserPageV2 {
		
	
		WebDriver driver;
		
		public UserPageV2(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		@FindBy(xpath="//p-sorticon[@field='userId']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")WebElement userIdArrow;
	
		@FindBy(xpath="//p-sorticon[@field='userId']")WebElement IdArrow;
		@FindBy(xpath="//table/thead/tr/th[2]/p-sorticon/i")WebElement sortIdArrow;
		@FindBy(xpath="//p-sorticon[@field='userFirstName']")WebElement nameArrow;
		@FindBy(xpath="//p-sorticon[@field='userLocation']")WebElement userLocationArrow;
		@FindBy(xpath="//p-sorticon[@field='userPhoneNumber']")WebElement userPhoneNumberArrow;
		@FindBy(id="user") WebElement userModuleBtn;
		@FindBy(xpath = "//div/table/thead/tr/th[2][@class='p-sortable-column']") WebElement uIDArrow;
		@FindBy(xpath = "//div/table/thead/tr/th[3][@class='p-sortable-column']") WebElement uNameArrow;
		@FindBy(xpath = "//div/table/thead/tr/th[4][@class='p-sortable-column']") WebElement uLocationArrow;
		@FindBy(xpath = "//div/table/thead/tr/th[5][@class='p-sortable-column']") WebElement uPhoneArrow;
		@FindBy(xpath = "//td[text()='programName']/sortIcon")WebElement ProgramName_SortIcon;
		@FindBy(xpath = "//div[@class='p-datatable-wrapper ng-star-inserted']//table[@role='grid']") private WebElement tablsrt;
		@FindBy(xpath = "//input[@id='filterGlobal']") WebElement searchbox;
		
		boolean status;
		
		public void GoToUserPage()
		{
			driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getUserPageUrl());
			Log.info("User navigated to Home Page");
		}
		public void clickUserModule() throws InterruptedException {
			Thread.sleep(2000);
			userModuleBtn.click();
		}
		
		//**********************Sort user***************************
		public void clearsearch() throws InterruptedException {
			searchbox.clear();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
		}
		
			public void clickSortArrow()
			{
				sortIdArrow.click();
			}
			public void clickSortuID()
			{
				uIDArrow.click();
			}
			public void clickSortUName()
			{
				uNameArrow.click();
			}
			public void clickSortLocation()
			{
				uLocationArrow.click();
			}
			public void clickSortPhoneNumber()
			{
				uPhoneArrow.click();
			}
			public void clickIdAscending()
			{
				List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));
				List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
				List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
				Assert.assertTrue(originallist.equals(sortedlist));
			}
			public void clickNameAscending()
			{
				List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[3]"));
				List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
				List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
				Assert.assertTrue(originallist.equals(sortedlist));
			}
			public void clickLocationAscending()
			{
				List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[4]"));
				List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
				List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
				Assert.assertTrue(originallist.equals(sortedlist));
			}
			public void clickPhoneAscending()
			{
				List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[5]"));
				List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
				List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
				Assert.assertTrue(originallist.equals(sortedlist));
			}
//		public void sortingMethod()
//		{
//				driver.findElement(By.xpath("//button[contains(text(),'Sort')]")).click();
//			List<WebElement> tdList = (List<WebElement>) tablsrt;
//			String strArry [] = new String[tdList.size()];
//			for(int i=0;i < tdList.size();i++)
//			{
//				strArry[i]=tdList.get(i).getText();
//			}
//			
//			//  Compare the values
//			 
//			boolean sortFunctionality = true;
//			outer: 
//				for(int i=0;i < strArry.length;i++)
//				{
//					for(int j=i+1;j < i;j++)
//					{
//						int result = strArry[j].compareTo(strArry[i]);
//						if(!(result > 0))
//						{
//							//Log.logInfo("Data in the Table is not SORTED");
//								System.out.println("Data in the Table is not SORTED::" +strArry[j]+":::"+ strArry[i]);
//							sortFunctionality=false;
//							break outer;
//						}
//						else
//						{
//							//Log.logInfo("Data in the Table is SORTED");
//							System.out.println("Data in the Table is SORTED::" +strArry[j]+":::"+ strArry[i]);
//						}
//					}
//				}
//	
//	
//			if(sortFunctionality)
//			{
//				//Log.logInfo("SORT Functionality is working");
//				System.out.println("SORT Functionality is working");
//			}
//			else
//			{
//				//Log.logInfo("SORT Functionality is not working");
//				System.out.println("SORT Functionality is not working");
//			}
//	
//		} 
//	
		public void clickUserIdArrow() throws InterruptedException
		{
			Thread.sleep(2000);
			//uIDArrow.click();
			IdArrow.click();
	
			Thread.sleep(2000);
			//uIDArrow.click();
			IdArrow.click();
		}
		
	//	public void clickUserNameArrow()
	//	{
	//		nameArrow.click();
	//	}
	//	public void clickUserLocationArrow()
	//	{
	//		userLocationArrow.click();
	//	}
	//	public void userPhoneNumberArrow()
	//	{
	//		userPhoneNumberArrow.click();
	//	}
		public void clickUserModuleBtn()
		{
			uIDArrow.click();
		}

		public String getcurrentUrl() {
			return driver.getCurrentUrl();
		}
		public String getUserPageUrl() {
		    String userPageUrl = FileReaderManager.getInstance().getConfigReader().getUserPageUrl();
		   
		    Log.info("User navigated to User Page");
		    return userPageUrl;
		}
		public String getdashboardPageUrl() {
		    String dashboardPageUrl = FileReaderManager.getInstance().getConfigReader().getdashboardPageUrl();
		   
		    Log.info("User navigated to Dashboard Page");
		    return dashboardPageUrl;
		}
		
		//													**********Delete User***************
		
		//@FindBy(xpath = "//button [contains(@class,'p-button-rounded p-button-danger p-button p-component p-button-icon-only')]") WebElement headerDeltbtn;
		@FindBy(xpath ="//span[text() = 'Confirm']") WebElement confirmText;
		@FindBy(xpath = "//span[contains(text(),'Yes')]") WebElement yesBtn;
		@FindBy(xpath = "//span[contains(text(),'No')]") WebElement noBtn;
	   // @FindBy(xpath = "//div[contains(@class,'p-dialog-content')]") WebElement deletePopUp;
		@FindBy(xpath = "//div[contains(@class,'p-dialog-header')]/span[contains(text(),Confirm)]")WebElement deletePopUp;
	    @FindBy(xpath="//span[text() = 'Are you sure you want to delete the user?']")WebElement alertMessage;
	    @FindBy(xpath="//*[text()='Successful']")WebElement successDeleteMes;
	    @FindBy(xpath="//*[text()='User Deleted']")WebElement userDeleteMess;
	    //@FindBy(xpath="//div[contains(@class,'ng-tns-c91-131']//div[text()='User Deleted'] ")WebElement userDeleteMess;
	    @FindBy(xpath="//p-confirmdialog//div[1]//button[1]")WebElement closeBttn;
	    @FindBy(xpath = "(//div[@role='checkbox'])") List<WebElement> checkBoxes;
	    @FindBy(xpath = "(//span[@class='p-button-icon pi pi-trash'])[1]") WebElement commonDeleteBttn;
	    @FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> deleteIconsdelpage;
	    @FindBy(xpath = "//div[contains(@class, 'p-d-flex p-ai-center p-jc-between ng-star-inserted')]") WebElement footerText;
	    //@FindBy( xpath=("//table/tbody/tr[1]/td[1]/p-tablecheckbox//div[2]"))WebElement firstCheckBox;
	   // @FindBy(xpath=("//tbody/tr[1]"))WebElement firstCheckBox;
	    @FindBy(xpath = "//p-table//tr[1]/td[1]/p-tablecheckbox") WebElement firstCheckBox;
	    //@FindBy(xpath ="//table/tbody/tr//button[contains(@icon, 'pi-trash')]")
	    @FindBy (id = "filterGlobal") WebElement searchButton;
	    @FindBy (xpath = "//span[@class = 'p-paginator-current ng-star-inserted']") WebElement footerPageforsearch;
	    @FindBy(xpath = "//tr[1]//td[2]") WebElement userIdToDelete;
	    @FindBy(xpath="//table/tbody/tr[1]/td[6]//button[2]")WebElement rightDelBtn ;
	   
	   	String footerMsg;
		String footerMsgforYes;
		String footerMsgNo;
		String userName;
				
		public void validaterowisDeleted() throws InterruptedException  {
			
			
	        searchButton.click();
			searchButton.sendKeys(userName);
			Thread.sleep(1000);
			String Actual = footerPageforsearch.getText().toString();
			Assert.assertEquals(Actual, "Showing 0 to 0 of 0 entries");
			driver.navigate().back();
			//userModuleBtn.click();
		}
	
		public void clickheaderdelbtn()  {
			userName = userIdToDelete.getText();
			 System.out.println("User Id to delete " +userName);
			 
			 //commonDeleteBttn.click();
			//yesBtn.click();
		}
	  //common delete option enabled 
	  public boolean commonDeleteBtn() {
		  return commonDeleteBttn.isEnabled();
	  }
		    public void clickAnyCheckBox() {
		       	try {
					if (!checkBoxes.isEmpty()) {
					    checkBoxes.get(2).click();
					} else {
					    System.out.println("No checkboxes found in the data table.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	    //Validate Success deleted messages.
	    public boolean isSuccessDeleteMessageDisplayed() {
	        return successDeleteMes.isDisplayed();
	    }
	    
	    public boolean isUserDeleteMessageDisplayed() {
	        return userDeleteMess.isDisplayed();
	    }
	    //To compare actual with expected
	    
	
	    public String getSuccessDeleteMessageText() throws InterruptedException {
	    	Thread.sleep(2000);
	        String textsuccess=successDeleteMes.getText();
	        return textsuccess;
	    }
	    
	    public String getUserDeleteMessageText() {
	        return userDeleteMess.getText();
	    }
	    public boolean isUserConfirmPopUpDisplayed() {
	    	if(deletePopUp.isDisplayed()) {
	    		System.out.println("User confirmation pop-up is displayed.");
	    		return true;
	    	}else 
	    	{
	    		System.out.println("User confirmation pop-up is not displayed.");
	    		return false;
	    	 
	    	    }
	    }
	    
	    
	    //Clicking delete button
	    public void ClickDelBtn() {
	    	commonDeleteBttn.click();
	    	
		}
	    public void ClickRightDelBtn() {
	    	
	    	rightDelBtn.click();
		}
	    
	  public WebElement deleletePopUpOptionYes() {
		return yesBtn;
			
	}
	public WebElement deleletePopUpOptionNo() {
		return noBtn;		
		}
		
		public String getConfirmText() {
		    String text = confirmText.getText();
		System.out.println("The confirmation text is: " + text);
		    return text;
		}
	
		public String getYesText() {
		    String text = yesBtn.getText();
		    System.out.println("The confirmation Yes text is: " + text);
		    return text;
		}
		public String getNoText() {
		    String text = noBtn.getText();
		    System.out.println("The confirmation No  text is: " + text);
		    return text;
		}
		public WebElement Deletealert() {
			
	        return deletePopUp;
		}
			
			
			public void ClickDeleteYesBtn() {
				footerMsgforYes=footerText.getAttribute("innerText");
				 System.out.println("this is before yes delete  " +footerMsgforYes);
				yesBtn.click();
			}
			public void ClickDeleleteoptionNo() throws InterruptedException {
	
			footerMsg=footerText.getAttribute("innerText");
			System.out.println("this is before delete  " +footerMsg);
				 Thread.sleep(2000);
					 noBtn.click();
				
				}
			public void userDeleteSucess() {
	
				String footermsgforyes1=footerText.getAttribute("innerText");
				System.out.println("this is after clicking yes to del  " +footermsgforyes1);
				int num1 = Integer.parseInt(footerMsgforYes.replaceAll("\\D", ""));
		        int num2 = Integer.parseInt(footermsgforyes1.replaceAll("\\D", ""));
	
		        Assert.assertEquals(num1, num2 + 1);
		    }
			public void userNotDelete() {
	
				String footermsgforNo=footerText.getAttribute("innerText");
				System.out.println("this is after clicking no to del  " +footermsgforNo);
				int num1 = Integer.parseInt(footerMsgforYes.replaceAll("\\D", ""));
		        int num2 = Integer.parseInt(footerMsgNo.replaceAll("\\D", ""));
	
		        Assert.assertEquals(num1, num2 + 1);
		    }
			
			
		public void clickCloseBtn() {
			closeBttn.click();
		}
	
		
	
	    //**********************Delete Multiple user************************
	
		//Select check boxes for row 1,3,4
	    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr[ position()=4 or position()=5]//td[1]//div[@role='checkbox']") List<WebElement> multipleCheckboxes;
	
	    public void deleteCheckBox() throws InterruptedException {
		userName = userIdToDelete.getText();
		 System.out.println("User Id to delete " +userName);
		
		Thread.sleep(2000);
		firstCheckBox.click();
		Thread.sleep(2000);
		commonDeleteBttn.click();
	}
	public void selectCheckboxesForRow134() {
	    // Iterate over the list of checkboxes for rows 1, 3, and 4
	    for (WebElement checkbox : multipleCheckboxes) {
	        checkbox.click(); // Select the checkbox
	    }
	}
	
	
	}		
