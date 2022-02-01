<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅창 목록</title>

    <link href="${contextPath}/resources/css/chatRoomList.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"  />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="chat_info">
            <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61ea6885cbefd43cdfd1638e/previews/61ea6886cbefd43cdfd163b7/download/TTEUTTO_ver.1.png">
            <span>실시간으로 간편하게 문의하세요.
                <span>
                    <div class="chatClose" onclick="chatClose();">×</div>
                </span>
            </span>
        </div>
        <div class="menuTap">
            <ul>
                <li><a href="#" class="on">채팅</a></li>
                <li><a href="${contextPath}/chat/messageList">쪽지</a></li>
            </ul>
        </div>

    </div>
    <div class="modeChange">
        <select>
            <option>수강생모드</option>
            <option>강사모드</option>
        </select>
    </div>

    <!-- 채팅리스트 -->
    <main class="chat_romm_list">
        <ul>
            <li>
                <a href="${contextPath}/chat/chatRoom">
                    <img src="${contextPath}/resources/images/class-detail/teacherProfileImg.png" class="profile-img" alt="k페이프로필사진">
                    <div class="talk">
                        <p class="friend-name"><span>백동현</span> 강사님</p>
                        <p class="chat-content">안녕하세요😊</p>
                    </div>
                    <div class="chat-status">
                        <time datetime="15:40:00+09:00">오후 3:40</time>
                        <span class="chat-balloon">1</sapn>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${contextPath}/resources/images/class-detail/teacherProfileImg.png" class="profile-img" alt="뫄뫄프로필사진">
                    <div class="talk">
                        <p class="friend-name"><span>천동현</span> 강사님</p>
                        <p class="chat-content">네 물어보세요</p>
                    </div>
                    <div class="chat-status">
                        <time datetime="15:39:00+09:00">오후 3:39</time>
                            <span class="chat-balloon">1</span>
                    </div>
                </a>
            </li>
            <li>
                <a href="#" target="_blank">
                    <img src="${contextPath}/resources/images/class-detail/teacherProfileImg.png" class="profile-img" alt="쀼프로필사진">
                    <div class="talk">
                        <p class="friend-name"><span>만동현</span> 강사님</p>
                        <p class="chat-content">안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.</p>
                    </div>
                    <div class="chat-status">
                        <time datetime="10:15:00+09:00">오전 10:15</time>
                    </div>
                </a>
            </li>


            
        </ul>
    </main>





    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        // 채팅창 닫기
        $(function chatClose() {

            $(".chatClose").click(function () {
                if (confirm("채팅창을 닫으시겠습니까?")) {
                    window.close();
                }

            });
        });
    </script>
</body>

</html>