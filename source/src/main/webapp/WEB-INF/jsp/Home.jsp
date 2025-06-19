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
			<form id="home-form" class="home-form">
		    	<input type="text" name="item-10[0]" value="100">
			    <input type="text" name="item-10[1]" value="50">
			    <input type="text" name="item-10[2]" value="etc">
			    <input type="text" name="item-11[0]" value="240">
			    <input type="text" name="item-11[1]" value="120">
			    <input type="text" name="item-11[2]" value="etc">
			    <input type="text" name="item-12[0]" value="240">
			    <input type="text" name="item-12[1]" value="120">
			    <input type="text" name="item-12[2]" value="sun">
			</form>
			<form class="selectWeek">
				<div><button id="" class="beforeWeek">前の週</button><button id="" class="nextWeek">次の週</button></div>
			</form>
			<ul id="" class="horizontal-list head">
				<li id="" class="horizontal-item"></li>
				<li id="dateSun" class="horizontal-item">6/8<br>(日)</li>
				<li id="" class="horizontal-item">6/9<br>(月)</li>
				<li id="" class="horizontal-item">6/10<br>(火)</li>
				<li id="" class="horizontal-item">6/11<br>(水)</li>
				<li id="" class="horizontal-item">6/12<br>(木)</li>
				<li id="" class="horizontal-item">6/13<br>(金)</li>
				<li id="" class="horizontal-item">6/14<br>(土)</li>
				<li id="" class="horizontal-item spacer">
					<div><button type="button" class="decide">確定</button></div>
				</li>
		    </ul>
			<ul id="weekly-list" class="horizontal-list">
				<li id="" class="horizontal-item time" style="position:relative;">
					<div style="position:absolute; top:0px; right:0px;">0:00──</div>
					<div style="position:absolute; top:24px; right:0px;">1:00──</div>
					<div style="position:absolute; top:48px; right:0px;">2:00──</div>
					<div style="position:absolute; top:72px; right:0px;">3:00──</div>
					<div style="position:absolute; top:96px; right:0px;">4:00──</div>
					<div style="position:absolute; top:120px; right:0px;">5:00──</div>
					<div style="position:absolute; top:144px; right:0px;">6:00──</div>
					<div style="position:absolute; top:168px; right:0px;">7:00──</div>
					<div style="position:absolute; top:192px; right:0px;">8:00──</div>
					<div style="position:absolute; top:216px; right:0px;">9:00──</div>
					<div style="position:absolute; top:240px; right:0px;">10:00──</div>
					<div style="position:absolute; top:264px; right:0px;">11:00──</div>
					<div style="position:absolute; top:288px; right:0px;">12:00──</div>
					<div style="position:absolute; top:312px; right:0px;">13:00──</div>
					<div style="position:absolute; top:336px; right:0px;">14:00──</div>
					<div style="position:absolute; top:360px; right:0px;">15:00──</div>
					<div style="position:absolute; top:384px; right:0px;">16:00──</div>
					<div style="position:absolute; top:408px; right:0px;">17:00──</div>
					<div style="position:absolute; top:432px; right:0px;">18:00──</div>
					<div style="position:absolute; top:456px; right:0px;">19:00──</div>
					<div style="position:absolute; top:480px; right:0px;">20:00──</div>
					<div style="position:absolute; top:504px; right:0px;">21:00──</div>
					<div style="position:absolute; top:528px; right:0px;">22:00──</div>
					<div style="position:absolute; top:552px; right:0px;">23:00──</div>
					<div style="position:absolute; top:576px; right:0px;">24:00──</div>
				</li>
	    		<li id="sun" class="horizontal-item">
	    			<div id="item-12" class="box work">仕事
			            <div id="item-12-top" class="drug-bar drug-bar-top"></div>
			            <div id="item-12-end" class="drug-bar drug-bar-end"></div>
			        </div>
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
			        <div id="item-10" class="box walk">ウォーキング
			            <div id="item-10-top" class="drug-bar drug-bar-top"></div>
			            <div id="item-10-end" class="drug-bar drug-bar-end"></div>
			        </div>
			        <div id="item-11" class="box work">仕事
			            <div id="item-11-top" class="drug-bar drug-bar-top"></div>
			            <div id="item-11-end" class="drug-bar drug-bar-end"></div>
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