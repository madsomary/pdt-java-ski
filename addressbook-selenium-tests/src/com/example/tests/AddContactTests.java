package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initNewContactCreation();
		ContactData group = new ContactData();
		group.firstName = "first name";
		group.lastName = "last name";
		group.address = "address";
		group.home = "home";
		group.mobile = "1234567890";
		group.work = "work";
		group.email = "test@test.com";
		group.email2 = "test2@test.com";
		group.day = "1";
		group.month = "January";
		group.year = "1990";
		group.contactGroup = "group name 1";
		group.secondaryAddress = "address2";
		group.secondaryHome = "home 2";
		app.getContactHelper().fillContactForm(group);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
