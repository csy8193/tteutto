<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/studentCommentList.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
        <main>
            <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>

            <div class="right">
                <div class="title">
                    <p><span>000</span>님이 작성한 후기</p>
                </div>

                <div class="table">
                    <div class="row">
                        <div class="column table-column">번호</div>
                        <div class="column table-column">클래스명</div>
                        <div class="column table-column">강사명</div>
                        <div class="column table-column">평점</div>
                        <div class="column table-column">후기 내용</div>
                        <div class="column table-column"></div>
                    </div>
                    <div class="row">
                        <div class="column">1</div>
                        <div class="column">클래스명1</div>
                        <div class="column">수강 예정</div>
                        <div class="column">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                            <i class="far fa-star"></i>
                        </div>
                        <div class="column">선생님이 너무 친절하세요.  강의도 ...</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    <div class="invisible">
                        <div class="invisible-btn">
                            <button class="report-modal-btn"><i class="far fa-edit"></i> 수정</button>
                            <button><i class="far fa-trash-alt"></i> 삭제</button>
                        </div>
                    </div>


                    


                </div>
                <div class="page-number">
                    <ul class="page-ul">
                        <li>
                            <a href="#"><i class="fas fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-angle-left"></i></a>
                        </li>
                        
                        <li style="border-radius: 50%; background-color: #FFDF3E;">
                            <a style="color: white;">1</a>
                        </li>
                        <li>
                            <a href="#">2</a>
                        </li>
                        
                        
                        <li>
                            <a href="#"><i class="fas fa-angle-right"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-angle-double-right"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </main>

        <div id="report-modal">
            <div class="modal-content">
                <form action="#" method="post">
                    <div class="modal-title">
                        <h2>후기 수정</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p>'클래스명1' - 홍길동</p>
                    </div>

                    <div class="score">
                        평점 : <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half-alt"></i>
                        <i class="far fa-star"></i> 
                    </div>
                    
                    <textarea name="" class="modal-comment" placeholder="댓글 수정">댓글 내용</textarea>

                    <input type="hidden">

                    <div class="modal-btn">
                        <button>수정하기</button>
                        <button type="button" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>

    </div>

<jsp:include page="../common/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(".left > .list > div:nth-of-type(3)").addClass("selected");
	
	
    // 모달 열기
    $(".report-modal-btn").click(function () {
        $("#report-modal").fadeIn(100);
        $("#report-modal").css("display", "flex");
    });

    // 모달 닫기 버튼
    $(".modal-close-btn").click(function () {
        $("#report-modal").fadeOut(100);
    });

    // 모달 밖에 클릭시 모달 닫기
    $("#report-modal").click(function (e) {
        if($(e.target).hasClass('modal-layer')) {
            $("#report-modal").fadeOut(100);
        }

    });

    // 슬라이드
    $(".slide").on("click", function () {
        if ($(this).parent().next().css("display") == "none") {
            $(".invisible").slideUp(100);
            $(".slide").html('<i class="fas fa-angle-down"></i>');
            $(this).parent().next().slideDown(100);
            $(this).html('<i class="fas fa-angle-up"></i>');

        } else {
            $(this).parent().next().slideUp(100);
            $(this).html('<i class="fas fa-angle-down"></i>');

        }
    });

</script>
