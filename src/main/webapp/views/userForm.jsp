<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Segiy
  Date: 02.08.2016
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User form</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/> ">
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
                User form
            </h3>
        </div>
        <div class="panel-body">
            <form:form cssClass="form-horizontal" modelAttribute="user"  method="post"
                       action="saveUser">

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="name">Name</form:label></div>
                    <div class="col-xs-6">
                        <form:hidden path="page" value="${page}"/>
                        <form:hidden path="id" value="${userObject.id}"/>
                        <form:hidden path="createdDate" value="${userObject.createdDate}"/>
                        <form:input cssClass="form-control" path="name" value="${userObject.name}"/>
                        <form:errors path="name" cssStyle="color: #a94442" />
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="age" cssClass="control-label col-xs-3">Age</form:label>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="age" value="${userObject.age}"/>
                        <form:errors path="age" cssStyle="color: #a94442"/>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="admin" cssClass="control-label col-xs-3">isAdmin</form:label>
                    <div class="col-xs-6">
                            <form:label path="admin" cssClass="radio-inline">
                                <form:radiobutton path="admin" value="true"/> True
                            </form:label>

                            <form:label path="admin" cssClass="radio-inline">
                                <form:radiobutton path="admin" value="false"/> False
                            </form:label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-4">
                        </div>
                        <div class="col-xs-4">
                            <input type="submit" class="btn btn-primary" value="Save"/>
                        </div>
                        <div class="col-xs-4">
                        </div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>
