<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>직원 등록</title>
        <script src="addEmployee.js"></script>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>여기는 직원 등록 페이지</h1>
        <form id="addEmplForm" action="/employees/add" method="post" onsubmit="return validateForm();">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>
            <br>
            <label for="department">부서명</label>
            <input type="text" id="department" name="department" required>
            <br>
            <label for="position">직급명</label>
            <input type="text" id="position" name="position" required>
            <br>
            <label for="phone">연락처</label>
            <input type="text" id="phone" name="phone" required>
            <br>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" required>
            <br>
            <input type="submit" value="직원 등록">
        </form>

    </body>
</html>