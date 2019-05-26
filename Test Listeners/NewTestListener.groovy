import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import internal.GlobalVariable as GlobalVariable
import myPack.projectKeywords

import com.kms.katalon.core.configuration.RunConfiguration

import com.fasterxml.jackson.databind.ObjectMapper

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile



import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//import cucumber.api.Scenario;
//import cucumber.api.java.Before;
//import cucumber.api.java.After;
import cucumber.api.java.After;
import cucumber.api.java.Before;

class NewTestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	
	
	@AfterTestCase()
	def AfterScenario(TestCaseContext context)
	{
	   Map srt = context.getTestCaseVariables();
	   println(srt.get("userName"));
	   println("The above is variable name")
	   println(GlobalVariable.userName)		
	   
	   println "###########################" +context.getTestCaseId()
	   
	   WebUI.delay(15)
	   String tsName = context.getTestCaseId()
	   int start   = tsName.lastIndexOf('/')
		 String  ReportName = tsName.substring(start+1)
		println "Report Name :" +ReportName
		 new projectKeywords().Jsonfieldcontext(ReportName,GlobalVariable.userName)
	   
	}
	
	@Before
	def Sample()
	{
		int a,b,c;
		a=10;
		b=20;
		c=a+b;
		print(c)
		println('Hi there this is before');
	}
	
	@After
	def Afterscen()
	{
		println('I am completed');
	}
	
	
	@AfterTestSuite
	def sampleAfterTestCase(TestSuiteContext testSuiteContext) {
		
	/*  println "###########################" +testSuiteContext.getTestSuiteId()		
		WebUI.delay(15)
		String tsName = testSuiteContext.getTestSuiteId()
		int start   = tsName.lastIndexOf('/')
		String  ReportName = tsName.substring(start+1)
		println "Report Name :" +ReportName 
		new projectKeywords().Jsonfieldcontext(ReportName,GlobalVariable.userName)  */		  	  
		
	}
	
		
	
}

	
	
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	
