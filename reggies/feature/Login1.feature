
Feature: Login
Scenario:Navigating to Google
Given I Navigate to Google

 Scenario Outline: Title of your scenario outline
    When I search the  <name>
    Then I verify the <name> in step
    
    Examples: 
      |  name         |
      |  "Reggies"    |
      |  "Roger"      | 
      |  "Pushpender" | 
      
Scenario:Closing the Browser
Given I close the Browser
      