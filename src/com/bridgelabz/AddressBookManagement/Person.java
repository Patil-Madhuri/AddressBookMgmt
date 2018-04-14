package com.bridgelabz.AddressBookManagement;
/***************************************************************************************
 * @purpose : This program is used for the address book to get and set the 
 * 		`		address of person separately and prit using toString()
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 09/04/2018
 ***************************************************************************************/
public class Person
{
	private String mFirstName;
	private String mLastName;
	private Address mAddress;
	private String mContactNumber;
	
	/**
	 * @return first name of person
	 */
	public String getmFirstName() 
	{
		return mFirstName;
	}
	/**
	 * @param mFirstName
	 *  set first name of person
	 */
	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	/**
	 * @return last name of person
	 */
	public String getmLastName() {
		return mLastName;
	}
	/**
	 * @param mLastName
	 * set last name of person
	 */
	public void setmLastName(String mLastName) 
	{
		this.mLastName = mLastName;
	}
	/**
	 * @return address of person
	 */
	public Address getmAddress() {
		return mAddress;
	}
	/**
	 * @param mAddress
	 * set address of person
	 */
	public void setmAddress(Address mAddress) {
		this.mAddress = mAddress;
	}
	/**
	 * @return contact number of person
	 */
	public String getmContactNumber() {
		return mContactNumber;
	}
	/**
	 * @param mContactNumber
	 * set contact number of person
	 */
	public void setmContactNumber(String mContactNumber) {
		this.mContactNumber = mContactNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * print the details of person
	 */
	@Override
	public String toString() 
	{
		return "Person [mFirstName=" + mFirstName + ", mLastName=" + mLastName + ", mAddress=" + mAddress
				+ ", mContactNumber=" + mContactNumber + "]";
	}

}
