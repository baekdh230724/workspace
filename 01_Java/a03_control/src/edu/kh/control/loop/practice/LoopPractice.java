package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {

	/*
	1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.

	ex.
	정수를 하나 입력하세요 : 8
	1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
	*/
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1 ; i<=input ; i++) {
			sum += i;
			
			System.out.print(i);
			
			if(i < input) { 
				System.out.print(" + ");
			}
		}
		
		System.out.println(" = " + sum);
	}
	
	/*
	사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
	*/
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		// 입력 받은 두 수가 모두 1 이상인가?
		if(input1 >= 1 && input2 >=1) {
			
			// 작은 수부터 큰 수 까지 1씩 증가하며 반복
			
			// 생각을 좀 해봐야되는 방법 + 변수를 아는가?
			if(input1 > input2) {
				// 먼저 입력한 수가 더 큰 경우
				// 두 변수의 값 교환(임시 변수 필요)
				int temp = input1;
				input1 = input2;
				input2 = temp;
			}
			
			for(int i=input1 ; i<=input2 ; i++) {
				System.out.print(i + " ");
			}
			
			/*//  쉬운 방법
			if(input1 <= input2) { // 먼저 입력한 수가 작거나 같을 때
				
				for(int i=input1 ; i<=input2 ; i++) {
					System.out.print(i + " ");
				}
				
			}else { // 나중에 입력한 수가 작을 때
				
				for(int i=input2 ; i<=input1 ; i++) {
					System.out.print(i + " ");
				}
			}
			*/
			
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
		
	}
	
	
	/*
	사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
	단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
	*/
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
//		if( !(input >= 2 && input <=9) ) { // 2 ~ 9 사이가 아닐 경우
		if( input < 2 || input > 9 ) { // 2 ~ 9 사이가 아닐 경우
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			
		} else {
			for(int dan=input ; dan<=9 ; dan++) {
				System.out.printf("===== %d단 ===== \n",dan);

				for(int i=1 ; i<=9 ; i++) {
					System.out.printf("%d x %d = %d \n", dan, i , dan*i);
				}
			}
		}
	}
	
	
	
	
}
