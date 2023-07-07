<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
 		<!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath }/">스프링 프레임워크</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="${pageContext.request.contextPath }/boardView">회원게시판</a></li>
                        
                        <!-- 로그인 안되어있을때 보여줄 부분 -->
                        <c:if test="${sessionScope.login == null }">
	                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<c:url value='/loginView'/>">로그인</a></li>
	                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<c:url value='/registView'/>">회원가입</a></li>
                        </c:if>
                        
                        <!-- 로그인 되어있을때 보여줄 부분 -->
                        <!-- 세션 객체 중 key 값으로 login이 저장되어있는지 확인 -->
                        <c:if test="${sessionScope.login != null }">
	                        <li class="nav-item mx-0 mx-lg-1">
	                        	<form action="${pageContext.request.contextPath }/memberEditView" method="POST" id="editForm">
		                        	<div class="dropdown nav-link py-3 px-0 px-lg-3 rounded">
									  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
									    ${sessionScope.login.memName }님
									  </button>
									  <ul class="dropdown-menu " aria-labelledby="dropdownMenuButton1">
									    <li><a class="dropdown-item" href="#">마이페이지</a></li>
						                <li><a class="dropdown-item" href="#" onclick="fn_edit()">수정</a></li>
						                <li><a class="dropdown-item" href="<c:url value='/logoutDo'/>">로그아웃</a></li>
									  </ul>
									</div>
	                        	</form>
	                        </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <script type="text/javascript">
			function fn_edit() {
				document.getElementById("editForm").submit()
			}
		</script>