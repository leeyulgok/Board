<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	function deletelist(num){
		var num = num;
		location.href="/delete?num="+num;
	}
	function updatepage(num){
		var num = num;
		location.href="/updatepage?num="+num;
	}
</script>
<!-- Page content-->
                <div class="container-fluid">
                   <h1 class="mt-4">${id} 게시판</h1>
                </div>
                <div>
                	<form action="/pubService" method="post">
	                	<table class="table">
	                		<thead>
	                			<tr>
	                				<td>번호</td>
	                				<td>제목</td>
	                				<td>작성자</td>
	                				<td>게시일</td>
	                				<td>조회수</td>
	                				<td>공개여부</td>
	                			</tr>
	                		</thead>
	                		<tbody>
		                		<c:forEach var="n" items="${list}">
		                			<tr>
		                				<td>${n.num}</td>
		                				<td><a href="/detail?num=${n.num}">${n.title}</a></td>
		                				<td>${n.id}</td>
		                				<td>
		                					<fmt:parseDate value='${n.regdate}' var='regdate' pattern='yyyymmdd'/>
		                					<fmt:formatDate pattern="yy-MM-dd" value="${regdate}"/>
		                				<td>${n.hit}</td>
		                				<c:choose>
									      	<c:when test="${n.pub eq 1}">							          	
				                				<td><input type="checkbox" name="nums" value="${n.num}" checked></td>
									        </c:when>
									        <c:otherwise>
									        	<td><input type="checkbox" name="nums" value="${n.num}"></td>
									        </c:otherwise>
								      	</c:choose>
		                				<td><button type="button" class="btn btn-primary" onClick="updatepage(${n.num});">수정하기</button></td>
		                				<td><button type="button" class="btn btn-primary" onClick="deletelist(${n.num});">삭제하기</button></td>
		                			</tr>
		                		</c:forEach>
	                		</tbody>
	                	</table>
	                	<input type="submit" value="일괄수정">
                	</form>
                </div>
            </div>
        </div>