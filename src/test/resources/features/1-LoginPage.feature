@regression
@login-page

Feature: SME CLIENT RS - LOGIN PAGE

@smoke
Scenario: Perform successfully login
Given go to the SME Client login page at the @URL
And click on the PASSWORD button for login with username and password
And type @username and @password and press Continue button
And type OTP for login & press the Login button or just press Login button (if bank doesnt use OTP for login)
Then Profile icon should be visible and contain Logout button
