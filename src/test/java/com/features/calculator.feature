@test
Feature: Customer is able to arithmetic operation using the groups already exist
  As a user - I want to select different group member to calculator and perform the given arthmetic operation

  @positive
  Scenario Outline: customer able to select group and perform various operation for valid input
    Given the customer has navigated to home page in <Browser Name>
    And Customer pass the algorithm equation
      | <query> |
    When customer click on calculate button
    Then customer will get this expected result
      | <result> |

    Examples:
      | Browser Name | query                         | result                                         |
      | Chrome       | ( primes Intersection evens ) | 2                                              |
      | Chrome       | primes ∆ evens                | 3,4,5,6,7,8,10,11,12,13,14,16,17,18,19         |
      | Chrome       | ints ⋃ square                 | ,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19 |

  @negative
  Scenario Outline: customer able to select group and perform various operation for invalid input in a loop
    Given the customer has navigated to home page in <Browser Name>
    Then Customer pass the algorithm equation and validate the result
      | query                         | result                              |
      | ints Difference square square | Error: Please ensure query is valid |
      |                               | Please enter query above            |
      | ( )                           | Error: Please ensure query is valid |

    Examples:
      | Browser Name |
      | Chrome       |