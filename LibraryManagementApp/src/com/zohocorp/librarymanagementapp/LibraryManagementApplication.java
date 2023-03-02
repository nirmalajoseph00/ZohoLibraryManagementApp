package com.zohocorp.librarymanagementapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

class Book 
{
	private String bookId;
	private String bookName;
	private String author;
	
	public String getBookId()
	{
		return this.bookId;
	}
	public void addBookId(String bookId)
	{
		this.bookId=bookId;
	}
	public String getBookName()
	{
		return this.bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName=bookName;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}	
	public void displayBookDetails()
	{
		System.out.println("ID: "+getBookId()+"\t Name: "+getBookName()+"\t Author: "+getAuthor());
	}

}

class Member
{
	public void searchBook(Iterator<Entry<String, Book>> bookIterator,String bookName)
	{	
		int flag=0;
		while (bookIterator.hasNext()) 
		{
			Entry<String, Book> mapElement=bookIterator.next();
			Book bookObject=(Book) mapElement.getValue();
			if ((bookObject.getBookName()).equalsIgnoreCase(bookName))
			{
				System.out.println(bookName + " is available");
				System.out.println("Book ID of searched book: " + bookObject.getBookId());
				flag=1;
			}
		}
		if (flag==0)
		{
			System.out.println(bookName + " is not available");
		}
	}
}

class Librarian extends Member
{
	String bookName, bookId, author;
	
	public Book addBook(String bookId, String bookName, String author)
	{
		Book bookObject=new Book();
		bookObject.addBookId(bookId);
		bookObject.setBookName(bookName);
		bookObject.setAuthor(author);
		return bookObject;
	}
	
	public Book modifyBook(Book bookObject, String editedName, String bookField)
	{
		if (bookField.equals("author"))
			bookObject.setAuthor(editedName);
		else
			bookObject.setBookName(editedName);
		bookObject.displayBookDetails();
		return bookObject;
	}
	public void deleteBook(Book bookObject)
	{
		bookObject.setBookName(null);
		bookObject.setAuthor(null);
	}
}




public class LibraryManagementApplication 
{
	//public static Scanner sc = new Scanner(System.in);
	static HashMap<String,Book> books=new HashMap<>();
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		char mainChoice='Y';
		int choice;
		
		do
		{
			System.out.println("\n Main Menu \n 1.Librarian \n 2.Member \n 3.Quit");
			System.out.println("Enter your choice: ");
			//choice = Integer.parseInt(reader.readLine());
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				librarianMenu();
				break;
				
			case 2:
				memberMenu();
				break;
			case 3:
				System.out.println("Do you want to continue(Y/N): ");
				mainChoice=sc.next().charAt(0);
				break;
			default:
				System.out.println("Wrong choice");
					
			}	
		}while (mainChoice=='Y');
		System.out.println("Goodbye");
		//sc.close();
	}
	
	public static void librarianMenu() throws IOException
	{	
		//char librarianChoice='Y';
		Scanner sc = new Scanner(System.in);
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int choice;
		Book bookObjectMain;
		String bookName;
		String bookId;
		String author;
		String bookField;
		String editedName;
		Librarian librarianObject=new Librarian();
		
		System.out.println("\n Librarian Menu \n 1.Add Books \n 2.Modify Books \n 3.Delete Books"
					+ "\n 4.Search Book");
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
								
		switch(choice)
		{
		case 1:
			System.out.println("Enter ID of new book: ");
			bookId=sc.next();
			System.out.println("Enter name of new book: ");
			bookName=reader.readLine();
			System.out.println("Enter author of new book: ");
			author=reader.readLine();
			bookObjectMain=librarianObject.addBook(bookId,bookName,author);
			books.put(bookId,bookObjectMain);
			display();
			break;
		case 2:
			System.out.println("Enter ID of book to be modified: ");
			bookId=sc.next();
			System.out.println("Enter the field you want to edit(name/author)");
			bookField=reader.readLine();
			System.out.println("Enter the edit: ");
			editedName=reader.readLine();
			bookObjectMain=librarianObject.modifyBook(books.get(bookId),editedName, bookField);	
			//books.put(bookId,bookObjectMain); //check if needed
			display();
			break;
		case 3:
			System.out.println("Enter ID of book to be deleted: ");
			bookId=sc.next();
			librarianObject.deleteBook(books.get(bookId));
			books.remove(bookId);
			break;
		case 4:
			Iterator<Entry<String, Book>> bookIterator = books.entrySet().iterator();
			System.out.println("Enter name of book to search: ");
			bookName=reader.readLine();
			librarianObject.searchBook(bookIterator,bookName);
			break;
		default:
			System.out.println("Wrong choice");
			}
	}
	
	public static void memberMenu() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String bookName;
		
		System.out.println("\n Member Menu \n 1.Search Book ");
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
			
		Member memberObject=new Member();
			
		switch(choice)
		{
		case 1:
			Iterator<Entry<String, Book>> bookIterator = books.entrySet().iterator();
			System.out.println("Enter name of book to search: ");
			bookName=reader.readLine();
			memberObject.searchBook(bookIterator,bookName);
			break;
		default:
			System.out.println("Wrong choice");
		}	
	}
	
	public static void display()
	{
		System.out.println("BOOK LIST");
		books.forEach((k,v)
				-> v.displayBookDetails());
	}

}
