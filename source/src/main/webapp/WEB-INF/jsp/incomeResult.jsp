<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><!-- ページタイトル入力 --></title>
    <link rel="stylesheet" href="<c:url value='' />">

</head>
<body>
    <!--　ヘッダー　-->
    <header>
        <%@ include file="header.jsp" %>
    </header>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
    <main>
        <h2>結果表示</h2>
   <form>
    <table>
        <tr>
            <label>
                <td> 
                    目標年収
                </td>
                <td>
                  年収の数字(gIncome)
                </td>
            </label>
        </tr>
        <tr>
            <label>
                <td> 
                    手取り
                </td>
                <td>
                    手取り(wWage)
                </td>
            </label>
        </tr>
        <tr>
            <label>
                <td> 
                    1日当たりの労働時間
                </td>
                <td>
                    手取り(wWork)
                </td>
            </label>
        </tr>
        <tr>
            <td>
              <a href="HomeMakan"><button type="button">ホームに戻る</button></a>
            </td>
            
        </tr>
    </table>
    </form>
    </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
    <!--　フッターここまで　-->
</body>
</html>