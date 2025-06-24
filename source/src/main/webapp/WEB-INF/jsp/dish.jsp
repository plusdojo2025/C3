<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事表示</title>

<style>

.kadomaru {
  justify-content: center;
  color: white;
  background-color: #B5ACA1;
  border-radius: 10px;
  width: 128px;
  padding: 10px 20px; /* 縦横の余白を調整 */
 
  width: auto; /* 必要なら明示的に */
  white-space: nowrap; /* 改行しない */
  font-size: 20px;
  max-width: 160px; /* 必要なら最大幅を指定 */
  text-decoration: none;
  font-weight: bold;
  display: inline-block;
  margin: 15px auto;
}

.kadomarud{
  margin: 15px auto;
  justify-content: center;
  display: flex;
  font-size: 20px;
  
  }
  
#week-nav {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px; /* ボタンと日付の間隔 */
  margin: 20px auto;
  flex-wrap: wrap;
}

/* 日付ボタンの親要素を中央揃え */
#date-buttons {
  display: flex;
  gap: 8px;
  flex-wrap: wrap;
}

/* 日付ボタンの基本スタイル */
#date-buttons button{
  background-color: #FEF4F4;
  border: 1px solid #ccc;
  border-radius: 12px;
  padding: 8px 12px;
  cursor: pointer;
  transition: background-color 0.2s;
}

/* ホバー時の色 */
#date-buttons button:hover {
  background-color: #F5B1AA;
}

/* 選択中のボタン */
#date-buttons button.selected {
  background-color: #F5B1AA;
  font-weight: bold;
}

/* 食事内容全体 */
.meal-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  max-width: 1200px;
  margin: 0 auto;
}

/*食事表示全体*/
  .meal-section {
    width: 45%; /*横２列にする*/
    border: 2px solid #ccc;
    border-radius: 15px;
    padding: 15px;
    margin: 15px auto;
    max-width: 500px;
    background-color: #fff8cc; /* デフォルトは淡い黄色 */
    box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
  }

  .meal-section.blue {
    background-color: #e0f4ff; /* 淡い水色 */
  }

  .meal-section h2 {
    text-align: center;
    margin-top: 0;
    color: #333;
  }

  .meal-section p {
    font-size: 16px;
    padding: 5px;
    margin: 3px 0;
  }
  
  /*ナビゲーション*/
  #prev-week, #next-week{
  	max-width: 100px;
  	radius: 12px;
  	padding: 8px 12px;
  	background-color: white;
  	border:white;
  }

.selecteddate{
	text-align: center;
}
  
</style>

<link rel="stylesheet" href="<c:url value='/css/css_madoka.css' />">
</head>
<body>

<!-- ヘッダー読み込み -->
<header>
<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
</header>

<!-- 日付ナビゲーション -->
<div id="week-nav">
<button id="prev-week">◀ 前の週</button>
<div id="date-buttons"></div>
<button id="next-week">次の週 ▶</button>
</div>
<!-- 例：選択中の日付の表示 -->
<div class="selecteddate"><p>選択中の日付：<c:out value="${selectedDate}" /></p></div>

<!-- 食事が表示される場所 -->
<main>
  <!-- 食事選択画面へ遷移 -->
  <div class=kadomarud><a id="select-link" class=kadomaru href="DishInfMakan">食事選択画面へ</a></div>
  
  <div class="meal-container">
  <div class="meal-section yellow">
    <h2>朝食</h2>
    <div id="content-morning">
      <c:forEach var="b" items="${dish}" begin="0" end="3">
        <p>${b.name}（${b.calorie} kcal）</p>	
      </c:forEach>
    </div>
  </div>

  <div class="meal-section blue">
    <h2>昼食</h2>
    <div id="content-noon">
      <c:forEach var="n" items="${dishN}" begin="0" end="3">
        <p>${n.name}（${n.calorie} kcal）</p>		
      </c:forEach>
    </div>
  </div>

  <div class="meal-section blue">
    <h2>夕食</h2>
    <div id="content-evening">
      <c:forEach var="e" items="${dishE}" begin="0" end="3">
        <p>${e.name}（${e.calorie} kcal）</p>
      </c:forEach>
    </div>
  </div>

  <div class="meal-section yellow">
    <h2>間食</h2>
    <div id="content-snack">
      <c:forEach var="s" items="${dishS}" begin="0" end="3">
        <p>${s.name}（${s.calorie} kcal）</p>
      </c:forEach>
    </div>
  </div>
</div>
</main>

<!-- トラ画像
<img src="images/tora.png" width="100" height="auto">

 一日の消費カロリー
<p>今日の消費カロリー</p>
<p>○kcal</p>
 -->
<!-- フッター読み込み -->
<footer>
  <%@ include file="footer.jsp" %>
</footer>

<!-- JavaScript 読み込み -->

<jsp:include page="script/dish.js.jsp" />
</body>
</html>
