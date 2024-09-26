<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${color }"  var="ob">
	${ob }<br>
</c:forEach>
<c:forEach begin="1" end="${num }" var="num">
	${num }&nbsp;
</c:forEach><br>
<a href="/index.html">처음으로</a>
</body>
</html>