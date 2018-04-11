package com.bridgelabz.AddressBookManagement;
/***************************************************************************************
 * @purpose : This program is used for the address book to add, detele, edit the deatils
 * 				of the person, and sort details by name, sort details by zip code
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 09/04/2018
 ***************************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AddressBook
{
	Scanner scanner=new Scanner(System.in);
	ArrayList<Person> list=new ArrayList<Person>();
	String mfirstName,mLastName,mCity,mState;
	long mContactNumber;
	int mZipCode,mChoice;
	
	/**
	 *  Operayion perform to person
	 */
	public void operation() 
	{
		list = AddressManager.listReturn();
		boolean status=true;
		do{
		System.out.println("Choose Operation you want to do");
		System.out.println("1. Add Details of Person\n2. Edit Details of Person \n3.Delete Details of Person"
				+ "\n4. Sort Details of Person By Name \n5. Sort Details of Person By Zip \n6. Exit");
		switch (scanner.nextInt()) 
		{
		case 1: addPerson();
				break;
		case 2: 
				editPerson();
				break;
		case 3:
			deletePerson();
				break;
		case 4:
			sortByZip();
				break;
		case 5:
			sortByName();
			break;
		case 6:
			status=false;
				break;
		}
		}
		while(status);
	}
		
	
	/**
	 *  add the details of person to the address book
	 */
	public void addPerson()
	{
		Person person=new Person();
		Address address=new Address();
		System.out.println("Enter the First name:");
		mfirstName=scanner.next();
		person.setmFirstName(mfirstName);
	
		System.out.println("Enter the Last name:");
		mLastName=scanner.next();
		person.setmLastName(mLastName);
	
		System.out.println("Enter the contact number:");
		mContactNumber= scanner.nextLong();
		person.setmContactNumber(mContactNumber);
		
		System.out.println("Enter the City:");
		 mCity=scanner.next();
		address.setmCity(mCity);
	
		System.out.println("Enter the Zip:");
		 mZipCode=scanner.nextInt();
		address.setmZip(mZipCode);
	
		System.out.println("Enter the State:");
		mState = scanner.next();
		address.setmState(mState);
		
		person.setmAddress(address);
		list.add(person);
		
	}
	
	/**
	 * edit  the details of person to the address book
	 */
	public void editPerson() 
	{
		System.out.println("Enter the firstname to Edit details: ");
		mfirstName = scanner.next();
		for(int i=0;i<list.size();i++)
		{
			Person person = list.get(i);
			if(mfirstName.equals(person.getmFirstName()))
			{
				Address address  = person.getmAddress();
				System.out.println("1.Edit lastname \n2.Edit Contact No \n3.Edit city \n4.Edit state \n5.Edit zipcode \n6.Stop editing");
				System.out.println("Enter your choice to update: ");
				mChoice = scanner.nextInt();
				switch(mChoice)
				{
				case 1:
					System.out.println("Enter the lastName");
					 mLastName=scanner.next();
					 person.setmLastName(mLastName); 
					break;
				case 2:
					System.out.println("Enter your Contact number");
					mContactNumber = scanner.nextLong();
					person.setmContactNumber(mContactNumber);
					break;
				case 3:
					System.out.println("Enter your City");
					mCity = scanner.next();		
					address.setmCity(mCity);
					
					break;
				case 4:
					System.out.println("Enter your State");
					mState = scanner.next();
					address.setmState(mState);
					break;
				case 5:
					System.out.println("Enter your zipcode:");
					mZipCode = scanner.nextInt();
					address.setmZip(mZipCode);
					break;
				case 6:
					System.out.println("**Edited Successfully**");
					break;
					
				default:
						System.out.println("Invalid choice");
				}
			}
			System.out.println(person);
		}	
		
		
	}
	
	/**
	 *  delete  the details of person from the address book
	 */
	public void deletePerson() 
	{
		System.out.println("Enter the firstname to delete details: ");
		mfirstName = scanner.next();
		for(int i=0;i<list.size();i++)
		{
			Person person = list.get(i);
			if(mfirstName.equals(person.getmFirstName()))
			{
				list.remove(i);
			}
			System.out.println(list);
			}
	}
	
	/**
	 *  Sort the details of the person in address book in asecnding order
	 *  using the comparator on the basis of name
	 */
	public void sortByName() 
	{
		@SuppressWarnings("unused")
		class SortByName implements Comparator<Person> 
		{
			@Override
			public int compare(Person person1, Person person2)
			{
				return person1.getmFirstName() .compareToIgnoreCase(person2.getmFirstName());
			}
		}
		Collections.sort(list, new SortByName());
		for(Person person : list)
		{
			 System.out.println(person);
		}
	}
	/**
	 *  Sort the details of the person in address book in asecnding order
	 *  using the comparator on the basis of Zip code of person city
	 */
	public void sortByZip() 
	{
		class SortByZip implements Comparator<Person>
		{
			public int compare(Person person1, Person person2) 
			{
			
			Address address1  = person1.getmAddress();
			Address address2 = person2.getmAddress();
			int zip1 = address1.getmZip();
			int zip2 = address2.getmZip();
				return zip1 - zip2;
			}
		}
		Collections.sort(list, new SortByZip());
		  for(Person address : list)
		  {
		  System.out.println(address);
		  }
	}
	
	/**
	 * @return the list of person in the address book
	 */
	public ArrayList<Person> list()
	{
		return list;
	}
	
	
//public static void main(String[] args) {
//	AddressBook a=new AddressBook();
//	a.addPerson();
//	a.addPerson();
//	a.sortByName();
//	a.sortByZip();
//}
	

}
