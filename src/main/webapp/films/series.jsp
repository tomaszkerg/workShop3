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
            <a href="<c:url value="/series/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-address-book fa-sm text-white-50"></i> Dodaj Serial</a>
        </div>
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista Serialów</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>LastEp</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>LastEp</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach items="${series}" var="serie">
                            <tr>
                                <td>${serie.getId()}</td>
                                <td>${serie.getTitle()}</td>
                                <td>${serie.getType()}</td>
                                <td>${serie.getDescription()}</td>
                                <td>${serie.getLastEp()}</td>
                                <td>
                                    <a href='<c:url value="/series/edit?id=${serie.getId()}"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Edit</a>
                                    <a href='<c:url value="/series/remove?id=${serie.getId()}"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Remove</a>
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