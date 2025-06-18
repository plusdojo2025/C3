<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>労働時間計算</title>
    <%-- <link rel="stylesheet" href="<c:url value='/css/style.css' />"> --%>
</head>
<body>
    <!-- ヘッダー -->
    <header>
        <%@ include file="header.jsp" %>
    </header>

    <!-- メイン -->
    <main>
        <h2>1週間の労働時間と手取り計算</h2>
        <form method="POST" action="<c:url value='/IncomeResultMakan' />">
            <table>
                <tr>
                    <td>目標年収を入力</td>
                    <td><input type="text" name="gIncome"></td>
                </tr>
                <tr>
                    <td>時給を入力</td>
                    <td><input type="text" name="hWage"></td>
                </tr>
                <tr>
                    <td>1週間の希望労働日数を入力</td>
                    <td><input type="text" name="wWork"></td>
                </tr>
                <tr>
                    <td>扶養しているか</td>
                    <td>
                        <label><input type="radio" name="dependent" value="YES"> はい</label>
                        <label><input type="radio" name="dependent" value="NO"> いいえ</label>
                    </td>
                </tr>
                <tr>
                
                
                <tr>  
                    <td><input type="hidden" name="U_id" value=${userInf.id}></td>
                </tr>
                
                
                
                    <td colspan="2">
                        <input type="submit" name="submit" value="決定">
                    </td>
                </tr>
            </table>
        </form>
    </main>

    <!-- フッター -->
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</body>
</html>