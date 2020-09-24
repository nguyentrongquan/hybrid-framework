package pageUIs.nopcommerce.user;

public class AddressPageUI {
	public static final String ADD_NEW_ADDRESS_BUTTON= "//input[@value='Add new']";
	public static final String COUNTRY_DROPDOWN= "//select[@id='Address_CountryId']";
	public static final String SAVE_ADDRESS_BUTTON= "//input[@value='Save']";
	public static final String NAME_ADDRESS= "//li[@class='name' and text()='%s']";
	public static final String EMAIL_ADDRESS= "//li[@class='email' and text()='%s']";
	public static final String PHONE_ADDRESS= "//li[@class='phone' and contains(text(),'%s')]";
	public static final String FAX_ADDRESS= "//li[@class='fax' and contains(text(),'%s')]";
	public static final String ADDRESS1_ADDRESS= "//li[@class='address1' and contains(text(),'%s')]";
	public static final String ADDRESS2_ADDRESS= "//li[@class='address2' and contains(text(),'%s')]";
	public static final String CITY_ZIP_ADDRESS= "//li[@class='city-state-zip' and contains(text(),'%s')]";
	public static final String COUNTRY_ADDRESS= "//li[@class='country' and contains(text(),'%s')]";
	public static final String COMPANY_ADDRESS= "//li[@class='company' and contains(text(),'%s')]";

}
