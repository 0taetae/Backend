<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{	color:green;font-weight: bold;	font-size: 30px;}
	body { margin: 0; padding: 0; }
	#menu { height: 100px; background-color: #eee;	}
	a { display:inline-block;  margin-top:40px; text-decoration: none; font: bold;  
	    width: 100px; text-align: center; }
	#login_info { font-size: 12px; }
</style>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<div id="menu">
	<!-- 처음 화면 -->
	<a href="${root }/index.jsp">HOME</a>
	
	<!-- 사용자가 로그인하지 않은 경우 = 세션에 logOK가 없는 경우 -->
	<c:if test="${empty logOK }">
		<a href="${root }/login/login.jsp">로그인 화면</a>
	</c:if>
	<!-- 사용자가 로그인한 경우 = 세션에 logOk가 있는 경우 -->
	<c:if test="${!empty logOK }">
		<a href="${root }/book/bookInsert.jsp">도서등록</a>
		<a href="${root }/main?action=listbook">도서목록</a>
		<a href="${root }/main?action=logout">로그아웃</a>
		<span id="login_info"><b>${logOK.id }</b>님이 로그인 하셨습니다</span>
	</c:if>
</div>
<hr>
</body>
</html>