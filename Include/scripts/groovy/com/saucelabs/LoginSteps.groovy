package com.saucelabs
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



class LoginSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("The saucelabs URL")
	def theSaucelabsURL() {
		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.urlSauceLabs)
	}

	@When("I input (.*) and (.*) in the fields")
	def inputUsernameAndPwd(String username, String password) {
		WebUI.waitForElementPresent(findTestObject('sauceLabs/loginScreen/fieldUsername'), 0)

		WebUI.sendKeys(findTestObject('sauceLabs/loginScreen/fieldUsername'), username)

		WebUI.sendKeys(findTestObject('sauceLabs/loginScreen/fieldPassword'), password)
	}

	@And("I click on the signin button")
	def clickOnSigninButton() {
		WebUI.click(findTestObject('sauceLabs/loginScreen/btnLogin'))
	}

	@Then("the burger menu button will be displayed")
	def burgerMenuWillBeDisplayed() {
		WebUI.waitForElementVisible(findTestObject('sauceLabs/loginScreen/btnBurgerMenu'), 0)

		WebUI.closeBrowser()
	}
}