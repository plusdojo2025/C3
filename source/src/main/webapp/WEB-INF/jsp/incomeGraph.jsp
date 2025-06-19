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
  <script src="script/incomeGraph.js" defer></script>
  
  <!-- CSSファイル -->
　　<link rel="stylesheet" href="<c:url value='/css/css_hana.css'/>">

  <style>
    #incomechart-container {
      width: 80%;
      margin: 40px auto; 
      
    }
    .button-container {
      text-align: center;
      margin-bottom: 20px;
    }
    button {
      margin: 0 10px;
      padding: 8px 16px;
      font-size: 16px;
    }
  </style>
</head>
<body>

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

<img src="<c:url value='/images/mama.png' />" alt="イメージキャラクター" width="100" height=auto>
<p>現状<br>
現在<br>
目標まであと</p>

</body>
</html>