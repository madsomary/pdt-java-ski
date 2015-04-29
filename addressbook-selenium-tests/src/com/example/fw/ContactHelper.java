package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData group) {
		type(By.name("firstname"), group.firstName);
		type(By.name("lastname"), group.lastName);
		type(By.name("address"), group.address);
		type(By.name("home"), group.home);
		type(By.name("mobile"), group.mobile);
		type(By.name("work"), group.work);
		type(By.name("email"), group.email);
		type(By.name("email2"), group.email2);
	    selectByText(By.name("bday"), group.day);
	    selectByText(By.name("bmonth"), group.month);
	    type(By.name("byear"), group.year);
	   // selectByText(By.name("new_group"), group.contactGroup);
	    type(By.name("address2"), group.secondaryAddress);
	    type(By.name("phone2"), group.secondaryHome);
	
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	  }

	public void returnToHomePage() {
		click(By.linkText("home page"));
	  }
	
	public void initContactModification(int index) {
		click(By.xpath(".//*[@id='maintable']//tr[" + index + "]" + "/td[7]//img"));
	}
	
	public void submitContactModification() {
		click(By.name("update"));
	}
	
    public void deleteContact() {
    	click(By.xpath("(//input[@name='update'])[2]"));
    }
}
