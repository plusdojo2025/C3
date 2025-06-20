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
  <form method="POST" action="<c:url value='HealthResistMakan' />">
    <table>
        <tr>
            <td> 
                目標体重
            </td>
            <td>
                <input type="text" name="iWeight"><br>
            </td>
        </tr>
        <tr>
             <td> 
                現在体重
            </td>
            <td>
                <input type="text" name="cWeight"><br>
            </td>
        </tr>
        <tr>
            <td> 
                身長
            </td>
            <td>
                <input type="text" name="height"><br>
            </td>
        </tr>
        <tr>
            <td> 
                年齢
            </td>
            <td>
                <input type="text" name="age"><br>
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
                <input type="text" name="term"><br>
            </td>
        </tr>
        <tr>
            <td> 
                一週間の運動日数
            </td>
            <td>
                <input type="text" name="wMotionDays"><br>
            </td>
        </tr>
        
        <tr>  
            <td><input type="hidden" name="U_id" value="${userInf.id}"></td>
       </tr>
       <tr>
       </table>   
       <div style="text-align:center;">                  
                <input type="submit" name="submit" class="kadomaru" value="決定">  
       </div>                 
  </form>
 </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
	<%@ include file="footer.jsp" %>
    <!--　フッターここまで　-->
</body>
</html>