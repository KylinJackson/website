<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>用户管理--修改用户信息</title>
</head>
<body>
<%@ include file="head.jsp" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                修改用户信息
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form class="form-horizontal" action="/servlet/UserServlet" method="post">
                <c:forEach items="${UserList}" var="user">
                <input type="hidden" name="flag" value="alterUser"/>
                <input type="hidden" name="userId" value="${user.userId}"/>
                <input type="hidden" name="id" value="${user.userId}"/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userName" value="${user.userName}" title="用户名"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="password" name="userPassword" value="${user.userPassword}"
                               title="密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <select class="form-control" title="性别" name="userSex">
                            <c:choose>
                                <c:when test="${user.userSex == '男'}">
                                    <option value="男" selected="selected">男</option>
                                    <option value="女">女</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="男">男</option>
                                    <option value="女" selected="selected">女</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userTel" value="${user.userTel}" title="电话"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userEmail" value="${user.userEmail}" title="邮箱"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">修改</button>
                    </div>
                </div>
            </form>
            </c:forEach>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>