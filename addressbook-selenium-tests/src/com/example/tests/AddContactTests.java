package com.example.tests;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initNewContactCreation();
    ContactData group = new ContactData();
    group.firstName = "first name";
    group.lastName = "last name";
    group.address = "address";
    group.home = "home";
    group.mobile = "1234567890";
    group.work = "work";
    group.email = "test@test.com";
    group.email2 = "test2@test.com";
    group.day = "1";
    group.month = "January";
    group.year = "1990";
    group.contactGroup = "group name 1";
    group.secondaryAddress = "address2";
    group.secondaryHome = "home 2";
	fillContactForm(group);
    submitEntryCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initNewContactCreation();
	fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    submitEntryCreation();
    returnToHomePage();
  }

}
