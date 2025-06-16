<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--　ヘッダー　-->
    <header>
    </header>
    <!--　ヘッダーここまで　-->

    
    <!--　メイン　-->
    <main>
        <p>目標体重　────────</p>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <h2>体重推移グラフ</h2>

            <!-- 表示切替・移動用ボタン -->
            <div id="controls">
                <button onclick="changeToMonth()">月表示</button>
                <button onclick="changeToYear()">年表示</button>
                <button onclick="prev()">前</button>
                <button onclick="next()">次</button>
            </div>
        <div style="width: 600px;">
            <canvas id="weightChart"></canvas>
        </div>
        
        <!-- JavaScriptファイルを読み込む -->
        <script src="WeightGraph.js"></script>

        <div>
            <img src="mama.png" alt="イメージキャラクター" width="100" height=auto>
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
        
    </footer>
    <!--　フッターここまで　-->
</body>
</html>