package com.example.fw;

public class Contact {
	
	public String firstname;
	public String lastname; 
	public String streetAddress;
	public String city;
	public String postalCode;
	public String country;
	public String phone;
	public String fax;
	public String mobile;

	public String getStreetAddress() {
		return streetAddress;
	}

	public Contact setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Contact setCity(String city) {
		this.city = city;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Contact setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Contact setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Contact setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public Contact setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Contact setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public Contact setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public Contact setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
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
		Contact other = (Contact) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
	

}
