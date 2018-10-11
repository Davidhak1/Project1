Feature: Login into Application

Scenario Outline: Positive test validating login

Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link in home page to land on Secure sign in page
When User enters <username> and <password> and logs in 
Then Verify that user is successfully logged in
And close browsers

Examples:
|username	|password	|
|davodavidhakobyan@gmail.com |	hayastan98|
|davodavidhakobyan@gmail.com |	hayastan98!|
|davodavidhakobyan@gmail.com |	Hayastan98|



