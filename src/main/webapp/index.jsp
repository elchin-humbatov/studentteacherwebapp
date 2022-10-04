<%@ page import="entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Elchin Humbatov
  Date: 9/25/2022
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Teachers</title>
    <link rel="stylesheet" href="style.css">
    <script src="app.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Dashboard</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Teachers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Students</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<h1>Teachers</h1>
<form id="form" class="col-3 m-lg-3">
    <div class="mb-3">
        <label class="form-label" for="name" >
            name
        </label>
        <input class="form-control" id="name" type="text"/>
    </div>
    <div class="mb-3">
        <label class="form-label" for="surname" >
            surname
        </label>
        <input class="form-control" id="surname" type="text"/>
    </div>
    <div class="mb-3">
        <label class="form-label" for="salary" >
            salary
        </label>
        <input class="form-control" id="salary" type="text"/>
        <br>
        <button class="btn btn-primary">SEARCH</button>
    </div>
</form>
<br/>
<br/>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>salary</th>
            <th>university</th>
            <th>actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            final List<Teacher> list = (List<Teacher>) request.getAttribute("teachers");

            for (Teacher teacher : list) {
        %>
        <tr>
            <td>
                <%=teacher.getName() %>
            </td>
            <td>
                <%=teacher.getSurname()%>
            </td>
            <td>
                <%=teacher.getSalary() %>
            </td>
            <td>
                <%=teacher.getUniversity().getId() %>
            </td>
            <td>
                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">delete</button>
            </td>
            <td>
                <a href ="update.jsp?<%="id="+teacher.getId()%>">
                    <button class="btn btn-warning">update</button>
                </a>

            </td>
        </tr>
       <% } %>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure to delete?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

