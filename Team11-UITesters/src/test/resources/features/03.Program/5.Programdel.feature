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
     #Given user is on appUrl
     #When The user enter valid credentials        
     #And Click on Login button
     #Then user is on Manage Program page
    
 @Program_01   
  Scenario: Delete Feature
    When user clicks Delete button on the data table for any row
    Then user should see a alert open with  YES and NO button for deletion
    	
 @Program_02
  Scenario: Validate details for Confirm Deletion form
    When user clicks Delete button on the data table for any row
    Then Admin should see a message Are you sure you want to delete Program name?
    
 @Program_03
  Scenario: Click Yes on deletion window
    Given user is on Confirm Deletion alert
    When user clicks YES button on the alert
    Then user gets a message Successful Program Deleted and able to see that program deleted in the data table
    
 @Program_04
  Scenario: Click No on deletion window
    Given user is on Confirm Deletion alert
    When user clicks NO button on the alert
    Then user can see the deletion alert disappears without deleting
    
 @Program_05
  Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
    Given user is on Confirm Deletion alert
    When user clicks Cancel or Close Icon on Deletion alert
    Then user can see the deletion alert disappears without any changes
    
    
    
    
  
