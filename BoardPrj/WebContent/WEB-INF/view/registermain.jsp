<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Page content-->
                <div class="container-fluid">
                	<h1>회원가입</h1>
                    <form action="/registerService" method="post">
                    	<h4>이름</h4><input type="text" name="name">
                    	<h4>아이디</h4><input type="text" name="id">
                    	<h4>비밀번호</h4><input type="password" name="pw"><br /><br />
                    	<input type="submit" value="회원가입">
                    </form>
                </div>
            </div>
        </div>