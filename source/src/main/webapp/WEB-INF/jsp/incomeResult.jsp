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
    	
    	 <div class="Form">
			  <div class="Form-Item">
			    <p class="Form-Item-Label-Result">目標年収</p>
	    <p class="Form-Item-Result">${h.gIncome}万円</p><br>
			  </div>
			  <div class="Form-Item">
			    <p class="Form-Item-Label-Result">手取り</p>
			    <p class="Form-Item-Result" >${h.netIncome}万円</p>
	  </div>
			  <div class="Form-Item">
			    <p class="Form-Item-Label-Result">1日当たりの労働時間</p>
			    <p class="Form-Item-Result">${h.dWork}時間</p>
	  </div>
	
		  <input type="hidden" name="U_id" value="${userInf.id}">
		</div> 
    	
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