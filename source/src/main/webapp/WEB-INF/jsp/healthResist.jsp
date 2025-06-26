<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録</title>
    <link rel="stylesheet" href="<c:url value='css/css_takehiro.css ' />">
    <!-- <link rel="stylesheet" href="<c:url value='css/css_ryuji.css ' />"> -->

</head>
<body>
    <!--　ヘッダー　-->
    <%@ include file="header.jsp" %>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
<main>
        <h2 class="midashi">Health目標入力</h2>
        <p class="midashi">あなたの身体情報をもとに、一日当たりの必要な運動時間を概算します</p>
<form method="POST" action="<c:url value='HealthResistMakan' />" onsubmit="return validateWeightLoss();"> 
   <div class="Form">
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>目指す体重
    </p>
    <input type="number" name="iWeight" class="Form-Item-Input" placeholder="単位：kg (現在体重より低い値にしてください)"><br>
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>現在の体重</p>
    <input type="number" name="cWeight" class="Form-Item-Input" placeholder="単位：kg">
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>身長</p>
    <input type="number" name="height" class="Form-Item-Input" placeholder="単位：cm">
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label"><span class="Form-Item-Label-Required">必須</span>年齢</p>
    <input type="number" name="age" class="Form-Item-Input" placeholder="">
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
    <input type="number" name="term" class="Form-Item-Input" placeholder="単位：日"><br>
  </div>
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>1週間の運動日数
    </p>
    <input type="number" name="wMotionDays" class="Form-Item-Input" min="1" max="7" placeholder="単位：日（1～7で入力）"><br>
  </div>
  <input type="hidden" name="U_id" value="${userInf.id}">
  <div  style="text-align:center;"class="Form-Item">                  
      <input type="submit" name="submit" class="kadomarutake" value="決定">  
  </div>
</div>
</form>

<!-- JavaScript取得 -->
<script src="<c:url value='/script/healthResistAlert.js' />"></script>

</main>
    <!--　メインここまで　-->
    <!--　フッター　-->
	<%@ include file="footer.jsp" %>
    <!--　フッターここまで　-->
</body>
</html>