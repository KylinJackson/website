<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>管理员档案</title>
</head>
<body>
<%@ include file="head.jsp" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                管理员档案
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        登录名
                    </th>
                    <th>
                        姓名
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        电话
                    </th>
                    <th>
                        邮箱
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ManageList}" var="manager">
                    <tr>
                        <td>
                                ${manager.manageId}
                        </td>
                        <td>
                                ${manager.manageName}
                        </td>
                        <td>
                                ${manager.manageSex}
                        </td>
                        <td>
                                ${manager.manageTel}
                        </td>
                        <td>
                                ${manager.manageEmail}
                        </td>
                        <td>
                            <c:if test="${manager.manageId==manageid}">
                                <a href="/servlet/ManagerServlet?flag=search&manageId=${manageid}">
                                    修改个人信息</a></c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>