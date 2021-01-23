$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "To validate the login functionality",
  "description": "",
  "id": "to-validate-the-login-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Validate registered Reg Maintain user is able to login with valid username and password",
  "description": "",
  "id": "to-validate-the-login-functionality;validate-registered-reg-maintain-user-is-able-to-login-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is on flowable login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitionTest.user_is_on_flowable_login_page()"
});
formatter.result({
  "duration": 5689790322,
  "error_message": "junit.framework.ComparisonFailure: Facebook - Log In or Sign Up expected:\u003c[]\u003e but was:\u003c[User is not on login page]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.TestCase.assertEquals(TestCase.java:253)\r\n\tat stepdefinition.LoginStepDefinitionTest.user_is_on_flowable_login_page(LoginStepDefinitionTest.java:13)\r\n\tat ✽.Given user is on flowable login page(login.feature:4)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 6,
  "name": "Validate registered Reg Maintain user is not able to login with Invalid username and password",
  "description": "",
  "id": "to-validate-the-login-functionality;validate-registered-reg-maintain-user-is-not-able-to-login-with-invalid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "user is on flowable login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitionTest.user_is_on_flowable_login_page()"
});
formatter.result({
  "duration": 9159664,
  "error_message": "junit.framework.ComparisonFailure: Facebook - Log In or Sign Up expected:\u003c[]\u003e but was:\u003c[User is not on login page]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.TestCase.assertEquals(TestCase.java:253)\r\n\tat stepdefinition.LoginStepDefinitionTest.user_is_on_flowable_login_page(LoginStepDefinitionTest.java:13)\r\n\tat ✽.Given user is on flowable login page(login.feature:7)\r\n",
  "status": "failed"
});
});