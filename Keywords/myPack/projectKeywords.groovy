package myPack
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Field

import com.fasterxml.jackson.databind.ObjectMapper
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
//import com.oracle.webservices.internal.api.message.ContentType

import internal.GlobalVariable
//import jdk.nashorn.internal.parser.JSONParser
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.json.Json
import org.openqa.selenium.WebDriver
import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
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
import org.apache.http.entity.StringEntity
import org.openqa.selenium.remote.HttpCommandExecutor
import org.openqa.selenium.remote.SessionId

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost

import org.apache.http.io.SessionInputBuffer
//import org.eclipse.persistence.internal.oxm.record.json.JSONParser
//import org.json.JSONArray
//import org.json.JSONObject
import org.json.simple.parser.JSONParser;
import org.apache.http.entity.ContentType

//import com.fasterxml.jackson.databind.ObjectMapper
import org.json.simple.JSONArray
import org.json.simple.JSONObject


class projectKeywords {

	@Keyword
	def public String generateRandomString(int strLen) {

		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i <strLen ; i++) {
			int randIndex=rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}

	@Keyword
	def countRowsPerPage(String xpath){

		//println "xpath is " + xpath
		WebDriver driver = DriverFactory.getWebDriver()

		//Find the table element on the page

		WebUI.switchToFrame(findTestObject('Object Repository/PurchasingPolicy/iframe'), 10)


		WebElement Webtable=driver.findElement(By.xpath(xpath))
		//println Webtable

		List TotalRowCount=Webtable.findElements(By.xpath(xpath))

		//Get the size of the List, this is the number of rows
		int totalNumberOfRows=TotalRowCount.size()
		println('Total Number of rows on the page:= ' + totalNumberOfRows)

		WebUI.switchToDefaultContent()

		return totalNumberOfRows

	}


	//------------------Check whether File got Downloaded-----------------------

	@Keyword

	//	public boolean isFiledownloaded(String downloadPath, String fileName) {
	def isFiledownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);

		File[] dirContents = dir.listFiles();

		String lastAttempt = '';
		String fileNameInExcel ='';
		WebUI.delay(1)

		println "######################## dowloadPath" + downloadPath
		println "######################## dirContents.length"+ dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				if (dirContents[i].getName().equals(fileName)) {

					// File has been found, it can now be deleted:

					dirContents[i].delete();

					KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					KeywordUtil.markPassed("")
					println "Fname from folder "+dirContents[i].getName() + "equals to" + fileName
					fileNameInExcel = dirContents[i].getName()
					println "File name is = "+ fileNameInExcel
					return fileNameInExcel;
					//return true;

				}

				//	lastAttempt = dirContents[i].getName().equals(fileName);
				lastAttempt = dirContents[i].getName()
				println "lastAttempt is = "+ lastAttempt
			}

			if (lastAttempt != fileName) {
				//println "Fname from folder "+dirContents[i].getName() + "not equals to" + fileName
				//fileNameInExcel = dirContents[i].getName()
				KeywordUtil.markFailed(fileName + ' does not exist in ' + downloadPath)
				println "lastAttempt is = "+ lastAttempt
				return lastAttempt
				//return false;
			}
		}

		return false;
	}


	//####################################Delete All the Files From Downloaded Location###################

	@Keyword

	def deleteDownloadedFiles(String downloadPath){
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		println "#################"+downloadPath
		println dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				dirContents[i].delete();
				//return true;

			}

		}

		return false
	}

	//#############Compare from Excel ##############
	@Keyword
	def Excelcompare(String Fname, String DataFile, String ColName) {
		String b
		String a =Fname
		for(def row=1;row<=findTestData(DataFile).getRowNumbers();row++){

			b= findTestData(DataFile).getValue(ColName, row)

			//println b
			if(a.equals(b)){

				println a+" is equal to "+b

				KeywordUtil.markPassed(a+ ' is equal to '+b)

				return true
			}
		}

		if(a!=b) {
			KeywordUtil.markFailed(a + " is not equal to "+ b)

			return false
		}
	}

	//##########################Compare Excel########################################

	@Keyword
	def CompareExcel(String Fname, String DataFile, String ColName) {
		String b
		String a = Fname
		for(def row=1;row<=findTestData(DataFile).getRowNumbers();row++){

			b= findTestData(DataFile).getValue(ColName, row)

			//println b
			if(a.equals(b)){

				println a+" is equal to "+b

				KeywordUtil.markPassed(a+ ' is equal to '+b)

				return b
			}
		}

		if(a!=b) {
			KeywordUtil.markFailed(a + " is not equal to "+ b)

			return b
		}
	}

	//#####################Set Download Location################################

	@Keyword

	def setDownloadPath() {

		//ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true)

		HashMap<Object, String> chromePrefs = new HashMap<Object, String>();

		chromePrefs.put("download.default_directory", RunConfiguration.getProjectDir() + "/Include/TestData/DownloadedFiles")

		RunConfiguration.setWebDriverPreferencesProperty("prefs", chromePrefs)





	}


	//#####################Delete Reports Location################################

	@Keyword

	public boolean isFiledelete(String reportPath) {

		File dir = new File(reportPath);

		File[] dirContents = dir.listFiles();

		WebUI.delay(1)
		println "length :" + dirContents.length
		if (dirContents.length > 0) {
			println " inside length :" + dirContents.length

			for (int i = 0; i < dirContents.length; i++) {

				dirContents[i].delete();
			}
		}
		return false
	}


	//#####################Modify Reports Name################################

	@Keyword

	def modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));

			//Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null)
			{
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			//Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			//Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//Closing the resources

				reader.close();

				writer.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	// To change the report Naame for Katalon Analytics

	@Keyword
	def getXmlFiles(String testSuiteId){

		String pathToFolder = RunConfiguration.getProjectDir() + '/MyReports'
		List<File> aList = new ArrayList<File>();

		File dir = new File(pathToFolder);

		File[] dirContents = dir.listFiles();

		for (File xmlfname : dirContents) {

			if (xmlfname.isFile() && getFileExtensionName(xmlfname).indexOf("xml") != -1) {
				aList.add(xmlfname);
			}
		}


		aList= aList.toArray(new File[aList.size()]);

		println "aList :"+ aList
		for(int i=0;i<aList.size;i++){

			String fpath = aList[i]
			println "fpath :"+fpath
			modifyFile(fpath,"cucumber.runtime.formatter.JUnitFormatter",testSuiteId)
		}


	}

	public static String getFileExtensionName(File f) {
		if (f.getName().indexOf(".") == -1) {
			return "";
		} else {
			return f.getName().substring(f.getName().length() - 3, f.getName().length());
		}
	}

	@Keyword
	def Jsonfieldcontext(String testSuiteId,String Usr){

		String pathToFolder = RunConfiguration.getProjectDir() + '/MyReports'
		List<File> arrList = new ArrayList<File>();

		File dir = new File(pathToFolder);

		File[] dirContents = dir.listFiles();

		for (File jsonfname : dirContents) {

			if (jsonfname.isFile() && getFileName(jsonfname).indexOf("json") != -1) {
				arrList.add(jsonfname);

			}
		}

		arrList= arrList.toArray(new File[arrList.size()]);

		println "arrList :"+ arrList
		for(int i=0;i<arrList.size;i++){
			println "arrList.size :"+ arrList.size
			String fpath = arrList[i]

			println "fpath :"+fpath

			JSONParser parser = new JSONParser();

			Object obj = parser.parse(new FileReader(fpath));

			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get("name");

			JSONArray companyList = (JSONArray) jsonObject.get("elements");

			//				println"comp :"+ companyList
			def scenario_name= companyList.get(0)["name"]
			println"scenario_name :"+ scenario_name

			def executionProfile =RunConfiguration.getExecutionProfile()
			println "executionProfile :"+executionProfile

			String c =RunConfiguration.getExecutionProfile()



			String data="Login To gmail Account"
			String Scenario="Login To gmail Account -->"+executionProfile + Usr
			println "Scenario"+ Scenario

			if(scenario_name=="Login To gmail Account")
			{
				modifyFile(fpath,data,Scenario)
			}
			else{
				println "Else Cond"
			}
		}
	}

	public static String getFileName(File f) {
		if (f.getName().indexOf(".") == -1) {
			return "";
		} else {
			return f.getName().substring(f.getName().length() -4 , f.getName().length());
		}
	}


	@Keyword
	static void sendCommandForDownloadChromeHeadLess(HttpCommandExecutor driverCommandExecutor,SessionId sessionId,String downloadPath) {
		println "Entered now"
		println ""+driverCommandExecutor
		println ""+sessionId
		println "" +downloadPath
		Json json = new Json()

		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("cmd", "Page.setDownloadBehavior");

		//	println "######################" + paramsMap
		Map<String,String> cmdParamsMap = new HashMap<>();
		cmdParamsMap.put("behavior", "allow");
		//	println "######################" + cmdParamsMap
		cmdParamsMap.put("downloadPath", downloadPath);
		//	println "######################" + cmdParamsMap
		paramsMap.put("params", cmdParamsMap);
		//	println "######################" + paramsMap

		String content = json.toJson(paramsMap)
		//	println "################# Content = "+content
		//log.debug("The request content is :: {}" ,content);
		URL remoteServerUri = null;
		try {

			Field field = HttpCommandExecutor.class.getDeclaredField("remoteServer")

			//		println "################# Field = "+field
			field.setAccessible(true);
			remoteServerUri = (URL)field.get(driverCommandExecutor);
			//		println "################# remoteServerUri = "+remoteServerUri
		}catch (Exception e) {
			println "############# ERROR"+e
			println "This will cause all the file validations to fail"
			//log.debug("The HttpCommandExecutor has been modified please check with the framework team",e);
			//log.error("This will cause all the file validations to fail");
			return;
		}

		CloseableHttpClient httpclient = null;

		try {


			httpclient = HttpClients.createDefault()
			//	println "############# httpclient"+ httpclient
			URIBuilder builder = new URIBuilder(remoteServerUri.toURI())
			//	println "############# builder"+ builder
			builder.setPath("/session/"+sessionId.toString()+"/chromium/send_command");
			//builder.setPath("session/"+sessionId.toString()+"/chromium/send_command");
			//	println "############# builder.setPath"+ builder
			HttpPost sendCommandPost = new HttpPost(builder.build())
			//	println "############# sendCommandPost"+ sendCommandPost
			sendCommandPost.setHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
			//sendCommandPost.setHeaders("Content-Type","")

			//StringEntity entity = new StringEntity(content, );
			StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON)
			//		println "############# entity"+ entity
			sendCommandPost.setEntity(entity);
			//		println "############# sendCommandPost"+ sendCommandPost
			CloseableHttpResponse response = httpclient.execute(sendCommandPost);
			//		println "############# response"+ response
			int statusCode = response.getStatusLine().getStatusCode();
			//log.debug("The Response Status code is {}",statusCode);
			println"The Response Status code is {}" + statusCode;
			if(statusCode <= 200 && statusCode >= 300) {
				///log.debug("Un-Successfull status code received");
				println "Failure"
			}
		}catch (IOException e) {
			//log.error("Error Occured while enabling download file setting for chrome headless mode");
			//log.error("This will cause all the file validations to fail",e);
			println "This will cause all the file validations to fail"+e

		} catch (URISyntaxException e) {
			//log.debug("this should never ever occur");
			println "this should never ever occur"

		}
		finally {
			if(httpclient != null) {
				try {
					//httpclient.close()
				} catch (IOException e) {
					//log.warn("Error Occured while closing the http client",e);
					println "Error Occured while closing the http client" + e
				}
			}
		}

	}

}