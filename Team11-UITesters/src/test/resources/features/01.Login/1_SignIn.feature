Feature: loginpage

Background: 
Given user is on appUrl

  Scenario: Navigate to appUrl
    
    When user gets title of the page
    Then appUrl Page Title should be "LMS"

  Scenario: Login to LMS website
    
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
