<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="200px">
	<tr>
		<td>이름</td>
		<td>연락처</td>
	</tr>
	<c:forEach items="${list }" var="ob">
		<tr>
			<td>${ob.name }</td>
			<td>${ob.phone }</td>
		</tr>
	</c:forEach>
</table>
<a href="/index.html">처음으로</a>
</body>
</html>






