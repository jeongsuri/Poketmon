# Poketmon
삐까

![342066053-ad6e9d2e-167d-46a0-8378-2361f6de2261](https://github.com/jeongsuri/Poketmon/assets/163953571/eeff4ba1-efdd-4ead-bf79-90307ee6f5e1)

< POKEMON GAME >

<1. 프로젝트 소개>
--------------------------------------------------------
--------------------------------------------------------
* 프로젝트 명 : POKEMON GAME
* 개발 기간 : 2024. 06. 25 ~ 2024. 07. 04
* 개발 인원 : 6명
* 핵심 기능 : 포켓몬스터 도감 확인 및 게임
<br>

<2. 개발 환경>
---------------------------------------------------------
---------------------------------------------------------
* IntelliJ (인텔리제이)
* Gradle (그래들)
* JAVA (자바)
* HTML, CSS, JAVA SCRIPT
* Sourcetree (소스 트리)
* GITHUB (깃허브)
* Docker Desktop
* dbeaver
<br>

<3. GitMind 작성>
---------------------------------------------------------
---------------------------------------------------------
-> 이미지 파일 추가 예정


<br>

<4. 기능 명세서>
----------------------------------------------------------
----------------------------------------------------------
<br>

< 관리자 >
----------------------------------------------------------
----------------------------------------------------------

<br>

< 회원 >
----------------------------------------------------------
----------------------------------------------------------

<br>

< 게시글 >
----------------------------------------------------------
----------------------------------------------------------

<br>

< 도감 >
----------------------------------------------------------
----------------------------------------------------------
✅ 포켓몬 도감
-
- 포켓몬 공식 사이트 API 연동
- API에서 도감에 들어갈 세부사항 중 필요한 부분 (이름, 번호, 속성 등) 만 뽑아서 DB에 POKEMON 테이블 생성하여 저장 
- 연동한 API 도감 카드화
- 카드화한 포켓몬으로 목록화하여 도감 페이지 완성

✅ 개별 포켓몬
-
- 포켓몬 도감 페이지에서 포켓몬 클릭 시 개별 포켓몬 페이지로 이동
- 개별 페이지 이동 시 포켓몬 사진 + 포켓몬 이름, 몸무게, 속성 타입 1 & 2, 특징 정보 확인
<br>

< 게임 > 
----------------------------------------------------------
----------------------------------------------------------
✅ 이름 맞추기 게임
- 
-POKEMON 테이블에서 랜덤 포켓몬 실루엣, 설명, 속성을 뽑아서 가져온 뒤 이름 맞추기 퀴즈 형식으로 문제 출제<br>
![readme1](https://github.com/KIMJEONGHYEON1016/Poketmon/assets/127102729/b4e02f0d-17ac-42b8-9f9d-64a813be82eb) 
- 오른쪽 화살표 버튼을 클릭 시 새로운 포켓몬으로 새로고침
- 오답 시 정답 입력 하단에 텍스트가 표시됨<br>
<img src="https://github.com/jeongsuri/Poketmon/assets/127102729/d4ec6549-8425-4f0d-9823-829e0f298c06" width="600" height="100" ><br>
- 한 번 잡은 포켓몬은 재등장하지 않음

✅ 마이 포켓몬 저장
-
-잡은 포켓몬의 별명, 번호, 유저 번호를 MYPOKEMON 테이블에 저장<br>
![readme2](https://github.com/KIMJEONGHYEON1016/Poketmon/assets/127102729/9201d571-cce2-421e-99f6-f1a8c7ab2962)
- 좌측 '박스로 이동' 버튼을 누를 시 '내 포켓몬' 탭으로 이동하며 별명을 저장(별명을 지정하지 않을 시 기본 포켓몬 이름)
- 다시 하기 버튼을 누를 시 저장을 포기하며, 다시 '포켓몬 잡기' 탭으로 이동
  ![readme4](https://github.com/jeongsuri/Poketmon/assets/127102729/a18478e6-06f7-4802-ade8-1e3a4a348929)

< 랭킹 >
----------------------------------------------------------
----------------------------------------------------------
✅ 전체 랭킹
- MYPOKEMON 테이블에 저장된 값 중 회원번호(USER_NO)와 포켓몬 번호(POKEMON_NO)로 순위를 나열하여 전체 유저 중 TOP10 랭킹 출력
- 
![순위표](https://github.com/jeongsuri/Poketmon/assets/163954323/68599d66-af73-42f9-b9ed-6abe831cf6e6)

- 유저별 포켓몬 포획 횟수(점수)가 동일할 시 같은 순위를 매기고 다음 순위를 미룸 -> 사진 참고(6위가 두 명이면 다음 순위가 8위)
- 순위 중복이 많아 랭킹 10위까지의 유저가 10명이 넘는 경우면 전부 출력하지 않고 상위 10개까지만 출력되게 함

✅ 유저 랭킹 검색

![검색1](https://github.com/jeongsuri/Poketmon/assets/163954323/65697ba1-271d-4860-a4d8-bc7124969e8e)

- 유저의 아이디를 검색하여 순위와 점수를 확인, 한 번 검색 후 연이어 다른 아이디의 랭킹을 확인할 수 있도록 상단에 아이디 검색창 유지
- 
![검색2](https://github.com/jeongsuri/Poketmon/assets/163954323/83a3d690-4bf4-4339-be15-3883667b0ef2)

- 가입되어 있지 않은 아이디를 검색했을 시 해당하는 사용자가 없다는 내용의 화면 출력함
- 모든 검색이 끝나고 순위표로 이동 버튼 클릭 시 다시 TOP10 랭킹을 보여 주는 화면으로 이동

<br>


<br>

< 내 포켓몬 >
----------------------------------------------------------
----------------------------------------------------------

<br>

<5. DB 연동 테이블>
----------------------------------------------------------
----------------------------------------------------------

![DB 모음](https://github.com/jeongsuri/Poketmon/assets/163954323/321b06ac-9a0f-4b88-a5d7-8f7573c3de31)


(1) 게시판 테이블

CREATE TABLE BOARD ( <br>
BID VARCHAR2(30) PRIMARY KEY, <br>
BNAME VARCHAR2(60) NOT NULL, <br>
ROWS_PER_PAGE NUMBER(4) DEFAULT 20, <br>
ACTIVE NUMBER(1) DEFAULT 0, <br>
ACTIVE_CATEGORY NUMBER(1) DEFAULT 0, <br>
CATEGORY CLOB, <br>
AUTHORITY VARCHAR2(10) DEFAULT 'ALL' CHECK(AUTHORITY IN ('ALL', 'USER', 'ADMIN')) <br>
);
<br>

(2) 게시판 설정 테이블

CREATE TABLE BOARD_DATA ( <br>
SEQ NUMBER(10) PRIMARY KEY, <br>
BID VARCHAR2(30), <br>
GID VARCHAR2(45), <br>
POSTER VARCHAR2(40) NOT NULL, <br>
MEMBER_SEQ NUMBER(10) DEFAULT 0, <br>
GUEST_PASSWORD VARCHAR2(65), <br>
CATEGORY VARCHAR2(40), <br>
NOTICE NUMBER(1) DEFAULT 0, <br>
SUBJECT VARCHAR2(255) NOT NULL, <br>
CONTENT CLOB NOT NULL, <br>
UA VARCHAR2(150), <br>
IP VARCHAR2(30), <br>
REG_DT DATE DEFAULT SYSDATE, <br>
MOD_DT DATE <br>
);
<br>

(3) 멤버 테이블
CREATE TABLE MEMBER( <br>
USER_NO NUMBER(10) PRIMARY KEY, <br>
USER_ID VARCHAR2(60) UNIQUE NOT NULL, <br>
PASSWORD VARCHAR2(65) NOT NULL, <br>
USER_TYPE VARCHAR2(20) DEFAULT 'USER' CHECK(USER_TYPE IN ('USER', 'ADMIN')), <br>
NICKNAME VARCHAR2(50) UNIQUE NOT NULL, <br>
MY_POKEMON_SEQ NUMBER(10) DEFAULT 0 <br>
);
<br>

(4) 내 포켓몬 테이블
CREATE TABLE MYPOKEMON ( <br>
USER_NO NUMBER(10) REFERENCES MEMBER(USER_NO), <br>
POKEMON_NO NUMBER(10) REFERENCES POKEMON(SEQ), <br>
NICKNAME VARCHAR2(50) <br>
);
<br>

(5) 포켓몬 API 연동 테이블
CREATE TABLE POKEMON ( <br>
SEQ NUMBER(10) PRIMARY KEY, <br>
NAME VARCHAR2(60) NOT NULL, <br>
WEIGHT NUMBER(7) DEFAULT 0, <br>
TYPE1 VARCHAR2(60) NOT NULL, <br>
TYPE2 VARCHAR2(60), <br>
FLAVOR_TEXT VARCHAR2(1000), <br>
FRONT_DEFAULT VARCHAR2(1000), <br>
RAW_DATA CLOB <br>
);
<br>

<6. 역할 분담>
----------------------------------------------------------
----------------------------------------------------------
* 회원가입 및 로그인 : 박세현
* 관리자 및 게시글 : 김정훈
* 포켓몬 도감 및 개별 포켓몬 : 정채윤
* 포켓몬 사냥 게임 : 김정현
* 포켓몬 게임 랭킹 조회 : 김선규
* 내 포켓몬 : 채연화

<br>

<7. 일정표>
----------------------------------------------------------
----------------------------------------------------------

-> 한셀 이미지로 추가할 예정
