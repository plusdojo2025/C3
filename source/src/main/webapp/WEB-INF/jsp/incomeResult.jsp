<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果表示</title>
    <link rel="stylesheet" href="<c:url value='/css/css_takehiro.css' />">
</head>
<body>
    <!-- ヘッダー -->
    <header>
        <%@ include file="header.jsp" %>
    </header>

    <!-- メイン -->
<main>
    <h2 class="midashi">結果表示</h2>
<c:forEach var="h" items="${emp}">
		<table>
    		<tr>
      			<th>目標年収（万円）：</th>
      			<td>${h.gIncome}</td>
    		</tr>
    		<tr>
      			<th>手取り（万円）</th>
      			<td>${h.netIncome}</td>
    		</tr>
    		<tr>
      			<th>1日当たりの労働時間（時間）</th>
      			<td>${h.dWork}</td>
    		</tr>
    	</table>
    	</c:forEach>
    <form action="HomeMakan" method="get">
    <div style="text-align:center;">
        <button type="submit" class="kadomaru">ホームに戻る</button>
        </div>
    </form>
</main>
    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>