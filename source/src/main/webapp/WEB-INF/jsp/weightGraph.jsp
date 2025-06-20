<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重グラフ</title>

 <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
 <!-- CSSファイル -->
<link rel="stylesheet" href="<c:url value='/css/css_hana.css'/>">

</head>
<body>
 <!-- フッターここから -->
 <%@ include file="header.jsp" %>
 
 <!-- フッターここまで -->
 <%@ page contentType="text/html; charset=UTF-8" language="java" %>

    
    <!--　メイン　-->
    <main>

        <h2>体重推移グラフ</h2>
		
		   <!-- グラフ表示切替用ボタン -->
        <div class="button-container">
            <button onclick="switchToMonthly()">月別表示</button>
            <button onclick="switchToYearly()">年別表示</button>
        </div>

        <div id="monthly-controls" class="button-container">
            <button onclick="changeMonth(-1)">前月</button>
            <span id="month-label"></span>
            <button onclick="changeMonth(1)">次月</button>
        </div>

        <div id="yearly-controls"  class="button-container" style="display:none;" >
            <button onclick="changeYear(-1)">前年</button>
            <span id="year-label"></span>
            <button onclick="changeYear(1)">次年</button>
        </div>

 		<!-- グラフ本体 -->
        <div id="weightchart-container" style="width: 800px;">
            <canvas id="weightChart"></canvas>
        </div>
        
        <!-- JavaScriptファイルを読み込む -->
        <script src="script/WeightGraph.js"></script>

       
        <img id=mama-weightgraph src="<c:url value='/images/mama.png' />" alt="イメージキャラクター" width="150" height=auto>
        <div id=now-weightgraph>
        
        	<p>現在の体重：○○㎏</p>
            <p>目標まであと：○○kg</p>
            
        </div>

        <div>
            <p>＜体重計算方法＞</p>
            <p>今週の総消費カロリー = 運動量(○○kcal) + 基礎代謝量(○○kcal)－食事量(○○kcal)</p>
            <p>－1kg =－7200kcalを指標に増減を計算しています。</p>
        </div>


    </main>
    <!--　メインここまで　-->
<!--　フッター　-->
<footer>
  <%@ include file="footer.jsp" %>
</footer>
<!--　フッターここまで　-->
</body>
</html>