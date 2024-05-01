Feature: Assign Student

  Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar and Admin is on Manage User Page

  @tag1
  Scenario: Validate Assign Student Popup window
    When Admin clicks Assign Student button UM1
    Then UM1 Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

  @tag2
  Scenario: Validate input fields and their text boxes in Assign Student form
    When Admin clicks Assign Student button UM1
    Then  UM1Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

  @tag3
  Scenario: Validate Dropdown in Assign Student Form
    When Admin clicks Assign Student button UM1
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name UM1

  @tag4
  Scenario: Validate radio button in Assign Student Form
    When Admin clicks Assign Student button UM1
    Then Admin should see two radio button for Status UM1

  @tag5
  Scenario: Empty Form Submission
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Save button with entering any data UM1
    Then Admin gets a Error message alert for Assign student UM1

  @tag6
  Scenario: Validate the Assign Student form page without giving Student Email id
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Save button without entering Student Email id UM1
    Then Admin gets a Error message alert as Student Email id is required UM1

  @tag7
  Scenario: Validate the Assign Student form page without selecting Program
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Save button without selecting program UM1
    Then Admin gets a Error message alert as Program is required UM1

  @tag8
  Scenario: Validate the Assign Student form page without selecting batch
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Save button without selecting batch UM1
    Then Admin gets a Error message alert as Batch is required UM1

  @tag9
  Scenario: Validate the Assign Student form page without giving Status
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Save button without giving status UM1
    Then Admin gets a Error message alert as Status is required UM1

  @tag10
  Scenario: Validate Cancel/Close(X) icon on Assign Student form
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Cancel or Close(X) Icon on Assign Student form UM1
    Then Assign Student popup window should be closed without saving UM1

  @tag11
  Scenario: Validate Save button on Assign Student form
    Given Admin is in Assign Student details pop up page UM1
    When Enter all the required fields with valid values and click Save button UM1
    Then Admin gets a message Successfully Student Assigned alert UM1

  @tag12
  Scenario: Validate Cancel button on Assign Student form
    Given Admin is in Assign Student details pop up page UM1
    When Admin clicks Cancel button UM1 Assign student
    Then Admin can see the Assign Student popup disappears without assigning UM1
