DROP TABLE "COMMENT";
DROP TABLE BOARD;
DROP TABLE MEMBER;

-------------------------------------------------------------------------------------------
-- MEMBER 테이블 --

CREATE TABLE MEMBER(
	MEMBER_NO 		NUMBER NOT NULL,
	MEMBER_EMAIL 	VARCHAR2(50) NOT NULL,
	MEMBER_PW 		VARCHAR2(100) NOT NULL,
	MEMBER_NICKNAME	VARCHAR2(30) NOT NULL,
	MEMBER_TEL 		CHAR(11) NOT NULL,
	MEMBER_ADDRESS 	VARCHAR2(300),
	ENROLL_DATE		DATE DEFAULT SYSDATE NOT NULL ,
	MEMBER_DEL_FL 	CHAR(1) DEFAULT 'N' NOT NULL
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MEMBER_NO);

ALTER TABLE MEMBER ADD CONSTRAINT MEM_DEL_CHK CHECK(MEMBER_DEL_FL IN ('Y', 'N'));


COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원 번호';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '회원 이메일';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NICKNAME IS '회원 닉네임';
COMMENT ON COLUMN MEMBER.MEMBER_TEL IS '휴대폰 번호(- 없음)';
COMMENT ON COLUMN MEMBER.MEMBER_ADDRESS IS '회원 주소';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';
COMMENT ON COLUMN MEMBER.MEMBER_DEL_FL IS '탈퇴여부(N : 탈퇴X , Y : 탈퇴 O)';

-------------------------------------------------------------------------------------------
-- BOARD 테이블 --

CREATE TABLE BOARD (
	BOARD_NO		NUMBER NOT NULL,
	BOARD_TITLE		VARCHAR2(150) NOT NULL,
	BOARD_CONTENT	VARCHAR2(4000) NOT NULL,
	B_CREATE_DATE	DATE DEFAULT SYSDATE NOT NULL,
	READ_COUNT		NUMBER DEFAULT 0 NOT NULL,
	BOARD_DEL_FL	CHAR(1) DEFAULT 'N' NOT NULL,
	MEMBER_NO		NUMBER NOT NULL
);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY(BOARD_NO);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_DEL_CHK CHECK(BOARD_DEL_FL IN ('Y', 'N'));

ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK 
FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER;


COMMENT ON COLUMN BOARD.BOARD_NO IS '게시글 번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '게시글 제목';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '게시글 내용';
COMMENT ON COLUMN BOARD.B_CREATE_DATE IS '게시글 작성일';
COMMENT ON COLUMN BOARD.READ_COUNT IS '조회수';
COMMENT ON COLUMN BOARD.BOARD_DEL_FL IS '삭제 여부(N : 삭제X , Y : 삭제O)';
COMMENT ON COLUMN BOARD.MEMBER_NO IS '작성자 회원 번호';

-------------------------------------------------------------------------------------------
-- "COMMENT" 테이블 --

CREATE TABLE "COMMENT" (
	COMMENT_NO		NUMBER NOT NULL,
	COMMENT_CONTENT	VARCHAR2(4000) NOT NULL,
	C_CREATE_DATE	DATE DEFAULT SYSDATE NOT NULL,
	COMMENT_DEL_FL	CHAR(1)	DEFAULT 'N'	NOT NULL,
	BOARD_NO		NUMBER NOT NULL,
	MEMBER_NO		NUMBER NOT NULL
);

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_PK PRIMARY KEY(COMMENT_NO);

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_DEL_CHK CHECK(COMMENT_DEL_FL IN ('Y', 'N'));

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_BOARD_FK 
FOREIGN KEY(BOARD_NO) REFERENCES BOARD;

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_MEMBER_FK 
FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER;



COMMENT ON COLUMN "COMMENT".COMMENT_NO IS '댓글 번호';
COMMENT ON COLUMN "COMMENT".COMMENT_CONTENT IS '댓글 내용';
COMMENT ON COLUMN "COMMENT".C_CREATE_DATE IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT".COMMENT_DEL_FL IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';
COMMENT ON COLUMN "COMMENT".BOARD_NO IS '댓글이 작성된 게시글 번호';
COMMENT ON COLUMN "COMMENT".MEMBER_NO IS '댓글 작성자 회원 번호';
