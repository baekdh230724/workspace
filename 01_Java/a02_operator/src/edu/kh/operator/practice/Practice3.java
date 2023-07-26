package edu.kh.operator.practice;

import java.util.Scanner;

/*
정수를 하나 입력 받아 양수/음수/0 을 구분하세요.

[실행화면]
정수 입력 : 3
양수

정수 입력 : -5
음수

정수 입력 : 0
0
*/

public class Practice3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt();
		
		String result = input == 0 ? "0" : (input > 0 ? "양수" : "음수");
		
		System.out.println(result);
		
	}
}
