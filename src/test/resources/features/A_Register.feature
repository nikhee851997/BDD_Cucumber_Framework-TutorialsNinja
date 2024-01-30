
@RegisterForTutorialsNinja

Feature: RegisterFunctionality

Background:Common Steps Of The Code
Given User navigates to Registerpage
And User enters firstname "Raj" in the respective field
And User enters lastname "Kumar" in the respective field
And User enters emailaddress in the respective field
And User enters telephonenumber "8686550100" in the respective field
And User enters password "asdfg1234@R" in the respective field
Then User needs to confirmpassword "asdfg1234@R" in the respective field

@mandatoryfields
Scenario: Register With Mandatory Fields
Then User needs to agree to privacypolicy by selecting the respective option
When User clicks continue button
Then User will be navigated to AccountPage

@AllFields
Scenario: Register With All Fields
And User selects the option to subscribe in the respective option 
Then User needs to agree to privacypolicy by selecting the respective option
When User clicks continue button
Then User will be navigated to AccountPage
   