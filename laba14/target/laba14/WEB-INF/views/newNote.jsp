<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2022
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавить новое объявление</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="header">
    <h1 class="header_name">Доска объявлений</h1>
    <p class="header_link" style="color: red; text-decoration: underline; margin-top: 0;">${userName}</p>
    <a class="header_link" href="/board/newNote">Добавить объявление</a>
    <a class="header_link" href="/logout">Выйти</a>
</div>

<div style="text-align: center">
    <form action="/board" method="POST">

    <div class="newNote_field">Введите текст объявления: <input id="newNote" lang="ru" type = "text" name = "noteText"/></div>
    <div class="newPerson_field"><input type = "submit" value = "Добавить" /></div>
</form>

</div>

</body>
</html>
