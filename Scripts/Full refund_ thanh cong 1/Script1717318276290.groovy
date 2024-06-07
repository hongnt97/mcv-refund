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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

WebUI.openBrowser('https://dev-mcv2.9pay.mobi/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Account 9Pay/input_username'), 'mch2')

WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), 'Abc@12345')

WebUI.click(findTestObject('Page_Account 9Pay/button_login'))

WebUI.click(findTestObject('Page_Dashboard/modulerefund'))

WebUI.click(findTestObject('Page_Dashboard/a_Refund'))

WebUI.click(findTestObject('Page_Refund Request List/button_Add'))

WebUI.setText(findTestObject('Page_Create Refund Request/input__transactionid'), '62757081248219')

textngayGD = WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))
textloaiGD= WebUI.getText(findTestObject('Page_Create Refund Request/LoaiGD'))
textstatus= WebUI.getText(findTestObject('Page_Create Refund Request/status'))
String textloaiGD
String textstatus
if (textloaiGD== "Thanh toán") {
	System.out.println("Tạo GD")
} else {
	System.out.println("Giao dịch không thể tạo yêu cầu hoàn tiền")
}

if (textstatus== "Thành công") {
	System.out.println("Tạo GD")
} else {
	System.out.println("Giao dịch không thể tạo yêu cầu hoàn tiền")
}
System.out.println(textngayGD)
LocalDateTime myDateObj = LocalDateTime.now();  
    System.out.println("Before formatting: " + myDateObj);  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss dd/mm/yyyy");  
    String formattedDate = myDateObj.format(myFormatObj);  
    System.out.println("After formatting: " + formattedDate);


WebUI.enableSmartWait()

WebUI.verifyElementText(findTestObject('Page_Create Refund Request/p_The Transaction can be partially refunded after 24 hours of success'), 
    'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

WebUI.verifyElementChecked(findTestObject('Page_Create Refund Request/Full refund'), 10)

WebUI.verifyElementNotClickable(findTestObject('Page_To yu cu hon tin/hon 1 phn'))

WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), textarea_reason)

WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

WebUI.enableSmartWait()

WebUI.verifyTextPresent(expected_msg, false)

WebUI.closeBrowser()

