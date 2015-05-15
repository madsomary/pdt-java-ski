package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	public void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> cells = driver.findElements(By
				.xpath("//tr[@name='entry']/td[2]"));
		for (WebElement cell : cells) {
			String text = cell.getText();
			String lastName = text;
			cachedContacts.add(new ContactData().withLastName(lastName));
		}
	}

	public ContactHelper createContact(ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
		initNewContactCreation();
		fillContactForm(contact, formType);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(ContactData contact, int index,
			boolean formType) {
		initContactModification(index);
		fillContactForm(contact, formType);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		initContactModification(index);
		deleteContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	// ----------------------------------------------------------------------------------------------

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getDay());
		selectByText(By.name("bmonth"), contact.getMonth());
		type(By.name("byear"), contact.getYear());
//		if (formType == CREATION) {
//			// selectByText(By.name("new_group"), contact.getContactGroup());
//		} else {
//			if (driver.findElements(By.name("new_group")).size() != 0) {
//				throw new Error(
//						"Group selector exist in contact modification form");
//			}
//		}
		type(By.name("address2"), contact.getSecondaryAddress());
		type(By.name("phone2"), contact.getSecondaryHome());
		return this;
	}

	public ContactHelper deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		return this;
	}

	public ContactHelper initNewContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("//tr[" + (index + 2) + "]" + "/td[7]//img"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		return this;
	}

}
