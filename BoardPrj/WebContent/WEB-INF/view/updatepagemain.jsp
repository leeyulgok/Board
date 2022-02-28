<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
                <div class="container-fluid">
                	<h1>수정하기</h1>
                	<c:forEach var="u" items="${list}">
	                    <form action="/updateService" method="post">
	                    	<h4>제목</h4>
	                    	<input type="text" name="title" value="${u.title}">
	                    	<h4>내용</h4>
	                    	<textarea name="content">${u.title}</textarea><br />
	                    	<p>비공개하기<input type="radio" name="pub" value="0"></p>
	                    	<input type="hidden" name="num" value="${u.num}">
	                    	<input type="submit" value="수정하기">
	                    </form>
                	</c:forEach>
                </div>
            </div>
        </div>