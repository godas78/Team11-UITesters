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

Feature: Pagination
  #Background: The user is logged in to LMS application
  #Scenario: user loggedin 
    #	Given user is on appUrl
     #	When The user enter valid credentials        
     #	And Click on Login button
     #	Then user is on Manage Program page
    
@page_01   
  Scenario: Verify Next page link
    When user clicks Next page link on the program table
    Then user should see the Pagination has Next active link
    
 @page_02   
  Scenario: Verify Last page link
    When user clicks Last page link
    Then user should see the last page record on the table with Next page link are disabled 
    
 @page_03   
  Scenario: Admin is on last page of Program table
    When user clicks First page link
    Then user should see the first page record on the table with previous page link disabled

@page_04   
  Scenario: Verify Start page link 
    When user clicks Start page link
    Then user should see the first page record on the table with previous page link being disabled
  
    
    
    