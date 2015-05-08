package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initNewContactCreation();
		//ContactData group = new ContactData();
		//group.day = "01";
		//group.month = "January";
		//group.year = "1990";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
