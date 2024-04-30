Feature: Add New Program

  Background: Admin is on Manage Program Page after clicks Program on the navigation bar
    Given Admin is on "Program Details" Popup window

  Scenario: Empty form submission
    When Admin clicks <Save>button without entering any data
    Then Admin gets a Error message alert

  Scenario: Enter only Program Name
    When Admin enters only<Program Name> in text box and clicks Save button
    Then Admin gets a message alert 'Description is required'

  Scenario: Enter only Program Description
    When Admin enters only<Program description> in text box and clicks Save button
    Then Admin gets a message alert 'Name is required'

  Scenario: Select Status only
    When Admin selects only Status and clicks Save button
    Then Admin gets a message alert 'Name and Description required'

  Scenario: Validate invalid values on the text column
    When Admin enters only numbers or special char in name and desc column
    Then Admin gets a Error message alert

  Scenario: Validate Cancel/Close(X) icon on Program Details form
    When Admin clicks Cancel/Close(X) Icon on Program Details form
    Then Program Details popup window should be closed without saving

  Scenario: Validate Save button on Program Details form
    When Enter all the required fields with valid values and click Save button
    Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table

  Scenario: Validate Cancel button on Program Details form
    When Admin clicks <Cancel>button
    Then Admin can see the Program details popup disappears without creating any program
