<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事選択</title>

<!-- CSSここから -->
<style>

/* 全体 */
body {
  font-family: 'Yu Gothic', sans-serif;
  background-color: #fdfaf6;
  padding: 20px;
}

.setsumei {
  text-align: center;
}

/* 食事内容全体 */
.meal-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  max-width: 1200px;
  margin: 0 auto;
}

/* 食事ボックス */
.meal-box {
  width: 48%;  /* 横に2個並ぶように調整 */
  padding: 15px;
  border-radius: 15px;
  box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
  box-sizing: border-box;
  background-color: white; /* デフォルト背景（上書き用） */
  border: 2px solid #ccc;
}

.meal-box h2 {
  margin-top: 0;
  color: black;  /* 黒文字に変更 */
  text-align: center;
}

.meal-box.yellow {
  background-color: #fff8cc; /* 淡い黄色 */
}

.meal-box.blue {
  background-color: #e0f4ff; /* 淡い水色 */
}

/* プルダウン内のスクロール枠 */
.scroll-box {
  max-height: 150px;
  overflow-y: auto;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: white;
  margin-bottom: 10px;
}

details summary {
  font-weight: bold;
  cursor: pointer;
  margin: 8px 0;
}

.total-cal {
  margin-top: 10px;
  font-weight: bold;
  text-align: right;
}

/*送信ボタン*/
.kadomaru {
  text-align: center;
  color: white;
  background-color: #B5ACA1;
  border-radius: 10px;
  width: 128px;
 
  width: auto; /* 必要なら明示的に */
  font-size: 14px;
  max-width: 160px; /* 必要なら最大幅を指定 */
  text-decoration: none;
  font-weight: bold;
  display: inline-block;
}
 
</style>

<link rel="stylesheet" href="<c:url value='/css/css_madoka.css' />">
</head>

<body>

<!-- ヘッターここから -->
<header>
<%@ include file="header.jsp" %>
</header>
<!-- ヘッターここまで -->

<p class=setsumei>食事内容をチェックしましょう<br>
＊各項目１つのみ選択してください</p>
	

<form method="POST" action="/c3/DishInfMakan">
 <div class="meal-container">
  <!-- 上段：朝と昼 -->
  <div class="meal-box yellow">
    <h2>朝食</h2>
      <details><summary>主食</summary>
  		<div class="scroll-box">
    		<c:forEach var="b" items="${emp}" varStatus="status">
      		<label><input type="radio" name="mStaple" value="${b.id}" data-calorie="${b.calorie}"
          	<c:if test="${status.first}">checked</c:if>>
        	${b.name}（${b.calorie} kcal）</label><br>
    		</c:forEach>
  		</div>
  		</details>
      <details><summary>主菜</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp2}" varStatus="status">
            <label><input type="radio" name="mMain" value="${b.id}" data-calorie="${b.calorie}"
             <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <details><summary>副菜</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp3}" varStatus="status">
            <label><input type="radio" name="mSide" value="${b.id}" data-calorie="${b.calorie}"
              <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <details><summary>その他</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp4}" varStatus="status">
            <label><input type="radio" name="mOther" value="${b.id}" data-calorie="${b.calorie}"
              <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <div class="total-cal">合計: <span id="mTotal">0 kcal</span></div>
    </div>

  <div class="meal-box blue">
    <h2>昼食</h2>
      <details><summary>主食</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp}" varStatus="status">
            <label><input type="radio" name="nStaple" value="${b.id}" data-calorie="${b.calorie}"
              <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <details><summary>主菜</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp2}" varStatus="status">
            <label><input type="radio" name="nMain" value="${b.id}" data-calorie="${b.calorie}"
              <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <details><summary>副菜</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp3}" varStatus="status">
            <label><input type="radio" name="nSide" value="${b.id}" data-calorie="${b.calorie}"
              <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <details><summary>その他</summary>
        <div class="scroll-box">
          <c:forEach var="b" items="${emp4}" varStatus="status">
            <label><input type="radio" name="nOther" value="${b.id}" data-calorie="${b.calorie}"
               <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
          </c:forEach>
        </div>
      </details>
      <div class="total-cal">合計: <span id="nTotal">0 kcal</span></div>
    </div>

  <!-- 下段：夜と間食 -->
  <div class="meal-box blue">
    <h2>夕食</h2>
	<details><summary>主食</summary>
	  <div class="scroll-box">
	    <c:forEach var="b" items="${emp}" varStatus="status">
	      <label><input type="radio" name="eStaple" value="${b.id}" data-calorie="${b.calorie}"
               <c:if test="${status.first}">checked</c:if>>
               ${b.name}（${b.calorie} kcal）</label><br>
	    </c:forEach>
	  </div>
	</details>
	
	<details><summary>主菜</summary>
	  <div class="scroll-box">
	    <c:forEach var="b" items="${emp2}" varStatus="status">
	      <label><input type="radio" name="eMain" value="${b.id}" data-calorie="${b.calorie}"
               <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
	    </c:forEach>
	  </div>
	</details>
	
	<details><summary>副菜</summary>
	  <div class="scroll-box">
	    <c:forEach var="b" items="${emp3}" varStatus="status">
	      <label><input type="radio" name="eSide" value="${b.id}" data-calorie="${b.calorie}"
               <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
	    </c:forEach>
	  </div>
	</details>
	
	<details><summary>その他</summary>
	  <div class="scroll-box">
	    <c:forEach var="b" items="${emp4}" varStatus="status">
	      <label><input type="radio" name="eOther" value="${b.id}" data-calorie="${b.calorie}"
               <c:if test="${status.first}">checked</c:if>>
              ${b.name}（${b.calorie} kcal）</label><br>
	    </c:forEach>
	  </div>
	</details>
	</div>

  <div class="meal-box yellow">
    <h2>間食</h2>
    <details><summary>その他</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp4}" varStatus="status">
      <label><input type="radio" name="snack" value="${b.id}" data-calorie="${b.calorie}"
       <c:if test="${status.first}">checked</c:if>>
       ${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>
</div>

<!-- ======= 送信ボタン ======= -->
<p><input type="submit" id="save" class="kadomaru" name="submit" value="保存"></p>
</div>
</form>



<!-- フッター -->
 <%@ include file="footer.jsp" %>


</body>
</html>
