<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Page content-->
                <div class="container-fluid">
                   <h1 class="mt-4">${id} 게시판</h1>
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
                		<c:forEach var="n" items="${list}">
                			<tr>
                				<td>${n.num}</td>
                				<td><a href="/detail?num=${n.num}">${n.title}</a></td>
                				<td>${n.id}</td>
                				<td>
                					<fmt:parseDate value='${n.regdate}' var='regdate' pattern='yyyymmdd'/>
                					<fmt:formatDate pattern="yy-MM-dd" value="${regdate}"/>
                				</td>
                				<td>${n.hit}</td>
                			</tr>
                		</c:forEach>
                		</tbody>
                	</table>
                	<%-- <div>
                		<c:set var="page" value="${(param.p == null) ? 1 : param.p}"/>
                		<c:set var="startNum" value="${page - (page-1) % 5}"/>
                		<ul class="ul">
                			<c:forEach var="i" begin="0" end="4">
                				<li><a>${startNum+i}</a></li>
                			</c:forEach>
                		</ul>
                	</div> --%>
                </div>
            </div>
        </div>