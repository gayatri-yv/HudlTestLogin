Feature: To test login functionality for hudl

  #Positive scenario to veirfy successful login
  @test
  Scenario Outline: To verify login functionality of hudl
    Given I navigate to hudl login page
    When I submit "<username>" and "<password>"
    Then I can see hudl home page with my login
    Examples:
      | username             | password |
      | gayatri.yv@gmail.com | sairam31 |

    #Negative scenarios
  @test
  Scenario Outline: To verify user cannot login with invalid credentials
    Given I navigate to hudl login page
    When I submit "<username>" and "<password>"
    Then error message is displayed
    Examples:
      | username               | password |
      | gaya£tri.yv@gmail.com  | test     |
      | n&                     | abc      |
      |                        | test     |
      | gayatri.yv@gmail.com   |          |
      | gayatri.test@gmail.com |          |
      | Invalid@invalid.test   | test     |