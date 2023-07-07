<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>회원게시판</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/assets/favicon.ico" />
    </head>
    <body id="page-top">
    
    	<!-- 모든 페이지 상단에 포함되는 부분 -->
    	<%@ include file="/WEB-INF/inc/top.jsp" %>
    	
        <!-- 회원가입 폼 -->
        <section class="page-section mt-5" id="contact">
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">회원 게시판</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <!-- bootstrap -->
                <!-- div class row 붙이면 div class col 붙어 있는것들에 대해  한 행(12) 안에서 나뉜다.-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                       <table class="table">
                       		<thead>
                       			<tr>
	                       			<th>글 번호</th>
	                       			<th>제목</th>
	                       			<th>작성자</th>
	                       			<th>날짜</th>
                       			</tr>
                       		</thead>
                       		
                       		<c:forEach items="${boardList }" var="board">
                       			<tr>
	                      			<td>${board.boardNo }</td>
	                      			<td><a href="${pageContext.request.contextPath }/boardDetailView?boardNo=${board.boardNo}">${board.boardTitle }</a></td>
	                      			<td>${board.memName }</td>
	                      			<td>${board.boardDate }</td>
	                      		</tr>
                       		</c:forEach>
                       </table>
                    </div>
                    <div class="col-lg-8 col-xl-7 d-flex justify-content-end">
                    	<a href="<c:url value='/boardWriteView'/>">
	                    	<button type="button" class="btn btn-danger" >글쓰기</button>
                    	</a>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="/WEB-INF/inc/bottom.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>

