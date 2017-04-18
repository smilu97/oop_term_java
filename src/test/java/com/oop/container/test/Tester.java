package com.oop.container.test;

import com.oop.container.Phone;

public class Tester {
	private Phone phone;
	Tester() {
		phone = null;
	}
	public void runTest() {
		phone = new Phone();
		try {
			test1();
			test2();
			test3();
			test4();
			test5();
			test6();
			test7();
			test8();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void test1() throws Exception {
		/*
		 * 20 개의 Entry를 생성하여서 Phone Library의 In-Memory Collection 과 File에 저장하십시오.  이를 File에서 읽어, 깔끔하게 화면에 Display하세요.
		 */
		if(phone == null) throw new Exception();
	}
	public void test2() throws Exception {
		/*
		 * 이름의 Alphabet 순서로 Sorting하세요. 화면에 Display하시고 File에 Save하세요
		 */
		if(phone == null) throw new Exception();
	}
	public void test3() throws Exception {
		/*
		 * Test Application에서 전화번호부의 10 개의 Entry를 추가로 생성하여서 추가하세요.  이때 Sorting한 상태를 계속 유지해야 합니다. 이를 확인할 수 있도록 보여주세요.  그리고 이를 File에 저장하고 읽으세요. 여전히 Sort된 상태에 있나요?
		 */
		if(phone == null) throw new Exception();
	}
	public void test4() throws Exception {
		/*
		 * Text Files을 Editor로 편집하여서 3개의Entries를 추가하고, 2개를 변경하고, 1개를 지우세요.  이를 제대로 읽어서 다시 Sorting하여서 보여주시고 저장하세요.
		 */
		if(phone == null) throw new Exception();
		
	}
	public void test5() throws Exception {
		/*
		 * 전화번호부에서 주어진 이름을 갖는 Entry를 찾는 기능을 구현하시고 Test하세요.  이를 결과로서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		
	}
	public void test6() throws Exception {
		/*
		 * 전화번호를 가지고 Entry를 찾는 효율적인 Algorithm에 대한 설계를 하고, 구현 및 Test를 하십시오.
		 */
		if(phone == null) throw new Exception();
		
	}
	public void test7() throws Exception {
		/*
		 * 이를 바탕으로 수발신 SMS Message를 Browse하고, 선택해서 보여주는 기능을 구현하세요.  SMS 메시지를 20개 만들어서 Test하여주세요.  이를 File에 Save하고 읽어서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		
	}
	public void test8() throws Exception {
		/*
		 * 수신전화에 대해서 Caller ID에 기반하여, 필요시 발신자의 정보를 보여주는 기능을 구현하세요. 20개의 수발신전화 Entry를 만드시고 File에 Save하고 읽어서 보여주세요.
		 */
		if(phone == null) throw new Exception();
		
	}
}
