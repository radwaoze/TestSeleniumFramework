Feature: User Registration
  I want to check that user can register in our e-commerce website.

Scenario: User Registration
  Given the user in the home page
  When I click on register button
  And I entered the user data
  Then The registration page displayed successfully

