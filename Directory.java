package test0915;

import java.util.Scanner;

class Phone {

	//필드 name(이름) pn(전화번호)생성
	private String name;
	private String pn;

	Phone(String name, String pn) {
		this.name = name;
		this.pn = pn;
	}

	public String getName() {
		return name;
	}

	public String getPn() {
		return pn;
	}
}

public class Directory {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Phone phone[];
		
		int i = 0;
		
		System.out.print("인원수>>");
		int num = scan.nextInt();
		//인원 수 (num) 만큼 입력(저장) 및 phone 배열에 추가
		phone = new Phone[num];
		
		for (i = 0; i < phone.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			//입력 메소드는 스페이스바(한칸 간격으로 구분 가능)
			String name = scan.next();
			String pn = scan.next();
			
			phone[i] = new Phone(name, pn);
		}
		
		System.out.println("저장되었습니다...");
		
		while (true) {
			System.out.print("검색할 이름>>");
			String name = scan.next();
			//phone배열에서 찾아 출력.
			for (i = 0; i < num; i++) {
				if (name.equals(phone[i].getName())) {
					System.out.println(name + "의 번호는 " + phone[i].getPn() + " 입니다.");
					i--;
					break;
				}
			}
			//'그만' 입력할 경우
			if (name.equals("그만"))
				break;
			// 'phone[] 배열에 포함되지 않은 name인 경우 '
			else if (i == num)
				System.out.println(name + " 이 없습니다.");
		}
		scan.close();
	}
}