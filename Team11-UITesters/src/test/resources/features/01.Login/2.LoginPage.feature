@LoginPage
Feature: Login Page Verification

  Background: Admin gives a correct portal URL
    Given Admin is on Home Page
    When Admin clicks login button

  Scenario: Verify Login Page
    Then Admin land on Login Page

  Scenario: Verify Broken Link on login page
    Then HTTP response ">=400" then the login link is broken 

  Scenario: Varify Header of the Login Page
    Then Admin should see "Please login to LMS application" in the Header

  Scenario: Verify Text spelling of the Login Page
    Then Admin should see correct spelling in all the feilds

  Scenario: Verify text feild is present
    Then Admin should see two text feilds

  Scenario: Verify text on the first text feilds
    Then Admin should User in the first text feild

  Scenario: Verify asterik next to user text
    Then Admin should see "*" symbol next to user text

  Scenario: Verify text on the second text feilds
    Then Admin should Password in the second text feild

  Scenario: Verify asterik next to password text
    Then Admin should see "*" symbol next to password text

  Scenario: Verify the alignment input feild for the login
    Then Admin should see input feild on the centre of the page

  Scenario: Verify login is present
    Then Admin should see login button

  Scenario: verify alignment of the login button
    Then Admin should see login button on the centre of the page

  Scenario: Verify input discriptive test in user feild
    Then Admin should see user in grey color

  Scenario: Verify input discriptive test in password feild
    Then Admin should see password in grey color
