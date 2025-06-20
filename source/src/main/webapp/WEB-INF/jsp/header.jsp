<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><!-- ページタイトル入力 --></title>
	<link rel="stylesheet" href="<c:url value='/css/css_ryuji.css' />">
	<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
    <!--　ヘッダー　-->
    <header class="header">
    	<div class="makan"><a class="logo" href="HomeMakan">MAKAN</a></div>
        <div class="logo_img">
            <a href="HomeMakan"><img src="<c:url value='images/icon.png' />" alt="MAKAN" ></a>
        </div>
        
        <nav class="nav">
            <ul class="nav_list">
                <li class="kadomaru2"><a href="HomeMakan">ホーム</a></li>
                <li class="kadomaru2"><a href="DishMakan">食事登録</a></li>
                <li class="kadomaru2" id="graph"><a href="#">グラフ</a>
                    <ul class="dropdown">
                        <li><a href="IncomeGraphMakan">グラフ(年収)</a></li>
                        <li><a href="WeightGraphMakan">グラフ(体重)</a> </li>
                    </ul>
                </li>
                <li class="kadomaru2"><a href="#">年収管理</a>
                    <ul class="dropdown">
                        <li><a href="IncomeResisterMakan">目標年収入力/変更</a></li>
                        <li><a href="IncomeResultMakan">計算結果</a></li>
                    </ul>
                </li>
                <li class="kadomaru2"><a  href="#">運動管理</a>
                    <ul class="dropdown">
                        <li><a href="HealthResistMakan">目標体重入力/変更</a></li>
                        <li><a href="HealthResultDefaultMakan">計算結果</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div><a href="LogoutMakan" class="headerLogout">ログアウト</a></div>
    </header>
    <!--　ヘッダーここまで　-->
    
</body>
</html>