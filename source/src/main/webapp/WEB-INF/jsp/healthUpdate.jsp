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
  <form method="POST" action="<c:url value='HealthResistMakan'/>">
    <table>
        <tr>
            <td> 
                目標体重
            </td>
            <td>
                <input type="number" name="iWeight" value="${h.iWeight }" ><br>
            </td>
        </tr>
        <tr>
             <td> 
                現在体重
            </td>
            <td>
                <input type="number" name="cWeight" value="${h.cWeight }"><br>
            </td>
        </tr>
        <tr>
            <td> 
                身長
            </td>
            <td>
                <input type="number" name="height" value="${h. height}"><br>
            </td>
        </tr>
        <tr>
            <td> 
                年齢
            </td>
            <td>
                <input type="number" name="age" value="${h.age }"><br>
            </td>
        </tr>
        <tr>
            <td> 
                性別
            </td>
            <td>    
                <label><input type="radio" name="gender" value="M">男性</label>
                <label><input type="radio" name="gender" value="F">女性</label><br>
            </td>
        </tr>
        <tr>
            <td> 
                期間
            </td>
            <td>
                <input type="number" name="term" value="${h.term }"><br>
            </td>
        </tr>
        <tr>
            <td> 
                一週間の運動日数
            </td>
            <td>
                <input type="number" name="wMotionDays" value="${h.wMotionDays }"><br>
            </td>
        </tr>
        <tr>  
            <td><input type="hidden" name="U_id" value="${userInf.id}"></td>
       </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="更新">
            </td>
        </tr>
    </table>
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
