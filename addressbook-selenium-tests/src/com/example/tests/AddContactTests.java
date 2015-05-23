package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

public class AddContactTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile (new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		app.getContactHelper().createContact(contact, CREATION);

		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		assertThat(newList, equalTo(oldList.withAdded(contact)));

	}

}
