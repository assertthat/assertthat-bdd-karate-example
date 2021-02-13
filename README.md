# assertthat-bdd-karate-example

Example of AssertThat BDD Jira plugin integration with Karate

To tun: 

```
mvn clean verify
```

Feature file used: 

```
# language: en
@users    
Feature: sample karate test script

    for help, see: https://github.com/intuit/karate/wiki/IDE-Support

    Background: 
        
        * url 'https://jsonplaceholder.typicode.com'

    @AUTOMATED 
    Scenario: get all users and then get the first user by id
        
        Given path 'users'
        When method get
        Then status 200
        * def first = response[0]
        Given path 'users', first.id
        When method get
        Then status 200

    @AUTOMATED 
    Scenario: create a user and then get it by id
        
        * def user =
          """
          {
            "name": "Test User",
            "username": "testuser",
            "email": "test@user.com",
            "address": {
              "street": "Has No Name",
              "suite": "Apt. 123",
              "city": "Electri",
              "zipcode": "54321-6789"
            }
          }
          """
        Given url 'https://jsonplaceholder.typicode.com/users'
        And request user
        When method post
        Then status 201
        * def id = response.id
        * print 'created id is: ', id
        Given path id


```
