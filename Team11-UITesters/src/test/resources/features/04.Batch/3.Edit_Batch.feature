Feature: Edit batch
#Background: Logged on the LMS portal
#Given Admin is on dashboard page after Login
#When Admin clicks "Batch" from navigation bar

@tag1
  Scenario: Validate row level edit icon
    Given The edit icon on row level in data table is enabled for batch
    When Admin clicks the edit icon for batch
    Then A new pop up with Batch details appears for batch

  @tag2
  Scenario Outline: Check if the fields are updated
   
    When Update the fields with valid values and click save from "<Sheetname>" and <RowNumber> for edit batch
    Then The updated batch details should appear on the data table for edit batch module

      Examples: 
      | Sheetname  | RowNumber | 
      | Batch  |     0     | 
      
  Scenario Outline: Check if the update throws error with invalid valued
    Given Admin clicks the edit icon for edit batch
    When Update the fields with invalid values and click save from "<Sheetname>" and <RowNumber> for edit batch
    Then Error message should appear for edit batch module

      Examples: 
      | Sheetname  | RowNumber | 
      | Batch  |     2     |    
      
   Scenario Outline: Check if you get error message when mandatory fields are erased
    Given Admin clicks the edit icon for edit batch
    When Erase data from mandatory field for edit batch
    Then Error message should appear for edit batch module


   Scenario Outline: Check if description field is optional in update
    Given Admin clicks the edit icon for edit batch
    When Erase data from description field for edit batch
    Then Error message should appear for edit batch module
      