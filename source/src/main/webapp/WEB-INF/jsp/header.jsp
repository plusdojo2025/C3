<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>タイトル入力</title>
    <link rel="stylesheet" href="<c:url value='' />">
</head>
<body>
    <!--　ヘッダー　-->
    <header>
        <div>
            <a href="<c:url value='HomeMakan'/>"><img src="<c:url value='' />" alt="MAKAN"/></a>
        </div>
        <nav>
            <ul>

                <li><a href="HomeMakan"><img src="<c:url value='' />" alt="ロゴ表示"></a></li>
                <li class="kadomaru"><a href="<c:url value='HomeMakan'/>">ホーム</a></li>
                <li class="kadomaru"><a href="<c:url value='DishMakan'/>">食事登録</a></li>
                <li class="kadomaru"><a href="#">グラフ</a>
                    <div>
                        <a href="<c:url value='IncomeGraphMakan'/>">グラフ(年収)</a>
                        <a href="<c:url value='WeightGraphMakan'/>">グラフ(体重)</a>
                    </div>
                </li>
                <li class="kadomaru"><a href="#">年収管理</a>
                    <div>
                        <a href="<c:url value='IncomeResisterMakan'/>">目標年収入力/変更</a>
                        <a href="<c:url value='IncomeResultMakan'/>">計算結果</a>
                    </div>
                </li>
                <li class="kadomaru"><a href="#">運動管理</a>
                    <div>
                        <a href="<c:url value='HealthResistMakan'/>">目標体重入力/変更</a>
                        <a href="<c:url value='HealthResultFirstWeekMakan'/>">計算結果</a>
                    </div>
                </li>

                <li class="kadomaru"><a href="<c:url value='LogoutMakan'/>">ログアウト</a></li>
            </ul>
        </nav>
    </header>
    <!--　ヘッダーここまで　-->
    
</body>
</html>