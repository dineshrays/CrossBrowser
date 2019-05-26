import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When




class gmailLoginStepDef {

	@Given("User should be on gmail login Page")
	public void user_should_be_on_gmail_login_Page() {
		WebUI.openBrowser("")
		WebUI.maximizeWindow()
		//WebUI.setViewPortSize(1044,788)
		String url = GlobalVariable.Url

		//RunConfiguration.executionProfile.
		String ss =DriverFactory.getExecutedBrowser().getName()
		Map m = RunConfiguration.getExecutionProperties()
		String driverProp = m.get("drivers").get("system").get("WebUI").get("browserType")
		println  driverProp
		//RunConfiguration.getExecutionProfile(GlobalVariable.userName)


		println(ss)
		WebUI.navigateToUrl(url)
	}

	@Given("User enters Email Id")
	public void user_enters_Email_Id() {

		String userName = GlobalVariable.userName

		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_userid'), userName)
	}

	@And("User clicks Next")
	public void user_clicks_Next() {
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/Page_Sign in  Google accounts/content_Next_username"))
	}

	@When("User enters password")
	public void user_enters_password() {

		String password = GlobalVariable.password
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_password'), password)
	}

	@And("User clicks Next Button")
	public void user_clicks_Next_Button(){
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/Page_Sign in  Google accounts/content_Next"))
	}

	@Then("User should be logged in to the gmail account")
	public void user_should_be_logged_in_to_the_gmail_account() {
		WebUI.delay(8)
		println "Inbox"
		//WebUI.click(findTestObject("Object Repository/Page_Google Account/div_Personal info"))
	}
}