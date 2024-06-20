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
import java.time.LocalTime as LocalTime
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Date as Date
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import java.util.GregorianCalendar as GregorianCalendar
import java.text.ParseException as ParseException
import java.time.Period
import java.time.Duration as Duration
import java.time.Period
		WebUI.openBrowser('https://stg-mcv2.9pay.mobi/')

		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Page_Account 9Pay/input_username'),"mch01")

		WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), "Abc@12345")

		WebUI.click(findTestObject('Page_Account 9Pay/button_login'))
		WebUI.enableSmartWait()
		
		textsoduchodoisoat=WebUI.getText(findTestObject('Page_Dashboard/soduchodoisoat'))
		System.out.println(textsoduchodoisoat)
		soduchodoisoat = 0
		
		soduchodoisoat = textsoduchodoisoat.replace(',', '')
		
		System.out.println('Balance: ' + soduchodoisoat)

		WebUI.click(findTestObject('Page_Dashboard/modulerefund'))

		WebUI.click(findTestObject('Page_Dashboard/a_Refund'))

		WebUI.click(findTestObject('Page_Refund Request List/button_Add'))

		WebUI.setText(findTestObject('Page_Create Refund Request/input__transactionid'), "63806199396618")

		WebUI.enableSmartWait()


textngayGD = WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

System.out.println (textngayGD)

if (textngayGD== "—") {
  WebUI.verifyTextPresent(expect_msg, false)
  WebUI.closeBrowser()
  return false
} else {
  System.out.println ("Tiếp tục")
}

Date objDate = new Date();
System.out.println(objDate.toString())
String strDateFormat = "HH:MM:ss  dd/MM/yyyy";
SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat)
System.out.println(objSDF.format(objDate))


SimpleDateFormat format = new SimpleDateFormat('HH:mm:ss dd/MM/yyyy')



Date d1 = null

Date d2 = null

try {
  d1 = format.parse(textngayGD)

  d2 = format.parse(objSDF.format(objDate))
}
catch (ParseException e) {
}
System.out.println('d1 ' + d1.getTime());
System.out.println('d2 ' + d2.getTime());

long diff = Math.abs(d2.getTime() - d1.getTime())
long diffSeconds = diff / 1000

System.out.println(('Số giây : ' + diffSeconds) + ' seconds.')

status=WebUI.getText(findTestObject('Page_Create Refund Request/status'))
loaiGD=WebUI.getText(findTestObject('Page_Create Refund Request/loaiGD'))
PTTT=WebUI.getText(findTestObject('Page_Create Refund Request/PTTT'))
thuonghieuthe=WebUI.getText(findTestObject('Page_Create Refund Request/thuonghieuthe'))
System.out.println (status)
System.out.println (loaiGD)
System.out.println (PTTT)
System.out.println (thuonghieuthe)
System.out.println('test dk '+ diffSeconds)

if (diffSeconds < 86400 && status=="Thành công" && loaiGD=="Thanh toán" && PTTT=="Thẻ quốc tế" ) {
  WebUI.verifyElementText(findTestObject('Page_Create Refund Request/p_The Transaction can be partially refunded after 24 hours of success'),
		'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

  WebUI.verifyElementChecked(findTestObject('Page_Create Refund Request/Page_To yu cu hon tin/Full refund checked'), 10)
		WebUI.verifyElementNotClickable(findTestObject('Page_Create Refund Request/Page_To yu cu hon tin/Partial disabled'))
		
		 textsotienmuonhoan=WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')
		  WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), "djfhjdfhjdfjdj")
		  textarea_reason= WebUI.getAttribute(findTestObject('Page_Create Refund Request/textarea__reason'), 'value')
			  if(textarea_reason!="") {
		  textgiatrigd1=WebUI.getAttribute(findTestObject('Page_Create Refund Request/Page_To yu cu hon tin/giatriGD1'), 'value')
		  System.out.println(textgiatrigd1)
		  giatrigd1 = 0
		  
		  giatrigd1 = textgiatrigd1.replace(',', '')
		  
		  System.out.println('gia tri GD: ' + giatrigd1)
		
		 textphithanhtoan= WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan1'), 'value')
		  textphixuly=WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly1'), 'value')
		 textsotiendahoan=WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan1'), 'value')
		  
		 
		  System.out.println(textsotiendahoan)
		  System.out.println(textsotienmuonhoan)
		  System.out.println(textphithanhtoan)
		  System.out.println(textphixuly)
		  sotienmuonhoan = 0
		  
		  sotienmuonhoan = textsotienmuonhoan.replace(',', '')
		  
		  System.out.println('số tiền muốn hoàn: ' + sotienmuonhoan)
		
		  phithanhtoan = 0
		  
		  phithanhtoan = textphithanhtoan.replace(',', '')
		  
		  System.out.println('phithanhtoan: ' + phithanhtoan)
		  
		  phixuly = 0
		  
		  phixuly = textphixuly.replace(',', '')
		  
		  System.out.println('phixuly: ' + phixuly)
		  
		  sotienmuonhoan=Integer.parseInt(sotienmuonhoan)
		  phithanhtoan=Integer.parseInt(phithanhtoan)
		  phixuly=Integer.parseInt(phixuly)
		  trusodu=sotienmuonhoan-phithanhtoan+phixuly
		  System.out.println ('trusodu:' +trusodu)
		   WebUI.verifyEqual(sotienmuonhoan, giatrigd1)
		WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))
		 WebUI.enableSmartWait()
		 confirm=WebUI.getText(findTestObject('Confirm'))
		 System.out.println ('Confirm: ' + confirm)
		  
		  if (trusodu<= Integer.parseInt(soduchodoisoat)) {
				WebUI.verifyTextPresent('Thêm mới yêu cầu hoàn tiên thành công', true)
				WebUI.click(findTestObject('menudashboard'))
				textsoduchodoisoat1=WebUI.getText(findTestObject('Page_Dashboard/soduchodoisoat'))
				System.out.println(textsoduchodoisoat1)
				a = 0
				
				a = textsoduchodoisoat1.replace(',', '')
				a=Integer.parseInt(a)
				System.out.println('Balance sau hoan: ' + a)
				System.out.println('trusoduMC: ' + (Integer.parseInt(soduchodoisoat) - trusodu))
				WebUI.verifyEqual((Integer.parseInt(soduchodoisoat) - trusodu), a)
				WebUI.closeBrowser()
                WebUI.openBrowser('https://stg-cms-payment.9pay.mobi/login')

WebUI.setText(findTestObject('Page_cms-payment - Login/input_usernameCMS'), 'admin@gmail.com')

WebUI.setText(findTestObject('Page_cms-payment - Login/input_passwwordCMS'), 'paygate@123')

WebUI.click(findTestObject('Page_cms-payment - Login/button_LoginCMS'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('f1/Page_Dashboard/a_module ychoantien'))

WebUI.click(findTestObject('f1/Page_Dashboard/a_Danh sch ch duyt'))

WebUI.enableSmartWait()

WebUI.setText(findTestObject('Page_Danh sch ch duyt yu cu hon tin/filter'), '63806199396618')

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/button_Timkiem'))

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/checkall'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/button_T chi'))

WebUI.setText(findTestObject('Page_Danh sch ch duyt yu cu hon tin/lydotuchoi'), 'tu choi GD')

WebUI.click(findTestObject('Page_Danh sch ch duyt yu cu hon tin/btn xacnhantuchoi'))

WebUI.enableSmartWait()


WebUI.closeBrowser()


				WebUI.openBrowser('https://stg-mcv2.9pay.mobi/')
				
						WebUI.maximizeWindow()
				
						WebUI.setText(findTestObject('Page_Account 9Pay/input_username'), "mch01")
				
						WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), "Abc@12345")
				
						WebUI.click(findTestObject('Page_Account 9Pay/button_login'))
						
						textsoduchodoisoattuchoi=WebUI.getText(findTestObject('Page_Dashboard/soduchodoisoat'))
						System.out.println(textsoduchodoisoattuchoi)
						soduchodoisoattuchoi = 0
						
						soduchodoisoattuchoi = textsoduchodoisoattuchoi.replace(',', '')
						
						System.out.println('Balance: ' + soduchodoisoattuchoi)
						WebUI.verifyEqual(Integer.parseInt(soduchodoisoattuchoi), Integer.parseInt(soduchodoisoat))
						WebUI.closeBrowser()
						
		  } else {
			  WebUI.verifyTextPresent('Số dư không đủ để tạo yêu cầu', true)
				return false
		  }}
		  else {WebUI.verifyTextPresent(expect_msg, false)
			  return false
		  }
}