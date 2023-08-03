package edu.kh.oarr.model.dto;

public class Student {
	private int grade; 
	private int ban;
	private int number;
	private String name; 
	private int kor;
	private int eng;
	private int math;
	
	// 생성자 : 객체 생성 시 필드 초기화, 특정 기능을 수행하기하는
	//        객체 생성 시 수행되는 기능
	
	public Student() {} // 기본 생성자
	
	public Student(int grade, int ban, int number, String name) {
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
	}
	
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	
	
}