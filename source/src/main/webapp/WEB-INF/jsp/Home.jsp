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
			<form id="home-form">
    <input type="text" name="item-10[0]" value="100">
    <input type="text" name="item-10[1]" value="50">
    <input type="text" name="item-10[2]" value="etc">
</form>
	<ul id="" class="horizontal-list head">
	<li id="" class="horizontal-item"></li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item">6/9<br>(月)</li>
	<li id="" class="horizontal-item spacer"></li>
    </ul>
<ul id="weekly-list" class="horizontal-list">
	<li id="memori" class="horizontal-item">
		<div style="position:absolute; top:0px;">0:00</div>
		<div style="position:absolute; top:24px;">1:00</div>
		<div style="position:absolute; top:48px;">2:00</div>
		<div style="position:absolute; top:72px;">3:00</div>
		<div style="position:absolute; top:96px;">4:00</div>
		<div style="position:absolute; top:120px;">5:00</div>
		<div style="position:absolute; top:144px;">6:00</div>
		<div style="position:absolute; top:168px;">7:00</div>
		<div style="position:absolute; top:192px;">8:00</div>
		<div style="position:absolute; top:216px;">9:00</div>
	</li>
    <li id="sun" class="horizontal-item">

    </li>
    <li id="mon" class="horizontal-item">

    </li>
    <li id="tue" class="horizontal-item">

    </li>
    <li id="wed" class="horizontal-item">

    </li>
    <li id="thu" class="horizontal-item">

    </li>
    <li id="fri" class="horizontal-item">

    </li>
    <li id="sat" class="horizontal-item">

    </li>
    <li id="etc" class="horizontal-item">
        <div id="item-10" class="box walk">
            <div id="item-10-top" class="drug-bar drug-bar-top"></div>
            <div id="item-10-end" class="drug-bar drug-bar-end"></div>
        </div>
    </li>
    </ul>
    <ul id="" class="horizontal-list foot">
	<li id="" class="horizontal-item"></li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item">運動で消費したカロリー200kcal</li>
	<li id="" class="horizontal-item spacer"></li>
    </ul>
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
		<jsp:include page="homeScript.jsp" />
	</body>
</html>
<!-- 
<a href="/c3/IncomeResisterMakan">IncomeResisterMakan</a>
<a href="/c3/HealthResultDefaultMakan">HealthResultDefaultMakan</a>
<a href="/c3/HealthResistMakan">HealthResistMakan</a>
<a href="/c3/WeightGraphMakan">WeightGraphMakan</a>
<a href="/c3/DishMakan">DishMakan</a> -->