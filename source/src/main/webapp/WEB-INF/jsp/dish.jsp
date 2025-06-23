<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<c:set var="labels" value="朝,昼,晩,間食" />
<c:forEach var="label" items="${fn:split(labels, ',')}" varStatus="status">
  <div class="meal-section">
    <div class="meal-title">${label}</div>
    <div class="meal-content">
      <c:choose>
        <c:when test="${dish != null and status.index < dish.size()}">
          <p><c:out value="${dish.get(status.index).name}" /></p>
          <p><c:out value="${dish.get(status.index).calorie}" /> kcal</p>
        </c:when>
        <c:otherwise>
          <p>データがありません</p>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</c:forEach>

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
