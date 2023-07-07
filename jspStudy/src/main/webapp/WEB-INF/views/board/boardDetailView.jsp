<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${board.boardTitle }</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/assets/favicon.ico" />
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <style type="text/css">
        	.my-right-arrange{
        		display: flex;			/* d-flex */
        		justify-content: end;	/* justify-content-end */
        	}
        </style>
    </head>
    <body id="page-top">
    
    	<!-- 모든 페이지 상단에 포함되는 부분 -->
    	<%@ include file="/WEB-INF/inc/top.jsp" %>
    	
        <!-- 게시글 폼 -->
        <section class="page-section mt-5" id="contact">
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">${board.boardTitle }</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <div class="form-floating mb-3 d-flex justify-content-end">
                        	<h5 style="margin-right: 30px;">${board.memName }</h3>
                        	<h5>${board.boardDate }</h3>
                        </div>
                        <div class="mb-3">
                            <textarea class="form-control" id="message" name="boardContent" type="text" style="height: 20rem" readonly>${board.boardContent }</textarea>
                        </div>
                        <!-- 현재 로그인한 사람의 아이디가 -->
                        <!-- 현재 게시글의 작성자 아이디와 같아야 표기 -->
                        <c:if test="${sessionScope.login.memId == board.memId }">
	                        <div class="my-right-arrange">
	                        	<form action="${pageContext.request.contextPath }/boardEditView" method="POST">
	                        		<input type="hidden" name="boardNo" value="${board.boardNo }">
		                        	<button type="submit" class="btn btn-warning me-1">수정</button>
	                        	</form>
	                        	<form id="delForm" action="${pageContext.request.contextPath }/boardDelDo" method="POST">
	                        		<input type="hidden" name="boardNo" value="${board.boardNo }">
		                        	<button type="button" class="btn btn-danger" onclick="f_del()">삭제</button>
	                        	</form>
	                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="/WEB-INF/inc/bottom.jsp" %>
        <script type="text/javascript">
        	function f_del() {
        		if(confirm("정말로 삭제하시겠습니까?")){
        			// form태그의 action을 실행(submit)
        			document.getElementById("delForm").submit()
        		}
        			
        	}
        </script>
    </body>
</html>

