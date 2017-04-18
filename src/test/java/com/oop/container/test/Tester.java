package com.oop.container.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;

import com.oop.container.CallRecord;
import com.oop.container.Person;
import com.oop.container.Phone;
import com.oop.container.SMSRecord;

public class Tester {
	private Phone phone;
	public Tester() {
		phone = null;
	}
	public void runTest() {
		// Main runner
		phone = new Phone();
		try {
			System.out.println("TEST1 Start**********************************************************");
			test1();
			System.out.println("TEST2 Start**********************************************************");
			test2();
			System.out.println("TEST3 Start**********************************************************");
			test3();
			System.out.println("TEST4 Start**********************************************************");
			test4();
			System.out.println("TEST5 Start**********************************************************");
			test5();
			System.out.println("TEST6 Start**********************************************************");
			test6();
			System.out.println("TEST7 Start**********************************************************");
			test7();
			System.out.println("TEST8 Start**********************************************************");
			test8();
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
	public void test1() throws Exception {
		/*
		 * 20 개의 Entry를 생성하여서 Phone Library의 In-Memory Collection 과 File에 저장하십시오.  이를 File에서 읽어, 깔끔하게 화면에 Display하세요.
		 */
		if(phone == null) throw new Exception();
		// 20개의 Entry를 생성
		for(int i=0; i<20; ++i) {
			Person unit = new Person("PERSON"+i, "0101234123"+i);
			phone.personContainer.add(unit);
		}
		// saveFile.json 에 저장
		phone.saveToJSONFile("saveFile.json");
	}
	public void test2() throws Exception {
		/*
		 * 이름의 Alphabet 순서로 Sorting하세요. 화면에 Display하시고 File에 Save하세요
		 */
		if(phone == null) throw new Exception();
		// Ordered map 형태의 컨테이너에 저장되 있으므로 이미 정렬되어 있음
		Iterator<String> it = phone.personContainer.nicknameIterator();
		while(it.hasNext()) {
			NavigableSet<Person> units = phone.personContainer.findByNickname(it.next());
			for(Person unit: units) {
				System.out.println(unit.toJSONObject().toJSONString());
			}
		}
		// Save
		phone.saveToJSONFile("saveFile.json");
	}
	public void test3() throws Exception {
		/*
		 * Test Application에서 전화번호부의 10 개의 Entry를 추가로 생성하여서 추가하세요.  이때 Sorting한 상태를 계속 유지해야 합니다. 이를 확인할 수 있도록 보여주세요.  그리고 이를 File에 저장하고 읽으세요. 여전히 Sort된 상태에 있나요?
		 */
		if(phone == null) throw new Exception();
		// 10개의 엔트리를 추가로 생성
		for(int i=20; i<30; ++i) {
			Person unit = new Person("PERSON"+i, "0101234123"+i);
			phone.personContainer.add(unit);
		}
		// 다시 모든 엔트리를 출력
		Iterator<String> it = phone.personContainer.nicknameIterator();
		while(it.hasNext()) {
			NavigableSet<Person> units = phone.personContainer.findByNickname(it.next());
			for(Person unit: units) {
				System.out.println(unit.toJSONObject().toJSONString());
			}
		}
	}
	public void test4() throws Exception {
		/*
		 * Text Files을 Editor로 편집하여서 3개의Entries를 추가하고, 2개를 변경하고, 1개를 지우세요.  이를 제대로 읽어서 다시 Sorting하여서 보여주시고 저장하세요.
		 */
		if(phone == null) throw new Exception();
		phone.saveToJSONFile("modifyTest.json");
		System.out.println("modifyTest.json 파일을 수정하고 Enter를 눌러서 계속하세요");
		System.in.read();
		phone.loadFromJSONFile("modifyTest.json");
		Iterator<String> it = phone.personContainer.nicknameIterator();
		while(it.hasNext()) {
			NavigableSet<Person> units = phone.personContainer.findByNickname(it.next());
			for(Person unit: units) {
				System.out.println(unit.toJSONObject().toJSONString());
			}
		}
	}
	public void test5() throws Exception {
		/*
		 * 전화번호부에서 주어진 이름을 갖는 Entry를 찾는 기능을 구현하시고 Test하세요.  이를 결과로서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		//찾을 이름을 받음
		System.out.println("targetName:");
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String targetName = consoleReader.readLine();
		NavigableSet<Person> units = phone.personContainer.findByNickname(targetName);
		System.out.println("results:");
		for(Person unit: units) {
			System.out.println(unit.toJSONObject().toJSONString());
		}
		if(units.size() <= 0) {
			System.out.println("Not found result");
		}
	}
	public void test6() throws Exception {
		/*
		 * 전화번호를 가지고 Entry를 찾는 효율적인 Algorithm에 대한 설계를 하고, 구현 및 Test를 하십시오.
		 */
		if(phone == null) throw new Exception();
		// map으로 되있으므로 log arithemetic 시간 안에 찾을 수 있다.
		System.out.println("targetPhoneNumber:");
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String targetName = consoleReader.readLine();
		NavigableSet<Person> units = phone.personContainer.findByPhoneNumber(targetName);
		System.out.println("results:");
		for(Person unit: units) {
			System.out.println(unit.toJSONObject().toJSONString());
		}
		if(units.size() <= 0) {
			System.out.println("Not found result");
		}
	}
	public void test7() throws Exception {
		/*
		 * 이를 바탕으로 수발신 SMS Message를 Browse하고, 선택해서 보여주는 기능을 구현하세요.  SMS 메시지를 20개 만들어서 Test하여주세요.  이를 File에 Save하고 읽어서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		// SMS 20개를 생성
		for(int i=0; i<20; ++i) {
			SMSRecord unit = new SMSRecord("0101234234"+i, "01012349876", "This is message of "+i);
			phone.smsContainer.add(unit);
		}
		for(Integer key: phone.smsContainer) {
			SMSRecord record = phone.smsContainer.get(key);
			System.out.println(record.toJSONObject().toJSONString());
		}
		
	}
	public void test8() throws Exception {
		/*
		 * 수신전화에 대해서 Caller ID에 기반하여, 필요시 발신자의 정보를 보여주는 기능을 구현하세요. 20개의 수발신전화 Entry를 만드시고 File에 Save하고 읽어서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		// 20 번 전화를 받음, 10번은 이미 알고있는 사람에게서, 10번은 모르는 사람에게서
		ArrayList<String> fromNumbers = new ArrayList<String>();
		for(int i=0; i<10; ++i) { // 아는 사람
			fromNumbers.add("0101234123"+i);
		}
		for(int i=0; i<10; ++i) { // 모르는 사람
			fromNumbers.add("0191234123"+i);
		}
		for(String fromNumber: fromNumbers) { 
			NavigableSet<Person> suspects = phone.personContainer.findByPhoneNumber(fromNumber);
			System.out.println("전화가 "+fromNumber+"로 부터 왔습니다");
			if(suspects.size() == 1) {
				System.out.println(suspects.iterator().next().getNickname() + "으로 부터 왔습니다");
			}
			else if(suspects.size() > 0) {
				System.out.println("다음 중 한명으로 부터의 전화입니다");
				for(Person p: suspects) {
					System.out.println("후보: " + p.getNickname());
				}
			}
			// Generate record
			CallRecord record = new CallRecord(fromNumber, "01011112222");
			phone.callContainer.add(record);
		}
		System.out.println("Entry:"); // Print Entries
		for(Integer key: phone.callContainer) {
			CallRecord unit = phone.callContainer.get(key);
			System.out.println(unit.toJSONObject().toJSONString());
		}
	}
}
