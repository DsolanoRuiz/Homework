
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="WEB-INF/view/style.jspf" %>
    </head>
    <body>
        <div class="container">
            <%@include file="WEB-INF/view/header.jspf" %>
          
            <div class="row">
                <div class="col">
                    <h1>Enter your access data</h1>
                </div>
            </div>
            <form action="login" method="post" >
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" name="email"
                           id="email" placeholder="Enter email">
                     <div class="col">${requestScope.msgErrorEmail}</div>
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" name="pwd"
                           id="pwd" placeholder="Password">
                     <div class="col">${requestScope.msgErrorPwd}</div>
                </div>
                <div class="container">
                    <a href="form-regist-user.jsp"class="btn btn-primary">Registration</a>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
                <c:if test="${not empty requestScope.msgErrorLogin }" >
                <div class="alert alert-success" role="alert">
                    ${requestScope.msgErrorLogin}
                </div>
            </c:if>
        </div>
    </body>
</html>