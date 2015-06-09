package com.example.fw;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	int timeout = manager.getProcessHelper().getTimeout();
	
	private void initContactCreation() {
				manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", timeout)
				.click("Add").winWaitAndActivate("Add Contact", "", timeout);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper().send("TDBEdit12", contact.firstname)
				.send("TDBEdit11", contact.lastname)
				.send("TDBEdit8", contact.streetAddress)
				.send("TDBEdit7", contact.city)
				.send("TDBEdit6", contact.postalCode)
				.send("TDBEdit5", contact.country)
				.send("TDBEdit4", contact.phone).send("TDBEdit3", contact.fax)
				.send("TDBEdit2", contact.mobile);

	}

	private void confirmContactCreation() {
		manager.getAutoItHelper().click("Save")
				.winWaitAndActivate("AddressBook Portable", "", timeout);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", timeout)
				.click("TListView1").send("{DOWN}{SPACE}").click("Edit")
				.winWaitAndActivate("Update Contact", "", timeout);
		Contact contact = new Contact().setFirstName(
				manager.getAutoItHelper().getText("TDBEdit12")).setLastName(
				manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
				.winWaitAndActivate("AddressBook Portable", "", timeout);
		return contact;
	}

}
