@UserDeletePage

Feature: Delete user
  

  Scenario: Validate row level delete icon
   Given Admin is on dashboard page after Login UM
    When Admin clicks User on the navigation bar UM
  
  
   Scenario: Validate delete icon
    Given Admin is on Manage User Page UM
    When Admin clicks the delete icon UM
    Then Admin should see a alert open with heading "Confirm" along with  "YES" and "NO" button for deletion UM
 
 Scenario: Validate accept alert
    Given Admin is on "Confirm" Deletion alert UM
    When Admin click yes option UM
    And Admin gets a message "Successful" and "User Deleted" alert message UM
  	Then Admin do not see that user in the data table UM

  
  Scenario: Validate reject alert
    Given Admin is on "Confirm" Deletion alert UM after clicking delete icon
    When Admin click No option UM
    Then Admin can see the deletion alert disappears without any changes UM

  
  Scenario: Validate Close(X) icon on Confirm Deletion alert
    Given Admin is on "Confirm" Deletion alert UM after clicking delete icon
    When Admin clicks on close button UM
    Then Admin can see the deletion alert disappears without any changes UM

  
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Given Admin is on Manage User Page UM
    When Admin clicks any checkbox in the data table UM
    Then Admin should see common delete option enabled under header Manage Program UM
  
 