package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().initContactModification(index);
		ContactData group = new ContactData();
		group.firstName = "new first name";
		group.lastName = "new lastname";
		app.getContactHelper().fillContactForm(group);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.remove(index);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
