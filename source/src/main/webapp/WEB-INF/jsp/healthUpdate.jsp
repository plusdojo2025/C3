<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>更新</title>
    <link rel="stylesheet" href="">

</head>
<body>
    <!--　ヘッダー　-->
    <header>

    </header>
    <!--　ヘッダーここまで　-->
    
    <!--　メイン　-->
    <main>
        <h2>Health目標更新</h2>
  <form method="POST" action="HealthResultDefaultMakan">
    <table>
        <tr>
            <td> 
                目標体重
            </td>
            <td>
                <input type="text" name="iWeight"><br>
            </td>
        </tr>
        <tr>
             <td> 
                現在体重
            </td>
            <td>
                <input type="text" name="cWeight"><br>
            </td>
        </tr>
        <tr>
            <td> 
                身長
            </td>
            <td>
                <input type="text" name="height"><br>
            </td>
        </tr>
        <tr>
            <td> 
                年齢
            </td>
            <td>
                <input type="text" name="age"><br>
            </td>
        </tr>
        <tr>
            <td> 
                性別
            </td>
            <td>    
                <label><input type="radio" name="sex" value="m">男性</label>
                <label><input type="radio" name="sex" value="f">女性</label><br>
            </td>
        </tr>
        <tr>
            <td> 
                期間
            </td>
            <td>
                <input type="text" name="term"><br>
            </td>
        </tr>
        <tr>
            <td> 
                一週間の運動日数
            </td>
            <td>
                <input type="text" name="wMotionDays"><br>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="更新">
            </td>
        </tr>
    </table>
  </form>
    </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
    <footer>
        
    </footer>
    <!--　フッターここまで　-->
</body>
</html>
