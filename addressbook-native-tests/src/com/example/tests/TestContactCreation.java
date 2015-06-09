package com.example.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {

	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact()
		.setFirstName(RandomStringCapitalized())
		.setLastName(RandomStringCapitalized())
		.setStreetAddress(RandomStringCapitalized() + " street")
		.setCity(RandomStringCapitalized() + " city")
		.setPostalCode(RandomStringUtils.randomNumeric(5))
		.setCountry(RandomStringCapitalized())
		.setPhone(RandomStringUtils.randomNumeric(11))
		.setFax(RandomStringUtils.randomNumeric(11))
		.setMobile(RandomStringUtils.randomNumeric(11));
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
		//app.getProcessHelper().closeApplication();
	}

	private String RandomStringCapitalized() {
		return WordUtils.capitalize(RandomStringUtils.randomAlphabetic(5).toLowerCase());
	}
}
