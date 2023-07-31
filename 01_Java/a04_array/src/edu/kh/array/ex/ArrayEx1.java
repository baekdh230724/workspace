package edu.kh.array.ex;

import java.util.Scanner;

public class ArrayEx1 {
	
	/* 배열 (자료구조)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 
	 * - 묶여진 변수들은 하나의 이름(배열명)으로 불려지고
	 *   각 변수들은 index를 이용해서 구분하게 된다
	 *   
	 *   (index : 색인, 자료의 위치)
	 *   
	 * - index의 번호는 0부터 시작
	 */
	
	// 배열 할당, 선언, 초기화
	public void ex1() {
		
		// 변수 선언
		int a; // int 자료형을 저장할 변수 a 선언(메모리 공간 할당)
		
		
		// 배열 선언
		int[] arr; 
		// int 자료형 변수를 묶어서 다루는 배열 arr을 선언
		// int[]은 참조형
		
		
		
		// 변수 대입 (== 값 자체를 대입)
		a = 10;
		
		// 배열 대입 (== 할당)
		arr = new int[3];
		// new 연산자 : Heap 영역에 새로운 메모리를 할당
		// (메모리 할당 == 메모리 공간을 차지한다)
		
		// int[3] : int 변수 3칸짜리 배열
		
		// new int[3]
		// Heap 영역에 int 변수 3칸짜리 배열을 새롭게 할당
		// -> 할당된 배열에 시작 주소가 생김
		
		
		// arr = new int[3]
		// - new int[3]으로 생성된 배열의 시작 주소를
		//   arr에 대입
		
		// -> arr 호출 시
		//    arr에 저장된 주소를 참조해
		//    Heap 영역에 할당된 배열을 찾아감
		//    --> 이래서 int[]을 "참조형"이라고 한다.
		
		// * 배열 다루기 *
		System.out.println("arr : " + arr); // [I@6f2b958e -> 주소값 출력
		
		System.out.println("arr[0] : " + arr[0]); // 0 -> 기본값
		System.out.println("arr[1] : " + arr[1]); // 0
		System.out.println("arr[2] : " + arr[2]); // 0
		 
	}
	
	
	// 배열 선언 및 할당 + 직접 초기화
	public void ex2() {
		
		// int 자료형 4개를 묶음으로 다루는 배열 numbers를
		// 선언 및 할당해라
		
		//int[] numbers; // 선언
		//numbers = new int[4]; // 할당
 		
		int[] numbers = new int[4]; // 선언 및 할당
				
		// new 연산자 : Heap 영역에 메모리를 새롭게 할당		
		
		
		// * 배열 직접 초기화 *
		
		numbers[0] = 10;
		numbers[1] = 100;
		numbers[2] = 1000;
		numbers[3] = 10000;
		
		// * 인덱스는 0 부터 시작해서
		//   배열의 크기(길이) - 1 까지 이다.
		
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		
		// * 배열 + 반복문(for) 
		for(int i=0 ; i<=3 ; i++) {
			System.out.printf("numbers[%d] = %d \n", i, numbers[i]);
		}
		
		System.out.println("-------------------------");
		
		// 10000
		// 1000
		// 100
		// 10
		
		for(int i=3 ; i >= 0 ; i--) {
			System.out.println(numbers[i]);
		}
	}
	
	
	// 3명의 키를 입력 받아 
	// 입력받은 키 + 평균 키 출력  (배열 이용)
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		// double형 배열을 참조할 변수 heightArray 선언(주소 저장) 후
		// Heap 영역에 double 3칸짜리 배열을 할당하여 
		// 그 주소를 heightArray 저장한다.
		double[] heightArray = new double[3];
		
		// 3명의 키 입력
		for(int i=0 ; i<3 ; i++) {
			System.out.print(i + "번 키 입력 : ");
			heightArray[i] = sc.nextDouble();
		}
		
		System.out.println("---------------");
		
		// * 배열명.length : 배열의 길이(크기)를 반환 *
		
		double sum = 0.0;
		
		for(int i=0 ; i<heightArray.length ; i++) {
			System.out.printf("[%d번째의 키] = %.1f \n", i, heightArray[i]);
			
			sum += heightArray[i]; // 합계
		}
		
		System.out.println("평균 : " + sum/3.0);
		
	}
	
	
	// 점심 메뉴 뽑기 프로그램
	// (배열 선언과 동시에 초기화)
	public void ex4() {
		
		// 문자열 배열 선언 및 할당
//		String[] menuArray = new String[5];
//		menuArray[0] = "햄버거";
//		menuArray[1] = "돈까스";
//		menuArray[2] = "제육볶음";
//		menuArray[3] = "샐러드";
//		menuArray[4] = "닭갈비";
		
		
		// 배열 선언과 동시에 초기화
		String[] menuArray = {"햄버거", "돈까스", "제육볶음" 
							 , "샐러드", "닭갈비", "순대국밥"
							 , "평양냉면", "삼각김밥+컵라면"
							 , "도시락", "육회비빔밥"};
		
		
		// 배열 index범위 내 난수를 발생
		int index = (int)(Math.random() * menuArray.length);
				//  (int)(0.0 <= x < 5.0)
				//  (0 <= x < 5) --> 0 1 2 3 4
		
		System.out.println("오늘의 메뉴 : " + menuArray[index]);
	}
	
	
	// 분식집 주문 프로그램
	public void ex5() {
		
		// 배열 2개를 생성 후
		// 같은 인덱스 번호에 메뉴명, 가격을 작성
		
		String[] menus = {"원조김밥", "참치김밥", "치즈김밥", "라면", "떡볶이"};
		
		int[] prices = {3000, 4000, 4000, 3500, 5000};
		
		Scanner sc = new Scanner(System.in);
		
		String orderMenu = ""; // 주문한 메뉴를 저장할 변수
		int sum = 0; // 주문한 메뉴의 가격을 저장할 변수
		
		while(true) {
			System.out.println("----- 메뉴 -----");
			
			// 메뉴 출력
			for(int i=0 ; i<menus.length ; i++) {
				System.out.printf("%d) %s (%d원) \n", i, menus[i], prices[i]);
			}
			System.out.println("9) 주문 완료");
			
			System.out.print("메뉴 선택 >> ");
			int input = sc.nextInt();
		
			System.out.println();
			
			// 만약에 9를 입력한 경우 반복문을 멈춰라
			if(input == 9) {
				break;
			} 
			
			// 메뉴 인덱스 범위를 초과할 때 "잘못 입력" 출력
			else if(input < 0 || input >= menus.length ) {
				System.out.println("잘못 입력");
			}
			
			else { // 정상 입력  ->  누적
				orderMenu += menus[input] + " ";
				sum += prices[input];
			}
	
		} // while 종료
		
		System.out.println("주문한 메뉴 : " + orderMenu);
		System.out.println("합계 " + sum + "원");
		
	}
	
	
	
	// 분식집 주문 프로그램(업그레이드 버전)
	public void ex5a() {
		
		// 배열 2개를 생성 후
		// 같은 인덱스 번호에 메뉴명, 가격을 작성
		
		String[] menus = {"원조김밥", "참치김밥", "치즈김밥", "라면", "떡볶이"};
		int[] prices = {3000, 4000, 4000, 3500, 5000};
		Scanner sc = new Scanner(System.in);
		
		int[] counts = new int[menus.length]; // 주문한 메뉴 개수 카운트
		int sum = 0; // 주문한 메뉴의 가격을 저장할 변수
		
		System.out.println(" --------------------------");
		System.out.println("|   분식집 주문 프로그램   |");
		System.out.println(" --------------------------");
		
		
		while(true) {
			System.out.println("*********** 메뉴 ***********");
			
			// 메뉴 출력
			for(int i=0 ; i<menus.length ; i++) {
				
				// 자릿수를 나타내는 ,를 가격에 찍어서 문자열로 만들어 저장
				String temp = prices[i] / 1000 + "," + (prices[i] % 1000 != 0 ? prices[i] % 1000 : "000");
				
				System.out.printf("%d) %s (%s원) \n", i, menus[i], temp);
				
			}
			
			
			System.out.println("9) 주문 완료");
			System.out.println("****************************");
			
			System.out.print("메뉴 선택 >> ");
			int input = sc.nextInt();
			
			System.out.println();
			
			// 만약에 9를 입력한 경우 반복문을 멈춰라
			if(input == 9) {
				break;
			} 
			
			// 메뉴 인덱스 범위를 초과할 때 "잘못 입력" 출력
			else if(input < 0 || input >= menus.length ) {
				System.out.println("잘못 입력");
			}
			
			else { // 정상 입력  
				counts[input]++; // 주문한 메뉴 카운트 증ㄱ사
				sum += prices[input]; // 가격 누적
			}
			
		} // while 종료
		
		System.out.println("===== 주문한 메뉴 =====");
		
		for(int i=0 ; i<menus.length ; i++) {
			if(counts[i] > 0) {
				String temp = prices[i] / 1000 + "," + (prices[i] % 1000 != 0 ? prices[i] % 1000 : "000");
				System.out.printf("%s(%s원) : %d개 \n", menus[i], temp, counts[i]);
			}
		}
		
		
		String temp = sum / 1000 + "," + (sum % 1000 != 0 ? sum % 1000 : "000");
		System.out.println("합계 : " + temp + "원");
		
	}
	
	
	
	
	
	
	
	
	
}
