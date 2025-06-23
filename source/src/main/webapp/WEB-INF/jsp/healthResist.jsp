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
 <!--  <div class="form">       
  <form method="POST" action="<c:url value='HealthResistMakan' />">
    <table>
        <tr>
            <td> 
	            <p class="Form-Item-Label">
		      			<span class="Form-Item-Label-Required">必須</span>目標体重
		    	</p>               
            </td>
            <td>
            <div class="Form-Item">
	            
                <input type="number" name="iWeight"><br>
            </div>
            </td>
            
        </tr>
        <tr>
             <td> 
                現在体重
            </td>
            <td>
                <input type="number" name="cWeight"><br>
            </td>
        </tr>
        <tr>
            <td> 
                身長
            </td>
            <td>
                <input type="number" name="height"><br>
            </td>
        </tr>
        <tr>
            <td> 
                年齢
            </td>
            <td>
                <input type="number" name="age"><br>
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
                <input type="number" name="term"><br>
            </td>
        </tr>
        <tr>
            <td> 
               <p class="Form-Item-Label">
		      			<span class="Form-Item-Label-Required">必須</span>1週間の運動日数
		    	</p>
            </td>
            <td>
                <input type="number" name="wMotionDays"><br>
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
 </div> 
 -->
<form method="POST" action="<c:url value='HealthResistMakan' />"> 
   <div class="Form">
  <div class="Form-Item">
    <p class="Form-Item-Label">
      <span class="Form-Item-Label-Required">必須</span>目指す体重
    </p>
    <input type="number" name="iWeight" class="Form-Item-Input" placeholder="単位：kg"><br>
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
  <div style="text-align:center;" class="Form-Item">                  
      <input type="submit" name="submit" class="kadomarutake" value="決定">  
  </div>
</div>
</form>
</main>
    <!--　メインここまで　-->
    <!--　フッター　-->
	<%@ include file="footer.jsp" %>
    <!--　フッターここまで　-->
</body>
</html>