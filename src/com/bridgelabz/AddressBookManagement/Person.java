package com.bridgelabz.AddressBookManagement;
public class Person
{
	private String fname;
	private String lname;
	private Address address;
	private long contact;
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", contact=" +contact +"address="
				+ address + "]";
	}
}
