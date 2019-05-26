
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import org.openqa.selenium.remote.HttpCommandExecutor

import org.openqa.selenium.remote.SessionId

import com.kms.katalon.core.testobject.TestObject


def static "myPack.projectKeywords.generateRandomString"(
    	int strLen	) {
    (new myPack.projectKeywords()).generateRandomString(
        	strLen)
}

def static "myPack.projectKeywords.countRowsPerPage"(
    	String xpath	) {
    (new myPack.projectKeywords()).countRowsPerPage(
        	xpath)
}

def static "myPack.projectKeywords.isFiledownloaded"(
    	String downloadPath	
     , 	String fileName	) {
    (new myPack.projectKeywords()).isFiledownloaded(
        	downloadPath
         , 	fileName)
}

def static "myPack.projectKeywords.deleteDownloadedFiles"(
    	String downloadPath	) {
    (new myPack.projectKeywords()).deleteDownloadedFiles(
        	downloadPath)
}

def static "myPack.projectKeywords.Excelcompare"(
    	String Fname	
     , 	String DataFile	
     , 	String ColName	) {
    (new myPack.projectKeywords()).Excelcompare(
        	Fname
         , 	DataFile
         , 	ColName)
}

def static "myPack.projectKeywords.CompareExcel"(
    	String Fname	
     , 	String DataFile	
     , 	String ColName	) {
    (new myPack.projectKeywords()).CompareExcel(
        	Fname
         , 	DataFile
         , 	ColName)
}

def static "myPack.projectKeywords.setDownloadPath"() {
    (new myPack.projectKeywords()).setDownloadPath()
}

def static "myPack.projectKeywords.isFiledelete"(
    	String reportPath	) {
    (new myPack.projectKeywords()).isFiledelete(
        	reportPath)
}

def static "myPack.projectKeywords.modifyFile"(
    	String filePath	
     , 	String oldString	
     , 	String newString	) {
    (new myPack.projectKeywords()).modifyFile(
        	filePath
         , 	oldString
         , 	newString)
}

def static "myPack.projectKeywords.getXmlFiles"(
    	String testSuiteId	) {
    (new myPack.projectKeywords()).getXmlFiles(
        	testSuiteId)
}

def static "myPack.projectKeywords.Jsonfieldcontext"(
    	String testSuiteId	
     , 	String Usr	) {
    (new myPack.projectKeywords()).Jsonfieldcontext(
        	testSuiteId
         , 	Usr)
}

def static "myPack.projectKeywords.sendCommandForDownloadChromeHeadLess"(
    	HttpCommandExecutor driverCommandExecutor	
     , 	SessionId sessionId	
     , 	String downloadPath	) {
    (new myPack.projectKeywords()).sendCommandForDownloadChromeHeadLess(
        	driverCommandExecutor
         , 	sessionId
         , 	downloadPath)
}

def static "myPack.CucumberAp.refreshBrowser"() {
    (new myPack.CucumberAp()).refreshBrowser()
}

def static "myPack.CucumberAp.clickElement"(
    	TestObject to	) {
    (new myPack.CucumberAp()).clickElement(
        	to)
}

def static "myPack.CucumberAp.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new myPack.CucumberAp()).getHtmlTableRows(
        	table
         , 	outerTagName)
}
