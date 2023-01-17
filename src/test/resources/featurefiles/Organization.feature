
Feature: Organization
  
  Scenario: Create Organization
    Given Launch browser and enter Vtiger CRM url
    And Login to Vtiger CRM application
    When User clicks on Organization tab
    And Clicks on Plus button
    And Enters name and industry and clicks on save button
    Then New Organization Info page is displayed
 		When User click on organizations link
 		Then New organization appears on the list
 		And User logs out of the application and closes the browser

 