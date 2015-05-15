package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContact(contact, index, MODIFICATION);
		
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		ContactData deletedContact = oldList.get(index);
		assertThat(newList, equalTo(oldList.without(deletedContact).withAdded(contact)));
	}

}
