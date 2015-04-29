package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactModification(2);
	ContactData group = new ContactData();
    group.firstName = "new name";
    group.lastName = "new lastname";
    app.getContactHelper().fillContactForm(group);
    app.getContactHelper().submitContactModification();
	}	

}
