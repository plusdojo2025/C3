<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Makan-まま管理アプリ-</title>
	<link rel="stylesheet" href="<c:url value='/css/css_login.css' />">
	<link rel="stylesheet" href="<c:url value='/css/css_ryuji.css' />">
</head>
	<body id="top_login" class="login_body">
	        <img src="images/icon.png" alt="まま管理アプリ-makan-">
	        
	        <h1>Makan~ログインフォーム~</h1><!--見出し-->
		<main>
	    	<form id="form_login" class="login_box" action="<c:url value="/LoginMakan" />" method="POST">
	        	<table>
	            	<tr>
	                	<td>
	                    	<label for="ID_login">ID<br>
	                        	<input type="text" name="loginID" placeholder="5桁のIDを入力してください" id="ID_login" pattern="[0-9]{5}">
	                        </label>
	                   	</td>
	           		</tr>
	                <tr>
	                	<td>
	                    	<label for="pass_login">パスワード<br>
	                        	<input type="password" name="loginPassword" placeholder="パスワードを入力してください" id="pass_login" maxlength="20">
	                        </label>
	                    </td>
	               	</tr>
	              	<tr>
	                	<td colspan="2">
	                    	<input type="submit" value="ログイン" class="kadomaru">
	                        <input type="reset" value="リセット" class="kadomaru">
	                        <p id="error_login"><c:out value="${loginMiss}" /></p>
	                  	</td>
	           		</tr>
	         	</table>
	    	</form>
	  	</main>
	  	<footer>
	  		
	  	</footer>
	  	<script src="script/login.js"></script>
	</body>
</html>