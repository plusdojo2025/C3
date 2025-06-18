<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果表示</title>
    <link rel="stylesheet" href="<c:url value='/style.css' />">
</head>
<body>
    <!-- ヘッダー -->
    <header>
        <%@ include file="header.jsp" %>
    </header>

    <!-- メイン -->
    <main>
        <h2>結果表示</h2>
        <table>
            <tr>
                <th>目標年収</th>
                <td>${gIncome}</td>
            </tr>
            <tr>
                <th>手取り</th>
                <td>${wWage}</td>
            </tr>
            <tr>
                <th>1日当たりの労働時間</th>
                <td>${wWork}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form action="HomeMakan" method="get">
                        <button type="submit">ホームに戻る</button>
                    </form>
                </td>
            </tr>
        </table>
    </main>

    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>