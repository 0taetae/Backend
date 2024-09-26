<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="../menu.jsp"/>
<c:if test="${!empty emplist}">
		<table border="1" align="center" width="500">
			<tr>
				<td>사원번호</td>
				<td>사원이름</td>
				<td>연락처</td>
				<td>부서</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${emplist }" var="ob">
			<tr>
				<td>${ob.eno }</td>
				<td>${ob.ename}</td>
				<td>${ob.phone }</td>
				<td>${ob.dept }</td>
				<td>
					<form action="${root }/emptest/empUpdate.jsp" method="post">
						<input type="hidden" name="eno" value="${ob.eno }">
						<input type="hidden" name="ename" value="${ob.ename }">
						<input type="hidden" name="phone" value="${ob.phone }">
						<input type="hidden" name="dept" value="${ob.dept}">
						<input type="submit" value="수정">						         
					</form>
				</td>
				<td>
					<form action="${root }/emp" method="post">
					<input type="hidden" name="action" value="deleteemp">
						<input type="hidden" name="eno" value="${ob.eno }">
						<input type="submit" value="삭제" onclick="return confirm('삭제할까요?')">						         
					</form>
				</td>
			</tr>	
		</c:forEach>
		</table>
</c:if>	
</body>
</html>







