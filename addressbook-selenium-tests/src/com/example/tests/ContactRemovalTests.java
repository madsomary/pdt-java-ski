package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void DeleteSomeContact() {

		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app
				.getModel().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().deleteContact(index);

		SortedListOf<ContactData> newList = new SortedListOf<ContactData>(app
				.getModel().getContacts());

		ContactData deletedContact = oldList.get(index);
		assertThat(newList, equalTo(oldList.without(deletedContact)));

		if ("true".equals(app.getProperty("check.db"))) {
			if (wantToCheck()) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getHibernateHelper().listContacts()));
			}
		}

		if ("true".equals(app.getProperty("check.ui"))) {
			if (wantToCheck()) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getContactHelper().getUiContacts()));
			}
		}
	}
}
