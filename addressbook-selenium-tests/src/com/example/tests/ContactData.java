package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
		final int prime = 31;
		int result = 1;
	//result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
}