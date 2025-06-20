<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>年収グラフ</title> 

  <!-- Chart.js本体 -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.0/dist/chart.umd.min.js"></script>

  <!-- JSファイル -->
<!--  <script src="script/incomeGraph.js" defer></script> -->
  
  <!-- CSSファイル -->
　　<link rel="stylesheet" href="<c:url value='/css/css_hana.css'/>">

</head>
<body>

<!-- フッターここから -->
<%@ include file="header.jsp" %>
<!-- フッターここまで -->

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<h2>収入推移グラフ</h2>

<div class="button-container">
  <button onclick="changeYear(-1)">前年</button>
  <span id="year-label">2025年</span>
  <button onclick="changeYear(1)">次年</button>
</div>

<!-- グラフ本体 -->
<div id="incomechart-container" style="width: 800px;">
    <canvas id="incomeChart"></canvas>
</div>


<img id=mama-incomegraph src="<c:url value='/images/mama.png' />" alt="イメージキャラクター" width="150" height=auto>
<div id=now-incomegraph>	
	<p>現状<br>
	現在<br>
	目標まであと</p>
</div>

<!--　フッター　-->
<footer>
  <%@ include file="footer.jsp" %>
</footer>
<!--　フッターここまで　-->
<jsp:include page="script/incomeGraph.js.jsp" />
</body>
</html>