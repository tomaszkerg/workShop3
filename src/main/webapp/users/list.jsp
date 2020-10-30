<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<!-- Main Content -->
<div id="content">

    <!-- Topbar -->
    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"></nav>
    <!-- End of Topbar -->

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-address-book fa-sm text-white-50"></i> Dodaj Użytkownika</a>
        </div>
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista Użytkowników</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.getId()}</td>
                                <td>${user.getUserName()}</td>
                                <td>${user.getEmail()}</td>
                                <td>
                                    <a href='<c:url value="/user/show?id=${user.getId()}"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Show</a>
                                    <a href='<c:url value="/user/edit?id=${user.getId()}"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Edit</a>
                                    <a href='<c:url value="/user/remove?id=${user.getId()}"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<jsp:include page="footer.jsp"/>