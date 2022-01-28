<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- favicon -->
		<link rel="apple-touch-icon" sizes="57x57" href="${contextPath}/resources/images/favicon/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="${contextPath}/resources/images/favicon/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="${contextPath}/resources/images/favicon/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/images/favicon/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="${contextPath}/resources/images/favicon/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="${contextPath}/resources/images/favicon/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="${contextPath}/resources/images/favicon/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="${contextPath}/resources/images/favicon/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/images/favicon/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}/resources/images/favicon/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/images/favicon/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="${contextPath}/resources/images/favicon/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/images/favicon/favicon-16x16.png">
		<link rel="manifest" href="${contextPath}/resources/images/favicon/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="${contextPath}/resources/images/favicon/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
		<title>뜨또 | 뜨겁게 또 시작해보자! 전국의 모든 오프라인 클래스, 뜨또에서 찾아보세요.</title>
		<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
		<link rel="stylesheet" href="${contextPath}/resources/fontello/css/tteutto.css"> <!-- fontello -->
		<!-- font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
	</head>
	
	<body>
		<header>
			<div class="content">
				<div class="main">
					<div class="logo prevent-dragging">
						<a href="${contextPath}"><img src="${contextPath}/resources/images/common/TTEUTTO ver.2.png" alt="뜨또 로고 이미지"></a>
					</div>
					
					<!-- 클래스 검색 목록 페이지로 이동 -->
					<div class="search">
						<form action="${contextPath}/main/searchList?${param.search}" method="get">
							<div class="search-icon">
								<input type="text" placeholder="듣고 싶은 클래스를 찾아보세요." name="search">
								<i class="icon-search"></i>
							</div>
						</form>
					</div>
				</div>
				
				<div class="prevent-dragging">
					<c:choose>
						<%-- 미로그인 시 노출되는 메뉴 --%>
						<c:when test="${empty sessionScope.loginMember}">
							<ul class="logout">
								<%-- 강사 신청 페이지로 이동 --%>
								<li><a href="${contextPath}/member/teacherRegister">강사 신청하기</a></li>
								
								<%-- 로그인 페이지로 이동 --%>
								<li><a href="${contextPath}/member/login">로그인</a></li>
							</ul>
						</c:when>
						
						<%-- 로그인 시 노출되는 메뉴 --%>
						<c:otherwise>
							<ul class="login">
								<%-- 강사 신청 페이지로 이동 --%>
								<li><a href="${contextPath}/member/teacherRegister">강사 신청하기</a></li>
								
								<%-- 찜한 클래스 페이지로 이동--%>
								<li><a href="${contextPath}/member/studentWishList"><i class="icon-heart"></i></a></li>
								
								<%-- 1:1 채팅 / 쪽지 팝업창 열기 --%>
								<li><a href="#"><i class="icon-chat" id="chat">
									<%-- 알림 표시 --%>
									<span class="alert">2</span>
								</i></a></li>
								
								<%-- 프로필 모달창 열기 --%>
								<li class="profile">
									<div class="my-profile" id="my-profile">
										<%-- 프로필 이미지 --%>
										<img src="${contextPath}/resources/images/profile/temp.png" alt="프로필 이미지">
										<i class="icon-open" id="icon"></i>
									</div>
									
									<%-- 프로필 모달 --%>
									<div class="profile-modal" id="profile-modal">
										<div class="modal-1">
											<%-- 프로필 이미지 --%>
											<img src="${contextPath}/resources/images/profile/temp.png" alt="프로필 이미지">
											
											<div class="user">
												<%-- 회원명 --%>
												<div class="user-name"><span>${sessionScope.loginMember.memberNm}</span></div>
												
												<%-- 회원 프로필 페이지로 이동 --%>
												<div class="my-page"><a href="${contextPath}/member/studentProfile">학생 프로필</a></div>
											</div>
										</div>
										
										<div class="modal-2">
											<%-- 내 클래스 조회 페이지로 이동 --%>
											<div><a href="${contextPath}/teacher/classList" target="_blank">강사 페이지 열기</a></div>
											
											<%-- 로그아웃 후 Main 페이지로 이동 --%>
											<div><a href="${contextPath}/member/logout">로그아웃</a></div>
										</div>
									</div>
								</li>
							</ul>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</header>
		
		<script>
			const myProfile = document.querySelector("#my-profile");
			const profileModal = document.querySelector("#profile-modal");
			const icon = document.querySelector("#icon");
		
			/* 헤더 프로필 이미지 + icon 클릭 시 모달창 열고 닫기 */
			myProfile.addEventListener("click", function() {
				if (profileModal.style.display != "block") {
					profileModal.style.display = "block";
					icon.classList.remove("icon-open");
					icon.classList.add("icon-close");
					
				} else {
					profileModal.style.display = "none";
					icon.classList.remove("icon-close");
					icon.classList.add("icon-open");
				}  
			});
			
			/* 모달창이 열려있을 때 헤더 프로필 이미지 + icon, 모달창 외 나머지 클릭 시 모달창 닫기 */
			window.addEventListener("click", function(e) {
				const nodeList = document.querySelectorAll("#profile-modal *");
				const arr = Array.from(nodeList);
				arr.push(profileModal);
				
				arr.push(icon);
				arr.push(document.querySelector("#my-profile > img"));

				let flag = true;  
				for (el of arr) {
					if (e.target == el) {
						flag = false;
						break;
					}
				}
  
				if (flag && profileModal.style.display == "block") {
					profileModal.style.display = "none";
					icon.classList.remove("icon-close");
					icon.classList.add("icon-open");
				}
			});
		</script>
	</body>
</html>