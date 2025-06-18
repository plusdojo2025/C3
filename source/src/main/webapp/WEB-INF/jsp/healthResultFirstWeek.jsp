<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果(初週)</title>
    <link rel="stylesheet" href="<c:url value=''/>">

</head>
<body>
    <!--　ヘッダー　-->
    <header>
	<%@ include file="header.jsp" %>
    </header>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
    <main>
        <h2>＜今週の運動予定＞</h2>
        <table>
		<tr>
			<th>今週の一日あたりの運動時間：　</th>
			<td>〇〇分</td>
        </tr>
        </table>
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