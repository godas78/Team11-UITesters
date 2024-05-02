#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Multiple Delete Program
  #Background: The user is logged in to LMS application
  #Scenario: user loggedin 
    #	Given user is on appUrl
     #	When The user enter valid credentials        
     #	And Click on Login button
     #	Then user is on Manage Program page
    
 @Program_06   
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Given user is Manage Program page
    When user clicks any checkbox in the data table
    Then user should see common delete option enabled under header Manage Program
    
 @Program_07   
  Scenario: Validate multiple program deletion yes by selecting Single checkbox
    Given user is on Confirm Deletion alert yes with single sel
    When user clicks YES button on the alert check
    Then user gets a message Successful Program Deleted and able to see that program deleted
    
  @Program_08   
  Scenario: Validate multiple program deletion no by selecting Single checkbox
    Given user is on Confirm Deletion alert no with single sel
    When user clicks NO button on the alert check
    Then user can see the deletion alert disappears without deleting the program
   
   @Program_09   
 Scenario: Validate multiple program deletion by selecting multiple check boxes
    Given user is on Confirm Deletion alert yes with multiple sel
    When Admin clicks YES button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
   
   @Program_10   
  Scenario: Validate multiple program deletion by selecting Single checkbox
    Given Admin is on Confirm Deletion alert no with multiple sel
    When Admin clicks NO button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
    
    
    