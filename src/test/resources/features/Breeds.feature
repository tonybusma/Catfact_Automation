
@Full
Feature: Consult breeds API
  Checking the query on the GET endpoint '/breeds'

 @PositiveLimit
  Scenario: Query with a positive value
    Given that the user queries the GET endpoint
    When enters the value 20 in the limit field and executes the request
    Then the endpoint should return status code 200
    And should return a list with the number of items equal to 20

@MaximumPageCount
  Scenario: Check maximum page count
    Given that the user queries the GET endpoint
    When enters the value 1 in the limit field and executes the request
    Then the endpoint should return status code 200
    And should return the value 98 in the 'last_page' field

@LimitFieldZero
  Scenario: Query with zero value
    Given that the user queries the GET endpoint
    When enters the value 0 in the limit field and executes the request
    Then the endpoint should return status code 200
    And should return a list with the number of items equal to 15

@NegativeLimit
  Scenario: Query with a negative value
    Given that the user queries the GET endpoint
    When enters the value -5 in the limit field and executes the request
    Then the endpoint should return status code 404
    And should return the message 'Not Found'     
    
@PageWithoutData
  Scenario: Check return page without data
    Given that the user queries the GET endpoint
    When enters the value 50 in the limit field, 3 in the page field and executes the request
    Then the endpoint should return status code 200
    And should return the empty data list