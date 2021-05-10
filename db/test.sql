/* 노래링크(유튜브) */
DROP TABLE big5.Song 
	CASCADE CONSTRAINTS;

/* 재생추천된 노래 */
DROP TABLE big5.ListeningLog 
	CASCADE CONSTRAINTS;

/* 계정멤버 */
DROP TABLE big5.Spmem 
	CASCADE CONSTRAINTS;

/* 타인에게 추천된 노래 */
DROP TABLE big5.RecToOther 
	CASCADE CONSTRAINTS;

/* 개별평가기록 */
DROP TABLE big5.AssessmentLog 
	CASCADE CONSTRAINTS;

/* SNA영상목록 */
DROP TABLE big5.USvideo 
	CASCADE CONSTRAINTS;

/* SNA영상댓글 */
DROP TABLE big5.UScomments 
	CASCADE CONSTRAINTS;

/* 노래링크(유튜브) */
CREATE TABLE big5.Song (
	URLLINK VARCHAR2(90) NOT NULL, /* 노래링크 */
	genre VARCHAR2(60) NOT NULL, /* 노래장르정의 */
	Atmos VARCHAR2(60) NOT NULL, /* 노래분위기 */
	RecTime VARCHAR2(60) DEFAULT 0 NOT NULL /* 추천된횟수 */
);

COMMENT ON TABLE big5.Song IS '노래링크(유튜브)';

COMMENT ON COLUMN big5.Song.URLLINK IS '노래링크';

COMMENT ON COLUMN big5.Song.genre IS '노래장르정의';

COMMENT ON COLUMN big5.Song.Atmos IS '노래분위기';

COMMENT ON COLUMN big5.Song.RecTime IS '추천된횟수';

CREATE UNIQUE INDEX big5.PK_Song
	ON big5.Song (
		URLLINK ASC
	);

ALTER TABLE big5.Song
	ADD
		CONSTRAINT PK_Song
		PRIMARY KEY (
			URLLINK
		);

/* 재생추천된 노래 */
CREATE TABLE big5.ListeningLog (
	Nickname VARCHAR2(50), /* 닉네임 */
	URLLINK VARCHAR2(90) NOT NULL, /* 노래링크 */
	LisTime VARCHAR2(50) DEFAULT TO_CHAR(Sysdate,'YYYY-MM-DD HH24:MI:SS') not null, /* 청취시간 */
	Disgenre VARCHAR2(50) NOT NULL, /* 선호분위기오차2 */
	DisAtmos VARCHAR2(50) NOT NULL, /* 선호분위기오차 */
	IsSatisfied NUMBER DEFAULT 1 /* 만족여부 */
);


COMMENT ON TABLE big5.ListeningLog IS '재생추천된 노래';

COMMENT ON COLUMN big5.ListeningLog.Nickname IS '닉네임';

COMMENT ON COLUMN big5.ListeningLog.URLLINK IS '노래링크';

COMMENT ON COLUMN big5.ListeningLog.LisTime IS '청취시간';

COMMENT ON COLUMN big5.ListeningLog.Disgenre IS '선호분위기오차2';

COMMENT ON COLUMN big5.ListeningLog.DisAtmos IS '선호분위기오차';

COMMENT ON COLUMN big5.ListeningLog.IsSatisfied IS '만족여부';

/* 계정멤버 */
CREATE TABLE big5.Spmem (
	Nickname VARCHAR2(50) NOT NULL, /* 닉네임 */
	Email VARCHAR2(80) NOT NULL, /* 이메일 */
	ID VARCHAR2(50) NOT NULL, /* 아이디 */
	Password VARCHAR2(50) NOT NULL, /* 비밀번호 */
	Point NUMBER DEFAULT 0 NOT NULL, /* 포인트 */
	Prefergenre VARCHAR2(50) DEFAULT 0 NOT NULL, /* 선호장르 */
	PreferAtmos VARCHAR2(50) DEFAULT 0 NOT NULL, /* 선호분위기1 */
	PreferAtmos2 VARCHAR2(50) DEFAULT 0 NOT NULL, /* 선호분위기2 */
	PreferAtmos3 VARCHAR2(50) DEFAULT 0 NOT NULL /* 선호분위기3 */
);

COMMENT ON TABLE big5.Spmem IS '계정멤버';

COMMENT ON COLUMN big5.Spmem.Nickname IS '닉네임';

COMMENT ON COLUMN big5.Spmem.Email IS '이메일';

COMMENT ON COLUMN big5.Spmem.ID IS '아이디';

COMMENT ON COLUMN big5.Spmem.Password IS '비밀번호';

COMMENT ON COLUMN big5.Spmem.Point IS '포인트';

COMMENT ON COLUMN big5.Spmem.Prefergenre IS '선호장르';

COMMENT ON COLUMN big5.Spmem.PreferAtmos IS '선호분위기1';

COMMENT ON COLUMN big5.Spmem.PreferAtmos2 IS '선호분위기2';

COMMENT ON COLUMN big5.Spmem.PreferAtmos3 IS '선호분위기3';

CREATE UNIQUE INDEX big5.PK_Spmem
	ON big5.Spmem (
		Nickname ASC
	);

CREATE UNIQUE INDEX big5.UIX_Spmem
	ON big5.Spmem (
		ID ASC,
		Nickname ASC,
		Email ASC
	);

CREATE INDEX big5.IX_Spmem
	ON big5.Spmem (
		PreferAtmos ASC
	);

CREATE INDEX big5.IX_Spmem2
	ON big5.Spmem (
		PreferAtmos2 ASC
	);

CREATE INDEX big5.IX_Spmem3
	ON big5.Spmem (
		PreferAtmos3 ASC
	);

ALTER TABLE big5.Spmem
	ADD
		CONSTRAINT PK_Spmem
		PRIMARY KEY (
			Nickname
		);

ALTER TABLE big5.Spmem
	ADD
		CONSTRAINT UK_Spmem
		UNIQUE (
			ID,
			Nickname,
			Email
		);

/* 타인에게 추천된 노래 */
CREATE TABLE big5.RecToOther (
	SendNick VARCHAR2(50), /* 추천발신인 */
	RecNick VARCHAR2(50) NOT NULL, /* 추천수신인 */
	URLLINK VARCHAR2(90) NOT NULL, /* 노래링크 */
	RecTime VARCHAR2(50) DEFAULT TO_CHAR(Sysdate,'YYYY-MM-DD HH24:MI:SS') NOT NULL /* 추천시간 */
);

COMMENT ON TABLE big5.RecToOther IS '타인에게 추천된 노래';

COMMENT ON COLUMN big5.RecToOther.SendNick IS '추천발신인';

COMMENT ON COLUMN big5.RecToOther.RecNick IS '추천수신인';

COMMENT ON COLUMN big5.RecToOther.URLLINK IS '노래링크';

COMMENT ON COLUMN big5.RecToOther.RecTime IS '추천시간';

/* 개별평가기록 */
CREATE TABLE big5.AssessmentLog (
	URLLINK VARCHAR2(90) NOT NULL, /* 노래링크 */
	Nickname VARCHAR2(50) NOT NULL, /* 닉네임 */
	genre VARCHAR2(60) NOT NULL, /* 노래장르정의 */
	Atmos VARCHAR2(60) NOT NULL /* 노래분위기 */
);

COMMENT ON TABLE big5.AssessmentLog IS '개별평가기록';

COMMENT ON COLUMN big5.AssessmentLog.URLLINK IS '노래링크';

COMMENT ON COLUMN big5.AssessmentLog.Nickname IS '닉네임';

COMMENT ON COLUMN big5.AssessmentLog.genre IS '노래장르정의';

COMMENT ON COLUMN big5.AssessmentLog.Atmos IS '노래분위기';

CREATE UNIQUE INDEX big5.UIX_AssessmentLog
	ON big5.AssessmentLog (
		Nickname ASC,
		URLLINK ASC
	);

ALTER TABLE big5.AssessmentLog
	ADD
		CONSTRAINT UK_AssessmentLog
		UNIQUE (
			Nickname,
			URLLINK
		);

/* SNA영상목록 */
CREATE TABLE big5.USvideo (
	video_id VARCHAR2(90), /* 영상식별자 */
	title VARCHAR2(150), /* 영상제목 */
	channel_title VARCHAR2(150), /* 채널제목 */
	category_id NUMBER, /* 카테고리번호 */
	tags VARCHAR2(750), /* 태그 */
	views NUMBER, /* 조회수 */
	likes NUMBER, /* 좋아요수 */
	dislikes NUMBER, /* 싫어요수 */
	comment_total NUMBER, /* 댓글 총합 */
	thumbnail_link VARCHAR2(300), /* 썸네일링크 */
	Uploaddate VARCHAR2(90) /* 게시날짜 */
);

COMMENT ON TABLE big5.USvideo IS 'SNA영상목록';

COMMENT ON COLUMN big5.USvideo.video_id IS '영상식별자';

COMMENT ON COLUMN big5.USvideo.title IS '영상제목';

COMMENT ON COLUMN big5.USvideo.channel_title IS '채널제목';

COMMENT ON COLUMN big5.USvideo.category_id IS '카테고리번호';

COMMENT ON COLUMN big5.USvideo.tags IS '태그';

COMMENT ON COLUMN big5.USvideo.views IS '조회수';

COMMENT ON COLUMN big5.USvideo.likes IS '좋아요수';

COMMENT ON COLUMN big5.USvideo.dislikes IS '싫어요수';

COMMENT ON COLUMN big5.USvideo.comment_total IS '댓글 총합';

COMMENT ON COLUMN big5.USvideo.thumbnail_link IS '썸네일링크';

COMMENT ON COLUMN big5.USvideo.Uploaddate IS '게시날짜';

/* SNA영상댓글 */
CREATE TABLE big5.UScomments (
	video_id VARCHAR2(90), /* 영상식별자 */
	comment_text VARCHAR2(4000), /* 댓글내용 */
	likes DECIMAL(5), /* 좋아요 */
	replies DECIMAL(5) /* 답글 */
);

COMMENT ON TABLE big5.UScomments IS 'SNA영상댓글';

COMMENT ON COLUMN big5.UScomments.video_id IS '영상식별자';

COMMENT ON COLUMN big5.UScomments.comment_text IS '댓글내용';

COMMENT ON COLUMN big5.UScomments.likes IS '좋아요';

COMMENT ON COLUMN big5.UScomments.replies IS '답글';

ALTER TABLE big5.ListeningLog
	ADD
		CONSTRAINT FK_Song_TO_ListeningLog
		FOREIGN KEY (
			URLLINK
		)
		REFERENCES big5.Song (
			URLLINK
		);

		
ALTER TABLE big5.ListeningLog
	ADD
		CONSTRAINT FK_Spmem_TO_ListeningLog
		FOREIGN KEY (
			Nickname
		)
		REFERENCES big5.Spmem (
			Nickname
		)on delete cascade;

ALTER TABLE big5.RecToOther
	ADD
		CONSTRAINT FK_Spmem_TO_RecToOther
		FOREIGN KEY (
			SendNick
		)
		REFERENCES big5.Spmem (
			Nickname
		);

		
ALTER TABLE big5.RecToOther
	ADD
		CONSTRAINT FK_Spmem_TO_RecToOther2
		FOREIGN KEY (
			RecNick
		)
		REFERENCES big5.Spmem (
			Nickname
		)on delete cascade;

ALTER TABLE big5.RecToOther
	ADD
		CONSTRAINT FK_Song_TO_RecToOther
		FOREIGN KEY (
			URLLINK
		)
		REFERENCES big5.Song (
			URLLINK
		);

ALTER TABLE big5.AssessmentLog
	add
		CONSTRAINT FK_Song_TO_AssessmentLog
		FOREIGN KEY (
			URLLINK
		)
		REFERENCES big5.Song (
			URLLINK
		);

		
ALTER TABLE big5.AssessmentLog
	ADD
		CONSTRAINT FK_Spmem_TO_AssessmentLog
		FOREIGN KEY (
			Nickname
		)
		REFERENCES big5.Spmem (
			Nickname
		)on delete cascade;
------0805
create or replace procedure delSpmem--Spmem-del
	(NICK_R in Spmem.Nickname%type,
	Password_R in Spmem.Password%type)
as
BEGIN
	delete from SPMEM
	where Nickname = NICK_R and Password = Password_R;
END;
/
var NICK_R VARCHAR2(50);
var Password_R VARCHAR2(50);
var Email_R VARCHAR2(80);
var ID_R VARCHAR2(50);
var Point_R NUMBER;
var Prefergenre_R VARCHAR2(50);
var PreferAtmos_R VARCHAR2(50);
var PreferAtmos2_R VARCHAR2(50);
var PreferAtmos3_R VARCHAR2(50);

create or replace procedure showgen--Spmem-prefergenre show
	(NICK_R in Spmem.Nickname%type,
	Prefergenre_R out Spmem.Prefergenre%type)
as
BEGIN
	select Prefergenre into Prefergenre_R
	FROM Spmem where Nickname=NICK_R;
END;
/

create or replace procedure upgen--Spmem-prefergenre update
	(NICK_R in Spmem.Nickname%type,
	Prefergenre_R in Spmem.Prefergenre%type)
as
BEGIN
	update spmem
		set Prefergenre=Prefergenre_R
	where Nickname=NICK_R;
END;
/

create or replace procedure showAtmos--Spmem-preferAtmos show
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos_R out Spmem.PreferAtmos%type)
as
BEGIN
	select PreferAtmos into PreferAtmos_R
	FROM Spmem where Nickname=NICK_R;
END;
/

create or replace procedure upAtmos--Spmem-preferAtmos update
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos_R in Spmem.PreferAtmos%type)
as
BEGIN
	update spmem
		set PreferAtmos=PreferAtmos_R
	where Nickname=NICK_R;
END;
/

create or replace procedure showAtmos2--Spmem-preferAtmos show2
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos2_R out Spmem.PreferAtmos2%type)
as
BEGIN
	select PreferAtmos2 into PreferAtmos2_R
	FROM Spmem where Nickname=NICK_R;
END;
/

create or replace procedure upAtmos2--Spmem-preferAtmos2 update
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos2_R in Spmem.PreferAtmos2%type)
as
BEGIN
	update spmem
		set PreferAtmos2=PreferAtmos2_R
	where Nickname=NICK_R;
END;
/

create or replace procedure showAtmos3--Spmem-preferAtmos show3
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos3_R out Spmem.PreferAtmos3%type)
as
BEGIN
	select PreferAtmos3 into PreferAtmos3_R
	FROM Spmem where Nickname=NICK_R;
END;
/

create or replace procedure upAtmos3--Spmem-preferAtmos3 update
	(NICK_R in Spmem.Nickname%type,
	PreferAtmos3_R in Spmem.PreferAtmos3%type)
as
BEGIN
	update spmem
		set PreferAtmos3=PreferAtmos3_R
	where Nickname=NICK_R;
END;
/

--관리자용 전체평가로그 보기(여기서부터
create or replace procedure showAsl
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select URLLINK, Nickname, genre, Atmos
	FROM AssessmentLog;
END;
/
var URLLINK_R VARCHAR2(90);
var Nickname_R VARCHAR2(50);
var genre_R VARCHAR2(60);
var Atmos_R VARCHAR2(60);

--이 위쪽으로 관리자용 전체평가보기

--이 아래로 관리자용 추천소비기록 보기
create or replace procedure showLL
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select URLLINK, Nickname, LisTime, DisAtmos, IsSatisfied 
	FROM ListeningLog;
END;
/
var URLLINK_R VARCHAR2(90);
var Nickname_R VARCHAR2(50);
var LisTime_R VARCHAR2(50);
var DisAtmos_R VARCHAR2(50);
var IsSatisfied_R NUMBER;

--이 아래로 관리자용 전체계정일람

--이 아래로 다시 클라이언트용(아래꺼 안됨)
create or replace procedure addAsl--AssessmentLog add
	(URLLINK_R in AssessmentLog.URLLINK%type,
	Nickname_R in AssessmentLog.Nickname%type,
	genre_R in AssessmentLog.genre%type,
	Atmos_R in AssessmentLog.Atmos%type)
as
BEGIN
	insert into AssessmentLog(URLLINK, Nickname, genre, Atmos) 
		values (URLLINK_R, Nickname_R, genre_R, Atmos_R);
END;
/

create or replace procedure addLisLog--ListeningLog add
	(URLLINK_R in ListeningLog.URLLINK%type,
	Nickname_R in ListeningLog.Nickname%type,
	DisAtmos_R in ListeningLog.DisAtmos%type,
	Disgenre_R in ListeningLog.Disgenre%type)
as
BEGIN
	insert into ListeningLog(URLLINK, Nickname, DisAtmos, Disgenre) 
		values (URLLINK_R, Nickname_R, DisAtmos_R, Disgenre_R);
END;
/

create or replace procedure upLisLog--ListeningLog unsatisfied
	(NICK_R in ListeningLog.Nickname%type,
	URLLINK_R in ListeningLog.URLLINK%type,
	LisTime_R in ListeningLog.LisTime%type,
	IsSatisfied_R in ListeningLog.IsSatisfied%type)
as
BEGIN
	update ListeningLog
		set IsSatisfied=IsSatisfied_R
	where Nickname=NICK_R
	and URLLINK = URLLINK_R
	and LisTime = LisTime_R;
END;
/

--right here
create or replace procedure upRecToOther--RectoOther add
	(SendNick_R in RecToOther.SendNick%type,
	RecNick_R in RecToOther.RecNick%type,
	URLLINK_R in RecToOther.URLLINK%type)
as
BEGIN
	insert into RecToOther(SendNick, RecNick, URLLINK) 
		values (SendNick_R, RecNick_R, URLLINK_R);
END;
/
var SendNick_R VARCHAR2(50);
var RecNick_R VARCHAR2(50);

create or replace procedure showRTO--RectoOther show
	(VO_RES OUT SYS_REFCURSOR,
	RecNick_R in RecToOther.RecNick%type)
as
BEGIN
	open VO_RES for
	select SendNick, URLLINK, RecTime
	FROM RecToOther
	where RecNick=RecNick_R;
END;
/
var RecTime_R VARCHAR2(50);
--관리자용 RecToOther 열람
create or replace procedure showRTOall--RectoOther show
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select SendNick, RecNick, URLLINK, RecTime
	FROM RecToOther;
END;
/

--이 위로 관리자용 RecToOther 열람

create or replace procedure showSongall--Song show
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select URLLINK, genre, Atmos
	FROM Song;
END;
/

create or replace procedure pointforASL--ASL returns as point
	(NICK_R in Spmem.Nickname%type)
as
BEGIN
	update Spmem
		set Point = (select Point from Spmem where Nickname=NICK_R)+10
	where Nickname=NICK_R;
END;
/

create or replace procedure songavgupdate--ASL추가에 따른 최신화
	(URLLINK_R in Song.URLLINK%type,
	genre_R in Song.genre%type,
	Atmos_R in Song.Atmos%type)
as
BEGIN
	update Song
		set genre = genre_R,
		Atmos = Atmos_R
		where URLLINK=URLLINK_R;
END; 
/

create or replace procedure aslURLgather --ASL추가에 따른 최신화 과정에서 평균치 넣을 값 뽑아내기
	(URLLINK_R in AssessmentLog.URLLINK%type,
	VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select URLLINK, genre, Atmos from AssessmentLog
	where URLLINK=URLLINK_R;
END; 
/

create or replace procedure showmemberall--rto에서 누구에게 보낼지 보기 위한 멤버
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select Nickname from Spmem;
END; 
/

create or replace procedure showSongforrto--Song show for rto
	(VO_RES OUT SYS_REFCURSOR)
as
BEGIN
	open VO_RES for
	select URLLINK
	FROM Song;
END;
/

create or replace procedure pointforRTO--ASL returns as point
	(NICK_R in Spmem.Nickname%type,
	Point_R in Spmem.Point%type)
as
BEGIN
	update Spmem
		set Point = (select Point from Spmem where Nickname=NICK_R)-50
	where Nickname=NICK_R;
END;
/

create or replace procedure showSongforASL--Song check for ASL
	(VO_RES OUT SYS_REFCURSOR,
	URLLINK_R in Song.URLLINK%type)
as
BEGIN
	open VO_RES for
	select URLLINK
	FROM Song
	WHERE URLLINK=URLLINK_R;
END;
/

create or replace procedure addSong--AssessmentLog add
	(URLLINK_R in Song.URLLINK%type,
	genre_R in Song.genre%type,
	Atmos_R in Song.Atmos%type)
as
BEGIN
	insert into Song(URLLINK, genre, Atmos) 
		values (URLLINK_R, genre_R, Atmos_R);
END;
/