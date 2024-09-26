<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="color" value="${'orange' }"/>
<c:choose>
	<c:when test="${color=='red' }">빨간색</c:when>
	<c:when test="${color=='green' }">초록색</c:when>
	<c:when test="${color=='blue' }">파란색</c:when>
	<c:otherwise>기타색</c:otherwise>
</c:choose>
<!-- 
또는 <c:out value="기타색"></c:out>
 -->
</body>
</html>