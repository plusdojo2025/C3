<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><!-- ページタイトル入力 --></title>
    <link rel="stylesheet" href="">

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
                <li><a href="HomeMakan">ホーム</a></li>
                <li><a href="DishMakan">食事登録</a></li>
                <li><a href="#">グラフ</a>
                    <div>
                        <a href="IncomeGraphMakan">グラフ(年収)</a>
                        <a href="WeightGraphMakan">グラフ(体重)</a>
                    </div>
                </li>
                <li><a href="#">年収管理</a>
                    <div>
                        <a href="IncomeResisterMakan">目標年収入力/変更</a>
                        <a href="IncomeResultMakan">計算結果</a>
                    </div>
                </li>
                <li><a href="#">運動管理</a>
                    <div>
                        <a href="HealthResistMakan">目標体重入力/変更</a>
                        <a href="HealthResultFirstWeekMakan">計算結果</a>
                    </div>
                </li>
                <li><a href="LogoutMakan">ログアウト</a></li>
            </ul>
        </nav>
    </header>
    <!--　ヘッダーここまで　-->
    
</body>
</html>