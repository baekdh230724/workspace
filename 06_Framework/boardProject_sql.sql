/* 계정 생성(관리자) */

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 계정 생성
CREATE USER spring_bdh IDENTIFIED BY spring1234;

-- 권한 부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO spring_bdh;

-- 객체 생성 공간 할당
ALTER USER spring_bdh DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";

------------------------------------------------------------------
-- "" 작성 시 대/소문자 구분
--> "" 붙이는걸 권장

-- VARCHAR2(10) : 10바이트 문자열 (바이트 단위), 최대 4000바이트
-- NVARCHAR2(10) : 10글자 문자열 (유니코드), 최대 4000바이트


/* MEMBER 테이블 생성 */
CREATE TABLE "MEMBER"(
	"MEMBER_NO" NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
	"MEMBER_EMAIL" VARCHAR2(50) NOT NULL,
	"MEMBER_PW" VARCHAR2(100) NOT NULL,
	"MEMBER_NICKNAME" NVARCHAR2(10) NOT NULL,
	"MEMBER_TEL" CHAR(11) NOT NULL,
	"MEMBER_ADDRESS" NVARCHAR2(200),
	"PROFILE_IMG" VARCHAR2(300),
	"ENROLL_DATE" DATE DEFAULT SYSDATE NOT NULL,
	"MEMBER_DEL_FL" CHAR(1) DEFAULT 'N' CHECK("MEMBER_DEL_FL" IN ('Y', 'N')),
	"AUTHORITY" NUMBER DEFAULT 1 CHECK("AUTHORITY" IN (1,2))
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" 		 IS '회원 번호(SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" 	 IS '회원 이메일(ID역할)';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" 		 IS '비밀번호(암호화)';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '별명';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" 	 IS '전화번호(-없음)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS"  IS '주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" 	 IS '프로필 이미지 저장 경로';
COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" 	 IS '가입일';
COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" 	 IS '탈퇴여부(Y:탈퇴, N:정상)';
COMMENT ON COLUMN "MEMBER"."AUTHORITY" 		 IS '권한(1:일반, 2:관리자)';


-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'member01@naver.com', 'pass01',
	'회원1', '01012341234', 
	'04540^^^서울시 중구 남대문로 120^^^2층',
	NULL, DEFAULT, DEFAULT, DEFAULT
);

COMMIT;

SELECT * FROM "MEMBER"
WHERE MEMBER_NO = 3;


-- 로그인
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME ,
	MEMBER_TEL , MEMBER_ADDRESS , PROFILE_IMG , AUTHORITY ,
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE 
FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = member01@naver.com
AND MEMBER_PW = 'pass01'
;


-- 샘플 회원 비밀번호 변경(암호화 적용)
UPDATE "MEMBER" SET
MEMBER_PW = '$2a$10$9ocVv7Fdvm.k04WK72/h5egQKpBzJu0WU7MTk3cvouvlSlgl2MdMi'
WHERE MEMBER_NO = 1;

COMMIT;


-- 회원 정보 수정
-- "MEMBER" 테이블에서
-- MEMBER_NO가 일치하는 회원의
-- MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS 수정
UPDATE "MEMBER" SET
MEMBER_NICKNAME = 'TEST',
MEMBER_TEL = '01012345678',
MEMBER_ADDRESS = 'AAA^^^BBB^^^CCC'
WHERE MEMBER_NO = 2
;

ROLLBACK;

-- BCrypt 암호화 시 비밀번호를 조회한 후
-- matches() 메서드를 이용해서 비교

-- 로그인한 회원의 암호화된 비밀번호 조회
SELECT MEMBER_PW 
FROM "MEMBER"
WHERE MEMBER_NO = 회원번호  ;


-- 비밀번호 변경
UPDATE "MEMBER" SET 
MEMBER_PW = '변경된 비밀번호'
WHERE MEMBER_NO = '회원 번호'  ;



-- 회원 탈퇴
UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'Y'
WHERE MEMBER_NO = 2 ;







