@wip
Feature:API Tests

  Scenario:Get request to users
    Given existing Server application "https://reqres.in/api/users"
    Then on GET request to users it returns expected users list

  Scenario: Get request to single user
    Given existing Server application "https://reqres.in/api/users/2"
    Then on GET request it returns expected welcome message

  Scenario: Get request to nonexisting user
    Given existing Server application "https://reqres.in/api/users/23"
    Then on GET request it returns "404" status code

