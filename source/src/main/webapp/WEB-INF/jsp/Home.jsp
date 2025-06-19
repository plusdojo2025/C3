<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ホーム画面</title>
		<link rel="stylesheet" href="<c:url value='/css/css_home.css' />">
	</head>
	<body>
		<header>
			<%@ include file="header.jsp" %>
		</header>
		<main class="main">
			<!-- <form action = "HomeMakan" method = "post">
				<div>
					<input type = "submit" id = "logout" name = "logout" value ="ログアウト">
				</div>
				
			</form> -->
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
		
		<p><c:out value="${id}" /></p>
		<p><c:out value="${userInf.name}" /></p>
	</body>
</html>
<!-- 
<a href="/c3/IncomeResisterMakan">IncomeResisterMakan</a>
<a href="/c3/HealthResultDefaultMakan">HealthResultDefaultMakan</a>
<a href="/c3/HealthResistMakan">HealthResistMakan</a>
<a href="/c3/WeightGraphMakan">WeightGraphMakan</a>
<a href="/c3/DishMakan">DishMakan</a> -->