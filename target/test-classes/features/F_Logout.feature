
@Logout
Feature: LogoutFunctionality

@LogoutApplication
  Scenario: VerifyLogoutOfApplication
  
 Given User travel to LoginPage
 And User insert ecredentials "nikhee851997@gmail.com" in their field of LoginPage
 And User insert pcredentials "Restartnew@8" in their field of LoginPage
 And User press down Login optn
 And User navigates to AccountPage
 And User press down Logout optn
 Then User press down continue optn to Logout of aplication
  