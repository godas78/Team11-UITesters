Feature: Manage Program Validation

  Background: Logged on the LMS portal as Admin
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar

  Scenario: Validate landing in Program page
    Then Admin should see URL with "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/"

  Scenario: Validate the heading
    Then Admin should see a heading with text "Manage Program" on the page

  Scenario: Validate the footer
    Then Admin should see the text as "Showing 1 to 5 of [0-9]+ entries" along with Pagination icon below the table.

  Scenario: Validate the footer
    Then Admin should see the footer as "In total there are z programs."   #z- Total number of records

  Scenario: Validating the default state of Delete button
    Then Admin should see a Delete button on the top left hand side as Disabled

  Scenario: Validate Add New Program
    Then Admin should see a "+A New Program" button on the program page above the data table

  Scenario: Validate that number of records (rows of data in the table) displayed
    Then Admin should see the number of records (rows of data in the table) displayed on the page are 5

  Scenario: Verify data table on the Program page
    Then Admin should see data table on the Manage Program Page with following column headers "Program Name Program Description Program Status Edit / Delete"

  Scenario: Verify Sort arrow icon on the data table
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  Scenario: Verify Check box on the data table
    Then Admin should see check box on the left side in all rows of the data table

  Scenario: Verify Edit and Delete buttons
    Then Admin should see the Edit and Delete buttons on each row of the data table

  Scenario: Verify Search bar on the Program page
    Then Admin should see Search bar with text as "Search..."
