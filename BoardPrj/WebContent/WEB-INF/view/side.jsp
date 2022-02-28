<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex" id="wrapper">
	<!-- Sidebar-->
  	<div class="border-end bg-white" id="sidebar-wrapper">
      	<div class="sidebar-heading border-bottom bg-light">Private Board</div>
      	<div class="list-group list-group-flush">
      	<c:choose>
	      	<c:when test="${sessionScope.id eq null}">
	          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/login">로그인</a>
	          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/register">회원가입</a>
	        </c:when>
	        <c:otherwise>
	        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/main">게시판</a>
	        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/write">글쓰기</a>
	        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/update">수정하기</a>
	        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/allnotice">전체 게시판</a>
	          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/logout">로그아웃</a>
	        </c:otherwise>
      	</c:choose>
          	<!-- <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Overview</a>
          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
          	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a> -->
      	</div>
  	</div>