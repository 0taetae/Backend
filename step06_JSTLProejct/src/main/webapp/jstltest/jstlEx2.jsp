<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] color={"red","green","blue"};
%>
<c:set var="num1" value="${10 }"/>  <!-- int num1=10; 와 동일 -->
<c:set var="num2">20</c:set>
num1 + num2 = ${num1 + num2}<br><br>
<c:remove var="num1"/>
num1 + num2 = ${num1 + num2}<br><br>

<!--  varStatus:상태변수(count, index, current등 사용 가능) -->
<c:forEach items="<%=color%>" varStatus="i">
	${i.count }&nbsp;&nbsp;&nbsp;${i.current }<br>
</c:forEach>
<c:forTokens items="벤츠,소나타,아우디,BMW,포르쉐" delims="," var="car">
	${car}&nbsp;&nbsp;&nbsp;
</c:forTokens>
<br>
<!-- 1 2 3 4 5 6 7 8 9 10  *내림차순은 안된다*-->
<c:forEach begin="1" end="10" step="1" var="num">
	${num }&nbsp;&nbsp;&nbsp;
</c:forEach>
</body>
</html>
