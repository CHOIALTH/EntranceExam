<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>회원 관리</title>
        <script src="emplsManage.js"></script>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>여기는 직원 관리 페이지</h1>
        <%-- 회원 리스트--%>
        <h2> 현재 직원 리스트</h2>
        <table>
            <tr>
                <th>사번</th>
                <th>이름</th>
                <th>부서명</th>
                <th>직급</th>
                <th>연락처</th>
                <th>이메일</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <form action="employees/update">
                        <td><input type="text" value="${employee.id}" disabled></td>
                        <td><input type="text" value="${employee.name}"></td>
                        <td><input type="text" value="${employee.department}"></td>
                        <td><input type="text" value="${employee.position}"></td>
                        <td><input type="text" value="${employee.phone}"></td>
                        <td><input type="text" value="${employee.email}"></td>
                        <td><input type="submit" value="수정">
                    </form>
                    <form action="/employees/delete" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="submit" value="삭제">
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
     </body>
</html>