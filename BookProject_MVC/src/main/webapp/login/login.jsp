<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="../menu.jsp"/>
<form action="${root }/main"  method="post">
<input type="hidden" name="action" value="login">
<table border="0" align="center" width="350">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userpwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="reset" value="취&nbsp;&nbsp;소">
		</td>
	</tr>
</table>
</form>
</body>
</html>