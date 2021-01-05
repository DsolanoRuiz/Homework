<%@page import="com.homework.model.DB"%>
<%@page import="com.homework.model.User"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </><%@include file="WEB-INF/view/style.jspf" %>
    </head>
    <body>
        </><%@include file="WEB-INF/view/header.jspf" %>
        </><%@include file="WEB-INF/view/navegation.jspf" %>
        <h1>User List </h1>

        <%Collection<User>users=DB.getUser();
            request.setAttribute("UserList", users);
        %>

        <div>
            <table class="table" >
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="users" items="${requestScope.userlist}" >
                        <tr>
                            <th scope="row">${users.nameLastname}</th>
                            <td>${users.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>