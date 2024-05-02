@LoginPageCredentials
Feature: Login Page Verification

  Background: Admin is in login page after clicking login button in Home Page
    Given Admin is on login Page
#@Log1
  #Scenario Outline: Validate login with valid credentials
    #When Admin enter valid credentials from excel sheet "<Sheetname>" and <RowNumber>
    #Then Admin should land on dashboard page
    #Examples: 
      #| Sheetname | RowNumber |
      #| Login    |         0 |

  Scenario Outline: Validate login with invalid credentials
    When Admin enter invalid credentials from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username/password
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         1 |
    

  Scenario Outline: Validate login with valid credentials in username
    When Admin enter valid username from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check password
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         2 |

  Scenario Outline: Validate login with valid credentials in password
    When Admin enter valid  password from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username
    Examples: 
      | Sheetname | RowNumber |
      | Login   |         3 |

  Scenario Outline: Validate login with blank username credentials
    When Admin enter blank in username from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username or password
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         4 |

  Scenario Outline: Validate login with blank password credentials
    When Admin enter blank in password from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username also password
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         5 |

  Scenario: validate login with empty values in both field
    When Admin clicks Login button with empty values in both columns
    Then Error message please check username and password

  Scenario Outline: verify login button action through keyboard
    When Admin enter valid credentials and click through keyboard from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin should land dashboard page
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         0 |

  Scenario Outline: verify login button action through mouse
    When Admin enter valid credentials and click through mouse from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin land on dashboard page
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         0 |
 Scenario Outline: Validate login with valid credentials
    When Admin enter valid credentials from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin should land on dashboard page
    Examples: 
      | Sheetname | RowNumber |
      | Login    |         0 |