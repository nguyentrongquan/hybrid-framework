package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.CheckoutPageObject;
import pageObject.nopcommerce.user.CustomerInfoPageObject;
import pageObject.nopcommerce.user.DesktopsPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.NotebooksPageObject;
import pageObject.nopcommerce.user.OrderDetailPageObject;
import pageObject.nopcommerce.user.OrderPageObject;
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
	CustomerInfoPageObject customerInfoPage;
	OrderPageObject orderPage;
	OrderDetailPageObject orderDetailsPage;
	NotebooksPageObject notebooksPage;
	
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
		registerPage.clickToDynamicSubMenuByName(driver,"Computers", "Desktops");
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
		verifyTrue(productDetailPage.isProductRAMInShoppingMiniCartDisplayed(driver,"RAM: 8GB [+$60.00]"));
		verifyTrue(productDetailPage.isProductHDDInShoppingMiniCartDisplayed(driver,"HDD: 400 GB [+$100.00]"));
		verifyTrue(productDetailPage.isProductOSInShoppingMiniCartDisplayed(driver,"OS: Vista Premium [+$60.00]"));
		verifyTrue(productDetailPage.isProductSoftwareInShoppingMiniCartDisplayed(driver,"Software: Microsoft Office [+$50.00]"));
		verifyTrue(productDetailPage.isProductSoftwareInShoppingMiniCartDisplayed(driver,"Software: Acrobat Reader [+$10.00]"));
	//	verifyTrue(productDetailPage.isProductSoftwareInShoppingMiniCartDisplayed(driver,"Software: Total Commander [+$5.00]"));
		verifyTrue(productDetailPage.isProductUnitPriceInShoppingMiniCartDisplayed(driver,"$1,500.00"));
		verifyTrue(productDetailPage.isProductQuantityInShoppingMiniCartDisplayed(driver,"1"));
		verifyTrue(productDetailPage.isProductSubToTalInShoppingMiniCartDisplayed(driver,"$1,500.00"));
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
	}
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		productDetailPage = shoppingCartPage.clickToEditProductLink();
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
		verifyTrue(	productDetailPage.isProductNameInShoppingMiniCartDisplayed(driver,"Build your own computer"));
		verifyTrue(	productDetailPage.isProductInforDetailInShoppingMiniCartDisplayed(driver,"Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(productDetailPage.isProductRAMInShoppingMiniCartDisplayed(driver,"RAM: 4GB [+$20.00]"));
		verifyTrue(productDetailPage.isProductHDDInShoppingMiniCartDisplayed(driver,"HDD: 320 GB"));
		verifyTrue(productDetailPage.isProductOSInShoppingMiniCartDisplayed(driver,"OS: Vista Home [+$50.00]"));
		//verifyTrue(productDetailPage.isProductSoftwareInShoppingMiniCartDisplayed(driver,"Software: Microsoft Office [+$50.00]"));
		verifyTrue(productDetailPage.isProductUnitPriceInShoppingMiniCartDisplayed(driver,"$1,320.00"));
		verifyTrue(productDetailPage.isProductQuantityInShoppingMiniCartDisplayed(driver,"2"));
		verifyTrue(productDetailPage.isProductSubToTalInShoppingMiniCartDisplayed(driver,"$2,640.00"));
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
		verifyTrue(	shoppingCartPage.isProductNameInShoppingCartDisplayed("Build your own computer"));
		verifyTrue(	shoppingCartPage.isProductProcessorInShoppingCartDisplayed("Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(	shoppingCartPage.isProductRAMInShoppingCartDisplayed("RAM: 4GB [+$20.00]"));
		verifyTrue(shoppingCartPage.isProductHDDInShoppingCartDisplayed("HDD: 320 GB"));
		verifyTrue(shoppingCartPage.isProductOSInShoppingCartDisplayed("OS: Vista Home [+$50.00]"));
		//verifyTrue(shoppingCartPage.isProductSoftwareInShoppingCartDisplayed("Software: Microsoft Office [+$50.00]"));
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
		verifyTrue(productDetailPage.isProductNameInShoppingMiniCartDisplayed(driver,"Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(productDetailPage.isProductUnitPriceInShoppingMiniCartDisplayed(driver,"$500.00"));
		verifyTrue(productDetailPage.isProductQuantityInShoppingMiniCartDisplayed(driver,"1"));
		verifyTrue(productDetailPage.isProductSubToTalInShoppingMiniCartDisplayed(driver,"$500.00"));
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
		notebooksPage = PageGeneratorNopcommerceManager.getNotebooksPage(driver);
		notebooksPage.clickToPoductDetailByName(driver, "Apple MacBook Pro 13-inch");
		productDetailPage = PageGeneratorNopcommerceManager.getProductDetailPage(driver);
		productDetailPage.clickToADDTOCARTButton();
		verifyTrue(productDetailPage.isMessageProductAddedCartSuccessDisplayed());
		productDetailPage.clickToCloseMessageProdoductAddedSuccessButton();
		productDetailPage.hoverToShoppingCartMenuHeader(driver);
		productDetailPage.clickToGoToCartButton(driver);
		shoppingCartPage = PageGeneratorNopcommerceManager.getShoppingCartPage(driver);
		shoppingCartPage.clickToAgreeTermsOfServiceCheckbox();
		checkoutPage = shoppingCartPage.clickToCheckoutButton();
		
		checkoutPage.deselectToShipToTheSameAddressCheckbox();
		checkoutPage.inputToBilldingAddressTextbox("First name", firstName);
		checkoutPage.inputToBilldingAddressTextbox("Last name", lastName);
		checkoutPage.inputToBilldingAddressTextbox("Email", email);
		checkoutPage.inputToBilldingAddressTextbox("Company", company);
		checkoutPage.selectToCountryBillAddressDropdown("Country",country);
		checkoutPage.inputToBilldingAddressTextbox("City", cityBillding);
		checkoutPage.inputToBilldingAddressTextbox("Address 1", address1Billding);
		checkoutPage.inputToBilldingAddressTextbox("Zip", zipBillding);
		checkoutPage.inputToBilldingAddressTextbox("Phone number", phoneBillding);
		
		checkoutPage.clickToCheckoutContineButton("Billing address");
		checkoutPage.selectToNewAddressShippingDropdown("New Address");
		
		checkoutPage.inputToShippingAddressTextbox("First name", firstName);
		checkoutPage.inputToShippingAddressTextbox("Last name", lastName);
		checkoutPage.inputToShippingAddressTextbox("Email", email);
		checkoutPage.inputToShippingAddressTextbox("Company", company);
		checkoutPage.selectToCountryShippingAddressDropdown("Country",country);
		checkoutPage.inputToShippingAddressTextbox("City", cityShipping);
		checkoutPage.inputToShippingAddressTextbox("Address 1", address1Shipping);
		checkoutPage.inputToShippingAddressTextbox("Zip", zipShipping);
		checkoutPage.inputToShippingAddressTextbox("Phone number", phoneShipping);
		checkoutPage.clickToCheckoutContineButton("Shipping address");
		
		checkoutPage.selectToNameShippingMethodRadioButton("Ground");
		checkoutPage.clickToCheckoutContineButton("Shipping method");
		checkoutPage.selectToPaymentMethodRadioButton("Check / Money Order");
		checkoutPage.clickToCheckoutContineButton("Payment method");
		verifyTrue(checkoutPage.isPaymentInformationDisplayed());
		checkoutPage.clickToCheckoutContineButton("Payment information");
		
		
		verifyTrue(checkoutPage.isBilldingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("phone",phoneBillding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("address1",address1Billding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("city-state-zip",cityBillding +","+zipBillding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("country",country));
		
	
		verifyTrue(checkoutPage.isShippingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isShippingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isShippingInfodisplayed("phone",phoneShipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("address1",address1Shipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("city-state-zip",cityShipping +","+ zipShipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("country",country));
		
		verifyTrue(checkoutPage.isPaymentMethodNameDisplayed("Check / Money Order"));
		verifyTrue(checkoutPage.isShippingMethodGroundDisplayed("Ground"));
		
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("sku","AP_MBP_13"));
		verifyTrue(checkoutPage.isConfirmOrderProductNameInfoDisplayed("product","Apple MacBook Pro 13-inch"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("unit-price","$1,800.00"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("quantity","2"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("subtotal","$3,600.00"));
		
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Sub-Total","$3,600.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Shipping","$0.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Tax","$0.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Total","$3,600.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("You will earn","360 points"));
		checkoutPage.clickToConfirmButton();
		
		verifyTrue(checkoutPage.isMessageOrderSuccessDisplayed("Your order has been successfully processed!"));
	//	orderNumber = checkoutPage.getOrderNumber();
		
		checkoutPage.openMenuHeaderPageByPageName(driver,"My account");
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerPage(driver);
		customerInfoPage.openToDynamicMenuPageListMyAccount(driver, "Orders");
		orderPage = PageGeneratorNopcommerceManager.getOrderPage(driver);
		//verifyTrue(orderPage.isOrderNumberDisplayed(orderNumber));
		orderDetailsPage = orderPage.clicktoDetailsLink();
		
		//orderDetailsPage.isOrderNumberDisplayed("");
//		verifyTrue(orderDetailsPage.isOrderDateDisplayed("Wednesday, October 21, 2020"));
		verifyTrue(orderDetailsPage.isOrderStatusDisplayed("Pending"));
		verifyTrue(orderDetailsPage.isOrderTotalDisplayed("$3,600.00"));
		
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("name",firstName+" "+lastName));
		//verifyTrue(orderDetailsPage.isBilldingInfodisplayed("email",email));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("phone",phoneBillding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("address1",address1Billding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("city-state-zip",cityBillding +","+zipBillding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("country",country));
		
	
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("name",firstName+" "+lastName));
		//verifyTrue(orderDetailsPage.isShippingInfodisplayed("email",email));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("phone",phoneShipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("address1",address1Shipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("city-state-zip",cityShipping +","+ zipShipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("country",country));
		
		verifyTrue(orderDetailsPage.isPaymentMethodNameDisplayed("Check / Money Order"));
		verifyTrue(orderDetailsPage.isShippingMethodGroundDisplayed("Ground"));
		
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("sku","AP_MBP_13"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductNameInfoDisplayed("product","Apple MacBook Pro 13-inch"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("unit-price","$1,800.00"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("quantity","2"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("total","$3,600.00"));
		
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Sub-Total","$3,600.00"));
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Shipping","$0.00"));
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Tax","$0.00"));
		verifyTrue(orderDetailsPage.isCartOrderTotalInforDisplayed("Order Total","$3,600.00"));
		
	}
	@Test
	public void Order_06_Checkout_Cart_Payment_Method_By_Card() {
		orderDetailsPage.clickToDynamicSubMenuByName(driver,"Computers", "Notebooks");
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
		checkoutPage = shoppingCartPage.clickToCheckoutButton();
		
//		checkoutPage.deselectToShipToTheSameAddressCheckbox();
//		checkoutPage.inputToBilldingAddressTextbox("First name", firstName);
//		checkoutPage.inputToBilldingAddressTextbox("Last name", lastName);
//		checkoutPage.inputToBilldingAddressTextbox("Email", email);
//		checkoutPage.inputToBilldingAddressTextbox("Company", company);
//		checkoutPage.selectToCountryBillAddressDropdown("Country",country);
//		checkoutPage.inputToBilldingAddressTextbox("City", cityBillding);
//		checkoutPage.inputToBilldingAddressTextbox("Address 1", address1Billding);
//		checkoutPage.inputToBilldingAddressTextbox("Zip", zipBillding);
//		checkoutPage.inputToBilldingAddressTextbox("Phone number", phoneBillding);
		
		checkoutPage.clickToCheckoutContineButton("Billing address");
//		checkoutPage.selectToNewAddressShippingDropdown("New Address");
//		
//		checkoutPage.inputToShippingAddressTextbox("First name", firstName);
//		checkoutPage.inputToShippingAddressTextbox("Last name", lastName);
//		checkoutPage.inputToShippingAddressTextbox("Email", email);
//		checkoutPage.inputToShippingAddressTextbox("Company", company);
//		checkoutPage.selectToCountryShippingAddressDropdown("Country",country);
//		checkoutPage.inputToShippingAddressTextbox("City", cityShipping);
//		checkoutPage.inputToShippingAddressTextbox("Address 1", address1Shipping);
//		checkoutPage.inputToShippingAddressTextbox("Zip", zipShipping);
//		checkoutPage.inputToShippingAddressTextbox("Phone number", phoneShipping);
		
		checkoutPage.clickToCheckoutContineButton("Shipping address");
		
		checkoutPage.selectToNameShippingMethodRadioButton("Ground");
		checkoutPage.clickToCheckoutContineButton("Shipping method");
		checkoutPage.selectToPaymentMethodRadioButton("Credit Card");
		checkoutPage.clickToCheckoutContineButton("Payment method");
		
		checkoutPage.selectToCreditCardDropdown("Visa");
		checkoutPage.inputToCardholderNameTextbox("DE16528837768273746040");
		checkoutPage.inputToCardNumberTextbox("4778504544156287");
		checkoutPage.selectToExpirationMonthDropdown("01");
		checkoutPage.selectToExpirationYearDropdown("2021");
		checkoutPage.inputToCardCodeTextbox("338");
		
		checkoutPage.clickToCheckoutContineButton("Payment information");
		
		
		verifyTrue(checkoutPage.isBilldingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("phone",phoneBillding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("address1",address1Billding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("city-state-zip",cityBillding +","+zipBillding));
		verifyTrue(checkoutPage.isBilldingInfodisplayed("country",country));
		
	
		verifyTrue(checkoutPage.isShippingInfodisplayed("name",firstName+" "+lastName));
		verifyTrue(checkoutPage.isShippingInfodisplayed("email",email));
		verifyTrue(checkoutPage.isShippingInfodisplayed("phone",phoneShipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("address1",address1Shipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("city-state-zip",cityShipping +","+ zipShipping));
		verifyTrue(checkoutPage.isShippingInfodisplayed("country",country));
		
		verifyTrue(checkoutPage.isPaymentMethodNameDisplayed("Credit Card"));
		verifyTrue(checkoutPage.isShippingMethodGroundDisplayed("Ground"));
		
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("sku","AP_MBP_13"));
		verifyTrue(checkoutPage.isConfirmOrderProductNameInfoDisplayed("product","Apple MacBook Pro 13-inch"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("unit-price","$1,800.00"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("quantity","2"));
		verifyTrue(checkoutPage.isConfirmOrderProductInfoDisplayed("subtotal","$3,600.00"));
		
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Sub-Total","$3,600.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Shipping","$0.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Tax","$0.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("Total","$3,600.00"));
		verifyTrue(checkoutPage.isCartTotalInforDisplayed("You will earn","360 points"));
		checkoutPage.clickToConfirmButton();
		
		verifyTrue(checkoutPage.isMessageOrderSuccessDisplayed("Your order has been successfully processed!"));
		orderNumber = checkoutPage.getOrderNumber();
		
		checkoutPage.openMenuHeaderPageByPageName(driver, "My account");
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerPage(driver);
		customerInfoPage.openToDynamicMenuPageListMyAccount(driver, "Orders");
		orderPage = PageGeneratorNopcommerceManager.getOrderPage(driver);
		//verifyTrue(orderPage.isOrderNumberDisplayed(orderNumber));
		orderDetailsPage = orderPage.clicktoDetailsLink();
		
		//orderDetailsPage.isOrderNumberDisplayed("");
//		verifyTrue(orderDetailsPage.isOrderDateDisplayed("Wednesday, October 21, 2020"));
		verifyTrue(orderDetailsPage.isOrderStatusDisplayed("Pending"));
		verifyTrue(orderDetailsPage.isOrderTotalDisplayed("$3,600.00"));
		
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("name",firstName+" "+lastName));
		//verifyTrue(orderDetailsPage.isBilldingInfodisplayed("email",email));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("phone",phoneBillding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("address1",address1Billding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("city-state-zip",cityBillding +","+zipBillding));
		verifyTrue(orderDetailsPage.isBilldingInfodisplayed("country",country));
	
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("name",firstName+" "+lastName));
		//verifyTrue(orderDetailsPage.isShippingInfodisplayed("email",email));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("phone",phoneShipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("address1",address1Shipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("city-state-zip",cityShipping +","+ zipShipping));
		verifyTrue(orderDetailsPage.isShippingInfodisplayed("country",country));
		
		verifyTrue(orderDetailsPage.isPaymentMethodNameDisplayed("Credit Card"));
		verifyTrue(orderDetailsPage.isShippingMethodGroundDisplayed("Ground"));
		
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("sku","AP_MBP_13"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductNameInfoDisplayed("product","Apple MacBook Pro 13-inch"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("unit-price","$1,800.00"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("quantity","2"));
		verifyTrue(orderDetailsPage.isConfirmOrderProductInfoDisplayed("total","$3,600.00"));
		
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Sub-Total","$3,600.00"));
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Shipping","$0.00"));
		verifyTrue(orderDetailsPage.isCartTotalInforDisplayed("Tax","$0.00"));
		verifyTrue(orderDetailsPage.isCartOrderTotalInforDisplayed("Order Total","$3,600.00"));
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
