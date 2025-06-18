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
    <c:forEach var="b" items="${emp}">
        <table>
            <tr>
                <th>目標年収</th>
                <td>${b.gIncome}</td>
            </tr>
            <tr>
                <th>手取り</th>
                <td>${b.netIncome}</td>
            </tr>
            <tr>
                <th>1日当たりの労働時間</th>
                <td>${b.dWork}</td>
            </tr>
        </table>
    </c:forEach>

    <form action="HomeMakan" method="get">
        <button type="submit">ホームに戻る</button>
    </form>
</main>
    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>