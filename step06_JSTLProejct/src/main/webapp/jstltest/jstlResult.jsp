<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
이름 : ${param.name}<br>
나이 : ${param.age }세
<c:if test="${param.age>=20 }">
	(청소년)
</c:if>
<c:if test="${param.age<20 })">
	(성인)
</c:if>
<br>
좋아하는 색깔 : 
<c:choose>
	<c:when test="${param.color=='red' }">빨간색</c:when>
	<c:when test="${param.color=='green' }">초록색</c:when>
	<c:when test="${param.color=='blue' }">파란색</c:when>
	<c:when test="${param.color=='magenta' }">보라색</c:when>
	<c:otherwise><c:out value="기타색"></c:out></c:otherwise>
</c:choose>
<br>
취미 :
<c:forEach items="${paramValues.hobby }" var="ob">
	${ob }&nbsp;
</c:forEach><br>
</body>
</html>

<%-- 
${paramValues.hobby[0]}
${paramValues.hobby[1]}
${paramValues.hobby[2]}
${paramValues.hobby[3]}<br>

${paramValues['hobby'][0]}
${paramValues['hobby'][1]}
${paramValues['hobby'][2]}
${paramValues['hobby'][3]}
 --%>