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
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getModel().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContact(contact, index, MODIFICATION);
		
		SortedListOf<ContactData> newList = new SortedListOf<ContactData>(app.getModel().getContacts());

		ContactData deletedContact = oldList.get(index);
		
		assertThat(newList, equalTo(oldList.without(deletedContact).withAdded(contact)));
	
	if ("true".equals(app.getProperty("check.db"))) {
		if (wantToCheck()) {
				assertThat(app.getModel().getContacts(), equalTo(app
					.getHibernateHelper().listContacts()));
		}
	}
	
	ContactData modifiedContact = newList.get(index);
	
	SortedListOf<ContactData> modifiedContactList = new SortedListOf<ContactData>().withAdded(modifiedContact);
	

	if ("true".equals(app.getProperty("check.ui"))) {
		if (wantToCheck()) {
			SortedListOf<ContactData> uiList = new SortedListOf<ContactData>(app.getContactHelper().getModifiedContactFromUi(index));

				assertThat(modifiedContactList, equalTo (uiList));
		}
	}
}

}
