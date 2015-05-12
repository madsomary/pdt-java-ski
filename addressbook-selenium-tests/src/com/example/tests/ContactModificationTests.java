package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		
		ContactData modifiedContact = oldList.get(index); // find object by index
        oldList.remove(modifiedContact); // delete object from list
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(oldList, newList);

	}

}
