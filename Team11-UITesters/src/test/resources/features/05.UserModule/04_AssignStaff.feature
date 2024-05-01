Feature: Assign Staff

  Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar and Admin is on Manage User Page

  @tag1
  Scenario: Validate Assign Staff Popup window
    When Admin clicks Assign Staff button UM1
    Then  UM1 Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

  @tag2
  Scenario: Validate Assign Staff Popup window
    When Admin clicks Assign Staff button UM1
    Then UM1Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.

  @tag3
  Scenario: Validate Assign Staff Popup window
    When Admin clicks Assign Staff button UM1
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name UM1 ASSIGN STAFF

  @tag4
  Scenario: Validate Assign Staff Popup window
    When Admin clicks Assign Staff button UM1
    Then Admin should see two radio button for Status UM1 aSSIGN STAFF

  @tag5
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button with entering any data UM1
    Then Admin gets a Error message alert UM1 aSSIGN STAFF

  @tag6
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button without entering Student Email id UM1 Assign STAFFE
    Then Admin gets a Error message alert as Student Email id is required UM1 AssignStaff

  @tag7
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button without entering Skill UM1
    Then Admin gets a Error message alert as Skill is required UM1 aSSIGN STAFF

  @tag8
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button without selecting program UM1
    Then Admin gets a Error message alert as Program is required UM1 Assign staff

  @tag9
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button without selecting batch UM1
    Then Admin gets a Error message alert as Batch is required UM1

  @tag10
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button without giving status UM1
    Then Admin gets a Error message alert as Status is required UM1

  @tag11
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Admin clicks Save button with entering any dataAdmin clicks Cancel or Close(X) Icon on Assign Staff  form UM1
    Then Assign Staff popup window should be closed without saving UM1

  @tag12
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page UM1
    When Enter all the required fields with valid values and click Save button UM1 ASsign staff
    Then Admin gets a message Successfully Staff Assigned alert UM1

  @tag13
  Scenario: Validate Assign Staff Popup window
    Given Admin is in Assign Staff details pop up page
    When Admin clicks Cancel button
    Then Admin can see the Assign Staff popup disappears without assigning
