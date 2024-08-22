#Name:chandramouli
#Desc:feature file for jsonplacholder.typicode.com
#Date:20-8-24
Feature: CRUD Operations on Jsonplaceholder application

Scenario: Get all posts
Given I have a base URI "https://jsonplaceholder.typicode.com"
When I send a GET request to "/posts"
Then the response status code should be 200
@RegressionTesting
Scenario Outline: create new post in application
Given I have a base URI "https://jsonplaceholder.typicode.com"
When I send a POST request to "/posts" with body as "<RequestBody>"
Then the response time should be less than 5000

Scenario: Get one post
Given I have a base URI "https://jsonplaceholder.typicode.com"
When I send a GET request to "/posts/3"
Then the response status code should be 200
@SanityTesting
Scenario Outline: update one post
Given I have a base URI "https://jsonplaceholder.typicode.com"
When I send a PUT request to "/posts/4" with body as "<ReqBody>"
Then the response time should be less than 5000
@SmokeTesting
Scenario: delete one post
Given I have a base URI "https://jsonplaceholder.typicode.com"
When I send a Delete request to "/posts/3"
Then the response status code should be 200
Examples: 
|RequestBody																					|ReqBody																										|
|{ \\"title\\": \\"foo\\", \\"body\\": \\"bar ece\\" }|{ \\"title\\": \\"new post1\\", \\"body\\": \\"new eee\\" }|
