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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.urlVoila)

WebUI.waitForElementVisible(findTestObject('voila.id/Login/displayPopUp'), 15)

WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonClosePopUp'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonIconToLogin'))

WebUI.sendKeys(findTestObject('Object Repository/voila.id/Login/fieldEmail'), email)

WebUI.sendKeys(findTestObject('Object Repository/voila.id/Login/fieldPassword'), password)

WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonLogin'))

WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/tabMenCategory'), 0)

WebUI.click(findTestObject('voila.id/MenCollectionPage/tabMenCategory'))

WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/checkboxClothingCategory'), 1)

WebUI.scrollToPosition(300, 300)

WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/ImageOfProduct'), 0)

WebUI.click(findTestObject('voila.id/MenCollectionPage/checkboxClothingCategory'))

WebUI.delay(1)

WebUI.scrollToPosition(200, 200)

WebUI.delay(1)

WebUI.click(findTestObject('voila.id/MenCollectionPage/buttonSortby'))

WebUI.click(findTestObject('voila.id/MenCollectionPage/priceLowToHigh'))

WebUI.scrollToPosition(100, 350)

WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/titleOfProduct'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('voila.id/MenCollectionPage/titleOfProduct'))

WebUI.waitForElementVisible(findTestObject('voila.id/ProductDetails/pickSizeOfProduct'), 0)

WebUI.scrollToPosition(100, 160)

WebUI.delay(1)

WebUI.click(findTestObject('voila.id/ProductDetails/pickSizeOfProduct'))

WebUI.click(findTestObject('voila.id/ProductDetails/buttonKeranjang'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('voila.id/Checkout/scrollToLihatKeranjang'), 0)

WebUI.click(findTestObject('voila.id/Checkout/scrollToLihatKeranjang'))

WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/buttonCheckout'), 0)

WebUI.scrollToPosition(100, 150)

WebUI.click(findTestObject('voila.id/Checkout/buttonCheckout'))

WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/InformasiPengiriman/labelAlamatPengiriman'), 0)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldFirstName'), firstName)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/inputLastName'), lastName)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldAddress'), address)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldNotesForKurir'), notes)

WebUI.scrollToElement(findTestObject('voila.id/Checkout/buttonLanjutkanKePengiriman'), 0)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldKotaKecamatan'), kotaDanKecamatan)

WebUI.selectOptionByLabel(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPickProvince'), province, false)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPostalCode'), postalCode)

WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPhone'), phoneNumber)

WebUI.click(findTestObject('voila.id/Checkout/InformasiPengiriman/checkboxInfoBySMS'))

WebUI.click(findTestObject('voila.id/Checkout/buttonLanjutkanKePengiriman'))

WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/InformasiPengiriman/buttonLanjutkanPembayaran'), 0)

WebUI.click(findTestObject('voila.id/Checkout/InformasiPengiriman/buttonLanjutkanPembayaran'))

WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/buttonBayarSekarang'), 0)

WebUI.scrollToElement(findTestObject('voila.id/Checkout/buttonBayarSekarang'), 0)

WebUI.click(findTestObject('voila.id/Checkout/buttonBayarSekarang'))

WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/titleOfKartuKreditDebit'), 0)

