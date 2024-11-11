package test.fast.CreatePolicyforLife;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.ContentType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nyl.base.WebBase;
import com.nyl.utilities.EnvParameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;
import com.relevantcodes.extentreports.model.Log;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.ITestContext;


public class CreatePolicyWithAPI extends WebBase{
	public static ExtentReports mainReport;
	public HashMap<String, Integer> testCaseRetryCount = new HashMap<String, Integer>();
	public String folderPath;
	
	@BeforeClass(alwaysRun = true)
	public void reportInitialization() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
		LocalDateTime now = LocalDateTime.now();
		folderPath = ".//Reports/Functional Test Reports/CreatePolicyWithAPI/Test Report_" + dtf.format(now);
		fileName = folderPath + "/CreatePolicyWithAPI.html";
		mainReport = new ExtentReports(fileName);
		mainReport.loadConfig(new File(".//Config Files/Functional Test Report-config.xml"));
	}

	// Test method for creating the policy using APIs
	@Test
	public void createPolicy(ITestContext context) throws Exception {
		ExtentTest subTest = null;
		ExtentTest test = null;
		ExtentReports report = new ExtentReports("dummy.html");
		test = report.startTest("Create Policy");
		subTest = report.startTest("Create Policy Using API Calls");
		try {
			// Step 1: Directory containing the XML files
			String folderPath = context.getCurrentXmlTest().getParameter("XMLsFolderPath");
			subTest.log(LogStatus.INFO, "Step1: Received the XML's folder path from the TestNG Runner as: <b><a href='"+folderPath+"' target='_blank'>Folder Path</a></b>");
			
			// Step 2: Get all XML Files from the given folder path
			File folder = new File(folderPath);
			File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"));
			subTest.log(LogStatus.INFO, "Step2: Capturing all the .xml files from the given folder path");

			// Step 3: Ensure there are XML files to process
			Assert.assertNotNull(listOfFiles, "No XML files found in the directory");
			Assert.assertTrue(listOfFiles.length > 0, "No XML files found in the directory");
			subTest.log(LogStatus.INFO, "Step3: Total number of xml files for policy creation are: "+ listOfFiles.length);
			
			// Step 4: Get bearer token
			String token = getBearerToken(subTest);
			test.appendChild(subTest);
			report.endTest(subTest);
			
			
			// Step 4: Loop through each XML and create policies
			for (File file : listOfFiles) {
				if (file.isFile()) {
					subTest = report.startTest("Create Policy Using API Calls for the XML file [<font color='#30A0DB'><b>"+file.getName()+"</b></font>]");
					// Convert XML file to Base64
					subTest.log(LogStatus.INFO, "Step1: Encoding the XML file [<font color='#30A0DB'><b>"+file.getName()+"</b></font>] to Base64 String format");
					String encodedXML = encodeXMLToBase64(file.getAbsolutePath());
					subTest.log(LogStatus.PASS, "Step2: Success! Encoded the XML file to Base64 String format");
					subTest.log(LogStatus.INFO, "Encoded String: "+encodedXML);
					System.out.println("Processing file: " + file.getName());
					
					subTest.log(LogStatus.INFO, "Step3: Hit the Policy Creation endpoint URL along with the token and the encoded string");
					// Step 5: Hit policy creation API with the Base64 encoded XML
					String policyNumber = createPolicy(token, encodedXML);
					subTest.log(LogStatus.PASS, "Success! Policy got created with the Policy Number as: "+policyNumber);
					
					// Assert that the policy number is not null or empty
					//Assert.assertNotNull(policyNumber, "Policy number should not be null");
					//Assert.assertFalse(policyNumber.isEmpty(), "Policy number should not be empty");
					
					test.appendChild(subTest);
					report.endTest(subTest);
				}
			}

			
		}catch(Exception e) {
			e.printStackTrace();
			subTest.log(LogStatus.FAIL, "Exception Occured - " + e.getLocalizedMessage());
			test.appendChild(subTest);
			//if(testCaseRetryCount.get(data.get("PolicyNumber"))==2)
				addTestToMainReport(test);
			Assert.fail();
		}
				
		
		addTestToMainReport(test);
	}

	// Utility function to encode the XML file to Base64
	public String encodeXMLToBase64(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fis.read(bytes);
		fis.close();
		
		return Base64.encodeBase64String(bytes);
	}

	// Helper method to get bearer token
	public String getBearerToken(ExtentTest subTest) throws Exception {
		FileInputStream fis = null;
	    Properties prop = null;
	    
		fis = new FileInputStream("config.properties");
        prop = new Properties();
        prop.load(fis);
        String userID=prop.getProperty("User_Name");
        String password=prop.getProperty("Password");
        subTest.log(LogStatus.INFO, "Step4: Captured the User ID as [<font color='#30A0DB'><b>"+userID+"</b></font>] and Passwaord as [<font color='#30A0DB'><b>"+password+"</b></font>] from the Config File");
		
		// Prepare the payload
		String payload = "{ \"username\" : \""+userID+"\", \"password\" : \""+password+"\" }";

		// Create the HTTP POST request
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(EnvParameters.tokenApiUrl);

		// Set headers
		post.setHeader("Content-Type", "application/json");
		post.setHeader("X-API-KEY", EnvParameters.XAPIKEY);

		// Set payload
		post.setEntity(new StringEntity(payload, ContentType.APPLICATION_JSON));

		// Execute the request
		CloseableHttpResponse response = client.execute(post);
		subTest.log(LogStatus.INFO, "Step5: Hit the token endpoint url with the given credentials");

		// Validate response code
		// Assert.assertEquals(response.getCode(), 200, "Token API response code should be 200");
		
		// Extract response body
		String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		client.close();

		// Extract the token from the response
		String token = extractTokenFromResponse(responseBody);
		subTest.log(LogStatus.PASS, "Step6: Success! generated the token as: "+token);
		return token;
	}

	// Helper method to extract token from the JSON response
	public String extractTokenFromResponse(String responseBody) {
		// the token comes in this format:
		// { "token" : "adbkjfhakjdfkad", "expires": "2024-10-21-T08:10:05Z" }
		return responseBody.split("\"token\"\\s*:\\s*\"")[1].split("\"")[0];
	}

	// Helper method to hit the policy creation API
	public String createPolicy(String token, String encodedXML) throws Exception {
		
		// Prepare the payload
		String payload = "{ \"encodedACORDXml\" : \"" + encodedXML + "\" }";

		// Create the HTTP POST request
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(EnvParameters.policyApiUrl);

		// Set headers
		post.setHeader("Content-Type", "application/json");
		post.setHeader("Authorization", "Bearer " + token);
		post.setHeader("X-API-KEY", EnvParameters.XAPIKEY);

		// Set payload
		post.setEntity(new StringEntity(payload, ContentType.APPLICATION_JSON));

		// Execute the request
		CloseableHttpResponse response = client.execute(post);

		// Validate response code
		// Assert.assertEquals(response.getCode(), 200, "Policy creation API response
		// code should be 200");

		// Extract response body
		String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		client.close();

		// Extract the Policy Number from the response
		String policyNumber = extractPolicyNumberFromResponse(responseBody);
		return policyNumber;
	}

	// Helper method to extract policy number from the JSON response
	public String extractPolicyNumberFromResponse(String responseBody) {
		JSONObject jsonResponse = new JSONObject(responseBody);
		String policyNumber = jsonResponse.getJSONObject("PolicyHdr").getJSONObject("PolicyHdrData")
				.getString("PolicyNumber");
		return policyNumber;
	}
	
	public void logError(ExtentTest localTest, Exception e, WebDriver driver) {
		String screenshotFileName = "/Screenshots/Screenshot_" + Math.random() + ".png";
		String screenshotPath = System.getProperty("user.dir") + folderPath.substring(2) + screenshotFileName;
		screenshotFileName = "./" + screenshotFileName;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		localTest.log(LogStatus.ERROR, "Exception Occured and Execution Stopped.\n" + e.getLocalizedMessage()
				+ localTest.addScreenCapture(screenshotFileName));
	}

	
	@AfterClass(alwaysRun = true)
	public void reporee(ITestContext result) {
		try {
			FileUtils.deleteDirectory(new File(folderPath + "/Additional Supporting Reports"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		mainReport.flush();
	}
	
	public void addTestToMainReport(ExtentTest test) {
		ITest grandParentTest = test.getTest();
		ExtentTest parentTest = mainReport.startTest(grandParentTest.getName());
		List<com.relevantcodes.extentreports.model.Test> children = grandParentTest.getNodeList();
		for (int k = 0; k < children.size(); k++) {
			ExtentTest child = mainReport.startTest(children.get(k).getName());
			List<Log> logs = children.get(k).getLogList();

			for (int i = 0; i < logs.size(); i++) {
				child.log(logs.get(i).getLogStatus(), logs.get(i).getDetails());

			}
			parentTest.appendChild(child);
			mainReport.endTest(child);
		}

		mainReport.endTest(parentTest);
	}
}
