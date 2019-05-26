import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import gmail_Login_Runner
import gmail_Login_Runner1
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration


CucumberKW.runWithCucumberRunner(gmail_Login_Runner.class)

//println(GlobalVariable.userName)


def profile_name= RunConfiguration.getExecutionProfile();

//GlobalVariable.userName

switch(profile_name){
	
	case "Devtester":
	CucumberKW.runWithCucumberRunner(gmail_Login_Runner.class)
	println("I entetered in DevTester switch case")
	break

	case "TesterDev":
	CucumberKW.runWithCucumberRunner(gmail_Login_Runner1.class)
	println("I entetered in TesterDev switch case")
	break
	
	default :    break 
}
