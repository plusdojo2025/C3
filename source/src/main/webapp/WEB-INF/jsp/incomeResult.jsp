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
		
    目標年収（万円）<input type="text" name="gIncome" value="${MoneyInf.gIncome}"><br>
    手取り（万円）<input type="text" name="netIncome" value="${MoneyInf.netIncome}"><br>
    1日当たりの労働時間（時間）<input type="text" name="dWork" value="${MoneyInf.dWork}"><br>

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