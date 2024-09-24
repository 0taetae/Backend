<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "김태영";	
public void init(){
	System.out.println("init methodo");
}
%>
<%
int x = Integer.parseInt("a");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello SSAFY</h1>
	<h3>안녕 싸피!!!</h3>
	<h5><% out.println(name); %>님 안녕하세요.</h5> 
	<h5><%= name  %>님 안녕하세요.</h5>
	<a href="/basic_jsp/index.jsp">홈으로 go..</a>
</body>
</html>