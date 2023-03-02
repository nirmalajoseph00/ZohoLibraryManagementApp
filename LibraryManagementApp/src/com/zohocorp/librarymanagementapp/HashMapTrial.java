package com.zohocorp.librarymanagementapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//class Book 
//{
//	private String bookId;
//	private String bookName;
//	//private ArrayList<String> author=new ArrayList<>();
//	
//	
//	public void set(String bookId, String bookName)
//	{
//		this.bookId=bookId;
//		this.bookName=bookName;
//	}
//	public String getid()
//	{
//		return this.bookId;
//	}
//	public String getbook()
//	{
//		return this.bookName;
//	}
//
//}
//class member
//{
//	public Book add()
//	{
//		Book b=new Book();
//		b.set("bid1", "harrp potter");
//		return b;
//	}
//}
//public class HashMapTrial 
//{
//	public static void main(String[] args) 
//	{
////		HashMap<String, List<String>> Books = new HashMap<>();
////		String bn="238j";
////		String a="jack mol";
////		String bnam="hjdhd";
////		Books.put(bn, Arrays.asList(bnam,a));
////		System.out.println(Books);
////		System.out.println(Books.get("238j").get(0));
//		
//		HashMap<String,Book> books=new HashMap<>();
//		member m=new member();
//		Book b1,b2 =new Book();
//		b1=m.add();
//		books.put(b1.getid(), b1);
//		b2=m.add();
//		books.put("bid2", b2);
//		System.out.println(books);
//		System.out.println(books.get(b1.getid()));
//		//System.out.println(books.containsKey("book2"));
//		boolean d;
//		//System.out.println(b1.getbook());
//		books.forEach((k,v)
//				-> d=v.getbook().equals("harrp potter"));//doesnt work
//					
//
//				//( v.getbook()).equals("harrp potter"))
//		
//		Iterator bookIte=books.entrySet().iterator();
//		
//		while (bookIte.hasNext()) {
//			Map.Entry mapElement=(Map.Entry)bookIte.next();
//			Book b3=(Book) mapElement.getValue();
//			if (b3.getbook().equals("harrp potter")){
//				System.out.println("present");
//			}
//		}
//	}
//
//}
