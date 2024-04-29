@HomePage
Feature: Home Page Verification

  Background: 
    Given Admin Launch the Browser

  Scenario: Verify Admin is able to land on Home Page
    When Admin gives correct LMS portal URL
    Then Admin should land on the Home Page

  Scenario: Verify for broken Link
    When Admin gives correct LMS portal URL
    Then HTTP response ">=400" then the link is broken

  Scenario: Verify text spelling in the page
    When Admin gives correct LMS portal URL
    Then Admin should see correct spelling all the fields

  Scenario: Verify logo of the LMS
    When Admin gives correct LMS portal URL
    Then Admin should see correct logo of the LMS

  Scenario: Verify logo properly aligned
    When Admin gives correct LMS portal URL
    Then Admin should see logo is properly aligned

  Scenario: Verify login button is present
    When Admin gives correct LMS portal URL
    Then Admin should see login button

  Scenario: Verify login button is clickable
    When Admin gives correct LMS portal URL
    Then Admin should able to click login button

  Scenario: Verify Admin is able to land on Home Page
    When Admin gives invalid LMS portal URL
    Then Admin should receive "404 Page not found" error
