
@LoginForTutorialsNinja
Feature: Login Functionality
 
@ValidCredentials
Scenario: Verify Login With Valid Credentials
   Given User navigates to LoginPage
   And User enters validemail "nikhee851997@gmail.com" in the respective field
   And User enters validpassword "Restartnew@8" in the respective field
   And User clicks on the Login button
   Then User successfully Login into AccountPage
   
@InvalidCredentails 
Scenario: Verify Login With Invalid Credentails 
   Given User navigates to LoginPage
   And User enters invalidemail "nikhee581997@gmail.com" in the respective field
   And User enters invalidpassword "Restartnew@5" in the respective field
   And User clicks on the Login button 
   Then User receives a warning message "Warning: No match for E-Mail Address and/or Password." in the LoginPage
   
@validEmailInvalidPassword
Scenario: Verify Login with ValidEmail InvalidPassword
    Given User navigates to LoginPage
    And User enters validemail " nikhee851997@gmail.com" in the respective field
    And User enters invalidpassword "Restartnew@0" in the respective field 
    And User clicks on the Login button
    Then User receives a warning message "Warning: No match for E-Mail Address and/or Password." in the LoginPage
    
@InvalidEmailValidPassword
Scenario: Verify Login With InvalidEmail ValidPassword
    Given User navigates to LoginPage
    And User enters invalidemail "nikhee581997@gmail.com" in the respective field
    And User enters validpassword "Restartnew@8" in the respective field
    And User clicks on the Login button
    Then User receives a warning message "Warning: No match for E-Mail Address and/or Password." in the LoginPage
    
@NoCredentials
Scenario: Verify Login with NoCredentials
    Given User navigates to LoginPage
    And User clicks on the Login button
    Then User receives a warning message "Warning: No match for E-Mail Address and/or Password." in the LoginPage
    