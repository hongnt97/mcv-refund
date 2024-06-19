import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://dev-mcv2.9pay.mobi/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Account 9Pay/input_username'), username)

WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), password)

WebUI.click(findTestObject('Page_Account 9Pay/button_login'))

WebUI.click(findTestObject('Page_Dashboard/modulerefund'))

WebUI.click(findTestObject('Page_Dashboard/a_Refund'))

WebUI.click(findTestObject('Page_Refund Request List/button_Add'))

WebUI.setText(findTestObject('Page_Create Refund Request/input__transactionid'), input_transactionid)

WebUI.enableSmartWait()

WebUI.verifyTextPresent(expect_msg, false)

WebUI.closeBrowser()

