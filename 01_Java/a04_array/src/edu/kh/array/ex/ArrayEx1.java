package edu.kh.array.ex;

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
	
	
	
	
	
	
}
