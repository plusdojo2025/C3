<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事選択</title>
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>

<body>
<!-- フッターここから -->
<!-- フッターここまで -->

<p>食事内容をチェックしましょう</p>
<p>＊各項目１つのみ選択してください</p>

<form method="POST" action="/C3/DishInfMakan">
<p>主食<br></p>
<c:forEach var="b" items="${emp}">
<table>

<tr>
	<td><input type="radio" name="mStaple" value="${b.id}" checked>${b.name}</td>
	<td><p>${b.calorie}</p></td>
</tr>
</table>
</c:forEach>

<p>主菜<br></p>
<c:forEach var="b" items="${emp2}">
<table>
<tr>
	<td><input type="radio" name="mMain" value="${b.id}" checked>${b.name}</td>
	<td><p>${b.calorie}</p></td>
</tr>
</table>
</c:forEach>

<p>副菜<br></p>
<c:forEach var="b" items="${emp3}">
<table>
<tr>
	<td><input type="radio" name="mSide" value="${b.id}" checked>${b.name}</td>
	<td><p>${b.calorie}</p></td>
</tr>
</table>
</c:forEach>

<p>その他<br></p>
<c:forEach var="b" items="${emp4}">
<table>
<tr>
	<td><input type="radio" name="mOther" value="${b.id}" checked>${b.name}</td>
	<td><p>${b.calorie}</p></td>
</tr>
</table>
</c:forEach>
<!-- 🔽 JavaScriptで埋め込む日時の隠しフィールド -->
<input type="hidden" id="date" name="date">

<input type="submit" id="save" name="submit" value="保存">
</form>
<script src="script/dish.js"></script>

</body>
