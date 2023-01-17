#Feature is the list of scenarios of particular feature
Feature: Vtiger login
	
	#Scenario is a test scenario of feature 
  Scenario: Login with valid credentials test
 		#Given specifies pre condition of the test scenario
    Given Navigate to vtiger application
    #When specifies the condition of test scenario
    When User enters valid credentials
    #And acts like connecting word when two or more pre-conditions or conditions or validations are present
    And clicks on login button
    #Then specifies validation of the test scenario
    Then Vtiger home page should display
    

 