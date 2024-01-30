
@SearchProductInTutorialsNinja
Feature: SearchFunctionality

@ValidProduct
Scenario:SearchingForValidProduct
Given User navigates to LandingPage
And User enters validproduct "HP" in the searchbox
And User clicks on search button
Then User can see the product information that is displayed in SearchPage
  
@InvalidProduct
Scenario:SearchForInvalidProduct
Given User navigates to LandingPage
And User enters invalidproduct "Huawei" in the searchbox
And User clicks on search button
Then User can see the warning message,"There is no product that matches the search criteria."

@NoProduct
Scenario:SearchForNoProduct
Given User navigates to LandingPage
And User clicks on search button
Then User can see the warning message,"There is no product that matches the search criteria."
