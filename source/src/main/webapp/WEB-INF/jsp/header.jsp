<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><!-- ページタイトル入力 --></title>
    <link rel="stylesheet" href="">
<link rel="stylesheet" href="<c:url value='/css/css_ryuji.css' />">
</head>
<body>
    <!--　ヘッダー　-->
    <header>
        <div>
            <a href="MenuServlet"><img src="" alt="MAKAN"></a>
        </div>
        <nav>
            <ul>
                <li><a href="HomeMakan"><img src="" alt="ロゴ表示"></a></li>
                <li class="kadomaru"><a href="HomeMakan">ホーム</a></li>
                <li class="kadomaru"><a href="DishMakan">食事登録</a></li>
                <li class="kadomaru"><a href="#">グラフ</a>
                    <div>
                        <a href="IncomeGraphMakan">グラフ(年収)</a>
                        <a href="WeightGraphMakan">グラフ(体重)</a>
                    </div>
                </li>
                <li class="kadomaru"><a href="#">年収管理</a>
                    <div>
                        <a href="IncomeResisterMakan">目標年収入力/変更</a>
                        <a href="IncomeResultMakan">計算結果</a>
                    </div>
                </li>
                <li class="kadomaru"><a href="#">運動管理</a>
                    <div>
                        <a href="HealthResistMakan">目標体重入力/変更</a>
                        <a href="HealthResultFirstWeekMakan">計算結果</a>
                    </div>
                </li>
                <li class="kadomaru"><a href="LogoutMakan">ログアウト</a></li>
            </ul>
        </nav>
    </header>
    <!--　ヘッダーここまで　-->
    
</body>
</html>