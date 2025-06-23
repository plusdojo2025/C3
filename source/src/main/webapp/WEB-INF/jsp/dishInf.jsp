<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事選択</title>
<link rel="stylesheet" href="<c:url value='/css/css_madoka.css' />">
</head>

<body>


<script >
function calculateCalories() {
	  const sections = ['m', 'n', 'e', 'snack'];
	  sections.forEach(prefix => {
	    let total = 0;

	    // それぞれの選択肢（主食・主菜・副菜・その他）を取得
	    ['Staple', 'Main', 'Side', 'Other'].forEach(type => {
	      const selected = document.querySelector(`input[name="${prefix}${type}"]:checked`);
	      if (selected && selected.dataset.calorie) {
	        total += parseInt(selected.dataset.calorie);
	      }
	    });

	    // 間食（snack）は prefix = 'snack' で nameも 'snack'
	    if (prefix === 'snack') {
	      const snack = document.querySelector(`input[name="snack"]:checked`);
	      if (snack && snack.dataset.calorie) {
	        total = parseInt(snack.dataset.calorie);
	      }
	    }

	    // 表示更新
	    const target = document.getElementById(`${prefix}Total`);
	    if (target) target.textContent = total + ' kcal';
	  });
	}

	// ページロード時にも一度計算
	window.addEventListener('DOMContentLoaded', () => {
	  calculateCalories();
	  document.querySelectorAll('input[type="radio"]').forEach(input => {
	    input.addEventListener('change', calculateCalories);
	  });
	});
	</script>
	
<!-- ヘッターここから -->
<%@ include file="header.jsp" %>
<!-- ヘッターここまで -->

<p>食事内容をチェックしましょう</p>
<p>＊各項目１つのみ選択してください</p>
	
<form method="POST" action="/c3/DishInfMakan">
 <!-- ======= 朝 ======= -->
<p>朝</p>

<details><summary>主食</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp}">
      <label><input type="radio" name="mStaple" value="${b.id}" checked data-calorie="${b.calorie}">${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>主菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp2}">
      <label><input type="radio" name="mMain" value="${b.id}" checked data-calorie="${b.calorie}">${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>副菜</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp3}">
      <label><input type="radio" name="mSide" value="${b.id}" checked data-calorie="${b.calorie}">${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<details><summary>その他</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp4}">
      <label><input type="radio" name="mOther" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
    </c:forEach>
  </div>
</details>

<!-- ======= 昼 ======= -->
<p>昼</p>

<details><summary>主食</summary>
  <div class="scroll-box">
    <c:forEach var="b" items="${emp}">
      <label><input type="radio" name="nStaple" value="${b.id}" checked>${b.name}（${b.calorie} kcal）</label><br>
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
<p>晩</p>

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
