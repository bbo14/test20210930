package Test0929;			//안은준_소프트웨어개발방법론활용

import java.util.Scanner;

//변수 생성
class Member {
	private String id;
	private String name;
	private String loc;

	public Member(String id, String name, String loc) {
		this.id = id;
		this.name = name;
		this.loc = loc;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLoc() {
		return loc;
	}
}

public class HealthClub {

	private Scanner sc;
	private Member[] mArray;

	public HealthClub() {
		sc = new Scanner(System.in);
	}
	
	//상위 메뉴
	void read() {

		System.out.println("=======헬스클럽 회원관리 프로그램========");
		System.out.println("1.회원 정보관리         |    2.프로그램 종료");
		System.out.println("================================");
		System.out.println("메뉴를 선택하세요. >>");

		int sn = sc.nextInt();

		if (sn == 1) {
			run();
		} else if (sn == 2) {
			System.out.println("프로그램을 종료합니다");
			return;
		} else {
			System.out.println("메뉴를 잘못 입력하였습니다.");
			read();
			return;
		}
	}

	// 11.일반회원 정보입력
	void account() {
		System.out.println("가입할 회원 수를 입력하세요.>>");
		// member number
		int mn = sc.nextInt();
		mArray = new Member[mn];

		for (int i = 0; i < mArray.length; i++) {

			System.out.println("회원정보를 입력하세요.");
			System.out.print("회원 아이디");
			// 아이디: id
			String id = sc.next();
			System.out.print("회원 이름");
			// 이름: name
			String name = sc.next();
			System.out.print("회원 지역");
			// 지역: location
			String loc = sc.next();
			mArray[i] = new Member(id, name, loc);
		}
	}

	// 22.일반회원 정보삭제
	void delete() {
		System.out.println("회원 정보가 삭제되었습니다. 프로그램을 재시작하세요.");
	}

	// 33.일반회원 정보확인
	void check() {
		try {
			System.out.println("등록된 회원수는" + mArray.length + "입니다.");
			for (int i = 0; i < mArray.length; i++) {
				System.out.println("회원 번호" + (i + 1));
				System.out.println("회원 아이디" + mArray[i].getId());
				System.out.println("회원 이름" + mArray[i].getName());
				System.out.println("회원 지역" + mArray[i].getLoc());
			}

		} catch (Exception e) {
			System.out.println("일반회원 정보입력란에 회원정보를 먼저 입력해주세요.");
		}

	}
	
	//하위 메뉴
	void run() {
		while (true) {
			
			System.out.println("==========================일반회원 정보관리==========================");
			System.out.println("11.일반회원 정보입력  | 22.일반회원 정보삭제   | 33.일반회원 정보확인  | 0. 이전단계");
			System.out.println("=============================================================");
			System.out.println("메뉴를 선택하세요. >>");

			// 메뉴 선택 : member data number
			int mdn = sc.nextInt();

			if (mdn == 11) {
				account();
			} else if (mdn == 22) {
				delete();
				return;
			} else if (mdn == 33) {
				check();
			} else if (mdn == 0) {
				System.out.println("상위메뉴로 이동합니다.");
				read();
				return;
			} else {
				System.out.println("메뉴선택이 잘못됐습니다!");
			}
		}
	}
	
	//상위 메뉴부터 출력시켜 상호작용
	public static void main(String[] args) {
		new HealthClub().read();
	}
}