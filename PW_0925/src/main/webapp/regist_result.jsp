<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<h1>도서 등록 결과</h1>
	<h2>등록 도서 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>도서번호</td>
				<td><%=request.getParameter("isbn") %></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><%=request.getParameter("title") %></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><%=request.getParameter("author") %></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=request.getParameter("price") %></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><%=request.getParameter("desc") %></td>
			</tr>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>