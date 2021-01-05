
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
        <title>Homework Registration Form</title>
        <%@include file="WEB-INF/view/style.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/view/header.jspf" %>
    <form action="nuevo-usuario" method="post">
            <div class="row">
                <div class="col">
                    <label for='id'> ID:  </label>
                    <input type='number' class="form-control" id='id' name="id" placeholder="${requestScope.messageId}" /> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='description'> Description:  </label>
                    <input type='text' class="form-control" id='description' name="description" placeholder="${requestScope.messageDescription}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='status'> Status:  </label>
                    <input type='text' class="form-control" id='status' name="status" placeholder="${requestScope.messageStatus}"/> </br>
                </div>
            <button type='submit' class="btn btn-primary"> Add Homework </button>
            <button class="btn btn-primary" type="button">
            <span class="icon icon-thumbs-up"></span>
            Home
            </button>
        </form>
    </body>
</html>