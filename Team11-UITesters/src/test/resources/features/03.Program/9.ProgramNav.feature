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

Feature: Navigation Validation from Manage Program to other Pages
  #Background: The user is logged in to LMS application
  #Scenario: user loggedin 
    #	Given user is on appUrl
     #	When The user enter valid credentials        
     #	And Click on Login button
     #	Then user is on Manage Program page
     	     
 @Nav_01   
  Scenario: User link on navigation bar
    Given user is Manage Program page
    When user clicks on User link on Manage Program page
    Then user is re-directed to User page
    
 @Nav_02   
  Scenario: Batch link on navigation bar
    Given user is Manage Program page
    When user clicks on Batch link on Manage Program page
    Then user is re-directed to Batch page
    
 #@Nav_03   
  #Scenario: Logout link on navigation bar
    #Given user is on Manage Program page
    #When user clicks on Logout link on Manage Program page
    #Then user is re-directed to Login page

