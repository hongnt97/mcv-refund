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
		WebUI.openBrowser('https://dev-mcv2.9pay.mobi/')

		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Page_Account 9Pay/input_username'),'mch2')

		WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), 'Abc@12345')

		WebUI.click(findTestObject('Page_Account 9Pay/button_login'))

		WebUI.click(findTestObject('Page_Dashboard/modulerefund'))

		WebUI.click(findTestObject('Page_Dashboard/a_Refund'))

		WebUI.click(findTestObject('Page_Refund Request List/button_Add'))

		WebUI.setText(findTestObject('Page_Create Refund Request/input__transactionid'), '62709466132899')

		WebUI.enableSmartWait()

WebUI.enableSmartWait()

textngayGD = WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

System.out.println(textngayGD)

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
System.out.println('d2 ' + d2);

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

if (diffSeconds < 86400 && status=="Thành công " && loaiGD=="Thanh toán" && PTTT=="Thẻ quốc tế" )
	{
	WebUI.verifyElementText(findTestObject('Page_Create Refund Request/p_The Transaction can be partially refunded after 24 hours of success'),
		'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

	WebUI.verifyElementChecked(findTestObject('Page_Create Refund Request/Full refund'), 10)

	WebUI.verifyElementClickable(findTestObject('Page_To yu cu hon tin/hon 1 phn'))

	WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

	WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))

	WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))

	WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))

	WebUI.getText(findTestObject('Page_Create Refund Request/sotienmuonhoan'))

	WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))

	WebUI.verifyMatch(giatrigd, sotienmuonhoan, false)

	WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

	WebUI.enableSmartWait()
}
else if (diffSeconds< 86400 && status=="Thành công " && loaiGD=="Thanh toán" && PTTT=="Thẻ nội địa" && thuonghieuthe=="MB") {
	
  WebUI.verifyElementText(findTestObject('Page_Create Refund Request/p_The Transaction can be partially refunded after 24 hours of success'),
		'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

	WebUI.verifyElementChecked(findTestObject('Page_Create Refund Request/Full refund'), 10)

	WebUI.verifyElementClickable(findTestObject('Page_To yu cu hon tin/hon 1 phn'))

	WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

	WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))

	WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))

	WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))

	WebUI.getText(findTestObject('Page_Create Refund Request/sotienmuonhoan'))

	WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))

	WebUI.verifyMatch(giatrigd, sotienmuonhoan, false)

	WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

	WebUI.enableSmartWait() }
else if(diffSeconds< 86400 && status=="Thành công " && loaiGD=="Thanh toán" && PTTT!="Thẻ nội địa" ) {
	WebUI.click(findTestObject('Page_Create Refund Request/Partial refund'))
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/sotienmuonhoan'), '10000')
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')
	
	  giatrigd=WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))
	
	 phithanhtoan= WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))
	  phixuly=WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))
	 sotiendahoan=WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))
	  
	  System.out.println(giatrigd)
	  System.out.println(sotiendahoan)
	 WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))
	 WebUI.enableSmartWait()}
else if(diffSeconds< 86400 && status=="Thành công " && loaiGD=="Thanh toán" && PTTT!="Thẻ quốc tế" ) {
	WebUI.click(findTestObject('Page_Create Refund Request/Partial refund'))
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/sotienmuonhoan'), '10000')
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')
	
	  giatrigd=WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))
	
	 phithanhtoan= WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))
	  phixuly=WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))
	 sotiendahoan=WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))
	  
	  System.out.println(giatrigd)
	  System.out.println(sotiendahoan)
	 WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))
	 WebUI.enableSmartWait()}
else if(diffSeconds< 86400 && status=="Thành công " && loaiGD=="Thanh toán" && PTTT=="Thẻ nội địa"&& PTTT!="MB" ) {
	WebUI.click(findTestObject('Page_Create Refund Request/Partial refund'))
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/sotienmuonhoan'), '10000')
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')
	
	  giatrigd=WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))
	
	 phithanhtoan= WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))
	  phixuly=WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))
	 sotiendahoan=WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))
	  
	  System.out.println(giatrigd)
	  System.out.println(sotiendahoan)
	 WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))
	 WebUI.enableSmartWait()}
else if(diffSeconds >= 86400 && status=="Thành công" && loaiGD=="Thanh toán") {
	WebUI.click(findTestObject('Page_Create Refund Request/Partial refund'))
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/sotienmuonhoan'), '10000')
	
	  WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')
	
	  giatrigd=WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))
	
	 phithanhtoan= WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))
	  phixuly=WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))
	 sotiendahoan=WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))
	  
	  System.out.println(giatrigd)
	  System.out.println(sotiendahoan)
	 WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))
	 WebUI.enableSmartWait()}
else {
	System.out.println('còn nại');
}

	
   
	
	

   
	 
	
	
	
	
   