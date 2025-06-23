<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事表示</title>

<link rel="stylesheet" href="<c:url value='/css/css_madoka.css' />">
</head>
<body>
<!-- ヘッダー読み込み -->
<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!-- 日付ナビゲーション -->
<button id="prev-week">◀ 前の週</button>
<div id="date-buttons"></div>
<button id="next-week">次の週 ▶</button>

<!-- 食事が表示される場所 -->
<main>
  <!-- 食事選択画面へ遷移 -->
  <a id="select-link" href="DishInfMakan">選択</a>
	<h2>朝食</h2>
      <div id="content-morning">
		<c:forEach var="b" items="${dish}" begin="0" end="3" varStatus="status">
		<p>${b.name}（${b.calorie} kcal）</p>	
		</c:forEach>
		</div>
	<h2>昼食</h2>
      <div id="content-noon">
		<c:forEach var="n" items="${dishN}" begin="0" end="3" varStatus="status">
		<p>${n.name}（${n.calorie} kcal）</p>		
		</c:forEach>
		</div>
	<h2>夕食</h2>
      <div id="content-evening">
		<c:forEach var="e" items="${dishE}" begin="0" end="3" varStatus="status">
		<p>${e.name}（${e.calorie} kcal）</p>
		</c:forEach>
		</div>
	<h2>間食</h2>
      <div id="content-morning">
		<c:forEach var="s" items="${dishS}" begin="0" end="3" varStatus="status">
		<p>${s.name}（${s.calorie} kcal）</p>
		</c:forEach>
		</div>
</main>

<!-- トラ画像 -->
<img src="images/tora.png" width="100" height="auto">

<!-- 一日の消費カロリー -->
<p>今日の消費カロリー</p>
<p>○kcal</p>

<!-- フッター読み込み -->
<footer>
  <%@ include file="footer.jsp" %>
</footer>

<!-- JavaScript 読み込み -->

<jsp:include page="script/dish.js.jsp" />
</body>
</html>
