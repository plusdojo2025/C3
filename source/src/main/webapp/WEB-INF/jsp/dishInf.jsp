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

<p>主食<br></p>
<c:forEach var="b" items="${emp}">
<tr>
<td><input type="radio" name="dishInf" value="${b.id}" checked>${b.name}</td>
<td>${b.calorie}</td>
</tr>
</c:forEach>

<!-- <form method="POST" action="<c:url value='DishMakan' />">保存</form> -->