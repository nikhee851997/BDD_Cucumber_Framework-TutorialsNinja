
@ProductSpecsAndAddingToCart 
 
Feature: SpecsAndCartFunctionality 

Background: Common Steps Of The Code

Given User will be directed to LoginPage
And User will enter emailid "nikhee851997@gmail.com" in the field
And User will enter passcode "Restartnew@8" in the field
And User will tap on Login option
And User will enter product name "HP" in the field
And User will tap on the search option 
Then User will see the product with name "HP LP3065" in SearchPage 
    
@ProductSpecs              
Scenario: VerifySpecsOfProduct    
And User will tap on the product "HP LP3065" for more details in SearchPage 
And User will tap on specs option of the product "HP LP3065" in ProductPage
Then User will see the product specs displayed in ProductPage

@ProductAddingToCart
Scenario: VerifyAddingProductToCart
And User will tap on add to cart option of the product "HP LP3065" in SearchPage
And User will tap on add to cart option of the product "Hp" in ProductPage
And User will tap on cart option held on the top in ProductPage
And User will tap on view cart option that is in dropdown of cart option in ProductPage
Then User will see the product "HP LP3065" added to cart in CartPage



