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

  Scenario Outline: Validate invalid values on the text column
    When Admin enters only numbers or special char in "<name>" and "<desc>" column
    Then Admin gets a message alert "Alert"

    Examples: 
      | name | desc | Alert                                                                                                                               |  |
      | 123@ | 123$ | This field should start with an alphabet, no special char and min 2 char. ,This field should start with an alphabet and min 2 char. |  |


  
  Scenario: Validate Cancel/Close(X) icon on Program Details form
    When Admin clicks Cancel/Close(X) Icon on Program Details form
    Then Program Details popup window should be closed without saving

   Scenario Outline: Validate with success button 
    When Admin enters valid values "programName13" and "ProgramDescription13"
    Then Admin should see succes "message"
    
    Examples:
    |programName |ProgramDescription|message|
    |program     |sdet3             |success.S|
    
     
  Scenario: Validate Cancel button on Program Details form
    When Admin clicks <Cancel>button
    Then Admin can see the Program details popup disappears without creating any program
