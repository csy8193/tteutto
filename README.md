# tteutto
-----------

```
메인 페이지
 * http://localhost:8080/tteutto/
 
-----------------------------------------------------------------------

클래스 검색 목록
 * http://localhost:8080/tteutto/main/searchList
 
클래스 테마 목록
 * http://localhost:8080/tteutto/main/themeList
 
클래스 상세
* http://localhost:8080/tteutto/class/classDetail?classNo=1000 (승인된 클래스만 조회)

-----------------------------------------------------------------------

로그인
 * http://localhost:8080/tteutto/member/login

회원가입
 * http://localhost:8080/tteutto/member/signup
 
비밀번호 찾기
 * http://localhost:8080/tteutto/member/findPw
 
비밀번호 변경
 * http://localhost:8080/tteutto/member/changePw
 
-----------------------------------------------------------------------

학생 프로필
 * http://localhost:8080/tteutto/member/studentProfile

클래스 목록 (학생)
 * http://localhost:8080/tteutto/member/studentClassList

내 후기 조회
 * http://localhost:8080/tteutto/member/studentCommentList
 
찜한 클래스
 * http://localhost:8080/tteutto/member/studentWishList
 
강사 신청
 * http://localhost:8080/tteutto/member/teacherRegister

-----------------------------------------------------------------------

강사 프로필
 * http://localhost:8080/tteutto/member/teacherProfile
 
클래스 목록 (강사)
 * http://localhost:8080/tteutto/teacher/classList
 
클래스 학생 목록 (교육 예정)
 * http://localhost:8080/tteutto/teacher/studentListExpect

클래스 학생 목록 (교육 중)
 * http://localhost:8080/tteutto/teacher/studentListOngoing

-----------------------------------------------------------------------

클래스 등록
 * http://localhost:8080/tteutto/register/class

회차 스케줄 등록
 * http://localhost:8080/tteutto/register/schedule

-----------------------------------------------------------------------

공지사항 목록
 * http://localhost:8080/tteutto/notice/noticeList
 
공지사항 내용
 * http://localhost:8080/tteutto/notice/noticeView

FAQ
 * http://localhost:8080/tteutto/notice/faq

이용약관
 * http://localhost:8080/tteutto/notice/terms
 
-----------------------------------------------------------------------

채팅 목록 팝업창
 * http://localhost:8080/tteutto/chat/chatRoomList

쪽지 목록 팝업창
 * http://localhost:8080/tteutto/chat/messageList

채팅 내용 팝업창
 * http://localhost:8080/tteutto/chat/chatRoom

-----------------------------------------------------------------------

클래스 신청 관리
 * http://localhost:8080/tteutto/admin/classManage

클래스 신청 상세조회
 * http://localhost:8080/tteutto/admin/class/{클래스번호}

클래스 수정 관리
 * http://localhost:8080/tteutto/admin/classUpdateManage

클래스 수정 상세조회
 * http://localhost:8080/tteutto/admin/classUpdate/{클래스번호}

회차별 신청 관리
 * http://localhost:8080/tteutto/admin/classEpisodeManage

회차별 신청 상세조회
 * http://localhost:8080/tteutto/admin/classEpisode/{회차번호}?no={클래스번호}

후기 관리
 * http://localhost:8080/tteutto/admin/reviewManage

유저 관리
 * http://localhost:8080/tteutto/admin/userManage

강사 신청 관리
 * http://localhost:8080/tteutto/admin/teacherManage

학생 신고 관리
 * http://localhost:8080/tteutto/admin/studentReportManage

클래스 신고 관리
 * http://localhost:8080/tteutto/admin/classReportManage

정산 관리
 * http://localhost:8080/tteutto/admin/calculateManage

정산 영수증 페이지
 * http://localhost:8080/tteutto/admin/calculate/{정산번호}

환불 관리
 * http://localhost:8080/tteutto/admin/refundManage

공지사항
 * http://localhost:8080/tteutto/admin/noticeManage

공지사항 등록
 * http://localhost:8080/tteutto/admin/noticeInsert

FAQ
 * http://localhost:8080/tteutto/admin/faqManage

FAQ 등록
 * http://localhost:8080/tteutto/admin/faqInsert
