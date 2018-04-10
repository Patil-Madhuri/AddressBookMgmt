package com.bridgelabz.AddressBookManagement;

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
	static {
	System.out.println("*****@ Address Book Manager @*****");	
	}
	ObjectMapper objectMapper = new ObjectMapper();
	AddressBook addressbook=new AddressBook();
	static ArrayList<Person> arrayList = new ArrayList<>();
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
					saveAddressBook();
					
				}
				else{
					System.out.println("Address book is already exists.");
					saveAddressBook();
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
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {};
				arrayList = objectMapper.readValue(arrayToJson, type);
				
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		addressbook.operation();
		saveAddressBook();
	}
	public static ArrayList<Person> listReturn()
	{
		return arrayList;
	}
//	public void saveAddressBook(String filename) 
//	{
//		System.out.println("Enter the filename");
//		String file1 = scanner.next();
//		file = new File(filename);
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			ArrayList<Person> list2 = mapper.readValue(file, new TypeReference<List<Person>>(){});
//			System.out.println(list2);
//			
//			ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.writeValue(new File("/home/bridgeit/MADHURI/AddressBookMgmt/Files/"), list);
//			String jsString = objectMapper.writeValueAsString(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	public void saveAddressBook() 
	{
		ArrayList<Person> arrayList=new ArrayList<Person>();
		arrayList=addressbook.list();
		
		
		try {
			objectMapper.writeValue(file, arrayList);
			System.out.println(arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void saveAsAddressBook()
	{
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(resultFile, value);
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
