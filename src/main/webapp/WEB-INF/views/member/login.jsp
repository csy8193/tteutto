<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/login.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
    <main class="login">
        <h1>로그인</h1>

        <form action="${contextPath}/member/login" method="POST">
            <input type="email" id="memberEmail" name="memberEmail" placeholder="이메일" value="${cookie.saveId.value}"> <br>
            <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호"> <br>

            <div id="save-div">
           		<c:if test="${!empty cookie.saveId.value }">
               		<c:set var="chk" value="checked"/>
               	</c:if>
                <input id="saveEmail" type="checkbox" name="save" ${chk}>
                <label for="saveEmail">
                	
                    <span><i class="fas fa-check"></i></span>
                    이메일 기억하기
                </label>
            </div>

            <button>로그인</button>
        </form>

        <div id="pw-signup">
            <a href="findPw">비밀번호 찾기</a>
            |
            <a href="signup">회원가입</a>
        </div>

        <div id="naver_id_login"></div>

        <a href="#" class="sns">
            <div>
                <img style="background-color: #f9e000;" src="https://d2v80xjmx68n4w.cloudfront.net/assets/icon/kakao_logo.png">
                <span>카카오로 시작하기</span>
            </div>
        </a>

        <a href="#" class="sns">
            <div>
                <img style="background-color: #f8f9fd;" src="https://d2v80xjmx68n4w.cloudfront.net/assets/icon/google_logo.png">
                <span>구글로 시작하기</span>
            </div>
        </a>

    </main>
</div>

<jsp:include page="../common/footer.jsp"/>

<script type="text/javascript">
  	var naver_id_login = new naver_id_login("d_q2NGPsQeZpTrvq0_S0", "http://localhost:8080/tteutto/member/callback");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("green", 3, 60);
  	naver_id_login.setDomain("http://localhost:8080/tteutto/member/login");
  	naver_id_login.setState(state);
  	//naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
</script>
