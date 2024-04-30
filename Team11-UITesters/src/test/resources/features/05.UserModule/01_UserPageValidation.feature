Feature: User page validation

  Background: 
    Given Validate landing in User page and Admin is on dashboard page after Login

  @tag1
  Scenario: Validate landing in User page
    When Admin clicks User from navigation bar for UM1
    Then Admin should see the Manage User in the URL

  @tag2
  Scenario: Validate the heading
    When Admin clicks User from navigation bar for UM1
    Then Admin should see a heading with text Manage user on the page

  @tag3
  Scenario: Validate the text and pagination icon below the data table
    When Admin clicks User from navigation bar for UM1
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table for usermodule.

  @tag4
  Scenario: Validate data table headers in the User Page
    When Admin clicks User from navigation bar for UM1
    Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete for UM

  @tag5
  Scenario: Validating the default state of Delete button
    When Admin clicks User from navigation bar for UM1
    Then Admin should see a Delete button on the top left hand side as Disabled for UserDEtailsPage

  @tag6
  Scenario: Validate "+ A New user" button in User Page
    When Admin clicks User from navigation bar for UM1
    Then Admin should be able to see the "+ A New User" button above the data table for add new user

  @tag7
  Scenario: Validate "+ Assign staff"  button in User page
    When Admin clicks User from navigation bar for UM1
    Then Admin should be able to see the "+ A New User" button above the data table for add new user

  @tag8
  Scenario: Validate "+ Assign Student"  button in User page
    When Admin clicks User from navigation bar for UM1
    Then Admin should be able to see the "+ A New User" button above the data table for add new user

  @tag9
  Scenario: Validate search box in User page
    When Admin clicks User from navigation bar for UM1
    Then Admin should be able to see the search text box above the data table for userdetailspage

  @tag10
  Scenario: "Validate number of data rows in the data table"
    When Admin clicks User from navigation bar for UM1
    Then Admin should see two  records displayed on the data table for userdetailspage

  @tag11
  Scenario: Verify Check box on the data table
    When Admin clicks User from navigation bar for UM1
    Then Each row in the data table should have a checkbox for userdetailspage

  @tag12
  Scenario: Verify edit icon on the data table
    When Admin clicks User from navigation bar for UM1
    Then Each row in the data table should have a edit icon that is enabled for userdetailspage

  @tag13
  Scenario: Verify  delete icon on the data table
    When Admin clicks User from navigation bar for UM1
    Then Each row in the data table should have a delete icon that is enabled for userdetailspage

  @tag14
  Scenario: search user by name
    Given Admin clicks User from navigation bar for UM1
    When Admin enters user name into search box for userdetailspage
    Then Admin should see user displayed with the entered name for userdetailspage

  @tag15
  Scenario: Validating the Search with unrelated keyword
    Given Admin clicks User from navigation bar for UM1
    When Admin enters the keywords not present in the data table on the Search box for userdetailspage
    Then Admin should see zero entries on the data table for userdetailspage
