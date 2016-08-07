<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/> ">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Users List</b></div>
                <div align="right"><a href="addUser">Add New User</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty userList}">
                There are no Users in Database
            </c:if>
            <c:if test="${not empty userList}">

                <form action="searchUser">
                    <div class="row">
                        <div class="col-md-4">Search User: <input type='text' name='searchName' id='searchName'/></div>
                        <div class="col-md-1"><input class="btn btn-success" type='submit' value='Search'/></div>
                        <div class="col-md-1"><label class="label label-info">Type 'all' to see all Users </label></div>
                    </div>
                </form>

                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>isAdmin</th>
                        <th>Created date</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <th><c:out value="${user.id}"/></th>
                            <th><c:out value="${user.name}"/></th>
                            <th><c:out value="${user.age}"/></th>
                            <th><c:out value="${user.admin}"/></th>
                            <th><spring:eval expression="user.createdDate"/></th>
                            <th>
                                <a href="/editUser?id=<c:out value='${user.id}'/>&page=<c:out value="${currentPage}"/>">
                                    Edit
                                </a>
                            </th>
                            <th>
                                <a href="/deleteUser?id=<c:out value='${user.id}'/>&page=<c:out value="${currentPage}"/>">
                                    Delete
                                </a>
                            </th>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <div class="col-md-12 text-center">
                    <div class="pagination pagination-centered">
                        <div class="btn-group inline "><c:forEach var="p" begin="${startPage}" end="${endPage}"
                                                                  step="1">
                            <a href="<c:url value="/searchUser" >
                              <c:param name="searchName" value="${searchName}"/>
                              <c:param name="page" value="${p - 1}"/></c:url>"
                               style="text-decoration:none">
                                <div class="btn btn-mini">${p}</div>
                            </a>
                        </c:forEach></div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
