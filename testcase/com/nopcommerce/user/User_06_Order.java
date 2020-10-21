package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.CheckoutPageObject;
import pageObject.nopcommerce.user.DesktopsPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.ProductDetailPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;
import pageObject.nopcommerce.user.SearchPageObject;
import pageObject.nopcommerce.user.ShoppingCartPageObject;

public class User_06_Order extends AbstractTest {
	WebDriver driver;
	SearchPageObject searchPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	DesktopsPageObject desktopsPage;
	ShoppingCartPageObject shoppingCartPage;
	ProductDetailPageObject productDetailPage;
	CheckoutPageObject checkoutPage;
	
	String firstName = "Automatic";
	String lastName = "FC";
	String email = "automation" + randomEmail() + ".vn@gmail.com";
	String company = "auto FC";
	String password = "123456";
	String confirmpassword = "123456";
	String orderNumber;
	String cityBillding="Ha Noi";
	String address1Billding="Hoan Kiem";
	String zipBillding="600000";
	String phoneBillding="0972111222";
	String country="Viet Nam";
	String cityShipping="Ha Nam";
	String address1Shipping="Le Loi";
	String zipShipping="500000";
	String phoneShipping="0912123123";
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
		registerPage.inputToDynamicByValueNameTextbox(driver, "FirstName", firstName);
		registerPage.inputToDynamicByValueNameTextbox(driver, "LastName", lastName);
		registerPage.inputToDynamicByValueNameTextbox(driver, "Email", email);
		registerPage.inputToDynamicByValueNameTextbox(driver, "Password", password);
		registerPage.inputToDynamicByValueNameTextbox(driver, "ConfirmPassword", confirmpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());
		homePage.clickToDynamicSubMenuByName(driver,"Computers", "Desktops");
		desktopsPage = PageGeneratorNopcommerceManager.getDesktopsPage(driver);
		desktopsPage.clickToPoductDetailByName(driver, "Build your own computer"); 
		productDetailPage =PageGeneratorNopcommerceManager.getProductDetailPage(driver);
	}
	@Test
	public void Order_01_Add_Product_To_Cart() {
		productDetailPage.selectItemInProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		productDetailPage.selectItemInRAMDropdown("8GB [+$60.00]");
		productDetailPage.selectItemInHDDRadioButton("400 GB [+$100.00]");
		productDetailPage.selectItemInOSRadioButton("Vista Premium [+$60.00]");
		productDetailPage.selectItemInSoftwareCheckbox("Microsoft Office [+$50.00]");
		productDetailPage.selectItemInSoftwareCheckbox("Acrobat Reader [+$10.00]");
		productDetailPage.selectItemInSoftwareCheckbox("Total Commander [+$5.00]");
		productDetailPage.clickToADDTOCARTButton();
		verifyTrue(productDetailPage.isMessageProductAddedCartSuccessDisplayed());
		productDetailPage.clickToCloseMessageProdoductAddedSuccessButton();
		productDetailPage.hoverToShoppingCartMenuHeader(driver);
		verifyTrue(productDetailPage.isItemInShoppingMiniCartDisplayed(driver,"1 item(s)"));
		verifyTrue(productDetailPage.isProductNameInShoppingMiniCartDisplayed(driver,"Build your own computer"));
		verifyTrue(productDetailPage.isProductInforDetailInShoppingMiniCartDisplayed(driver,"Processor: 2.5 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(productDetailPage.isProductRAMInYourCartDisplayed(driver,"RAM: 8GB [+$60.00]"));
		verifyTrue(productDetailPage.isProductHDDInYourCartDisplayed(driver,"HDD: 400 GB [+$100.00]"));
		verifyTrue(productDetailPage.isProductOSInYourCartDisplayed(driver,"OS: Vista Premium [+$60.00]"));
		verifyTrue(productDetailPage.isProductSoftwareInYourCartDisplayed(driver,"Software: Microsoft Office [+$50.00]"));
		verifyTrue(productDetailPage.isProductSoftwareInYourCartDisplayed(driver,"Software: Acrobat Reader [+$10.00]"));
		//verifyTrue(productDetailPage.isProductSoftwareInYourCartDisplayed(driver,"Software: Total Commander [+$5.00]"));
		verifyTrue(productDetailPage.isProductUnitPriceInYourCartDisplayed(driver,"$1,500.00"));
		verifyTrue(productDetailPage.isProductQuantityInYourCartDisplayed(driver,"1"));
		verifyTrue(productDetailPage.isProductSubToTalInYourCartDisplayed(driver,"$1,500.00"));
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
	}
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		shoppingCartPage.clickToEditProductLink();
		productDetailPage =PageGeneratorNopcommerceManager.getProductDetailPage(driver);
		productDetailPage.selectItemInProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectItemInRAMDropdown("4GB [+$20.00]");
		productDetailPage.selectItemInHDDRadioButton("320 GB");
		productDetailPage.selectItemInOSRadioButton("Vista Home [+$50.00]");
		productDetailPage.deselectItemInSoftwareCheckbox("Acrobat Reader [+$10.00]");
		productDetailPage.deselectItemInSoftwareCheckbox("Total Commander [+$5.00]");
		verifyTrue(productDetailPage.isProductPriceDisplayed("$1,320.00"));
		productDetailPage.inputQuantityTextbox("2");
		productDetailPage.clickToUPDATEButton();
		verifyTrue(productDetailPage.isMessageProductAddedCartSuccessDisplayed());
		productDetailPage.clickToCloseMessageProdoductAddedSuccessButton();
		productDetailPage.hoverToShoppingCartMenuHeader(driver);
		verifyTrue(	productDetailPage.isItemInShoppingMiniCartDisplayed(driver,"2 item(s)"));
	//	verifyTrue(	productDetailPage.isProductNameInYourCartDisplayed(driver,"Build your own computer"));
	//	verifyTrue(	productDetailPage.isProductProcessorInYourCartDisplayed(driver,"Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(productDetailPage.isProductRAMInYourCartDisplayed(driver,"RAM: 4GB [+$20.00]"));
		verifyTrue(productDetailPage.isProductHDDInYourCartDisplayed(driver,"HDD: 320 GB"));
		verifyTrue(productDetailPage.isProductOSInYourCartDisplayed(driver,"OS: Vista Home [+$50.00]"));
		//verifyTrue(productDetailPage.isProductSoftwareInYourCartDisplayed(driver,"Software: Microsoft Office [+$50.00]"));
		verifyTrue(productDetailPage.isProductUnitPriceInYourCartDisplayed(driver,"$1,320.00"));
		verifyTrue(productDetailPage.isProductQuantityInYourCartDisplayed(driver,"2"));
		verifyTrue(productDetailPage.isProductSubToTalInYourCartDisplayed(driver,"$2,640.00"));
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
		verifyTrue(	shoppingCartPage.isProductNameInShoppingCartDisplayed("Build your own computer"));
		verifyTrue(	shoppingCartPage.isProductProcessorInShoppingCartDisplayed("Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(	shoppingCartPage.isProductRAMInShoppingCartDisplayed("RAM: 4GB [+$20.00]"));
		verifyTrue(shoppingCartPage.isProductHDDInShoppingCartDisplayed("HDD: 320 GB"));
		verifyTrue(shoppingCartPage.isProductOSInShoppingCartDisplayed("OS: Vista Home [+$50.00]"));
		verifyTrue(shoppingCartPage.isProductSoftwareInShoppingCartDisplayed("Software: Microsoft Office [+$50.00]"));
		verifyTrue(shoppingCartPage.isProductUnitPriceInShoppingCartDisplayed("$1,320.00"));
		verifyEquals(shoppingCartPage.isProductQuantityInShoppingCartDisplayed("value"),"2");
		verifyTrue(shoppingCartPage.isProductToTalInYourCartDisplayed("$2,640.00"));
	}
	@Test
	public void Order_03_Remove_From_Cart() {
		shoppingCartPage.selectToRemoveCheckbox();
		shoppingCartPage.clickToUpdateShoppingCartButton();
		verifyTrue(shoppingCartPage.isMessageCartEmptyDisplayed("Your Shopping Cart is empty!"));
		verifyTrue(shoppingCartPage.isProductNameInYourCartUndisplayed("Build your own computer"));
		
	}
	@Test
	public void Order_04_Update_Shopping_Cart() {
		shoppingCartPage.clickToDynamicSubMenuByName(driver,"Computers", "Desktops");
		desktopsPage = PageGeneratorNopcommerceManager.getDesktopsPage(driver);
		desktopsPage.clickToPoductDetailByName(driver, "Lenovo IdeaCentre 600 All-in-One PC");
		productDetailPage = PageGeneratorNopcommerceManager.getProductDetailPage(driver);
		productDetailPage.clickToADDTOCARTButton();
		verifyTrue(productDetailPage.isMessageProductAddedCartSuccessDisplayed());
		productDetailPage.clickToCloseMessageProdoductAddedSuccessButton();
		productDetailPage.hoverToShoppingCartMenuHeader(driver);
		verifyTrue(productDetailPage.isItemInShoppingMiniCartDisplayed(driver,"1 item(s)"));
	//	verifyTrue(productDetailPage.isProductNameInYourCartDisplayed(driver,"Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(productDetailPage.isProductUnitPriceInYourCartDisplayed(driver,"$500.00"));
		verifyTrue(productDetailPage.isProductQuantityInYourCartDisplayed(driver,"1"));
		verifyTrue(productDetailPage.isProductSubToTalInYourCartDisplayed(driver,"$500.00"));
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
		shoppingCartPage.inputToQtyValue("5");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		verifyTrue(shoppingCartPage.isProductToTalInYourCartDisplayed("$2,500.00"));
		shoppingCartPage.selectToRemoveCheckbox();
		shoppingCartPage.clickToUpdateShoppingCartButton();
		verifyTrue(shoppingCartPage.isMessageCartEmptyDisplayed("Your Shopping Cart is empty!"));
	}
	@Test
	public void Order_05_Checkout_Cart() {
		shoppingCartPage.clickToDynamicSubMenuByName(driver,"Computers", "Notebooks");
		desktopsPage = PageGeneratorNopcommerceManager.getDesktopsPage(driver);
		desktopsPage.clickToPoductDetailByName(driver, "Apple MacBook Pro 13-inch");
		productDetailPage = PageGeneratorNopcommerceManager.getProductDetailPage(driver);
		productDetailPage.clickToADDTOCARTButton();
		verifyTrue(productDetailPage.isMessageProductAddedCartSuccessDisplayed());
		productDetailPage.clickToCloseMessageProdoductAddedSuccessButton();
		productDetailPage.hoverToShoppingCartMenuHeader(driver);
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
		shoppingCartPage.clickToAgreeTermsOfServiceCheckbox();
		shoppingCartPage.clickToCheckoutButton();
		
		checkoutPage =PageGeneratorNopcommerceManager.getCheckoutPage(driver);
		checkoutPage.deselectToShipToTheSameAddressCheckbox();
		checkoutPage.inputToDynamicBilldingAddressTextbox("First name", firstName);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Last name", lastName);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Email", email);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Company", company);
		checkoutPage.selectToCountryBillAddressDropdown("Country",country);
		checkoutPage.inputToDynamicBilldingAddressTextbox("City", cityBillding);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Address 1", address1Billding);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Zip", zipBillding);
		checkoutPage.inputToDynamicBilldingAddressTextbox("Phone number", phoneBillding);
		
		checkoutPage.clickToDynamicCheckoutContineButton("Billing address");
		checkoutPage.selectToNewAddressShippingDropdown("New Address");
		
		checkoutPage.inputToDynamicShippingAddressTextbox("First name", firstName);
		checkoutPage.inputToDynamicShippingAddressTextbox("Last name", lastName);
		checkoutPage.inputToDynamicShippingAddressTextbox("Email", email);
		checkoutPage.inputToDynamicShippingAddressTextbox("Company", company);
		checkoutPage.selectToCountryShippingAddressDropdown("Country",country);
		checkoutPage.inputToDynamicShippingAddressTextbox("City", cityShipping);
		checkoutPage.inputToDynamicShippingAddressTextbox("Address 1", address1Shipping);
		checkoutPage.inputToDynamicShippingAddressTextbox("Zip", zipShipping);
		checkoutPage.inputToDynamicShippingAddressTextbox("Phone number", phoneShipping);
		checkoutPage.clickToDynamicCheckoutContineButton("Shipping address");
		
		checkoutPage.selectToDynamicNameShippingMethodRadioButton("Ground");
		checkoutPage.clickToDynamicCheckoutContineButton("Shipping method");
		checkoutPage.selectToDynamicPaymentMethodRadioButton("Check / Money Order");
		checkoutPage.clickToDynamicCheckoutContineButton("Payment method");
		verifyTrue(checkoutPage.isPaymentInformationDisplayed());
		checkoutPage.clickToDynamicCheckoutContineButton("Payment information");
		
		
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("phone",phoneBillding));
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("address1",address1Billding));
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("city-state-zip",cityBillding +","+zipBillding));
		verifyTrue(checkoutPage.isDynamicBilldingInfodisplayed("country",country));
		
	
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("phone",phoneShipping));
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("address1",address1Shipping));
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("city-state-zip",cityShipping +","+ zipShipping));
		verifyTrue(checkoutPage.isDynamicShippingInfodisplayed("country",country));
		
		verifyTrue(checkoutPage.isPaymentMethodNameDisplayed("Check / Money Order"));
		verifyTrue(checkoutPage.isShippingMethodGroundDisplayed("Ground"));
		
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("sku","AP_MBP_13"));
		verifyTrue(checkoutPage.isConfirmOrderProductNameInfoDisplayed("product","Apple MacBook Pro 13-inch"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("unit-price","$1,800.00"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("quantity","2"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("subtotal","$3,600.00"));
		

//		checkoutPage.isSubTotalInCartInfoDisplayed("$3,600.00");
//		checkoutPage.isShippingGroundInCartInfoDisplayed("$0.00");
//		checkoutPage.isTaxInCartInfoDisplayed("$0.00");
//		checkoutPage.isTotalInCartInfoDisplayed("$3,600.00");
//		checkoutPage.clickToConfirmButton();
//		
//		checkoutPage.isMessageOrderSuccessDisplayed("Your order has been successfully processed!");
//		orderNumber = checkoutPage.getOrderNumber();
//		Assert.assertTrue(orderNumber);
//		checkoutPage.openMenuHeaderPageByPageName("My account");
//		checkoutPage.openToDynamicMenuPageListMyAccount("Order");
//		orderPage.isOrderNumberDisplayed("");
//		orderPage.clicktoDetailsLink();
//		orderDetailsPage.isOrderNumberDisplayed("");
//		orderDetailsPage.OrderDateDisplayed("Tuesday, October 06, 2020");
//		orderDetailsPage.OrderStatusDisplayed("Pending");
//		orderDetailsPage.OrderTotalDisplayed("$3,600.00");
//		
//		orderDetailsPage.isBillingAddressDisplayed("""""""""");
//		orderDetailsPage.isPaymentMethodCheckMoneyOrderDisplayed();
//		orderDetailsPage.isShippingAddressDisplayed();
//		orderDetailsPage.isShippingMethodGroundDisplayed();
//		orderDetailsPage.isShippingMethodGroundDisplayed();
//		orderDetailsPage.isProductSKUDisplayed();
//		orderDetailsPage.isProductNameisplayed("Apple MacBook Pro 13-inch");
//		orderDetailsPage.isProductPriceDisplayed("$1,800.00");
//		orderDetailsPage.isProductQtyDisplayed("2");
//		orderDetailsPage.isProductTotalDisplayed("$3,600.00");
//		
//		orderDetailsPage.isSubTotalInCartInfoDisplayed("$3,600.00");
//		orderDetailsPage.isShippingGroundInCartInfoDisplayed("$0.00");
//		orderDetailsPage.isTaxInCartInfoDisplayed("$0.00");
//		orderDetailsPage.isTotalInCartInfoDisplayed("$3,600.00");
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
