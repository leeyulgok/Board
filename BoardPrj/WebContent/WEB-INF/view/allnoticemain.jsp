<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Page content-->
                <div class="container-fluid">
                   <h1 class="mt-4">전체 게시판</h1>
                </div>
                <div>
                	<table class="table">
                		<thead>
                			<tr>
                				<td>번호</td>
                				<td>제목</td>
                				<td>작성자</td>
                				<td>게시일</td>
                				<td>조회수</td>
                			</tr>
                		</thead>
                		<tbody>
                		<c:forEach var="a" items="${allList}">
                			<tr>
                				<td>${a.num}</td>
                				<td><a class="a" href="/detail?num=${a.num}">${a.title}</a></td>
                				<td>${a.id}</td>
                				<td>
                					<fmt:parseDate value='${a.regdate}' var='regdate' pattern='yyyymmdd'/>
                					<fmt:formatDate pattern="yy-MM-dd" value="${regdate}"/>
                				</td>
                				<td>${a.hit}</td>
                			</tr>
                		</c:forEach>
                		</tbody>
                	</table>
                </div>
            </div>
        </div>