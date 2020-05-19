Feature: Google_Search
Scenario: Searching in Google
	Given Google Home Page should be displayed
	When user enters search string
	Then search related pages should be displayed