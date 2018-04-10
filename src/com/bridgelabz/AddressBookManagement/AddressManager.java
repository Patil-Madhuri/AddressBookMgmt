package com.bridgelabz.AddressBookManagement;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

public class AddressManager 
{
	static {
	System.out.println("*****@ Address Book Manager @*****");	
	}
	ObjectMapper objectMapper = new ObjectMapper();
	AddressBook addressbook=new AddressBook();
	File file;
	static Scanner scanner=new Scanner(System.in);
	public void createAddressBook()
	{
		File path=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/");
		File[] listFile=path.listFiles();
		System.out.println("list of file in folder: ");
		for(File file1: listFile)
		{
			System.out.println(file1.getName());
			}
		System.out.println("Give a name to your new address book:");
		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
				""+scanner.next()+".json");
		try {
				if (file.createNewFile()){
					System.out.println("Address book is created!");
					FileWriter fw=new FileWriter(file);
					fw.write("{}");
					fw.flush();
					fw.close();
				}
				else{
					System.out.println("Address book is already exists.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				}
		
	}
	public void openAddressBook() {
		File path=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/");
		File[] listFile=path.listFiles();
		System.out.println("list of file in folder: ");
		for(File file1: listFile)
		{
			System.out.println(file1.getName());
			}
		System.out.println("Enter the name of address book");
		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
				""+scanner.next()+".json");
//				try {
//					Person person=objectMapper.readValue(new FileInputStream(filename), Person.class );
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		addressbook.operation();
	}
	public void saveAddressBook() 
	{
		ArrayList<Person> arrayList=new ArrayList<Person>();
		arrayList=addressbook.list();
		System.out.println(arrayList);
		
		try {
			objectMapper.writeValue(file, arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void saveAsAddressBook()
	{
		
	}
	public void quit() 
	{
	
	}

	public static void main(String[] args) {
		
	AddressManager manager=new AddressManager();
		do{
		System.out.println("Make a choice from below");
		System.out.println("1.Create Address-Book \n2. Open Address-Book \n3. Save Address-Book\n4. Save As Address-Book\n5.Quit");
		File file = null;
		switch (scanner.nextInt()) {
		case 1:	manager.createAddressBook();
				break;
		case 2:	manager.openAddressBook();
				break;
		case 3:	manager.saveAddressBook();
				break;
		case 4:	manager.saveAsAddressBook();
				break;
		
		case 5:System.exit(0);
			
		}
		}while(true);
	}
	
}
