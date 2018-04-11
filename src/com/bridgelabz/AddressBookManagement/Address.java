package com.bridgelabz.AddressBookManagement;
/***************************************************************************************
 * @purpose : This program is used for the address book to get and set the 
 * 		`		values of person variables separately and print using toString()
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 09/04/2018
 ***************************************************************************************/
public class Address 
{
	private String mCity;
	private int mZip;
	private String mState;
	
	/**
	 * @return city of person
	 */
	public String getmCity() 
	{
		return mCity; 
	}

	/**
	 * @param mCity
	 * set city of person
	 */
	public void setmCity(String mCity) {
		this.mCity = mCity;
	}

	/**
	 * @return Zipcode of person city
	 */
	public int getmZip() {
		return mZip;
	}

	/**
	 * @param mZip
	 * set the zip code of person city
	 */
	public void setmZip(int mZip) {
		this.mZip = mZip;
	}

	/**
	 * @return the state of person
	 */
	public String getmState() {
		return mState;
	}

	/**
	 * @param mState
	 * set the state of person
	 */
	public void setmState(String mState) {
		this.mState = mState;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Print the address of person
	 */
	@Override
	public String toString() {
		return "Address [mCity=" + mCity + ", mZip=" + mZip + ", mState=" + mState + "]";
	}

	
}
