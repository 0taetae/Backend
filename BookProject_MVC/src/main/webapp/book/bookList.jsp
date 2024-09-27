<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- JSTL core 태그 라이브러리 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> 
<c:import url="../menu.jsp"/>

<!-- 책 목록이 비어있지 않은 경우 -->
<c:if test="${!empty booklist}">
		<table border="1" align="center" width="600">
			<tr>
				<td>도서코드</td>
				<td>책이름</td>
				<td>저자</td>
				<td>출판사</td>
				<td>가격</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<!-- 책 목록을 반복하면서 각 책의 정보를 테이블에 출력  -->
			<c:forEach items="${booklist }" var="ob">
			<tr>
				<td>${ob.isbn }</td>
				<td>${ob.title }</td>
				<td>${ob.author }</td>
				<td>${ob.company }</td>
				<td><fmt:formatNumber value="${ob.price}" groupingUsed="true"/></td>
				<td>
					<form action="${root }/book/bookUpdate.jsp" method="post">
						<input type="hidden" name="isbn" value="${ob.isbn }">
						<input type="hidden" name="title" value="${ob.title }">
						<input type="hidden" name="author" value="${ob.author }">
						<input type="hidden" name="company" value="${ob.company }">
						<input type="hidden" name="price" value="${ob.price }">
						<input type="submit" value="수정">						         
					</form>
				</td>
				<td>
					<form action="${root }/main" method="post">
						<input type="hidden" name="action" value="deletebook">
						<input type="hidden" name="isbn" value="${ob.isbn }">
						<input type="submit" value="삭제" onclick="return confirm('삭제할까요?')">	
					</form>
				</td>
			</tr>		
			</c:forEach>
		</table>
</c:if>
</body>
</html>