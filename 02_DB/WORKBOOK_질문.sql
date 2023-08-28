-- 1-7번
-- 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는 과목들은
-- 어떤 과목인지 과목 번호를 조회하시오
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 2-2번
-- 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 두 명 있다고 한다. 
-- 그 교수의 이름과 주민번호를 조회하는 SQL을 작성하시오
SELECT PROFESSOR_NAME, PROFESSOR_SSN 
FROM TB_PROFESSOR 
--WHERE LENGTH(PROFESSOR_NAME) != 3;
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 2-3번
-- 춘 기술대학교의 남자 교수들의 이름과 나이를 나이 오름차순으로 조회하시오.
-- (단, 교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수이름"으로 한다. 나이는 '만'으로 계산한다.)
SELECT  PROFESSOR_NAME 교수이름,
	FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('19' || SUBSTR(PROFESSOR_SSN,1,6), 'YYYYMMDD')) / 12)
	나이
FROM TB_PROFESSOR 
WHERE SUBSTR(PROFESSOR_SSN,8,1) = '1'
ORDER BY 나이;



-- 2-5번
-- 춘 기술대학교의 재수생 입학자를 조회하시오.
-- (19살에 입학하면 재수를 하지 않은 것!)
SELECT STUDENT_NO, STUDENT_NAME 
FROM TB_STUDENT 
WHERE EXTRACT (YEAR FROM ENTRANCE_DATE)      
	- EXTRACT (YEAR FROM  TO_DATE('19' || SUBSTR(STUDENT_SSN,1,6), 'YYYYMMDD') )
	> 19;



-- 2-7번
-- 학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성하시오.
-- 단, 이때 출력 화면의 헤더는 "평점"이라고 찍히게 하고, 
-- 점수는 반올림하여 소수점 이하 한자리까지만 표시한다
SELECT ROUND( AVG(POINT) , 1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A517178';


-- 2-10번
-- 학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL문을 작성하시오.
-- 단, 이때 출력화면의 헤더는 "년도", "년도 별 평점"이라고 찍히게 하고, 
-- 점수는 반올림하여 소수점 이하 한자리까지만 표시한다
SELECT SUBSTR(TERM_NO,1,4) 년도, ROUND(AVG(POINT), 1 ) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4);


-- 2-11번
-- 학과 별 휴학생 수를 파악하고자 한다. 
-- 학과 번호와 휴학생 수를 조회하는 SQL을 작성하시오.
SELECT DEPARTMENT_NO, 
	COUNT( DECODE(ABSENCE_YN, 'Y', 'Y') ),
	SUM( DECODE(ABSENCE_YN, 'Y', 1, 'N', 0) )
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;



-- 2-12번
-- 춘 대학교에 다니는 동명이인인 학생들의 
-- 이름, 동명인 수를 조회하시오.
SELECT STUDENT_NAME "이름", COUNT(*) "동명인 수"
FROM TB_STUDENT 
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1
ORDER BY STUDENT_NAME ;


-- 2-13번
-- 학번이 A112113인 김고운 학생의 학점을 조회하려고 한다.
-- 년도, 학기 별 평점과 년도 별 누적 평점, 총 평점을 구하는 SQL을 작성하시오.
-- (단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)

SELECT NVL(SUBSTR(TERM_NO,1,4), ' ') 년도, 
	NVL(SUBSTR(TERM_NO,5,2), ' ') 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP( SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2) );


-- 3-10번
-- 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 조회하시오.
-- (단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)
SELECT STUDENT_NO , STUDENT_NAME, ROUND(AVG(POINT), 1) "전체 평점"
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO , STUDENT_NAME
ORDER BY STUDENT_NO;



-- 3-13번
-- 예체능 계열 과목 중 과목 담당교수를 한 명도 배정받지 못한 과목을 찾아
-- 과목 이름, 학과 이름을 조회하시오.
SELECT CLASS_NAME, DEPARTMENT_NO 
FROM TB_CLASS 
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;




-- 3-15번
-- 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아
-- 학생의 학번, 이름, 학과 이름, 평점을 조회하시오.
SELECT STUDENT_NO "학번", STUDENT_NAME "이름", 
	DEPARTMENT_NAME "학과 이름",
	AVG(POINT) "평점"
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
WHERE ABSENCE_YN != 'Y'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4
ORDER BY "학번";








