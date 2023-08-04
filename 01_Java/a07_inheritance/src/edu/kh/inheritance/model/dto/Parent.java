package edu.kh.inheritance.model.dto;

public class Parent {

	private int money = 100_000_000; // 1억
	private String lastName = "홍";
	
	// 생성자
	public Parent() {
		 System.out.println("Parent() 기본 생성자로 부모 객체 생성");
	}
	
	public Parent(int money, String lastName) {
		System.out.println("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		
		this.money = money;
		this.lastName = lastName;
	}
	
	
	// getter / setter
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	// toString() : 객체의 필드를 하나의 문자열로 반환
	public String toString() {
		return money + " / " + lastName;
	}
	
	
	
	
	
	
	
}
