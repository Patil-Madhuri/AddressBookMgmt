package com.bridgelabz.AddressBookManagement;
/***************************************************************************
 * @purpose : This program is used for manage the address book
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 09/04/2018
 ***************************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class AddressManager 
{
	static
	{
	System.out.println("*****@ Address Book Manager @*****");	
	}
	
	ObjectMapper objectMapper = new ObjectMapper();
	AddressBook addressbook=new AddressBook();
	static ArrayList<Person> arrayList = new ArrayList<>();
	File file;
	static Scanner scanner=new Scanner(System.in);
	
	/**
	 * create new address book
	 */
	public void createAddressBook()
	{
		File lPath=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/");
		File[] lListFile=lPath.listFiles();
		System.out.println("list of file in folder: ");
		for(File file1: lListFile)
		{
			System.out.println(file1.getName());
			}
		System.out.println("Give a name to your new address book:");
		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
				""+scanner.next()+".json");
		try {
				if (file.createNewFile()){
					System.out.println("Address book is created!");
					saveAddressBook();
					
				}
				else{
					System.out.println("Address book is already exists.");
				
				}
			} catch (IOException e) {
				e.printStackTrace();
				}
	}
	
	/**
	 * Open address book
	 */
	public void openAddressBook()
	{
		File lPath=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/");
		File[] lListFile=lPath.listFiles();
		System.out.println("list of file in folder: ");
		for(File file1: lListFile)
		{
			System.out.println(file1.getName());
			}
		System.out.println("Enter the name of address book");
		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
				""+scanner.next()+".json");
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {};
				arrayList = objectMapper.readValue(arrayToJson, type);
				
			}
			reader.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		addressbook.operation();
		saveAddressBook();
	}
	/**
	 * @return list of the person
	 */
	public static ArrayList<Person> listReturn()
	{
		return arrayList;
	}

	/**
	 * save the address book
	 */
	public void saveAddressBook() 
	{
		ArrayList<Person> arrayList=new ArrayList<Person>();
		arrayList=addressbook.list();
		try {
			objectMapper.writeValue(file, arrayList);
			System.out.println("File Save Successfully");
			System.out.println(arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 *  Rename the address Book
	 */
	public void saveAsAddressBook()
	{
		System.out.println("Enter the name of address book");
		String filename = scanner.next();
		System.out.println("Enter the extension of your file: ");
		String extension = scanner.next();
		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +""+filename+extension);
		ArrayList<Person> arrayList=new ArrayList<Person>();
		arrayList=addressbook.list();
		try {
			objectMapper.writeValue(file, arrayList);
		
			System.out.println(arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Rename file
//		System.out.println("Enter old file name: ");
//		file=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
//				""+scanner.next()+".json");
//		System.out.println("Enter new file name: ");
//		File file1=new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/" +
//				""+scanner.next()+".json");
//		if(file.renameTo(file1))
//		{
//			System.out.println("Your file is renamed sucesfully......");
//		}
//		else
//		{
//			System.out.println("File is not renamed");
//		}
	}

	public static void main(String[] args) 
	{
		AddressManager manager=new AddressManager();
		do
		{
			System.out.println("Make a choice from below");
			System.out.println("1.Create Address-Book \n2. Open Address-Book \n3. Save Address-Book\n4. Save As Address-Book\n5.Quit");
			switch (scanner.nextInt()) 
			{
			case 1:	manager.createAddressBook();
					break;
			case 2:	manager.openAddressBook();
					break;
			case 3:	manager.saveAddressBook();
					break;
			case 4:	manager.saveAsAddressBook();
					break;
			case 5:
				System.out.println("Address Book Closed");
				System.exit(0);				
			}
		}while(true);
	}
	
}
