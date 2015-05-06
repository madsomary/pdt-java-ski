package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void DeleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(2);
		app.getContactHelper().deleteContact();
	}
}
