<%@page import="java.util.Date"%>
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
<c:set var="date" value="<%=new Date() %>"/>
오늘 날짜: <fmt:formatDate value="${date }"/><br>
현재 시간: <fmt:formatDate value="${date }" type="time"/><br>
<fmt:formatNumber value="12345678" groupingUsed="true"/>원<br>
<fmt:formatNumber value="1.2" pattern="#.##"/><br>
<fmt:formatNumber value="1.2" pattern="#.00"/><br>
<fmt:formatNumber value="0.12" type="percent"/><br>
<fmt:formatNumber value="12345678" type="currency"/><br>


</body>
</html>