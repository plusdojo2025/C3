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
<!-- フッターここから -->
<%@ include file="header.jsp" %>
<!-- フッターここまで -->

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

  <!-- 日付 -->
  <button id="prev-week">◀ 前の週</button>
  <div id="date-buttons"></div>
  <button id="next-week">次の週 ▶</button>

  <!-- 食事が表示される場所 -->
 <main>
 <!-- 食事選択画面へ遷移 -->
 <a href="<c:url value="DishInfMakan"/>">選択</a>
 
  <div id="content">
    <div class="meal-section">
      <div class="meal-title">朝</div>
      <!-- 料理内容 -->
      <div class="meal-content" id="content-morning">ここに内容が表示されます</div>

    </div>

    <div class="meal-section">
      <div class="meal-title">昼</div>
      <div class="meal-content" id="content-lunch">ここに内容が表示されます</div>
    </div>

    <div class="meal-section">
      <div class="meal-title">晩</div>
      <div class="meal-content" id="content-dinner">ここに内容が表示されます</div>
    </div>

    <div class="meal-section">
      <div class="meal-title">間食</div>
      <div class="meal-content" id="content-snack">ここに内容が表示されます</div>
    </div>
  </div>
</main>

  <!-- トラ画像 -->
  <img src="images/tora.png" width="100", height=aoto>

  <!-- 一日の消費カロリー -->
  <p>今日の消費カロリー</p>
  <p>〇kcal</p>

 <!--　フッター　-->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
    <!--　フッターここまで　-->
    
<script src="script/dish.js"></script>
</body>
</html>
