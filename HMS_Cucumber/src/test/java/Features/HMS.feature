Feature: HMS_Application
Scenario: HMS_Login
	Given HMS home page is available
	When user enters username and password
	And user click on submit button
	Then validate login page