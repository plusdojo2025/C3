<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			
			<form class="selectWeek">
				<div><button id="" class="beforeWeek">前の週</button><button id="" class="nextWeek">次の週</button></div>
			</form>
			<ul id="" class="horizontal-list head">
				<li id="" class="horizontal-item"></li>
				<c:forEach var="e" items="${week}" >
					<li id="" class="horizontal-item"><fmt:formatDate value="${e}" pattern="MM/dd(E)" /></li>
				</c:forEach>
				<li id="" class="horizontal-item spacer">
					<form id="home-form" class="home-form" method="post" action="">
						<c:forEach var="e" items="${dWork}" varStatus="status">
							<input type="hidden" name="idList" value="item-<c:out value='${e.u_id}'/>">
							<input type="hidden" name="item-<c:out value='${e.u_id}'/>[0]" value="<c:out value='${status.index*30}'/>">
					    	<input type="hidden" name="item-<c:out value='${e.u_id}'/>[1]" value="<c:out value='${e.dWork/10*4}'/>">
					    	<input type="hidden" name="item-<c:out value='${e.u_id}'/>[2]" value="etc1">
						</c:forEach>
						<c:forEach var="e" items="${dWalk}" varStatus="status">
							<input type="hidden" name="idList" value="item-<c:out value='${e.u_id}'/>">
							<input type="hidden" name="item-<c:out value='${e.u_id}'/>[0]" value="<c:out value='${status.index*30}'/>">
					    	<input type="hidden" name="item-<c:out value='${e.u_id}'/>[1]" value="<c:out value='${e.dMotionTime/10*4}'/>">
					    	<input type="hidden" name="item-<c:out value='${e.u_id}'/>[2]" value="etc2">
						</c:forEach>
						<div>
							<button class="decide" type="submit">確定</button>
							<button class="reset" id="clear-storage">位置リセット</button>
						</div>
					</form>
				</li>
				<li id="" class="horizontal-item spacer">
					
				</li>
				<li id="" class="horizontal-item spacer">
					
				</li>
		    </ul>
			<ul id="weekly-list" class="horizontal-list">
				<li id="" class="horizontal-item time" style="position:relative;">
					<!-- 一時間24px　10分4px 開始は-13から -->
					<!-- <div style="position:absolute; top:-13px; right:0px;">0:00──</div>-->
					<div style="position:absolute; top:11px; right:0px;">1:00──</div>
					<div style="position:absolute; top:35px; right:0px;">2:00──</div>
					<div style="position:absolute; top:59px; right:0px;">3:00──</div>
					<div style="position:absolute; top:83px; right:0px;">4:00──</div>
					<div style="position:absolute; top:107px; right:0px;">5:00──</div>
					<div style="position:absolute; top:131px; right:0px;">6:00──</div>
					<div style="position:absolute; top:155px; right:0px;">7:00──</div>
					<div style="position:absolute; top:179px; right:0px;">8:00──</div>
					<div style="position:absolute; top:203px; right:0px;">9:00──</div>
					<div style="position:absolute; top:227px; right:0px;">10:00──</div>
					<div style="position:absolute; top:251px; right:0px;">11:00──</div>
					<div style="position:absolute; top:275px; right:0px;">12:00──</div>
					<div style="position:absolute; top:299px; right:0px;">13:00──</div>
					<div style="position:absolute; top:323px; right:0px;">14:00──</div>
					<div style="position:absolute; top:347px; right:0px;">15:00──</div>
					<div style="position:absolute; top:371px; right:0px;">16:00──</div>
					<div style="position:absolute; top:395px; right:0px;">17:00──</div>
					<div style="position:absolute; top:419px; right:0px;">18:00──</div>
					<div style="position:absolute; top:443px; right:0px;">19:00──</div>
					<div style="position:absolute; top:467px; right:0px;">20:00──</div>
					<div style="position:absolute; top:491px; right:0px;">21:00──</div>
					<div style="position:absolute; top:515px; right:0px;">22:00──</div>
					<div style="position:absolute; top:539px; right:0px;">23:00──</div>
					<!-- <div style="position:absolute; top:576px; right:0px;">24:00──</div> -->
				</li>
				<c:if test="${not empty sList}">
					<c:forEach var="e" items="${sList}" >
						<li id="sun" class="horizontal-item <c:if test="${1 <= now}">tourokuzumi</c:if>"></li>
					    <li id="mon" class="horizontal-item <c:if test="${2 <= now}">tourokuzumi</c:if>"></li>
					    <li id="tue" class="horizontal-item <c:if test="${3 <= now}">tourokuzumi</c:if>"></li>
					    <li id="wed" class="horizontal-item <c:if test="${4 <= now}">tourokuzumi</c:if>"></li>
					    <li id="thu" class="horizontal-item <c:if test="${5 <= now}">tourokuzumi</c:if>"></li>
					    <li id="fri" class="horizontal-item <c:if test="${6 <= now}">tourokuzumi</c:if>"></li>
					    <li id="sat" class="horizontal-item <c:if test="${7 <= now}1">tourokuzumi</c:if>"></li>
					</c:forEach>
				</c:if>
				<c:if test="${empty sList}">
		    		<li id="sun" class="horizontal-item"></li>
				    <li id="mon" class="horizontal-item"></li>
				    <li id="tue" class="horizontal-item"></li>
				    <li id="wed" class="horizontal-item"></li>
				    <li id="thu" class="horizontal-item"></li>
				    <li id="fri" class="horizontal-item"></li>
				    <li id="sat" class="horizontal-item"></li>
				</c:if>
			    <li id="etc1" class="horizontal-item">
				    <c:forEach var="e" items="${dWork}"  varStatus="status">
				    	<div id="item-<c:out value='${e.u_id}'/>" class="box work" style="z-index:<c:out value='${status.index}'/>">仕事
				            <div id="item-<c:out value='${e.u_id}'/>-top" class="drug-bar drug-bar-top"></div>
				            <div id="item-<c:out value='${e.u_id}'/>-end" class="drug-bar drug-bar-end"></div>
				        </div>
					</c:forEach>
			    </li>
			    <li id="etc2" class="horizontal-item">
			    	<c:forEach var="e" items="${dWalk}" varStatus="status" >
						<div id="item-<c:out value='${e.u_id}'/>" class="box walk" style="z-index:<c:out value='${status.index}'/>">ウォーキング
				        	<div id="item-<c:out value='${e.u_id}'/>-top" class="drug-bar drug-bar-top"></div>
				            <div id="item-<c:out value='${e.u_id}'/>-end" class="drug-bar drug-bar-end"></div>
				        </div>
					</c:forEach>
			    </li>
			    <li id="etc3" class="horizontal-item">
			        
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
				<li id="" class="horizontal-item spacer"></li>
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
		<p><c:out value="${dWalk}" /></p>
		<jsp:include page="homeScript.jsp" />
	</body>
</html>
<!-- 
<a href="/c3/IncomeResisterMakan">IncomeResisterMakan</a>
<a href="/c3/HealthResultDefaultMakan">HealthResultDefaultMakan</a>
<a href="/c3/HealthResistMakan">HealthResistMakan</a>
<a href="/c3/WeightGraphMakan">WeightGraphMakan</a>
<a href="/c3/DishMakan">DishMakan</a> -->