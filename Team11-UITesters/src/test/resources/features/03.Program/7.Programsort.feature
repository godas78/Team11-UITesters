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

Feature: Delete Program
  #Background: The user is logged in to LMS application
  #Scenario: user loggedin 
    #	Given user is on appUrl
     #	When The user enter valid credentials        
     #	And Click on Login button
     #	Then user is on Manage Program page
    
@Sort_01   
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given user is Manage Program page
    When user clicks the sort icon of program name column ascending
    Then The data get sorted on the table based on the program name column values in ascending order

@Sort_02   
  Scenario: Validates Sorting(data ordering) on the Program Data table
    When user clicks the sort icon of program name column descending
    Then The data get sorted on the table based on the program name column values in descending order
        
@Sort_03   
  Scenario: Validates Sorting(data ordering) on the Program Data table
    When user clicks the sort icon of programDesc column ascending
    Then The data get sorted on the table based on the program description column values in ascending order
    
 @Sort_04   
 Scenario: Validates Sorting(data ordering) on the Program Data table
    When user clicks the sort icon of programDesc column descending
    Then The data get sorted on the table based on the program description column values in descending order
    
 @Sort_05   
  Scenario: Validates Sorting(data ordering) on the Program Data table
    When user clicks the sort icon of program Status column ascending
    Then The data get sorted on the table based on the program status column values in ascending order
    
 @Sort_06   
  Scenario: Validates Sorting(data ordering) on the Program Data table
    When user clicks the sort icon of program status column descending
    Then The data get sorted on the table based on the program status column values in descending order
    
 