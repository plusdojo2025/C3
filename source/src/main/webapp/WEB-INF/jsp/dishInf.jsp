<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事選択</title>
  <style>
    body {
      font-family: 'Yu Gothic', sans-serif;
      background-color: #fdfaf6;
      text-align: center;
      padding: 20px;
    }

    .meal-box {
      background-color: #fff8f4;
      border: 2px solid #ffd9d9;
      border-radius: 15px;
      box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
      width: 80%;
      max-width: 600px;
      margin: 20px auto;
      padding: 20px;
    }

    .meal-box h2 {
      margin-top: 0;
      color: #ff6f91;
    }

    details {
      text-align: left;
      margin-bottom: 10px;
    }

    summary {
      font-weight: bold;
      cursor: pointer;
      font-size: 16px;
      color: #444;
    }

    .scroll-box {
      max-height: 180px;
      overflow-y: auto;
      border: 1px dashed #ddd;
      padding: 8px;
      background-color: #fff;
      border-radius: 8px;
    }

    input[type="submit"] {
      margin-top: 20px;
      padding: 10px 30px;
      background-color: #ffb6b9;
      border: none;
      border-radius: 25px;
      color: white;
      font-weight: bold;
      cursor: pointer;
    }

    .total-cal {
      margin-top: 10px;
      font-weight: bold;
      color: #e86f6f;
    }
  </style>
<link rel="stylesheet" href="<c:url value='/css/css_madoka.css' />">
</head>

<body>

<!-- ヘッターここから -->
<%@ include file="header.jsp" %>
<!-- ヘッターここまで -->

<p>食事内容をチェックしましょう</p>
<p>＊各項目１つのみ選択してください</p>
	
<form method="POST" action="/c3/DishInfMakan">
 <!-- ======= 朝 ======= -->
<div class="meal-box">
  <h2>朝食</h2>

  <details><summary>主食</summary>
    <div class="scroll-box">
      <c:forEach var="b" items="${emp}">
        <label><input type="radio" name="mStaple" value="${b.id}" data-calorie="${b.calorie}" checked>
        ${b.name}（${b.calorie} kcal）</label><br>
      </c:forEach>
    </div>
  </details>

  <details><summary>主菜</summary>
    <div class="scroll-box">
      <c:forEach var="b" items="${emp2}">
        <label><input type="radio" name="mMain" value="${b.id}" data-calorie="${b.calorie}" checked>
        ${b.name}（${b.calorie} kcal）</label><br>
      </c:forEach>
    </div>
  </details>

  <details><summary>副菜</summary>
    <div class="scroll-box">
      <c:forEach var="b" items="${emp3}">
        <label><input type="radio" name="mSide" value="${b.id}" data-calorie="${b.calorie}" checked>
        ${b.name}（${b.calorie} kcal）</label><br>
      </c:forEach>
    </div>
  </details>

  <details><summary>その他</summary>
    <div class="scroll-box">
      <c:forEach var="b" items="${emp4}">
        <label><input type="radio" name="mOther" value="${b.id}" data-calorie="${b.calorie}" checked>
        ${b.name}（${b.calorie} kcal）</label><br>
      </c:forEach>
    </div>
  </details>
  <div class="total-cal">合計: <span id="mTotal">0 kcal</span></div>
</div>

<!-- ======= 昼 ======= -->
<p>昼食</p>

<details><summary>主食</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp}">
      <label><input type="radio" name="nStaple" value="${b.id}" checked>
      ${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>主菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp2}">
      <label><input type="radio" name="nMain" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>副菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp3}">
      <label><input type="radio" name="nSide" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>その他</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp4}">
      <label><input type="radio" name="nOther" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<!-- ======= 晩 ======= -->
<p>夕食</p>

<details><summary>主食</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp}">
      <label><input type="radio" name="eStaple" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>主菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp2}">
      <label><input type="radio" name="eMain" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>副菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp3}">
      <label><input type="radio" name="eSide" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>その他</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp4}">
      <label><input type="radio" name="eOther" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<!-- ======= 間食 ======= -->
<p>間食</p>

<details><summary>その他</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp4}">
      <label><input type="radio" name="snack" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<!-- ======= 送信ボタン ======= -->
<p><input type="submit" id="save" name="submit" value="保存"></p>

</form>

<p>朝 合計カロリー: <span id="mTotal">0 kcal</span></p>
<p>昼 合計カロリー: <span id="nTotal">0 kcal</span></p>
<p>晩 合計カロリー: <span id="eTotal">0 kcal</span></p>
<p>間食: <span id="snackTotal">0 kcal</span></p>


<!-- フッター -->
 <%@ include file="footer.jsp" %>


</body>
</html>
