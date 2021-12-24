Feature: n11 Facebook login

@login
Scenario: n11 mark login
Given user launch browser and open the main page
When user logged in with facebook login auth
Then user logged in successfully
