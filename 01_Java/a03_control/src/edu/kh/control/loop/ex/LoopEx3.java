package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx3 {

	/* while문
	 * 
	 * - 반복 조건만을 설정하는 반복문
	 * 
	 * - 조건식이 true인 경우에 계속 반복
	 *   --> 조건식이 false가 되는 상황을 같이 구현해야함
	 *       (안하면 무한루프...)
	 *       
	 * [작성법]
	 * while (조건식) {
	 * 		조건식이 true일 때 수행할 구문
	 * 		(+ 조건식이 특정 상황에 false가 되게하는 구문도 같이 작성)  
	 * }
	 * 
	 */
	
	
	public void ex1() {
		
		// 숫자 0이 입력될 때까지 프로그램 종료 X
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // 입력 받은 값을 저장할 변수
						// + 종료 조건과 관련 없는 값으로 초기화
		
		while(input != 0) { // input이 0이 아닐 때 true
			
			// true일 때 반복 수행
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
		}
	}
	
	
	
	
	
	
	
}
