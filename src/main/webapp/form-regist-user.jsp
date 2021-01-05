
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.homework.model.DB"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="com.homework.model.Homework"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration Form</title>
        <%@include file="WEB-INF/view/style.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/view/header.jspf" %>
    <form action="nuevo-usuario" method="post">
            <div class="row">
                <div class="col"> 
                    <label for='user'> User:  </label>
                    <input type='text' class="form-control" id='user' name="user" placeholder="${requestScope.messageUser}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='name'> Name:  </label>
                    <input type='text' class="form-control" id='name' name="name" placeholder="${requestScope.messageName}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='lastname'> Lastname:  </label>
                    <input type='text' class="form-control" id='lastname' name="lastname" placeholder="${requestScope.messageLastname}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='email'> Email:  </label>
                    <input type='text' class="form-control" id='email' name="email" placeholder="${requestScope.messageEmail}"/> </br>
                </div>
                          </div>
            <div class="row">
                <div class="col"> 
                    <label for='Password'> Password:  </label>
                    <input type='text' class="form-control" id='password' name="password" placeholder="${requestScope.messagePassword}"/> </br>
                </div>
            </div>
            <button type='submit' class="btn btn-primary"> Add User </button>
            <button class="btn btn-primary" type="button">
            <span class="icon icon-thumbs-up"></span>
            Home
            </button>
        </form>
                
    </body>
</html>