
@OrderPlacement
Feature: CheckoutFunctionality

@Checkout
Scenario:VerifyCheckoutProduct

Given User will traverse to LoginPage
And User interacts with mail selector and insert "nikhee851997@gmail.com" in its field
And User interacts with pass selector and insert "Restartnew@8" in its field
And User interacts with Login selector
And User interacts with searchbar selector and insert "HP" in its field
And User interacts with search selector
Then User will see the selected product in SearchPage   
And User interacts with add to cart selector of the device in SearchPage
And User interacts with add to cart selector of the device in ProductPage
And User interacts with cart selector in ProductPage
And User interacts with checkout selector that is inside cart selector in ProductPage
And User interacts with checkout selector in CartPage that traverse to CheckoutPage
And User interacts with the continue selector in CheckoutPage for billing details
And User interacts with continue selector for delivery details
And User interacts with continue selector for delivery method
And User need to acknowlege to terms and conditions before placing order 
And User interacts with continue selector for payment method
And User interacts with confirm order selector
Then User will see a successful placement of order message


  