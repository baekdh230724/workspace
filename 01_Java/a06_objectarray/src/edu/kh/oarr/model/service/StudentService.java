package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;

public class StudentService {

	// 필드
	private Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10개의 묶음 Student[] 을 할당하고
	// 그 주소를 studentArr에 대입
	
	// studentArr[0], studentArr[1], studentArr[2] ...
	// 각 배열 요소 하나하나는 Student 객체 참조 변수가 된다.
	
	
	//- 기본 생성자
	//	 학생 객체 배열에 들어갈 샘플 학생 데이터를 3개 추가
	public StudentService() {
		
		// ctrl + alt + 위아래 방향키 : 복사
		studentArr[0] = new Student(1,2,3, "홍길동");
		studentArr[1] = new Student(2,3,13, "박철수");
		studentArr[2] = new Student(3,7,23, "최미영");

		Random random = new Random(); // 랜덤 객체 생성(자바에서 제공)
		
		for(int i=0 ; i<studentArr.length ; i++) {
			// studentArr[3] 부터 참조하는 학생 객체가 없음
			// studentArr[3] 부터 저장된 값은 null
			// * null : 참조하는 객체가 없음을 뜻하는 값 *
			
			if(studentArr[i] == null) {
				break; // 학생 객체가 없으면 반복문 멈춤
			}
			
			// random.nextInt(101)
			// -  0 이상 101 미만의 정수형 난수를 반환
			studentArr[i].setKor( random.nextInt(101) );
			studentArr[i].setEng( random.nextInt(101) );
			studentArr[i].setMath( random.nextInt(101) );
		}
	}

	
	
	
	/** 학생 추가 서비스 입니다.*/
	public boolean addStudent(int grade, int ban, int number, String name) {
		
		// 1. studentArr의 요소 중
		//   참조하는게 없는 배열 요소를 찾아
		//   그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입
		//   true 반환
		for(int i=0 ; i<studentArr.length ; i++) {
			if(studentArr[i] == null) { // 참조하는게 없을 경우
				// 학생 객체를 생성하여 주소를 대입
				studentArr[i] = new Student(grade, ban, number, name);
				
				// return : 현재 메서드를 즉시 멈추고 호출한 곳으로 돌아감
				return true;
			}
		}
		
		// 2. studentArr의 요소 중
		//   참조하는게 없는 배열 요소가 없을 경우 (꽉찬 경우)
		//   false를 반환
		return false;
	}



	/** 학생 전체 조회 서비스 */
	public Student[] selectAll() {
		return studentArr;
	}

	
	/** 학생 1명 정보 조회(인덱스) 서비스 */
	public Student selectIndex(int index) {
		
		// index가 배열 범위를 초과 하거나
		// studentArr[index] 요소가 저장한 값이 null인 경우
		// null 반환
		if( index < 0   || 
			index >= studentArr.length   || 
			studentArr[index] == null) {
			return null;
		}
		
		// index번째 요소에 학생 객체를 참조하는 주소가 있는 경우
		// 그 주소를 반환
		return studentArr[index];
	}



	/** 학생 1명 점수 조회(점수, 합계, 평균) 서비스*/
	public String selectScore(int index) {
		
		if(	index < 0   ||  index >= studentArr.length   ||
			studentArr[index] == null) {
			return "해당 인덱스에 학생 정보가 존재하지 않습니다.";
		}
		
		// studentArr[index] 쓰기 기니까 짧은 이름의 변수에 주소만 복사
		Student s = studentArr[index];
		int sum = s.getKor() + s.getEng() + s.getMath(); // 합계
		
		return String.format(
			"[%s] 국어:%d, 영어:%d, 수학:%d, 합계:%d, 평균:%.1f", 
			s.getName(), s.getKor(), s.getEng(), s.getMath(), sum , sum/3.0);
	}




	
	
	
	
	
	
}
