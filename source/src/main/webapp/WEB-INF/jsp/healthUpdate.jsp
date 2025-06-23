<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>更新</title>
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
        <h2 class="midashi">Health目標更新</h2>
  <c:forEach var="h" items="${emp}">
 
  <form method="POST" action="<c:url value='HealthUpdateMakan' />"> 
   <div class="Form">
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>目指す体重
    </p>
    <input type="number" name="iWeight" class="Form-Item-Input" placeholder="単位：kg" value="${h.iWeight }"><br>
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>現在の体重</p>
    <input type="number" name="cWeight" class="Form-Item-Input" placeholder="単位：kg" value="${h.cWeight }">
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>身長</p>
    <input type="number" name="height" class="Form-Item-Input" placeholder="単位：cm" value="${h. height}">
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>年齢</p>
    <input type="number" name="age" class="Form-Item-Input" placeholder="" value="${h.age }">
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>性別
    </p>
    <input type="radio" name="gender" id="M" value="M"><label for="M" class="label">男性</label>
    <input type="radio" name="gender" id="F" value="F"><label for="F" class="label">女性</label><br>
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>期間
    </p>
    <input type="number" name="term" class="Form-Item-Input" placeholder="単位：日" value="${h.term }"><br>
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>1週間の運動日数
    </p>
    <input type="number" name="wMotionDays" class="Form-Item-Input" min="1" max="7" placeholder="単位：日（1～7で入力）" value="${h.wMotionDays }"><br>
  </div>
  <input type="number" name="lwCcalorie" value="${h.lwCcalorie}">
  <input type="number" name="lwIcalorie" value="${h.lwIcalorie}">
  <input type="hidden" name="U_id" value="${userInf.id}">
  <div style="text-align:center;" class="Form-Item">                  
      <input type="submit" name="submit" class="kadomarutake" value="更新">  
  </div>
</div>
</form>
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
