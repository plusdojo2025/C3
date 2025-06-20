<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果(2週目以降)</title>
    <link rel="stylesheet" href="<c:url value=' '/>">

</head>
<body>
    <!--　ヘッダー　-->
    <header>
    <%@ include file="header.jsp" %>
    </header>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
    <main>
    <p>empの中身確認: ${not empty emp}</p>
    <p>サイズ: ${fn:length(emp)}</p>
    
        <h2>＜先週の振り返り＞</h2>
        <table>
		<tr>
			<th>先週の消費カロリー：　</th>
			<td>〇〇kcal</td>
        </tr>
		<tr>
			<th>先週の摂取カロリー：　</th>
			<td>〇〇kcal</td>
        </tr>
        </table>
    
    
        <h2>＜今週の運動予定＞</h2>
		<c:forEach var="h" items="${emp}">
		<table>
    		<tr>
      			<th>今週の一日あたりの運動時間：</th>
      			<td>${h.dMotionTime}　分</td>
    		</tr>
    	</table>
  		</c:forEach>
        
        <a href="<c:url value='HomeMakan'/>"><button>ホームに戻る</button></a>
    </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
    <footer>
    <%@ include file="footer.jsp" %>
    </footer>
    <!--　フッターここまで　-->
</body>
</html>