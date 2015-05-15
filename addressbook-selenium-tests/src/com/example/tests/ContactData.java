package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String lastName;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String day;
	private String month;
	private String year;
	private String contactGroup;	
	private String secondaryAddress;
	private String secondaryHome;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getContactGroup() {
		return contactGroup;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getSecondaryHome() {
		return secondaryHome;
	}

	public ContactData() {
	}

	public ContactData(String firstName, String lastName, String address,
			String home, String mobile, String work, String email,
			String email2, String day, String month, String year,
			String contactGroup, String secondaryAddress, String secondaryHome) {
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

	@Override
	public String toString() {
		return "ContactData [lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}
	
	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	
	public ContactData withDay(String day) {
		this.day = day;
		return this;
	}
	
	public ContactData withMonth(String month) {
		this.month = month;
		return this;
	}
	
	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}
	
	public ContactData withContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
		return this;
	}
	
	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}
	
	public ContactData withSecondaryHome(String secondaryHome) {
		this.secondaryHome = secondaryHome;
		return this;
	}

	

	
}