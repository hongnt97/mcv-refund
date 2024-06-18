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
import java.time.Period as Period
import java.time.Duration as Duration

WebUI.openBrowser('https://stg-mcv2.9pay.mobi/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Account 9Pay/input_username'), 'mch01')

WebUI.setText(findTestObject('Page_Account 9Pay/input_password'), 'Abc@12345')

WebUI.click(findTestObject('Page_Account 9Pay/button_login'))

textsoduchodoisoat = WebUI.getText(findTestObject('Page_Dashboard/soduchodoisoat'))

System.out.println(textsoduchodoisoat)

soduchodoisoat = 0

soduchodoisoat = textsoduchodoisoat.replace(',', '')

System.out.println('Balance: ' + soduchodoisoat)

WebUI.click(findTestObject('Page_Dashboard/modulerefund'))

WebUI.click(findTestObject('Page_Dashboard/a_Refund'))

WebUI.click(findTestObject('Page_Refund Request List/button_Add'))

WebUI.setText(findTestObject('Page_Create Refund Request/input__transactionid'), '63249464122280')

WebUI.enableSmartWait()

textngayGD = WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

WebUI.getText(findTestObject('Page_Create Refund Request/ngayGD'))

System.out.println(textngayGD)

if (textngayGD == '—') {
    WebUI.verifyTextPresent(expect_msg, false)

    WebUI.closeBrowser()

    return false
} else {
    System.out.println('Tiếp tục')
}

Date objDate = new Date()

System.out.println(objDate.toString())

String strDateFormat = 'HH:MM:ss  dd/MM/yyyy'

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

System.out.println('d1 ' + d1.getTime())

System.out.println('d2 ' + d2.getTime())

long diff = Math.abs(d2.getTime() - d1.getTime())

long diffSeconds = diff / 1000

System.out.println(('Số giây : ' + diffSeconds) + ' seconds.')

status = WebUI.getText(findTestObject('Page_Create Refund Request/status'))

loaiGD = WebUI.getText(findTestObject('Page_Create Refund Request/loaiGD'))

PTTT = WebUI.getText(findTestObject('Page_Create Refund Request/PTTT'))

thuonghieuthe = WebUI.getText(findTestObject('Page_Create Refund Request/thuonghieuthe'))

System.out.println(status)

System.out.println(loaiGD)

System.out.println(PTTT)

System.out.println(thuonghieuthe)

System.out.println('test dk ' + diffSeconds)

if ((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Thẻ quốc tế')) {
    WebUI.verifyElementText(findTestObject('/Page_To yu cu hon tin/Page_To yu cu hon tin'), 'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

    WebUI.verifyElementChecked(findTestObject('Page_To yu cu hon tin/Full refund'), 10)

    WebUI.verifyElementClickable(findTestObject('Page_To yu cu hon tin/Partial refund'))

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatriGD1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan1'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly1'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan1'), 'value')

    System.out.println(textsotiendahoan)

    System.out.println(textphithanhtoan)

    System.out.println(textphixuly)

    System.out.println(textsotienmuonhoan)

    sotienmuonhoan = 0

    sotienmuonhoan = textsotienmuonhoan.replace(',', '')

    System.out.println('số tiền muốn hoàn: ' + sotienmuonhoan)

    phithanhtoan = 0

    phithanhtoan = textphithanhtoan.replace(',', '')

    System.out.println('phithanhtoan: ' + phithanhtoan)

    phixuly = 0

    phixuly = textphixuly.replace(',', '')

    System.out.println('phixuly: ' + phixuly)

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if (((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Thẻ nội địa')) && 
(thuonghieuthe == 'MB')) {
    WebUI.verifyElementText(findTestObject('Page_Create Refund Request'), 'Giao dịch có thể tạo hoàn 1 phần sau 24 giờ giao dịch thành công.')

    WebUI.verifyElementChecked(findTestObject('Page_To yu cu hon tin/Full refund'), 10)

    WebUI.verifyElementClickable(findTestObject('Page_To yu cu hon tin/Partial refund'))

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatriGD1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan1'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly1'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan1'), 'value')

    System.out.println(textsotiendahoan)

    System.out.println(textphithanhtoan)

    System.out.println(textphixuly)

    System.out.println(textsotienmuonhoan)

    sotienmuonhoan = 0

    sotienmuonhoan = textsotienmuonhoan.replace(',', '')

    System.out.println('số tiền muốn hoàn: ' + sotienmuonhoan)

    phithanhtoan = 0

    phithanhtoan = textphithanhtoan.replace(',', '')

    System.out.println('phithanhtoan: ' + phithanhtoan)

    phixuly = 0

    phixuly = textphixuly.replace(',', '')

    System.out.println('phixuly: ' + phixuly)

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if ((diffSeconds < 86400) && (status != 'Thành công')) {
    System.out.println('Kết thúc')
} else if ((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Ví điện tử')) {
    WebUI.verifyElementChecked(findTestObject('Page_Create Refund Request/Partial refund'), 10)

    WebUI.verifyElementNotClickable(findTestObject('Page_Create Refund Request/Partial refund'))

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatrigd1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan'), 'value')

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

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if ((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Apple Pay')) {
    WebUI.verifyElementChecked(findTestObject('Page_To yu cu hon tin/Full refund'), 10)

    WebUI.verifyElementNotClickable(findTestObject('Page_To yu cu hon tin/Partial refund'))

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatrigd1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan'), 'value')

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

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if ((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Chuyển khoản ngân hàng')) {
    WebUI.verifyElementChecked(findTestObject('Page_To yu cu hon tin/Full refund'), 10)

    WebUI.verifyElementNotClickable(findTestObject('Page_To yu cu hon tin/Partial refund1'))

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatrigd1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan'), 'value')

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

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_To yu cu hon tin/nganhangchuyenkhoan'))

    WebUI.click(findTestObject('Page_To yu cu hon tin/VCB'))

    WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/sotaikhoan'), '1234565')

    WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/hoten'), 'HONG')

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if ((((diffSeconds < 86400) && (status == 'Đã nhậ tiền')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Chuyển khoản ngân hàng')) {
    WebUI.verifyElementChecked(findTestObject('Page_To yu cu hon tin/Full refund1'), 10)

    WebUI.verifyElementNotClickable(findTestObject('Page_To yu cu hon tin/Partial refund'))

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatrigd1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan'), 'value')

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

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.verifyEqual(sotienmuonhoan, giatrigd1)

    WebUI.click(findTestObject('Page_To yu cu hon tin/nganhangchuyenkhoan'))

    WebUI.click(findTestObject('Page_To yu cu hon tin/VCB'))

    WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/sotaikhoan'), '1234565')

    WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/hoten'), 'HONG')

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if (((((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD == 'Thanh toán')) && (PTTT == 'Thẻ nội địa')) && 
(thuonghieuthe != 'MB')) {
    WebUI.click(findTestObject('Page_Create Refund Request/Partial refund'))

    WebUI.setText(findTestObject('Page_Create Refund Request/sotienmuonhoan'), '10000')

    textsotienmuonhoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), 'value')

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    textgiatrigd1 = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/giatrigd1'), 'value')

    System.out.println(textgiatrigd1)

    giatrigd1 = 0

    giatrigd1 = textgiatrigd1.replace(',', '')

    System.out.println('gia tri GD: ' + giatrigd1)

    textphithanhtoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan'), 'value')

    textphixuly = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly'), 'value')

    textsotiendahoan = WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan'), 'value')

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

    sotienmuonhoan = Integer.parseInt(sotienmuonhoan)

    phithanhtoan = Integer.parseInt(phithanhtoan)

    phixuly = Integer.parseInt(phixuly)

    trusodu = ((sotienmuonhoan - phithanhtoan) + phixuly)

    System.out.println('trusodu:' + trusodu)

    if (trusodu <= Integer.parseInt(soduchodoisoat)) {
        System.out.println('Hoàn tiền thành công')
    } else {
        System.out.println('Số dư không đủ')

        return false
    }
    
    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()

    WebUI.setText(findTestObject('Page_Create Refund Request/textarea__reason'), 'hoan tien GD auto')

    giatrigd = WebUI.getText(findTestObject('Page_Create Refund Request/giatrigd'))

    phithanhtoan = WebUI.getText(findTestObject('Page_Create Refund Request/phithanhtoan'))

    phixuly = WebUI.getText(findTestObject('Page_Create Refund Request/phixuly'))

    sotiendahoan = WebUI.getText(findTestObject('Page_Create Refund Request/sotiendahoan'))

    System.out.println(giatrigd)

    System.out.println(sotiendahoan)

    WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

    WebUI.enableSmartWait()
} else if (((diffSeconds < 86400) && (status == 'Thành công')) && (loaiGD != 'Thanh toán')) {
    System.out.println('Kết thúc')
} else if (((diffSeconds >= 86400) && (status == 'Thành công')) && (loaiGD != 'Thanh toán')) {
    System.out.println('Kết thúc')
} else if ((diffSeconds >= 86400) && (status != 'Thành công')) {
    System.out.println('Kết thúc')
} else {
    System.out.println('Còn lại')
}

WebUI.verifyElementNotClickable(findTestObject(null))

WebUI.getAttribute(findTestObject('Page_Create Refund Request/Page_To yu cu hon tin/giatriGD1'), '')

WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phixuly1'), '')

WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/phithanhtoan1'), '')

WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotiendahoan1'), '')

WebUI.getAttribute(findTestObject('Page_To yu cu hon tin/sotienmuonhoan1'), '')

WebUI.click(findTestObject('Page_To yu cu hon tin/ngan hang chuyen khoan'))

WebUI.click(findTestObject('Page_To yu cu hon tin/vcb'))

WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/hoten'), 'Hong')

WebUI.setText(findTestObject('f1/Page_To yu cu hon tin/sotaikhoan'), '123456')

WebUI.getText(findTestObject('Confirm'))

WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

WebUI.verifyTextPresent('Thêm mới yêu cầu hoàn tiên thành công', true)

WebUI.verifyElementText(findTestObject('Page_Create Refund Request/p_The Transaction can be partially refunded after 24 hours of success'), 
    '')

WebUI.click(findTestObject('Page_Create Refund Request/button_Send Request'))

WebUI.verifyTextPresent('', false)

WebUI.getAttribute(findTestObject(null), '')

