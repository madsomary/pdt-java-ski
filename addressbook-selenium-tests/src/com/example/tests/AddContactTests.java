package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;

public class AddContactTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		app.getContactHelper().createContact(contact, CREATION);

		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		assertThat(newList, equalTo(oldList.withAdded(contact)));

	}

}
