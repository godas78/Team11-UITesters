@UserDeleteMultiplePage
Feature: Delete multiple user

  
  Scenario: Validate multiple user deletion by selecting Single checkbox
  Given Admin clicks delete button under header after selecting the check box in the data table DMU
  And 	Admin is on Confirm Deletion alert DMU
	When Admin clicks "YES" button on the alert DMU
 Then Admin should land on Manage User page and can see the selected user is deleted from the data table DMU
  
  Scenario: Validate multiple user deletion by selecting Single checkbox
    Given Admin clicks delete button under header after selecting the check box in the data table DMU
    And Admin is on Confirm Deletion alert DMU
    When Admin clicks "NO" button on the alert for delete multiple user DMU
    Then Admin should land on Manage User page and can see the selected user is not deleted from the data table DMU
  
  Scenario: Validate multiple user deletion by selecting multiple check boxes
  
  Given Admin clicks delete button under header after selecting multiple checkboxes in the data table DMU
  And Admin is on Confirm Deletion alert DMU
  When  Admin clicks "YES" button on the alert DMU
  Then Admin should land on Manage User page and can see the selected users are deleted from the data table DMU
  
  Scenario: Validate multiple user deletion by selecting multiple check boxes
    Given Admin clicks delete button under header after selecting multiple checkboxes in the data table DMU
    And Admin is on Confirm Deletion alert DMU
    When Admin clicks "NO" button on the alert for delete multiple user DMU
    Then Admin should land on Manage User page and can see the selected users are not deleted from the data tables DMU
    
 
