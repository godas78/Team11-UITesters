@SortUser

Feature: Sort user

Background: Logged on the LMS portal as admin 
Given Admin is on dashboard page after Login SU
When Admin clicks User from navigation bar SU

Scenario: Sort user by id
Given Admin is on Manage User Page SU
When Admin clicks on ID sort icon SU
Then Admin should see User details are sorted by id SU

Scenario: Sort user by name
Given Admin is on Manage User Page SU
When Admin clicks on name sort icon SU
Then Admin should see User details are sorted by name SU


Scenario: Sort user by Location
Given Admin is on Manage User Page SU
When Admin clicks on Location sort icon SU
Then Admin should see User details are sorted by Location SU

Scenario: Sort user by Phone number
Given Admin is on Manage User Page SU
When Admin clicks on Phone number sort icon SU
Then Admin should see User details are sorted by Phone number SU