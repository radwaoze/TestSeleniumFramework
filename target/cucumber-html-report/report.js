$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UserRegistraion.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": "I want to check that user can register in our e-commerce website.",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered the user data",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 1770251600,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_click_on_register_button()"
});
formatter.result({
  "duration": 15109300,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_entered_the_user_data()"
});
formatter.result({
  "duration": 3908607900,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 55527100,
  "status": "passed"
});
});