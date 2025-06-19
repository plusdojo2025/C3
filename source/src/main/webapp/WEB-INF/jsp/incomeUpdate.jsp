<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>労働時間計算（更新）</title>
    <link rel="stylesheet" href="<c:url value='' />">

</head>
<body>
    <!--　ヘッダー　-->
    <header>
        <%@ include file="header.jsp" %>
    </header>
    <!--　ヘッダーここまで　-->
    <!--　メイン　-->
    <main>
        <h2>1週間の労働時間と手取り計算</h2>
  <form method="POST" action="<c:url value='/IncomeResultMakan' />">
    <table>
        <tr>
            <label>
                <td> 
                    目標年収を入力
                </td>
                <td>
                    <input type="text" name="gIncome"><br>
                </td>
            </label>
        </tr>
        <tr>
            <label>
                <td> 
                    時給を入力
                </td>
                <td>
                    <input type="text" name="hWage"><br>
                </td>
            </label>
        </tr>
        <tr>
            <label>
                <td> 
                    １週間の希望労働日数を入力
                </td>
                <td>
                    <input type="text" name="wWork"><br>
                </td>
            </label>
        </tr>
        <tr>
            <label>
                <td> 
                    扶養しているか
                </td>
<tr>
            <td>
                <label><input type="radio" name="huyou" value="YES">はい</label>
                <label><input type="radio" name="huyou" value="NO">いいえ</label><br>
            </td>
        </tr>
            </label>    
        
            <tr>  
                  <td><input type="hidden" name="U_id" value="${userInf.id}"></td>
                  <td><c:out value="${userInf.id}" /></td>
            </tr>     
                       
        <tr>
            <td>
               <input type="submit" name="submit" value="更新">
            </td>
        </tr>
    </table>
  </form>
    </main>
    <!--　メインここまで　-->
    <!--　フッター　-->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
    <!--　フッターここまで　-->
</body>
</html>