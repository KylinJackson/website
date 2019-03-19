<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>用户管理页面</title>
</head>
<body>
<%@ include file="head.jsp" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                用户管理
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
                        用户名
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
                <c:forEach items="${UserList}" var="user">
                    <tr>
                        <td>
                                ${user.userId}
                        </td>
                        <td>
                                ${user.userName}
                        </td>
                        <td>
                                ${user.userSex}
                        </td>
                        <td>
                                ${user.userTel}
                        </td>
                        <td>
                                ${user.userEmail}
                        </td>
                        <td>
                            <a href="/servlet/UserServlet?flag=search&userId=${user.userId}">修改</a>&nbsp;&nbsp;
                            <c:choose>
                                <c:when test="${user.userFreeze == 'no'}">
                                    <a href="/servlet/UserServlet?flag=freezeUser&userId=${user.userId}">冻结</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/servlet/UserServlet?flag=cancelFreeze&userId=${user.userId}">取消冻结</a>
                                </c:otherwise>
                            </c:choose>
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