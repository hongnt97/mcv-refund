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

WebUI.openBrowser('https://stg-cms-payment.9pay.mobi/login')

WebUI.setText(findTestObject('Page_cms-payment - Login/input_usernameCMS'), 'admin@gmail.com')

WebUI.setText(findTestObject('Page_cms-payment - Login/input_passwwordCMS'), 'paygate@123')

WebUI.click(findTestObject('Page_cms-payment - Login/button_LoginCMS'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('f1/Page_Dashboard/a_module ychoantien'))

WebUI.click(findTestObject('f1/Page_Dashboard/a_Danh sch ch duyt'))

WebUI.enableSmartWait()

WebUI.setText(findTestObject('Page_Danh sch ch duyt yu cu hon tin/filter'), '63678732318889')

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/button_Timkiem'))

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/checkall'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/button_T chi'))

WebUI.setText(findTestObject('Page_Danh sch ch duyt yu cu hon tin/lydotuchoi'), 'tu choi GD')

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/btn xacnhantuchoi'))

WebUI.enableSmartWait()
