<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Account data changing page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="row justify-content-sm-center">
        <div class="col-9">
            <form method="post" action="${pageContext.request.contextPath}/account/register"
                  enctype="multipart/form-data">
                <div class="container">
                    <div class="form-group row">
                        <label for="login">Login</label>
                        <input type="text" name="login" class="form-control" id="login" required>
                    </div>
                    <div class="form-group row">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password"
                               name="pass" required>
                    </div>
                    <div class="form-group row">
                        <label for="email">Email</label>
                        <input type="email" name="email" class="form-control" id="email" required>
                    </div>
                    <div class="form-group row">
                        <label for="name">Name</label>
                        <input id="name" class="form-control" type="text" name="name" required>
                    </div>
                    <div class="form-group row">
                        <label for="lastName">Lastname</label>
                        <input id="lastName" class="form-control" type="text" name="lastName" required>
                    </div>
                    <div class="form-group row">
                        <label for="patronymic">Patronymic</label>
                        <input id="patronymic" class="form-control" type="text" name="patronymic">
                    </div>
                    <button type="submit">Submit</button>
                    <c:if test="${pageContext.request.getAttribute('exception')}">
                        <p>Something went wrong, try again later</p>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>




