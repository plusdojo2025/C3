<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果(初週)</title>
    <link rel="stylesheet" href="<c:url value='css/css_takehiro.css'/>">

</head>
<body>
    <!--　ヘッダー　-->
    <header>
	<%@ include file="header.jsp" %>
    </header>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
    <main>
       <h2 class="midashi">＜計算結果＞</h2>        
		<c:forEach var="h" items="${emp}">	
<div class="Form">
  <div class="Form-Item">
    <p class="Form-Item-Label-Result">
     	今週の一日あたりの運動時間
    </p>
    <p class="Form-Item-Result">${h.dMotionTime}分</p><br>
  </div>
  <a href="<c:url value='HomeMakan'/>"><button class="kadomarutake">ホームに戻る</button></a>
  </div>
  
  		</c:forEach>
    </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
    <footer>
 	<%@ include file="footer.jsp" %>       
    </footer>
    <!--　フッターここまで　-->
</body>
</html>