<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"></nav>

<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edytowanie użytkownika</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-address-book fa-sm text-white-50"></i> Lista Użytkowników</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Edytuj użytkownika</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form method="post" action="/user/edit">
                    <div class="form-group">
                        <label for="username">New Username: </label>
                        <input type="text" name="username" class="form-control" id="username">
                    </div>
                    <div class="form-group">
                        <label for="email">New Email: </label>
                        <input type="text" name="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="password">New Password: </label>
                        <input type="text" name="password" class="form-control" id="password">
                    </div>

                    <button type = "submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>