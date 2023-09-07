package com.voila
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CheckoutTransactionSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User access the voila URL")
	def theVoilaURL() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.urlVoila)
	}

	@When("User Click button close from popup alert")
	def clickButtonCloseFromPopUp() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Login/displayPopUp'), 15)
		WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonClosePopUp'))
		WebUI.delay(2)
	}

	@And("User Click button Account")
	def clickButtonAccount() {
		WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonIconToLogin'))
	}

	@When("User input (.*) and (.*) in the fields")
	def inputEmailAndPassword(String email, String password) {
		WebUI.sendKeys(findTestObject('Object Repository/voila.id/Login/fieldEmail'), email)
		WebUI.sendKeys(findTestObject('Object Repository/voila.id/Login/fieldPassword'), password)
	}
	
	@And("User Click button Login")
	def clickOnLoginButton() {
		WebUI.click(findTestObject('Object Repository/voila.id/Login/buttonLogin'))
	}
	
	@Then("User is on the homepage")
	def theMenIsVisible() {
		WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/tabMenCategory'), 0)
	}
	
	@And("User Click Tab Men on Top Navbar")
	def clickNavbarMen() {
		WebUI.click(findTestObject('voila.id/MenCollectionPage/tabMenCategory'))
	}

	@Then("User is on Men Collection page")
	def menCollectionPage() {
		WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/checkboxClothingCategory'), 1)
		WebUI.scrollToPosition(300, 300)
		WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/ImageOfProduct'), 0)
	}
	
	@And("User Choose the Clothing Category")
	def clickClothingCategory() {
		WebUI.click(findTestObject('voila.id/MenCollectionPage/checkboxClothingCategory'))
		WebUI.delay(1)
		WebUI.scrollToPosition(200, 200)
		WebUI.delay(1)
	}
	
	@And("User Click button Sort By")
	def clickButtonSortby() {
		WebUI.click(findTestObject('voila.id/MenCollectionPage/buttonSortby'))
	}
	
	@And("User Choose the Price: low to high")
	def priceLowtoHigh() {
		WebUI.click(findTestObject('voila.id/MenCollectionPage/priceLowToHigh'))
		WebUI.scrollToPosition(100, 350)
	}
	
	@Then("User can Choose the one of product with the lowest price")
	def chooseAnProduct() {
		WebUI.waitForElementVisible(findTestObject('voila.id/MenCollectionPage/titleOfProduct'), 0)
		WebUI.delay(2)
		WebUI.click(findTestObject('voila.id/MenCollectionPage/titleOfProduct'))
	}
	
	@And("User Choose the Size")
	def chooseTheSize() {
		WebUI.waitForElementVisible(findTestObject('voila.id/ProductDetails/pickSizeOfProduct'), 0)
		WebUI.scrollToPosition(100, 160)
		WebUI.delay(1)
		WebUI.click(findTestObject('voila.id/ProductDetails/pickSizeOfProduct'))
	}
	
	@And("User Click button + Keranjang")
	def clickAddToChart() {
		WebUI.click(findTestObject('voila.id/ProductDetails/buttonKeranjang'))
		WebUI.delay(1)
	}
	
	@And("User Click button Lihat Keranjang")
	def showChart() {
		WebUI.scrollToElement(findTestObject('voila.id/Checkout/scrollToLihatKeranjang'), 0)
		WebUI.click(findTestObject('voila.id/Checkout/scrollToLihatKeranjang'))
	}
	
	@When("User Click button Checkout")
	def clickButtonCheckout() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/buttonCheckout'), 0)
		WebUI.scrollToPosition(100, 150)
		WebUI.click(findTestObject('voila.id/Checkout/buttonCheckout'))
	}
	
	@Then("User is on Informasi page")
	def isOnInformasiPage() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/InformasiPengiriman/labelAlamatPengiriman'), 0)
	}
	
	@And("User input (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	def inputInformasiPengiriman(String firstName, String lastName, String address, String kotaDanKecamatan, String province, String postalCode, String phoneNumber) {
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldFirstName'), firstName)
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/inputLastName'), lastName)
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldAddress'), address)
		WebUI.scrollToElement(findTestObject('voila.id/Checkout/buttonLanjutkanKePengiriman'), 0)
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldKotaKecamatan'), kotaDanKecamatan)
		WebUI.selectOptionByLabel(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPickProvince'), province, false)
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPostalCode'), postalCode)
		WebUI.setText(findTestObject('voila.id/Checkout/InformasiPengiriman/fieldPhone'), phoneNumber)
	}

	@And("User Checklist Terima info SMS resi pesanan & penawaran")
	def checklistInfo() {
		WebUI.click(findTestObject('voila.id/Checkout/InformasiPengiriman/checkboxInfoBySMS'))
	}
	
	@When("User Click button Lanjutkan ke pengiriman")
	def clickButtonLanjutkanPengiriman() {
		WebUI.click(findTestObject('voila.id/Checkout/buttonLanjutkanKePengiriman'))
	}
	
	@Then("User is on Pengiriman page")
	def isOnPengirimanPage() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/buttonBayarSekarang'), 0)
		WebUI.scrollToElement(findTestObject('voila.id/Checkout/buttonBayarSekarang'), 0)
	}
	
	@When("User Click button Lanjutkan ke pembayaran")
	def clickButtonLanjutkanPembayaran() {
		WebUI.click(findTestObject('voila.id/Checkout/buttonBayarSekarang'))
	}
	
	@Then("User is on Pembayaran page")
	def isOnPembayaranPage() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/buttonBayarSekarang'), 0)
	}
	
	@When("User Click button Bayar Sekarang")
	def clickButtonbayarSekarang() {
		WebUI.click(findTestObject('voila.id/Checkout/buttonBayarSekarang'))
	}
	
	@Then("User do validation the payment on Midtrans")
	def isOnMidtransPage() {
		WebUI.waitForElementVisible(findTestObject('voila.id/Checkout/titleOfKartuKreditDebit'), 0)
	}
}