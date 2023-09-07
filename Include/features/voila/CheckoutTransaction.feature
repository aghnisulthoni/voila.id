#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Checkout 
  Make 1 transaction from login to checkout with specification: 
  product’s price below
  IDR 10.000.000 and product not in category BAG or WATCH
  
  @tag1
  Scenario Outline: successfully checkout an transaction
    Given User access the voila URL
    And User Click button close from popup alert
    When User Click button Account
    And User input <email> and <password> in the fields
    And User Click button Login
    Then User is on the homepage
    When User Click Tab Men on Top Navbar
    Then User is on Men Collection page
    And User Choose the Clothing Category
    And User Click button Sort By
    When User Choose the Price: low to high
    Then User can Choose the one of product with the lowest price
    And User Choose the Size
    When User Click button + Keranjang
    And User Click button Lihat Keranjang
    When User Click button Checkout
    Then User is on Informasi page
    And User input <firstName> and <lastName> and <address> and <kotaDanKecamatan> and <province> and <postalCode> and <phoneNumber>
    And User Checklist Terima info SMS resi pesanan & penawaran
    When User Click button Lanjutkan ke pengiriman
    Then User is on Pengiriman page
    When User Click button Lanjutkan ke pembayaran
    Then User is on Pembayaran page
    When User Click button Bayar Sekarang
    Then User do validation the payment on Midtrans
    
    Examples: 
      | email 		 	  					| password 		  	 | firstName	| lastName 		  | address 		 	 									 | kotaDanKecamatan 		   		 | province 		 									 | postalCode 		  | phoneNumber 		  |
      | aghnisulthoni@gmail.com | voilatesting123  | AGHNI 			| SULTHONI 		  | [AGHNI SULTHONI]-[Candidate QA]  | Jakarta Barat, Kebon Jeruk  | Daerah Khusus Ibukota Jakarta	 | 11510						| 085155332325			|