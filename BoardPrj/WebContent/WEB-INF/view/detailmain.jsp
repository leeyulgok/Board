<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
                <div class="container-fluid">
	                <div>
	                	<c:forEach var="d" items="${list}">
	                		<h1>${d.title}</h1>
	                		<h5>${d.content}</h5>
	                	</c:forEach>
	                </div>
                </div>
            </div>
        </div>