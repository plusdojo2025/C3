<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>労働時間計算（登録）</title>
    <%-- <link rel="stylesheet" href="<c:url value='/css/style.css' />"> --%>
    <link rel="stylesheet" href="<c:url value='/css/css_takehiro.css' />">
</head>
<body>
    <!-- ヘッダー -->
    <header>
        <%@ include file="header.jsp" %>
    </header>

    <!-- メイン -->
    <main>
        <h2 class="midashi">1週間の労働時間と手取り計算</h2>
        <form method="POST" action="<c:url value="/IncomeResultMakan" />">
            <table>
                <tr>
                    <th class="left">目標年収を入力（万円）</th>
                    <td><input type="number" name="gIncome" min="0" max="1000"></td>
                </tr>
                <tr>
                    <th class="left">時給を入力（円）</th>
                    <td><input type="number" name="hWage" min="0"></td>
                </tr>
                <tr>
                    <th class="left">1週間の希望労働日数を入力（日）</th>
                    <td><input type="number" name="wWork" min="0" max="7"></td>
                </tr>
                <tr>
                    <th class="left">扶養しているか</th>
                    <td>
                        <label><input type="radio" name="dependent" value="YES"> はい</label>
                        <label><input type="radio" name="dependent" value="NO"> いいえ</label>
                    </td>
                </tr>
                
                
                <tr>  
                    <td><input type="hidden" name="U_id" value="${userInf.id}"></td>
                
                </tr>
                             
                 </table>
                    
                    <div style="text-align:center;">
                        <input type="submit" class="kadomaru" name="submit" value="決定">
                    </div>                  
        </form>
    </main>

    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>