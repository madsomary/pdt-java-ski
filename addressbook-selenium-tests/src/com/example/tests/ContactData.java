package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String day;
	public String month;
	public String year;
	public String contactGroup;
	public String secondaryAddress;
	public String secondaryHome;
	
	public ContactData() {
	}

	public ContactData(String firstName, String lastName, String address,
			String home, String mobile, String work, String email,
			String email2, String day, String month, String year, String contactGroup, String secondaryAddress, 
			String secondaryHome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.day = day;
		this.month = month;
		this.year = year;
		this.contactGroup = contactGroup;
		this.secondaryAddress = secondaryAddress;
		this.secondaryHome = secondaryHome;
		}
}