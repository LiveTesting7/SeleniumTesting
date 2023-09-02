@FeatureOne
Feature: To validate Mythra login functionality

@regression @sanity
Scenario: To validate positive combination of Mynthra login functionality
Given  To open browser and maximize window
When  To launch the url 
And  To enter registered PhoneNumber in PhoneNumber field 
|Number1|987654321|
|Number2|3457895678|
And  To enter password in Password field 
|Password1|Password2|Password3|
|12345|1234567|12345678|
|ABCD|ABCDE|ABCDEF|
And  To click login button
Then  To close the browser

@smoke
Scenario: To validate negative combination of Mynthra login functionality
Given User has To open browser and maximize window
When User has To launch the url 
And User has To enter registered PhoneNumber in PhoneNumber field 
|1234|ABCD|1234|
And User has To enter password in Password field 
|12345|1234567|12345678|
|ABCD|ABCDE|ABCDEF|
And User has To click login button
Then User has To close the browser