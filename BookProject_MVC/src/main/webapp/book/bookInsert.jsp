<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!-- JSTL core 태그 라이브러리 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<c:import url="../menu.jsp"/>

<!-- 서버로 요청을 보낼 URL 설정, POST 방식 -->
<form action="${root }/main" method="post">

<!-- 서버에 "insertbook" action을 전송하여 책 추가 요청 -->
<input type="hidden" name="action" value="insertbook"/>
<table border="0" width="300" align="center">
	<tr>
		<td>도서코드</td>
		<td><input type="text" name="isbn"></td>
	</tr>
	<tr>
		<td>책이름</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>저자</td>
		<td><input type="text" name="author"></td>
	</tr>
	<tr>
		<td>출판사</td>
		<td><input type="text" name="company"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="추가">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
</body>
</html>
