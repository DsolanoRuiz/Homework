

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
        <title>Homework List</title>
        <%@include file="WEB-INF/view/style.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/view/header.jspf" %>
        <div class="container">
            <h1>Homework List ${sessionScope.user.nameeUser}</h1> 
            <br>
            <hr/>
            <%
                String user = (String) request.getAttribute("user");
                Collection<Homework> homeworkToDo = DB.getHomeworkToDoUser(user);
                Collection<Homework> homeworkInProgress = DB.getHomeworkInProgressUser(user);
                Collection<Homework> homeworkDone = DB.getHomeworkDoneUser(user);
            %>
            <div class="row">
                <div class="col">
                    <h3> To_Do List</h3> 

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Description</th>
                                <th scope="col">ChangeStatus</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% for (Homework h : homeworkToDo) {%>
                            <tr>
                                <th scope="row"><%= h.getId()%></th>
                                <td><%= h.getDescription()%></td>
                                <td><a href="HomeworkServlet?id=<%= h.getId()%>&user=<%=user%>&changeStatus" > --> </a> </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                </div>
                <div class="col">
                    <h3>In_Progress List </h3> 
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Description</th>
                                <th scope="col">ChangeStatus</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% for (Homework h : homeworkInProgress) {%>
                            <tr>
                                <th scope="row"><%= h.getId()%></th>
                                <td><%= h.getDescription()%></td>
                                <td> <a href="HomeworkServlet?id=<%= h.getId()%>&user=<%=user%>&changeStatus=In_Progress">  <--  </a>
                                    <a href="cambiar-estado?id=<%= h.getId()%>&user=<%=user%>&changeStatus=Done">  -->  </a> </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>

                <div class="col">

                    <h3>Done List</h3> 

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Description</th>
                                <th scope="col">Change Status</th>
                            </tr>
                        </thead>
                        <tbody>

                           <% for (Homework h : homeworkInProgress) {%>
                            <tr>
                                <th scope="row"><%= h.getId()%></th>
                                <td><%= h.getDescription()%></td>
                                <td><a href="HomeworkServlet?id=<%= h.getId()%>&user=<%=user%>&changeStatus= Done">  <--  </a> </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                </div>

                <hr />

                <hr />

            </div>
        </div>

    </div>

</body>

<footer>
</footer>

</html>