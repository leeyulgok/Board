<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Page content-->
                <div class="container-fluid">
                	<h1>글쓰기</h1>
                    <form action="/noticeWriteService" method="post" class="form">
                    	<h4>제목</h4>
                    	<input type="text" name="title">
                    	<h4>내용</h4>
                    	<textarea name="content"></textarea><br />
                    	<p>비공개하기<input type="radio" name="pub" value="0"></p><br />
                    	<input type="submit" value="글쓰기">
                    </form>
                </div>
            </div>
        </div>