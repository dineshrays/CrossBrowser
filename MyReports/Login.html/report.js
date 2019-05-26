$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/gmail_Login.feature");
formatter.feature({
  "name": "Gmail Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Login To gmail Account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    },
    {
      "name": "@Hoks"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User should be on gmail login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "gmailLoginStepDef.user_should_be_on_gmail_login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters Email Id",
  "keyword": "And "
});
formatter.match({
  "location": "gmailLoginStepDef.user_enters_Email_Id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks Next",
  "keyword": "When "
});
formatter.match({
  "location": "gmailLoginStepDef.user_clicks_Next()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters password",
  "keyword": "And "
});
formatter.match({
  "location": "gmailLoginStepDef.user_enters_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks Next Button",
  "keyword": "And "
});
formatter.match({
  "location": "gmailLoginStepDef.user_clicks_Next_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be logged in to the gmail account",
  "keyword": "Then "
});
formatter.match({
  "location": "gmailLoginStepDef.user_should_be_logged_in_to_the_gmail_account()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});