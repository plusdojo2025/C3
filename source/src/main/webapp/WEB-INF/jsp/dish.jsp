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

  <div id="content">
    <div class="meal-section">
      <div class="meal-title">朝</div>
      <div class="meal-content" id="content-morning">
        <p><c:out value="${dish.get(0).name}"></c:out></p>
      </div>
    </div>

    <div class="meal-section">
      <div class="meal-title">昼</div>
      <div class="meal-content" id="content-lunch">
        <p>ここに内容が表示されます</p>
      </div>
    </div>

    <div class="meal-section">
      <div class="meal-title">晩</div>
      <div class="meal-content" id="content-dinner">
        <p>ここに内容が表示されます</p>
      </div>
    </div>

    <div class="meal-section">
      <div class="meal-title">間食</div>
      <div class="meal-content" id="content-snack">
        <p>ここに内容が表示されます</p>
      </div>
    </div>
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
