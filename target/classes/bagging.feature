Feature: Verify Banggood Application

#  Background: Open app and Close popup
#    Given Open Banggood Online Shopping App
  @TC01
  Scenario: Verify first product
    Given  Open Banggood Online Shopping App
    When Click to the Category on footer menu
    And Scroll and click to Home and Garden in left menu
    And After the right category displayed, click to the Home decor
    And Click to the Filter and input price from 20 to 30
    And Click Done
    And Click First product
    Then Verify product name should be displayed and product price 20 to 30