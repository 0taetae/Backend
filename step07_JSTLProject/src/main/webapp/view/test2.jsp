<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${title }<br>
당신의 점수는 ${score }점 이고
<c:if test="${score>=60 }">합격</c:if>
<c:if test="${score<60 }">불합격</c:if>입니다<br>
<a href="/index.html">처음으로</a>
</body>
</html>