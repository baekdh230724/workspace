package edu.kh.inheritance.model.dto;

public class Child2 extends Parent{
	private String house;
	
	public Child2() {
		System.out.println("Child2() 기본 생성자로 자식 객체 생성");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자로 자식 객체 생성");
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
	public String toString() {
		// 부모로 부터 상속 받은 멤버(필드,메서드)를 
		// 자식이 자신의 것 처럼 사용 가능
//		setLastName(house);
//		setMoney(10);
//		getMoney();
//		getLastName();
		
		return house;
	}
	
	
	
	
}
