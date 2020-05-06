package com.bean;

public class RegistrationBean {

	private String name;
	private String companyName;
	private String contactNumber;
	private boolean gender;
	private String city;
	private String state;
	private String country;

	public RegistrationBean() {
		super();
	}

	public RegistrationBean(String name, String companyName, String contactNumber, boolean gender, String city,
			String state, String country) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "RegistrationBean [name=" + name + ", companyName=" + companyName + ", contactNumber=" + contactNumber
				+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
