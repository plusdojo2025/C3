<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>労働時間計算（登録）</title>
    <%-- <link rel="stylesheet" href="<c:url value='/css/style.css' />"> --%>
    <link rel="stylesheet" href="<c:url value='/css/css_takehiro.css' />">
</head>
<body>
    <!-- ヘッダー -->
    <header>
        <%@ include file="header.jsp" %>
    </header>

    <!-- メイン -->
    <main>
                
	 <form method="POST" action="<c:url value="/IncomeResultMakan" />">                
	   <div class="Form">
			  <div class="Form-Item">
			    <p class="Form-Item-Label">
			      <span class="Form-Item-Label-Required">必須</span>目標年収
	    </p>
	    <input type="number" name="gIncome" class="Form-Item-Input" placeholder="単位：万円" min="0" max="1000"><br>
			  </div>
			  <div class="Form-Item">
			    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>時給</p>
			    <input type="number" name="hWage" class="Form-Item-Input" placeholder="単位：円" min="0">
	  </div>
			  <div class="Form-Item">
			    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>1週間の希望労働日数</p>
			    <input type="number" name="wWork" class="Form-Item-Input" placeholder="単位：日"min="0" max="7">
	  </div>
	
	  <div class="Form-Item">
			    <p class="Form-Item-Label">
			      <span class="Form-Item-Label-Required">必須</span>扶養の有無
	    </p>
			    <input type="radio" name="dependent" id="YES" value="YES"><label for="YES" class="label">はい</label>
			    <input type="radio" name="dependent" id="NO" value="NO"><label for="NO" class="label">いいえ</label><br>
	  </div>
	 
	 
		<input type="hidden" name="U_id" value="${userInf.id}">
				  <div style="text-align:center;" class="Form-Item">
				      <input type="submit" name="submit" class="kadomarutake" value="決定">
				  </div>                  
              
                    
        </form>
    </main>
  
    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>