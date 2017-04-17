package com.oop;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.NavigableSet;

import com.oop.container.*;

public class Tester {
	public String createRandomName() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			char c = chars[rand.nextInt(chars.length)];
			sb.append(c);
		}
		String res = sb.toString();
		return res;
	}
	
	public String createRandomNumber() {
		char[] chars = "0123456789".toCharArray();
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 11; i++) {
			char c = chars[rand.nextInt(chars.length)];
			sb.append(c);
		}
		String res = sb.toString();
		return res;
	}
	
 	PersonContainer adbook = new PersonContainer();
 	
	public void test1() { //20 entries add
		//add 20
	}
	public void test2() { //sorting, display, save
		for(; adbook.it_name.hasNext();) {
			System.out.println(adbook.it_name.next().getKey() +
					((Person) ((Entry<String, Collection<Person>>) adbook.it_name).getValue()).getPhoneNumber());	
		}
	}
	
	public void test3() { //add 10 entries to application
		for(int i = 0; i < 10; i++) {
			Person one = new Person(createRandomName(), createRandomNumber());
			adbook.add(one);
		}
		
		//file save, load
		
		for(; adbook.it_name.hasNext();) {
			System.out.println(adbook.it_name.next().getKey() +
					((Person) ((Entry<String, Collection<Person>>) adbook.it_name).getValue()).getPhoneNumber());	
		}
	}
	
	public void test4() { //add 3, change 2, delete 1
		System.out.println("add 3, change 2, delete 1");
		//file load, save;
		
		for(; adbook.it_name.hasNext();) {
			System.out.println(adbook.it_name.next().getKey() +
					((Person) ((Entry<String, Collection<Person>>) adbook.it_name).getValue()).getPhoneNumber());	
		}	
	}
	
	public void test5() { //find entry
		char[] name = new char[65535];
		System.out.println("Input name:" );
		Scanner scan = new Scanner(System.in);
		String findName = scan.nextLine();
		NavigableSet<Person> found = adbook.findByNickname(findName);
		if(found.isEmpty()) return;
		for(Person p : found) {
			System.out.println(p.getNickname() + p.getPhoneNumber());
		}
	}
	
	public void test6() {
		
	}
	
	public void test7() {
		
	}
	
	public void test8() {
		
	}
}
