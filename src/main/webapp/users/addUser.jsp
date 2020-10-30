<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"></nav>

<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Dodawanie użytkownika</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-address-book fa-sm text-white-50"></i> Lista Użytkowników</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <h3><c:out value="${error}"/></h3>
                <form method="post" action="/user/add">
                    <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" name="username" class="form-control" id="username">
                    </div>
                    <div class="form-group">
                    <label for="email">Email: </label>
                    <input type="email" name="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" name="password" class="form-control" id="password">
                    </div>

                    <button type = "submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>