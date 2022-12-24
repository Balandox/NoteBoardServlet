<%@ page import="org.suai.laba14.model.Note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Доска объявлений</title>

    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div class="header">
        <h1 class="header_name">Доска объявлений</h1>
        <%
            if(request.getAttribute("userName") != null){
                String userName = request.getAttribute("userName").toString();
        %>
        <p class="header_link" style="color: red; text-decoration: underline; margin-top: 0;"><%=userName%></p>
        <a class="header_link" href="/board/newNote">Добавить объявление</a>
        <a class="header_link" href="/logout">Выйти</a>
        <%
            } else {
        %>
        <a class="header_link" href = "/login">Войти</a>
        <%
            }
        %>
    </div>

    <div id="note_list">

        <c:forEach items="${noteList}" var="note">
            <div id="note">
                <p><i>Пользователь: </i>${note.getOwner().getUserName()}</p>
                <p><i>Дата создания: </i>${note.getCreationTime()}</p>
                <pre><i>Текст объявления: </i><br/>${note.getText()}</pre>
            </div>
        </c:forEach>

    </div>

</body>
</html>
