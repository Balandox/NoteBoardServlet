<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2022
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Регистрация нового пользователя</title>
  <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
  <h1 class="header_name">Доска объявлений</h1>
</div>

<div class="newPerson">

  <form action="/login" method="POST">

    <div class="newPerson_field">Введите имя пользователя: <input type = "text" name = "userName"/></div>
    <div class="newPerson_field">Введите пароль: <input type = "text" name = "password"/></div>
    <div class="newPerson_field"><input type = "submit" value = "Войти" /></div>

  </form>
</div>

</body>
</html>
