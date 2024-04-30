Feature: Add New Program

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button

  Scenario: Validate Program Details Popup window
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  Scenario: Validate input fields and their text boxes in Program details form
    Then Admin should see two input fields and their respective text boxes in the program details window

  Scenario: Validate radio button for Program Status
    Then Admin should see two radio button for Program Status
