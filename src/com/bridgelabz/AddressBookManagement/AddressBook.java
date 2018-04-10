package com.bridgelabz.AddressBookManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook
{
	Scanner scanner=new Scanner(System.in);
	ArrayList<Person> list=new ArrayList<Person>();
	String firstName,lastName,city,state;
	long contactNumber;
	int zipcode,choice;
	public void operation() {
		
		boolean status=true;
		do{
		System.out.println("Choose Operation you want to do");
		System.out.println("1. Add\n2. Edit\n3. SortById\n4. SortByZip \n5.deletePerson\n6. Exit");
		switch (scanner.nextInt()) {
		case 1: addPerson();
				break;
		case 2: 
				editPerson();
		
				break;
		
		case 3: sortByName();
				break;
		case 4:
			//sortByZip();
				break;
		case 5:
			deletePerson();
			break;
		case 6:	
			status=false;
				break;
		}
		}
		while(status);
	}
		
	public void addPerson()
	{
		
		//ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	//objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		Person person=new Person();
		Address address=new Address();
		System.out.println("Enter the First name:");
		firstName=scanner.next();
		person.setFname(firstName);
	
		System.out.println("Enter the Last name:");
		lastName=scanner.next();
		person.setLname(lastName);;
	
		System.out.println("Enter the contact number:");
		contactNumber = scanner.nextLong();
		person.setContact(contactNumber);
		
		System.out.println("Enter the City:");
		 city=scanner.next();
		address.setCity(city);
	
		System.out.println("Enter the Zip:");
		 zipcode=scanner.nextInt();
		address.setZip(zipcode);
	
		System.out.println("Enter the State:");
		state = scanner.next();
		address.setState(state);
		
		person.setAddress(address);
		list.add(person);
		
	/*	try {
			
			objectMapper.writeValue(file,list);
			//System.out.println(arrayToJson);
			
			
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}*/
		
		//System.out.println(person.getFname()+" "+person.getLname()+" "+person.getAddress());
	//person.setAddress(s.next());
		
	}
	
	public void editPerson() 
	{
		
		System.out.println("Enter the firstname to Edit details: ");
		firstName = scanner.next();
		for(int i=0;i<list.size();i++)
		{
			Person person = list.get(i);
			if(firstName.equals(person.getFname()))
			{
				Address address  = person.getAddress();
				System.out.println("1.Edit lastname \n2.Edit Contact No \n3.Edit city \n4.Edit state \n5.Edit zipcode \n6.Stop editing");
				System.out.println("Enter your choice to update: ");
				choice = scanner.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the lastName");
					 lastName=scanner.next();
					 person.setLname(lastName); 
					break;
				case 2:
					System.out.println("Enter your Contact number");
					contactNumber = scanner.nextLong();
					person.setContact(contactNumber);
					break;
				case 3:
					System.out.println("Enter your City");
					city = scanner.next();		
					address.setCity(city);
					
					break;
				case 4:
					System.out.println("Enter your State");
					state = scanner.next();
					address.setState(state);
					break;
				case 5:
					System.out.println("Enter your zipcode:");
					zipcode = scanner.nextInt();
					address.setZip(zipcode);
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
	
	public void deletePerson() 
	{
		System.out.println("Enter the firstname to delete details: ");
		firstName = scanner.next();
		for(int i=0;i<list.size();i++)
		{
			Person person = list.get(i);
			if(firstName.equals(person.getFname()))
			{
				list.remove(i);
			}
			System.out.println(list);
			}
	}
	
	
	public void sortByName() 
	{
		@SuppressWarnings("unused")
		class SortByName implements Comparator<Person> 
		{
			@Override
			public int compare(Person person1, Person person2)
			{
				return person1.getFname() .compareToIgnoreCase(person2.getFname());
			}
		}
			 Collections.sort(list, new SortByName());
			  for(Person person : list)
			  {
			  System.out.println(person.getFname());
			  }
		
		
	}
	public void sortByZip() 
	{
		class SortByZip implements Comparator<Person>
		{
			public int compare(Person person1, Person person2) 
			{
			Person person;
			Address address1  = person1.getAddress();
			Address address2 = person2.getAddress();
			int zip1 = address1.getZip();
			int zip2 = address2.getZip();
				return zip1 - zip2;
			}
		}
		Collections.sort(list, new SortByZip());
		  for(Person address : list)
		  {
		  System.out.println(address);
		  }
	}
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